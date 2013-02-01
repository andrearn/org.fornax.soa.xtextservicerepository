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

/*
 * Generate an XSD for a SubNamespace. Types and exceptions are filtered by their lifecycle state, determining whether it
 * is supported by the given target environment.
 */
class XSDTemplates {

	@Inject extension BindingExtensions
		
	
	@Inject org.fornax.soa.servicedsl.generator.templates.xsd.XSDTemplates 					xsdGenerator
	@Inject IQualifiedNameProvider 			nameProvider
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject Logger log

	def toXSD (SubNamespace ns, List<Environment> env, String targetEnv, List<SOAProfile> profiles, String profileName) {
		ns.toXSD (env.findFirst (e|e.name == targetEnv), profiles.findFirst (e|e.name == profileName));
	}
	
	
	def toXSD (SubNamespace ns, Environment env, SOAProfile profile) {
		log.fine("Generating XSDs for namespace " + nameProvider.getFullyQualifiedName(ns).toString)
		try {
			xsdGenerator.toXSD (ns, env.getMinLifecycleState (ns, profile.lifecycle), profile, env.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.severe ("Error generating XSDs for namespace " + nameProvider.getFullyQualifiedName(ns).toString + "\n" + ex.message)
		}
	}
	
	def toXSD (VersionedDomainNamespace ns, Environment env, SOAProfile profile) {
		log.fine("Generating XSDs for namespace " + ns.fqn + " with major version " + ns.version)
		try {
			xsdGenerator.toXSD (ns, env.getMinLifecycleState (ns.subdomain as SubNamespace, profile.lifecycle), profile, env.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.severe ("Error generating XSDs for namespace " + ns.fqn + " with major version " + ns.version + "\n" + ex.message)
		}
	}
	
	

	def dispatch void toXSD (VersionedDomainNamespace ns, LifecycleState minState, Binding bind, SOAProfile profile) {
		
	}
	def dispatch toXSD (VersionedDomainNamespace ns, LifecycleState minState, ServiceBinding bind, SOAProfile profile) {
		toXSD(ns, minState, bind.eContainer as Binding, profile)
	}
	
	def dispatch toXSD (VersionedDomainNamespace ns, LifecycleState minState, ModuleBinding bind, SOAProfile profile) {
		log.fine("Generating XSDs for namespace " + ns.fqn + " with major version " + ns.version)
		try {
			xsdGenerator.toXSD (ns, bind.environment.getMinLifecycleState(ns.subdomain as SubNamespace, profile.lifecycle), profile, bind.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.severe ("Error generating XSDs for namespace " + ns.fqn + " with major version " + ns.version + "\n" + ex.message)
		}
	}
	
	
}