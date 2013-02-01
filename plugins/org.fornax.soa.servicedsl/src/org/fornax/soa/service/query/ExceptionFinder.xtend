package org.fornax.soa.service.query

import com.google.inject.Inject
import java.util.List
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.search.StateMatcher
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.serviceDsl.SubNamespace

/*
 * Search for Exception type definitions
 */
class ExceptionFinder {
	
	@Inject extension StateMatcher

	def dispatch List exceptionsWithMinState (Object ns, LifecycleState state) {
		newArrayList();
	}


	def dispatch List exceptionsWithMinState (SubNamespace ns, LifecycleState state) {
		ns.exceptions.filter (e|e.state.matchesMinStateLevel (state)).toList;
	}


	def dispatch List exceptionsWithMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.subdomain.exceptionsWithMinState (state);
	}
	
}