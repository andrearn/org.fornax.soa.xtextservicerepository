package org.xkonnex.repo.generator.bindingdsl.templates.wsdl

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import com.google.inject.Inject
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.generator.bindingdsl.templates.naming.DefaultEndpointQualifierNameProvider
import org.xkonnex.repo.dsl.bindingdsl.binding.query.EndpointQualifierQueries
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Qualifier
import org.xkonnex.repo.generator.bindingdsl.templates.naming.IEndpointQualifierNameProvider
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup

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