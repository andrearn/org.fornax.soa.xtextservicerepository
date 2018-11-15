package org.xkonnex.repo.dsl.profiledsl.scoping.versions;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile;

public interface IStateMatcher {

	/**
	 * 
	 * @param sourceState state to verify
	 * @param targetState state to verify against
	 * @return true, when asset with targetState is reachable from asset with sourceState
	 */
	public boolean matches(LifecycleState sourceState,
			LifecycleState targetState);
	
	public boolean supportsEnvironment (LifecycleState state, Environment env);
	
	public boolean supportsEnvironment(LifecycleState state, Environment env, Profile profile);	
	
	public boolean supportsEnvironment (LifecycleState state, String envName);
	
	public boolean supportsEnvironment (LifecycleState state, String envName, Profile profile);

	public boolean supportsEnvironmentType (LifecycleState state, EnvironmentType envType);

	public boolean supportsEnvironmentType (LifecycleState state, EnvironmentType envType, Profile profile);
	
	public LifecycleState getLowestStateByEnvironment (Lifecycle cycle, Environment env);
	
	public LifecycleState getLowestStateByEnvironment (Lifecycle cycle, Environment env, Profile profile);

}