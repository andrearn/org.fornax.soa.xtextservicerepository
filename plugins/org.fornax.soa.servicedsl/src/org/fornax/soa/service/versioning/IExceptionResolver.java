package org.fornax.soa.service.versioning;

import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.serviceDsl.ExceptionRef;

public interface IExceptionResolver {
	
	/**
	 *	Find the latest minor version of the referenced Exceptiontype matching the 
	 *	version constraint in the reference and the minimal required LifecycleState 
	 */	
	public org.fornax.soa.serviceDsl.Exception findMatchingException (ExceptionRef excRef, LifecycleState minState);
	
	/**
	 *	Find the latest minor version of the referenced Exceptiontype matching the 
	 *	version constraint in the reference. The LifecycleState of the Exception is not considered. 
	 */	
	public org.fornax.soa.serviceDsl.Exception findMatchingException (ExceptionRef excRef);
	
	
	/**
	 *	Checks, whether the Exception is the latest minor version in a given major version
	 *  @param exc				The Exception to checked
	 *  @param majorVersion		The major version number to which minor versions should match
	 */
	public boolean isMatchingException (org.fornax.soa.serviceDsl.Exception exc, Integer majorVersion, LifecycleState minState);
		

}
