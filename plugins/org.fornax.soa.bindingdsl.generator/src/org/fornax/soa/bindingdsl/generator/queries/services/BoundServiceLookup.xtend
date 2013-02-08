package org.fornax.soa.bindingdsl.generator.queries.services

import com.google.inject.Inject
import java.util.Set
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.binding.query.services.BindingServiceResolver
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.moduleDsl.NamespaceRef
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.service.query.ServiceQueries
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.service.namespace.NamespaceSplitter
import org.fornax.soa.service.versioning.IServiceResolver
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver

/*
 * Finds services bound into an environment, i.e. referenced from a binding
 */
class BoundServiceLookup {
	
	@Inject extension ServiceQueries
	@Inject extension NamespaceSplitter
	@Inject extension BindingExtensions
	@Inject extension CommonStringExtensions
	@Inject extension BindingServiceResolver
	@Inject extension IServiceResolver
	@Inject extension EnvironmentBindingResolver		
	
	/*
	 * Find published services (with public service endpoints) bound with the given BindingProtocol
	 */
	def dispatch Iterable<Service> toServicesWithPublisherProtocol (Binding bind, Class bindingProtocolClass) {
		
	}
	
	
	/*
	 * Find published services (with public service endpoints) bound with the given BindingProtocol
	 */
	def dispatch Iterable<Service> toServicesWithPublisherProtocol (ModuleBinding bind, Class bindingProtocolClass) {
		bind.module.module.providedServices.map (ref|ref.service as Service).filter (s| ! bind.getMostSpecificBinding (s).endpointProtocols
			.map (p|bindingProtocolClass.isInstance (p)).empty
		)
	}
	
	def dispatch Iterable<Service> toServicesWithProviderProtocol (Binding bind, Class bindingProtocolClass) {
		
	}
	
	def dispatch Iterable<Service> toServicesWithProviderProtocol (ModuleBinding bind, Class bindingProtocolClass) {
		bind.module.module.providedServices.map (ref|ref.service as Service).filter (s| ! bind.getMostSpecificBinding (s).endpointProtocols
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
		val environment = binding.resolveEnvironment;
		val minState = environment.getMinLifecycleState (binding, profile.lifecycle);	
		var Set<Service> services = newHashSet();	

		services.addAll (binding.module.module.providedServices.map (s | s.latestServiceInEnvironment (environment)));
		val Set<VersionedDomainNamespace> versionedNamespaces = provNamespaces.map (ns |ns.toVersionedDomainNamespaces()).flatten.toSet
		for (VersionedDomainNamespace verNs : versionedNamespaces) {
			val svcCand = verNs.servicesWithMinState (minState).filter (typeof (Service)).filter (e|e.isMatchingService (verNs.version.asInteger(), minState));
			val nsServices = svcCand.filter (c | !exclServices.contains (c));
			services.addAll (nsServices);
		}
		return services;
	}
	
	/*
	 * Find all services referenced by the module referenced in the binding. Service versions are 
	 * chosen with respect to their state and the target environment
	 */
	def Set<Service> getAllUsedServices (Module module, Environment environment, SOAProfile profile) {
		val usedModules = module.usedModules
		val Iterable<SubNamespace> usedModuleNamespaces = usedModules.map (e | e.moduleRef.module.providedNamespaces).flatten.filter (typeof(NamespaceRef)).map (e|e.namespace);
		val Iterable<ServiceRef> nsServiceExclRefs = usedModules.map (e | e.moduleRef.module.providedNamespaces).flatten.filter (typeof(NamespaceRef)).map (n | n.excludedServices).flatten;
		val exclServices = nsServiceExclRefs.map (r | r.service).toList;
		val minState = environment.getMinLifecycleState (module, profile.lifecycle);	
		var Set<Service> services = newHashSet();	

		services.addAll (module.usedServices.map (s | s.latestServiceInEnvironment (environment)));
		val Set<VersionedDomainNamespace> versionedNamespaces = usedModuleNamespaces.map (ns |ns.toVersionedDomainNamespaces()).flatten.toSet
		for (VersionedDomainNamespace verNs : versionedNamespaces) {
			val svcCand = verNs.servicesWithMinState (minState).filter (typeof (Service)).filter (e|e.isMatchingService (verNs.version.asInteger(), minState));
			val nsServices = svcCand.filter (c | !exclServices.contains (c));
			services.addAll (nsServices);
		}
		return services;
	}
	
	/*
	 * Find all services referenced by the module referenced in the binding. Service versions are 
	 * chosen with respect to their state and the target environment
	 */
	def Set<Service> getAllUsedServicesWithProtocol (Module module, Environment environment, ImportBindingProtocol protocol, SOAProfile profile) {
		val usedModuleRefs = module.usedModules
		val Iterable<SubNamespace> usedModuleNamespaces = usedModuleRefs.map (e | e.moduleRef.module.providedNamespaces).flatten.filter (typeof(NamespaceRef)).map (e|e.namespace);
		val Iterable<ServiceRef> nsServiceExclRefs = usedModuleRefs.map (e | e.moduleRef.module.providedNamespaces).flatten.filter (typeof(NamespaceRef)).map (n | n.excludedServices).flatten;
		val exclServices = nsServiceExclRefs.map (r | r.service).toList;
		val minState = environment.getMinLifecycleState (module, profile.lifecycle);	
		var Set<Service> services = newHashSet();
		
		if (!module.usedServices.empty) {
			services.addAll (module.usedServices.filter (e|e.endpointProtocol == protocol || module.usesEndpointProtocol == protocol).map (s | s.latestServiceInEnvironment (environment)));
		}
		if (!usedModuleNamespaces.empty) {
			val Set<VersionedDomainNamespace> versionedNamespaces = usedModuleNamespaces.map (ns |ns.toVersionedDomainNamespaces()).flatten.toSet
			for (VersionedDomainNamespace verNs : versionedNamespaces) {
				val svcCand = verNs.servicesWithMinState (minState).filter (typeof (Service)).filter (e|e.isMatchingService (verNs.version.asInteger(), minState));
				val nsServices = svcCand.filter (c | !exclServices.contains (c));
				services.addAll (nsServices);
			}
		}
		return services;
	}
}