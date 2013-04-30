package org.fornax.soa.moduledsl.query

import org.fornax.soa.moduledsl.query.IModuleVersionMatcher
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.basedsl.version.VersionComparator
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.emf.ecore.resource.ResourceSet
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef
import org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.basedsl.search.IPredicateSearch
import org.eclipse.xtext.naming.QualifiedName
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef
import org.fornax.soa.basedsl.version.VersionMatcher

/*
 * Checks, whether to two module versions are compatible.<br/>
 * 
 * A Module is considered compatible, if it has
 * <ol>
 * 	<li>the same major version number</li>
 *  <li>the same or a higher minor version number</li>
 * </ol> 
 */
class DefaultModuleVersionMatcher implements IModuleVersionMatcher {
	
	@Inject extension VersionQualifierExtensions
	@Inject extension IQualifiedNameProvider
	@Inject extension VersionMatcher

	/* 
	 * Check, whether the Module module is compatible to Module originalModule based on their versions
	 * 
	 * returns true, if module is compatible to originalModule
	 */
	override isCompatibleTo(Module otherModule, Module originalModule) {
		val originalVersion = originalModule.version
		val otherVersion = otherModule.version
		if (otherModule.fullyQualifiedName == originalModule.fullyQualifiedName 
			&& originalVersion.toMajorVersionNumber == otherVersion.toMajorVersionNumber
			&& VersionComparator::compare (originalVersion.toVersionNumber, otherVersion.toVersionNumber) >= 0
		)	{
			return true
		}
		return false
	}
	

	override isEffectivelyReferencedVersion(Module module, QualifiedName moduleRefName, VersionRef moduleRefVersionContraint) {
		return module.fullyQualifiedName == moduleRefName && module.version.versionMatches(moduleRefVersionContraint)
	}
	
}