package org.xkonnex.repo.generator.servicedsl.templates

import com.google.inject.Inject
import com.google.inject.name.Named
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile
import org.xkonnex.repo.dsl.servicedsl.service.versioning.NamespaceSplitter
import org.xkonnex.repo.dsl.servicedsl.service.query.ServiceQueries
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceModel
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.generator.servicedsl.templates.webservice.WSDLGenerator
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.XSDGenerator
import org.xkonnex.repo.dsl.servicedsl.service.versioning.IServiceResolver
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery

class ServiceContractGenerator {
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceSplitter
	@Inject extension org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
	@Inject extension ServiceQueries
	@Inject extension IServiceResolver
	@Inject extension WSDLGenerator
	@Inject extension XSDGenerator
	@Inject extension NamespaceQuery
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies

	def void toOrganizationNamespace (OrganizationNamespace orgNs, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		orgNs.subNamespaces.forEach (n|n.toSubNamespace (minState, profile, registryBaseUrl));
	}

	def dispatch void toSubNamespace (SubNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		//ERROR "not a concrete type"
	}

	def dispatch void toSubNamespace (DomainNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val applicableProfile = ns.getApplicableProfile(profile)
		ns.interalNamespaces.forEach (n|n.toSubNamespace (minState, applicableProfile, registryBaseUrl));
		val verNs = ns.splitNamespaceByMajorVersion();
		verNs.forEach (
			v|v.servicesWithMinState (minState)
				.filter (typeof (Service)).filter(e|e.isMatchingService(v.version.asInteger(), minState))
				.filter(e|e.providedContractUrl == null)
				.forEach (s|s.toService (ns, minState, applicableProfile, registryBaseUrl))
		);

		if ( ! noDependencies ) {
			ns.toBusinessObject (minState, profile, registryBaseUrl);
		}
	}
	
	def dispatch void toSubNamespace (InternalNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val verNs = ns.splitNamespaceByMajorVersion();
		val applicableProfile = ns.getApplicableProfile(profile)
		verNs.forEach (
			v|v.servicesWithMinState (minState).filter (typeof (Service))
				.filter (e|e.isMatchingService(v.version.asInteger(), minState))
				.filter (e|e.providedContractUrl == null)
				.forEach (s|s.toService (ns, minState, applicableProfile, registryBaseUrl))
		)
		if ( ! noDependencies ) {
			ns.toBusinessObject (minState, applicableProfile, registryBaseUrl);
		}
	}



	def dispatch toService (Service s, DomainNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		s.toWSDL (subDom, minState, profile, registryBaseUrl);
	}
	
	def dispatch toService (Service s, InternalNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		s.toWSDL (subDom, minState, profile, registryBaseUrl);
	}



	def dispatch toBusinessObject (DomainNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		ns.toXSD (minState, profile, registryBaseUrl);
	}
	
	def dispatch toBusinessObject (InternalNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		ns.toXSD (minState, profile, registryBaseUrl);
	}


	
}