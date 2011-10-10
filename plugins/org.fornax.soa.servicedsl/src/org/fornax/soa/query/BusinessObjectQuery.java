package org.fornax.soa.query;

import java.util.ArrayList;
import java.util.List;

import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Property;

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
