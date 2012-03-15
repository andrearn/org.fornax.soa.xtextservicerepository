package org.fornax.soa.bindingdsl.generator.queries.services

import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.environmentDsl.EnvironmentType
import org.fornax.soa.moduledsl.generator.query.ModuleNamespaceQuery
import com.google.inject.Inject
import org.fornax.soa.moduledsl.generator.query.ModuleServiceResolver
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.generator.query.LifecycleQueries
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle

class BindingServiceResolver {
	
	@Inject extension ModuleNamespaceQuery
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
			case EnvironmentType::DEV: {
											if (ns.linkingPolicy != null) {
												ns.linkingPolicy.minDevState
											} else {
												lifecycleQueries.getMinDevState(l)
											}
										}
			case EnvironmentType::TEST: {
											if (ns.linkingPolicy != null) {
												ns.linkingPolicy.minTestState
											} else {
												lifecycleQueries.getMinTestState(l)
											}
										}
			case EnvironmentType::PROD: {
											if (ns.linkingPolicy != null) {
												ns.linkingPolicy.minProdState
											} else {
												lifecycleQueries.getMinProdState(l)
											}
										}
			default: lifecycleQueries.getMinProdState(l)
		}
	}
}