package org.xkonnex.repo.generator.bindingdsl.rest.raml.templates

import java.util.Set
import java.util.logging.Logger
import javax.inject.Inject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
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
import org.xkonnex.repo.dsl.moduledsl.model.EffectiveProvidingEndpoint
import org.xkonnex.repo.dsl.moduledsl.model.EffectiveProvidingEndpointProtocol
import org.xkonnex.repo.dsl.moduledsl.model.IEffectiveProvidingEndpointBuilder
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.MessageHeaderQuery
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.service.query.resource.ResourceQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.type.ReferencedTypesFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.type.TypeQueries
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractOperation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.IntReturnCode
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceOperation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Response
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ReturnCode
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.StringReturnCode
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Verb
import org.xkonnex.repo.generator.bindingdsl.http.HTTPMessagingExtensions
import org.xkonnex.repo.generator.bindingdsl.rest.RESTEndpointAddressResolver
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.generator.bindingdsl.templates.DefaultResourceContractFilenameProvider
import org.xkonnex.repo.generator.bindingdsl.templates.DefaultServiceContractFilenameProvider
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.json.JSONSchemaGenerator
import org.xkonnex.repo.generator.servicedsl.templates.webservice.ServiceTemplateExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.OperationWrapperTypesGenerator
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaTypeExtensions
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.emf.ecore.resource.ResourceSet

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
    @Inject extension MessageHeaderQuery
    @Inject extension HTTPMessagingExtensions

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
            «toTypes(service, minState, profile, headerImports, environment.registryBaseUrl)»
            «service.operations.map[op | op.toOperation(bindingBuilder.createEffectiveBinding(op, binding), profile)].join»
        '''
        fsa.generateFile(ramlFile, content)
    }
    
    def dispatch void toRAML(Resource resource, LifecycleState minState, ModuleBinding binding, Profile profile) {
        log.info('''Generating RAML description for Service «resource.fullyQualifiedName»'''.toString)
        val Set<VersionedTechnicalNamespace> headerImports = resource.collectTechnicalVersionedNamespaceImports (profile)
        val effBind = bindingBuilder.createEffectiveBinding(resource, binding)
        val prot = effBind.protocol.filter(typeof(ExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
        val ramlFile = resourceFilenameProvider.getResourceContractFileNameFragment(resource, effBind.moduleBinding, typeof(REST)) + ".raml";
        val content = '''
            #%RAML 1.0
            title: «resource.name» API
            version: v«resource.version.version»
            baseUri: «resource.toEndpointAddress (effBind.provServer, prot, effBind)»
            «toTypes(resource, minState, profile, headerImports)»
            «resource.operations.map[op | op.toOperation(bindingBuilder.createEffectiveBinding(op, binding), profile)].join»
        '''
        fsa.generateFile(ramlFile, content)
    }

//
    def dispatch void toRAMLStateless (AnyBinding binding, Service svc, Profile profile) {
        
    }
    
    def dispatch void toRAMLStateless (ModuleBinding binding, Service svc, Profile profile) {
        svc.toRAMLStateless (binding, profile);
    }

    def dispatch void toRAMLStateless (EffectiveBinding binding, Service svc, Profile profile) {
        svc.toRAMLStateless (binding.moduleBinding, profile);
    }

    def dispatch void toRAMLStateless (AnyBinding binding, Resource svc, Profile profile) {
        
    }
    
    def dispatch void toRAMLStateless (ModuleBinding binding, Resource svc, Profile profile) {
        svc.toRAMLStateless (binding, profile);
    }

    def dispatch void toRAMLStateless (EffectiveBinding binding, Resource svc, Profile profile) {
        svc.toRAMLStateless (binding.moduleBinding, profile);
    }
    
    def dispatch void toRAMLStateless(Service service, ModuleBinding binding, Profile profile) {
        log.info('''Generating RAML description for Service «service.fullyQualifiedName»'''.toString)
        val Set<VersionedTechnicalNamespace> headerImports = service.collectTechnicalVersionedNamespaceImports (profile)
        val effBind = bindingBuilder.createEffectiveBinding(service, binding)
        val prot = effBind.protocol.filter(typeof(ExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
        val ramlFile = service.getServiceContractFileNameFragment(effBind.moduleBinding, typeof(REST)) + ".raml";
        val environment = environmentResolver.resolveEnvironment(binding)
        wrapperTypesGenerator.toOperationWrappersStateless (service, service.findSubdomain(), profile, environment.getRegistryBaseUrl());
        val verbsToOperations = operationBindingQueries.getRESTOperationsByVerb(service, effBind.moduleBinding)
        val content = '''
            #%RAML 1.0
            title: «service.name» API
            version: v«service.version.version»
            baseUri: «service.toEndpointAddress (effBind.provServer, prot, effBind)»
            «toTypesStateless (service, profile, headerImports, environment.registryBaseUrl)»
            «service.operations.map[op | op.toOperation(bindingBuilder.createEffectiveBinding(op, binding), profile)].join»
        '''
        fsa.generateFile(ramlFile, content)
    }
    
    def dispatch void toRAMLStateless(Resource resource, ModuleBinding binding, Profile profile) {
        log.info('''Generating RAML description for Service «resource.fullyQualifiedName»'''.toString)
        val Set<VersionedTechnicalNamespace> headerImports = resource.collectTechnicalVersionedNamespaceImports (profile)
        val effBind = bindingBuilder.createEffectiveBinding(resource, binding)
        val prot = effBind.protocol.filter(typeof(ExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
        val ramlFile = resourceFilenameProvider.getResourceContractFileNameFragment(resource, effBind.moduleBinding, typeof(REST)) + ".raml";
        val content = '''
            #%RAML 1.0
            title: «resource.name» API
            version: v«resource.version.version»
            baseUri: «resource.toEndpointAddress (effBind.provServer, prot, effBind)»
            «toTypesStateless (resource, profile, headerImports)»
            «resource.operations.map[op | op.toOperation(bindingBuilder.createEffectiveBinding(op, binding), profile)].join»
        '''
        fsa.generateFile(ramlFile, content)
    }

//    
    def String toOperation(AbstractOperation operation, EffectiveBinding binding, Profile profile) {
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
        val uri = if(restProt?.path !== null) restProt?.path else null
        val params = resourceQueries.extractParametersFromURI(uri, operation).toList
        val content = '''
            
            «basePath.normalizePath»:
                «IF !params.nullOrEmpty»
                    uriParameters:
                        «FOR param : params»
                            «param.name» : «inlineTypeGenerator.toPropertyType(param.type)»
                        «ENDFOR»
                «ENDIF»
                «operation.toRequestResponse(restProt, restModuleEndpoint, profile)»
        '''
        content
    }
    def String toOperation(ResourceOperation operation, EffectiveBinding binding, Profile profile) {
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
        val uri = if(restProt?.path !== null) restProt?.path else operation.uri
        val params = resourceQueries.extractParametersFromURI(uri, operation).toList
        val content = '''
            
            «basePath.normalizePath»:
                «IF !params.nullOrEmpty»
                    uriParameters:
                        «FOR param : params»
                            «param.name» : «inlineTypeGenerator.toPropertyType(param.type)»
                        «ENDFOR»
                «ENDIF»
                «operation.toRequestResponse(restProt, restModuleEndpoint, profile)»
        '''
        content
    }
    
    def dispatch toRequestResponse(AbstractOperation op, REST binding, org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST endpoint, Profile profile) {
    }
    def dispatch toRequestResponse(Operation op, REST binding, org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST endpoint, Profile profile) {
        val verb = if (binding.verb !== null) binding.verb else if (endpoint?.verb !== null) endpoint.verb else Verb::POST
        val requestContentTypes = if (!binding.requestContentType.nullOrEmpty) binding.requestContentType else (endpoint?.requestContentType)
        val responses = if (!binding.response.nullOrEmpty) binding.response else (endpoint?.response)
        val requestMessageHeaders = op.getRequestMessageHeader(profile)
        val responseMessageHeaders = op.getResponseMessageHeader(profile)
        '''
            «verb.toRAMLVerb»:
                «IF requestMessageHeaders !== null && !requestMessageHeaders.toRequestHeaderMap.isEmpty»
                    headers:
                        «FOR propEntry : requestMessageHeaders.toRequestHeaderMap.entrySet»
                            «propEntry.key»:
                                type: «propEntry.value.toHeaderType(op.eResource.resourceSet)»
                        «ENDFOR»
                «ENDIF»
                «IF isVerbWithRequestBody(verb) && !op.parameters.nullOrEmpty»
                    body:
                        «FOR contentType : requestContentTypes»
                            «contentType»:
                                «op.toRequestBody»
                                 «/* example:
						            {
						                 "message" : "Hello World"
						             } 
						         */»
                        «ENDFOR»
                        «IF requestContentTypes.isNullOrEmpty»
                            application/json:
                                «op.toRequestBody»
                        «ENDIF»                            
            	«ENDIF»
                responses:
                    «FOR response : responses»
                        «response.statusCode»:
                            «IF !response.header.nullOrEmpty»
                                headers:
                                    «FOR header : response.header»
                                        «header.name»:
                                            type:
                                                - «IF (header.type !== null)»«header.type»«ELSE»string«ENDIF»
                                                «/*default: «header.messageHeader*/»
                                    «ENDFOR»
                            «ENDIF»
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
    def dispatch toRequestResponse(ResourceOperation op, REST binding, org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST endpoint, Profile profile) {
        val verb = if (binding.verb !== null) binding.verb else if (op.verb !== null) op.verb else Verb::POST
        val requestContentTypes = if (!binding.requestContentType.nullOrEmpty) binding.requestContentType else (endpoint?.requestContentType)
        val responses = if (!binding.response.nullOrEmpty) binding.response else (op?.response)
        val requestMessageHeaders = op.getRequestMessageHeader(profile)
        val responseMessageHeaders = op.getResponseMessageHeader(profile)
        '''
            «verb.toRAMLVerb»:
                «IF requestMessageHeaders !== null && !requestMessageHeaders.toRequestHeaderMap.isEmpty»
                    headers:
                        «FOR propEntry : requestMessageHeaders.toRequestHeaderMap.entrySet»
                            «propEntry.key»:
                                type: «propEntry.value.toHeaderType(op.eResource.resourceSet)»
                        «ENDFOR»
                «ENDIF»
                «IF isVerbWithRequestBody(verb) && !op.parameters.nullOrEmpty»
                     body:
                         «FOR contentType : requestContentTypes»
                             «contentType»:
                                 «op.toRequestBody»
                                 «/* example:
						             {
						                 "message" : "Hello World"
						             } 
						         */»
                         «ENDFOR»                            
                         «IF requestContentTypes.isNullOrEmpty»
                             application/json:
                                 «op.toRequestBody»
                         «ENDIF»                            
                «ENDIF»
                responses:
                    «FOR response : op.response»
                        «response.responseCode.toReturnCode»:
                            «IF responseMessageHeaders !== null && !requestMessageHeaders.parameters.nullOrEmpty»
                                headers:
                                    «FOR propEntry : responseMessageHeaders.toRequestHeaderMap.entrySet»
                                        «propEntry.key»:
                                            type: «propEntry.value.toHeaderType(op.eResource.resourceSet)»
                                    «ENDFOR»
                            «ENDIF»
                            body:
                                «FOR contentType : response.contentType»
                                    «contentType»:
                                        «response.toReturnType»
                                «ENDFOR»                            
                    «ENDFOR»
                    «IF responses.nullOrEmpty»
                        200:
                            body:
                                application/json:
                                    «op.toReturnType»
                    «ENDIF»
        '''
    }
    
    def String toTypes(Service service, LifecycleState state, Profile profile, Set<VersionedTechnicalNamespace> namespaces, String registryBaseUrl) {
        val allVerTypes = service.getAllReferencedVersionedTypes(state).toList.sortBy[name]
        allVerTypes.filter(typeof(DataObject)).forEach(t|jsonSchemaGenerator.generateSchema(t, registryBaseUrl))
        '''
            types:
                «allVerTypes.map(t|inlineTypeGenerator.toTypeDeclaration(t)).filterNull.map(t|t.toString).toSet.join("\n")»
        '''
    }

    def String toTypesStateless (Service service, Profile profile, Set<VersionedTechnicalNamespace> namespaces, String registryBaseUrl) {
        val allVerTypes = service.getAllReferencedVersionedTypes().toList.sortBy[name]
        allVerTypes.filter(typeof(DataObject)).forEach(t|jsonSchemaGenerator.generateSchema(t, registryBaseUrl))
        '''
            types:
                «allVerTypes.map(t|inlineTypeGenerator.toTypeDeclaration(t)).filterNull.map(t|t.toString).toSet.join("\n")»
        '''
    }
    
    
    def String toTypes(Resource resource, LifecycleState state, Profile profile, Set<VersionedTechnicalNamespace> namespaces) {
        val typeRefs = resource.operations.map(op|op.parameters).flatten.map(p|p.type).toList
        val respTypeRefs = resource.operations.map(op|op.response).flatten.map[it.^return].flatten.map(p|p.type)
        typeRefs.addAll(respTypeRefs)
        val types = typeRefs.filter(t| !(t instanceof DataTypeRef || t instanceof org.xkonnex.repo.dsl.profiledsl.profileDsl.DataTypeRef))
        '''
            types:
                «types.map(t|inlineTypeGenerator.toTypeDeclaration(t)).filterNull.toSet.join("\n")»
        '''
    }
    
    def String toTypesStateless(Resource resource, Profile profile, Set<VersionedTechnicalNamespace> namespaces) {
        val typeRefs = resource.operations.map(op|op.parameters).flatten.map(p|p.type).toList
        val respTypeRefs = resource.operations.map(op|op.response).flatten.map[it.^return].flatten.map(p|p.type)
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
        val verb = if (bindingRESTProtocol.verb !== null) bindingRESTProtocol.verb else Verb.POST
        return verb.toRAMLVerb
    }
    
    private def toRAMLVerb (Verb verb) {
        verb.getName().toLowerCase
    }
    private def dispatch String toReturnCode (ReturnCode returnCode) {
    	'''200'''
    }
    private def dispatch String toReturnCode (IntReturnCode returnCode) {
        '''«returnCode.returnCode»'''
    }
    private def dispatch String toReturnCode (StringReturnCode returnCode) {
        '''«returnCode.returnCode»'''
    }
    
    private def dispatch toReturnType (Response response) {
        if (response.^return.size > 1) {
            '''
                properties: 
                    «FOR param : response.^return»
                        «param.name» «inlineTypeGenerator.toPropertyType(param.type)»
                    «ENDFOR»
            '''
        } else if(response.^return.size == 1) {
            '''
                type: «inlineTypeGenerator.toPropertyType(response.^return.get(0).type)»
            '''
        } else {
            ''''''
        }
    }
    private def dispatch toReturnType (AbstractOperation op) {
    	
    }

    private def dispatch toReturnType (Operation op) {
        if (op.^return.size > 1) {
            '''
                properties: 
                    «FOR param : op.^return»
                        «param.name»: «inlineTypeGenerator.toPropertyType(param.type)»
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
    
    private def toRequestBody (AbstractOperation op) {
        if (op.parameters.size > 0) {
            '''
                properties: 
                    «FOR param : op.parameters»
                        «param.name»: «inlineTypeGenerator.toPropertyType(param.type)»
                    «ENDFOR»
            '''
        } else {
            ''''''
        }
    }

    private def toHeaderType (IEObjectDescription propertyDescription, ResourceSet rs) {
    	val propObj = EcoreUtil2.resolve(propertyDescription.EObjectOrProxy, rs)
    	if (propObj instanceof org.xkonnex.repo.dsl.profiledsl.profileDsl.Property ) {
    		val prop = propObj as org.xkonnex.repo.dsl.profiledsl.profileDsl.Property
    		inlineTypeGenerator.toPropertyType(prop.type)
    	}
    }
    
    private def isVerbWithRequestBody(Verb verb) {
    	switch verb {
    		case POST: return true
    		case PUT: return true
    		case null: return true
    		default: return false 
    	} 
    }
}