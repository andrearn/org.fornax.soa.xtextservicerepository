package org.fornax.soa.bindingdsl.generator.templates

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import org.fornax.soa.basedsl.generator.CommonStringExtensions
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingdsl.generator.queries.modules.ModuleBindingResolver
import org.fornax.soa.bindingdsl.generator.queries.services.BindingServiceResolver
import org.fornax.soa.bindingdsl.generator.queries.services.BoundServiceLookup
import org.fornax.soa.bindingdsl.generator.templates.soap.ConcreteProviderWsdlTemplates
import org.fornax.soa.bindingdsl.generator.templates.soap.ConcreteWsdlTemplates
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.profiledsl.generator.templates.MessageHeaderXSDTemplates
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.generator.domain.NamespaceSplitter
import org.fornax.soa.servicedsl.generator.query.ServiceFinder
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceImportQueries
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery
import org.fornax.soa.servicedsl.generator.templates.ServiceTemplates
import org.fornax.soa.servicedsl.generator.templates.webservice.WSDLTemplates
import org.fornax.soa.servicedsl.generator.templates.xsd.EventXSDTemplates
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.XSDTemplates

class BindingBuilder {
	
	
	@Inject extension NamespaceQuery
	@Inject extension CommonStringExtensions
	@Inject extension ServiceFinder
	@Inject extension BindingExtensions
	@Inject extension NamespaceSplitter
	@Inject extension NamespaceImportQueries
	@Inject extension org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension BindingServiceResolver
	@Inject extension ModuleBindingResolver
		
	
	@Inject BindingServiceContractBuilder	contractBuilder
	@Inject WSDLTemplates 					wsdlGenerator
	@Inject XSDTemplates 					xsdGenerator
	@Inject ServiceTemplates 				serviceGenerator
	@Inject EventXSDTemplates 				eventXsdGenerator
	@Inject ConcreteWsdlTemplates 			concreteWsdlGenerator
	@Inject ConcreteProviderWsdlTemplates 	concreteProviderWsdlGenerator
	@Inject MessageHeaderXSDTemplates 		msgHeaderGenerator
	@Inject BoundServiceLookup				serviceLookup
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
		
	/*
		ENTRYPOINT for generation of concrete and imported abstract WSDLs and their required XSDs 
		for a given DomainBinding. The DomainBinding binds all Services in a given SubNamespace 
		to a certain Environment.<br/>
		
		All Services and their required XSDs that match the minimal LifecycleState of environment
		referenced by the DomainBinding are considered. Overrides of minimal LifecycleStates 
		declared in SubNamespaces will be respected
	*/
	def dispatch void toBinding (DomainBinding binding, SOAProfile profile) {
		contractBuilder.build (binding, profile);
	}
	
	

	/*
		ENTRYPOINT for generation of concrete and imported abstract WSDLs and their required XSDs 
		for a gibven ModuleBindings. The ModuleBinding binds all Services provided by the module
		to a certain Environment. Generates artifacts for all ModuleBindings
		that target an Environment matching the given environment name.
		
		All Services referenced by the Module and their required XSDs that match the minimal given 
		LifecycleState derived from the profile's Environment and the minimal required LifecycleState 
		of the respective Service / owning SubNamespace
	*/
	def dispatch toBinding (ModuleBinding binding, SOAProfile profile) {
		contractBuilder.build (binding, profile);
	}
	
	def toBinding (ModuleBinding binding, SOAProfile profile, boolean noDeps, boolean includeSubNamespaces) {
		contractBuilder.build (binding, profile);
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
		val profile = profiles.findFirst (e|e.name == profileName);
		eventXsdGenerator.toEvents (ns,env.getMinLifecycleState(ns, profile.lifecycle), profile, env.getRegistryBaseUrl());
	}
	
}