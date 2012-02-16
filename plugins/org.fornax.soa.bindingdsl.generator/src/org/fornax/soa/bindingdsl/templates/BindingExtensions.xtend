package org.fornax.soa.bindingdsl.templates

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingDsl.OperationBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.bindingDsl.Binding
import java.util.List
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.environmentDsl.EnvironmentType
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.servicedsl.query.LifecycleQueries
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.basedsl.sOABaseDsl.Version
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.environmentDsl.AppServer
import org.fornax.soa.serviceDsl.VISIBILITY
import org.fornax.soa.environmentDsl.ESB
import org.fornax.soa.basedsl.lifecycle.StateMatcher

class BindingExtensions {
	
	@Inject boolean generatePrivateWsdlForProviderHost
	
	@Inject extension CommonStringExtensions
	@Inject extension StateMatcher
	@Inject extension NamespaceQuery
	@Inject extension LifecycleQueries
	@Inject extension VersionQualifierExtensions

	def boolean generatePrivateWsdlForProviderHost () {
		generatePrivateWsdlForProviderHost;
	}

	def dispatch String getRegistryBaseUrl (EObject o) {}

	def dispatch String getRegistryBaseUrl (DomainBinding b) {
		b.environment.defaultRegistry.baseUrl.stripTrailingSlash();
	}
	
	def dispatch String getRegistryBaseUrl (ServiceBinding b) {
		b.eContainer.getRegistryBaseUrl();
	}
	
	def dispatch String getRegistryBaseUrl (OperationBinding b) {
		b.eContainer.getRegistryBaseUrl();
	}
	
	def dispatch String getRegistryBaseUrl (ModuleBinding b) {
		b.environment.defaultRegistry.baseUrl.stripTrailingSlash();
	}
	
	def dispatch String getRegistryBaseUrl (Environment env) {
		env.defaultRegistry.baseUrl.stripTrailingSlash();
	}
	
	/*
	boolean isEligibleForEnvironment(Service svc, Environment env) :
		switch (env.type) {
			case EnvironmentType::Prod: {
				(svc.state == LifecycleState::productive || 
						svc.state == LifecycleState::deprecated) ? true : false
			}
			case EnvironmentType::PreProd: {
				(svc.state == LifecycleState::productive || 
						svc.state == LifecycleState::deprecated || 
						svc.state == LifecycleState::test) ? true : false
			}
			case EnvironmentType::Test: {
				(svc.state == LifecycleState::productive || 
						svc.state == LifecycleState::deprecated || 
						svc.state == LifecycleState::test) ? true : false
			}
			default: {
				(svc.state != LifecycleState::retired) ? true : false
			}
			
		};
	*/

	def dispatch Binding getMostSpecificBinding (DomainBinding b, Service s) {
		if (b.serviceBinding.filter (e|e.service.service == s).size > 0) {
			b.serviceBinding.findFirst (e|e.service.service == s)
		} else {
			b;
		}
	}
	def dispatch List<BindingProtocol> getProviderProtocols (DomainBinding b) {
		b.protocol;
	}
	
	/* TODO: CONTAINS DEAD CODE!!! */
	def dispatch List<BindingProtocol> getProviderProtocols (ServiceBinding b) {
		if (!b.protocol.isEmpty) {
			b.protocol;
		} else {
			b.protocol;
		}
	}
	def dispatch List<BindingProtocol> getProviderProtocols (OperationBinding b) {
		if (!b.providerProtocol.isEmpty) {
			b.providerProtocol;
		} else {
			b.protocol;
		}
	}
	
	def dispatch List<BindingProtocol> getPublisherProtocols (DomainBinding b) {
		b.protocol;
	}
	def dispatch List<BindingProtocol> getPublisherProtocols (ServiceBinding b) {
		b.protocol;
	}
	def dispatch List<BindingProtocol> getPublisherProtocols (OperationBinding b) {
		b.protocol;
	}
	
	def dispatch LifecycleState getMinLifecycleState (Environment env, EObject o) {
		switch (env.type) {
			case EnvironmentType::DEV : 		o.getOwnerMinDevState()
			case EnvironmentType::TEST:			o.getOwnerMinTestState()
			case EnvironmentType::PRE_PROD :	o.getOwnerMinTestState()
			case EnvironmentType::PROD :		o.getOwnerMinProdState()
			default:							o.getOwnerMinDevState()
		}
	}
	
	def dispatch String toModuleName (String moduleBaseName, Version v) {
		moduleBaseName + "." + v.toVersionPostfix();
	}
			
	def dispatch String toModuleName (SubNamespace subNs, Version v) {
		subNs.findOrgNamespace().prefix + "."  + subNs.name + "." + v.toVersionPostfix();
	}
			
	def dispatch String toModuleName (SubNamespace subNs, Version v, String moduleName) {
		if (moduleName != null) {
			moduleName + "." + v.toVersionPostfix()
		} else {
			subNs.findOrgNamespace().prefix + "."  + subNs.name + "." + v.toVersionPostfix();
		}
	}
	
	def dispatch boolean isPublicEndpoint (Service s, Server server) {
		false;
	}
	def dispatch boolean isPublicEndpoint (Service s, AppServer server) {
		false;
	}
	def dispatch boolean isPublicEndpoint (Service s, ESB server) {
		s.visibility == VISIBILITY::PUBLIC;
	}
	
	def dispatch Binding getMostSpecificBinding (ModuleBinding modBind, Service svc) {
		if (!modBind.serviceBindings.filter (e|e.service.service == svc).isEmpty) { 
			modBind.serviceBindings.findFirst(e|e.service.service == svc);
		} else { 
			modBind;
		}
	}
		
	def dispatch String getServiceVisibilityName (Service s) {
		switch (s.visibility) {
			case VISIBILITY::PUBLIC : "Public"
			case VISIBILITY::DOMAIN : "Domain"
			default: "Private"
		}
	}
		
	def dispatch boolean isEligibleForEnvironment (Service s, Environment env) {
		s.state.matchesMinStateLevel (env.getMinLifecycleState(s));
	}
}