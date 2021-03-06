package org.xkonnex.repo.generator.bindingdsl.rest.raml.templates

import javax.inject.Inject
import org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueries
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef
import org.xkonnex.repo.generator.servicedsl.templates.json.JSONSchemaGenerator
import org.xkonnex.repo.generator.servicedsl.templates.json.JSONTypeExtensions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.AbstractProperty
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Attribute

class RAMLTypesGenerator {
	
	@Inject extension JSONTypeExtensions
	@Inject extension JSONSchemaGenerator
	@Inject extension DataObjectQueries
	
	def dispatch toTypeDeclaration (TypeRef typeRef) {
		
	}
	def dispatch toTypeDeclaration (DataObjectRef typeRef) {
		'''
			«typeRef.toContextualTypeNameRef»:
			    type: «typeRef.type.toBaseType»
			      «IF(typeRef.type instanceof DataObject)»
			        properties:
			            «(typeRef.type as DataObject).properties.map(p|p.toProperty).join("\n")»
			      «ENDIF»
		'''
	}
	def dispatch toTypeDeclaration (VersionedTypeRef typeRef) {
		'''
			«typeRef.toContextualTypeNameRef»:
			    type: «typeRef.type.toBaseType»
			    «IF(typeRef.type instanceof DataObject)»
			        properties:
			            «(typeRef.type as DataObject).properties.map(p|p.toProperty).join("\n")»
				«ELSEIF (typeRef.type instanceof Enumeration)»
			        enum: 
			            [«(typeRef.type as Enumeration).literals.map[name].join(", ")»]
			    «ENDIF»
		'''
	}
	def dispatch toTypeDeclaration (DataObject type) {
		'''
			«type.toContextualTypeNameRef»:
			    type: «type.toBaseType»
			    properties:
			        «type.properties.map(p|p.toProperty).join("\n")»
		'''
	}
	def dispatch toTypeDeclaration (Enumeration type) {
		'''
			«type.toContextualTypeNameRef»:
			    type: «type.toBaseType»
			    enum: 
			        [«type.literals.map[name].join(", ")»]
		'''
	}
	def dispatch toTypeDeclaration (VersionedType type) {
		''''''
	}



	def dispatch toJSONTypeDeclaration (TypeRef typeRef, String registryBaseUrl) {
		
	}
	def dispatch toJSONTypeDeclaration (DataObjectRef typeRef, String registryBaseUrl) {
		'''
			- «typeRef.toContextualTypeNameRef»: |
			    «typeRef.type.toJSONSchema(registryBaseUrl)»
		'''
	}
	def dispatch toJSONTypeDeclaration (VersionedTypeRef typeRef, String registryBaseUrl) {
		'''
			- «typeRef.toContextualTypeNameRef»: |
			    «typeRef.type.toJSONSchema(registryBaseUrl)»
		'''
	}
	def dispatch toJSONTypeDeclaration (DataObject type, String registryBaseUrl) {
		'''
			- «type.toContextualTypeNameRef»: |
			    «type.toJSONSchema(registryBaseUrl)»
		'''
	}
	def dispatch toJSONTypeDeclaration (Enumeration type, String registryBaseUrl) {
		'''
			- «type.toContextualTypeNameRef»: |
			    «type.toJSONSchema(registryBaseUrl)»
		'''
	}
	def toJSONTypeDeclaration (VersionedType type) {
		''''''
	}

	
	def dispatch toBaseType(VersionedType type) {
		"object"
	}
	
	def dispatch toBaseType(DataObject type) {
		if (type.superObject === null){
			"object"
		} else if(type.superObject.type !== null) {
			type.superObject.type.toContextualTypeNameRef
		} else {
			""
		}
	}
	def dispatch toBaseType(Enumeration type) {
		"string"
	}
	
	def dispatch toProperty (Property p) {
		'''«p.name»«IF p.optional»?«ENDIF»: «p.type.toPropertyType»'''
	}
	def dispatch toProperty (AbstractProperty p) {
		'''«p.name»'''
	}
	def dispatch toProperty (Attribute p) {
		'''«p.name»«IF p.optional»?«ENDIF»: «p.type.toPropertyType»'''
	}
	def dispatch toProperty (org.xkonnex.repo.dsl.profiledsl.profileDsl.Property p) {
		'''«p.name»«IF p.optional»?«ENDIF»: «p.type.toPropertyType»'''
	}
	
	def dispatch String toPropertyType (TypeRef typeRef) {
		
	}
	def dispatch String toPropertyType (VersionedTypeRef typeRef) {
		typeRef.toContextualTypeNameRef + typeRef.toArrayIndicator
	}
	def dispatch String toPropertyType (org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedTypeRef typeRef) {
		typeRef.toContextualTypeNameRef + typeRef.toArrayIndicator
	}
	def dispatch String toPropertyType (DataTypeRef typeRef) {
		switch (typeRef.type.name) {
			case "int": "integer" + typeRef.toArrayIndicator
			case "double": "number" + typeRef.toArrayIndicator
			case "float": "number" + typeRef.toArrayIndicator
			case "date": "date" + typeRef.toArrayIndicator
			case "date-only": "date-only" + typeRef.toArrayIndicator
			case "time": "time" + typeRef.toArrayIndicator
			case "time-only": "time-only" + typeRef.toArrayIndicator
			case "datetime": "dateTime" + typeRef.toArrayIndicator
			// file, integer
			default: typeRef.type.name + typeRef.toArrayIndicator
		}
	}
	def dispatch String toPropertyType (org.xkonnex.repo.dsl.profiledsl.profileDsl.DataTypeRef typeRef) {
		switch (typeRef.type.name) {
			case "int": "integer" + typeRef.toArrayIndicator
			case "double": "number" + typeRef.toArrayIndicator
			case "float": "number" + typeRef.toArrayIndicator
			case "date": "date" + typeRef.toArrayIndicator
			case "date-only": "date-only" + typeRef.toArrayIndicator
			case "time": "time" + typeRef.toArrayIndicator
			case "time-only": "time-only" + typeRef.toArrayIndicator
			case "datetime": "dateTime" + typeRef.toArrayIndicator
			// file, integer
			default: typeRef.type.name + typeRef.toArrayIndicator
		}
	}
	def dispatch String toPropertyType (VersionedType type) {
		type.name
	}
	def dispatch String toPropertyType (Enumeration type) {
		'''enum: [ «type.literals.map(e|e.name).join(", ")» ]'''
	}
	def dispatch String toPropertyType (org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType type) {
		type.name
	}
	def dispatch String toPropertyType (org.xkonnex.repo.dsl.profiledsl.profileDsl.Enumeration type) {
		'''enum: [ «type.literals.map(e|e.name).join(", ")» ]'''
	}
	
	def toTypeExample(VersionedType type) {
		
	}
	
	def toTypeExample(DataTypeRef type) {
		
	}
	
	private def toArrayIndicator(VersionedTypeRef typeRef) {
		if(typeRef.many)'''[]'''else''''''
	}
	private def toArrayIndicator(DataTypeRef typeRef) {
		if(typeRef.many)'''[]'''else''''''
	}
	private def toArrayIndicator(org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedTypeRef typeRef) {
		if(typeRef.many)'''[]'''else''''''
	}
	private def toArrayIndicator(org.xkonnex.repo.dsl.profiledsl.profileDsl.DataTypeRef typeRef) {
		if(typeRef.many)'''[]'''else''''''
	}
}