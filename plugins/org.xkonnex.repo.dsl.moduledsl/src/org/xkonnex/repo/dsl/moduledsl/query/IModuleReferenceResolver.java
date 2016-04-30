package org.xkonnex.repo.dsl.moduledsl.query;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceModuleRef;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Qualifier;

/**
 * Resolve references from a {@link Module} to a referenced/used {@link Module} matching constraints like
 * <ul>
 * 	<li>The minimal required {@link LifecycleState} of the Module</li>
 * 	<li>The {@link Environment} the Module should run in</li>
 * 	<li>The endpoint {@link Qualifier} a canditate Module must match</li>
 * </ul>
 * 
 * @author André Arnold
 */
public interface IModuleReferenceResolver {
	
	/**
	 * Find the latest version of the referenced {@link Module} having the minimal given {@link LifecycleState}
	 * 
	 * @param moduleRef Reference to the Module
	 * @param minState The minimal required {@link LifecycleState}
	 * @return
	 */
	public Module resolveModuleRef (ModuleRef moduleRef, LifecycleState minState);
	
	/**
	 * Find the latest version of the referenced {@link Module} having the minimal given {@link LifecycleState}
	 * 
	 * @param moduleRef Reference to the Module
	 * @param targetEnvironment The {@link Environment} the Module must be ready to run in
	 * @param lifecycle The applicable {@link Lifecycle} for the Module
	 * @return
	 */
	public Module resolveModuleRef (ModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle);

	/**
	 * Find the latest version of the referenced {@link Module} having the minimal given {@link LifecycleState}
	 * 
	 * @param moduleRef Reference to the Module
	 * @param targetEnvironment The {@link Environment} the Module must be ready to run in
	 * @param lifecycle The applicable {@link Lifecycle} for the Module
	 * @param endpointQualifierRef The endpoint qualifier to filter for
	 * @param usedProtocol The protocol, the Module must support
	 * @return
	 */
	public Module resolveModuleRef (ModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle, EndpointQualifierRef endpointQualifierRef, EndpointProtocol usedProtocol);
	
	/**
	 * Find the latest version of the referenced {@link Module} having the minimal given {@link LifecycleState}
	 * 
	 * @param moduleRef Reference to the Module
	 * @param minState The minimal required {@link LifecycleState}
	 * @return
	 */
	public Module resolveModuleServiceRef (ServiceModuleRef moduleRef, LifecycleState minState);
	
	/**
	 * Find the latest version of the referenced {@link Module} having the minimal given {@link LifecycleState}
	 * 
	 * @param moduleRef Reference to the Module
	 * @param targetEnvironment The {@link Environment} the Module must be ready to run in
	 * @param lifecycle The applicable {@link Lifecycle} for the Module
	 * @return
	 */
	public Module resolveModuleServiceRef (ServiceModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle);
	
	/**
	 * Find the latest version of the referenced {@link Module} having the minimal given {@link LifecycleState}
	 * 
	 * @param moduleRef Reference to the Module
	 * @param targetEnvironment The {@link Environment} the Module must be ready to run in
	 * @param lifecycle The applicable {@link Lifecycle} for the Module
	 * @param endpointQualifierRef The endpoint qualifier to filter for
	 * @param usedProtocol The protocol, the Module must support
	 * @return
	 */
	public Module resolveModuleServiceRef (ServiceModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle, EndpointQualifierRef endpointQualifierRef, EndpointProtocol usedProtocol);

}
