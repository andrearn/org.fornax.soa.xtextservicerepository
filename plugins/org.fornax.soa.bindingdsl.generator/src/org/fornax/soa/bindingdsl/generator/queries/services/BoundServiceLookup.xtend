package org.fornax.soa.bindingdsl.generator.queries.services

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.serviceDsl.Service

class BoundServiceLookup {
	
	@Inject extension BindingExtensions
	
	def dispatch Iterable<Service> toServicesWithPublisherProtocol (Binding bind, Class bindingProtocolClass) {
		
	}
	
	def dispatch Iterable<Service> toServicesWithPublisherProtocol (DomainBinding bind, Class bindingProtocolClass) {
		bind.subNamespace.services.filter (s| ! bind.getMostSpecificBinding (s).publisherProtocols
			.map (p|bindingProtocolClass.isInstance (p)).empty
		)
	}
	
	def dispatch Iterable<Service> toServicesWithPublisherProtocol (ModuleBinding bind, Class bindingProtocolClass) {
		bind.module.module.providedServices.map (ref|ref.service as Service).flatten.filter (s| ! bind.getMostSpecificBinding (s).publisherProtocols
			.map (p|bindingProtocolClass.isInstance (p)).empty
		)
	}
	
	def dispatch Iterable<Service> toServicesWithProviderProtocol (Binding bind, Class bindingProtocolClass) {
		
	}
	
	def dispatch Iterable<Service> toServicesWithProviderProtocol (DomainBinding bind, Class bindingProtocolClass) {
		bind.subNamespace.services.filter (s| ! bind.getMostSpecificBinding (s).providerProtocols
			.map(p|bindingProtocolClass.isInstance (p)).empty
		)
	}
	
	def dispatch Iterable<Service> toServicesWithProviderProtocol (ModuleBinding bind, Class bindingProtocolClass) {
		bind.module.module.providedServices.map (ref|ref.service as Service).flatten.filter (s| ! bind.getMostSpecificBinding (s).publisherProtocols
			.map (p|bindingProtocolClass.isInstance (p)).empty
		)
	}
}