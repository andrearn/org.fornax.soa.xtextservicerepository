package org.fornax.soa.basedsl.generator.lifecycle

import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState

class StateMatcher {

	def boolean matchesMinStateLevel (LifecycleState state, LifecycleState minState) { 
		switch (minState) {
			case LifecycleState::PROPOSED: 		state != LifecycleState::RETIRED
			case LifecycleState::DEFINED:		state != LifecycleState::PROPOSED && state != LifecycleState::RETIRED
			case LifecycleState::DEVELOPMENT:	(state != LifecycleState::PROPOSED && state != LifecycleState::DEFINED) && state != LifecycleState::RETIRED
			case LifecycleState::TEST:			(state == LifecycleState::TEST || state == LifecycleState::PRODUCTIVE || state == LifecycleState::DEPRECATED) &&  state != LifecycleState::RETIRED
			case LifecycleState::PRODUCTIVE:	state == LifecycleState::PRODUCTIVE || state == LifecycleState::DEPRECATED
			case LifecycleState::DEPRECATED:	state == LifecycleState::DEPRECATED
			case LifecycleState::RETIRED:		state == LifecycleState::RETIRED
			default: false
		};
		
	}
}