package org.xkonnex.repo.generator.environmentdsl

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.AppServer
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Broker
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ESB
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ProcessServer
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SOAPHTTP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.WebServer
import com.google.inject.Inject
import java.util.logging.Logger

class EndpointResolver {
	
	@Inject Logger log
	
	def dispatch String getSOAPHttpEndpointUrl (Server s) {
		if (s.getSOAPHttpEndpoint() != null) {
			if (s.getSOAPHttpEndpoint().contextRoot != null) {
				("http://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint().port.toString() + s.getSOAPHttpEndpoint().contextRoot.toContextRootPath)
			} else {
				("http://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint().port.toString())
			}
		}
	}
	def dispatch String getSOAPHttpEndpointUrl (Server s, Connector con) {
		if (s.getSOAPHttpEndpoint(con) != null) {
			if (s.getSOAPHttpEndpoint(con).contextRoot != null) {
				("http://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint(con).port.toString() + s.getSOAPHttpEndpoint(con).contextRoot.toContextRootPath)
			} else {
				("http://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint(con).port.toString())
			}
		}
	}
			
	def dispatch String getSecuredSOAPHttpEndpointUrl (Server s) {
		if (s.getSOAPHttpEndpoint() != null) {
			if (s.getSOAPHttpEndpoint().contextRoot != null) { 
				("https://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint().port.toString() + s.getSOAPHttpEndpoint().contextRoot.toContextRootPath)
			} else {
				("https://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint().port.toString())
			}
		}
	}
			
	def dispatch String getSecuredSOAPHttpEndpointUrl (Server s, Connector con) {
		if (s.getSOAPHttpEndpoint() != null) {
			if (s.getSOAPHttpEndpoint(con).contextRoot != null) { 
				("https://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint(con).port.toString() + s.getSOAPHttpEndpoint(con).contextRoot.toContextRootPath)
			} else {
				("https://" + s.host.fqn + ":" + s.getSOAPHttpEndpoint(con).port.toString())
			}
		}
	}
	
	def dispatch SOAPHTTP getSOAPHttpEndpoint (Server s) {}
	def dispatch SOAPHTTP getSOAPHttpEndpoint (Server s, Connector con) {}
	
	def dispatch SOAPHTTP getSOAPHttpEndpoint (AppServer s) {
		val con = s.connectors.filter (typeof (SOAPHTTP)).findFirst (e|e.isDefault);
		if (con == null) 
			return s.connectors.filter (typeof (SOAPHTTP)).head;
		return con;
	}
	def dispatch SOAPHTTP getSOAPHttpEndpoint (AppServer s, Connector con) {
		s.connectors.filter (typeof (SOAPHTTP)).findFirst (e|e == con);
	}
	
	def dispatch SOAPHTTP getSOAPHttpEndpoint (ESB s) {
		val con = s.connectors.filter (typeof (SOAPHTTP)).findFirst (e|e.isDefault);
		if (con == null) 
			return s.connectors.filter (typeof (SOAPHTTP)).head;
		return con;
	}
	def dispatch SOAPHTTP getSOAPHttpEndpoint (ESB s, Connector con) {
		s.connectors.filter (typeof (SOAPHTTP)).findFirst (e|e == con);
	}
	
	def private toContextRootPath (String path) {
		return if (path.startsWith("/")) path else '''/«path»''' 
	}
	
		
}