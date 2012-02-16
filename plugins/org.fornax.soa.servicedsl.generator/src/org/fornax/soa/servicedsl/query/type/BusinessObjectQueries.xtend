package org.fornax.soa.servicedsl.query.type

import java.util.List
import org.fornax.soa.serviceDsl.Property
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.serviceDsl.BusinessObject
import java.util.ArrayList

class BusinessObjectQueries {
	
	def dispatch List<Property> findAllVisibleProperties (Object bo, LifecycleState minState) {newArrayList()}

	def dispatch List<Property> findAllVisibleProperties (BusinessObject bo, LifecycleState minState) {
		bo.collectAllVisibleProperties (minState, newArrayList());
	}
		
	def dispatch List<Property> collectAllVisibleProperties (BusinessObject bo, LifecycleState minState, List<Property> props) {
		props.addAll (bo.properties);
		props.addAll(bo.findAllInheritedProperties(minState));
		props;
	}
		
	def dispatch List<Property> findAllInheritedProperties (BusinessObject bo, LifecycleState minState) {
		bo.findAllSuperTypes (minState).map (e|e.properties).flatten.toList;
	}
		
	def dispatch List<BusinessObject> findAllSuperTypes (BusinessObject bo, LifecycleState minState) {
		bo.collectAllSuperTypes (newArrayList(), minState);
	}
	
	def private List<BusinessObject> collectAllSuperTypes (BusinessObject bo, List<BusinessObject> superTypes, LifecycleState minState) {
		if (bo.superBusinessObject != null) {
			superTypes.add ( bo.superBusinessObject.type as BusinessObject);
			superTypes;
		} else {
			superTypes;
		}
	}
}