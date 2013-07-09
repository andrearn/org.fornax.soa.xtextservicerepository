package org.fornax.soa.service.query.type;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.fornax.soa.basedsl.ref.DependencyDescription;
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.basedsl.search.IReferenceSearch;
import org.fornax.soa.basedsl.util.BaseDslEqualityHelper;
import org.fornax.soa.basedsl.util.TreeNode;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.serviceDsl.ApprovalDecision;
import org.fornax.soa.serviceDsl.DataObject;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class DataObjectQueryInternal {
	
	@Inject
	IQualifiedNameProvider nameProvider;
	
	@Inject
	IPredicateSearch predicateSearch;
	
	@Inject
	IEObjectDescriptionBuilder descriptionBuilder;
	
	@Inject
	IReferenceSearch referenceSearch;
	
	@Inject
	IEObjectLookup objLookup;
	
	@Inject
	IStateMatcher stateMatcher;

	/**
	 * Get all super types of the business object in upward order
	 * @param do The business object
	 * @param vistitedBOs	already visited business objects
	 * @return
	 */
	public static List<DataObject> getAllSuperTypes (DataObject bo, List<DataObject> vistitedBOs) {
		if (vistitedBOs == null)
			vistitedBOs = Lists.newArrayList();
		if (bo.getSuperObject() != null && bo.getSuperObject().getType() != null) {
			vistitedBOs.add (bo.getSuperObject().getType());
			getAllSuperTypes (bo.getSuperObject().getType(), vistitedBOs);
		}
		return vistitedBOs;
	}
		
	public DataObject getRootDataObject (DataObject bo) {
		if (bo.getSuperObject() != null) {
			List<DataObject> allSuperTypes = getAllSuperTypes(bo, new ArrayList<DataObject>());
			if (!allSuperTypes.isEmpty()) {
				return allSuperTypes.get(allSuperTypes.size()-1);
			}
		}
		return bo;
	}
	
	/**
	 * all own and inherited properties visible on the type
	 * @param bo The DataObject
	 * @return all own and inherited properties visible on the type
	 */
	public static List<Property> getAllVisibleProperties (final DataObject bo) {
		List<Property> props = new ArrayList<Property>();
		props.addAll (bo.getProperties());
		props.addAll (getAllInheritedProperties(bo));
		return props;
	}
	
	/**
	 * all inherited properties visible on the type (own properties are excluded)
	 * @param bo The DataObject
	 * @return all own and inherited properties visible on the type
	 */
	public static List<Property> getAllInheritedProperties (final DataObject bo) {
		return collectAllInheritedProperties (bo, new ArrayList<Property>());
	}
	
	
	public Iterable<IEObjectDescription> findUnapprovedDataObjects (ResourceSet res) {
		final ResourceSet resSet = res;
		Iterable<IEObjectDescription> result = predicateSearch.search (ServiceDslPackage.Literals.BUSINESS_OBJECT.getName (), new Predicate<IEObjectDescription>() {

			public boolean apply (IEObjectDescription objDesc) {
				EObject eObjectOrProxy = objDesc.getEObjectOrProxy ();
				if (eObjectOrProxy.eIsProxy () && eObjectOrProxy instanceof Service) {
					DataObject bo = (DataObject) EcoreUtil2.resolve (eObjectOrProxy, resSet);
					if (bo.getGovernanceApproval () == null)
						return true;
					else if (bo.getGovernanceApproval ().getDecision () != ApprovalDecision.YES)
						return true;
				}
				return false;
			}
			
		});
		return result;
	}
	
	
	/**
	 * Find all transitive dependencies of the Property. The dependency graph is build from all properties transitively 
	 * referenced via the properties' type references if these have properties themselves, i.e. they are BusinessOobjects 
	 * @param prop Property from which to start the traversal of the dependency graph
	 * @param includeInheritedProperties
	 * @param includeCycleTypes include the BO in the result even if it already was visited. 
	 * 		However traversal of this path stops here
	 * @return {@link DependencyDescription} keyed with the {@link IEObjectDesription} of the referring property 
	 */
	public DependencyDescription getTransitiveDependencies (final Property prop, final boolean includeInheritedProperties, final boolean includeCycleTypes, List<IEObjectDescription> visitedDependendies, DependencyDescription referrer) {
		TypeRef typeRef = prop.getType();
		if (typeRef instanceof VersionedTypeRef) {
			VersionedTypeRef verTypeRef 	= (VersionedTypeRef) typeRef;
			VersionedType verType 			= verTypeRef.getType();
			DependencyDescription depRef 	= buildDependencyDescription (prop, verType, includeInheritedProperties, includeCycleTypes, visitedDependendies, referrer);
			return depRef;
		}
		return null;
	}
	
	/**
	 * Get all {@link EObject}s that have a transitive reference to the given {@code type}. Traversal of the reference graph stops, when the referrer
	 * is not a {@link DataObject}. References are being determined recursively. 
	 * 
	 * @param type The type to find transitive references to
	 * @param includeSuperTypes Look for references to super types as well?
	 * @param visited	Contains all trasititively found references so far.
	 * @param resourceSet	The {@link ResourceSet} used to materialize found references from.
	 * @return
	 */
	public List<IEObjectDescription> getAllTransitiveReferrers (final EObject type, final boolean includeSuperTypes, List<IEObjectDescription> visited, ResourceSet resourceSet) {
		final List<EObject> referrers = new ArrayList<EObject>();
		if (type instanceof DataObject) {
			DataObject dataObj = (DataObject) type;
			IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
				public void accept(IReferenceDescription referenceDescription) {
					EObject ref = objLookup.getModelElementByURI (referenceDescription.getSourceEObjectUri(), type.eResource().getResourceSet());
					if (ref instanceof VersionedTypeRef && !(ref.eContainer() instanceof Parameter)) {
						referrers.add (objLookup.getVersionedOwner(ref));
					} else if (ref instanceof VersionedTypeRef && ref.eContainer() instanceof Parameter) {
						referrers.add (ref.eContainer());
					} else {
						referrers.add (ref);
					}
				}
			};
			Predicate<IReferenceDescription> refPredicate = new Predicate<IReferenceDescription>() {

				public boolean apply(IReferenceDescription input) {
					return true;
				}
				
			};
			referenceSearch.findAllReferences(type, resourceSet, refPredicate, acceptor);
			List<DataObject> allSuperTypes = getAllSuperTypes(dataObj, new ArrayList<DataObject>());
			for (DataObject superType : allSuperTypes) {
				referenceSearch.findAllReferences(superType, resourceSet, refPredicate, acceptor);
			}
			visited.addAll(Lists.transform(referrers, new Function<EObject, IEObjectDescription>() {

				public IEObjectDescription apply(EObject input) {
					return descriptionBuilder.buildDescription(input);
				}
				
			}));
			for (EObject ref : referrers) {
				getAllTransitiveReferrers(ref, includeSuperTypes, visited, resourceSet);
			}
		}
		return visited;
	}
	
	public DependencyDescription buildDependencyDescription (final Property sourceProp, final VersionedType targetType, final boolean includeInheritedProperties, final boolean includeCycleTypes, List<IEObjectDescription> visitedDependendies, DependencyDescription referrer) {
		final IEObjectDescription source 		= descriptionBuilder.buildDescription (sourceProp);
		final IEObjectDescription sourceBO 		= descriptionBuilder.buildDescription (sourceProp.eContainer());
		final IEObjectDescription target 			= descriptionBuilder.buildDescription (targetType);
		final IEObjectDescription targetContainer 	= descriptionBuilder.buildDescription (targetType.eContainer());
		if (visitedDependendies == null) {
			visitedDependendies = new ArrayList<IEObjectDescription>();
		}
		if (visitedDependendies.isEmpty())
			visitedDependendies.add (sourceBO);
		Deque<DependencyDescription> dependencies = new ArrayDeque<DependencyDescription>();
		DependencyDescription dep = new DependencyDescription (source, target, targetContainer, referrer);
		boolean targetVisited = Iterables.any (visitedDependendies, new Predicate<IEObjectDescription>() {

			public boolean apply(IEObjectDescription input) {
				return BaseDslEqualityHelper.isEqual(input, target);
			}

		});
		if (!targetVisited) {
			visitedDependendies.add (target);
			if (targetType instanceof DataObject) {
				DataObject targetBO = (DataObject) targetType;
				for (Property p : targetBO.getProperties()) {
					DependencyDescription propDep = getTransitiveDependencies (p, includeInheritedProperties, includeCycleTypes, visitedDependendies, dep);
					if (propDep != null && (!propDep.isBackRef() || propDep.isBackRef() && includeCycleTypes))
						dependencies.add (propDep);
				}
			}
		} else {
			dep.setBackRef (true);
		}
		dep.setDependencies(dependencies);
		return dep;
		
	}
	
	/**
	 * Get the {@link QualifiedName}s of all Properties of all types  declared in the same {@link SubNamespace} as
	 * the given {@code type}, that refer transitively to types in the given {@link SubNamespace} {@code ns}
	 * 
	 * @param type The type who's namespace and all properties declared therein are to be examined
	 * @param ns The target namespace potentially being referenced
	 * @return The {@link QualifiedName}s of all properties that have such transitive references
	 */
	public List<QualifiedName> getOtherTypeNsRefsToNs (VersionedType type, SubNamespace ns) {
		SubNamespace typeNs = (SubNamespace) type.eContainer();
		QualifiedName typeNsName = nameProvider.getFullyQualifiedName (typeNs);
		QualifiedName nsName = nameProvider.getFullyQualifiedName(ns);
		List<QualifiedName> otherTypeNsRefs = new ArrayList<QualifiedName>();
		if (!nsName.equals (typeNsName)) {
			EList<Type> types = ((SubNamespace)type.eContainer()).getTypes();
			for(Type t : types) {
				if (t instanceof DataObject) {
					DataObject bo = (DataObject)t;
					for (Property p : bo.getProperties()) {
						if (p.getType() instanceof VersionedTypeRef) {
	
							SubNamespace targetNs = (SubNamespace) ((VersionedTypeRef)p.getType()).getType().eContainer();
							QualifiedName targetNsName = nameProvider.getFullyQualifiedName (targetNs);
							if (nsName.equals (targetNsName)) {
								otherTypeNsRefs.add (nameProvider.getFullyQualifiedName(p));
							}
						}
					}
				}
			}
		} 
		return otherTypeNsRefs;
	}
	
	public Map<EObject, VersionedType> getReferencedVersionedTypes (final DataObject bo, final boolean includeInheritedProperties) {
		Map<EObject, VersionedType> result = new HashMap<EObject, VersionedType>();
		List<Property> props = new ArrayList<Property>();
		if (includeInheritedProperties)
			props = bo.getProperties();
		else
			props = getAllVisibleProperties (bo);
		for (Property prop :  props) {
			if (prop .getType() instanceof VersionedTypeRef) {
				VersionedTypeRef verTypeRef = (VersionedTypeRef) prop.getType();
				VersionedType verType = verTypeRef.getType();
				Version v = verType.getVersion();
				if (verType.eIsProxy())
					EcoreUtil.resolve (verType, verType.eResource());
				result.put (prop, verType);
			}
		}
		return result;
	}

	
	
	private static List<Property> collectAllInheritedProperties (final DataObject bo, List<Property> props) {
		if (props == null)
			props = new ArrayList<Property> ();
		if  (bo.getSuperObject() != null && bo.getSuperObject().getType() != null) {
			List<Property> superTypeProps = bo.getSuperObject().getType().getProperties();
			props.addAll (superTypeProps);
			collectAllInheritedProperties (bo.getSuperObject().getType(), props);
		}
		return props;
	}
	
	
	public VersionedType toVersionedType (IEObjectDescription desc, Resource res) {
		VersionedType verType = null;
		EObject o = desc.getEObjectOrProxy();
		if (o.eIsProxy())
			o = EcoreUtil.resolve (o, res);
		if (o instanceof VersionedType) {
			verType = (VersionedType) o;
		}
		return verType;
	}
	
	public List<TreeNode<IEObjectDescription>> getAllSubTypes (final DataObject bo, final ResourceSet resourceSet) {
		final List<TreeNode<IEObjectDescription>> subTypes = newArrayList ();
		Predicate<IReferenceDescription> predicate = new Predicate<IReferenceDescription> () {

			public boolean apply (final IReferenceDescription input) {
				IEObjectDescription sourceObjContainer = objLookup.getIEOBjectDescriptionByURI (input.getContainerEObjectURI (), resourceSet);
				EObject sourceObj = objLookup.getModelElementByURI (input.getSourceEObjectUri (), resourceSet);
				if (sourceObjContainer != null && sourceObjContainer.getEObjectOrProxy () instanceof DataObject &&
						ServiceDslPackage.Literals.DATA_OBJECT__SUPER_OBJECT.getName ().equals (sourceObj.eContainingFeature ().getName ()))
					return true;
				else
					return false;
			}
			
		};

		IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
			public void accept(IReferenceDescription referenceDescription) {
				IEObjectDescription childBODesc = objLookup.getIEOBjectDescriptionByURI (referenceDescription.getContainerEObjectURI (), resourceSet);
				TreeNode<IEObjectDescription> childNode = new TreeNode<IEObjectDescription>(childBODesc);
				subTypes.add (childNode);
			}
		};
		referenceSearch.findAllReferences (bo, resourceSet, predicate, acceptor);
		for (TreeNode<IEObjectDescription> subType : subTypes) {
			getAllSubTypesWithParent (subType, resourceSet);
		}
		return subTypes;
	}
	
	public TreeNode<IEObjectDescription> getAllSubTypesWithParent (TreeNode<IEObjectDescription> parent, final ResourceSet resourceSet) {
		EObject parentObj = parent.getElement ().getEObjectOrProxy ();
		if (parentObj instanceof DataObject) {
			DataObject bo = (DataObject)parentObj;
			if (bo.eIsProxy ())
				bo = (DataObject) EcoreUtil.resolve (bo, resourceSet);
			final List<TreeNode<IEObjectDescription>> subTypes = newArrayList ();
			Predicate<IReferenceDescription> predicate = new Predicate<IReferenceDescription> () {
	
				public boolean apply (final IReferenceDescription input) {
					IEObjectDescription sourceObjContainer = objLookup.getIEOBjectDescriptionByURI (input.getContainerEObjectURI (), resourceSet);
					EObject sourceObj = objLookup.getModelElementByURI (input.getSourceEObjectUri (), resourceSet);
					if (sourceObjContainer != null && sourceObjContainer.getEObjectOrProxy () instanceof DataObject &&
							ServiceDslPackage.Literals.DATA_OBJECT__SUPER_OBJECT.getName ().equals (sourceObj.eContainingFeature ().getName ()))
						return true;
					else
						return false;
				}
				
			};
	
			IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
				public void accept(IReferenceDescription referenceDescription) {
					IEObjectDescription childBODesc = objLookup.getIEOBjectDescriptionByURI (referenceDescription.getContainerEObjectURI (), resourceSet);
					TreeNode<IEObjectDescription> childNode = new TreeNode<IEObjectDescription>(childBODesc);
					subTypes.add (childNode);
				}
			};
			referenceSearch.findAllReferences (bo, resourceSet, predicate, acceptor);
			parent.setChildren (subTypes);
			for (TreeNode<IEObjectDescription> subType : subTypes) {
				subType.setParent (parent);
				parent = getAllSubTypesWithParent (subType, resourceSet);
				
			}
		}
		return parent;
	}
	
	public List<DataObject> collectAllSuperTypes (DataObject bo, List<DataObject> superTypes, LifecycleState minState) {
		if (bo.getSuperObject() != null) {
			if (stateMatcher.matches(minState, bo.getSuperObject().getType().getState()))
			superTypes.add ( bo.getSuperObject().getType());
			return superTypes;
		} else {
			return superTypes;
		}
	}
}
