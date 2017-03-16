package org.xkonnex.repo.generator.bindingdsl.templates.wsdl

import com.google.inject.Inject
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.bindingdsl.templates.naming.IEndpointQualifierNameProvider
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions

class ConcreteWsdlFileNameProvider {
	
	@Inject extension BindingLookup
	@Inject extension IEndpointQualifierNameProvider
	@Inject extension SchemaNamespaceExtensions
	
	def String getConcreteWsdlFileNameFragment (Service service, AnyBinding binding) {
		var specBinding = binding
		val soapProt = specBinding.protocol.filter (p| p instanceof SOAP).map (e| e as SOAP).head
		return service.getConcreteWsdlFileNameFragment(specBinding.getEndpointQualifierName (service, soapProt))
	}
	
	def dispatch String getConcreteWsdlFileNameFragment (Service service, AnyBinding binding, BindingProtocol protocol) {
		var specBinding = binding
		return service.getConcreteWsdlFileNameFragment(specBinding.getEndpointQualifierName (service, protocol))
	}
	
	def String getConcreteWsdlFileNameFragment (Service service, Binding binding) {
		var specBinding = service.getMostSpecificBinding(binding)
		val soapProt = specBinding.protocol.filter (p| p instanceof SOAP).map (e| e as SOAP).head
		return service.getConcreteWsdlFileNameFragment(specBinding.getEndpointQualifierName (service, soapProt))
	}
	
	def dispatch String getConcreteWsdlFileNameFragment (Service service, Binding binding, BindingProtocol protocol) {
		var specBinding = service.getMostSpecificBinding(binding)
		return service.getConcreteWsdlFileNameFragment(specBinding.getEndpointQualifierName (service, protocol))
	}
	
	
	def String getConcreteWsdlFileNameFragment (Service s, String endPointKind) {
		s.eContainer.toFileNameFragment().replaceAll("\\." , "-") + "-" + s.name + endPointKind + "Port" + "-" + s.version.toVersionPostfix();
	}
	
}