package org.xkonnex.repo.generator.bindingdsl.templates

import com.google.inject.Inject
import com.google.inject.name.Named
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP

class BindingProtocolDataContractBuilder {
	
	@Inject @Named ("soapBindingTemplates")
	org.xkonnex.repo.generator.bindingdsl.templates.IProtocolContractBuilder soapBindingTemplates
	
	def dispatch void toDataContractForProtocol (VersionedDomainNamespace svc, Binding bind, BindingProtocol prot, SOAProfile profile) {
	}
	
	def dispatch void toDataContractForProtocol (SubNamespace svc, Binding bind, BindingProtocol prot, SOAProfile profile) {
	}
	
	
	def dispatch void toDataContractForProtocol (VersionedDomainNamespace svc, Binding bind, SOAP prot, SOAProfile profile) {
	}
	
	def dispatch void toDataContractForProtocol (SubNamespace svc, Binding bind, SOAP prot, SOAProfile profile) {
		
	}
	
}