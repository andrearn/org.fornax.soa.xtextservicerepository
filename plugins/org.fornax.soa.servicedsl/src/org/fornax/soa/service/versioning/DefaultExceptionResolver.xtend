package org.fornax.soa.service.versioning

import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.SubNamespace
import java.util.List
import com.google.inject.Inject
import org.fornax.soa.profiledsl.search.StateMatcher
import org.fornax.soa.basedsl.version.VersionMatcher

class DefaultExceptionResolver implements IExceptionResolver {
	
	@Inject extension StateMatcher
	@Inject extension VersionMatcher

	override findMatchingException(ExceptionRef excRef, LifecycleState minState) {
		excRef.exception
	}
	
	override findMatchingException(ExceptionRef excRef) {
		excRef.exception
	}
	
	override isMatchingException(org.fornax.soa.serviceDsl.Exception exc, Integer majorVersion, LifecycleState minState) {
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