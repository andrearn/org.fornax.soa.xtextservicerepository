package org.fornax.soa.bindingdsl.generator.templates

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.HashSet
import java.util.List
import org.fornax.soa.basedsl.generator.CommonStringExtensions
import org.fornax.soa.basedsl.generator.lifecycle.StateMatcher
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingModel
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingdsl.generator.queries.services.BoundServiceLookup
import org.fornax.soa.bindingdsl.generator.queries.modules.ModuleBindingResolver
import org.fornax.soa.bindingdsl.generator.queries.services.BindingServiceResolver
import org.fornax.soa.bindingdsl.generator.templates.soap.ConcreteProviderWsdlTemplates
import org.fornax.soa.bindingdsl.generator.templates.soap.ConcreteWsdlTemplates
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.profiledsl.generator.templates.MessageHeaderXSDTemplates
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.generator.domain.NamespaceSplitter
import org.fornax.soa.servicedsl.generator.query.ServiceFinder
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceImportQueries
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery
import org.fornax.soa.servicedsl.generator.templates.ServiceTemplates
import org.fornax.soa.servicedsl.generator.templates.xsd.EventXSDTemplates
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.XSDTemplates

class BindingTemplates {
	
	
	@Inject extension NamespaceQuery
	@Inject extension CommonStringExtensions
	@Inject extension ServiceFinder
	@Inject extension BindingExtensions
	@Inject extension StateMatcher
	@Inject extension NamespaceSplitter
	@Inject extension NamespaceImportQueries
	@Inject extension org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension BindingServiceResolver
	@Inject extension ModuleBindingResolver
		
	
	@Inject XSDTemplates 					xsdGenerator
	@Inject ServiceTemplates 				serviceGenerator
	@Inject EventXSDTemplates 				eventXsdGenerator
	@Inject ConcreteWsdlTemplates 			concreteWsdlGenerator
	@Inject ConcreteProviderWsdlTemplates 	concreteProviderWsdlGenerator
	@Inject MessageHeaderXSDTemplates 		msgHeaderGenerator
	@Inject BoundServiceLookup				serviceLookup
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
		
	def main (BindingModel model, LifecycleState minState, SOAProfile profile) {
		model.bindings.forEach (b|b.toBinding (minState, profile));
	}
	
	
	/*
		ENTRYPOINT for generation of concrete and imported abstract WSDLs and their required XSDs 
		for a given DomainBinding. The DomainBinding binds all Services in a given SubNamespace 
		to a certain Environment.<br/>
		
		All Services and their required XSDs that match the minimal LifecycleState of environment
		referenced by the DomainBinding are considered. Overrides of minimal LifecycleStates 
		declared in SubNamespaces will be respected
	*/
	def dispatch void toBinding (DomainBinding binding, SOAProfile profile) {
		binding.toBinding ( binding.environment.getMinLifecycleState (binding), profile);
	}
	
	
	/*
		ENTRYPOINT for generation of concrete and imported abstract WSDLs and their required XSDs 
		for a given DomainBinding. The DomainBinding binds all Services in a given SubNamespace 
		to a certain Environment.<br/>
		
		All Services and their required XSDs that match the minimal given LifecycleState are 
		considered
	*/
	def dispatch void toBinding (DomainBinding binding, LifecycleState minState, SOAProfile profile) {
		for (verNs : binding.subNamespace.toVersionedDomainNamespaces()) {
			val services = verNs.servicesWithMinState (minState).filter (typeof (Service)).filter (e|e.isLatestMatchingService (verNs.version.asInteger(), minState));
			for (svc : services) {
				binding.getMostSpecificBinding (svc).toBindingByService (svc, profile);
			}
		}

		serviceGenerator.toSubNamespace (binding.subNamespace, binding.environment.getMinLifecycleState (binding.subNamespace), profile, binding.getRegistryBaseUrl());
		if (! noDependencies ) {
			val namespaces = new HashSet<SubNamespace>();
			namespaces.add (binding.subNamespace);
			namespaces.addAll (binding.subNamespace.getImportedSubdomains().getAllLatestSubNamespacesByMajorVersion().map (e|e.subdomain as SubNamespace));
			for (ns : namespaces) {
				xsdGenerator.toXSD (ns, binding.environment.getMinLifecycleState(ns), profile, binding.getRegistryBaseUrl());
			}
			if (forceRelativePaths()) {
				msgHeaderGenerator.toMessageHeaderXSD (profile);
			} else {
				msgHeaderGenerator.toMessageHeaderXSD (profile, binding.getRegistryBaseUrl());
			}
		}
	}
	
	
	def dispatch toBindingByService(Binding binding, Service s, SOAProfile profile) {
		print("Unexpected Bining type " + binding.eClass.name);
	}
	
	
	/*
		Generate a concrete WSDL for the given Service defining a binding to the 
		publishing server, i.e. usually an ESB.
		The WSDL references an abstract WSDL defining the interface / porttype.<br/>
		
		If generation of concrete WSDL for private services bound providing servers is enable,
		generate a concrete WSDL for the private sevrice
	*/
	def dispatch void toBindingByService (DomainBinding binding, Service s, SOAProfile profile) {
		if (generatePrivateWsdlForProviderHost()) {
			for (prot : binding.getProviderProtocols().filter (typeof (SOAP)).filter (e|e.providedWsdlUrl == null && e.provider != null)) {
				concreteProviderWsdlGenerator.toWSDL (s, binding, prot, profile);
			}
		}
		for (prot : binding.getPublisherProtocols().filter (typeof (SOAP)) ) {
			if (binding.subNamespace instanceof DomainNamespace) {
				concreteWsdlGenerator.toWSDL (s, binding, prot, profile);
			}
		}
	}
	
	
	/*
		Generate a concrete WSDL for the given Service defining a binding to the 
		publishing server, i.e. usually an ESB.
		The WSDL references an abstract WSDL defining the interface / porttype.
		
		If generation of concrete WSDL for private services bound providing servers is enable,
		generate a concrete WSDL for the private sevrice
	*/
	def dispatch void toBindingByService (ServiceBinding binding, Service s, SOAProfile profile) {
		if (generatePrivateWsdlForProviderHost()) {
			for (prot : binding.getProviderProtocols().filter (typeof (SOAP)).filter (e|e.providedWsdlUrl == null && e.provider != null)) {
				concreteProviderWsdlGenerator.toWSDL (s, binding, prot, profile);
			}
		}
		for (prot : binding.getPublisherProtocols().filter (typeof (SOAP))) {
			if ((binding.eContainer as DomainBinding).subNamespace instanceof DomainNamespace) {
				concreteWsdlGenerator.toWSDL (s, binding, prot, profile);
			}
		}
	}
	
	
	
