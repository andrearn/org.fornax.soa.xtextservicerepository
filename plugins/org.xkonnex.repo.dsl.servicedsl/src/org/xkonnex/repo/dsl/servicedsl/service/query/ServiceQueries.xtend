package org.xkonnex.repo.dsl.servicedsl.service.query

import com.google.common.base.Predicates
import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.search.StateMatcher
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Aggregate
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.service.ModelExtensions

class ServiceQueries {
	
	@Inject extension StateMatcher
	@Inject extension NamespaceQuery
	@Inject extension ModelExtensions	
	@Inject
	private ServiceQueriesInternal svcQueriesInt
	@Inject
	private IPredicateSearch search
	
	def dispatch List servicesWithMinState (Object ns, LifecycleState state) {null;}
	
	def dispatch List<Service> servicesWithMinState (SubNamespace ns, LifecycleState state) {
		ns.services.filter (e|e.state.matchesMinStateLevel (state)).toList;
	}

	def dispatch List servicesWithMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.subdomain.servicesWithMinState (state);
	}
	
	def dispatch List resourcesWithMinState (Object ns, LifecycleState state) {null;}
	
	def dispatch List<Service> resourcesWithMinState (SubNamespace ns, LifecycleState state) {
		ns.services.filter (e|e.state.matchesMinStateLevel (state)).toList;
	}

	def dispatch List resourcesWithMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.subdomain.resourcesWithMinState (state);
	}
	
	def Set<Service> findAllServices () {
		search.search("Service ", Predicates::alwaysTrue).filter(typeof (Service)).toSet
	}
	
	def Set<Service> findAllResources () {
		search.search("Resource ", Predicates::alwaysTrue).filter(typeof (Service)).toSet
	}
	
	def List<EObject> findAllServiceConsumers (Service service) {
		svcQueriesInt.findAllServiceConsumers(service) 
	}
	
	def List<EObject> findAllProvidingModules (Service service) {
		svcQueriesInt.findAllProvidingModules(service)
	}
	
	def List<EObject> findAllResourceConsumers (Resource resource) {
		svcQueriesInt.findAllResourceConsumers(resource) 
	}
	
	def List<EObject> findAllProvidingModules (Resource resource) {
		svcQueriesInt.findAllProvidingModules(resource)
	}

	
	def List<Exception> allExceptionsByMajorVersion (SubNamespace s, String majorVersion) {
		s.exceptions.filter (e|e.version.version.split("\\.").head == majorVersion).toList;
	}
	
	def List<Exception> allExceptionsByMajorVersion (Service s, String majorVersion)  {
		s.findSubdomain().exceptions.filter (e|e.version.version.split("\\.").head == majorVersion).toList;
	}
	
	def List<Exception> allExceptionsByMajorVersion (Resource s, String majorVersion)  {
		s.findSubdomain().exceptions.filter (e|e.version.version.split("\\.").head == majorVersion).toList;
	}
	
	def List<Exception> allExceptionsByMajorVersion (Aggregate s, String majorVersion)  {
		s.findSubdomain().exceptions.filter (e|e.version.version.split("\\.").head == majorVersion).toList;
	}
	
	def List<Exception> allReferencedExceptions (Service s) {
		s.operations.map (o|o.^throws).flatten.map (e|e.exception).toList;
	}
	
	def List<Exception> allReferencedExceptions (Resource s) {
		s.operations.map (o|o.^throws).flatten.map[it.exception].flatten.map[it.exception].toList;
	}
	
	def List<Exception> allReferencedExceptions (Aggregate s) {
		s.operations.map (o|o.^throws).flatten.map (e|e.exception).toList;
	}
	
	def private Service findMatchingServiceByMajorVersionAndState (String majorVersion, List<Service> s, LifecycleState minState) {
		s.filter (e|e.version.version.split("\\.").head == majorVersion && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
}