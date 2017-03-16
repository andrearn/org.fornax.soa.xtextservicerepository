package org.xkonnex.repo.generator.bindingdsl.templates

import com.google.inject.Inject
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.bindingdsl.templates.naming.IEndpointQualifierNameProvider
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IProtocol

class DefaultServiceContractFilenameProvider {
	
	@Inject extension BindingLookup
	@Inject extension IEndpointQualifierNameProvider
	@Inject extension SchemaNamespaceExtensions
	
	def String getServiceContractFileNameFragment (Service service, Binding binding, Class<? extends IProtocol> protocolClazz) {
		var specBinding = service.getMostSpecificBinding(binding)
		val soapProt = specBinding.protocol.filter (p| p instanceof ExtensibleProtocol).filter[type.identifier == protocolClazz.canonicalName].head
		return service.getServiceContractFileNameFragment(specBinding.getEndpointQualifierName (service, soapProt))
	}
	
	def String getServiceContractFileNameFragment (Service service, Binding binding, BindingProtocol protocol) {
		var specBinding = service.getMostSpecificBinding(binding)
		return service.getServiceContractFileNameFragment(specBinding.getEndpointQualifierName (service, protocol))
	}
	
	
	def String getServiceContractFileNameFragment (Service s, String endPointKind) {
		s.eContainer.toFileNameFragment().replaceAll("\\." , "-") + "-" + s.name + endPointKind + "-" + s.version.toVersionPostfix();
	}
	
}