package org.xkonnex.repo.generator.bindingdsl.rest.raml.templates

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef
import javax.inject.Inject
import org.xkonnex.repo.generator.servicedsl.templates.json.JSONTypeExtensions
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractVersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject

class RAMLTypesGenerator {
	
	@Inject extension JSONTypeExtensions
	
	def dispatch toTypeDeclaration (TypeRef typeRef) {
		
	}
	def dispatch toTypeDeclaration (DataObjectRef typeRef) {
		'''
			«typeRef.toContextualTypeNameRef»:
			  	type: «typeRef.type.toBaseType»
			  		«IF(typeRef.type instanceof DataObject)»
			  			properties:
				  			«(typeRef.type as DataObject).properties.map(p|p.toProperty)»
			  		«ENDIF»
			
		'''
	}
	def dispatch toTypeDeclaration (VersionedTypeRef typeRef) {
		'''
			«typeRef.toContextualTypeNameRef»:
			  	type: «typeRef.type.toBaseType»
			  		«IF(typeRef.type instanceof DataObject)»
			  			properties:
			  				«(typeRef.type as DataObject).properties.map(p|p.toProperty)»
				  	«ELSEIF (typeRef.type instanceof Enumeration)»
			  		«ENDIF»
			
		'''
	}
	def dispatch toTypeDeclaration (DataObject type) {
		'''
			«type.toContextualTypeNameRef»:
			  	type: «type.toBaseType»
			  		properties:
			  			«type.properties.map(p|p.toProperty).join(",\n")»
			
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
	
	def toProperty (Property p) {
		'''«p.name»«IF p.optional»?«ENDIF»: «p.type.toPropertyType»'''
	}
	
	def dispatch String toPropertyType (TypeRef typeRef) {
		
	}
	def dispatch String toPropertyType (VersionedTypeRef typeRef) {
		typeRef.toContextualTypeNameRef + typeRef.toArrayIndicator
	}
	def dispatch String toPropertyType (DataTypeRef typeRef) {
		switch (typeRef.type.name) {
			case "int": "integer" + typeRef.toArrayIndicator
			case "double": "number" + typeRef.toArrayIndicator
			case "float": "number" + typeRef.toArrayIndicator
			case "date": "date-only" + typeRef.toArrayIndicator
			case "time": "time-only" + typeRef.toArrayIndicator
			case "datetime": "datetime" + typeRef.toArrayIndicator
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
}