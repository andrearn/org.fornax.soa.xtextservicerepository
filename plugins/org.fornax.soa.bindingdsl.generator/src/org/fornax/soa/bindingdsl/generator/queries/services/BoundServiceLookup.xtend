package org.fornax.soa.bindingdsl.generator.queries.services

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.servicedsl.generator.domain.NamespaceSplitter
import org.fornax.soa.basedsl.generator.CommonStringExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import java.util.Set
import org.fornax.soa.moduledsl.generator.query.ModuleNamespaceQuery
import org.fornax.soa.servicedsl.generator.query.ServiceFinder
import org.fornax.soa.servicedsl.VersionedDomainNamespace
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.serviceDsl.SubNamespace

/*
 * Finds services bound into an environment, i.e. referenced from a binding
 */
class BoundServiceLookup {
	
	@Inject extension ServiceFinder
	@Inject extension NamespaceSplitter
	@Inject extension BindingExtensions
	@Inject extension CommonStringExtensions
	@Inject extension BindingServiceResolver
	@Inject extension ModuleNamespaceQuery
	
	/*
	 * Find published services (with public service endpoints) bound with the given BindingProtocol
	 */
	def dispatch Iterable<Service> toServicesWithPublisherProtocol (Binding bind, Class bindingProtocolClass) {
		
	}
	
	/*
	 * Find published services (with public service endpoints) bound with the given BindingProtocol
	 */
	def dispatch Iterable<Service> toServicesWithPublisherProtocol (DomainBinding bind, Class bindingProtocolClass) {
		bind.subNamespace.services.filter (s| ! bind.getMostSpecificBinding (s).publisherProtocols
			.map (p|bindingProtocolClass.isInstance (p)).empty
		)
	}
	
	/*
	 * Find published services (with public service endpoints) bound with the given BindingProtocol
	 */
	def dispatch Iterable<Service> toServicesWithPublisherProtocol (ModuleBinding bind, Class bindingProtocolClass) {
		bind.module.module.providedServices.map (ref|ref.service as Service).flatten.filter (s| ! bind.getMostSpecificBinding (s).publisherProtocols
			.map (p|bindingProtocolClass.isInstance (p)).empty
		)
	}
	
	def dispatch Iterable<Service> toServicesWithProviderProtocol (Binding bind, Class bindingProtocolClass) {
		
	}
	
	def dispatch Iterable<Service> toServicesWithProviderProtocol (DomainBinding bind, Class bindingProtocolClass) {
		bind.subNamespace.services.filter (s| ! bind.getMostSpecificBinding (s).providerProtocols
			.map (p|bindingProtocolClass.isInstance (p)).empty
		)
	}
	
	def dispatch Iterable<Service> toServicesWithProviderProtocol (ModuleBinding bind, Class bindingProtocolClass) {
		bind.module.module.providedServices.map (ref|ref.service as Service).flatten.filter (s| ! bind.getMostSpecificBinding (s).publisherProtocols
			.map (p|bindingProtocolClass.isInstance (p)).empty
		)
	}
	
	/*
	 * Find all services referenced by the module referenced in the binding. Service versions are 
	 * chosen with respect ttheir state and the target environment
	 */
	def Set<Service> getAllProvidedServices (ModuleBinding binding, SOAProfile profile) {
		val Iterable<SubNamespace> provNamespaces = binding.module.module.providedNamespaces.map (n | n.namespace);
		val Iterable<ServiceRef> nsServiceExclRefs = binding.module.module.providedNamespaces.map (n | n.excludedServices).flatten;
		val exclServices = nsServiceExclRefs.map (r | r.service).toList;
		val environment = binding.environment;
		val minState = environment.getMinLifecycleState (binding, profile.lifecycle);	
		var Set<Service> services = newHashSet();	

		services.addAll (binding.module.module.providedServices.map (s | s.latestServiceInEnvironment (environment)));
		val Set<VersionedDomainNamespace> versionedNamespaces = provNamespaces.map (ns |ns.toVersionedDomainNamespaces()).flatten.toSet
		for (VersionedDomainNamespace verNs : versionedNamespaces) {
			val svcCand = verNs.servicesWithMinState (minState).filter (typeof (Service)).filter (e|e.isLatestMatchingService (verNs.version.asInteger(), minState));
			val nsServices = svcCand.filter (c | !exclServices.contains (c));
			services.addAll (nsServices);
		}
		return services;
	}
}