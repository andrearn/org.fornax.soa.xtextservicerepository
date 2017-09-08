package org.xkonnex.repo.generator.profiledsl

import java.util.LinkedHashMap
import java.util.Map
import org.xkonnex.repo.dsl.profiledsl.profileDsl.DataTypeRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Property
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Enumeration
import org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType
import org.xkonnex.repo.dsl.profiledsl.profileDsl.AbstractProperty

class HeaderExtensions {

	def Map<String, Property> flattenHeader(MessageHeader header) {
		var paramMap  = new LinkedHashMap<String, Property>()
		for (param : header.parameters) {
			flatten(param, param.name, paramMap)
		}
		return paramMap
	}
	
	def dispatch void flatten (AbstractProperty prop, String contextPath, Map<String, Property>  propertyMap) {
	}
	def dispatch void flatten (Property prop, String contextPath, Map<String, Property>  propertyMap) {
		if (prop.type instanceof DataTypeRef) {
			val typeRef = prop.type as DataTypeRef
			flatten(typeRef.type, contextPath, prop, propertyMap)
		} else if (prop.type instanceof VersionedTypeRef) {
			val typeRef = prop.type as VersionedTypeRef
			flatten(typeRef.type, contextPath, prop, propertyMap)
		}
	}
	
	def dispatch void flatten (VersionedType type, String contextPath, Property parentProp, Map<String, Property>  propertyMap) {
		
	}
	def dispatch void flatten (DataType type, String contextPath, Property parentProp, Map<String, Property>  propertyMap) {
		propertyMap.put(contextPath + "." + parentProp.name, parentProp)
	}
	def dispatch void flatten (Enumeration type, String contextPath, Property parentProp, Map<String, Property>  propertyMap) {
		propertyMap.put(contextPath + "." + parentProp.name, parentProp)
	}
	def dispatch void flatten (org.xkonnex.repo.dsl.profiledsl.profileDsl.Class type, String contextPath, Property parentProp, Map<String, Property>  propertyMap) {
		for (prop : type.properties) {
			flatten(prop, contextPath + "." + parentProp.name, propertyMap)
		}
	}
}
