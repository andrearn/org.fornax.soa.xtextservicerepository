package org.fornax.soa.bindingdsl.generator.templates.xsd

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import java.util.logging.Logger
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.serviceDsl.SubNamespace
import java.util.logging.Level
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.profiledsl.query.LifecycleQueries
import org.fornax.soa.servicedsl.generator.templates.xsd.XSDGenerator

/*
 * Generate an XSD for a SubNamespace. Types and exceptions are filtered by their lifecycle state, determining whether it
 * is supported by the given target environment.
 */
class XSDBuilder {

	@Inject extension BindingExtensions
	@Inject extension EnvironmentBindingResolver		
	@Inject extension LifecycleQueries
		
	
	@Inject XSDGenerator 					xsdGenerator
	@Inject IQualifiedNameProvider 			nameProvider
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject Logger log

	def void toXSD (SubNamespace ns, List<Environment> env, String targetEnv, List<SOAProfile> profiles, String profileName) {
		ns.toXSD (env.findFirst (e|e.name == targetEnv), profiles.findFirst (e|e.name == profileName));
	}
	
	
	def void toXSD (SubNamespace ns, Environment env, SOAProfile profile) {
		log.fine("Generating XSDs for namespace " + nameProvider.getFullyQualifiedName(ns).toString)
		try {
			xsdGenerator.toXSD (ns, env.getMinLifecycleState (profile.lifecycle), profile, env.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.log (Level::SEVERE, "Error generating XSDs for namespace " + nameProvider.getFullyQualifiedName(ns).toString + "\n", ex)
		}
	}
	
	def void toXSD (VersionedDomainNamespace ns, Environment env, SOAProfile profile) {
		log.fine("Generating XSDs for namespace " + ns.fqn + " with major version " + ns.version)
		try {
			xsdGenerator.toXSD (ns, env.getMinLifecycleState (profile.lifecycle), profile, env.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.log (Level::SEVERE, "Error generating XSDs for namespace " + ns.fqn + " with major version " + ns.version + "\n", ex)
		}
	}
	
	

	def dispatch void toXSD (VersionedDomainNamespace ns, LifecycleState minState, Binding bind, SOAProfile profile) {
		
	}
	def dispatch void toXSD (VersionedDomainNamespace ns, LifecycleState minState, ServiceBinding bind, SOAProfile profile) {
		toXSD(ns, minState, bind.eContainer as Binding, profile)
	}
	
	def dispatch void toXSD (VersionedDomainNamespace ns, LifecycleState minState, ModuleBinding bind, SOAProfile profile) {
		log.fine("Generating XSDs for namespace " + ns.fqn + " with major version " + ns.version)
		try {
			xsdGenerator.toXSD (ns, minState, profile, bind.getRegistryBaseUrl());
//			xsdGenerator.toXSD (ns, bind.resolveEnvironment.getMinLifecycleState(profile.lifecycle), profile, bind.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.log (Level::SEVERE, "Error generating XSDs for namespace " + ns.fqn + " with major version " + ns.version + "\n", ex)
		}
		
	}
	
	
}