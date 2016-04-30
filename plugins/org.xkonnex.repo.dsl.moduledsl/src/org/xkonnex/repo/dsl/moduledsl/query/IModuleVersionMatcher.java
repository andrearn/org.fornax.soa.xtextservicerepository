package org.xkonnex.repo.dsl.moduledsl.query;

import org.eclipse.xtext.naming.QualifiedName;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;

/**
 * Checks whether two module versions are compatible
 * @author André Arnold
 *
 */
public interface IModuleVersionMatcher {
	
	/** 
	 * Check, whether the Module module is compatible to Module originalModule based on their versions
	 * 
	 * returns true, if module is compatible to originalModule
	 */
	public boolean isCompatibleTo (Module module, Module originalModule);
	
	/** 
	 * Check, whether the Module module is effectively referenced by the given  qualified module name an version
	 * constraint
	 * 
	 * returns true, if module has the given <code>moduleRefName</code> and 
	 * 			it's version matches the version constraint <code>moduleRefVersionConstraint</code>
	 */
	public boolean isEffectivelyReferencedVersion (Module module, QualifiedName moduleRefName, VersionRef moduleRefVersionContraint);
	
}
