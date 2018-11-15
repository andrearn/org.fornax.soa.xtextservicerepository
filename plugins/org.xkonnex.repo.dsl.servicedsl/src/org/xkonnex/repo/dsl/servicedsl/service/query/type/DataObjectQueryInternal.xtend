package org.xkonnex.repo.dsl.servicedsl.service.query.type

import static com.google.common.collect.Lists.newArrayList
import java.util.ArrayDeque
import java.util.ArrayList
import java.util.Deque
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.util.IAcceptor
import org.xkonnex.repo.dsl.basedsl.ref.DependencyDescription
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch
import org.xkonnex.repo.dsl.basedsl.util.BaseDslEqualityHelper
import org.xkonnex.repo.dsl.basedsl.util.TreeNode
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ApprovalDecision
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef
import com.google.common.base.Function
import com.google.common.base.Predicate
import com.google.common.collect.Iterables
import com.google.common.collect.Lists
import com.google.inject.Inject
import org.xkonnex.repo.dsl.servicedsl.service.ModelExtensions

class DataObjectQueryInternal {
	@Inject package IQualifiedNameProvider nameProvider
	@Inject package IPredicateSearch predicateSearch
	@Inject package IEObjectDescriptionBuilder descriptionBuilder
	@Inject package IReferenceSearch referenceSearch
	@Inject package IEObjectLookup objLookup
	@Inject package IStateMatcher stateMatcher
	@Inject extension ModelExtensions

	/** 
	 * Get all super types of the business object in upward order
	 * @param bo The business object
	 * @param vistitedBOs	already visited business objects
	 * @return all supertypes of bo
	 */
	def static List<DataObject> getAllSuperTypes(DataObject bo, List<DataObject> vistitedBOs) {
		var vistitedBOsVar = vistitedBOs
		if(vistitedBOsVar === null) vistitedBOsVar = Lists::newArrayList()
		if (bo.getSuperObject() !== null && bo.getSuperObject().getType() !== null) {
			vistitedBOsVar.add(bo.getSuperObject().getType())
			getAllSuperTypes(bo.getSuperObject().getType(), vistitedBOsVar)
		}
		return vistitedBOsVar
	}

	def DataObject getRootDataObject(DataObject bo) {
		if (bo.getSuperObject() !== null) {
			var List<DataObject> allSuperTypes = getAllSuperTypes(bo, new ArrayList<DataObject>())
			if (!allSuperTypes.isEmpty()) {
				return allSuperTypes.get(allSuperTypes.size() - 1)
			}
		}
		return bo
	}

	/** 
	 * all own and inherited properties visible on the type
	 * @param bo The DataObject
	 * @return all own and inherited properties visible on the type
	 */
	def static List<Property> getAllVisibleProperties(DataObject bo) {
		var List<Property> props = new ArrayList<Property>()
		props.addAll(bo.getProperties())
		props.addAll(getAllInheritedProperties(bo))
		return props
	}

	/** 
	 * all inherited properties visible on the type (own properties are excluded)
	 * @param bo The DataObject
	 * @return all own and inherited properties visible on the type
	 */
	def static List<Property> getAllInheritedProperties(DataObject bo) {
		return collectAllInheritedProperties(bo, new ArrayList<Property>())
	}

	def Iterable<IEObjectDescription> findUnapprovedDataObjects(ResourceSet res) {
		val ResourceSet resSet = res
		var Iterable<IEObjectDescription> result = predicateSearch.search(
			ServiceDslPackage::Literals::BUSINESS_OBJECT.getName(), ([IEObjectDescription objDesc|
				var EObject eObjectOrProxy = objDesc.getEObjectOrProxy()
				if (eObjectOrProxy.eIsProxy() && eObjectOrProxy instanceof Service) {
					var DataObject bo = (EcoreUtil2::resolve(eObjectOrProxy, resSet) as DataObject)
					if(bo.getGovernanceApproval() === null) return true else if(bo.getGovernanceApproval().
						getDecision() !== ApprovalDecision::YES) return true
				}
				return false
			] as Predicate<IEObjectDescription>))
		return result
	}

