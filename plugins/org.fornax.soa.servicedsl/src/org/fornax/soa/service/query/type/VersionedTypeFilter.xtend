package org.fornax.soa.service.query.type

import org.fornax.soa.serviceDsl.VersionedType
import java.util.List
import org.fornax.soa.serviceDsl.SubNamespace
import com.google.inject.Inject
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.search.StateMatcher

class VersionedTypeFilter {
	
	@Inject extension VersionMatcher
	@Inject extension NamespaceQuery 
	@Inject extension StateMatcher
	
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