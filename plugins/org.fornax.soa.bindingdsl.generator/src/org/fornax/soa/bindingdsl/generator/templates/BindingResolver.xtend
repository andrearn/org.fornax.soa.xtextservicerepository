package org.fornax.soa.bindingdsl.generator.templates

import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingDsl.EJB
import org.fornax.soa.bindingDsl.JMS
import org.fornax.soa.bindingDsl.REST
import org.fornax.soa.bindingDsl.SCA

class BindingResolver {
	
	def getPublisher (BindingProtocol prot) {
		switch (prot) {
			SOAP:		(prot as SOAP).publisher
			EJB:		(prot as EJB).publisher
			JMS:		(prot as JMS).publisher
			REST:		(prot as REST).publisher
			SCA:		(prot as SCA).publisher
			default:	null
		}
		
	}
	def getProvider (BindingProtocol prot) {
		switch (prot) {
			SOAP:		(prot as SOAP).provider
			EJB:		(prot as EJB).provider
			JMS:		(prot as JMS).provider
			REST:		(prot as REST).provider
			SCA:		(prot as SCA).provider
			default:	null
		}
		
	}
}