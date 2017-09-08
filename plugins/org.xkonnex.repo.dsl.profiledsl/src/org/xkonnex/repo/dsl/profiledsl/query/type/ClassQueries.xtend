package org.xkonnex.repo.dsl.profiledsl.query.type

import com.google.common.base.Predicate
import com.google.common.collect.Iterables
import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.ArrayDeque
import java.util.ArrayList
import java.util.Deque
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.util.IAcceptor
import org.xkonnex.repo.dsl.basedsl.baseDsl.GovernanceDecisionResult
import org.xkonnex.repo.dsl.basedsl.ref.DependencyDescription
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch
import org.xkonnex.repo.dsl.basedsl.util.BaseDslEqualityHelper
import org.xkonnex.repo.dsl.basedsl.util.TreeNode
import org.xkonnex.repo.dsl.profiledsl.profileDsl.AbstractProperty
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Class
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ProfileDslPackage
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Property
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Type
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TypeRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher

class ClassQueries {
	@Inject package IQualifiedNameProvider nameProvider
	@Inject package IPredicateSearch predicateSearch
	@Inject package IEObjectDescriptionBuilder descriptionBuilder
	@Inject package IReferenceSearch referenceSearch
	@Inject package IEObjectLookup objLookup
	@Inject package IStateMatcher stateMatcher

	/** 
	 * Get all super types of the business object in upward order
	 * @param do The business object
	 * @param vistitedBOs	already visited business objects
	 * @return
	 */
	def static List<Class> getAllSuperTypes(Class bo, List<Class> vistitedBOs) {
		var vistitedBOsVar = vistitedBOs
		if(vistitedBOsVar === null) vistitedBOsVar = newArrayList()
		if (bo.superClass?.type !== null) {
			vistitedBOsVar.add(bo.superClass.type)
			getAllSuperTypes(bo.superClass.type, vistitedBOsVar)
		}
		return vistitedBOsVar
	}

	def Class getRootClass(Class bo) {
		if (bo.getSuperClass() !== null) {
			var List<Class> allSuperTypes = getAllSuperTypes(bo, new ArrayList<Class>())
			if (!allSuperTypes.isEmpty()) {
				return allSuperTypes.get(allSuperTypes.size() - 1)
			}
		}
		return bo
	}

	/** 
	 * all own and inherited properties visible on the type
	 * @param bo The org.xkonnex.repo.dsl.profiledsl.profileDsl.Class
	 * @return all own and inherited properties visible on the type
	 */
	def static List<AbstractProperty> getAllVisibleProperties(Class bo) {
		var props = new ArrayList<AbstractProperty>()
		props.addAll(bo.getProperties())
		props.addAll(getAllInheritedProperties(bo))
		return props
	}

	/** 
	 * all inherited properties visible on the type (own properties are excluded)
	 * @param bo The Class
	 * @return all own and inherited properties visible on the type
	 */
	def static List<AbstractProperty> getAllInheritedProperties(Class bo) {
		return collectAllInheritedProperties(bo, new ArrayList<AbstractProperty>())
	}

	def Iterable<IEObjectDescription> findUnapprovedClasses(ResourceSet res) {
		val ResourceSet resSet = res
		var Iterable<IEObjectDescription> result = predicateSearch.search(
			ProfileDslPackage.Literals::CLASS.getName(), ([IEObjectDescription objDesc|
				var EObject eObjectOrProxy = objDesc.getEObjectOrProxy()
				if (eObjectOrProxy.eIsProxy() && eObjectOrProxy instanceof Class) {
					var Class bo = (EcoreUtil::resolve(eObjectOrProxy, resSet) as Class)
					if(bo.governanceDecisions.nullOrEmpty) return true else if(!bo.governanceDecisions.exists[decisionResult == GovernanceDecisionResult::ACCEPTED]
						) return true
				}
				return false
			] as Predicate<IEObjectDescription>))
		return result
	}

