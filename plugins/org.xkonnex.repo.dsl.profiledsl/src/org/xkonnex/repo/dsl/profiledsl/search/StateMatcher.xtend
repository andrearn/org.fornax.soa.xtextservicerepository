package org.xkonnex.repo.dsl.profiledsl.search

import com.google.inject.Inject
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState

/*
 * @deprecated
 */
class StateMatcher {
	
	@Inject IStateMatcher stateMatcher
	
	def boolean matchesMinStateLevel (LifecycleState state, LifecycleState minState) {
		stateMatcher.matches (minState, state);
	}
	
}