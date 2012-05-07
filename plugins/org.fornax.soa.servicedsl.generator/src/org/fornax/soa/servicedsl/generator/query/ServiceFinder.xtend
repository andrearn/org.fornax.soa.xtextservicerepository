package org.fornax.soa.servicedsl.generator.query

import com.google.inject.Inject
import java.util.List
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery
import org.fornax.soa.serviceDsl.ServiceRef
import org.fornax.soa.basedsl.generator.version.VersionMatcher
import org.fornax.soa.basedsl.generator.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.generator.query.StateMatcher

class ServiceFinder {
	
	@Inject extension StateMatcher
	@Inject extension VersionMatcher
	@Inject extension VersionQualifierExtensions
	@Inject extension NamespaceQuery
	
	def dispatch List servicesWithMinState (Object ns, LifecycleState state) {null;}
	
	def dispatch List servicesWithMinState (SubNamespace ns, LifecycleState state) {
		ns.services.filter (e|e.state.matchesMinStateLevel (state)).toList;
	}

	def dispatch List servicesWithMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.subdomain.servicesWithMinState (state);
	}


	def List<ExceptionRef> allReferencedExceptionRefs (Service s) {
		s.operations.map (o|o.^throws).flatten.toList;
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

	def List<Service> allLatestMajorVersions (List<Service> s, LifecycleState minState) {
		s.map(e|e.version.toMajorVersionNumber ().latestServiceByMajorVersionAndMinState (s, minState));
	}
	
	def Service latestServiceByMajorVersionAndMinState (String majorVersion, List<Service> s, LifecycleState minState) {
		s.filter (e|e.version.version.split("\\.").head == majorVersion && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
		
	
	def Service findLatestMatchingService (ServiceRef s) {
		s.service.findSubdomain ().services.filter (e|e.name == s.service.name && s.service.version.versionMatches (s.versionRef))
			.filter (typeof (Service)).sortBy (e|e.version.version).last();
	}
	
	def Service findLatestMatchingService (ServiceRef s, LifecycleState minState) {
		s.findOwnerSubdomain().services
			.filter (e|e.name == s.service.name && e.version.versionMatches (s.versionRef) && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
	
	def boolean isLatestMatchingService (Service s, int majorVersion, LifecycleState minState) { 
		findLatestMatchingService ( (s.eContainer as SubNamespace).services.filter (e|e.name == s.name).toList, majorVersion, minState) == s;
	}
			
	def private  Service findLatestMatchingService (List<Service> canditates, int majorVersion, LifecycleState minState) {
		canditates.filter (e|e.version.versionMatches (majorVersion) && e.state.matchesMinStateLevel(minState)).sortBy(e|e.version.version).last();
	}	
}