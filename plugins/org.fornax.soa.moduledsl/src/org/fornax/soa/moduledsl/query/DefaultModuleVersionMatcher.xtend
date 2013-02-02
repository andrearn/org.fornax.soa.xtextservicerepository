package org.fornax.soa.moduledsl.query

import org.fornax.soa.moduledsl.query.IModuleVersionMatcher
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.basedsl.scoping.versions.VersionComparator
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider

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
	
	
	/* 
	 * Check, whether the Module module is compatible to Module originalModule based on thein versions
	 * 
	 * returns true, if module is compatible to originalModule
	 */
	override isCompatibleTo(Module otherModule, Module originalModule) {
		val originalVersion = otherModule.version
		val otherVersion = otherModule.version
		if (otherModule.fullyQualifiedName == originalModule.fullyQualifiedName 
			&& originalVersion.toMajorVersionNumber == otherVersion.toMajorVersionNumber
			&& VersionComparator::compare (originalVersion.toVersionNumber, otherVersion.toVersionNumber) >= 0
		)	{
			return true
		}
		return false
	}
	
}