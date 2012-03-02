package org.fornax.soa.bindingdsl.generator.queries.services

import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.environmentDsl.EnvironmentType
import org.fornax.soa.moduledsl.generator.query.ModuleNamespaceQuery
import com.google.inject.Inject
import org.fornax.soa.moduledsl.generator.query.ModuleServiceResolver
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery

class BindingServiceResolver {
	
	@Inject extension ModuleNamespaceQuery
	@Inject ModuleServiceResolver serviceResolver
	
	def dispatch Service latestServiceInEnvironment (org.fornax.soa.moduledsl.moduleDsl.ServiceRef svcRef, Environment env) {
		val minState = svcRef.findSubdomain().minStateByEnvironment (env);
		serviceResolver.findLatestMatchingServiceMod (svcRef, minState);
	}

	def dispatch Service latestServiceInEnvironment (ImportServiceRef svcRef, Environment env) {
		val minState = svcRef.findSubdomain().minStateByEnvironment (env);
		serviceResolver.findLatestMatchingServiceMod (svcRef, minState);
	}
	
	def dispatch LifecycleState minStateByEnvironment (SubNamespace ns, Environment env) {
		switch (env.type) {
			case EnvironmentType::DEV: {
											if (ns.linkingPolicy != null) {
												ns.linkingPolicy.minDevState
											} else {
												LifecycleState::DEVELOPMENT
											}
										}
			case EnvironmentType::TEST: {
											if (ns.linkingPolicy != null) {
												ns.linkingPolicy.minTestState
											} else {
												LifecycleState::TEST
											}
										}
			case EnvironmentType::PROD: {
											if (ns.linkingPolicy != null) {
												ns.linkingPolicy.minProdState
											} else {
												LifecycleState::PRODUCTIVE
											}
										}
			default: LifecycleState::PRODUCTIVE
		}
	}
}