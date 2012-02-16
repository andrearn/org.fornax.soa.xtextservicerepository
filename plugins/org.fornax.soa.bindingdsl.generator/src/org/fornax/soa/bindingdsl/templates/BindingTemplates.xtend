package org.fornax.soa.bindingdsl.templates

import com.google.inject.Inject
import java.util.HashSet
import java.util.List
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.basedsl.lifecycle.StateMatcher
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingModel
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingdsl.templates.soap.ConcreteProviderWsdlTemplates
import org.fornax.soa.bindingdsl.templates.soap.ConcreteWsdlTemplates
import org.fornax.soa.environmentdsl.generator.EndpointResolver
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.domain.NamespaceSplitter
import org.fornax.soa.servicedsl.query.ServiceFinder
import org.fornax.soa.servicedsl.query.namespace.NamespaceImportQueries
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery
import org.fornax.soa.servicedsl.templates.ServiceTemplates
import org.fornax.soa.servicedsl.templates.xsd.EventXSDTemplates
import org.fornax.soa.servicedsl.templates.xsd.MessageHeaderXSDTemplates
import org.fornax.soa.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.servicedsl.templates.xsd.SchemaTypeExtensions
import org.fornax.soa.servicedsl.templates.xsd.XSDTemplates
import org.fornax.soa.bindingdsl.queries.services.BindingServiceResolver
import org.fornax.soa.bindingdsl.queries.modules.ModuleBindingResolver
import org.fornax.soa.environmentDsl.Environment

