package org.fornax.soa.binding.query.services

import com.google.inject.Inject
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.environmentDsl.EnvironmentType
import org.fornax.soa.moduledsl.query.ModuleNamespaceQuery
import org.fornax.soa.moduledsl.query.ModuleServiceResolver
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.profiledsl.search.LifecycleQueries
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import java.util.Set
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.binding.query.BindingLookup
import org.fornax.soa.semanticsDsl.Qualifier

class BindingServiceResolver {
	
	@Inject extension ModuleNamespaceQuery
	@Inject extension BindingLookup
	@Inject ModuleServiceResolver serviceResolver
	@Inject LifecycleQueries lifecycleQueries
	
	def dispatch Service latestServiceInEnvironment (org.fornax.soa.moduledsl.moduleDsl.ServiceRef svcRef, Environment env) {
		val minState = svcRef.findSubdomain().minStateByEnvironment (env, svcRef.service.state.eContainer as Lifecycle);
		serviceResolver.findLatestMatchingServiceMod (svcRef, minState);
	}

	def dispatch Service latestServiceInEnvironment (ImportServiceRef svcRef, Environment env) {
		val minState = svcRef.findSubdomain().minStateByEnvironment (env, svcRef.service.state.eContainer as Lifecycle);
		serviceResolver.findLatestMatchingServiceMod (svcRef, minState);
	}
	
	def dispatch LifecycleState minStateByEnvironment (SubNamespace ns, Environment env, Lifecycle l) {
		switch (env.type) {
			case EnvironmentType::LOCAL: 	lifecycleQueries.getMinLocalState(l)
			case EnvironmentType::DEV: 		lifecycleQueries.getMinDevState(l)
			case EnvironmentType::TEST: 	lifecycleQueries.getMinTestState(l)
			case EnvironmentType::STAGING: 	lifecycleQueries.getMinStagingState(l)
			case EnvironmentType::PROD: 	lifecycleQueries.getMinProdState(l)

			default: lifecycleQueries.getMinProdState(l)
		}
	}
	
	def resolveServiceBinding (Service svc, Environment targetEnvironment, ImportBindingProtocol protocol, Iterable<Module> canditateModules, Qualifier endpointQualifier) {
		var Set<Binding> bindings =  newHashSet()
		if (!canditateModules?.empty && endpointQualifier != null) {
			bindings.addAll (svc.findMostSpecificBindings(targetEnvironment, protocol, endpointQualifier, canditateModules.toSet))
		} else if (!canditateModules?.empty && endpointQualifier == null) {
			bindings.addAll (svc.findMostSpecificBindings(targetEnvironment, protocol, canditateModules.toSet))
		} else if (canditateModules?.empty && endpointQualifier != null) {
			bindings.addAll (svc.findMostSpecificBindings(targetEnvironment, protocol, endpointQualifier))
		} else {
			bindings.addAll (svc.findMostSpecificBindings(targetEnvironment, protocol))
		} 
		return bindings
	}
}