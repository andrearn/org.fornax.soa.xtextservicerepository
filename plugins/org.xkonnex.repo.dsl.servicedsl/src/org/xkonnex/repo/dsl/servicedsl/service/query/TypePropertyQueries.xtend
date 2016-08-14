package org.xkonnex.repo.dsl.servicedsl.service.query

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject
import java.util.List
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject

class TypePropertyQueries {
	
	def List<Property> getAllBOKeys (DataObject bo) {
		bo.properties.filter(e | e.isBusinessKey || e.isProvidedKey).toList
	}
	def List<Property> getBOBusinessKeys (DataObject bo) {
		bo.properties.filter(e | e.isBusinessKey).toList
	}
	def List<Property> getBOProvidedKeys (DataObject bo) {
		bo.properties.filter(e | e.isProvidedKey).toList
	}
}