package org.fornax.soa.profiledsl.util;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver;

import com.google.inject.Inject;

public class ReferencedStateChecker {

	private LifecycleState ownerLifecycleState;
	
	@Inject IStateMatcher stateMatcher;
	@Inject ILifecycleStateResolver stateResolver;
	
	public boolean stateMatches (LifecycleState state, EObject owner) {
		ownerLifecycleState = stateResolver.getLifecycleState(owner);
		return stateMatcher.matches (ownerLifecycleState, state);
	}

}
