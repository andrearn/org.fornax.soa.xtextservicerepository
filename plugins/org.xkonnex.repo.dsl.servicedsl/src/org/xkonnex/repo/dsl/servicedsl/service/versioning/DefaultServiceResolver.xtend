package org.xkonnex.repo.dsl.servicedsl.service.versioning

import java.util.List
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef
import com.google.inject.Inject
import org.xkonnex.repo.dsl.profiledsl.search.StateMatcher
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace

class DefaultServiceResolver implements IServiceResolver {
	
	@Inject extension StateMatcher
	@Inject extension VersionMatcher

	override findMatchingService(ServiceRef s) {
		s.service
	}
	
	override findMatchingServiceByMajorVersionAndState(String majorVersion, List<Service> s, LifecycleState minState) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override findMatchingServiceByState(ServiceRef s, LifecycleState minState) {
		s.service
	}
	
	override boolean isMatchingService (Service s, int majorVersion, LifecycleState minState) { 
		findLatestMatchingService ( (s.eContainer as SubNamespace).services.filter (e|e.name == s.name).toList, majorVersion, minState) == s;
	}
			
	def private  Service findLatestMatchingService (List<Service> canditates, int majorVersion, LifecycleState minState) {
		canditates.filter (e|e.version.versionMatches (majorVersion) && e.state.matchesMinStateLevel(minState)).sortBy(e|e.version.version).last();
	}	
	
}