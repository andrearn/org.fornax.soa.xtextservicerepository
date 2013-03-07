package org.fornax.soa.moduledsl.query;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

/**
 * Checks whether two module versions are compatible
 * @author aarnold
 *
 */
public interface IModuleVersionMatcher {
	
	/* 
	 * Check, whether the Module module is compatible to Module originalModule based on thein versions
	 * 
	 * returns true, if module is compatible to originalModule
	 */
	public boolean isCompatibleTo (Module module, Module originalModule);
}
