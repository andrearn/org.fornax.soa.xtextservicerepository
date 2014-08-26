package org.fornax.soa.service.query

import com.google.inject.Inject
import java.util.List
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.serviceDsl.ServiceRef
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.search.StateMatcher
import org.fornax.soa.basedsl.search.IReferenceSearch
import com.google.common.base.Predicate
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.resource.IEObjectDescription
import org.fornax.soa.basedsl.search.IPredicateSearch
import com.google.common.base.Predicates
import java.util.Set

class ServiceQueries {
	
	@Inject extension StateMatcher
	@Inject extension VersionQualifierExtensions
	@Inject extension NamespaceQuery
	
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
	
	def Set<Service> findAllServices () {
		search.search("Service ", Predicates::alwaysTrue).filter(typeof (Service)).toSet
	}
	
	def List<EObject> findAllServiceConsumers (Service service) {
		svcQueriesInt.findAllServiceConsumers(service) 
	}
	
	def List<EObject> findAllProvidingModules (Service service) {
		svcQueriesInt.findAllProvidingModules(service)
	}

	
	def List<org.fornax.soa.serviceDsl.Exception> allExceptionsByMajorVersion (SubNamespace s, String majorVersion) {
		s.exceptions.filter (e|e.version.version.split("\\.").head == majorVersion).toList;
	}
	
	def List<org.fornax.soa.serviceDsl.Exception> allExceptionsByMajorVersion (Service s, String majorVersion)  {
		s.findSubdomain().exceptions.filter (e|e.version.version.split("\\.").head == majorVersion).toList;
	}
	
	def List<org.fornax.soa.serviceDsl.Exception> allReferencedExceptions (Service s) {
		s.operations.map (o|o.^throws).flatten.map (e|e.exception).toList;
	}
	
	def private Service findMatchingServiceByMajorVersionAndState (String majorVersion, List<Service> s, LifecycleState minState) {
		s.filter (e|e.version.version.split("\\.").head == majorVersion && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
}