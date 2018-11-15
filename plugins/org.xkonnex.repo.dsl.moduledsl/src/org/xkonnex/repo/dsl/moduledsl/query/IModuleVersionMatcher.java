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
	 * @param module the module to check
	 * @param originalModule to module to check for compatibility to
	 * @return true, if module is compatible to originalModule
	 */
	public boolean isCompatibleTo (Module module, Module originalModule);
	
	/** 
	 * Check, whether the Module module is effectively referenced by the given qualified module name and version
	 * constraint
	 * 
	 * @param module the module to check
	 * @param moduleRefName name of the referenced module
	 * @param moduleRefVersionContraint version constraint for the module reference
	 * @return true, if module has the given <code>moduleRefName</code> and 
	 * 			it's version matches the version constraint <code>moduleRefVersionConstraint</code>
	 */
	public boolean isEffectivelyReferencedVersion (Module module, QualifiedName moduleRefName, VersionRef moduleRefVersionContraint);
	
}
