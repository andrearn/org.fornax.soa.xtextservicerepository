package org.xkonnex.repo.generator.servicedsl.templates.json

import javax.inject.Inject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef
import javax.inject.Named
import org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueries

class JSONSchemaGenerator {
	
	@Inject extension JSONTypeExtensions
	@Inject extension JSONSchemaFilenameProvider
	@Inject extension JSONSchemaReferenceProvider
	@Inject extension DataObjectQueries
	@Inject IEObjectDocumentationProvider docProvider
	@Inject IFileSystemAccess fsa
	
	@Inject @Named ("useRegistryBasedFilePaths") 
	Boolean useRegistryBasedFilePaths
	
	@Inject @Named ("useNestedPaths") 
	Boolean useNestedPaths

	def generateSchema (DataObject dataObject, String registryBaseUrl) {
		val content = dataObject.toJSONSchema(registryBaseUrl)
		fsa.generateFile(dataObject.toFileNameFragment + ".json", content)
	}
	
	def dispatch toJSONSchema(VersionedType type, String registryBaseUrl) {
		
	}
	
	def dispatch toJSONSchema(DataObject type, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(type)
		//- Address : |
		'''
		      {
		        "$schema": "http://json-schema.org/draft-04/schema",
		        "type": "«type.toBaseType»",
		        «IF doc !== null»
		          "description": "«doc»",
		        «ENDIF»
		        "properties": {
		          «type.properties.map[toProperty(registryBaseUrl)].join(",\n")»
		        },
		        «type.toRequired»
		      }
		'''
	}
	def dispatch toJSONSchema(Enumeration type, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(type)
		//- Address : |
		'''
		      {
		        "$schema": "http://json-schema.org/draft-04/schema",
		        "type": "«type.toBaseType»",
		        «IF doc !== null»
		          "description": "«doc»",
		        «ENDIF»
		        "enum": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]
		      }
		'''
	}
	
	def toProperty(Property p, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(p)
		'''
			"«p.name»" : {
			  «IF doc !== null»
			    "description": "«doc»",
			  «ENDIF»
			  «p.type.toPropertyType (p.optional, registryBaseUrl)»
			}
		'''	
	}
	
	def toRequired(DataObject obj) {
		val requiredProps = obj.properties.filter[!optional]
		'''«IF !requiredProps.empty»"required": [«requiredProps.map["\"" + name + "\""].join(", ")»]«ENDIF»'''
	}
	
	def dispatch String toPropertyType (TypeRef typeRef, boolean optional, String registryBaseUrl) {
		
	}
	def dispatch String toPropertyType (VersionedTypeRef typeRef, boolean optional, String registryBaseUrl) {
		typeRef.type.toPropertyType(registryBaseUrl)
		if (typeRef.many) {
			'''
				"type":  "array",
				"items": {
					«typeRef.type.toPropertyType(registryBaseUrl)»
				},
				"minItems": «IF optional»0«ELSE»1«ENDIF»,
				"uniqueItems": «IF typeRef.set»true«ELSE»false«ENDIF»
			'''
		} else {
			'''
				«typeRef.type.toPropertyType(registryBaseUrl)»
			'''
		}
	}
	
	def dispatch String toPropertyType (DataTypeRef typeRef, boolean optional, String registryBaseUrl) {
		if (typeRef.many) {
			'''
				"type":  "array",
				"items": {
					«typeRef.type.toPropertyType(registryBaseUrl)»
				},
				"minItems": «IF optional»0«ELSE»1«ENDIF»,
				"uniqueItems": «IF typeRef.set»true«ELSE»false«ENDIF»
			'''
		} else {
			'''«typeRef.type.toPropertyType(registryBaseUrl)»'''
		}
	}
	
	def dispatch String toPropertyType (VersionedType type, String registryBaseUrl) {
		'''"$ref": "«type.toTypeReferenceURI(registryBaseUrl)»"'''
	}
	
	def dispatch String toPropertyType (Enumeration type, String registryBaseUrl) {
		'''
		"type": "string",
		"enum": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]'''
	}
	
	def dispatch String toPropertyType (DataType type, String registryBaseUrl) {
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
	
}