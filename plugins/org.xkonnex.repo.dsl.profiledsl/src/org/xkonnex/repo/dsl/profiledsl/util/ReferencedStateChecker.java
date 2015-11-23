package org.xkonnex.repo.dsl.profiledsl.util;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher;

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
