package org.xkonnex.repo.dsl.servicedsl.service.versioning

import com.google.inject.Inject
import java.util.List
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.search.StateMatcher
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace

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
		s.findServiceRefOwnerSubdomain().services
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