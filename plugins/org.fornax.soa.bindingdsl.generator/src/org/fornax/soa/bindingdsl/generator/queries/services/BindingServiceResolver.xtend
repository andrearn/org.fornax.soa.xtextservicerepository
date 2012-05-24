package org.fornax.soa.bindingdsl.generator.queries.services

import com.google.inject.Inject
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.environmentDsl.EnvironmentType
import org.fornax.soa.moduledsl.generator.query.ModuleNamespaceQuery
import org.fornax.soa.moduledsl.generator.query.ModuleServiceResolver
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.profiledsl.generator.query.LifecycleQueries
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import java.util.Set
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingdsl.generator.queries.modules.ModuleBindingResolver
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.moduledsl.moduleDsl.Module

class BindingServiceResolver {
	
	@Inject extension ModuleNamespaceQuery
	@Inject extension ModuleBindingResolver
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
	
	def resolveServiceBinding (Service svc, ImportBindingProtocol protocol, Iterable<Module> canditateModules, String qualifier) {
		var Set<Binding> bindings =  newHashSet()
		if (!canditateModules?.empty && qualifier != null) {
			bindings.addAll (svc.findMostSpecificBindings(protocol, qualifier, canditateModules.toSet))
		} else if (!canditateModules?.empty && qualifier == null) {
			bindings.addAll (svc.findMostSpecificBindings(protocol, canditateModules.toSet))
		} else if (canditateModules?.empty && qualifier != null) {
			bindings.addAll (svc.findMostSpecificBindings(protocol, qualifier))
		} else {
			bindings.addAll (svc.findMostSpecificBindings(protocol))
		} 
		return bindings
	}
}