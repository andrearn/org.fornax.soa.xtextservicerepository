package org.xkonnex.repo.dsl.moduledsl.query;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceModuleRef;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;

/**
 * Resolve references from Module to Module
 * 
 * @author aarnold
 */
public interface IModuleReferenceResolver {
	
	public Module resolveModuleRef (ModuleRef moduleRef, LifecycleState minState);
	
	public Module resolveModuleRef (ModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle);

	public Module resolveModuleRef (ModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle, EndpointQualifierRef endpointQualifierRef, EndpointProtocol usedProtocol);
	
	public Module resolveModuleServiceRef (ServiceModuleRef moduleRef, LifecycleState minState);
	
	public Module resolveModuleServiceRef (ServiceModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle);
	
	public Module resolveModuleServiceRef (ServiceModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle, EndpointQualifierRef endpointQualifierRef, EndpointProtocol usedProtocol);

}
