package org.fornax.soa.service.versioning

import com.google.inject.Inject
import java.util.List
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.profiledsl.search.StateMatcher
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState

class LatestMinorVersionExceptionResolver implements IExceptionResolver {
	
	@Inject extension StateMatcher
	@Inject extension VersionMatcher
	
	@Inject extension NamespaceQuery

	/**
	 *	Find the latest minor version of the referenced Exceptiontype matching the 
	 *	version constraint in the reference and the minimal required LifecycleState 
	 */	
	override org.fornax.soa.serviceDsl.Exception findMatchingException (ExceptionRef excRef, LifecycleState minState) {
		excRef.exception.findSubdomain ().exceptions.filter (e|e.name == excRef.exception.name && excRef.exception.version.versionMatches (excRef.version) && excRef.exception.state.matchesMinStateLevel (minState))
			.filter (typeof (org.fornax.soa.serviceDsl.Exception)).sortBy (e|e.version.version).last( );
	}
	
	/**
	 *	Find the latest minor version of the referenced Exceptiontype matching the 
	 *	version constraint in the reference. The LifecycleState of the Exception is not considered. 
	 */	
	override org.fornax.soa.serviceDsl.Exception findMatchingException (ExceptionRef excRef) { 
		excRef.exception.findSubdomain ().exceptions.filter (e|e.name == excRef.exception.name && excRef.exception.version.versionMatches (excRef.version))
			.filter (typeof (org.fornax.soa.serviceDsl.Exception)).sortBy (e|e.version.version).last( );
	}
	
	
	/**
	 *	Checks, whether the Exception is the latest minor version in a given major version
	 *  @param exc				The Exception to checked
	 *  @param majorVersion		The major version number to which minor versions should match
	 */
	override boolean isMatchingException (org.fornax.soa.serviceDsl.Exception exc, Integer majorVersion, LifecycleState minState) { 
		(findMatchingException( 
			(exc.eContainer as SubNamespace).exceptions.filter (e|e.name == exc.name).toList, 
			majorVersion, 
			minState)
		 == exc);
	} 
		
	def private org.fornax.soa.serviceDsl.Exception findMatchingException (List<org.fornax.soa.serviceDsl.Exception> exceptions, Integer majorVersion, LifecycleState minState) { 
		exceptions.filter (e|e.version.versionMatches (majorVersion) && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
	
}