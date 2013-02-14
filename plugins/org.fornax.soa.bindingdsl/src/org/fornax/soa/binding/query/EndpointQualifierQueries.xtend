package org.fornax.soa.binding.query

import org.fornax.soa.binding.query.environment.BindingConnectorResolver
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.environmentDsl.Connector
import org.fornax.soa.environmentDsl.EndpointVisibility
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.Visibility
import com.google.inject.Inject
import org.fornax.soa.bindingDsl.ModuleBinding
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.semanticsDsl.Qualifier

class EndpointQualifierQueries {
	
	@Inject
	private BindingConnectorResolver connectorResolver
	@Inject
	private EnvironmentBindingResolver envResolver
	
	def dispatch Qualifier getEffectiveEndpointQualifier (EObject binding) {
		
	}
	
	def dispatch Qualifier getEffectiveEndpointQualifier (Binding binding) {
		if (binding.endpointQualifierRef?.endpointQualifier != null)
			return binding.endpointQualifierRef.endpointQualifier
		else if (! (binding instanceof ModuleBinding)) 
			getEffectiveEndpointQualifier (binding.eContainer)
		else
			return null
	}
	
	def dispatch Qualifier getEffectiveEndpointQualifier (BindingProtocol prot) {
		if (prot.endpointQualifierRef?.endpointQualifier != null)
			return prot.endpointQualifierRef?.endpointQualifier
		else if (prot.eContainer instanceof Binding)
			return getEffectiveEndpointQualifier (prot.eContainer as Binding)
		else
			return null
	}
	
	def isPublicEndpoint (Service service, Binding binding, BindingProtocol prot) {
		val Connector connector = connectorResolver.resolveConnector(envResolver.resolveServer (binding, prot), binding, prot)
		return connector.endpointVisibility == EndpointVisibility::PUBLIC && service.visibility != Visibility::PRIVATE
	}
	def isExtenalEndpoint (Service service, Binding binding, BindingProtocol prot) {
		val Connector connector = connectorResolver.resolveConnector(envResolver.resolveServer (binding, prot), binding, prot)
		return connector.endpointVisibility == EndpointVisibility::EXTERNAL
	}
	def isPrivateEndpoint (Service service, Binding binding, BindingProtocol prot) {
		val Connector connector = connectorResolver.resolveConnector(envResolver.resolveServer (binding, prot), binding, prot)
		return connector.endpointVisibility == EndpointVisibility::PRIVATE || connector.endpointVisibility == null
	}
	
}