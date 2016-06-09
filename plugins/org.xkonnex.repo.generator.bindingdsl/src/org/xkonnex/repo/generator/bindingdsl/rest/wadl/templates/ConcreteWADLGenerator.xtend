package org.xkonnex.repo.generator.bindingdsl.rest.wadl.templates

import com.google.inject.Inject
import java.util.Set
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.REST
import org.xkonnex.repo.dsl.bindingdsl.model.EffectiveBinding
import org.xkonnex.repo.dsl.bindingdsl.model.IEffectiveBindingBuilder
import org.xkonnex.repo.dsl.bindingdsl.model.protocol.EffectiveExtensibleProtocol
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.HttpResponse
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.HttpVerb
import org.xkonnex.repo.dsl.moduledsl.model.EffectiveProvidingEndpoint
import org.xkonnex.repo.dsl.moduledsl.model.EffectiveProvidingEndpointProtocol
import org.xkonnex.repo.dsl.moduledsl.model.IEffectiveProvidingEndpointBuilder
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.OperationRef
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.bindingdsl.rest.RESTEndpointAddressResolver
import org.xkonnex.repo.generator.bindingdsl.templates.DefaultServiceContractFilenameProvider
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.webservice.ServiceTemplateExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaTypeExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.OperationWrapperTypesGenerator
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.eclipse.xtext.generator.IFileSystemAccess
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import java.util.logging.Logger
import java.util.logging.Level
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef
import java.util.List
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.generator.bindingdsl.templates.DefaultResourceContractFilenameProvider

class ConcreteWADLGenerator {
	
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
	@Inject DefaultResourceContractFilenameProvider resourceFilenameProvider
	@Inject OperationWrapperTypesGenerator wrapperTypesGenerator

	@Inject IFileSystemAccess fsa
	@Inject Logger log

	def dispatch void toWADL (AnyBinding binding, Service svc, LifecycleState minState, Profile profile) {
	}

	def dispatch void toWADL (ModuleBinding binding, Service svc, LifecycleState minState, Profile profile) {
		svc.toWADL (minState, binding, profile);
	}

	def dispatch void toWADL (EffectiveBinding binding, Service svc, LifecycleState minState, Profile profile) {
		svc.toWADL (minState, binding.moduleBinding, profile);
	}
	
	def dispatch void toWADL (AnyBinding binding, Resource svc, LifecycleState minState, Profile profile) {
	}

	def dispatch void toWADL (ModuleBinding binding, Resource svc, LifecycleState minState, Profile profile) {
		svc.toWADL (minState, binding, profile);
	}

	def dispatch void toWADL (EffectiveBinding binding, Resource svc, LifecycleState minState, Profile profile) {
		svc.toWADL (minState, binding.moduleBinding, profile);
	}
	
