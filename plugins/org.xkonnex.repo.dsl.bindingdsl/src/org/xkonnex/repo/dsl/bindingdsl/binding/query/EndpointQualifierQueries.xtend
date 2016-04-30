package org.xkonnex.repo.dsl.bindingdsl.binding.query

import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.BindingConnectorResolver
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EndpointVisibility
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Visibility
import com.google.inject.Inject
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Qualifier
import java.util.Set
import com.google.common.base.Predicates
import java.util.List
import org.xkonnex.repo.dsl.bindingdsl.binding.EndpointQualifierDescriptor
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceModuleRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleRef
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportServiceRef
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding

class EndpointQualifierQueries {
	
	@Inject
	private BindingConnectorResolver connectorResolver
	@Inject
	private EnvironmentBindingResolver envResolver
	@Inject
	private IEObjectLookup objLookup
	
	def dispatch Qualifier getEffectiveEndpointQualifier (EObject o) {
		if (o.eContainer != null)
			o.eContainer.effectiveEndpointQualifier
		else
			return null
	}
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
	
	def dispatch Qualifier getEffectiveEndpointQualifier (ServiceModuleRef ref) {
		ref.eContainer.getEffectiveEndpointQualifier
	}
	
	def dispatch Qualifier getEffectiveEndpointQualifier (ModuleRef ref) {
		if (ref.usingEndpoint?.endpointQualifierRef != null)
			return ref.usingEndpoint?.endpointQualifierRef.endpointQualifier
		else {
			val Module mod = objLookup.getOwnerByType(ref, typeof (Module))
			return mod.endpointQualifierRef?.endpointQualifier
		}
	}
	
	def dispatch Qualifier getEffectiveEndpointQualifier (ImportServiceRef ref) {
		if (ref.usingEndpoint?.endpointQualifierRef != null)
			return ref.usingEndpoint?.endpointQualifierRef.endpointQualifier
		else {
			val Module mod = objLookup.getOwnerByType(ref, typeof (Module))
			return mod.endpointQualifierRef?.endpointQualifier
		}
	}
	
	/**
	 * Get the effective endpoint qualifier and qualifiers defined on protocols declared inside the binding. 
	 * An endpoint qualifier on a more specific binding  overrides an endpoint qualifier from a higher level 
	 * more general binding definition. 
	 * Endpoint qualifiers on the protocols defined inside the binding are added at end of the list.
	 */
	def EndpointQualifierDescriptor getPotentialEffectiveEndpointQualifiers (AnyBinding binding) {
		var qualifierDesc = new EndpointQualifierDescriptor()
		qualifierDesc =  getPotentialEffectiveEndpointQualifiersInternal (binding, qualifierDesc)
		return qualifierDesc
	}
	
	def private EndpointQualifierDescriptor getPotentialEffectiveEndpointQualifiersInternal (AnyBinding binding, EndpointQualifierDescriptor qualifierDescriptor) {
		if (binding.endpointQualifierRef?.endpointQualifier != null && qualifierDescriptor.effectiveEndpointQualifier == null) {
			qualifierDescriptor.setEffectiveEndpointQualifier(binding.endpointQualifierRef.endpointQualifier)
		}
		for (prot : binding.protocol) {
			if (prot.endpointQualifierRef?.endpointQualifier != null && qualifierDescriptor.potentialEndpointQualifiers.get(prot) == null) {
				qualifierDescriptor.addPotentialEndpointQualifiers(prot, prot.endpointQualifierRef.endpointQualifier)
			}
		}
		if (! (binding instanceof ModuleBinding) && binding.eContainer instanceof Binding) {
			return getPotentialEffectiveEndpointQualifiersInternal (binding.eContainer as Binding, qualifierDescriptor)
		} else {
			return qualifierDescriptor
		}
	}
	
	
	def isPublicEndpoint (Service service, AnyBinding binding, BindingProtocol prot) {
		val Connector connector = connectorResolver.resolveConnector(envResolver.resolveServer (binding, prot), binding, prot)
		return connector?.endpointVisibility == EndpointVisibility::PUBLIC && service.visibility != Visibility::PRIVATE
	}
	def isExtenalEndpoint (Service service, AnyBinding binding, BindingProtocol prot) {
		val Connector connector = connectorResolver.resolveConnector(envResolver.resolveServer (binding, prot), binding, prot)
		return connector?.endpointVisibility == EndpointVisibility::EXTERNAL
	}
	def isPrivateEndpoint (Service service, AnyBinding binding, BindingProtocol prot) {
		val Connector connector = connectorResolver.resolveConnector(envResolver.resolveServer (binding, prot), binding, prot)
		return connector?.endpointVisibility == EndpointVisibility::PRIVATE || connector.endpointVisibility == null
	}
	
}