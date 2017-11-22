package org.xkonnex.repo.dsl.servicedsl.service.versioning;

import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef;

public interface IExceptionResolver {
	
	/**
	 *	Find the latest minor version of the referenced Exceptiontype matching the 
	 *	version constraint in the reference and the minimal required LifecycleState 
	 */	
	public org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception findMatchingException (ExceptionRef excRef, LifecycleState minState);
	
	/**
	 *	Find the latest minor version of the referenced Exceptiontype matching the 
	 *	version constraint in the reference. The LifecycleState of the Exception is not considered. 
	 */	
	public org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception findMatchingException (ExceptionRef excRef);
	
	
	/**
	 *	Checks, whether the Exception is the latest minor version in a given major version
	 *  @param exc				The Exception to checked
	 *  @param majorVersion		The major version number to which minor versions should match
	 */
	public boolean isMatchingException (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exc, Integer majorVersion, LifecycleState minState);
	
	/**
	 *	Checks, whether the Exception is the latest minor version in a given major version
	 *  @param exc				The Exception to checked
	 *  @param majorVersion		The major version number to which minor versions should match
	 */
	public boolean isMatchingException (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exc, Integer majorVersion);
		

}
