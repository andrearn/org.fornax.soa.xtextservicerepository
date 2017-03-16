package org.xkonnex.repo.generator.servicedsl.avro

import java.util.List
import java.util.logging.Logger
import java.util.regex.Pattern
import javax.inject.Inject
import javax.inject.Named
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries
import org.xkonnex.repo.dsl.profiledsl.query.ProfileQueries
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef
import org.xkonnex.repo.generator.servicedsl.VersionedTypeDescriptor
import org.xkonnex.repo.generator.servicedsl.templates.java.JavaTypeExtensions
import org.xkonnex.repo.generator.servicedsl.templates.json.JSONTypeExtensions
import org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueries

class AvroSchemaGenerator implements IGenerator2 {

	@Inject IQualifiedNameProvider nameProvider
	@Inject IEObjectLookup eObjectLookup
	
	@Inject Logger logger

	@Inject extension JSONTypeExtensions
	@Inject extension AvroSchemaFilenameProvider
	@Inject extension JavaTypeExtensions
	@Inject extension NamespaceQuery
	@Inject extension DataObjectQueries
	@Inject IEObjectDocumentationProvider docProvider
	@Inject IFileSystemAccess fsa
	@Inject
	IStateMatcher stateMatcher
	@Inject
	LifecycleQueries lifecycleQueries
	@Inject
	ProfileQueries profileQueries
	
	@Inject @Named ("profileName")
	String profileName
	
	@Inject @Named ("registryUrl")
	String registryUrl
	
	@Inject @Named ("useRegistryBasedFilePaths") 
	Boolean useRegistryBasedFilePaths
	
	@Inject @Named ("useNestedPaths") 
	Boolean useNestedPaths
	
	@Inject @Named ("versionedTypes")
	List<VersionedTypeDescriptor> versionedTypeDescriptors
	
	@Inject @Named (AvroSchemaGeneratorSetup.NAME_SPACES)
	List<String> namespaces
	
	@Inject @Named (AvroSchemaGeneratorSetup.DOMAIN_NAME_SPACES)
	List<String> domainNamespaces

	@Inject @Named (AvroSchemaGeneratorSetup.INTERNAL_NAME_SPACES)
	List<String> internalNamespaces