	/*
		ENTRYPOINT for generation of concrete and imported abstract WSDLs and their required XSDs 
		for all ModuleBindings to an Environment with the given name. The ModuleBinding binds all 
		Services provided by the module	to a certain Environment. Generates artifacts for all ModuleBindings
		that target an Environment matching the given environment name.
		
		All Services referenced by the Module and their required XSDs that match the minimal given 
		LifecycleState derived from the given Environment and the minimal required LifecycleState 
		of the respective Service / owning SubNamespace
	*/
	def toBindModulesToEnvorinment (List<ModuleBinding> bindings, SOAProfile profile, String targetEnvironmentName) {
		for (modBind : bindings.filter (e|e.environment.name==targetEnvironmentName)) {
			val environment = modBind.environment;
			for (provSvc : modBind.module.module.providedServices) {
				val svc = provSvc.latestServiceInEnvironment (environment);
				if (svc != null) {
					modBind.toBindingByService (svc, modBind.getMostSpecificBinding (svc), profile);
					serviceGenerator.toSubNamespace (svc.findSubdomain(), svc.findSubdomain().minStateByEnvironment (environment), profile, modBind.getRegistryBaseUrl());

					if ( ! noDependencies ) {
						val namespaces = new HashSet<SubNamespace>();
						namespaces.add (svc.findSubdomain());
						namespaces.addAll (svc.findSubdomain().getImportedSubdomains().getAllLatestSubNamespacesByMajorVersion().map (vns|vns.subdomain as SubNamespace));
						for (ns : namespaces) {
							xsdGenerator.toXSD (ns, ns.minStateByEnvironment (environment), profile, modBind.getRegistryBaseUrl());
						}
						if (forceRelativePaths()) {
							msgHeaderGenerator.toMessageHeaderXSD (profile);
						} else {
							msgHeaderGenerator.toMessageHeaderXSD (profile, modBind.getRegistryBaseUrl());
						}
					}
				}
			}
		}
	}
	
