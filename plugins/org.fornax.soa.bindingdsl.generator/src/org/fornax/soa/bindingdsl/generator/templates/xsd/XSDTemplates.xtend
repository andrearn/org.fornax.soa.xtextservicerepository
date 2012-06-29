package org.fornax.soa.bindingdsl.generator.templates.xsd

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import java.util.logging.Logger
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingdsl.generator.queries.modules.ModuleBindingResolver
import org.fornax.soa.bindingdsl.generator.queries.services.BindingServiceResolver
import org.fornax.soa.bindingdsl.generator.queries.services.BoundServiceLookup
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.profiledsl.generator.templates.MessageHeaderXSDTemplates
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.generator.query.LifecycleQueries

/*
 * Generate an XSD for a SubNamespace. Types and exceptions are filtered by their lifecycle state, determining whether it
 * is supported by the given target environment.
 */
class XSDTemplates {

	@Inject extension BindingExtensions
	@Inject extension BindingServiceResolver
	@Inject extension ModuleBindingResolver
	@Inject extension LifecycleQueries
		
	
	@Inject org.fornax.soa.servicedsl.generator.templates.xsd.XSDTemplates 					xsdGenerator
	@Inject MessageHeaderXSDTemplates 		msgHeaderGenerator
	@Inject BoundServiceLookup				serviceLookup
	@Inject IQualifiedNameProvider 			nameProvide
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject Logger log

	def toXSD (SubNamespace ns, List<Environment> env, String targetEnv, List<SOAProfile> profiles, String profileName) {
		ns.toXSD (env.findFirst (e|e.name == targetEnv), profiles.findFirst (e|e.name == profileName));
	}
	
	
	def toXSD (SubNamespace ns, Environment env, SOAProfile profile) {
		log.fine("Generating XSDs for namespace " + nameProvide.getFullyQualifiedName(ns).toString)
		try {
			xsdGenerator.toXSD (ns, env.getMinLifecycleState (ns, profile.lifecycle), profile, env.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.severe ("Error generating XSDs for namespace " + nameProvide.getFullyQualifiedName(ns).toString + "\n" + ex.message)
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
		ns.toXSD (bind.environment.getMinLifecycleState (ns, profile.lifecycle), bind, profile);
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
		log.fine("Generating XSDs for namespace " + nameProvide.getFullyQualifiedName(ns).toString)
		try {
			xsdGenerator.toXSD (ns, bind.environment.getMinLifecycleState(ns, profile.lifecycle), profile, bind.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.severe ("Error generating XSDs for namespace " + nameProvide.getFullyQualifiedName(ns).toString + "\n" + ex.message)
		}
	}

	def dispatch void toXSD (VersionedDomainNamespace ns, LifecycleState minState, Binding bind, SOAProfile profile) {
		
	}
	def dispatch toXSD (VersionedDomainNamespace ns, LifecycleState minState, ServiceBinding bind, SOAProfile profile) {
		toXSD(ns, minState, bind.eContainer as Binding, profile)
	}
	def dispatch toXSD (VersionedDomainNamespace ns, LifecycleState minState, DomainBinding bind, SOAProfile profile) {
		log.fine("Generating XSDs for namespace " + ns.fqn + " with major version " + ns.version)
		try {
			xsdGenerator.toXSD (ns, bind.environment.getMinLifecycleState(ns.subdomain as SubNamespace, profile.lifecycle), profile, bind.getRegistryBaseUrl());
		} catch (Exception ex) {
			log.severe ("Error generating XSDs for namespace " + ns.fqn + " with major version " + ns.version + "\n" + ex.message)
		}
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