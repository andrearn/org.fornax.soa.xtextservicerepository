package org.xkonnex.repo.dsl.profiledsl.scoping.versions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.environmentdsl.util.EnvironmentTypeComparator;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class DefaultStateMatcher implements IStateMatcher {
	
	@Inject
	private LifecycleStateComparator stateComparator;
	
	@Inject
	private EnvironmentTypeComparator envTypeComparator;
	
	/* (non-Javadoc)
	 * @see org.xkonnex.repo.dsl.semanticsdsl.profiledsl.scoping.versions.IStateMatcher#matches(org.xkonnex.repo.dsl.semanticsdsl.profiledsl.sOAProfileDsl.LifecycleState, org.xkonnex.repo.dsl.semanticsdsl.profiledsl.sOAProfileDsl.LifecycleState)
	 */
	public boolean matches (LifecycleState sourceState, LifecycleState targetState) {
		int compare = getStateComparator().compare (sourceState, targetState);
		if (sourceState == null || targetState == null)
			return true;
		if (!sourceState.isIsEnd () && targetState != null && targetState.isIsEnd ()) {
			return false;
		} else if (sourceState.isIsEnd () && targetState != null && targetState.isIsEnd ()) {
			return true;
		}
		EnvironmentType sourceStateEnvType = envTypeComparator.getGreatestEnvType (stateComparator.getStateEnvironmentTypes (sourceState));
		EnvironmentType targetStateEnvType = envTypeComparator.getGreatestEnvType (stateComparator.getStateEnvironmentTypes (targetState));
		if (targetStateEnvType != null)
			return envTypeComparator.compare (sourceStateEnvType, targetStateEnvType) <= 0;
		if  (compare <= 0)
			return true;
		return false;
	}
	
	public boolean supportsEnvironment(LifecycleState state, Environment env) {
		if (state != null && state.getQualifiesForEnvironment() != null) {
			for (Environment curEnv : state.getQualifiesForEnvironment()) {
				if (curEnv.equals(env))
					return true;
			}
		}
		return false;
	}

	public boolean supportsEnvironment (LifecycleState state, String envName) {
		if (state == null)
			return true;
		for (Environment env : state.getQualifiesForEnvironment ()) {
			if (env.getName().equals (envName)) {
				return true;
			}
		}
		return false;
	}

	public boolean supportsEnvironmentType (LifecycleState state,
			EnvironmentType envType) {
		List<EnvironmentType> types = new ArrayList<EnvironmentType> ();
		if (state != null) {
			types.addAll (state.getQualifiesFor ());
			types.addAll (Lists.transform (state.getQualifiesForEnvironment (), new Function<Environment, EnvironmentType> () {
				
				public EnvironmentType apply (Environment env) {
					return env.getType ();
				}
				
			}));
		}
		return types.contains (envType);
	}

	public LifecycleState getLowestStateByEnvironment (Lifecycle cycle, final Environment env) {
		List<LifecycleState> eligibleStates = Lists.newArrayList (Iterables.filter (cycle.getStates(), new Predicate <LifecycleState> () {

			public boolean apply (LifecycleState input) {
				return supportsEnvironment(input, env);
			}
			
		}));
		Collections.sort (eligibleStates, stateComparator);
		if (!eligibleStates.isEmpty())
			return eligibleStates.get (0);
		else 
			return null;
	}

	public void setStateComparator(LifecycleStateComparator stateComparator) {
		this.stateComparator = stateComparator;
	}

	public LifecycleStateComparator getStateComparator() {
		return stateComparator;
	}

}
