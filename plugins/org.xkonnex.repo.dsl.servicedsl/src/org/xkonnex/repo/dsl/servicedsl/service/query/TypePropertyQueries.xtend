package org.xkonnex.repo.dsl.servicedsl.service.query

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject
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