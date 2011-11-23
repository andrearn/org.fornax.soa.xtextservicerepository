package org.fornax.soa.query;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

import com.google.common.collect.Lists;

public class BusinessObjectQuery {

	
	public static List<BusinessObject> getAllSuperTypes (BusinessObject bo, List<BusinessObject> bos) {
		if (bos == null)
			bos =Lists.newArrayList();
		if (bo.getSuperBusinessObject() != null && bo.getSuperBusinessObject().getType() != null) {
			bos.add (bo.getSuperBusinessObject().getType());
			getAllSuperTypes (bo.getSuperBusinessObject().getType(), bos);
		}
		return bos;
	}

	public static List<Property> getAllVisibleProperties (final BusinessObject bo) {
		List<Property> props = new ArrayList<Property>();
		props.addAll (bo.getProperties());
		props.addAll (getAllInheritedProperties(bo));
		return props;
	}
	
	public static List<Property> getAllInheritedProperties (final BusinessObject bo) {
		return collectAllInheritedProperties (bo, new ArrayList<Property>());
	}
	
	public static List<VersionedType> getTransitiveDependencies (final Property prop, final boolean includeInheritedProperties, final boolean includeCycleTypes) {
		List<VersionedType> result = Lists.newArrayList();
		TypeRef typeRef = prop.getType();
		if (typeRef instanceof VersionedTypeRef) {
			VersionedTypeRef verTypeRef = (VersionedTypeRef) typeRef;
			if (((VersionedTypeRef) typeRef).getType() instanceof BusinessObject) {
				result.add (verTypeRef.getType());
				result.addAll (getTransitiveDependencies ((BusinessObject)verTypeRef.getType(), includeInheritedProperties, includeCycleTypes));
			} else {
				result.add (verTypeRef.getType());
			}
		}
		return result;
	}

	public static List<VersionedType> getTransitiveDependencies (final BusinessObject bo, final boolean includeInheritedProperties, final boolean includeCycleTypes) {
		List<VersionedType> initialResult = getReferencedVersionedTypes(bo, includeInheritedProperties);
		return getTransitiveDependencies (initialResult, includeInheritedProperties, includeCycleTypes, initialResult);
	}
	
	public static List<VersionedType> getTransitiveDependencies (final List<VersionedType> types, final boolean includeInheritedProperties, final boolean includeCycleTypes, List<VersionedType> initialResult) {
		List<VersionedType> nestedSearchList = new ArrayList<VersionedType>();
		List<VersionedType> result = new ArrayList<VersionedType>();
		result.addAll(initialResult);
		for (VersionedType type : types) {
			if (type instanceof BusinessObject) {
				List<VersionedType> refVerTypes = getReferencedVersionedTypes ((BusinessObject)type, includeInheritedProperties);
				for (VersionedType refVerType : refVerTypes) {
					if (!result.contains (refVerType))
						nestedSearchList.add (refVerType);
					result.add (refVerType);
				}
			}
		}
		if (!nestedSearchList.isEmpty())
			result = getTransitiveDependencies(nestedSearchList, includeInheritedProperties, includeCycleTypes, initialResult);
		return result;
	}
	
	public static List<VersionedType> getReferencedVersionedTypes (final BusinessObject bo, final boolean includeInheritedProperties) {
		List<VersionedType> result = new ArrayList<VersionedType>();
		for (Property prop :  bo.getProperties()) {
			if (prop .getType() instanceof VersionedTypeRef) {
				VersionedTypeRef verTypeRef = (VersionedTypeRef) prop.getType();
				result.add (verTypeRef.getType());
			}
		}
		return result;
	}
	
	private static List<Property> collectAllInheritedProperties (final BusinessObject bo, List<Property> props) {
		if (props == null)
			props = new ArrayList<Property> ();
		if  (bo.getSuperBusinessObject() != null &&bo.getSuperBusinessObject().getType() != null) {
			List<Property> superTypeProps = bo.getSuperBusinessObject().getType().getProperties();
			props.addAll (superTypeProps);
			collectAllInheritedProperties(bo.getSuperBusinessObject().getType(), props);
		}
		return props;
	}
}