	def toWADL(Service service, LifecycleState minState, ModuleBinding binding, Profile profile) {
		log.info('''Generating WADL for Service «service.fullyQualifiedName»'''.toString)
		val Set<VersionedTechnicalNamespace> headerImports = service.collectTechnicalVersionedNamespaceImports (profile)
		val effBind = bindingBuilder.createEffectiveBinding(service, binding)
		val prot = effBind.protocol.filter(typeof(ExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
		val wadlFile = service.getServiceContractFileNameFragment(effBind.moduleBinding, typeof(REST)) + ".wadl";
		val environment = environmentResolver.resolveEnvironment(binding)
		wrapperTypesGenerator.toOperationWrappers (service, service.findSubdomain(), minState, profile, environment.getRegistryBaseUrl());
		val content = '''
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
				«toGrammars(service, minState, profile, headerImports)»
				<resources base="«service.toEndpointAddress (effBind.provServer, prot, effBind)»">
					«service.operations.map[toOperation(effBind)].join»
				</resources>
			</application>
		'''
		fsa.generateFile(wadlFile, content)
	}
	
	def toWADL(Resource resource, LifecycleState minState, ModuleBinding binding, Profile profile) {
		log.info('''Generating WADL for Resource «resource.fullyQualifiedName»'''.toString)
		val Set<VersionedTechnicalNamespace> headerImports = resource.collectTechnicalVersionedNamespaceImports (profile)
		val effBind = bindingBuilder.createEffectiveBinding(resource, binding)
		val prot = effBind.protocol.filter(typeof(ExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
		val wadlFile = resourceFilenameProvider.getResourceContractFileNameFragment(resource, effBind.moduleBinding, typeof(REST)) + ".wadl";
		val environment = environmentResolver.resolveEnvironment(binding)
//		wrapperTypesGenerator.toOperationWrappers (resource, resource.findSubdomain(), minState, profile, environment.getRegistryBaseUrl());
		val content = '''
			<?xml version="1.0" encoding="UTF-8"?>
			<application xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xsi:schemaLocation="http://wadl.dev.java.net/2009/02 wadl.xsd"
				xmlns:tns="«resource.toTargetNamespace()»" 
				xmlns:xsd="http://www.w3.org/2001/XMLSchema"
				«FOR imp : resource.importedVersionedNS (versionQualifier.toMajorVersionNumber (resource.version), minState) »
					xmlns:«imp.versionedNamespacePrefix»="«imp.versionedNamespaceURI»"
				«ENDFOR»
				«IF !headerImports.empty»
					«FOR headerImp : headerImports»
						xmlns:«profileNamespaceURIProvider.getVersionedNamespacePrefix(headerImp)»="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"
					«ENDFOR»
				«ENDIF»
				xmlns="http://wadl.dev.java.net/2009/02">
				«toGrammars(resource, minState, profile, headerImports)»
				<resources base="«resource.toEndpointAddress (effBind.provServer, prot, effBind)»">
					«resource.operations.map[toOperation(effBind)].join»
				</resources>
			</application>
		'''
		fsa.generateFile(wadlFile, content)
	}
	
	def toGrammars(Service s, LifecycleState minState, Profile profile, Set<VersionedTechnicalNamespace> headerImports) {
		val content = '''
			<grammars>
				«FOR imp : s.importedVersionedNS (versionQualifier.toMajorVersionNumber(s.version), minState)»
					<include href="«imp.toSchemaAssetUrl (null)».xsd" />
				«ENDFOR»
				«IF !headerImports.empty»
					«FOR headerImp : headerImports»
						<include href="«profileSchemaNamespaceExt.toRegistryAssetUrl (headerImp, null)».xsd"/>
					«ENDFOR»
				«ENDIF»
			</grammars>		'''
		return content
	}
	
	def toGrammars(Resource s, LifecycleState minState, Profile profile, Set<VersionedTechnicalNamespace> headerImports) {
		val content = '''
			<grammars>
				«FOR imp : s.importedVersionedNS (versionQualifier.toMajorVersionNumber(s.version), minState)»
					<include href="«imp.toSchemaAssetUrl (null)».xsd" />
				«ENDFOR»
				«IF !headerImports.empty»
					«FOR headerImp : headerImports»
						<include href="«profileSchemaNamespaceExt.toRegistryAssetUrl (headerImp, null)».xsd"/>
					«ENDFOR»
				«ENDIF»
			</grammars>		'''
		return content
	}
	
	def toOperation(Operation operation, EffectiveBinding binding) {
		val restExtProt = binding.protocol.filter(typeof(EffectiveExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
		val REST restProt = restExtProt.inferComponent
		val module = binding.moduleBinding.module.module
		val effProvEndpoint = endpointBuilder.createEffectiveProvidingEndpoint(operation, module, new org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST)
		val basePath = operation.getOperationPath(binding)
		val content = '''
			<resource path="«basePath»">
				<method name="«toRequestVerb(restProt, effProvEndpoint)»" id="«operation.name»">
					<request>
						«operation.parameters.map[toRequestParam(binding, restProt)].join»
					</request>
					«toResponses(operation, restProt, effProvEndpoint)»
				</method>
			</resource>		
		'''
		return content
	}
	
	def toRequestParam(Parameter param, EffectiveBinding binding, REST protocol) {
		val content = '''
			<param name="«param.name»" type="«param.type.toTypeNameRef ()»" style="query" required="«if (param.optional) "false" else "true"»" />		
		'''
		return content
	}
	
	def toResponses(Operation op, REST bindingRESTProtocol, EffectiveProvidingEndpoint endpoint) {
		val responses = getResponses(bindingRESTProtocol, endpoint)
		'''
			«responses.filter[statusCode == null || statusCode < 400].map[toResponse(op.^return.head)].join»
			«responses.filter[statusCode != null && statusCode >= 400].map[toErrorResponse(op.throws)].join»		'''
	}
	
	def toResponse(HttpResponse response, Parameter param) {
		val content = '''
			«IF response.statusCode == null»
				<response>
					«FOR mediaType : response.contentType»
						<representation mediaType="«mediaType»"» />
					«ENDFOR»		
				</response>
			«ELSE»
				<response status="«response.statusCode»">
					«FOR mediaType : response.contentType»
						<representation mediaType="«mediaType»" element="«param.type.toTypeNameRef ()» />
					«ENDFOR»		
				</response>
			«ENDIF»
		'''
		return content
	}
	
	def toErrorResponse(HttpResponse response, List<ExceptionRef> exception) {
		val content = '''
			«IF !exception.nullOrEmpty && exception.size == 1»
				<response status="«response.statusCode»">
					«FOR mediaType : response.contentType»
						<representation mediaType="«mediaType»" element="«exception.head.toExceptionNameRef ()»" />
					«ENDFOR»		
				</response>
			«ELSE»
				<response status="«response.statusCode»">
					«FOR mediaType : response.contentType»
						<representation mediaType="«mediaType»" />
					«ENDFOR»		
				</response>
			«ENDIF»
		'''
		return content
	}
	
	private def getResponses(REST bindingRESTProtocol, EffectiveProvidingEndpoint endpoint) {
		if (!bindingRESTProtocol.response.nullOrEmpty) {
			return bindingRESTProtocol.response  
		} else if (endpoint.endpointProtocol instanceof EffectiveProvidingEndpointProtocol) {
			val effProtocol = endpoint.endpointProtocol as EffectiveProvidingEndpointProtocol
			val org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST rest = (effProtocol).endpointProtocol as org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST
			return rest.response
		}
	}
	
	def toRequestVerb(REST bindingRESTProtocol, EffectiveProvidingEndpoint endpoint) {
		val verb = if (bindingRESTProtocol.verb != null) bindingRESTProtocol.verb else HttpVerb.POST
		return verb.name
	}
	
	private def isVoid(OperationRef opRef) {
		opRef.operation.^return.nullOrEmpty || 
			(opRef.operation.^return.size == 1 && 
				opRef.operation.^return.head.type instanceof DataTypeRef && 
				(opRef.operation.^return.head.type as DataTypeRef).type.name == 'void'
			)
	}
	
}