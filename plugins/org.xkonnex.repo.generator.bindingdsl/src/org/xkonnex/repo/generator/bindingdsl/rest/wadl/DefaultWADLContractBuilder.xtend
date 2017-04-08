package org.xkonnex.repo.generator.bindingdsl.rest.wadl

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.logging.Level
import java.util.logging.Logger
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup
import org.xkonnex.repo.dsl.bindingdsl.binding.query.IModuleRefServiceBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.binding.query.ProtocolMatcher
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.AssetStateEnvironmentEligibilityChecker
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.binding.query.resource.ResourceRefBindingDescription
import org.xkonnex.repo.dsl.bindingdsl.binding.query.services.ServiceRefBindingDescription
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.REST
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.query.IModuleResourceResolver
import org.xkonnex.repo.dsl.moduledsl.query.IModuleServiceResolver
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.generator.bindingdsl.rest.wadl.templates.ConcreteWADLGenerator
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.generator.bindingdsl.templates.IProtocolContractBuilder
import org.xkonnex.repo.generator.bindingdsl.templates.xsd.XSDBuilder
import org.xkonnex.repo.generator.profiledsl.templates.MessageHeaderXSDTemplates

class DefaultWADLContractBuilder implements IProtocolContractBuilder {
	
	@Inject extension NamespaceQuery
	@Inject extension BindingExtensions
	@Inject extension AssetStateEnvironmentEligibilityChecker
	@Inject extension BindingLookup
	@Inject extension NamespaceImportQueries
	@Inject extension HeaderFinder
	@Inject extension EnvironmentBindingResolver		
		
	@Inject ConcreteWADLGenerator 		wadlBuilder
	@Inject XSDBuilder 					xsdGenerator
	@Inject MessageHeaderXSDTemplates 	msgHeaderGenerator
	@Inject IModuleRefServiceBindingResolver				bindingResolver
	@Inject IQualifiedNameProvider		nameProvider
	@Inject ProtocolMatcher				protocolMatcher
	@Inject LifecycleQueries 			lifecycleQueries
	@Inject IModuleServiceResolver 		modServiceResolver
	@Inject IModuleResourceResolver 	modResourceResolver
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	@Inject @Named ("useRegistryBasedFilePaths") 		
	Boolean useRegistryBasedFilePaths
	
	@Inject Logger log
	
	override buildProvidedServiceContracts(Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef providerEndpointQualifierRef, Profile enforcedProfile) {
		log.info ("Generating WADLs and XSDs for services provided by module " + module.name + " looking up binding for used module to environment " + targetEnvironment.name)
		val bindingDescs = 	bindingResolver.resolveProvidedServiceBindings (module, targetEnvironment, providerEndpointQualifierRef)
		for (specBindingDesc : bindingDescs.serviceRefDescriptions) {
			val svc = specBindingDesc.getResolvedService
			if (svc !== null) {
				try {
					if (protocolMatcher.supportsModuleEndpointProtocol (specBindingDesc.getApplicableBinding, typeof(org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST))) {
						doBuildServiceContracts (specBindingDesc, module.state, selectTypeVersionsByEnvironment, enforcedProfile)
					}
				} catch (Exception ex) {
					log.log (Level::SEVERE, "Error generating contracts for service " + nameProvider.getFullyQualifiedName (svc).toString + " and version " + svc.version.version + "\n", ex)
				}
			} else {
				log.severe ("Error generating contracts for service " + nameProvider.getFullyQualifiedName (specBindingDesc.getServiceRef.service).toString + " and version " + specBindingDesc.getServiceRef.service.version.version 
					+ " of module " + module.name +". Service could not be resolved for environment "+ targetEnvironment.name)
			}
		}
	}
	
