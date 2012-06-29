package org.fornax.soa.bindingdsl.generator.templates.soap

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.HashSet
import org.fornax.soa.basedsl.generator.CommonStringExtensions
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingdsl.generator.queries.modules.ModuleBindingResolver
import org.fornax.soa.bindingdsl.generator.queries.services.BindingServiceResolver
import org.fornax.soa.bindingdsl.generator.queries.services.BoundServiceLookup
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.bindingdsl.generator.templates.IProtocolContractBuilder
import org.fornax.soa.bindingdsl.generator.templates.xsd.EventXSDTemplates
import org.fornax.soa.bindingdsl.generator.templates.xsd.XSDTemplates
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.profiledsl.generator.templates.MessageHeaderXSDTemplates
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.servicedsl.generator.domain.NamespaceSplitter
import org.fornax.soa.servicedsl.generator.query.HeaderFinder
import org.fornax.soa.servicedsl.generator.query.ServiceFinder
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceImportQueries
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery
import org.fornax.soa.servicedsl.generator.query.type.ReferencedTypesFinder
import org.fornax.soa.servicedsl.generator.templates.ServiceTemplates
import org.fornax.soa.servicedsl.generator.templates.webservice.WSDLTemplates
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions
import java.util.List
import java.util.Set
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.bindingdsl.generator.queries.environment.EnvironmentBindingResolver
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.moduledsl.generator.query.ModuleServiceResolver
import org.fornax.soa.bindingdsl.generator.templates.BindingResolver
import java.util.logging.Logger
import org.eclipse.xtext.naming.IQualifiedNameProvider

/* 
 * Generates WSDLs and XSDs for SOAP based service endpoints 
 */
class SOAPProtocolContractBuilder implements IProtocolContractBuilder {
	
	@Inject extension NamespaceSplitter
	@Inject extension NamespaceQuery
	@Inject extension CommonStringExtensions
	@Inject extension ServiceFinder
	@Inject extension BindingExtensions
	@Inject extension NamespaceImportQueries
	@Inject extension org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension BindingServiceResolver
	@Inject extension ModuleBindingResolver
	@Inject extension ReferencedTypesFinder
	@Inject extension HeaderFinder
	@Inject extension EnvironmentBindingResolver		
		
	
	@Inject WSDLTemplates 					wsdlGenerator
	@Inject XSDTemplates 					xsdGenerator
	@Inject org.fornax.soa.servicedsl.generator.templates.xsd.XSDTemplates 		serviceDslXsdGenerator
	@Inject ServiceTemplates 				serviceGenerator
	@Inject EventXSDTemplates 				eventXsdGenerator
	@Inject ConcreteWsdlTemplates 			concreteWsdlGenerator
	@Inject ConcreteProviderWsdlTemplates 	concreteProviderWsdlGenerator
	@Inject MessageHeaderXSDTemplates 		msgHeaderGenerator
	@Inject BoundServiceLookup				serviceLookup
	@Inject ModuleServiceResolver			modServiceResolver
	@Inject BindingResolver					bindingResolver
	@Inject IQualifiedNameProvider			nameProvider

	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	@Inject @Named ("forceRelativePaths") 		
	Boolean forceRelativePaths

	@Inject @Named ("generatePrivateWsdlForProviderHost") 
	Boolean generatePrivateWsdlForProviderHost
	
	@Inject Logger log