	def toBindModulesToEnvironment (List<ModuleBinding> bindings, SOAProfile profile, String targetEnvironmentName) {
		for (modBind : bindings.filter (e|e.environment.name==targetEnvironmentName)) {
			val environment = modBind.environment;
			for (provSvc : modBind.module.module.providedServices) {
				val svc = provSvc.latestServiceInEnvironment (environment);
					if (svc != null) {
						modBind.toBindingByService (svc, modBind.getMostSpecificBinding (svc), profile);
						serviceGenerator.toSubNamespace (svc.findSubdomain(), svc.findSubdomain().minStateByEnvironment (environment), profile, modBind.getRegistryBaseUrl());
						
						if ( ! noDependencies ) {
							val namespaces = new HashSet<SubNamespace>();
							namespaces.add (svc.findSubdomain());
							namespaces.addAll (svc.findSubdomain().getImportedSubdomains().getAllLatestSubNamespacesByMajorVersion().map (vns|vns.subdomain as SubNamespace));
							for (ns : namespaces) {
								xsdGenerator.toXSD (ns, ns.minStateByEnvironment (environment), profile, modBind.getRegistryBaseUrl());
							}
							if (forceRelativePaths()) {
								msgHeaderGenerator.toMessageHeaderXSD (profile);
							} else {
								msgHeaderGenerator.toMessageHeaderXSD (profile, modBind.getRegistryBaseUrl());
							}
						}
					}
				
			}
		}
	}
	
	def toBindImportModulesToEnvironment (List<ModuleBinding> bindings, SOAProfile profile, String targetEnvironmentName) {
		for (modBind : bindings.filter (e|e.environment.name==targetEnvironmentName)) {
			val environment = modBind.environment;
			for (usedSvc : modBind.module.module.usedServices) {
				val svc 		= usedSvc.latestServiceInEnvironment (environment);
				val impBind 	= bindings.getImportModuleBinding (usedSvc.module.module, targetEnvironmentName);
				if (svc != null) {
					impBind.toBindingByService (svc, impBind.getMostSpecificBinding (svc), profile);
					serviceGenerator.toSubNamespace (svc.findSubdomain(), svc.findSubdomain().minStateByEnvironment (environment), profile, impBind.getRegistryBaseUrl());

					if ( ! noDependencies ) {
						var namespaces = new HashSet<SubNamespace>();
						namespaces.add (svc.findSubdomain());
						namespaces.addAll (svc.findSubdomain().getImportedSubdomains().getAllLatestSubNamespacesByMajorVersion().map (vns|vns.subdomain as SubNamespace));
						for (ns : namespaces) {
							xsdGenerator.toXSD (ns, ns.minStateByEnvironment (environment), profile, impBind.getRegistryBaseUrl());
						}
						if (forceRelativePaths()) {
							msgHeaderGenerator.toMessageHeaderXSD (profile);
						} else {
							msgHeaderGenerator.toMessageHeaderXSD (profile, impBind.getRegistryBaseUrl());
						}
					}
				}
			}
		}
	}
	
	/*
		ENTRYPOINT for generation of concrete and imported abstract WSDLs and their required XSDs 
		for a given ModuleBinding. The ModuleBinding binds all Services provided by the module 
		to a certain Environment.
		
		All Services referenced by the Module and their required XSDs that match the minimal given 
		LifecycleState derived from the given Environment and the minimal required LifecycleState 
		of the respective Service / owning SubNamespace
	*/
	def dispatch toBinding (ModuleBinding binding, List<SOAProfile> profiles, String profileName) {
		binding.toBinding (profiles.findFirst (e|e.name == profileName));
	}
	
	def dispatch toBinding (ModuleBinding binding, SOAProfile profile) {
		for (provSvc : binding.module.module.providedServices) {
			val environment = binding.environment;
			val svc = provSvc.latestServiceInEnvironment (environment);
			if (svc != null) {
				binding.toBindingByService (svc, binding.getMostSpecificBinding (svc), profile);
				serviceGenerator.toSubNamespace (svc.findSubdomain(), svc.findSubdomain().minStateByEnvironment (environment), profile, binding.getRegistryBaseUrl());

				if ( ! noDependencies ) {
					var namespaces = new HashSet<SubNamespace>();
					namespaces.add (svc.findSubdomain());
					namespaces.addAll (svc.findSubdomain().getImportedSubdomains().getAllLatestSubNamespacesByMajorVersion().map (vns|vns.subdomain as SubNamespace));
					for (ns : namespaces) {
						xsdGenerator.toXSD (ns, ns.minStateByEnvironment (environment), profile, binding.getRegistryBaseUrl());
					}
					if (forceRelativePaths()) {
						msgHeaderGenerator.toMessageHeaderXSD (profile);
					} else {
						msgHeaderGenerator.toMessageHeaderXSD (profile, binding.getRegistryBaseUrl());
					}
				}
			}
		}
	}
	
