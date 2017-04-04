package org.xkonnex.repo.dsl.servicedsl.service.query

import java.util.List
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property

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