package org.xkonnex.repo.dsl.moduledsl.query;

import java.util.Set;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractResourceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractServiceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ResourceRef;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultModuleResourceResolver.class)
public interface IModuleResourceResolver {
	
	/**
	 * Get all references to services used explicitly or implicitly by module import.
	 * Exclusion and inclusion rules for Module imports are respected
	 */
	public Set<? extends AbstractResourceRef> getAllUsedServiceRefs (Module module);

	/** 
	 * Get explicit and implicit references to resources provided from the module.
	 * Implicit service references are service in namespaces provided by the module.
	 * Resource inclusion and exclusion rules of namespace references are respected.
	 */
	public Set<AbstractResourceRef> getAllProvidedResourceRefs (Module module);
	
	/**
	 * Get the latest version of the resource referenced in the imported or exported 
	 * Service reference matching the given minimal LifecycleState 
	 */
	public Resource resolveModuleResourceRef (AbstractResourceRef resRef, LifecycleState minState);
	
	
	/**
	 * Get the latest version of the resource referenced in the imported or exported 
	 * Resource reference eligible for the given environment 
	 */
	public Resource resolveModuleResourceRef (AbstractResourceRef resRef, Environment env);

}