	def toBinding (ModuleBinding binding, SOAProfile profile, boolean noDeps, boolean includeSubNamespaces) {
		for (provSvc : binding.module.module.providedServices) {
			val environment = binding.environment;
			val svc = provSvc.latestServiceInEnvironment (environment);
			if (svc != null) {
				binding.toBindingByService (svc, binding.getMostSpecificBinding (svc), profile);
				serviceGenerator.toSubNamespace (svc.findSubdomain(), svc.findSubdomain().minStateByEnvironment (environment), profile, binding.getRegistryBaseUrl());

				if ( ! noDependencies ) {
					if (noDeps) {
						val ns = svc.findSubdomain();
						xsdGenerator.toXSD (svc.findSubdomain(), ns.minStateByEnvironment (environment), profile, binding.getRegistryBaseUrl(), noDeps, includeSubNamespaces) ;
					} else {
						var namespaces = new HashSet<SubNamespace>();	
						namespaces.add (svc.findSubdomain());
						namespaces.addAll (svc.findSubdomain().getImportedSubdomains().getAllLatestSubNamespacesByMajorVersion().map (vns|vns.subdomain as SubNamespace));
						for (ns : namespaces) {
							xsdGenerator.toXSD (ns, ns.minStateByEnvironment (environment), profile, binding.getRegistryBaseUrl(), noDeps, includeSubNamespaces);
						}
						if (forceRelativePaths()) {
							msgHeaderGenerator.toMessageHeaderXSD (profile);
						} else {
							msgHeaderGenerator.toMessageHeaderXSD (profile, binding.getRegistryBaseUrl());
						}
					}
				}
			}
		}
	}
	
	def toBindingByService (ModuleBinding binding, Service s, Binding specificBinding, SOAProfile profile) {
		for (prot : specificBinding.protocol) {
			if (prot instanceof SOAP) {
				val soapProt = prot as SOAP;
					if (s.providedContractUrl == null && s.isEligibleForEnvironment (binding.environment)) {
						if (s.isPublicEndpoint (binding.provider.provServer)) {
							concreteWsdlGenerator.toWSDL(binding, s, prot, profile);
						} else {
							concreteProviderWsdlGenerator.toWSDL(s, binding, prot, profile);
						}
					}
			}
		}
	}
	
	
	def toBindingByServiceName (DomainBinding binding, List<String> serviceNames, SOAProfile profile) {
	
		if (generatePrivateWsdlForProviderHost()) {
			for (prot : binding.getProviderProtocols().filter (typeof (SOAP)).filter (e|e.providedWsdlUrl == null && e.provider != null)) {
				concreteProviderWsdlGenerator.toWSDLByServiceName (binding, serviceNames, prot, profile);
			}
		}
		for (prot : binding.getPublisherProtocols().filter (typeof (SOAP))) {
			if (binding.subNamespace instanceof DomainNamespace) {
				concreteWsdlGenerator.toWSDLByServiceName (binding, serviceNames, prot, profile);
			}
		}
		var namespaces = new HashSet<SubNamespace>();
		namespaces.add (binding.subNamespace);
		namespaces.addAll (binding.subNamespace.getImportedSubdomains().map (vns|vns.subdomain as SubNamespace));
		for (ns : namespaces) {
			xsdGenerator.toXSD (ns, binding.environment.getMinLifecycleState(ns), profile, binding.getRegistryBaseUrl());
		}
		serviceGenerator.toSubNamespace (binding.subNamespace, binding.environment.getMinLifecycleState(binding.subNamespace), profile, binding.getRegistryBaseUrl());
		msgHeaderGenerator.toMessageHeaderXSD (profile, binding.getRegistryBaseUrl());
	
	}
	
		
	/*
		Event XSDs for Services having an request and an response event for each service operation
	*/
	def toEventsInclSubNamespaces (String namespaceName, List<SubNamespace> namespaces, List<Environment> environments, String targetEnv, List<SOAProfile> profiles, String profileName) {
		for (ns : namespaces.filter (e|e.name.startsWith (namespaceName))) {
			ns.toEvents (environments, targetEnv, profiles, profileName);
		}
	}
	
	def toEvents (SubNamespace ns, List<Environment> environments, String targetEnv, List<SOAProfile> profiles, String profileName) { 
		val env = environments.findFirst (e|e.name == targetEnv);
		eventXsdGenerator.toEvents (ns,env.getMinLifecycleState(ns), profiles.findFirst (e|e.name == profileName), env.getRegistryBaseUrl());
	}
	
}