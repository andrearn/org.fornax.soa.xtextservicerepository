package org.fornax.soa.bindingdsl.generator.templates.soap

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.logging.Level
import java.util.logging.Logger
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.binding.query.BindingResolver
import org.fornax.soa.binding.query.ProtocolMatcher
import org.fornax.soa.binding.query.services.ServiceRefBindingDescription
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.bindingdsl.generator.templates.IProtocolContractBuilder
import org.fornax.soa.bindingdsl.generator.templates.xsd.XSDTemplates
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.query.DefaultModuleServiceResolver
import org.fornax.soa.profiledsl.generator.templates.MessageHeaderXSDTemplates
import org.fornax.soa.profiledsl.query.LifecycleQueries
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.service.query.HeaderFinder
import org.fornax.soa.service.query.namespace.NamespaceImportQueries
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.generator.templates.webservice.WSDLTemplates
import org.fornax.soa.moduledsl.query.IModuleServiceResolver
import org.fornax.soa.binding.query.BindingLookup
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef
import org.fornax.soa.binding.query.services.BindingServiceQueries

/** 
 * Generates WSDLs and XSDs for SOAP based service endpoints 
 */
class SOAPProtocolContractBuilder implements IProtocolContractBuilder {
	
	@Inject extension NamespaceQuery
	@Inject extension BindingExtensions
	@Inject extension BindingServiceQueries
	@Inject extension BindingLookup
	@Inject extension NamespaceImportQueries
	@Inject extension HeaderFinder
	@Inject extension EnvironmentBindingResolver		
		
	
	@Inject WSDLTemplates 					wsdlGenerator
	@Inject XSDTemplates 					xsdGenerator
	@Inject ConcreteWsdlTemplates 			concreteWsdlGenerator
	@Inject MessageHeaderXSDTemplates 		msgHeaderGenerator
	@Inject BindingResolver					bindingResolver
	@Inject IQualifiedNameProvider			nameProvider
	@Inject ProtocolMatcher					protocolMatcher
	@Inject LifecycleQueries 				lifecycleQueries
	@Inject IModuleServiceResolver 			modServiceResolver
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	@Inject @Named ("forceRelativePaths") 		
	Boolean forceRelativePaths
	
	@Inject Logger log


