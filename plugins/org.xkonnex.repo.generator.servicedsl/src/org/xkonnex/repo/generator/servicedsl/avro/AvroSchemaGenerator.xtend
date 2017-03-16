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
	def dispatch toRecord(Enumeration type, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(type)
		'''
		      {
		        "type": "enum",
		        "name":	«type.name»",
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
		        ],
		        «type.toRequired»
		      }
		'''
	}
	def dispatch toInnerRecord(Enumeration type, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(type)
		'''
		    "type": "enum",
		    "name":	«type.name»",
		    «IF doc !== null»
		      "doc": "«doc»",
		    «ENDIF»
		    "symbols": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]
		'''
	}
	def toProperty(Property p, String registryBaseUrl) {
		val doc = docProvider.getDocumentation(p)
		'''
			{
			  "name": "«p.name»" : {
			  «IF doc !== null»
			    "doc": "«doc»",
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
			'''
		} else {
			'''«typeRef.type.toPropertyType(registryBaseUrl)»'''
		}
	}
	
	def dispatch String toPropertyType (VersionedType type, String registryBaseUrl) {
		'''«type.toInnerRecord(registryBaseUrl)»'''
	}
	
	def dispatch String toPropertyType (Enumeration type, String registryBaseUrl) {
		'''
		"type": "enum",
		"symbols": [ «type.literals.map(e|"\"" + e.name + "\"").join(", ")» ]'''
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