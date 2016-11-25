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
import org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType

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
		        },
		        «type.toRequired»
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
			  «p.type.toPropertyType (p.optional)»
			}
		'''	
	}
	
	def toRequired(DataObject obj) {
		val requiredProps = obj.properties.filter[!optional]
		'''«IF !requiredProps.empty»"required": [«requiredProps.map["\"" + name + "\""].join(", ")»]«ENDIF»'''
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
			'''
				«typeRef.type.toPropertyType»
			'''
		}
	}
	
	def dispatch String toPropertyType (DataTypeRef typeRef, boolean optional) {
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
		"type": "string",
		"enum": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]'''
	}
	
	def dispatch String toPropertyType (DataType type) {
		switch (type.name) {
			case "int": 		'''
									"type" : "integer"
								'''
			case "double": 		'''
									"type" : "number"
								'''
			case "float": 		'''
									"type" : "number"
								'''
			case "date":  		'''
									"type" : "string",
									"format" : "date"
								'''
			case "date-only": 	'''
									"type" : "string",
									"format" : "date"
								'''
			case "time":  		'''
									"type" : "string",
									"format" : "time"
								'''
			case "time-only":  	'''
									"type" : "string",
									"format" : "time"
								'''
			case "datetime": 	'''
									"type" : "string",
									"format" : "date-time"
								'''
			// file, integer
			default: '''
									"type" : "«type.name»"'''
		}
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