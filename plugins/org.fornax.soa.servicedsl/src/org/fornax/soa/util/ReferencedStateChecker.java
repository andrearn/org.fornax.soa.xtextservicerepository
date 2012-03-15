package org.fornax.soa.util;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.scoping.StateConstraintConfigurer;

import com.google.inject.Inject;

public class ReferencedStateChecker {

	private LifecycleState ownerLifecycleState;
	private LifecycleState minDevLifecycleState;
	private LifecycleState minTestLifecycleState;
	private LifecycleState minProdLifecycleState;
	
	@Inject IStateMatcher stateMatcher;
	@Inject LifecycleStateResolver stateResolver;
	
	public boolean stateMatches (LifecycleState state, EObject owner) {
		minDevLifecycleState = StateConstraintConfigurer.getMinDevState(owner);
		minTestLifecycleState = StateConstraintConfigurer.getMinTestState(owner);
		minProdLifecycleState = StateConstraintConfigurer.getMinProdState(owner);
		ownerLifecycleState = stateResolver.getLifecycleState(owner);
		return stateMatcher.matches (ownerLifecycleState, state, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
	}

}