	/** 
	 * Find all transitive dependencies of the Property. The dependency graph is build from all properties transitively 
	 * referenced via the properties' type references if these have properties themselves, i.e. they are DataObjects
	 *  
	 * @param prop Property from which to start the traversal of the dependency graph
	 * @param includeInheritedProperties whether inherited properties shall be included in the search
	 * @param includeCycleTypes include the BO in the result even if it already was visited. However traversal of this path stops here
	 * @param visitedDependendies the dependencies that have already been visited, initially empty
	 * @param referrer The DependencyDescription that refers to the DependencyDescriptions to be created
	 * @return {@link DependencyDescription} keyed with the {@link IEObjectDescription} of the referring property 
	 */
	def DependencyDescription getTransitiveDependencies(Property prop, boolean includeInheritedProperties,
		boolean includeCycleTypes, List<IEObjectDescription> visitedDependendies, DependencyDescription referrer) {
		var TypeRef typeRef = prop.getType()
		if (typeRef instanceof VersionedTypeRef) {
			var VersionedTypeRef verTypeRef = (typeRef as VersionedTypeRef)
			var VersionedType verType = verTypeRef.getType()
			var DependencyDescription depRef = buildDependencyDescription(prop, verType, includeInheritedProperties,
				includeCycleTypes, visitedDependendies, referrer)
			return depRef
		}
		return null
	}

	/** 
	 * Get all {@link EObject}s that have a transitive reference to the given {@code type}. Traversal of the reference graph stops, when the referrer
	 * is not a {@link DataObject}. References are being determined recursively. 
	 * @param type The type to find transitive references to
	 * @param includeSuperTypes Look for references to super types as well?
	 * @param visited	Contains all transitively found references so far. References include VersionedTypes and Operation Parameters.
	 * @param resourceSet	The {@link ResourceSet} used to materialize found references from.
	 * @return all objects with transitive references to  {@code type}
	 */
	def List<IEObjectDescription> getAllTransitiveReferrers(EObject type, boolean includeSuperTypes,
		List<IEObjectDescription> visited, ResourceSet resourceSet) {
		val List<EObject> referrers = new ArrayList<EObject>()
		if (type instanceof DataObject) {
			var DataObject dataObj = (type as DataObject)
			var IAcceptor<IReferenceDescription> acceptor = ([IReferenceDescription referenceDescription|
				var EObject ref = objLookup.getModelElementByURI(referenceDescription.getSourceEObjectUri(),
					type.eResource().getResourceSet())
				if (ref instanceof VersionedTypeRef && !(ref.eContainer() instanceof Parameter)) {
					referrers.add(objLookup.getVersionedOwner(ref))
				} else if (ref instanceof VersionedTypeRef && ref.eContainer() instanceof Parameter) {
					referrers.add(ref.eContainer())
				} else {
					referrers.add(ref)
				}
			] as IAcceptor<IReferenceDescription>)
			var Predicate<IReferenceDescription> refPredicate = ([IReferenceDescription input|return true] as Predicate<IReferenceDescription>)
			referenceSearch.findAllReferences(type, resourceSet, refPredicate, acceptor)
			var List<DataObject> allSuperTypes = getAllSuperTypes(dataObj, new ArrayList<DataObject>())
			for (DataObject superType : allSuperTypes) {
				referenceSearch.findAllReferences(superType, resourceSet, refPredicate, acceptor)
			}
			visited.addAll(
				Lists::transform(referrers,
					([EObject input|return descriptionBuilder.buildDescription(input)] as Function<EObject, IEObjectDescription>)))
			for (EObject ref : referrers) {
				getAllTransitiveReferrers(ref, includeSuperTypes, visited, resourceSet)
			}
		}
		return visited
	}

