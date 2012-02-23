package org.fornax.soa.moduledsl.query

import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.validation.LifecycleStatefulReferenceValidator
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef
import com.google.inject.Inject
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.basedsl.lifecycle.StateMatcher

class ModuleServiceResolver {
	
	@Inject extension VersionMatcher
	@Inject extension StateMatcher
	@Inject extension NamespaceQuery
	
	def dispatch Service findLatestMatchingServiceMod (ServiceRef s, LifecycleState minState) {
		s.service.findSubdomain().services.filter (e|e.name == s.service.name && e.version.versionMatches (s.versionRef) && e.state.matchesMinStateLevel(minState)).sortBy(e|e.version.version).last();
	}
	
	def dispatch Service findLatestMatchingServiceMod (ImportServiceRef s, LifecycleState minState) {
		s.service.findSubdomain().services.filter (e|e.name == s.service.name && e.version.versionMatches (s.versionRef) && e.state.matchesMinStateLevel(minState)).sortBy(e|e.version.version).last();
	}
}