	override buildServiceContracts (ModuleBinding binding, SOAProfile profile) {
		log.fine ("Generating WSDLs and XSDs for binding " + binding.name)
		val provNamespaces = binding.module.module.providedNamespaces;
		var Set<Service> services = serviceLookup.getAllProvidedServices (binding, profile);

		for (svc : services) {
			if (svc != null) {
				try {
					val specBinding = binding.getMostSpecificBinding (svc);
					for (soapProt : specBinding.protocol.filter (p| p instanceof SOAP).map (e| e as SOAP)) {
						if (svc.providedContractUrl == null && svc.isEligibleForEnvironment (binding.environment)) {
							val namespace = svc.findSubdomain();
									
							wsdlGenerator.toWSDL (svc, namespace, namespace.minStateByEnvironment (binding.environment, profile.lifecycle), profile, binding.getRegistryBaseUrl());
									
							if (svc.isProviderEndpoint (binding.provider.provServer)) {
								concreteProviderWsdlGenerator.toWSDL(svc, binding, soapProt, profile);
							} else {
								concreteWsdlGenerator.toWSDL(binding, svc, soapProt, profile);
							}
									
							if ( ! noDependencies) {
								val verNamespaces = svc.importedVersionedNS (namespace.minStateByEnvironment (binding.environment, profile.lifecycle));
								verNamespaces.forEach (n | xsdGenerator.toXSD(n, namespace.minStateByEnvironment (binding.environment, profile.lifecycle), binding, profile));
										
								val header = svc.findBestMatchingHeader (profile);
								if (forceRelativePaths)
									msgHeaderGenerator.toMessageHeaderXSD(header, profile, binding.getRegistryBaseUrl())
								else 
									msgHeaderGenerator.toMessageHeaderXSD(header, profile)
							}
						}
					}
				} catch (Exception ex) {
					log.severe ("Error generating contracts for service " + nameProvider.getFullyQualifiedName(svc).toString + " and version " + svc.version.version + "\n" +ex.message)
				}
			}
		}
	}
	
	
	override buildServiceContracts (DomainBinding binding, SOAProfile profile) {
		log.fine ("Generating WSDLs and XSDs for binding " + binding.name)
		val namespace = binding.subNamespace;
		val minState = binding.environment.getMinLifecycleState (binding, profile.lifecycle);		
		var verNamespaces = new HashSet<VersionedDomainNamespace>();
		var headers = new HashSet<MessageHeader>();
		
		for (verNs : binding.subNamespace.toVersionedDomainNamespaces()) {
			val services = verNs.servicesWithMinState (minState).filter (typeof (Service)).filter (e|e.isLatestMatchingService (verNs.version.asInteger(), minState));

			for (svc : services) {
				try {
					val specBinding = binding.getMostSpecificBinding (svc);
					val soapProviderEndpoints = specBinding.getProviderProtocols().filter (p| p instanceof SOAP).map (e| e as SOAP);
					val soapPublisherEndpoints = specBinding.getPublisherProtocols().filter (p| p instanceof SOAP).map (e| e as SOAP);
					
					if (! (soapPublisherEndpoints.empty && soapProviderEndpoints.empty)) {
						wsdlGenerator.toWSDL (svc, namespace, namespace.minStateByEnvironment (binding.environment, profile.lifecycle), profile, binding.getRegistryBaseUrl());
					}
					
					if (! soapPublisherEndpoints.empty) {	
						concreteWsdlGenerator.toWSDL (svc, binding, soapPublisherEndpoints.head, profile);
					}
	
					if (generatePrivateWsdlForProviderHost) {
						for (p : soapProviderEndpoints.filter (e|e.providedWsdlUrl == null && e.provider != null)) {
							concreteProviderWsdlGenerator.toWSDL (svc, binding, soapProviderEndpoints.head, profile);
						}
					}
					if (! (soapPublisherEndpoints.empty && soapProviderEndpoints.empty)) {
						verNamespaces.addAll (svc.importedVersionedNS (namespace.minStateByEnvironment (binding.environment, profile.lifecycle)));
						headers.add (svc.findBestMatchingHeader (profile));
					}
				} catch (Exception ex) {
					log.severe ("Error generating contracts for service " + nameProvider.getFullyQualifiedName(svc).toString + " and version " + svc.version.version + "\n" +ex.message)
				}
			}
		}
		
		if (! noDependencies ) {
			verNamespaces.forEach (n | xsdGenerator.toXSD (n, namespace.minStateByEnvironment (binding.environment, profile.lifecycle), binding, profile));
					
			if (forceRelativePaths)
				headers.forEach (header | msgHeaderGenerator.toMessageHeaderXSD (header, profile, binding.getRegistryBaseUrl()))
			else 
				headers.forEach (header | msgHeaderGenerator.toMessageHeaderXSD (header, profile, binding.getRegistryBaseUrl()))
		}
	}

