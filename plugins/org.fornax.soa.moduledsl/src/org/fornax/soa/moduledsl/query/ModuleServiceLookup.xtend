package org.fornax.soa.moduledsl.query

import java.util.Set
import com.google.common.util.concurrent.Service
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.moduledsl.moduleDsl.NamespaceRef
import org.fornax.soa.profiledsl.search.LifecycleQueries
import javax.inject.Inject

class ModuleServiceLookup {
	
	@Inject
	private extension LifecycleQueries
	/*
	 * Find all services referenced by the module referenced in the binding. Service versions are 
	 * chosen with respect to their state and the target environment
	 */
//	def Set<Service> getAllUsedServicesWithProtocol (Module module, Environment environment, ImportBindingProtocol protocol, SOAProfile profile) {
//		val usedModuleRefs = module.usedModules
//		val Iterable<SubNamespace> usedModuleNamespaces = usedModuleRefs.map (e | e.moduleRef.module.providedNamespaces).flatten.filter (typeof(NamespaceRef)).map (e|e.namespace);
//		val Iterable<ServiceRef> nsServiceExclRefs = usedModuleRefs.map (e | e.moduleRef.module.providedNamespaces).flatten.filter (typeof(NamespaceRef)).map (n | n.excludedServices).flatten;
//		val exclServices = nsServiceExclRefs.map (r | r.service).toList;
//		val minState = environment.getMinLifecycleState (module, profile.lifecycle);	
//		var Set<Service> services = newHashSet();
//		
//		if (!module.usedServices.empty) {
//			services.addAll (module.usedServices.filter (e|e.endpointProtocol == protocol || module.usesEndpointProtocol == protocol).map (s | s.latestServiceInEnvironment (environment)));
//		}
//		if (!usedModuleNamespaces.empty) {
//			val Set<VersionedDomainNamespace> versionedNamespaces = usedModuleNamespaces.map (ns |ns.toVersionedDomainNamespaces()).flatten.toSet
//			for (VersionedDomainNamespace verNs : versionedNamespaces) {
//				val svcCand = verNs.servicesWithMinState (minState).filter (typeof (Service)).filter (e|e.isLatestMatchingService (verNs.version.asInteger(), minState));
//				val nsServices = svcCand.filter (c | !exclServices.contains (c));
//				services.addAll (nsServices);
//			}
//		}
//		return services;
//	}
	
}