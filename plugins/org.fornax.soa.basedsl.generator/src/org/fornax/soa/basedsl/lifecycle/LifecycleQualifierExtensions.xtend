package org.fornax.soa.basedsl.lifecycle

import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState

/* from serviceDsl.../common.ext */
class LifecycleQualifierExtensions {
	
	def LifecycleState stateByName (String state) {
		switch (state) {
			case "proposed" : 		LifecycleState::PROPOSED
			case "defined" : 		LifecycleState::DEFINED
			case "development" : 	LifecycleState::DEVELOPMENT
			case "test" : 			LifecycleState::TEST
			case "productive" : 	LifecycleState::PRODUCTIVE
			case "deprecated" : 	LifecycleState::DEPRECATED
			case "retired" : 		LifecycleState::RETIRED
			default: 				LifecycleState::PROPOSED
		}
	}

	
}