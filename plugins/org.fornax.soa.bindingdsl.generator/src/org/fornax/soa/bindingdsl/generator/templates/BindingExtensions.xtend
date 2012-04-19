package org.fornax.soa.bindingdsl.generator.templates

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.generator.CommonStringExtensions
import org.fornax.soa.basedsl.generator.version.VersionQualifierExtensions
import org.fornax.soa.basedsl.sOABaseDsl.Version
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.OperationBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.environmentDsl.AppServer
import org.fornax.soa.environmentDsl.ESB
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.environmentDsl.EnvironmentType
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.VISIBILITY
import org.fornax.soa.servicedsl.generator.query.LifecycleQueries
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import java.util.Set
import org.fornax.soa.servicedsl.generator.query.ServiceFinder
import org.fornax.soa.bindingdsl.generator.queries.services.BoundServiceLookup

class BindingExtensions {
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceQuery
	@Inject extension LifecycleQueries
	@Inject VersionQualifierExtensions versionQualifier
	@Inject IStateMatcher stateMatcher
	@Inject BoundServiceLookup boundSvcLookup
	
	@Inject @Named ("generatePrivateWsdlForProviderHost") 
	Boolean generatePrivateWsdlForProviderHost

	def boolean generatePrivateWsdlForProviderHost () {
		generatePrivateWsdlForProviderHost;
	}

	def dispatch String getRegistryBaseUrl (EObject o) {}

	def dispatch String getRegistryBaseUrl (DomainBinding b) {
		b.environment?.defaultRegistry?.baseUrl?.stripTrailingSlash();
	}
	
	def dispatch String getRegistryBaseUrl (ServiceBinding b) {
		b.eContainer.getRegistryBaseUrl();
	}
	
	def dispatch String getRegistryBaseUrl (OperationBinding b) {
		b.eContainer.getRegistryBaseUrl();
	}
	
	def dispatch String getRegistryBaseUrl (ModuleBinding b) {
		b.environment?.defaultRegistry?.baseUrl?.stripTrailingSlash();
	}
	
	def dispatch String getRegistryBaseUrl (Environment env) {
		env?.defaultRegistry?.baseUrl?.stripTrailingSlash();
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
	
	def dispatch LifecycleState getMinLifecycleState (Environment env, EObject o, Lifecycle l) {
		switch (env.type) {
			case EnvironmentType::DEV : 		o.toOwnerMinDevState(l)
			case EnvironmentType::TEST:			o.toOwnerMinTestState(l)
			case EnvironmentType::STAGING :		o.toOwnerMinTestState(l)
			case EnvironmentType::PROD :		o.toOwnerMinProdState(l)
			default:							o.toOwnerMinDevState(l)
		}
	}
	
	def dispatch String toModuleName (String moduleBaseName, Version v) {
		moduleBaseName + "." + versionQualifier.toVersionPostfix(v);
	}
			
	def dispatch String toModuleName (SubNamespace subNs, Version v) {
		subNs.findOrgNamespace().prefix + "."  + subNs.name + "." + versionQualifier.toVersionPostfix (v);
	}
			
	def dispatch String toModuleName (SubNamespace subNs, Version v, String moduleName) {
		if (moduleName != null) {
			moduleName + "." + versionQualifier.toVersionPostfix(v)
		} else {
			subNs.findOrgNamespace().prefix + "."  + subNs.name + "." + versionQualifier.toVersionPostfix(v);
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
		stateMatcher.matches (env.getMinLifecycleState(s, s.state.eContainer as Lifecycle), s.state);
	}
	
	def getPublicEndpointQualifier (ModuleBinding bind, Service svc) {
		val moduleQualifier = bind.module.module.qualifiers
		val boundSvcQualifier = bind.module?.module?.providedServices?.findFirst(provSvc | provSvc.service==svc)?.qualifiers
		if (boundSvcQualifier != null)
			return boundSvcQualifier.qualifierName.head.replaceAll("\\.","_")
		if (moduleQualifier != null)
			return moduleQualifier.qualifierName.head.replaceAll("\\.","_")
		return "Public"
	}
	def getPrivateEndpointQualifier (ModuleBinding bind, Service svc) {
		val moduleQualifier = bind.module.module.qualifiers
		val boundSvcQualifier = bind.module?.module?.providedServices?.findFirst(provSvc | provSvc.service==svc)?.qualifiers
		if (boundSvcQualifier != null)
			return boundSvcQualifier.qualifierName.head.replaceAll("\\.","_")
		if (moduleQualifier != null)
			return moduleQualifier.qualifierName.head.replaceAll("\\.","_")
		return "Private"
	}
}