package org.fornax.soa.util;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.scoping.StateConstraintConfigurer;
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;

public class ReferencedStateChecker {

	private LifecycleState ownerLifecycleState;
	private LifecycleState minDevLifecycleState;
	private LifecycleState minTestLifecycleState;
	private LifecycleState minProdLifecycleState;
	
	public ReferencedStateChecker (EObject owner, LifecycleStateResolver stateResolver) {
		minDevLifecycleState = StateConstraintConfigurer.getMinDevState(owner);
		minTestLifecycleState = StateConstraintConfigurer.getMinTestState(owner);
		minProdLifecycleState = StateConstraintConfigurer.getMinProdState(owner);
		ownerLifecycleState = stateResolver.getLifecycleState(owner);
	}
	
	public boolean stateMatches (LifecycleState state) {
		if (ownerLifecycleState == null) {
			return true;
		}
		if (ownerLifecycleState == LifecycleState.RETIRED) {
			return true;
		}
		if (ownerLifecycleState == LifecycleState.RETIRED) {
				return true;
		} else if (ownerLifecycleState == LifecycleState.DEFINED && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minDevLifecycleState, state) >= 0;
		} else if (ownerLifecycleState == LifecycleState.DEVELOPMENT && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minDevLifecycleState, state) >= 0;
		} else if (ownerLifecycleState == LifecycleState.TEST && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minTestLifecycleState, state) >= 0;
		} else if (ownerLifecycleState == LifecycleState.PRODUCTIVE && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minProdLifecycleState, state) >= 0;
		} else if (ownerLifecycleState == LifecycleState.DEPRECATED && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minProdLifecycleState, state) >= 0;
		} else if (ownerLifecycleState == LifecycleState.PROPOSED && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minDevLifecycleState, state) >= 0;
		} else {
			return false;
		}
	}

}
