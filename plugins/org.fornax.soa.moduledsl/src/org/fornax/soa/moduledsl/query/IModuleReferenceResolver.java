package org.fornax.soa.moduledsl.query;

import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

public interface IModuleReferenceResolver {
	
	public Module resolveModuleRef (ModuleRef moduleRef, LifecycleState minState);
	
	public Module resolveModuleServiceRef (ServiceModuleRef moduleRef, LifecycleState minState);
	
	public Module resolveModuleRef (ModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle);
	
	public Module resolveModuleServiceRef (ServiceModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle);

}
