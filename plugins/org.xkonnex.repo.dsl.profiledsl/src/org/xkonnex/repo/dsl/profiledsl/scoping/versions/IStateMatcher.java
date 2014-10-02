package org.xkonnex.repo.dsl.profiledsl.scoping.versions;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;

public interface IStateMatcher {

	/**
	 * 
	 * @param sourceState
	 * @param targetState
	 * @return true, when asset with targetState is reachable from asset with sourceState
	 */
	public abstract boolean matches(LifecycleState sourceState,
			LifecycleState targetState);
	
	public abstract boolean supportsEnvironment (LifecycleState state, Environment env);
	
	public abstract boolean supportsEnvironment (LifecycleState state, String envName);

	public abstract boolean supportsEnvironmentType (LifecycleState state, EnvironmentType envType);
	
	public LifecycleState getLowestStateByEnvironment (Lifecycle cycle, Environment env);

}