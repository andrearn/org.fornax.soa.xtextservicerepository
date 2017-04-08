package org.xkonnex.repo.dsl.servicedsl.service.versioning

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceRef
import java.util.List
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import com.google.inject.Inject
import org.xkonnex.repo.dsl.profiledsl.search.StateMatcher
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.servicedsl.service.ModelExtensions

class DefaultResourceResolver implements IResourceResolver {
	
	@Inject extension StateMatcher
	@Inject extension VersionMatcher
	@Inject extension ModelExtensions
	
	override findMatchingResource(ResourceRef s) {
		s.resource
	}
	
	override findMatchingResourceByMajorVersionAndState(String majorVersion, List<Resource> s, LifecycleState minState) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override findMatchingResourceByState(ResourceRef s, LifecycleState minState) {
		s.resource
	}
	
	override isMatchingResource(Resource s, int majorVersion, LifecycleState minState) {
		findLatestMatchingResource ( (s.eContainer as SubNamespace).resources.filter (e|e.name == s.name).toList, majorVersion, minState) == s;
	}
	
	def private  Resource findLatestMatchingResource (List<Resource> canditates, int majorVersion, LifecycleState minState) {
		canditates.filter (e|e.version.versionMatches (majorVersion) && e.state.matchesMinStateLevel(minState)).sortBy(e|e.version.version).last();
	}	
	
}