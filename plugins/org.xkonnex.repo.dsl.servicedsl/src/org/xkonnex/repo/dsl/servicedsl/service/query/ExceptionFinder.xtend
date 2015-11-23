package org.xkonnex.repo.dsl.servicedsl.service.query

import com.google.inject.Inject
import java.util.List
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.search.StateMatcher
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace

/*
 * Search for Exception type definitions
 */
class ExceptionFinder {
	
	@Inject extension StateMatcher

	def dispatch List exceptionsWithMinState (Object ns, LifecycleState state) {
		newArrayList();
	}


	def dispatch List<org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception> exceptionsWithMinState (SubNamespace ns, LifecycleState state) {
		ns.exceptions.filter (e|e.state.matchesMinStateLevel (state)).toList;
	}


	def dispatch List exceptionsWithMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.subdomain.exceptionsWithMinState (state);
	}
	
}