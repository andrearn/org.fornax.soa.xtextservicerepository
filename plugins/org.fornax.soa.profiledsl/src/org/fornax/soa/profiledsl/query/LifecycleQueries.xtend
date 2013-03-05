package org.fornax.soa.profiledsl.query

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.fornax.soa.basedsl.search.EObjectLookup
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.environmentDsl.EnvironmentType
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator

/*
 * Queries for lifecycle states and stateful objects
 */
class LifecycleQueries {
	String STATE_ATTR_NAME = "state"
	
	@Inject EObjectLookup lookup
	@Inject extension LifecycleStateComparator stateComparator
	@Inject extension IStateMatcher
	@Inject ILifecycleStateResolver stateResolver
	
	def LifecycleState stateByName (String state, Resource res) {
		lookup.getModelElementByName (state, res, "LifecycleState");
	}
	
	/*
	 * Get the minimal state for an environment of type LOCAL based on a given lifecycle definition
	 */
	def LifecycleState getMinLocalState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::LOCAL)).sort (stateComparator).head
	}
	
	/*
	 * Get the minimal state for an environment of type DEV based on a given lifecycle definition
	 */
	def LifecycleState getMinDevState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::DEV)).sort (stateComparator).head
	}


	/*
	 * Get the minimal state for an environment of type TEST based on a given lifecycle definition
	 */
	def LifecycleState getMinTestState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::TEST)).sort (stateComparator).head
	}

	/*
	 * Get the minimal state for an environment of type STAGING based on a given lifecycle definition
	 */
	def LifecycleState getMinStagingState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::STAGING)).sort (stateComparator).head
	}

	/*
	 * Get the minimal state for an environment of type PROD based on a given lifecycle definition
	 */
	def LifecycleState getMinProdState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::PROD)).sort (stateComparator).head
	}
	
	def LifecycleState getMinLifecycleState (Environment env, Lifecycle l) {
		switch (env.type) {
			case EnvironmentType::LOCAL : 		l.minLocalState
			case EnvironmentType::DEV : 		l.minDevState
			case EnvironmentType::TEST:			l.minTestState
			case EnvironmentType::STAGING :		l.minStagingState
			case EnvironmentType::PROD :		l.minProdState
			default:							l.minDevState
		}
	}
	
	def LifecycleState getAssetLifecycleState (EObject asset) {
		stateResolver.getLifecycleState (asset)
	}
	
	def boolean hasLifecycleState (EObject asset) {
		stateResolver.definesState (asset)
	}
	
}