class BindingTemplates {
	
	
	@Inject extension NamespaceQuery
	@Inject extension CommonStringExtensions
	@Inject extension ServiceFinder
	@Inject extension BindingExtensions
	@Inject extension StateMatcher
	@Inject extension NamespaceSplitter
	@Inject extension NamespaceImportQueries
	@Inject extension SchemaNamespaceExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension BindingServiceResolver
	@Inject extension ModuleBindingResolver
		
	
	@Inject XSDTemplates 					xsdGenerator
	@Inject ServiceTemplates 				serviceGenerator
	@Inject EventXSDTemplates 				eventXsdGenerator
	@Inject ConcreteWsdlTemplates 			concreteWsdlGenerator
	@Inject ConcreteProviderWsdlTemplates 	concreteProviderWsdlGenerator
	@Inject MessageHeaderXSDTemplates 		msgHeaderGenerator
	
		
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
	def dispatch toBinding (DomainBinding binding, SOAProfile profile) {
		binding.toBinding ( binding.environment.getMinLifecycleState (binding), profile);
	}
	
	
	/*
		ENTRYPOINT for generation of concrete and imported abstract WSDLs and their required XSDs 
		for a given DomainBinding. The DomainBinding binds all Services in a given SubNamespace 
		to a certain Environment.<br/>
		
		All Services and their required XSDs that match the minimal given LifecycleState are 
		considered
	*/
	def dispatch toBinding (DomainBinding binding, LifecycleState minState, SOAProfile profile) {
		for (verNs : binding.subNamespace.toVersionedDomainNamespaces()) {
			val services = verNs.servicesWithMinState (minState).filter (typeof (Service)).filter (e|e.isLatestMatchingService(verNs.version.asInteger(), minState));
			for (svc : services) {
				binding.getMostSpecificBinding (svc).toBindingByService (svc, profile);
			}
		}
		serviceGenerator.toSubNamespace (binding.subNamespace, binding.environment.getMinLifecycleState (binding.subNamespace), profile, binding.getRegistryBaseUrl());
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
	
	def toBindModulesToEnvironment (List<ModuleBinding> bindings, SOAProfile profile, String targetEnvironmentName) {
		for (modBind : bindings.filter (e|e.environment.name==targetEnvironmentName)) {
			val environment = modBind.environment;
			for (provSvc : modBind.module.module.providedServices) {
				val svc = provSvc.latestServiceInEnvironment (environment);
					if (svc != null) {
						modBind.toBindingByService (svc, modBind.getMostSpecificBinding (svc), profile);
						serviceGenerator.toSubNamespace (svc.findSubdomain(), svc.findSubdomain().minStateByEnvironment (environment), profile, modBind.getRegistryBaseUrl());
						
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
	def toBindImportModulesToEnvironment (List<ModuleBinding> bindings, SOAProfile profile, String targetEnvironmentName) {
		for (modBind : bindings.filter (e|e.environment.name==targetEnvironmentName)) {
			val environment = modBind.environment;
			for (usedSvc : modBind.module.module.usedServices) {
				val svc 		= usedSvc.latestServiceInEnvironment (environment);
				val impBind 	= bindings.getImportModuleBinding (usedSvc.module.module, targetEnvironmentName);
				if (svc != null) {
					impBind.toBindingByService (svc, impBind.getMostSpecificBinding (svc), profile);
					serviceGenerator.toSubNamespace (svc.findSubdomain(), svc.findSubdomain().minStateByEnvironment (environment), profile, impBind.getRegistryBaseUrl());
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
	
	def toBinding (ModuleBinding binding, SOAProfile profile, boolean noDeps, boolean includeSubNamespaces) {
		for (provSvc : binding.module.module.providedServices) {
			val environment = binding.environment;
			val svc = provSvc.latestServiceInEnvironment (environment);
			if (svc != null) {
				binding.toBindingByService (svc, binding.getMostSpecificBinding (svc), profile);
				serviceGenerator.toSubNamespace (svc.findSubdomain(), svc.findSubdomain().minStateByEnvironment (environment), profile, binding.getRegistryBaseUrl());
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
	
	
	
	def toXSD (SubNamespace ns, List<Environment> env, String targetEnv, List<SOAProfile> profiles, String profileName) {
		ns.toXSD (env.findFirst (e|e.name == targetEnv), profiles.findFirst (e|e.name == profileName));
	}
	
	
	def dispatch toXSD (SubNamespace ns, Environment env, SOAProfile profile) {
		xsdGenerator.toXSD (ns, env.getMinLifecycleState (ns), profile, env.getRegistryBaseUrl());
	}
	
	/*
		ENTRYPOINT for generation of XSDs for a given DomainBinding. 
		
		An XSD for each VersionedDomainNamespace derived from the given SubNamespace. 
		VersionedDomainNamespaces are derived using the major version based splitting algorithm 
		constrained by the given LifecycleState.
		
		All VersionedDomainNamespaces that contain VerisonedTypes or Exceptions that match 
		the minimal LifecycleState required for the environment	referenced by the given DomainBinding 
		are considered. Overrides of minimal LifecycleStates declared in SubNamespaces 
		will be respected.
		
		If there exits no DomainBinding for the given SubNamespace any DomainBinding to the targeted
		Environment can be chosen.
	*/
	def dispatch void toXSD (SubNamespace ns, DomainBinding bind, SOAProfile profile) {
		ns.toXSD (bind.environment.getMinLifecycleState (ns), bind, profile);
	}
	
	/*
		<b>ENTRYPOINT</b> for generation of <b>XSD</b>s for a given DomainBinding. <br/><br/>
		
		An XSD for each VersionedDomainNamespace derived from the given SubNamespace 
		by the given DomainBinding. VersionedDomainNamespaces are derived using the 
		major version based splitting algorithm constrained by the given LifecycleState.<br/><br/>
		
		All VersionedDomainNamespaces that contain VerisonedTypes or Exceptions that match 
		the given minimal LifecycleState are considered.<br/><br/>
		
		If there exits no DomainBinding for the given SubNamespace any DomainBinding to the targeted
		Environment can be chosen.
	*/
	def toXSD (SubNamespace ns, LifecycleState minState, DomainBinding bind, SOAProfile profile) {
		xsdGenerator.toXSD (ns, bind.environment.getMinLifecycleState(ns), profile, bind.getRegistryBaseUrl());
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