	def DependencyDescription buildDependencyDescription(Property sourceProp, VersionedType targetType,
		boolean includeInheritedProperties, boolean includeCycleTypes,
		List<IEObjectDescription> visitedDependendies, DependencyDescription referrer) {
		var visitedDependendiesVar = visitedDependendies
		val IEObjectDescription source = descriptionBuilder.buildDescription(sourceProp)
		val IEObjectDescription sourceBO = descriptionBuilder.buildDescription(sourceProp.eContainer())
		val IEObjectDescription target = descriptionBuilder.buildDescription(targetType)
		val IEObjectDescription targetContainer = descriptionBuilder.buildDescription(targetType.eContainer())
		if (visitedDependendiesVar === null) {
			visitedDependendiesVar = new ArrayList<IEObjectDescription>()
		}
		if(visitedDependendiesVar.isEmpty()) visitedDependendiesVar.add(sourceBO)
		var Deque<DependencyDescription> dependencies = new ArrayDeque<DependencyDescription>()
		var DependencyDescription dep = new DependencyDescription(source, target, targetContainer, referrer)
		var boolean targetVisited = Iterables::any(visitedDependendiesVar, ([IEObjectDescription input|
			return BaseDslEqualityHelper::isEqual(input, target)
		] as Predicate<IEObjectDescription>))
		if (!targetVisited) {
			visitedDependendiesVar.add(target)
			if (targetType instanceof DataObject) {
				var DataObject targetBO = (targetType as DataObject)
				for (Property p : targetBO.getProperties()) {
					var DependencyDescription propDep = getTransitiveDependencies(p, includeInheritedProperties,
						includeCycleTypes, visitedDependendiesVar, dep)
					if(propDep !== null &&
						(!propDep.isBackRef() || propDep.isBackRef() && includeCycleTypes)) dependencies.add(propDep)
				}
			}
		} else {
			dep.setBackRef(true)
		}
		dep.setDependencies(dependencies)
		return dep
	}

	/** 
	 * Get the {@link QualifiedName}s of all Properties of all types  declared in the same {@link SubNamespace} as
	 * the given {@code type}, that refer transitively to types in the given {@link SubNamespace} {@code ns}
	 * @param type The type who's namespace and all properties declared therein are to be examined
	 * @param ns The target namespace potentially being referenced
	 * @return The {@link QualifiedName}s of all properties that have such transitive references
	 */
	def List<QualifiedName> getOtherTypeNsRefsToNs(VersionedType type, SubNamespace ns) {
		var SubNamespace typeNs = (type.eContainer() as SubNamespace)
		var QualifiedName typeNsName = nameProvider.getFullyQualifiedName(typeNs)
		var QualifiedName nsName = nameProvider.getFullyQualifiedName(ns)
		var List<QualifiedName> otherTypeNsRefs = new ArrayList<QualifiedName>()
		if (!nsName.equals(typeNsName)) {
			var types = ((type.eContainer() as SubNamespace)).types
			for (Type t : types) {
				if (t instanceof DataObject) {
					var DataObject bo = (t as DataObject)
					for (Property p : bo.getProperties()) {
						if (p.getType() instanceof VersionedTypeRef) {
							var SubNamespace targetNs = (((p.getType() as VersionedTypeRef)).getType().
								eContainer() as SubNamespace)
							var QualifiedName targetNsName = nameProvider.getFullyQualifiedName(targetNs)
							if (nsName.equals(targetNsName)) {
								otherTypeNsRefs.add(nameProvider.getFullyQualifiedName(p))
							}
						}
					}
				}
			}
		}
		return otherTypeNsRefs
	}

	def Map<EObject, VersionedType> getReferencedVersionedTypes(DataObject bo, boolean includeInheritedProperties) {
		var Map<EObject, VersionedType> result = new HashMap<EObject, VersionedType>()
		var List<Property> props = new ArrayList<Property>()
		if(includeInheritedProperties) props = bo.getProperties() else props = getAllVisibleProperties(bo)
		for (Property prop : props) {
			if (prop.getType() instanceof VersionedTypeRef) {
				var VersionedTypeRef verTypeRef = (prop.getType() as VersionedTypeRef)
				var VersionedType verType = verTypeRef.getType()
				if(verType.eIsProxy()) EcoreUtil::resolve(verType, verType.eResource())
				result.put(prop, verType)
			}
		}
		return result
	}

	def private static List<Property> collectAllInheritedProperties(DataObject bo, List<Property> properties) {
		var propsVar = properties
		if(propsVar === null) propsVar = new ArrayList<Property>()
		if (bo.getSuperObject() !== null && bo.getSuperObject().getType() !== null) {
			var List<Property> superTypeProps = bo.getSuperObject().getType().getProperties()
			propsVar.addAll(superTypeProps)
			collectAllInheritedProperties(bo.getSuperObject().getType(), propsVar)
		}
		return propsVar
	}

	def VersionedType toVersionedType(IEObjectDescription desc, Resource res) {
		var VersionedType verType = null
		var EObject o = desc.getEObjectOrProxy()
		if(o.eIsProxy()) o = EcoreUtil::resolve(o, res)
		if (o instanceof VersionedType) {
			verType = o as VersionedType
		}
		return verType
	}

