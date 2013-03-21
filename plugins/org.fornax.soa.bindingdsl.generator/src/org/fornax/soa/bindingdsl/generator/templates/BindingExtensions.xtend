package org.fornax.soa.bindingdsl.generator.templates

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.OperationBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.environmentDsl.HTTP

class BindingExtensions {
	
	@Inject extension CommonStringExtensions
	@Inject extension EnvironmentBindingResolver
	
	def dispatch String getRegistryBaseUrl (EObject o) {}
	
	def dispatch String getRegistryBaseUrl (ServiceBinding b) {
		b.eContainer.getRegistryBaseUrl();
	}
	
	def dispatch String getRegistryBaseUrl (OperationBinding b) {
		b.eContainer.getRegistryBaseUrl();
	}
	
	def dispatch String getRegistryBaseUrl (ModuleBinding b) {
		b.resolveEnvironment?.registryBaseUrl
	}
	
	def dispatch String getRegistryBaseUrl (Environment env) {
		if (env.defaultRegistry != null) {
			var regConnector = env.defaultRegistry.connectors.filter (typeof(HTTP)).filter (con | con.isDefault).head
			if (regConnector != null) {
				var baseUrl = ""
				if (env.defaultRegistry?.host != null) {
					baseUrl="http://" + env.defaultRegistry.host?.fqn
					if (regConnector.port != 0 && regConnector.port != 80) {
						baseUrl = baseUrl + ":" + regConnector.port
					}
					if (regConnector.contextRoot != null ) {
						var path = "/"+regConnector.contextRoot ?: ""
						path.replaceAll("//","/")
						baseUrl = baseUrl + path
					}
					
				}
				return baseUrl.stripTrailingSlash();
			}
		}
		return ""
	}
	
	
	def dispatch List<BindingProtocol> getEndpointProtocols (ServiceBinding b) {
		b.protocol;
	}
	def dispatch List<BindingProtocol> getEndpointProtocols (OperationBinding b) {
		b.protocol;
	}
		
}