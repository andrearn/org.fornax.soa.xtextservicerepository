package org.fornax.soa.bindingdsl.generator.templates

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.basedsl.sOABaseDsl.Version
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingProtocol
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
import org.fornax.soa.serviceDsl.Visibility
import org.fornax.soa.service.query.ServiceDslLifecycleQueries
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import java.util.Set
import org.fornax.soa.service.query.ServiceQueries
import org.fornax.soa.bindingdsl.generator.queries.services.BoundServiceLookup
import org.fornax.soa.environmentDsl.HTTP
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver

class BindingExtensions {
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceQuery
	@Inject extension ServiceDslLifecycleQueries
	@Inject extension EnvironmentBindingResolver
	@Inject VersionQualifierExtensions versionQualifier
	@Inject IStateMatcher stateMatcher
	@Inject BoundServiceLookup boundSvcLookup
	
	def dispatch String getRegistryBaseUrl (EObject o) {}
	
	def dispatch String getRegistryBaseUrl (ServiceBinding b) {
		b.eContainer.getRegistryBaseUrl();
	}
	
	def dispatch String getRegistryBaseUrl (OperationBinding b) {
		b.eContainer.getRegistryBaseUrl();
	}
	
	def dispatch String getRegistryBaseUrl (ModuleBinding b) {
		b.resolveEnvironment.registryBaseUrl
	}
	
	def dispatch String getRegistryBaseUrl (Environment env) {
		var regConnector = env.defaultRegistry?.connectors.filter(typeof(HTTP)).filter (c | c.isDefault).head
		if (regConnector != null) {
			var path = "/"+regConnector.contextRoot
			path.replaceAll("//","/")
			var baseUrl = "http://" + env.defaultRegistry.host.fqn + ":" + regConnector.port + path
			baseUrl.stripTrailingSlash();
		
		}
	}
	
	def dispatch Binding getMostSpecificBinding (Binding b, Service s) {
		
	}
	
	def dispatch List<BindingProtocol> getEndpointProtocols (ServiceBinding b) {
		b.protocol;
	}
	def dispatch List<BindingProtocol> getEndpointProtocols (OperationBinding b) {
		b.protocol;
	}
	
	def LifecycleState getMinLifecycleState (Environment env, EObject o, Lifecycle l) {
		switch (env.type) {
			case EnvironmentType::LOCAL : 		o.toOwnerMinLocalState(l)
			case EnvironmentType::DEV : 		o.toOwnerMinDevState(l)
			case EnvironmentType::TEST:			o.toOwnerMinTestState(l)
			case EnvironmentType::STAGING :		o.toOwnerMinStagingState(l)
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
	
	def dispatch boolean isProviderEndpoint (Service s, Server server) {
		true;
	}
	def dispatch boolean isProviderEndpoint (Service s, AppServer server) {
		true;
	}
	def dispatch boolean isProviderEndpoint (Service s, ESB server) {
		s.visibility == Visibility::PRIVATE;
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
			case Visibility::PUBLIC : "Public"
			case Visibility::DOMAIN : "Domain"
			default: "Private"
		}
	}
		
	def dispatch boolean isEligibleForEnvironment (Service s, Environment env) {
		stateMatcher.matches (env.getMinLifecycleState(s, s.state.eContainer as Lifecycle), s.state);
	}


	
	def dispatch getEndpointQualifier (Binding bind, Service svc) {
		return svc.serviceVisibilityName
	}
	def dispatch getEndpointQualifier (ServiceBinding bind, Service svc) {
		if (bind.eContainer instanceof ModuleBinding) {
			val modBind = (bind.eContainer as ModuleBinding)
			modBind.getEndpointQualifier(svc)
		}
		return svc.serviceVisibilityName
	}
	def dispatch getEndpointQualifier (ModuleBinding bind, Service svc) {
		val moduleQualifier = bind.module.module.qualifiers
		if (moduleQualifier != null)
			return moduleQualifier.qualifiers.head.name.replaceAll("\\.","_")
		return svc.serviceVisibilityName
	}
	/*
	 * Derive a qualifying name for the endpoint
	 * 
	 * FIXME: strange convention to name provider endpoints 
	 */
	def getProviderEndpointQualifier (Binding bind, Service svc) {
		if (svc.visibility == Visibility::PRIVATE)
			return "PrivateProvider"
		else
			return "Private"
	}
	def getProviderEndpointQualifier (ModuleBinding bind, Service svc) {
		val moduleQualifier = bind.module.module.qualifiers
		if (moduleQualifier != null)
			return moduleQualifier.qualifiers.head.name.replaceAll("\\.","_")
		if (svc.visibility == Visibility::PRIVATE)
			return "PrivateProvider"
		else
			return "Private"
	}
}