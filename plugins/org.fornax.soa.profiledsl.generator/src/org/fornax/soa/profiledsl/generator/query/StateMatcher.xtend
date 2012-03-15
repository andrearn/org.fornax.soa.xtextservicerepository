package org.fornax.soa.profiledsl.generator.query

import com.google.inject.Inject
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState

class StateMatcher {
	
	@Inject IStateMatcher stateMatcher
	
	def boolean matchesMinStateLevel (LifecycleState state, LifecycleState minState) {
		stateMatcher.matches (minState, state);
	}
	
}