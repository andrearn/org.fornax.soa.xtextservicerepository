package org.fornax.soa.bindingdsl.generator.templates

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import java.util.logging.Logger
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.generator.templates.xsd.EventXSDTemplates
import org.fornax.soa.profiledsl.query.LifecycleQueries

/**
 * Builds all technical artifacts that represent a binding (WSDLs/XSDs etc.).
 */
class BindingBuilder {
	
	
	@Inject extension BindingExtensions
	@Inject extension LifecycleQueries
		
	
	@Inject BindingServiceContractBuilder	contractBuilder
	@Inject EventXSDTemplates 				eventXsdGenerator
	@Inject IQualifiedNameProvider			nameProvider
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject Logger log
	
	

	/**
	 *	ENTRYPOINT for generation of concrete and imported abstract WSDLs and their required XSDs 
	 *	for a gibven ModuleBindings. The ModuleBinding binds all Services provided by the module
	 *	to a certain Environment. Generates artifacts for all ModuleBindings
	 *	that target an Environment matching the given environment name.
	 *	
	 *	All Services referenced by the Module and their required XSDs that match the minimal given 
	 *	LifecycleState derived from the profile's Environment and the minimal required LifecycleState 
	 *	of the respective Service / owning SubNamespace
	 */
	def toBinding (ModuleBinding binding, SOAProfile profile) {
		log.info ("Generating technical service contracts for binding " + binding.name)
		try {
			contractBuilder.build (binding, profile);
		} catch (Exception ex) {
			log.severe ("Error generating technical service contracts for binding " + binding.name + "\n" + ex.message)
		}
	}
	
	def toBinding (ModuleBinding binding, SOAProfile profile, boolean noDeps, boolean includeSubNamespaces) {
		log.info ("Generating technical service contracts for binding " + binding.name)
		try {
			contractBuilder.build (binding, profile);
		} catch (Exception ex) {
			log.severe ("Error generating technical service contracts for binding " + binding.name + "\n" + ex.message)
		}
	}

	def toBinding (Module module, Environment environment, boolean generateProvidedServices, boolean generateUsedServices, SOAProfile profile) {
		log.info ("Generating technical service contracts for services used by module " + module.name + " with modules providing the services bound to environment " + environment.name)
		try {
			contractBuilder.build (module, environment, generateProvidedServices, generateUsedServices, profile);
		} catch (Exception ex) {
			log.severe ("Error generating technical service contracts for services used by module " + module.name + " with modules providing the services bound to environment " + environment.name + "\n" + ex.message)
		}
	}
		
	
	/**
	 *	Event XSDs for Services having an request and an response event for each service operation
	 */
	def toEventsInclSubNamespaces (String namespaceName, List<SubNamespace> namespaces, List<Environment> environments, String targetEnv, List<SOAProfile> profiles, String profileName) {
		if (namespaceName != null) {
			for (ns : namespaces.filter (e|e.name.startsWith (namespaceName))) {
				ns.toEvents (environments, targetEnv, profiles, profileName);
			}
		} else {
			log.severe("No namespace name expression has been supplied")
		}
	}
	
	def toEvents (SubNamespace ns, List<Environment> environments, String targetEnv, List<SOAProfile> profiles, String profileName) { 
		val env = environments.findFirst (e|e.name == targetEnv);
		val profile = profiles.findFirst (e|e.name == profileName);
		log.info ("Generating event data definitions for services in namespace " + nameProvider.getFullyQualifiedName(ns) + " applicable for Environment " + env.name)
		try {
		eventXsdGenerator.toEvents (ns,env.getMinLifecycleState(profile.lifecycle), profile, env.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.severe ("Error generating event data definitions for services in namespace " + nameProvider.getFullyQualifiedName(ns) + " applicable for Environment " + env.name + "\n" + ex.message)
		}
	}
	
}