	override buildServiceContracts(ModuleBinding binding, Profile enforcedProfile) {
		log.fine ("Generating WADLs and XSDs for binding " + binding.name)
		val providedServices = modServiceResolver.getAllProvidedServiceRefs(binding.module.module)
		for (provSvcRef : providedServices) {
			val svc = modServiceResolver.resolveModuleServiceRef (provSvcRef, binding.resolveEnvironment)

			if (svc !== null) {
				try {
					if (svc.providedContractUrl === null && svc.isEligibleForEnvironment (binding.resolveEnvironment)) {
						val namespace = svc.findSubdomain();
						val profile = namespace.getApplicableProfile(enforcedProfile)
						val typesMinState = lifecycleQueries.getMinLifecycleState (binding.resolveEnvironment, profile.lifecycle)
						val minState = binding.module.module.state
									
						wadlBuilder.toWADL(binding, svc, minState, profile);
								
						if ( ! noDependencies) {
							val verNamespaces = svc.importedVersionedNS (typesMinState);
							verNamespaces.forEach (n | xsdGenerator.toXSD(n, typesMinState, binding, profile));
									
							val requestHeader = svc.findBestMatchingRequestHeader (profile);
							if (requestHeader !== null) {
								if (useRegistryBasedFilePaths)
									msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile, binding.getRegistryBaseUrl())
								else 
									msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile)
							}
							
							val responseHeader = svc.findBestMatchingResponseHeader (profile);
							if (responseHeader !== null) {
								if (useRegistryBasedFilePaths)
									msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile, binding.getRegistryBaseUrl())
								else 
									msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile)
							}
						}
					}
				} catch (Exception ex) {
					log.log (Level::SEVERE, "Error generating contracts for service " + nameProvider.getFullyQualifiedName(svc).toString + " and version " + svc.version.version + "\n", ex)
				}
			}
		}
	}
	
	override buildProvidedResourceContracts(Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef providerEndpointQualifierRef, Profile enforcedProfile) {
		log.info ("Generating WADLs and XSDs for resources provided by module " + module.name + " looking up binding for used module to environment " + targetEnvironment.name)
		val bindingDescs = 	bindingResolver.resolveProvidedServiceBindings(module, targetEnvironment, providerEndpointQualifierRef)
		for (specBindingDesc : bindingDescs.resourceRefDescriptions) {
			val svc = specBindingDesc.resolvedResource
			if (svc !== null) {
				try {
					if (protocolMatcher.supportsModuleEndpointProtocol (specBindingDesc.getApplicableBinding, typeof(org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST))) {
						doBuildResourceContracts (specBindingDesc, module.state, selectTypeVersionsByEnvironment, enforcedProfile)
					}
				} catch (Exception ex) {
					log.log (Level::SEVERE, "Error generating contracts for resource " + nameProvider.getFullyQualifiedName (svc).toString + " and version " + svc.version.version + "\n", ex)
				}
			} else {
				log.severe ("Error generating contracts for resource " + nameProvider.getFullyQualifiedName (specBindingDesc.getResourceRef.resource).toString + " and version " + specBindingDesc.getResourceRef.resource.version.version 
					+ " of module " + module.name +". Resource could not be resolved for environment "+ targetEnvironment.name)
			}
		}
	}
	
	override buildResourceContracts(ModuleBinding binding, Profile enforcedProfile) {
		log.fine ("Generating WADLs and XSDs for binding " + binding.name)
		val providedResources = modResourceResolver.getAllProvidedResourceRefs(binding.module.module)
		for (provResRef : providedResources) {
			val res = modResourceResolver.resolveModuleResourceRef (provResRef, binding.resolveEnvironment)

			if (res !== null) {
				try {
					if (res.providedContractUrl === null && res.isEligibleForEnvironment (binding.resolveEnvironment)) {
						val namespace = res.findSubdomain();
						val profile = namespace.getApplicableProfile(enforcedProfile)
						val typesMinState = lifecycleQueries.getMinLifecycleState (binding.resolveEnvironment, profile.lifecycle)
						val minState = binding.module.module.state
									
//						if (!res.properties.isEmpty) {
//							xsdGenerator.toXSD(res.versionedNamespace, minState, binding, enforcedProfile)
//						}
						wadlBuilder.toWADL(binding, res, minState, profile);
								
						if ( ! noDependencies) {
							val verNamespaces = res.importedVersionedNS (typesMinState);
							verNamespaces.forEach (n | xsdGenerator.toXSD(n, typesMinState, binding, profile));
									
							val requestHeader = res.findBestMatchingRequestHeader (profile);
							if (requestHeader !== null) {
								if (useRegistryBasedFilePaths)
									msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile, binding.getRegistryBaseUrl())
								else 
									msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile)
							}
							
							val responseHeader = res.findBestMatchingResponseHeader (profile);
							if (responseHeader !== null) {
								if (useRegistryBasedFilePaths)
									msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile, binding.getRegistryBaseUrl())
								else 
									msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile)
							}
						}
					}
				} catch (Exception ex) {
					log.log (Level::SEVERE, "Error generating contracts for resource " + nameProvider.getFullyQualifiedName(res).toString + " and version " + res.version.version + "\n", ex)
				}
			}
		}
	}
	
	override buildTypeDefinitions(SubNamespace namespace, Environment env, Profile enforcedProfile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override buildTypeDefinitions(VersionedDomainNamespace namespace, Environment env, Profile enforcedProfile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override buildUsedServiceContracts(Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef endpointQualifierRef, Profile enforcedProfile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	def protected doBuildServiceContracts (ServiceRefBindingDescription serviceBindingDescription, LifecycleState minState, boolean selectTypeVersionsByEnvironment, Profile enforcedProfile) {
		val service = serviceBindingDescription.getServiceRef.service
		val specBinding = serviceBindingDescription.getApplicableBinding
		for (restProt : specBinding.protocol.filter (ExtensibleProtocol).filter [e|e.type?.identifier == typeof(REST).canonicalName]) {
			try {
				if (service.providedContractUrl === null && service.isEligibleForEnvironment (specBinding.resolveEnvironment)) {
					val namespace = service.findSubdomain();
					val profile = namespace.getApplicableProfile(enforcedProfile)
					val typesMinState = if (selectTypeVersionsByEnvironment) 
											lifecycleQueries.getMinLifecycleState (specBinding.resolveEnvironment, minState.eContainer as Lifecycle)
										else
											minState
					wadlBuilder.toWADL(specBinding, service, minState, profile);
							
					if ( ! noDependencies) {
						val verNamespaces = service.importedVersionedNS (typesMinState);
						verNamespaces.forEach (n | xsdGenerator.toXSD(n, typesMinState, specBinding, profile));
								
						val requestHeader = service.findBestMatchingRequestHeader (profile);
						if (requestHeader !== null) {
							if (useRegistryBasedFilePaths)
								msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile, specBinding.getRegistryBaseUrl())
							else 
								msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile)
						}

						val responseHeader = service.findBestMatchingRequestHeader (profile);
						if (responseHeader !== null) {
							if (useRegistryBasedFilePaths)
								msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile, specBinding.getRegistryBaseUrl())
							else 
								msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile)
						}
					}
				}
			} catch (Exception ex) {
				log.log (Level::SEVERE, "Error generating contracts for service " + nameProvider.getFullyQualifiedName(service).toString + " and version " + service.version.version + "\n", ex)
			}
		}
	}

	def protected doBuildResourceContracts (ResourceRefBindingDescription resourceBindingDescription, LifecycleState minState, boolean selectTypeVersionsByEnvironment, Profile enforcedProfile) {
		val resource = resourceBindingDescription.getResourceRef.resource
		val specBinding = resourceBindingDescription.getApplicableBinding
		for (restProt : specBinding.protocol.filter (ExtensibleProtocol).filter [e|e.type?.identifier == typeof(REST).canonicalName]) {
			try {
				if (resource.providedContractUrl === null && resource.isEligibleForEnvironment (specBinding.resolveEnvironment)) {
					val namespace = resource.findSubdomain();
					val profile = namespace.getApplicableProfile(enforcedProfile)
					val typesMinState = if (selectTypeVersionsByEnvironment) 
											lifecycleQueries.getMinLifecycleState (specBinding.resolveEnvironment, minState.eContainer as Lifecycle)
										else
											minState
					wadlBuilder.toWADL(specBinding, resource, minState, profile);
					if ( ! noDependencies) {
						val verNamespaces = resource.importedVersionedNS (typesMinState);
						verNamespaces.forEach (n | xsdGenerator.toXSD(n, typesMinState, specBinding, profile))
								
						val requestHeader = resource.findBestMatchingRequestHeader (profile);
						if (requestHeader !== null) {
							if (useRegistryBasedFilePaths)
								msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile, specBinding.getRegistryBaseUrl())
							else 
								msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile)
						}

						val responseHeader = resource.findBestMatchingRequestHeader (profile);
						if (responseHeader !== null) {
							if (useRegistryBasedFilePaths)
								msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile, specBinding.getRegistryBaseUrl())
							else 
								msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile)
						}
					}
				}
			} catch (Exception ex) {
				log.log (Level::SEVERE, "Error generating contracts for resource " + nameProvider.getFullyQualifiedName(resource).toString + " and version " + resource.version.version + "\n", ex)
			}
		}
	}
	
	override buildUsedResourceContracts(Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef endpointQualifierRef, Profile enforcedProfile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}