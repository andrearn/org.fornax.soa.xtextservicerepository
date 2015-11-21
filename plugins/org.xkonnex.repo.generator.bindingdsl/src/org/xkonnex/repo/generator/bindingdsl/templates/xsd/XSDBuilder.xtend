package org.xkonnex.repo.generator.bindingdsl.templates.xsd

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import java.util.logging.Logger
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.AbstractProfile
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import java.util.logging.Level
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries
import org.xkonnex.repo.generator.servicedsl.templates.xsd.XSDGenerator
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery

/*
 * Generate an XSD for a SubNamespace. Types and exceptions are filtered by their lifecycle state, determining whether it
 * is supported by the given target environment.
 */
class XSDBuilder {

	@Inject extension BindingExtensions
	@Inject extension EnvironmentBindingResolver		
	@Inject extension LifecycleQueries
	@Inject extension NamespaceQuery
		
	
	@Inject XSDGenerator 					xsdGenerator
	@Inject IQualifiedNameProvider 			nameProvider
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject Logger log

	def void toXSD (SubNamespace ns, List<Environment> env, String targetEnv, List<AbstractProfile> profiles, String profileName) {
		ns.toXSD (env.findFirst (e|e.name == targetEnv), profiles.findFirst (e|e.name == profileName));
	}
	
	
	def void toXSD (SubNamespace ns, Environment env, AbstractProfile enforcedProfile) {
		val profile = ns.getApplicableProfile(enforcedProfile)
		log.fine("Generating XSDs for namespace " + nameProvider.getFullyQualifiedName(ns).toString)
		try {
			xsdGenerator.toXSD (ns, env.getMinLifecycleState (profile.lifecycle), profile, env.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.log (Level::SEVERE, "Error generating XSDs for namespace " + nameProvider.getFullyQualifiedName(ns).toString + "\n", ex)
		}
	}
	
	def void toXSD (VersionedDomainNamespace ns, Environment env, AbstractProfile enforcedProfile) {
		val profile = (ns.subdomain as SubNamespace).getApplicableProfile(enforcedProfile)
		log.fine("Generating XSDs for namespace " + ns.fqn + " with major version " + ns.version)
		try {
			xsdGenerator.toXSD (ns, env.getMinLifecycleState (profile.lifecycle), profile, env.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.log (Level::SEVERE, "Error generating XSDs for namespace " + ns.fqn + " with major version " + ns.version + "\n", ex)
		}
	}
	
	

	def dispatch void toXSD (VersionedDomainNamespace ns, LifecycleState minState, Binding bind, AbstractProfile enforcedProfile) {
		
	}
	def dispatch void toXSD (VersionedDomainNamespace ns, LifecycleState minState, ServiceBinding bind, AbstractProfile enforcedProfile) {
		val profile = (ns.subdomain as SubNamespace).getApplicableProfile(enforcedProfile)
		toXSD(ns, minState, bind.eContainer as Binding, profile)
	}
	
	def dispatch void toXSD (VersionedDomainNamespace ns, LifecycleState minState, ModuleBinding bind, AbstractProfile enforcedProfile) {
		val profile = (ns.subdomain as SubNamespace).getApplicableProfile(enforcedProfile)
		log.fine("Generating XSDs for namespace " + ns.fqn + " with major version " + ns.version)
		try {
			xsdGenerator.toXSD (ns, minState, profile, bind.getRegistryBaseUrl());
//			xsdGenerator.toXSD (ns, bind.resolveEnvironment.getMinLifecycleState(profile.lifecycle), profile, bind.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.log (Level::SEVERE, "Error generating XSDs for namespace " + ns.fqn + " with major version " + ns.version + "\n", ex)
		}
		
	}
	
	
}