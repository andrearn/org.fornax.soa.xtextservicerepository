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
import java.util.Set
import com.google.common.base.Predicates
import java.util.List
import org.fornax.soa.binding.EndpointQualifierDescriptor

class EndpointQualifierQueries {
	
	@Inject
	private BindingConnectorResolver connectorResolver
	@Inject
	private EnvironmentBindingResolver envResolver
	
	/**
	 * Get the effective endpoint qualifier. An endpoint qualifier on a more specific binding
	 * overrides an endpoint qualifier from a higher level more general binding definition. 
	 * Endpoint qualifiers on the protocols defined inside the binding are ignored.
	 */
	def dispatch Qualifier getEffectiveEndpointQualifier (Binding binding) {
		if (binding.endpointQualifierRef?.endpointQualifier != null) {
			return binding.endpointQualifierRef.endpointQualifier
		} else if (! (binding instanceof ModuleBinding) && binding.eContainer instanceof Binding) {
			return getEffectiveEndpointQualifier (binding.eContainer as Binding)
		} else {
			return null
		}
	}
	
	/**
	 * Get the effective endpoint qualifier. An endpoint qualifier on the protocol definition
	 * overrides an endpoint qualifier from it's declaring binding or a higher level more general binding definition.
	 */
	def dispatch Qualifier getEffectiveEndpointQualifier (BindingProtocol prot) {
		if (prot.endpointQualifierRef?.endpointQualifier != null)
			return prot.endpointQualifierRef?.endpointQualifier
		else if (prot.eContainer instanceof Binding)
			return getEffectiveEndpointQualifier (prot.eContainer as Binding)
		else
			return null
	}
	
	/**
	 * Get the effective endpoint qualifier and qualifiers defined on protocols declared inside the binding. 
	 * An endpoint qualifier on a more specific binding  overrides an endpoint qualifier from a higher level 
	 * more general binding definition. 
	 * Endpoint qualifiers on the protocols defined inside the binding are added at end of the list.
	 */
	def EndpointQualifierDescriptor getPotentialEffectiveEndpointQualifiers (Binding binding) {
		var qualifierDesc = new EndpointQualifierDescriptor()
		qualifierDesc =  getPotentialEffectiveEndpointQualifiersInternal (binding, qualifierDesc)
		return qualifierDesc
	}
	
	def private EndpointQualifierDescriptor getPotentialEffectiveEndpointQualifiersInternal (Binding binding, EndpointQualifierDescriptor qualifierDescriptor) {
		var List<Qualifier> effectiveQualifiers = newArrayList()
		if (binding.endpointQualifierRef?.endpointQualifier != null) {
			qualifierDescriptor.setEffectiveEndpointQualifier(binding.endpointQualifierRef.endpointQualifier)
			for (prot : binding.protocol) {
				if (prot.endpointQualifierRef?.endpointQualifier != null) {
					qualifierDescriptor.addPotentialEndpointQualifiers(prot, prot.endpointQualifierRef?.endpointQualifier)
				}
			}
			return qualifierDescriptor
		} else if (! (binding instanceof ModuleBinding) && binding.eContainer instanceof Binding) {
			return getPotentialEffectiveEndpointQualifiersInternal (binding.eContainer as Binding, qualifierDescriptor)
		}
		return qualifierDescriptor
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