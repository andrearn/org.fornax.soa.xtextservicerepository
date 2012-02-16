package org.fornax.soa.servicedsl.query

import com.google.inject.Inject
import java.util.List
import org.fornax.soa.basedsl.lifecycle.StateMatcher
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.serviceDsl.Exception
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.VersionedDomainNamespace
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery

/*
 * exceptions.ext
 */
class ExceptionFinder {
	
	@Inject extension StateMatcher
	@Inject extension VersionMatcher
	
	@Inject extension NamespaceQuery

	def dispatch List exceptionsWithMinState (Object ns, LifecycleState state) {
		newArrayList();
	}


	def dispatch List exceptionsWithMinState (SubNamespace ns, LifecycleState state) {
		ns.exceptions.filter (e|e.state.matchesMinStateLevel (state)).toList;
	}


	def dispatch List exceptionsWithMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.subdomain.exceptionsWithMinState (state);
	}


	/**
	 *	Find the latest minor version of the referenced Exceptiontype matching the 
	 *	version constraint in the reference and the minimal required LifecycleState 
	 */	
	def dispatch org.fornax.soa.serviceDsl.Exception findLatestMatchingException (ExceptionRef excRef, LifecycleState minState) {
		excRef.exception.findSubdomain ().exceptions.filter (e|e.name == excRef.exception.name && excRef.exception.version.versionMatches (excRef.version) && excRef.exception.state.matchesMinStateLevel (minState))
			.filter (typeof (org.fornax.soa.serviceDsl.Exception)).sortBy (e|e.version.version).last( );
	}
	
	/**
	 *	Find the latest minor version of the referenced Exceptiontype matching the 
	 *	version constraint in the reference. The LifecycleState of the Exception is not considered. 
	 */	
	def dispatch org.fornax.soa.serviceDsl.Exception findLatestMatchingException (ExceptionRef excRef) { 
		excRef.exception.findSubdomain ().exceptions.filter (e|e.name == excRef.exception.name && excRef.exception.version.versionMatches (excRef.version))
			.filter (typeof (org.fornax.soa.serviceDsl.Exception)).sortBy (e|e.version.version).last( );
	}
	
	
	/**
	 *	Checks, whether the Exception is the latest minor version in a given major version
	 *  @param exc				The Exception to checked
	 *  @param majorVersion		The major version number to which minor versions should match
	 */
	def dispatch boolean isLatestMatchingException (org.fornax.soa.serviceDsl.Exception exc, Integer majorVersion, LifecycleState minState) { 
		(findLatestMatchingException( 
			(exc.eContainer as SubNamespace).exceptions.filter (e|e.name == exc.name).toList, 
			majorVersion, 
			minState)
		 == exc);
	} 
		
	def private org.fornax.soa.serviceDsl.Exception findLatestMatchingException (List<org.fornax.soa.serviceDsl.Exception> exceptions, Integer majorVersion, LifecycleState minState) { 
		exceptions.filter (e|e.version.versionMatches (majorVersion) && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
	
}