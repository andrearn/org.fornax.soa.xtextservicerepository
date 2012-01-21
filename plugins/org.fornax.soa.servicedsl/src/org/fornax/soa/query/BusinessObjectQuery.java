package org.fornax.soa.query;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.ref.DependencyDescription;
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.basedsl.util.BaseDslEqualityHelper;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class BusinessObjectQuery {
	
	@Inject
	IQualifiedNameProvider nameProvider;
	
	@Inject
	IPredicateSearch predicateSearch;
	
	@Inject
	IEObjectDescriptionBuilder descriptionBuilder;

	/**
	 * Get all super types of the business object in upward order
	 * @param bo The business object
	 * @param vistitedBOs	already visited business objects
	 * @return
	 */
	public static List<BusinessObject> getAllSuperTypes (BusinessObject bo, List<BusinessObject> vistitedBOs) {
		if (vistitedBOs == null)
			vistitedBOs = Lists.newArrayList();
		if (bo.getSuperBusinessObject() != null && bo.getSuperBusinessObject().getType() != null) {
			vistitedBOs.add (bo.getSuperBusinessObject().getType());
			getAllSuperTypes (bo.getSuperBusinessObject().getType(), vistitedBOs);
		}
		return vistitedBOs;
	}

	/**
	 * all own and inherited properties visible on the type
	 * @param bo The BusinessObject
	 * @return all own and inherited properties visible on the type
	 */
	public static List<Property> getAllVisibleProperties (final BusinessObject bo) {
		List<Property> props = new ArrayList<Property>();
		props.addAll (bo.getProperties());
		props.addAll (getAllInheritedProperties(bo));
		return props;
	}
	
	/**
	 * Get all super types of the business object in upward order
	 * @param bo
	 * @return super types in upward order
	 */
	public static List<Property> getAllInheritedProperties (final BusinessObject bo) {
		return collectAllInheritedProperties (bo, new ArrayList<Property>());
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
			if (targetType instanceof BusinessObject) {
				BusinessObject targetBO = (BusinessObject) targetType;
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
	
	
	public List<QualifiedName> getOtherTypeNsRefsToNs (VersionedType type, SubNamespace ns) {
		SubNamespace typeNs = (SubNamespace) type.eContainer();
		QualifiedName typeNsName = nameProvider.getFullyQualifiedName (typeNs);
		QualifiedName nsName = nameProvider.getFullyQualifiedName(ns);
		List<QualifiedName> otherTypeNsRefs = new ArrayList<QualifiedName>();
		if (!nsName.equals (typeNsName)) {
			EList<Type> types = ((SubNamespace)type.eContainer()).getTypes();
			for(Type t : types) {
				if (t instanceof BusinessObject) {
					BusinessObject bo = (BusinessObject)t;
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
	
	public Map<EObject, VersionedType> getReferencedVersionedTypes (final BusinessObject bo, final boolean includeInheritedProperties) {
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

	
	
	private static List<Property> collectAllInheritedProperties (final BusinessObject bo, List<Property> props) {
		if (props == null)
			props = new ArrayList<Property> ();
		if  (bo.getSuperBusinessObject() != null && bo.getSuperBusinessObject().getType() != null) {
			List<Property> superTypeProps = bo.getSuperBusinessObject().getType().getProperties();
			props.addAll (superTypeProps);
			collectAllInheritedProperties (bo.getSuperBusinessObject().getType(), props);
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
}
