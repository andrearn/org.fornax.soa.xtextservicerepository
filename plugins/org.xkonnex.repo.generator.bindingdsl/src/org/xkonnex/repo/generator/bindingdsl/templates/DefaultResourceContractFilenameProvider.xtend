package org.xkonnex.repo.generator.bindingdsl.templates

import com.google.inject.Inject
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.generator.bindingdsl.templates.naming.IEndpointQualifierNameProvider
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IProtocol
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource

class DefaultResourceContractFilenameProvider {
	
	@Inject extension BindingLookup
	@Inject extension IEndpointQualifierNameProvider
	@Inject extension SchemaNamespaceExtensions
	
	def String getResourceContractFileNameFragment (Resource service, Binding binding, Class<? extends IProtocol> protocolClazz) {
		var specBinding = service.getMostSpecificBinding(binding)
		val soapProt = specBinding.protocol.filter (p| p instanceof ExtensibleProtocol).filter[type.identifier == protocolClazz.canonicalName].head
		return service.getResourceContractFileNameFragment(specBinding.getEndpointQualifierName (service, soapProt))
	}
	
	def String getResourceContractFileNameFragment (Resource service, Binding binding, BindingProtocol protocol) {
		var specBinding = service.getMostSpecificBinding(binding)
		return service.getResourceContractFileNameFragment(specBinding.getEndpointQualifierName (service, protocol))
	}
	
	
	def String getResourceContractFileNameFragment (Resource s, String endPointKind) {
		s.eContainer.toFileNameFragment().replaceAll("\\." , "-") + "-" + s.name + endPointKind + "-" + s.version.toVersionPostfix();
	}
	
}