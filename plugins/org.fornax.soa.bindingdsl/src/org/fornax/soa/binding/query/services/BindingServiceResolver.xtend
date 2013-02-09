package org.fornax.soa.binding.query.services

import com.google.inject.Inject
import org.fornax.soa.binding.query.BindingLookup
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.moduledsl.query.ModuleNamespaceQuery
import org.fornax.soa.moduledsl.query.ModuleServiceResolver
import org.fornax.soa.profiledsl.query.LifecycleQueries
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle
import org.fornax.soa.serviceDsl.Service

class BindingServiceResolver {
	
	@Inject extension ModuleNamespaceQuery
	@Inject extension BindingLookup
	@Inject ModuleServiceResolver serviceResolver
	@Inject LifecycleQueries lifecycleQueries
	
	def dispatch Service latestServiceInEnvironment (org.fornax.soa.moduledsl.moduleDsl.ServiceRef svcRef, Environment env) {
		val minState = lifecycleQueries.getMinLifecycleState(env, svcRef.service.state.eContainer as Lifecycle);
		serviceResolver.findLatestMatchingServiceMod (svcRef, minState);
	}

	def dispatch Service latestServiceInEnvironment (ImportServiceRef svcRef, Environment env) {
		val minState = lifecycleQueries.getMinLifecycleState(env, svcRef.service.state.eContainer as Lifecycle);
		serviceResolver.findLatestMatchingServiceMod (svcRef, minState);
	}
	
}