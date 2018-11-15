package org.xkonnex.repo.dsl.moduledsl.query;

import java.util.Set;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractServiceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

/**
 * Get and resolve service references from modules
 * 
 * @author André Arnold
 *
 */
public interface IModuleServiceResolver {
	
	/**
	 * Get all references to services used explicitly or implicitly by module import.
	 * Exclusion and inclusion rules for Module imports are respected
	 * 
	 * @param module the module to investigate
	 * @return all references to services used by the module
	 */
	public Set<? extends AbstractServiceRef> getAllUsedServiceRefs (Module module);
	
	/** 
	 * Get explicit and implicit references to services provided from the module.
	 * Implicit service references are service in namespaces provided by the module.
	 * Service inclusion and exclusion rules of namespace references are respected.
	 * 
	 * @param module the module to investigate
	 * @return all references to services provided by the module
	 */
	public Set<AbstractServiceRef> getAllProvidedServiceRefs (Module module);
	
	/**
	 * Get the latest version of the service referenced in the imported or exported 
	 * Service reference
	 * 
	 * @param svcRef reference to a service
	 * @return the latest version of the service matchin the version constraint in the service reference
	 */
	public Service resolveModuleServiceRef (AbstractServiceRef svcRef);
	
	/**
	 * Get the latest version of the service referenced in the imported or exported 
	 * Service reference matching the given minimal LifecycleState 
	 * 
	 * @param svcRef reference to a Service (imported or exported)
	 * @param minState the minimal required {@link LifecycleState}
	 * @return the {@link Service} with the latest version having at least  minState
	 */
	public Service resolveModuleServiceRef (AbstractServiceRef svcRef, LifecycleState minState);
	
	
	/**
	 * Get the latest version of the service referenced in the imported or exported 
	 * Service reference eligible for the given environment 
	 * 
	 * @param svcRef reference to a Service (imported or exported)
	 * @param env the {@link Environment}
	 * @return the {@link Service} with the latest version suitable for  {@link Environment} env regarding it's state
	 */
	public Service resolveModuleServiceRef (AbstractServiceRef svcRef, Environment env);


}
