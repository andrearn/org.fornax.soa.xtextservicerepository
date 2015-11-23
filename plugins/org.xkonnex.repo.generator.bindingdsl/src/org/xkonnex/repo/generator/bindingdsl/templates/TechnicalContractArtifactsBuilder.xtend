package org.xkonnex.repo.generator.bindingdsl.templates

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import java.util.logging.Logger
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.generator.servicedsl.templates.xsd.EventXSDGenerator
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery

/**
 * Builds all technical artifacts that represent a binding (WSDLs/XSDs etc.).
 */
class TechnicalContractArtifactsBuilder implements IArtifactBuilder {
	
	
	@Inject extension BindingExtensions
	@Inject extension LifecycleQueries
	@Inject extension NamespaceQuery
	
	@Inject ServiceContractBuilder	contractBuilder
	@Inject EventXSDGenerator 				eventXsdGenerator
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
	override build (ModuleBinding binding, Profile enforcedProfile) {
		log.info ("Generating technical service contracts for binding " + binding.name)
		try {
			contractBuilder.build (binding, enforcedProfile);
		} catch (Exception ex) {
			log.severe ("Error generating technical service contracts for binding " + binding.name + "\n" + ex.message)
		}
	}
	
	override build (ModuleBinding binding, Profile enforcedProfile, boolean noDeps, boolean includeSubNamespaces) {
		log.info ("Generating technical service contracts for binding " + binding.name)
		try {
			contractBuilder.build (binding, enforcedProfile);
		} catch (Exception ex) {
			log.severe ("Error generating technical service contracts for binding " + binding.name + "\n" + ex.message)
		}
	}

	override build (Module module, Environment environment, boolean selectTypeVersionsByEnvironment, boolean generateProvidedServices, boolean generateUsedServices, EndpointQualifierRef endpointQualifierRef, Profile enforcedProfile) {
		log.info ("Generating technical service contracts for services used by module " + module.name + " with modules providing the services bound to environment " + environment.name)
		try {
			contractBuilder.build (module, environment, selectTypeVersionsByEnvironment, generateProvidedServices, generateUsedServices, endpointQualifierRef, enforcedProfile);
		} catch (Exception ex) {
			log.severe ("Error generating technical service contracts for services used by module " + module.name + " with modules providing the services bound to environment " + environment.name + "\n" + ex.message)
		}
	}
		
	
	/**
	 *	Event XSDs for Services having an request and an response event for each service operation
	 */
	override buildEventsInclSubNamespaces (String namespaceName, List<SubNamespace> namespaces, List<Environment> environments, String targetEnv, Profile enforcedProfile) {
		if (namespaceName != null) {
			for (ns : namespaces.filter (e|e.name.startsWith (namespaceName))) {
				val profile = ns.getApplicableProfile(enforcedProfile)
				ns.buildEvents (environments, targetEnv, profile);
			}
		} else {
			log.severe("No namespace name expression has been supplied")
		}
	}
	
	override buildEvents (SubNamespace ns, List<Environment> environments, String targetEnv, Profile enforcedProfile) { 
		val env = environments.findFirst (e|e.name == targetEnv);
		val profile = ns.getApplicableProfile(enforcedProfile)
		log.info ("Generating event data definitions for services in namespace " + nameProvider.getFullyQualifiedName(ns) + " applicable for Environment " + env.name)
		try {
			eventXsdGenerator.toEvents (ns,env.getMinLifecycleState(profile.lifecycle), profile, env.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.severe ("Error generating event data definitions for services in namespace " + nameProvider.getFullyQualifiedName(ns) + " applicable for Environment " + env.name + "\n" + ex.message)
		}
	}
	
}