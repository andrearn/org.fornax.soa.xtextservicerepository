package org.fornax.soa.environmentdsl.generator

import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.environmentDsl.SOAPHTTP
import org.fornax.soa.environmentDsl.ESB
import org.fornax.soa.environmentDsl.AppServer

class EndpointResolver {
	
	def dispatch String getSOAPHttpEndpointUrl (Server s) {
		if (s.getSOAPHttpEndpoint() != null) {
			if (s.getSOAPHttpEndpoint().contextRoot != null) {
				("http://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint().port.toString() + s.getSOAPHttpEndpoint().contextRoot)
			} else {
				("http://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint().port.toString())
			}
		}
	}
			
	def dispatch String getSecuredSOAPHttpEndpointUrl (Server s) {
		if (s.getSOAPHttpEndpoint() != null) {
			if (s.getSOAPHttpEndpoint().contextRoot != null) { 
				("https://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint().port.toString() + s.getSOAPHttpEndpoint().contextRoot)
			} else {
				("https://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint().port.toString())
			}
		}
	}
	
	def dispatch SOAPHTTP getSOAPHttpEndpoint (Server s) {}
	
	def dispatch SOAPHTTP getSOAPHttpEndpoint (AppServer s) {
		s.connectors.filter (typeof (SOAPHTTP)).head();
	}
	
	def dispatch SOAPHTTP getSOAPHttpEndpoint (ESB s) {
		s.connectors.filter (typeof (SOAPHTTP)).head();
	}
		
}