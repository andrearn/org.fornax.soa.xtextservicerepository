package org.fornax.soa.profiledsl.scoping.versions;

import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.environmentDsl.EnvironmentType;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

public interface IStateMatcher {

	public abstract boolean matches(LifecycleState sourceState,
			LifecycleState targetState);
	
	public abstract boolean supportsEnvironment (LifecycleState state, Environment env);
	
	public abstract boolean supportsEnvironment (LifecycleState state, String envName);

	public abstract boolean supportsEnvironmentType (LifecycleState state, EnvironmentType envType);
	
	public LifecycleState getLowestStateByEnvironment (Lifecycle cycle, Environment env);

}