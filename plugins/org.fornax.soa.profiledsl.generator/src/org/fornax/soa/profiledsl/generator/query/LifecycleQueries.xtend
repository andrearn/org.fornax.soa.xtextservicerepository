package org.fornax.soa.profiledsl.generator.query

import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.basedsl.search.EObjectLookup
import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.environmentDsl.EnvironmentType

class LifecycleQueries {
	
	@Inject EObjectLookup lookup
	@Inject extension LifecycleStateComparator stateComparator
	@Inject extension IStateMatcher
	
	def LifecycleState stateByName (String state, Resource res) {
		lookup.getModelElementByName (state, res, "LifecycleState");
	}
	def dispatch LifecycleState getMinDevState (Lifecycle l) {
		l.states.filter (s | s.supportsEnvironmentType (EnvironmentType::DEV)).sort (stateComparator).head
	}


	def dispatch LifecycleState getMinTestState (Lifecycle l) {
		l.states.filter (s | s.supportsEnvironmentType (EnvironmentType::TEST)).sort (stateComparator).head
	}

	def dispatch LifecycleState getMinStagingState (Lifecycle l) {
		l.states.filter (s | s.supportsEnvironmentType (EnvironmentType::STAGING)).sort (stateComparator).head
	}
	

	def dispatch LifecycleState getMinProdState (Lifecycle l) {
		l.states.filter (s | s.supportsEnvironmentType (EnvironmentType::PROD)).sort (stateComparator).head
	}
	
	
}