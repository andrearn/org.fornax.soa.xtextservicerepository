package org.xkonnex.repo.generator.bindingdsl.templates

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.OperationBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.HTTP
import org.xkonnex.repo.dsl.bindingdsl.model.EffectiveBinding

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
	def dispatch String getRegistryBaseUrl (EffectiveBinding b) {
		b.resolveEnvironment?.registryBaseUrl
	}
	
	def dispatch String getRegistryBaseUrl (Environment env) {
		if (env.defaultRegistry !== null) {
			var regConnector = env.defaultRegistry.connectors.filter (typeof(HTTP)).filter (con | con.isDefault).head
			if (regConnector !== null) {
				var baseUrl = ""
				if (env.defaultRegistry?.host !== null) {
					baseUrl="http://" + env.defaultRegistry.host?.fqn
					if (regConnector.port != 0 && regConnector.port != 80) {
						baseUrl = baseUrl + ":" + regConnector.port
					}
					if (regConnector.contextRoot !== null ) {
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