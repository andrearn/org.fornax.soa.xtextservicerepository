package org.fornax.soa.binding.query.environment

import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle
import com.google.inject.Inject
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.profiledsl.query.LifecycleQueries
import org.fornax.soa.serviceDsl.VersionedType
import org.eclipse.emf.ecore.EObject

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
		stateMatcher.matches (env.getMinLifecycleState (service.state.eContainer as Lifecycle), service.state);
	}
	
	def dispatch boolean isEligibleForEnvironment (VersionedType type, Environment env) {
		stateMatcher.matches (env.getMinLifecycleState (type.state.eContainer as Lifecycle), type.state);
	}
	
	def dispatch boolean isEligibleForEnvironment (org.fornax.soa.serviceDsl.Exception exception, Environment env) {
		stateMatcher.matches (env.getMinLifecycleState (exception.state.eContainer as Lifecycle), exception.state);
	}
	
}