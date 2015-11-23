package org.xkonnex.repo.dsl.servicedsl.service.versioning

import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import java.util.List
import com.google.inject.Inject
import org.xkonnex.repo.dsl.profiledsl.search.StateMatcher
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher

class DefaultExceptionResolver implements IExceptionResolver {
	
	@Inject extension StateMatcher
	@Inject extension VersionMatcher

	override findMatchingException(ExceptionRef excRef, LifecycleState minState) {
		excRef.exception
	}
	
	override findMatchingException(ExceptionRef excRef) {
		excRef.exception
	}
	
	override isMatchingException(org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exc, Integer majorVersion, LifecycleState minState) {
		(findMatchingException( 
			(exc.eContainer as SubNamespace).exceptions.filter (e|e.name == exc.name).toList, 
			majorVersion, 
			minState)
		 == exc);
	}
	
	def private org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception findMatchingException (List<org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception> exceptions, Integer majorVersion, LifecycleState minState) { 
		exceptions.filter (e|e.version.versionMatches (majorVersion) && e.state.matchesMinStateLevel (minState))
			.sortBy (e|e.version.version).last();
	}
	
}