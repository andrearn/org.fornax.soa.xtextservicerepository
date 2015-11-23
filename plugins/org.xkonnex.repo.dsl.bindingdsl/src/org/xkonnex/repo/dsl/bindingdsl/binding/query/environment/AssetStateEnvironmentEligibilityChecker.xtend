package org.xkonnex.repo.dsl.bindingdsl.binding.query.environment

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle
import com.google.inject.Inject
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries

/**
 * Checks, whether an asset is eligible for an environment with regard to it's lifecycle state
 */
class AssetStateEnvironmentEligibilityChecker {
	
	@Inject extension LifecycleQueries
	@Inject IStateMatcher stateMatcher
			
	def dispatch boolean isEligibleForEnvironment (EObject asset, Environment env) {
		if (asset.hasLifecycleState) {
			val assetState = asset.assetLifecycleState
			return stateMatcher.matches (env.getMinLifecycleState (assetState.eContainer as Lifecycle), assetState)
		} else {
			return true
		}
	}
	
	def dispatch boolean isEligibleForEnvironment (Service service, Environment env) {
		if (service.state != null)
			stateMatcher.matches (env.getMinLifecycleState (service.state.eContainer as Lifecycle), service.state)
		else
			true
	}
	
	def dispatch boolean isEligibleForEnvironment (VersionedType type, Environment env) {
		if (type.state != null)
			stateMatcher.matches (env.getMinLifecycleState (type.state.eContainer as Lifecycle), type.state)
		else
			true
	}
	
	def dispatch boolean isEligibleForEnvironment (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exception, Environment env) {
		if (exception.state != null)
			stateMatcher.matches (env.getMinLifecycleState (exception.state.eContainer as Lifecycle), exception.state)
		else
			true
	}
	
}