package org.fornax.soa.profiledsl.scoping.versions;

import java.util.ArrayList;
import java.util.List;

import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.environmentDsl.EnvironmentType;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.util.EnvironmentTypeComparator;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class DefaultStateMatcher implements IStateMatcher {
	
	@Inject
	private LifecycleStateComparator stateComparator;
	
	@Inject
	private EnvironmentTypeComparator envTypeComparator;
	
	/* (non-Javadoc)
	 * @see org.fornax.soa.profiledsl.scoping.versions.IStateMatcher#matches(org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState, org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState)
	 */
	public boolean matches (LifecycleState sourceState, LifecycleState targetState) {
		int compare = getStateComparator().compare (sourceState, targetState);
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
	
	/* (non-Javadoc)
	 * @see org.fornax.soa.profiledsl.scoping.versions.IStateMatcher#matches(org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState, org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState, org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState, org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState, org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState)
	 */
	public boolean matches (LifecycleState sourceState, LifecycleState targetState, LifecycleState minDevState, LifecycleState minTestState, LifecycleState minProdState) {
		int compare = getStateComparator().compare (sourceState, targetState);
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

	public boolean supportsEnvironmentType(LifecycleState state,
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

	public void setStateComparator(LifecycleStateComparator stateComparator) {
		this.stateComparator = stateComparator;
	}

	public LifecycleStateComparator getStateComparator() {
		return stateComparator;
	}

}
