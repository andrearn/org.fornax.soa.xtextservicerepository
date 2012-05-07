package org.fornax.soa.bindingdsl.generator.templates

import com.google.inject.Inject
import com.google.inject.name.Named
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.bindingDsl.SOAP

class BindingProtocolDataContractBuilder {
	
	@Inject @Named ("soapBindingTemplates")
	org.fornax.soa.bindingdsl.generator.templates.IProtocolContractBuilder soapBindingTemplates
	
	def dispatch void toDataContractForProtocol (VersionedDomainNamespace svc, Binding bind, BindingProtocol prot, SOAProfile profile) {
	}
	
	def dispatch void toDataContractForProtocol (SubNamespace svc, Binding bind, BindingProtocol prot, SOAProfile profile) {
	}
	
	
	def dispatch void toDataContractForProtocol (VersionedDomainNamespace svc, Binding bind, SOAP prot, SOAProfile profile) {
	}
	
	def dispatch void toDataContractForProtocol (SubNamespace svc, Binding bind, SOAP prot, SOAProfile profile) {
		
	}
	
}