package org.xkonnex.repo.generator.bindingdsl.rest.raml.templates

import java.util.Set
import java.util.logging.Logger
import javax.inject.Inject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.binding.query.operation.OperationBindingQueries
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.REST
import org.xkonnex.repo.dsl.bindingdsl.model.EffectiveBinding
import org.xkonnex.repo.dsl.bindingdsl.model.IEffectiveBindingBuilder
import org.xkonnex.repo.dsl.bindingdsl.model.protocol.EffectiveExtensibleProtocol
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.HttpVerb
import org.xkonnex.repo.dsl.moduledsl.model.EffectiveProvidingEndpoint
import org.xkonnex.repo.dsl.moduledsl.model.EffectiveProvidingEndpointProtocol
import org.xkonnex.repo.dsl.moduledsl.model.IEffectiveProvidingEndpointBuilder
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.service.query.resource.ResourceQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.type.ReferencedTypesFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.type.TypeQueries
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractVersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Verb
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.generator.bindingdsl.rest.RESTEndpointAddressResolver
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.generator.bindingdsl.templates.DefaultResourceContractFilenameProvider
import org.xkonnex.repo.generator.bindingdsl.templates.DefaultServiceContractFilenameProvider
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.webservice.ServiceTemplateExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.OperationWrapperTypesGenerator
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaTypeExtensions
import org.xkonnex.repo.generator.servicedsl.templates.json.JSONSchemaGenerator

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
    @Inject extension TypeQueries
    @Inject extension DataObjectQueries

    @Inject RAMLTypesGenerator inlineTypeGenerator
    @Inject JSONSchemaGenerator jsonSchemaGenerator
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
    @Inject OperationBindingQueries operationBindingQueries
    @Inject ResourceQueries resourceQueries
    @Inject extension ReferencedTypesFinder refTypesFinder

    @Inject IFileSystemAccess fsa
    @Inject Logger log
    
    def dispatch void toRAML (AnyBinding binding, Service svc, LifecycleState minState, Profile profile) {
        
    }
    
    def dispatch void toRAML (ModuleBinding binding, Service svc, LifecycleState minState, Profile profile) {
        svc.toRAML (minState, binding, profile);
    }

    def dispatch void toRAML (EffectiveBinding binding, Service svc, LifecycleState minState, Profile profile) {
        svc.toRAML (minState, binding.moduleBinding, profile);
    }

    def dispatch void toRAML (AnyBinding binding, Resource svc, LifecycleState minState, Profile profile) {
        
    }
    
    def dispatch void toRAML (ModuleBinding binding, Resource svc, LifecycleState minState, Profile profile) {
        svc.toRAML (minState, binding, profile);
    }

    def dispatch void toRAML (EffectiveBinding binding, Resource svc, LifecycleState minState, Profile profile) {
        svc.toRAML (minState, binding.moduleBinding, profile);
    }
    
    def dispatch void toRAML(Service service, LifecycleState minState, ModuleBinding binding, Profile profile) {
        log.info('''Generating RAML description for Service «service.fullyQualifiedName»'''.toString)
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
            version: v«service.version.version»
            baseUri: «service.toEndpointAddress (effBind.provServer, prot, effBind)»
            «toTypes(service, minState, profile, headerImports)»
            «service.operations.map[toOperation(effBind)].join»
        '''
//            #%RAML 1.0
//            title: «service.name» API
//            version: v«service.version.version»
//            baseUri: «service.toEndpointAddress (effBind.provServer, prot, effBind)»
//              «toTypes(service, minState, profile, headerImports)»
//            types:
//              TestType:
//                type: object
//                properties:
//                  id: number
//                  optional?: string
//                  expanded:
//                    type: object
//                    properties:
//                      count: number
//              «service.operations.map[toOperation(effBind)].join»
//              /details:
//                get:
//                  responses:
//                    200:
//                      body:
//                        application/json:
        fsa.generateFile(ramlFile, content)
    }
    
    def dispatch void toRAML(Resource resource, LifecycleState minState, ModuleBinding binding, Profile profile) {
        log.info('''Generating RAML description for Service «resource.fullyQualifiedName»'''.toString)
        val Set<VersionedTechnicalNamespace> headerImports = resource.collectTechnicalVersionedNamespaceImports (profile)
        val effBind = bindingBuilder.createEffectiveBinding(resource, binding)
        val prot = effBind.protocol.filter(typeof(ExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
        val ramlFile = resourceFilenameProvider.getResourceContractFileNameFragment(resource, effBind.moduleBinding, typeof(REST)) + ".raml";
        val environment = environmentResolver.resolveEnvironment(binding)
        val verbsToOperations = operationBindingQueries.getRESTOperationsByVerb(resource, effBind.moduleBinding)
        val content = '''
            #%RAML 1.0
            title: «resource.name» API
            version: v«resource.version.version»
            baseUri: «resource.toEndpointAddress (effBind.provServer, prot, effBind)»
            «toTypes(resource, minState, profile, headerImports)»
            «resource.operations.map[toOperation(effBind)].join»
        '''
        fsa.generateFile(ramlFile, content)
    }
    
    def String toOperation(Operation operation, EffectiveBinding binding) {
        val restExtProt = binding.protocol.filter(typeof(EffectiveExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
        val REST restProt = restExtProt.inferComponent
        val module = binding.moduleBinding.module.module
        val effProvEndpoint = endpointBuilder.createEffectiveProvidingEndpoint(operation, module, new org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST)
        var EffectiveProvidingEndpointProtocol effProvEndpointProt = null
        var org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST restModuleEndpoint = null
        if (effProvEndpoint?.endpointProtocol instanceof EffectiveProvidingEndpointProtocol) {
            effProvEndpointProt = effProvEndpoint.endpointProtocol as EffectiveProvidingEndpointProtocol
            if (effProvEndpointProt?.endpointProtocol instanceof org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST) {
                restModuleEndpoint = effProvEndpointProt.endpointProtocol as org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST
            }
        }
        val basePath = operation.getOperationPath(binding)
        val uri = if(restProt?.path != null) restProt?.path else null
        val params = resourceQueries.extractParametersFromURI(uri, operation).toList
        val content = '''
            
            «basePath.normalizePath»:
                «IF !params.nullOrEmpty»
                    uriParameters:
                        «FOR param : params»
                            «param.name» : «param.toTypeNameRef»
                        «ENDFOR»
                «ENDIF»
                «operation.toRequestResponse(restProt, restModuleEndpoint)»
        '''
        content
    }
    
    def toRequestResponse(Operation op, REST binding, org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST endpoint) {
        val verb = if (binding.verb != null) binding.verb else if (endpoint?.verb != null) endpoint.verb else Verb::POST
        val responses = if (!binding.response.nullOrEmpty) binding.response else (endpoint?.response)
        '''
            «verb.toRAMLVerb»:
                responses:
                    «FOR response : responses»
                        «response.statusCode»:
                            headers:
                                «FOR header : response.header»
                                    «header.name»:
                                        type:
                                            - «IF (header.type != null)»«header.type»«ELSE»string«ENDIF»
                                            «/*default: «header.messageHeader*/»
                                «ENDFOR»
                            body:
                                «FOR contentType : response.contentType»
                                    «contentType»:
                                        «op.toReturnType»
                                            «/* example:
                                                {
                                                    "message" : "Hello World"
                                                } 
                                            */»
                                «ENDFOR»                            
                    «ENDFOR»
                    «IF responses.nullOrEmpty»
                        200:
                            body:
                                application/json:
                                    «op.toReturnType»
                                    «/*example:
                                        {
                                            "message" : "Hello World"
                                        } */»
                    «ENDIF»
        '''
    }
    
    def String toTypes(Service service, LifecycleState state, Profile profile, Set<VersionedTechnicalNamespace> namespaces) {
        val allVerTypes = service.getAllReferencedVersionedTypes(state).toList.sortBy[name]
        allVerTypes.filter(typeof(DataObject)).forEach(t|jsonSchemaGenerator.generateSchema(t))
        '''
            types:
                «allVerTypes.map(t|inlineTypeGenerator.toTypeDeclaration(t)).filterNull.map(t|t.toString).toSet.join("\n")»
        '''
    }
    
    
    def String toTypes(Resource resource, LifecycleState state, Profile profile, Set<VersionedTechnicalNamespace> namespaces) {
        val typeRefs = resource.operations.map(op|op.parameters).flatten.map(p|p.type).toList
        val respTypeRefs = resource.operations.map(op|op.^return).flatten.map(p|p.type)
        typeRefs.addAll(respTypeRefs)
        val types = typeRefs.filter(t| !(t instanceof DataTypeRef || t instanceof org.xkonnex.repo.dsl.profiledsl.profileDsl.DataTypeRef))
        '''
            types:
                «types.map(t|inlineTypeGenerator.toTypeDeclaration(t)).filterNull.toSet.join("\n")»
        '''
    }
    
    private def normalizePath(String path) {
        val normalizedPath = if (path.startsWith("/")) path else '''/«path»'''
        if (normalizedPath.endsWith("/")) normalizedPath.substring(0, normalizedPath.length-1) else normalizedPath    
    }
    
    def toRequestVerb(REST bindingRESTProtocol, EffectiveProvidingEndpoint endpoint) {
        val verb = if (bindingRESTProtocol.verb != null) bindingRESTProtocol.verb else Verb.POST
        return verb.toRAMLVerb
    }
    
    private def toRAMLVerb (Verb verb) {
        verb.getName().toLowerCase
    }
    
    private def toReturnType (Operation op) {
        if (op.^return.size > 1) {
            '''
                type: object
                    properties: 
                        «FOR param : op.^return»
                            «param.name» «inlineTypeGenerator.toPropertyType(param.type)»
                        «ENDFOR»
            '''
        } else if(op.^return.size == 1) {
            '''
                type: «inlineTypeGenerator.toPropertyType(op.^return.get(0).type)»
            '''
        } else {
            ''''''
        }
    }
}