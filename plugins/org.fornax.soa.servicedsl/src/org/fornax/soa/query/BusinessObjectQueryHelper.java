package org.fornax.soa.query;

import java.util.ArrayList;
import java.util.List;

import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Property;

public class BusinessObjectQueryHelper {

	public static List<Property> getAllInheritedProperties (BusinessObject bo) {
		return collectAllInheritedProperties (bo, new ArrayList<Property>());
	}
	
	private static List<Property> collectAllInheritedProperties (BusinessObject bo, List<Property> props) {
		if (props == null)
			props = new ArrayList<Property> ();
		if  (bo.getSuperBusinessObject() != null) {
			List<Property> superTypeProps = bo.getSuperBusinessObject().getType().getProperties();
			props.addAll (superTypeProps);
			collectAllInheritedProperties(bo.getSuperBusinessObject().getType(), props);
		}
		return props;
	}
}
