package org.fornax.soa.moduledsl.query;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.QualifiedName;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
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
	
	/* 
	 * Check, whether the Module module is effectively referenced by the given  qualified module name an version
	 * constraint
	 * 
	 * returns true, if module has the given <code>moduleRefName</code> and 
	 * 			it's version matches the version constraint <code>moduleRefVersionConstraint</code>
	 */
	public boolean isEffectivelyReferencedVersion (Module module, QualifiedName moduleRefName, VersionRef moduleRefVersionContraint);
	
}
