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
	@Inject extension JSONSchemaReferenceProvider
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
			  «p.type.toPropertyType (p.optional)»,
			  "required": "«if(p.isOptional)"true" else "false"»"
			}
		'''	
	}
	
	def dispatch String toPropertyType (TypeRef typeRef, boolean optional) {
		
	}
	def dispatch String toPropertyType (VersionedTypeRef typeRef, boolean optional) {
		typeRef.type.toPropertyType
		if (typeRef.many) {
			'''
				"type":  "array",
				"items": {
					«typeRef.type.toPropertyType»
				},
				"minItems": «IF optional»0«ELSE»1«ENDIF»,
				"uniqueItems": «IF typeRef.set»true«ELSE»false«ENDIF»
			'''
		} else {
			'''«typeRef.type.toPropertyType»'''
		}
	}
	
	def dispatch String toPropertyType (DataTypeRef typeRef, boolean optional) {
		if (typeRef.many) {
			'''
				"type":  "array",
				"items": { "type": "«typeRef.toType»" },
				"minItems": «IF optional»0«ELSE»1«ENDIF»,
				"uniqueItems": «IF typeRef.set»true«ELSE»false«ENDIF»
			'''
		} else {
			'''"type": "«typeRef.toType»"'''
		}
	}
	
	def String toType (DataTypeRef typeRef) {
		switch (typeRef.type.name) {
			case "int": "integer"
			case "double": "number"
			case "float": "number"
			case "date": "date"
			case "date-only": "date-only"
			case "time": "time"
			case "time-only": "time-only"
			case "datetime": "dateTime"
			// file, integer
			default: typeRef.type.name
		}
	}
	def dispatch String toPropertyType (VersionedType type) {
		'''"$ref": "«type.toTypeReferenceURI»"'''
	}
	def dispatch String toPropertyType (Enumeration type) {
		'''
		"string",
		"enum": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]'''
	}
	
	def toTypeRefURI (VersionedType type) {
		
	}
	
	private def toArrayIndicator(VersionedTypeRef typeRef) {
		if(typeRef.many)'''[]'''else''''''
	}
	private def toArrayIndicator(DataTypeRef typeRef) {
		if(typeRef.many)'''[]'''else''''''
	}
	
}