	def List<TreeNode<IEObjectDescription>> getAllSubTypes(DataObject bo, ResourceSet resourceSet) {
		val List<TreeNode<IEObjectDescription>> subTypes = newArrayList()
		var Predicate<IReferenceDescription> predicate = ([IReferenceDescription input|
			var IEObjectDescription sourceObjContainer = objLookup.getIEOBjectDescriptionByURI(
				input.getContainerEObjectURI(), resourceSet)
			var EObject sourceObj = objLookup.getModelElementByURI(input.getSourceEObjectUri(), resourceSet)
			if(sourceObjContainer !== null && sourceObjContainer.getEObjectOrProxy() instanceof DataObject &&
				ServiceDslPackage::Literals::DATA_OBJECT__SUPER_OBJECT.getName().equals(
					sourceObj.eContainingFeature().getName())) return true else return false
		] as Predicate<IReferenceDescription>)
		var IAcceptor<IReferenceDescription> acceptor = ([IReferenceDescription referenceDescription|
			var IEObjectDescription childBODesc = objLookup.getIEOBjectDescriptionByURI(
				referenceDescription.getContainerEObjectURI(), resourceSet)
			var TreeNode<IEObjectDescription> childNode = new TreeNode<IEObjectDescription>(childBODesc)
			subTypes.add(childNode)
		] as IAcceptor<IReferenceDescription>)
		referenceSearch.findAllReferences(bo, resourceSet, predicate, acceptor)
		for (TreeNode<IEObjectDescription> subType : subTypes) {
			getAllSubTypesWithParent(subType, resourceSet)
		}
		return subTypes
	}

	def TreeNode<IEObjectDescription> getAllSubTypesWithParent(TreeNode<IEObjectDescription> parent,
		ResourceSet resourceSet) {
		var parentVar = parent
		var EObject parentObj = parentVar.getElement().getEObjectOrProxy()
		if (parentObj instanceof DataObject) {
			var DataObject bo = (parentObj as DataObject)
			if(bo.eIsProxy()) bo = EcoreUtil::resolve(bo, resourceSet) as DataObject
			val List<TreeNode<IEObjectDescription>> subTypes = newArrayList()
			var Predicate<IReferenceDescription> predicate = ([IReferenceDescription input|
				var IEObjectDescription sourceObjContainer = objLookup.getIEOBjectDescriptionByURI(
					input.getContainerEObjectURI(), resourceSet)
				var EObject sourceObj = objLookup.getModelElementByURI(input.getSourceEObjectUri(), resourceSet)
				if(sourceObjContainer !== null && sourceObjContainer.getEObjectOrProxy() instanceof DataObject &&
					ServiceDslPackage::Literals::DATA_OBJECT__SUPER_OBJECT.getName().equals(
						sourceObj.eContainingFeature().getName())) return true else return false
			] as Predicate<IReferenceDescription>)
			var IAcceptor<IReferenceDescription> acceptor = ([IReferenceDescription referenceDescription|
				var IEObjectDescription childBODesc = objLookup.getIEOBjectDescriptionByURI(
					referenceDescription.getContainerEObjectURI(), resourceSet)
				var TreeNode<IEObjectDescription> childNode = new TreeNode<IEObjectDescription>(childBODesc)
				subTypes.add(childNode)
			] as IAcceptor<IReferenceDescription>)
			referenceSearch.findAllReferences(bo, resourceSet, predicate, acceptor)
			parentVar.setChildren(subTypes)
			for (TreeNode<IEObjectDescription> subType : subTypes) {
				subType.setParent(parentVar)
				parentVar = getAllSubTypesWithParent(subType, resourceSet)
			}
		}
		return parentVar
	}

	def List<DataObject> collectAllSuperTypes(DataObject bo, List<DataObject> superTypes, LifecycleState minState) {
		if (bo.getSuperObject() !== null) {
			if(stateMatcher.matches(minState, bo.getSuperObject().getType().getState())) superTypes.add(
				bo.getSuperObject().getType())
			return superTypes
		} else {
			return superTypes
		}
	}

	def List<DataObject> collectAllSuperTypes(DataObject bo, List<DataObject> superTypes) {
		if (bo.getSuperObject() !== null) {
			superTypes.add(
				bo.getSuperObject().getType())
			return superTypes
		} else {
			return superTypes
		}
	}
}
