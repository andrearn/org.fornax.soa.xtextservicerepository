package org.xkonnex.repo.generator.servicedsl.templates.json

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import javax.inject.Inject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess

class JSONSchemaGenerator {
	
	@Inject extension JSONTypeExtensions
	@Inject extension JSONSchemaFilenameProvider
	@Inject IEObjectDocumentationProvider docProvider
	@Inject IFileSystemAccess fsa
	
	def generateSchema (DataObject dataObject) {
		val content = dataObject.toJSONSchema
		fsa.generateFile(dataObject.toFileNameFragment + ".json", content)
	}
	
	def dispatch toJSONSchema(VersionedType type) {
		
	}
	
	def dispatch toJSONSchema(DataObject type) {
		val doc = docProvider.getDocumentation(type)
		//- Address : |
		'''
		      {
		        "$schema": "http://json-schema.org/draft-04/schema",
		        "type": "«type.toBaseType»",
		        «IF doc != null»
		          "description": "«doc»",
		        «ENDIF»
		        "properties": {
		          «type.properties.map[toProperty].join(",\n")»
		        }
		      }
		'''
	}
	def dispatch toJSONSchema(Enumeration type) {
		val doc = docProvider.getDocumentation(type)
		//- Address : |
		'''
		      {
		        "$schema": "http://json-schema.org/draft-04/schema",
		        "type": "«type.toBaseType»",
		        «IF doc != null»
		          "description": "«doc»",
		        «ENDIF»
		        "enum": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]
		      }
		'''
	}
	
	def toProperty(org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property p) {
		val doc = docProvider.getDocumentation(p)
		'''
		"«p.name»" : {
		«IF doc != null»
		  "description": "«doc»",
		«ENDIF»
		  "type": "«p.type.toPropertyType»", 
		  "required": "«if(p.isOptional)"true" else "false"»"
		}
		'''	
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
		'''
		"string",
		"enum": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]'''
	}
	
	private def toArrayIndicator(VersionedTypeRef typeRef) {
		if(typeRef.many)'''[]'''else''''''
	}
	private def toArrayIndicator(DataTypeRef typeRef) {
		if(typeRef.many)'''[]'''else''''''
	}
	
}