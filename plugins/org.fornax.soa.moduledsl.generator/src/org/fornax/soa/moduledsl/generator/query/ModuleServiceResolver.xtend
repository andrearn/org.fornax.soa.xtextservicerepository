package org.fornax.soa.moduledsl.generator.query

import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef
import com.google.inject.Inject
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery
import org.fornax.soa.basedsl.generator.version.VersionMatcher
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher

class ModuleServiceResolver {
	
	@Inject extension VersionMatcher
	@Inject IStateMatcher stateMatcher
	@Inject extension NamespaceQuery
	
	def dispatch Service findLatestMatchingServiceMod (ServiceRef s, LifecycleState minState) {
		s.service.findSubdomain().services.filter (e|e.name == s.service.name && e.version.versionMatches (s.versionRef) && stateMatcher.matches (minState, e.state)).sortBy(e|e.version.version).last();
	}
	
	def dispatch Service findLatestMatchingServiceMod (ImportServiceRef s, LifecycleState minState) {
		s.service.findSubdomain().services.filter (e|e.name == s.service.name && e.version.versionMatches (s.versionRef) && stateMatcher.matches (minState, e.state)).sortBy(e|e.version.version).last();
	}
}