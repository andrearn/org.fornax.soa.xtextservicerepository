package org.xkonnex.repo.generator.bindingdsl.templates.soap

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.logging.Level
import java.util.logging.Logger
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.bindingdsl.binding.query.DefaultModuleRefServiceBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.binding.query.ProtocolMatcher
import org.xkonnex.repo.dsl.bindingdsl.binding.query.services.ServiceRefBindingDescription
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.generator.bindingdsl.templates.IProtocolContractBuilder
import org.xkonnex.repo.generator.bindingdsl.templates.xsd.XSDBuilder
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportBindingProtocol
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.query.DefaultModuleServiceResolver
import org.xkonnex.repo.generator.profiledsl.templates.MessageHeaderXSDTemplates
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.generator.servicedsl.templates.webservice.WSDLGenerator
import org.xkonnex.repo.dsl.moduledsl.query.IModuleServiceResolver
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.AssetStateEnvironmentEligibilityChecker
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleStateimport org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile

/** 
 * Generates WSDLs and XSDs for SOAP based service endpoints 
 */
class SOAPProtocolContractBuilder implements IProtocolContractBuilder {
	
	@Inject extension NamespaceQuery
	@Inject extension BindingExtensions
	@Inject extension AssetStateEnvironmentEligibilityChecker
	@Inject extension BindingLookup
	@Inject extension NamespaceImportQueries
	@Inject extension HeaderFinder
	@Inject extension EnvironmentBindingResolver		
		
	
	@Inject WSDLGenerator 				wsdlGenerator
	@Inject XSDBuilder 					xsdGenerator
	@Inject ConcreteWsdlGenerator 		concreteWsdlGenerator
	@Inject MessageHeaderXSDTemplates 	msgHeaderGenerator
	@Inject DefaultModuleRefServiceBindingResolver				bindingResolver
	@Inject IQualifiedNameProvider		nameProvider
	@Inject ProtocolMatcher				protocolMatcher
	@Inject LifecycleQueries 			lifecycleQueries
	@Inject IModuleServiceResolver 		modServiceResolver
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	@Inject @Named ("useRegistryBasedFilePaths") 		
	Boolean useRegistryBasedFilePaths
	
	@Inject Logger log


