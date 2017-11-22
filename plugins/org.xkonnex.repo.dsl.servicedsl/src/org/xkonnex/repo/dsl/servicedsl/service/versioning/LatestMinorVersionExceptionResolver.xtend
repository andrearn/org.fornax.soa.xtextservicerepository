package org.xkonnex.repo.dsl.servicedsl.service.versioning

import com.google.inject.Inject
import java.util.List
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.profiledsl.search.StateMatcher
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.servicedsl.service.ModelExtensions

class LatestMinorVersionExceptionResolver implements IExceptionResolver {
	
	@Inject extension StateMatcher
	@Inject extension VersionMatcher
	
	@Inject extension NamespaceQuery
	@Inject extension ModelExtensions

	/**
	 *	Find the latest minor version of the referenced Exceptiontype matching the 
	 *	version constraint in the reference and the minimal required LifecycleState 
	 */	
	override org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception findMatchingException (ExceptionRef excRef, LifecycleState minState) {
		excRef.exception.findSubdomain ().exceptions.filter (e|e.name == excRef.exception.name && excRef.exception.version.versionMatches (excRef.versionRef) && excRef.exception.state.matchesMinStateLevel (minState))
			.filter (typeof (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception)).sortBy (e|e.version.version).last( );
	}
	
	/**
	 *	Find the latest minor version of the referenced Exceptiontype matching the 
	 *	version constraint in the reference. The LifecycleState of the Exception is not considered. 
	 */	
	override org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception findMatchingException (ExceptionRef excRef) { 
		excRef.exception.findSubdomain ().exceptions.filter (e|e.name == excRef.exception.name && excRef.exception.version.versionMatches (excRef.versionRef))
			.filter (typeof (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception)).sortBy (e|e.version.version).last( );
	}
	
	
	/**
	 *	Checks, whether the Exception is the latest minor version in a given major version
	 *  @param exc				The Exception to checked
	 *  @param majorVersion		The major version number to which minor versions should match
	 */
	override boolean isMatchingException (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exc, Integer majorVersion, LifecycleState minState) { 
		(findMatchingException( 
			(exc.eContainer as SubNamespace).exceptions.filter (e|e.name == exc.name).toList, 
			majorVersion, 
			minState)
		 == exc);
	} 
	
	/**
	 *	Checks, whether the Exception is the latest minor version in a given major version
	 *  @param exc				The Exception to checked
	 *  @param majorVersion		The major version number to which minor versions should match
	 */
	override boolean isMatchingException (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exc, Integer majorVersion) { 
		(findMatchingException( 
			(exc.eContainer as SubNamespace).exceptions.filter (e|e.name == exc.name).toList, 
			majorVersion)
		 == exc);
	} 
		
	def private org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception findMatchingException (List<org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception> exceptions, Integer majorVersion, LifecycleState minState) { 
		exceptions.filter (e|e.version.versionMatches (majorVersion) && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
		
	def private org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception findMatchingException (List<org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception> exceptions, Integer majorVersion) { 
		exceptions.filter (e|e.version.versionMatches (majorVersion))
			.sortBy (e|e.version.version).last();
	}
	
}