package org.fornax.soa.servicedsl.templates.webservice

import org.fornax.soa.serviceDsl.DomainNamespace

class WsdlExtensions {
	
	def String toWsdlTargetNamespace (DomainNamespace s) {
		"http://";
	}
}