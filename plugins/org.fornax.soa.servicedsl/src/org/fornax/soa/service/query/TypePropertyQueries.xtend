package org.fornax.soa.service.query

import org.fornax.soa.serviceDsl.Property
import org.fornax.soa.serviceDsl.BusinessObject
import java.util.List

class TypePropertyQueries {
	
	def List<Property> getAllBOKeys (BusinessObject bo) {
		bo.properties.filter(e | e.isBusinessKey || e.isProvidedKey).toList
	}
	def List<Property> getBOBusinessKeys (BusinessObject bo) {
		bo.properties.filter(e | e.isBusinessKey).toList
	}
	def List<Property> getBOProvidedKeys (BusinessObject bo) {
		bo.properties.filter(e | e.isProvidedKey).toList
	}
}