	override buildServiceContracts (ModuleBinding binding, SOAProfile profile) {
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
							val minState = lifecycleQueries.getMinLifecycleState (binding.resolveEnvironment, profile.lifecycle)
									
							wsdlGenerator.toWSDL (svc, namespace, minState, profile, binding.getRegistryBaseUrl());
							concreteWsdlGenerator.toWSDL(binding, svc, soapProt, profile);
									
							if ( ! noDependencies) {
								val verNamespaces = svc.importedVersionedNS (minState);
								verNamespaces.forEach (n | xsdGenerator.toXSD(n, minState, binding, profile));
										
								val header = svc.findBestMatchingHeader (profile);
								if (forceRelativePaths)
									msgHeaderGenerator.toMessageHeaderXSD(header, profile, binding.getRegistryBaseUrl())
								else 
									msgHeaderGenerator.toMessageHeaderXSD(header, profile)
							}
						}
					}
				} catch (Exception ex) {
					log.log (Level::SEVERE, "Error generating contracts for service " + nameProvider.getFullyQualifiedName(svc).toString + " and version " + svc.version.version + "\n", ex)
				}
			}
		}
	}
	
	

	override buildProvidedServiceContracts (Module module, Environment targetEnvironment, EndpointQualifierRef providerEndpointQualifier, SOAProfile profile) {
		log.fine ("Generating WSDLs and XSDs for services provided by module " + module.name + " looking up binding for used module to environment " + targetEnvironment.name)
		val bindingDescs = 	if (providerEndpointQualifier != null) 
								bindingResolver.resolveCompatibleProvidedServiceBindings (module, targetEnvironment, providerEndpointQualifier)
							else
								bindingResolver.resolveCompatibleProvidedServiceBindings (module, targetEnvironment)
		for (specBindingDesc : bindingDescs) {
			val svc = specBindingDesc.resolvedService
			if (svc != null) {
				try {
					if (protocolMatcher.supportsImportBindingProtocol (specBindingDesc.applicableBinding, ImportBindingProtocol::SOAP)) {
						doBuildServiceContracts (specBindingDesc, profile)
					}
				} catch (Exception ex) {
					log.log (Level::SEVERE, "Error generating contracts for service " + nameProvider.getFullyQualifiedName (svc).toString + " and version " + svc.version.version + "\n", ex)
				}
			} else {
				log.severe ("Error generating contracts for service " + nameProvider.getFullyQualifiedName (specBindingDesc.serviceRef.service).toString + " and version " + specBindingDesc.serviceRef.service.version.version 
					+ " of module " + module.name +". Service could not be resolved for environment "+ targetEnvironment.name)
			}
		}
	}
	
	
	override buildUsedServiceContracts (Module module, Environment targetEnvironment, SOAProfile profile) {
		log.fine ("Generating WSDLs and XSDs for used services in module " + module.name + " looking up binding for used module to environment " + targetEnvironment.name)
		val bindingDescs = bindingResolver.resolveCompatibleUsedServiceBindings (module, targetEnvironment)
		for (specBindingDesc : bindingDescs) {
			val svc = specBindingDesc.resolvedService
			if (svc != null) {
				try {
					if (protocolMatcher.supportsImportBindingProtocol (specBindingDesc.applicableBinding, ImportBindingProtocol::SOAP)) {
						doBuildServiceContracts (specBindingDesc, profile)
					}
				} catch (Exception ex) {
					log.log (Level::SEVERE, "Error generating contracts for service " + nameProvider.getFullyQualifiedName (svc).toString + " and version " + svc.version.version + "\n", ex)
				}
			} else {
				log.severe ("Error generating contracts for service " + nameProvider.getFullyQualifiedName (specBindingDesc.serviceRef.service).toString + " and version " + specBindingDesc.serviceRef.service.version.version 
					+ " of module " + module.name +". Service could not be resolved for environment "+ targetEnvironment.name)
			}
		}
	}
	
	
	def protected doBuildServiceContracts (ServiceRefBindingDescription serviceBindingDescription, SOAProfile profile) {
		val service = serviceBindingDescription.serviceRef.service
		val specBinding = serviceBindingDescription.applicableBinding
		for (soapProt : specBinding.protocol.filter (p| p instanceof SOAP).map (e| e as SOAP)) {
			try {
				if (service.providedContractUrl == null && service.isEligibleForEnvironment (specBinding.resolveEnvironment)) {
					val namespace = service.findSubdomain();
					val minState = lifecycleQueries.getMinLifecycleState (specBinding.resolveEnvironment, profile.lifecycle)
							
					wsdlGenerator.toWSDL (service, namespace, minState, profile, specBinding.getRegistryBaseUrl());
					concreteWsdlGenerator.toWSDL(specBinding, service, soapProt, profile);
							
					if ( ! noDependencies) {
						val verNamespaces = service.importedVersionedNS (minState);
						verNamespaces.forEach (n | xsdGenerator.toXSD(n, minState, specBinding, profile));
								
						val header = service.findBestMatchingHeader (profile);
						if (forceRelativePaths)
							msgHeaderGenerator.toMessageHeaderXSD(header, profile, specBinding.getRegistryBaseUrl())
						else 
							msgHeaderGenerator.toMessageHeaderXSD(header, profile)
					}
				}
			} catch (Exception ex) {
				log.log (Level::SEVERE, "Error generating contracts for service " + nameProvider.getFullyQualifiedName(service).toString + " and version " + service.version.version + "\n", ex)
			}
		}
	}

	
	override buildTypeDefinitions (SubNamespace namespace, Environment env, SOAProfile profile) {
		log.fine ("Generating XSDs for namespace " + nameProvider.getFullyQualifiedName(namespace).toString)
		xsdGenerator.toXSD (namespace, env, profile);
	}

	
	override buildTypeDefinitions (VersionedDomainNamespace namespace, Environment env, SOAProfile profile) {
		log.fine ("Generating XSD for namespace " + namespace.fqn + " with major version " + namespace.version)
		xsdGenerator.toXSD (namespace, env, profile);
	}
	
}