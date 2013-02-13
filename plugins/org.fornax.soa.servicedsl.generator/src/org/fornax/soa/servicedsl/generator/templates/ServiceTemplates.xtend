package org.fornax.soa.servicedsl.generator.templates

import com.google.inject.Inject
import com.google.inject.name.Named
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.service.namespace.NamespaceSplitter
import org.fornax.soa.service.query.ServiceQueries
import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.serviceDsl.InternalNamespace
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.ServiceModel
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.generator.templates.webservice.WSDLTemplates
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.XSDTemplates
import org.fornax.soa.service.versioning.IServiceResolver

class ServiceTemplates {
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceSplitter
	@Inject extension org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
	@Inject extension ServiceQueries
	@Inject extension IServiceResolver
	@Inject extension WSDLTemplates
	@Inject extension XSDTemplates
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies

	def void main (ServiceModel model, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		model.getAllServiceModels().map (m|m.orgNamespaces).flatten.forEach (o|o.toOrganizationNamespace (minState, profile, registryBaseUrl));
	}

	def void toOrganizationNamespace (OrganizationNamespace orgNs, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		orgNs.subNamespaces.forEach (n|n.toSubNamespace (minState, profile, registryBaseUrl));
	}

	def dispatch void toSubNamespace (SubNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		//ERROR "not a concrete type"
	}

	def dispatch void toSubNamespace (DomainNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		ns.interalNamespaces.forEach (n|n.toSubNamespace (minState, profile, registryBaseUrl));
		val verNs = ns.splitNamespaceByMajorVersion();
		verNs.forEach (
			v|v.servicesWithMinState (minState)
				.filter (typeof (Service)).filter(e|e.isMatchingService(v.version.asInteger(), minState))
				.filter(e|e.providedContractUrl == null)
				.forEach (s|s.toService (ns, minState, profile, registryBaseUrl))
		);

		if ( ! noDependencies ) {
			ns.toBusinessObject (minState, profile, registryBaseUrl);
		}
	}
	
	def dispatch void toSubNamespace (InternalNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val verNs = ns.splitNamespaceByMajorVersion();
		verNs.forEach (
			v|v.servicesWithMinState (minState).filter (typeof (Service))
				.filter (e|e.isMatchingService(v.version.asInteger(), minState))
				.filter (e|e.providedContractUrl == null)
				.forEach (s|s.toService (ns, minState, profile, registryBaseUrl))
		)
		if ( ! noDependencies ) {
			ns.toBusinessObject (minState, profile, registryBaseUrl);
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