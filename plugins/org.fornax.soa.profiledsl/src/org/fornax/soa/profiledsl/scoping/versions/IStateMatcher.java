package org.fornax.soa.profiledsl.scoping.versions;

import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.environmentDsl.EnvironmentType;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

public interface IStateMatcher {

	public abstract boolean matches(LifecycleState sourceState,
			LifecycleState targetState);

	public abstract boolean matches(LifecycleState sourceState,
			LifecycleState targetState, LifecycleState minDevState,
			LifecycleState minTestState, LifecycleState minProdState);
	
	public abstract boolean supportsEnvironment (LifecycleState state, Environment env);

	public abstract boolean supportsEnvironmentType (LifecycleState state, EnvironmentType envType);

}