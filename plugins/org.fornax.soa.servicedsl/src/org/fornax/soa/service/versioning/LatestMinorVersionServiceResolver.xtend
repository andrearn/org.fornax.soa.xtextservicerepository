package org.fornax.soa.service.versioning

import com.google.inject.Inject
import java.util.List
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.search.StateMatcher
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.ServiceRef
import org.fornax.soa.serviceDsl.SubNamespace

class LatestMinorVersionServiceResolver implements IServiceResolver {
	
	@Inject extension StateMatcher
	@Inject extension VersionMatcher
	@Inject extension NamespaceQuery
	
	override Service findMatchingServiceByMajorVersionAndState (String majorVersion, List<Service> s, LifecycleState minState) {
		s.filter (e|e.version.version.split("\\.").head == majorVersion && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
		
	
	override Service findMatchingService (ServiceRef s) {
		s.service.findSubdomain ().services.filter (e|e.name == s.service.name && s.service.version.versionMatches (s.versionRef))
			.filter (typeof (Service)).sortBy (e|e.version.version).last();
	}
	
	override Service findMatchingServiceByState (ServiceRef s, LifecycleState minState) {
		s.findOwnerSubdomain().services
			.filter (e|e.name == s.service.name && e.version.versionMatches (s.versionRef) && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
	
	
	override boolean isMatchingService (Service s, int majorVersion, LifecycleState minState) { 
		findLatestMatchingService ( (s.eContainer as SubNamespace).services.filter (e|e.name == s.name).toList, majorVersion, minState) == s;
	}
			
	def private  Service findLatestMatchingService (List<Service> canditates, int majorVersion, LifecycleState minState) {
		canditates.filter (e|e.version.versionMatches (majorVersion) && e.state.matchesMinStateLevel(minState)).sortBy(e|e.version.version).last();
	}	
}