	@Inject
	ResourceSetBasedResourceDescriptions resourceDescriptions

	
	override afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
	}
	
	override beforeGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
	}
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var resourceSet = resource.resourceSet;
		resourceDescriptions.setContext (resourceSet);
		
		val Profile profile = profileQueries.getProfileByName(profileName, resourceSet)
		if (profile !== null) {
			logger.info ("Enforcing generation with profile " + profile.name)
		}
		generateForSubNamespaces(resource)
	}

	private def generateForSubNamespaces(Resource resource) {
		val subNamespaces = resource.allContents.toIterable.filter(SubNamespace)
		for (ns : subNamespaces) {
			if (namespaces.exists (nsName | Pattern::matches (nsName, nameProvider.getFullyQualifiedName (ns).toString))) {
				compile (ns as SubNamespace, resource); 
			}
			if (ns instanceof DomainNamespace && domainNamespaces.exists (nsName | Pattern::matches (nsName, nameProvider.getFullyQualifiedName (ns).toString))) {
				compile (ns as SubNamespace, resource); 
			}
			if (ns instanceof InternalNamespace && internalNamespaces.exists (nsName | Pattern::matches (nsName, nameProvider.getFullyQualifiedName (ns).toString))) {
				compile (ns as SubNamespace, resource); 
			}
		}
	}
	
	protected def compile (SubNamespace namespace, Resource resource) {
		val Profile profile = namespace.getApplicableProfile(profileQueries.getProfileByName(profileName, resource.resourceSet))
		if (profile === null)
			logger.severe ("No applicable architecture profile found")
		
		if (profile !== null) {
			logger.info ("Generating Avro schemas for namespace " + nameProvider.getFullyQualifiedName(namespace).toString)
			generateSchemas (namespace, null);
		}
	}
	
	def generateSchemas (SubNamespace subNamespace, String registryBaseUrl) {
		subNamespace.types.filter(typeof(DataObject)).forEach[o | o.generateSchema(registryBaseUrl)]	
	}

	def generateSchema (DataObject dataObject, String registryBaseUrl) {
		val content = dataObject.toRecord(registryBaseUrl)
		fsa.generateFile(dataObject.toFileNameFragment + ".avsc", content)
	}
	
	def dispatch toRecord(VersionedType type, String registryBaseUrl) {
		
	}
	
	def dispatch toRecord(DataObject type, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(type)
		'''
		      {
		        "name": "«type.name»",
		        "namespace": "«type.toPackageName»",
		        "type": "record",
		        «IF doc !== null»
		          "doc": "«doc»",
		        «ENDIF»
		        "fields": [
		          «type.getAllVisibleProperties.map[toProperty(registryBaseUrl)].join(",\n")»
		        ]
		      }
		'''
	}
	def dispatch toRecord(Enumeration type, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(type)
		'''
		      {
		        "type": "enum",
		        "name":	"«type.name»",
		        «IF doc !== null»
		          "doc": "«doc»",
		        «ENDIF»
		        "symbols": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]
		      }
		'''
	}
	
	def dispatch toInnerRecord(DataObject type, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(type)
		'''
		      {
		        "name": «type.name»,
		        "namespace": «type.toPackageName»,
		        "type": "record",
		        «IF doc !== null»
		          "doc": "«doc»",
		        «ENDIF»
		        "fields": [
		          «type.getAllVisibleProperties.map[toProperty(registryBaseUrl)].join(",\n")»
		        ]
		      }
		'''
	}
	
	def dispatch toInnerRecord(DataObject type, boolean optional, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(type)
		'''
			«IF optional»
				[
				  {
				    "name": "«type.name»",
				    "namespace": "«type.toPackageName»",
				    "type": "record",
				    «IF doc !== null»
				      "doc": "«doc»",
				    «ENDIF»
				    "fields": [
				      «type.getAllVisibleProperties.map[toProperty(optional, registryBaseUrl)].join(",\n")»
				    ]
				  }, 
				  "null"
				], "default": null
		    «ELSE»
				{
				  "name": "«type.name»",
				  "namespace": "«type.toPackageName»",
				  "type": "record",
				  «IF doc !== null»
				    "doc": "«doc»",
				  «ENDIF»
				  "fields": [
				    «type.getAllVisibleProperties.map[toProperty(optional, registryBaseUrl)].join(",\n")»
				  ]
				}
		    «ENDIF»
		'''
	}

	def dispatch toInnerRecord(Enumeration type, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(type)
		'''
			{
			  "type": "enum",
			  "name": "«type.name»",
			  "namespace": "«type.toPackageName»",
			  «IF doc !== null»
			    "doc": "«doc»",
			  «ENDIF»
			  "symbols": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]
			}
		'''
	}
	
	def dispatch toInnerRecord(Enumeration type, boolean optional, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(type)
		'''
			«IF optional»
				[
				  {
				    "type": "enum",
				    "name": "«type.name»",
				    "namespace": "«type.toPackageName»",
				    «IF doc !== null»
				      "doc": "«doc»",
				    «ENDIF»
				    "symbols": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]
				  },
				  "null"
				], "default": null
		    «ELSE»
				{
				  "type": "enum",
				  "name": "«type.name»",
				  "namespace": "«type.toPackageName»",
				  «IF doc !== null»
				    "doc": "«doc»",
				  «ENDIF»
				  "symbols": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]
				}
		    «ENDIF»
		'''
	}
	
	def toProperty(Property p, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(p)
		'''
			{
			  "name": "«p.name»",
			  «IF doc !== null»
			    "doc": "«doc»",
			  «ENDIF»
			  «p.type.toPropertyType (p.optional, registryBaseUrl)»
			}'''	
	}
	
	def toProperty(Property p, boolean optional, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(p)
		'''
			{
			  "name": "«p.name»",
			  «IF doc !== null»
			    "doc": "«doc»",
			  «ENDIF»
			  «p.type.toPropertyType (p.optional, registryBaseUrl)»
			}'''	
	}
		
	def dispatch String toPropertyType (TypeRef typeRef, boolean optional, String registryBaseUrl) {
		
	}
	def dispatch String toPropertyType (VersionedTypeRef typeRef, boolean optional, String registryBaseUrl) {
		if (typeRef.many) {
			'''
				«IF optional»
					"type":  ["array","null"], "default": null,
				«ELSE»
					"type":  "array",
				«ENDIF»
				"items": {
					«typeRef.type.toPropertyType(registryBaseUrl)»
				},
			'''
		} else {
			'''
				«typeRef.type.toPropertyType(optional, registryBaseUrl)»
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
			'''
		} else {
			'''«typeRef.type.toPropertyType(optional, registryBaseUrl)»'''
		}
	}
	
	def dispatch String toPropertyType (VersionedType type, String registryBaseUrl) {
		'''"type": «type.toInnerRecord(registryBaseUrl)»'''
	}
	def dispatch String toPropertyType (VersionedType type, boolean optional, String registryBaseUrl) {
		'''"type": «type.toInnerRecord(optional, registryBaseUrl)»'''
	}
	
	def dispatch String toPropertyType (Enumeration type, String registryBaseUrl) {
		'''
			"type": {
			  "type": "enum",
			  "name": "«type.name»",
			  "namespace": "«type.toPackageName»",
			  "symbols": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]
			}
		'''
		
	}
	
	def dispatch String toPropertyType (Enumeration type, boolean optional, String registryBaseUrl) {
		'''
			«IF optional»
				"type": [{
				    "type": "enum",
				    "name": "«type.name»",
				    "namespace": "«type.toPackageName»",
				    "symbols": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]
				  }, 
				  "null"
				], "default": null
			«ELSE»
				"type": {
				  "type": "enum",
				  "name": "«type.name»",
				  "namespace": "«type.toPackageName»",
				  "symbols": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]
				}
			«ENDIF»
		'''
	}
	
	def dispatch String toPropertyType (DataType type, String registryBaseUrl) {
		switch (type.name) {
			case "date":  		'''
									"type" : "string",
									"logicalType" : "date"
								'''
			case "date-only": 	'''
									"type" : "string",
									"logicalType" : "date"
								'''
			case "time":  		'''
									"type" : "string",
									"logicalType" : "time-millis"
								'''
			case "time-only":  	'''
									"type" : "string",
									"logicalType" : "time-millis"
								'''
			case "datetime": 	'''
									"type" : "string",
									"logicalType" : "timestamp-millis"
								'''
			case "decimal":		'''
									"type" : "bytes",
									"logicalType" : "decimal"
								'''
			// file, integer
			default: 			'''
									"type" : "«type.name»"'''
		}
	}
	def dispatch String toPropertyType (DataType type, boolean optional, String registryBaseUrl) {
		switch (type.name) {
			case "date":  		'''
									"type" : «IF optional»["int", "null"], "default": null,«ELSE»"int",«ENDIF»
									"logicalType" : "date"
								'''
			case "date-only": 	'''
									"type" : «IF optional»["int", "null"], "default": null,«ELSE»"int",«ENDIF»
									"logicalType" : "date"
								'''
			case "time":  		'''
									"type" : «IF optional»["int", "null"], "default": null,«ELSE»"int",«ENDIF»
									"logicalType" : "time-millis"
								'''
			case "time-only":  	'''
									"type" : «IF optional»["int", "null"], "default": null,«ELSE»"int",«ENDIF»
									"logicalType" : "time-millis"
								'''
			case "datetime": 	'''
									"type" : «IF optional»["long", "null"], "default": null,«ELSE»"long",«ENDIF»
									"logicalType" : "timestamp-millis"
								'''
			case "decimal":		'''
									"type" : «IF optional»["bytes", "null"], "default": null,«ELSE»"bytes",«ENDIF»,
									"logicalType" : "decimal"
								'''
			// int, long, double ...
			default: 			'''
									"type" : «IF optional»["«type.name»", "null"]«ELSE»"«type.name»"«ENDIF»'''
		}
	}
	
	def toTypeRefURI (VersionedType type) {
		
	}
	
}