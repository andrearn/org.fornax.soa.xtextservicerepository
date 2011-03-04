package org.fornax.soa.basedsl.scoping.versions;

import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;

public class LifecycleStateComparator {

	public static int compare (LifecycleState s1, LifecycleState s2) {
		if (s1 == s2)
			return 0;
		if (s1==LifecycleState.PROPOSED) {
			if (s2 == LifecycleState.DEFINED || s2 == LifecycleState.DEVELOPMENT || s2 == LifecycleState.TEST || s2 == LifecycleState.PRODUCTIVE || s2 == LifecycleState.DEPRECATED || s2 == LifecycleState.RETIRED)
				return 1;
			else
				return -1;
		} else if (s1 == LifecycleState.DEFINED) {
			if (s2 == LifecycleState.DEVELOPMENT || s2 == LifecycleState.TEST || s2 == LifecycleState.PRODUCTIVE || s2 == LifecycleState.DEPRECATED || s2 == LifecycleState.RETIRED)
				return 1;
			else
				return -1;
		} else if (s1 == LifecycleState.DEVELOPMENT) {
			if (s2 == LifecycleState.TEST || s2 == LifecycleState.PRODUCTIVE || s2 == LifecycleState.DEPRECATED || s2 == LifecycleState.RETIRED)
				return 1;
			else
				return -1;
		} else if (s1 == LifecycleState.TEST) {
			if (s2 == LifecycleState.PRODUCTIVE || s2 == LifecycleState.DEPRECATED || s2 == LifecycleState.RETIRED)
				return 1;
			else
				return -1;
		} else if (s1 == LifecycleState.PRODUCTIVE) {
			if (s2 == LifecycleState.DEPRECATED || s2 == LifecycleState.RETIRED)
				return 1;
			else
				return -1;
		} else if (s1 == LifecycleState.DEPRECATED) {
			if (s2 == LifecycleState.RETIRED)
				return 1;
			else
				return -1;
		} else {
			return -1;
		}
	}

}
