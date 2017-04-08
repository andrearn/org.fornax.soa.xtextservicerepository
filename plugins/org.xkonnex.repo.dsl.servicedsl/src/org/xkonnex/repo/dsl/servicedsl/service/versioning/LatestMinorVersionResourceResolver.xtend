package org.xkonnex.repo.dsl.servicedsl.service.versioning

import org.xkonnex.repo.dsl.servicedsl.service.versioning.IResourceResolver
import com.google.inject.Inject
import org.xkonnex.repo.dsl.profiledsl.search.StateMatcher
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.service.ModelExtensions
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceRef
import java.util.List
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace

class LatestMinorVersionResourceResolver implements IResourceResolver {
	
	@Inject extension StateMatcher
	@Inject extension VersionMatcher
	@Inject extension NamespaceQuery
	@Inject extension ModelExtensions
	
	override Resource findMatchingResourceByMajorVersionAndState (String majorVersion, List<Resource> s, LifecycleState minState) {
		s.filter (e|e.version.version.split("\\.").head == majorVersion && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
		
	
	override Resource findMatchingResource (ResourceRef s) {
		s.resource.findSubdomain ().resources.filter (e|e.name == s.resource.name && s.resource.version.versionMatches (s.versionRef))
			.filter (typeof (Resource)).sortBy (e|e.version.version).last();
	}
	
	override Resource findMatchingResourceByState (ResourceRef s, LifecycleState minState) {
		s.findResourceRefOwnerSubdomain().resources
			.filter (e|e.name == s.resource.name && e.version.versionMatches (s.versionRef) && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
	
	
	override boolean isMatchingResource (Resource s, int majorVersion, LifecycleState minState) { 
		findLatestMatchingResource ( (s.eContainer as SubNamespace).resources.filter (e|e.name == s.name).toList, majorVersion, minState) == s;
	}
			
	def private  Resource findLatestMatchingResource (List<Resource> canditates, int majorVersion, LifecycleState minState) {
		canditates.filter (e|e.version.versionMatches (majorVersion) && e.state.matchesMinStateLevel(minState)).sortBy(e|e.version.version).last();
	}
	
}