	/** 
	 * Find all transitive dependencies of the Property. The dependency graph is build from all properties transitively 
	 * referenced via the properties' type references if these have properties themselves, i.e. they are ProfileDSL Classes 
	 * @param prop Property from which to start the traversal of the dependency graph
	 * @param includeInheritedProperties
	 * @param includeCycleTypes include the BO in the result even if it already was visited. 
	 * However traversal of this path stops here
	 * @return {@link DependencyDescription} keyed with the {@link IEObjectDesription} of the referring property 
	 */
	def DependencyDescription getTransitiveDependencies(Property prop, boolean includeInheritedProperties,
		boolean includeCycleTypes) {
		return getTransitiveDependencies(prop, includeCycleTypes, includeCycleTypes, newLinkedList(), null)
	}
	
	/** 
	 * Find all transitive dependencies of the Property. The dependency graph is build from all properties transitively 
	 * referenced via the properties' type references if these have properties themselves, i.e. they are ProfileDSL Classes 
	 * @param prop Property from which to start the traversal of the dependency graph
	 * @param includeInheritedProperties
	 * @param includeCycleTypes include the BO in the result even if it already was visited. 
	 * However traversal of this path stops here
	 * @param visitedDependendies List of dependencies, that already have been visited
	 * @param referrer The {@link DependencyDescription} referencing this one
	 * @return {@link DependencyDescription} keyed with the {@link IEObjectDesription} of the referring property 
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
	 * is not a {@link Class}. References are being determined recursively. 
	 * @param type The type to find transitive references to
	 * @param includeSuperTypes Look for references to super types as well?
	 * @param visited	Contains all transitively found references so far. References include VersionedTypes and Operation Parameters.
	 * @param resourceSet	The {@link ResourceSet} used to materialize references, that have been found.
	 * @return
	 */
	def List<IEObjectDescription> getAllTransitiveReferrers(EObject type, boolean includeSuperTypes,
		List<IEObjectDescription> visited, ResourceSet resourceSet) {
		val List<EObject> referrers = new ArrayList<EObject>()
		if (type instanceof Class) {
			var Class dataObj = (type as Class)
			var IAcceptor<IReferenceDescription> acceptor = ([IReferenceDescription referenceDescription|
				var EObject ref = objLookup.getModelElementByURI(referenceDescription.getSourceEObjectUri(),
					type.eResource().getResourceSet())
				if (ref instanceof VersionedTypeRef && !(ref.eContainer() instanceof Property)) {
					referrers.add(objLookup.getVersionedOwner(ref))
				} else if (ref instanceof VersionedTypeRef && ref.eContainer() instanceof Property) {
					referrers.add(ref.eContainer())
				} else {
					referrers.add(ref)
				}
			] as IAcceptor<IReferenceDescription>)
			var Predicate<IReferenceDescription> refPredicate = ([IReferenceDescription input|return true] as Predicate<IReferenceDescription>)
			referenceSearch.findAllReferences(type, resourceSet, refPredicate, acceptor)
			var List<Class> allSuperTypes = getAllSuperTypes(dataObj, new ArrayList<Class>())
			for (Class superType : allSuperTypes) {
				referenceSearch.findAllReferences(superType, resourceSet, refPredicate, acceptor)
			}
			visited.addAll(
				referrers.map[descriptionBuilder.buildDescription(it)])
			for (EObject ref : referrers) {
				getAllTransitiveReferrers(ref, includeSuperTypes, visited, resourceSet)
			}
		}
		return visited
	}