	override buildServiceContracts (ModuleBinding binding, Profile enforcedProfile) {
		log.fine ("Generating WSDLs and XSDs for binding " + binding.name)
		val providedServices = modServiceResolver.getAllProvidedServiceRefs(binding.module.module)
		for (provSvcRef : providedServices) {
			val svc = modServiceResolver.resolveModuleServiceRef (provSvcRef, binding.resolveEnvironment)

			if (svc != null) {
				try {
					val specBinding = svc.getMostSpecificBinding (binding);
					for (soapProt : specBinding.protocol.filter (p| p instanceof SOAP).map (e| e as SOAP)) {
						if (svc.providedContractUrl == null && svc.isEligibleForEnvironment (binding.resolveEnvironment)) {
							val namespace = svc.findSubdomain();
							val profile = namespace.getApplicableProfile(enforcedProfile)
							val typesMinState = lifecycleQueries.getMinLifecycleState (binding.resolveEnvironment, profile.lifecycle)
							val minState = binding.module.module.state
									
							wsdlGenerator.toWSDL (svc, namespace, minState, profile, binding.getRegistryBaseUrl());
							concreteWsdlGenerator.toWSDL(binding, svc, soapProt, profile);
									
							if ( ! noDependencies) {
								val verNamespaces = svc.importedVersionedNS (typesMinState);
								verNamespaces.forEach (n | xsdGenerator.toXSD(n, typesMinState, binding, profile));
										
								val requestHeader = svc.findBestMatchingRequestHeader (profile);
								if (requestHeader != null) {
									if (useRegistryBasedFilePaths)
										msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile, binding.getRegistryBaseUrl())
									else 
										msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile)
								}
								
								val responseHeader = svc.findBestMatchingResponseHeader (profile);
								if (responseHeader != null) {
									if (useRegistryBasedFilePaths)
										msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile, binding.getRegistryBaseUrl())
									else 
										msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile)
								}
							}
						}
					}
				} catch (Exception ex) {
					log.log (Level::SEVERE, "Error generating contracts for service " + nameProvider.getFullyQualifiedName(svc).toString + " and version " + svc.version.version + "\n", ex)
				}
			}
		}
	}
	
	

	override buildProvidedServiceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef endpointQualifierRef, Profile enforcedProfile) {
		log.fine ("Generating WSDLs and XSDs for services provided by module " + module.name + " looking up binding for used module to environment " + targetEnvironment.name)
		val bindingDescs = 	bindingResolver.resolveProvidedServiceBindings (module, targetEnvironment, endpointQualifierRef)
		for (specBindingDesc : bindingDescs.serviceRefDescriptions) {
			val svc = specBindingDesc.getResolvedService
			if (svc != null) {
				try {
					if (protocolMatcher.supportsImportBindingProtocol (specBindingDesc.getApplicableBinding, ImportBindingProtocol::SOAP)) {
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
	
	
	override buildUsedServiceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef endpointQualifierRef, Profile enforcedProfile) {
		log.fine ("Generating WSDLs and XSDs for used services in module " + module.name + " looking up binding for used module to environment " + targetEnvironment.name)
		val bindingDescs = bindingResolver.resolveUsedServiceBindings (module, targetEnvironment, endpointQualifierRef)
		for (curModBindDesc : bindingDescs) {
			for (specBindingDesc : curModBindDesc.serviceRefDescriptions) {
				val svc = specBindingDesc.getResolvedService
				if (svc != null) {
					try {
						if (protocolMatcher.supportsImportBindingProtocol (specBindingDesc.getApplicableBinding, ImportBindingProtocol::SOAP)) {
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
	}
	
	
	def protected doBuildServiceContracts (ServiceRefBindingDescription serviceBindingDescription, LifecycleState minState, boolean selectTypeVersionsByEnvironment, Profile enforcedProfile) {
		val service = serviceBindingDescription.getServiceRef.service
		val specBinding = serviceBindingDescription.getApplicableBinding
		for (soapProt : specBinding.protocol.filter (p| p instanceof SOAP).map (e| e as SOAP)) {
			try {
				if (service.providedContractUrl == null && service.isEligibleForEnvironment (specBinding.resolveEnvironment)) {
					val namespace = service.findSubdomain();
					val profile = namespace.getApplicableProfile(enforcedProfile)
					val typesMinState = if (selectTypeVersionsByEnvironment) 
											lifecycleQueries.getMinLifecycleState (specBinding.resolveEnvironment, minState.eContainer as Lifecycle)
										else
											minState
					wsdlGenerator.toWSDL (service, namespace, minState, profile, specBinding.getRegistryBaseUrl());
					concreteWsdlGenerator.toWSDL(specBinding, service, soapProt, profile);
							
					if ( ! noDependencies) {
						val verNamespaces = service.importedVersionedNS (typesMinState);
						verNamespaces.forEach (n | xsdGenerator.toXSD(n, typesMinState, specBinding, profile));
								
						val requestHeader = service.findBestMatchingRequestHeader (profile);
						if (requestHeader != null) {
							if (useRegistryBasedFilePaths)
								msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile, specBinding.getRegistryBaseUrl())
							else 
								msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile)
						}

						val responseHeader = service.findBestMatchingRequestHeader (profile);
						if (responseHeader != null) {
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

	
	override buildTypeDefinitions (SubNamespace namespace, Environment env, Profile enforcedProfile) {
		val profile = namespace.getApplicableProfile(enforcedProfile)
		log.fine ("Generating XSDs for namespace " + nameProvider.getFullyQualifiedName(namespace).toString)
		xsdGenerator.toXSD (namespace, env, profile);
	}

	
	override buildTypeDefinitions (VersionedDomainNamespace namespace, Environment env, Profile enforcedProfile) {
		val profile = (namespace.subdomain as SubNamespace).getApplicableProfile(enforcedProfile)
		log.fine ("Generating XSD for namespace " + namespace.fqn + " with major version " + namespace.version)
		xsdGenerator.toXSD (namespace, env, profile);
	}
	
}