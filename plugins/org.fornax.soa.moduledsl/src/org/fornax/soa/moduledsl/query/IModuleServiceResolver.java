package org.fornax.soa.moduledsl.query;

import java.util.Set;

import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.serviceDsl.Service;

public interface IModuleServiceResolver {
	
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
