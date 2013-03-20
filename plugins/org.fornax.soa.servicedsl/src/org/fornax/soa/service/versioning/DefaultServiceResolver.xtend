package org.fornax.soa.service.versioning

import java.util.List
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.ServiceRef
import com.google.inject.Inject
import org.fornax.soa.profiledsl.search.StateMatcher
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.serviceDsl.SubNamespace

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