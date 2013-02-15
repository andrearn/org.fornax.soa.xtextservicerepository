package org.fornax.soa.binding.query.services

import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle
import com.google.inject.Inject
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.profiledsl.query.LifecycleQueries

class BindingServiceQueries {
	
	@Inject extension LifecycleQueries
	@Inject IStateMatcher stateMatcher
			
	def dispatch boolean isEligibleForEnvironment (Service s, Environment env) {
		stateMatcher.matches (env.getMinLifecycleState(s.state.eContainer as Lifecycle), s.state);
	}
	
}