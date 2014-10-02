package org.xkonnex.repo.dsl.moduledsl.query;

import java.util.Set;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractServiceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

/**
 * Get and resolve service references from modules
 * 
 * @author aarnold
 *
 */
public interface IModuleServiceResolver {
	
	/**
	 * Get all references to services used explicitly or implicitly by module import.
	 * Exclusion and inclusion rules for Module imports are respected
	 */
	public Set<? extends AbstractServiceRef> getAllUsedServiceRefs (Module module);
	
	/** 
	 * Get explicit and implicit references to services provided from the module.
	 * Implicit service references are service in namespaces provided by the module.
	 * Service inclusion and exclusion rules of namespace references are respected.
	 */
	public Set<AbstractServiceRef> getAllProvidedServiceRefs (Module module);
	
	/**
	 * Get the latest version of the service referenced in the imported or exported 
	 * Service reference matching the given minimal LifecycleState 
	 */
	public Service resolveModuleServiceRef (AbstractServiceRef svcRef, LifecycleState minState);
	
	
	/**
	 * Get the latest version of the service referenced in the imported or exported 
	 * Service reference eligible for the given environment 
	 */
	public Service resolveModuleServiceRef (AbstractServiceRef svcRef, Environment env);


}
