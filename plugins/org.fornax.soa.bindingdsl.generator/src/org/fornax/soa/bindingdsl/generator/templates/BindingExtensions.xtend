package org.fornax.soa.bindingdsl.generator.templates

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.basedsl.sOABaseDsl.Version
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.OperationBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.environmentDsl.AppServer
import org.fornax.soa.environmentDsl.ESB
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.environmentDsl.HTTP
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.profiledsl.query.LifecycleQueries
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Visibility

class BindingExtensions {
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceQuery
	@Inject extension EnvironmentBindingResolver
	@Inject extension LifecycleQueries
	@Inject VersionQualifierExtensions versionQualifier
	@Inject IStateMatcher stateMatcher
	
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
	
	
	def dispatch List<BindingProtocol> getEndpointProtocols (ServiceBinding b) {
		b.protocol;
	}
	def dispatch List<BindingProtocol> getEndpointProtocols (OperationBinding b) {
		b.protocol;
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
			
		
	def dispatch boolean isEligibleForEnvironment (Service s, Environment env) {
		stateMatcher.matches (env.getMinLifecycleState(s.state.eContainer as Lifecycle), s.state);
	}


	
}