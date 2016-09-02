package org.xkonnex.repo.generator.servicedsl.templates.json

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration

class JSONTypeExtensions {
	
	def toContextualTypeNameRef(VersionedType type) {
		type.name	
	}
	
	def dispatch String toContextualTypeNameRef(TypeRef type) {
		""	
	}
	
	def dispatch toContextualTypeNameRef(VersionedTypeRef type) {
		type.type.name	
	}
	
	def dispatch toContextualTypeNameRef(DataTypeRef type) {
		type.type.name	
	}
	
	def dispatch toBaseType(VersionedType type) {
		"object"
	}
	
	def dispatch toBaseType(DataObject type) {
		if (type.superObject == null){
			"object"
		} else if(type.superObject.type != null) {
			type.superObject.type.toContextualTypeNameRef
		} else {
			""
		}
	}
	def dispatch toBaseType(Enumeration type) {
		"string"
	}
	
}