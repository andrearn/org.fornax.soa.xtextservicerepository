package org.xkonnex.repo.generator.bindingdsl.rest.raml.templates

import java.util.logging.Logger
import javax.inject.Inject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.model.IEffectiveBindingBuilder
import org.xkonnex.repo.dsl.moduledsl.model.IEffectiveProvidingEndpointBuilder
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.bindingdsl.rest.RESTEndpointAddressResolver
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.generator.bindingdsl.templates.DefaultServiceContractFilenameProvider
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.webservice.ServiceTemplateExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.OperationWrapperTypesGenerator
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaTypeExtensions
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.model.EffectiveBinding
import java.util.Set
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.REST
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.bindingdsl.model.protocol.EffectiveExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.binding.query.operation.OperationBindingQueries
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.HttpVerb
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Verb

class RAMLContractGenerator {
	
	@Inject extension SchemaTypeExtensions schemaTypeExt
	@Inject extension ServiceTemplateExtensions
	@Inject extension ServiceNamespaceURIProvider
	@Inject extension HeaderFinder
	@Inject extension NamespaceQuery
	@Inject extension NamespaceImportQueries
	@Inject VersionQualifierExtensions versionQualifier
	@Inject extension RESTEndpointAddressResolver
	@Inject extension IComponentInferrer
	@Inject extension BindingExtensions
	@Inject extension IQualifiedNameProvider

	@Inject extension SchemaNamespaceExtensions schemaNamespaceExt
	@Inject ProfileSchemaNamespaceExtensions profileSchemaNamespaceExt
	@Inject IEObjectDocumentationProvider docProvider
	@Inject ProfileNamespaceURIProvider profileNamespaceURIProvider
	@Inject EnvironmentBindingResolver environmentResolver
	@Inject IEffectiveBindingBuilder bindingBuilder
	@Inject IEffectiveProvidingEndpointBuilder endpointBuilder
	@Inject extension DefaultServiceContractFilenameProvider
	@Inject OperationWrapperTypesGenerator wrapperTypesGenerator
	@Inject OperationBindingQueries operationBindingQueries

	@Inject IFileSystemAccess fsa
	@Inject Logger log
	
	def toRAML (AnyBinding binding, Service svc, LifecycleState minState, Profile profile) {
		
	}
	
	def dispatch void toRAML (ModuleBinding binding, Service svc, LifecycleState minState, Profile profile) {
		svc.toRAML (minState, binding, profile);
	}

	def dispatch void toWADL (EffectiveBinding binding, Service svc, LifecycleState minState, Profile profile) {
		svc.toRAML (minState, binding.moduleBinding, profile);
	}
	
	def toRAML(Service service, LifecycleState minState, ModuleBinding binding, Profile profile) {
		log.info('''Generating WADL for Service «service.fullyQualifiedName»'''.toString)
		val Set<VersionedTechnicalNamespace> headerImports = service.collectTechnicalVersionedNamespaceImports (profile)
		val effBind = bindingBuilder.createEffectiveBinding(service, binding)
		val prot = effBind.protocol.filter(typeof(ExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
		val ramlFile = service.getServiceContractFileNameFragment(effBind.moduleBinding, typeof(REST)) + ".raml";
		val environment = environmentResolver.resolveEnvironment(binding)
		wrapperTypesGenerator.toOperationWrappers (service, service.findSubdomain(), minState, profile, environment.getRegistryBaseUrl());
		val verbsToOperations = operationBindingQueries.getRESTOperationsByVerb(service, effBind.moduleBinding)
		val content = '''
			#%RAML 1.0
			title: «service.name» API
			version: v1
			baseUri: «service.toEndpointAddress (effBind.provServer, prot, effBind)»
			  «toTypes(service, minState, profile, headerImports)»			types:
			  TestType:
			    type: object
			    properties:
			      id: number
			      optional?: string
			      expanded:
			        type: object
			        properties:
			          count: number
			  «service.operations.map[toOperation(effBind)].join»
			  /details:
			    get:
			      responses:
			        200:
			          body:
			            application/json:




			<?xml version="1.0" encoding="UTF-8"?>
			<application xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xsi:schemaLocation="http://wadl.dev.java.net/2009/02 wadl.xsd"
				xmlns:tns="«service.toTargetNamespace()»" 
				xmlns:xsd="http://www.w3.org/2001/XMLSchema"
				«FOR imp : service.importedVersionedNS (versionQualifier.toMajorVersionNumber (service.version), minState) »
					xmlns:«imp.versionedNamespacePrefix»="«imp.versionedNamespaceURI»"
				«ENDFOR»
				«IF !headerImports.empty»
					«FOR headerImp : headerImports»
						xmlns:«profileNamespaceURIProvider.getVersionedNamespacePrefix(headerImp)»="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"
					«ENDFOR»
				«ENDIF»
				xmlns="http://wadl.dev.java.net/2009/02">
				«toTypes(service, minState, profile, headerImports)»
				<resources base="«service.toEndpointAddress (effBind.provServer, prot, effBind)»">
					«service.operations.map[toOperation(effBind)].join»
				</resources>
			</application>
		'''
		fsa.generateFile(ramlFile, content)
	}
	
	def String toOperation(Operation operation, EffectiveBinding binding) {
		val restExtProt = binding.protocol.filter(typeof(EffectiveExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
		val REST restProt = restExtProt.inferComponent
		val module = binding.moduleBinding.module.module
		val effProvEndpoint = endpointBuilder.createEffectiveProvidingEndpoint(operation, module, new org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST)
		val basePath = operation.getOperationPath(binding)
		val content = '''
			
			«basePath.normalizePath»:
			  uriParameters:
			    aa : string
			  post:
			    queryParameters:
			      customerIds : array<integer>
			
			  get:
			    responses:
			      200:
			        body:
			          application/json:
			            example: |
			              {
			                "message" : "Hello World"
			              }
			      402:
			        displayName: hfksjssa
			        description:  sgfosagjvöa
			        headers:
			          key:
			            type:
			              - string
			            default: xyz
			        body:
			          application/json:
			            example:
			              {
			                "sdfg" : "dsfaga"
			              }
		'''
		content
	}
	
	def toRequestResponse(Operation op, REST binding, org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST endpoint) {
		val verb = if (binding.verb != null) binding.verb else if (endpoint.verb != null) endpoint.verb else Verb::POST
		'''
			«verb.toRAMLVerb»:
			  	responses:
					«FOR response : endpoint.response»
						«response.statusCode»:
							«FOR contentType : response.contentType»
								headers:
									key:
										type:
											- string
										default: xyz
								body:
									«contentType»:
										«/*example:
											{
												"message" : "Hello World"
											} */»
					        «ENDFOR»							
					«ENDFOR»
		'''
	}
	
	def String toTypes(Service service, LifecycleState state, Profile profile, Set<VersionedTechnicalNamespace> namespaces) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	private def normalizePath(String path) {
		val normalizedPath = if (path.startsWith("/")) path else '''/«path»'''
		if (normalizedPath.endsWith("/")) normalizedPath.substring(0, normalizedPath.length-1) else normalizedPath	
	}
	
	private def toRAMLVerb (Verb verb) {
		verb.getName().toLowerCase
	}
}