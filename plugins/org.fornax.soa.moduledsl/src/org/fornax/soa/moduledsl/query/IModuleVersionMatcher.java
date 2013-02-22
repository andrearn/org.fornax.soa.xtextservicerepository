package org.fornax.soa.moduledsl.query;

import org.fornax.soa.moduledsl.moduleDsl.Module;

/**
 * Checks whether two module version are compatible
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