	override buildUsedServiceContracts (Module module, Environment targetEnvironment, SOAProfile profile) {
		log.fine ("Generating WSDLs and XSDs for used services in module " + module.name + " looking up binding for used module to environment " + targetEnvironment.name)
		val Set<Service> services = serviceLookup.getAllUsedServicesWithProtocol (module, targetEnvironment, ImportBindingProtocol::SOAP, profile);
		val moduleRefs = module.usedModules
		val serviceRefs = module.usedServices
		for (svcRef : serviceRefs) {
			if (services.contains(svcRef.service)) {
				val svc = svcRef.service
				try {
					val qualifier = modServiceResolver.getQualifier(svcRef)
					val canditateModules = svcRef.modules.map (m|m.module)
					val bindings = svc.resolveServiceBinding (targetEnvironment, ImportBindingProtocol::SOAP, canditateModules, qualifier)
					
					for (specBinding : bindings) {
						doBuildServiceContracts(svc, specBinding, profile)
					}
				} catch (Exception ex) {
					log.severe ("Error generating contracts for service " + nameProvider.getFullyQualifiedName(svc).toString + " and version " + svc.version.version + "\n" +ex.message)
				}
			}
		}
		for (modRef : moduleRefs) {
			val modRefServices = modRef.moduleRef.module.providedServices
			val exclServices = modRef.excludedServices.map(s|s.service)
			
			for (Service svc : modRefServices.map (e|e.service).filter(typeof(Service))) {
				if (!exclServices.contains(svc)) {
					val qualifier = modServiceResolver.getQualifier(modRef)
					val Set<Module> canditateModules = newHashSet()
					canditateModules.add (modRef.moduleRef.module)
					val bindings = svc.resolveServiceBinding (targetEnvironment, ImportBindingProtocol::SOAP, canditateModules, qualifier)
					
					for (specBinding : bindings) {
						doBuildServiceContracts(svc, specBinding, profile)
					}
				}
			}
		}
	}
	
	def protected doBuildServiceContracts (Service service, Binding specBinding, SOAProfile profile) {
		for (soapProt : specBinding.protocol.filter (p| p instanceof SOAP).map (e| e as SOAP)) {
			try {
				if (service.providedContractUrl == null && service.isEligibleForEnvironment (specBinding.resolveEnvironment)) {
					val namespace = service.findSubdomain();
							
					wsdlGenerator.toWSDL (service, namespace, namespace.minStateByEnvironment (specBinding.resolveEnvironment, profile.lifecycle), profile, specBinding.getRegistryBaseUrl());
	
					if (service.isProviderEndpoint (specBinding.resolveServer(soapProt))) {
						concreteProviderWsdlGenerator.toWSDL(service, specBinding, soapProt, profile);
					} else {
						concreteWsdlGenerator.toWSDL(specBinding, service, soapProt, profile);
					}
							
					if ( ! noDependencies) {
						val verNamespaces = service.importedVersionedNS (namespace.minStateByEnvironment (specBinding.resolveEnvironment, profile.lifecycle));
						verNamespaces.forEach (n | xsdGenerator.toXSD(n, namespace.minStateByEnvironment (specBinding.resolveEnvironment, profile.lifecycle), specBinding, profile));
								
						val header = service.findBestMatchingHeader (profile);
						if (forceRelativePaths)
							msgHeaderGenerator.toMessageHeaderXSD(header, profile, specBinding.getRegistryBaseUrl())
						else 
							msgHeaderGenerator.toMessageHeaderXSD(header, profile)
					}
				}
			} catch (Exception ex) {
				log.severe ("Error generating contracts for service " + nameProvider.getFullyQualifiedName(service).toString + " and version " + service.version.version + "\n" +ex.message)
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