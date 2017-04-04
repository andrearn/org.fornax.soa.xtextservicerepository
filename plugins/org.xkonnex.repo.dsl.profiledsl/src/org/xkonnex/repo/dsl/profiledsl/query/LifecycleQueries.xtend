package org.xkonnex.repo.dsl.profiledsl.query

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.xkonnex.repo.dsl.basedsl.search.EObjectLookup
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.EnvironmentBasedLifecycleStateComparator
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator

/*
 * Queries for lifecycle states and stateful objects
 */
class LifecycleQueries {
	
	@Inject EObjectLookup lookup
	@Inject extension LifecycleStateComparator stateComparator
	@Inject extension IStateMatcher
	@Inject ILifecycleStateResolver stateResolver
	@Inject EnvironmentBasedLifecycleStateComparator envLifecycleComparator
	@Inject ProfileQueries profileQuery
	
	def LifecycleState stateByName (String state, Resource res) {
		lookup.getModelElementByName (state, res, "LifecycleState");
	}
	
	/*
	 * Get the minimal state for an environment of type LOCAL based on a given lifecycle definition
	 */
	def LifecycleState getMinLocalState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::LOCAL)).sortWith (stateComparator).head
	}
	
	/*
	 * Get the minimal state for an environment of type DEV based on a given lifecycle definition
	 */
	def LifecycleState getMinDevState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::DEV)).sortWith (stateComparator).head
	}


	/*
	 * Get the minimal state for an environment of type TEST based on a given lifecycle definition
	 */
	def LifecycleState getMinTestState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::TEST)).sortWith (stateComparator).head
	}

	/*
	 * Get the minimal state for an environment of type STAGING based on a given lifecycle definition
	 */
	def LifecycleState getMinStagingState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::STAGING)).sortWith (stateComparator).head
	}

	/*
	 * Get the minimal state for an environment of type PROD based on a given lifecycle definition
	 */
	def LifecycleState getMinProdState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::PROD)).sortWith (stateComparator).head
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
	/*
	 * Get the minimal state for an environment of type LOCAL based on a given lifecycle definition
	 */
	def LifecycleState getMaxLocalState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::LOCAL)).sortWith (stateComparator).last
	}
	
	/*
	 * Get the minimal state for an environment of type DEV based on a given lifecycle definition
	 */
	def LifecycleState getMaxDevState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::DEV)).sortWith (stateComparator).last
	}


	/*
	 * Get the minimal state for an environment of type TEST based on a given lifecycle definition
	 */
	def LifecycleState getMaxTestState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::TEST)).sortWith (stateComparator).last
	}

	/*
	 * Get the minimal state for an environment of type STAGING based on a given lifecycle definition
	 */
	def LifecycleState getMaxStagingState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::STAGING)).sortWith (stateComparator).last
	}

	/*
	 * Get the minimal state for an environment of type PROD based on a given lifecycle definition
	 */
	def LifecycleState getMaxProdState (Lifecycle lifecycleDefinition) {
		lifecycleDefinition.states.filter (s | s.supportsEnvironmentType (EnvironmentType::PROD)).sortWith (stateComparator).last
	}
	
	def LifecycleState getMaxLifecycleState (Environment env, Lifecycle l) {
		switch (env.type) {
			case EnvironmentType::LOCAL : 		l.maxLocalState
			case EnvironmentType::DEV : 		l.maxDevState
			case EnvironmentType::TEST:			l.maxTestState
			case EnvironmentType::STAGING :		l.maxStagingState
			case EnvironmentType::PROD :		l.maxProdState
			default:							l.maxDevState
		}
	}
	
	def LifecycleState getInitialState (Profile profile, ResourceSet resourceSet) {
		if (profile !== null) {
			return profile.lifecycle.states.findFirst[isInitial]
		} else {
			return profileQuery.getDefaultProfile(resourceSet)?.lifecycle.states.findFirst[isInitial]
		}
	}
	
	def Lifecycle getAssetLifecycle (EObject asset) {
		stateResolver.getLifecycleState (asset)?.eContainer as Lifecycle
	}
	
	def LifecycleState getAssetLifecycleState (EObject asset) {
		stateResolver.getLifecycleState (asset)
	}
	
	def boolean hasLifecycleState (EObject asset) {
		stateResolver.definesState (asset)
	}
	
	def getHighestEnvironmentalLifecycleState (List<LifecycleState> states) {
		var LifecycleState highestState = null
		if (!states.nullOrEmpty) {
			for (state : states) {
				if (highestState === null || envLifecycleComparator.compare(state, highestState) > 0) {
					highestState = state
				}
			}
		}
		//@TODO what should be done with environment wise equivalent states?
		return highestState
	}
	
}