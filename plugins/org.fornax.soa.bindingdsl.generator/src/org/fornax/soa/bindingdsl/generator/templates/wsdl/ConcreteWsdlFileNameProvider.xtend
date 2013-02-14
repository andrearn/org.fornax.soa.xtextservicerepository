package org.fornax.soa.bindingdsl.generator.templates.wsdl

import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.bindingDsl.Binding
import com.google.inject.Inject
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingdsl.generator.templates.naming.DefaultEndpointQualifierNameProvider
import org.fornax.soa.binding.query.EndpointQualifierQueries
import org.fornax.soa.semanticsDsl.Qualifier
import org.fornax.soa.bindingdsl.generator.templates.naming.IEndpointQualifierNameProvider
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.binding.query.BindingLookup

class ConcreteWsdlFileNameProvider {
	
	@Inject extension BindingLookup
	@Inject extension IEndpointQualifierNameProvider
	@Inject extension SchemaNamespaceExtensions
	
	def String getConcreteWsdlFileNameFragment (Service service, Binding binding) {
		var specBinding = service.getMostSpecificBinding(binding)
		val soapProt = specBinding.protocol.filter (p| p instanceof SOAP).map (e| e as SOAP).head
		return service.getConcreteWsdlFileNameFragment(specBinding.getEndpointQualifierName (service, soapProt))
	}
	
	def String getConcreteWsdlFileNameFragment (Service service, Binding binding, BindingProtocol protocol) {
		var specBinding = service.getMostSpecificBinding(binding)
		return service.getConcreteWsdlFileNameFragment(specBinding.getEndpointQualifierName (service, protocol))
	}
	
	
	def String getConcreteWsdlFileNameFragment (Service s, String endPointKind) {
		s.eContainer.toFileNameFragment().replaceAll("\\." , "-") + "-" + s.name + endPointKind + "Port" + "-" + s.version.toVersionPostfix();
	}
	
}