	def DependencyDescription buildDependencyDescription(AbstractProperty sourceProp, VersionedType targetType,
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
			if (targetType instanceof Class) {
				var Class targetBO = (targetType as Class)
				for (p : targetBO.getProperties().filter(typeof(Property))) {
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
	def List<QualifiedName> getOtherTypeNsRefsToNs(VersionedType type, TechnicalNamespace ns) {
		var TechnicalNamespace typeNs = (type.eContainer() as TechnicalNamespace)
		var QualifiedName typeNsName = nameProvider.getFullyQualifiedName(typeNs)
		var QualifiedName nsName = nameProvider.getFullyQualifiedName(ns)
		var List<QualifiedName> otherTypeNsRefs = new ArrayList<QualifiedName>()
		if (!nsName.equals(typeNsName)) {
			var types = ((type.eContainer() as TechnicalNamespace)).types
			for (Type t : types) {
				if (t instanceof Class) {
					var Class bo = (t as Class)
					for (p : bo.getProperties().filter(typeof(Property))) {
						if (p.getType() instanceof VersionedTypeRef) {
							var TechnicalNamespace targetNs = (((p.getType() as VersionedTypeRef)).getType().
								eContainer() as TechnicalNamespace)
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

	def Map<EObject, VersionedType> getReferencedVersionedTypes(Class bo, boolean includeInheritedProperties) {
		var Map<EObject, VersionedType> result = new HashMap<EObject, VersionedType>()
		var List<AbstractProperty> props = new ArrayList<AbstractProperty>()
		if(includeInheritedProperties) 
			props = bo.getProperties() 
		else 
			props = getAllVisibleProperties(bo)
		for (prop : props.filter(typeof(Property))) {
			if (prop.getType() instanceof VersionedTypeRef) {
				var VersionedTypeRef verTypeRef = (prop.getType() as VersionedTypeRef)
				var VersionedType verType = verTypeRef.getType()
				if(verType.eIsProxy()) EcoreUtil::resolve(verType, verType.eResource())
				result.put(prop, verType)
			}
		}
		return result
	}

	def private static List<AbstractProperty> collectAllInheritedProperties(Class bo, List<AbstractProperty> properties) {
		var propsVar = properties
		if(propsVar === null) propsVar = new ArrayList<AbstractProperty>()
		if (bo.superClass?.type !== null) {
			var List<AbstractProperty> superTypeProps = bo.superClass.type.properties
			propsVar.addAll(superTypeProps)
			collectAllInheritedProperties(bo.superClass.type, propsVar)
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

	def List<TreeNode<IEObjectDescription>> getAllSubTypes(Class bo, ResourceSet resourceSet) {
		val List<TreeNode<IEObjectDescription>> subTypes = newArrayList()
		var Predicate<IReferenceDescription> predicate = ([IReferenceDescription input|
			var IEObjectDescription sourceObjContainer = objLookup.getIEOBjectDescriptionByURI(
				input.getContainerEObjectURI(), resourceSet)
			var EObject sourceObj = objLookup.getModelElementByURI(input.getSourceEObjectUri(), resourceSet)
			if(sourceObjContainer !== null && sourceObjContainer.getEObjectOrProxy() instanceof Class &&
				ProfileDslPackage.Literals::CLASS__SUPER_CLASS.getName().equals(
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
		if (parentObj instanceof Class) {
			var Class bo = (parentObj as Class)
			if(bo.eIsProxy()) bo = EcoreUtil::resolve(bo, resourceSet) as Class
			val List<TreeNode<IEObjectDescription>> subTypes = newArrayList()
			var Predicate<IReferenceDescription> predicate = ([IReferenceDescription input|
				var IEObjectDescription sourceObjContainer = objLookup.getIEOBjectDescriptionByURI(
					input.getContainerEObjectURI(), resourceSet)
				var EObject sourceObj = objLookup.getModelElementByURI(input.getSourceEObjectUri(), resourceSet)
				if(sourceObjContainer !== null && sourceObjContainer.getEObjectOrProxy() instanceof Class &&
					ProfileDslPackage.Literals::CLASS__SUPER_CLASS.getName().equals(
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

	def List<Class> collectAllSuperTypes(Class bo, List<Class> superTypes, LifecycleState minState) {
		if (bo.getSuperClass() !== null) {
			if(stateMatcher.matches(minState, bo.getSuperClass().getType().getState())) superTypes.add(
				bo.getSuperClass().getType())
			return superTypes
		} else {
			return superTypes
		}
	}
}