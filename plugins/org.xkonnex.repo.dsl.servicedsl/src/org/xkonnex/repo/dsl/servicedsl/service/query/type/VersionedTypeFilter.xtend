package org.xkonnex.repo.dsl.servicedsl.service.query.type

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import java.util.List
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.search.StateMatcher
import org.xkonnex.repo.dsl.servicedsl.service.ModelExtensions

class VersionedTypeFilter {
	
	@Inject extension VersionMatcher
	@Inject extension NamespaceQuery 
	@Inject extension StateMatcher
	@Inject extension ModelExtensions
		
	/* all types from the namespace with the given major version */
	def dispatch List<VersionedType> allTypesByMajorVersion (SubNamespace s, String majorVersion) {
		s.types.filter (typeof (VersionedType))
			.filter (t|t.version.matchesMajorVersion (majorVersion)).toList();
	}

	/* all types from the namespace of the service with the given major version */
	def dispatch List<VersionedType> allTypesByMajorVersion (Service s, String majorVersion) { 
		(s.findSubdomain() as SubNamespace).types.filter (typeof (VersionedType))
			.filter (t|t.version.matchesMajorVersion (majorVersion)).toList();
	}

	/* all types from the namespace with the given major version */
	def dispatch List<VersionedType> allTypesByMajorVersion (SubNamespace s, String majorVersion, LifecycleState minState) {
		s.types.filter (typeof (VersionedType))
			.filter (e|e.state.matchesMinStateLevel(minState)).filter (t|t.version.matchesMajorVersion (majorVersion)).toList();
	}

	/* all types from the namespace of the service with the given major version */
	def dispatch List<VersionedType> allTypesByMajorVersion (Service s, String majorVersion, LifecycleState minState) { 
		(s.findSubdomain() as SubNamespace).types.filter (typeof (VersionedType))
			.filter (e|e.state.matchesMinStateLevel(minState)).filter (t|t.version.matchesMajorVersion (majorVersion)).toList();
	}
}