package org.fornax.soa.bindingdsl.generator.templates.wsdl

import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.bindingDsl.Binding
import com.google.inject.Inject
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingdsl.generator.templates.naming.EndpointQualifierNameProvider

class ConcreteWsdlExtensions {
	
	@Inject extension BindingExtensions
	@Inject extension EndpointQualifierNameProvider
	@Inject extension EnvironmentBindingResolver
	@Inject extension SchemaNamespaceExtensions
	
	def String toConcreteWsdlFileNameFragment (Service service, Binding binding) {
		var specBinding = binding.getMostSpecificBinding(service)
		val soapProt = specBinding.protocol.filter (p| p instanceof SOAP).map (e| e as SOAP).head
		val server = specBinding.resolveServer(soapProt)
		if (service.isProviderEndpoint(server))
			return service.getConcreteWsdlFileNameFragment(binding.getProviderEndpointQualifier (service))
		else
			return service.getConcreteWsdlFileNameFragment(binding.getEndpointQualifier (service))
	}

	def String toConcreteWsdlFileNameFragment (Service service, Binding binding, Server server, String qualifier) {
		if (service.isProviderEndpoint(server))
			return service.getConcreteWsdlFileNameFragment(binding.getProviderEndpointQualifier (service))
		else
			return service.getConcreteWsdlFileNameFragment(binding.getEndpointQualifier (service))
		
	}
	
	
	def String getConcreteWsdlFileNameFragment (Service s, String endPointKind) {
		s.eContainer.toFileNameFragment().replaceAll("\\." , "-") + "-" + s.name + endPointKind + "Port" + "-" + s.version.toVersionPostfix();
	}
	
}