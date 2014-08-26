package org.fornax.soa.binding.query.environment

import com.google.inject.Inject
import java.util.logging.Logger
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.EJB
import org.fornax.soa.bindingDsl.HTTP
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.SCA
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.environmentDsl.AppServer
import org.fornax.soa.environmentDsl.Broker
import org.fornax.soa.environmentDsl.Connector
import org.fornax.soa.environmentDsl.ESB
import org.fornax.soa.environmentDsl.IIOP
import org.fornax.soa.environmentDsl.JMS
import org.fornax.soa.environmentDsl.ProcessServer
import org.fornax.soa.environmentDsl.REST
import org.fornax.soa.environmentDsl.RMI
import org.fornax.soa.environmentDsl.SOAPHTTP
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.environmentDsl.WebServer
import org.fornax.soa.binding.query.ServerNotConnectableException
import org.fornax.soa.bindingDsl.FTP
import org.fornax.soa.bindingDsl.AMQP
import org.fornax.soa.environmentDsl.RFC
import org.fornax.soa.bindingDsl.SAP


/*
 * Lookup and resolution of connectors for bindings
 */
class BindingConnectorResolver {
	
	@Inject extension EnvironmentBindingResolver;
	@Inject Logger log
	
	/*
	 * Find the closest matching connector for the given protocol and connector name. If the connector name
	 * is not provided the first closest match based on the supported protocol is returned
	 */	
	def dispatch Connector resolveConnector (Server s, EObject bind, BindingProtocol prot) {
	}
	
	def dispatch Connector resolveConnector (Server s, ModuleBinding bind, BindingProtocol prot) {
		val serverConnectors = if (!bind.resolveServer(prot)?.connectors.nullOrEmpty) 
				bind.resolveServer(prot)?.connectors
			else 
				s.connectors 
		val chosenConnectors = prot?.endpointConnector?.connectors
		if (!chosenConnectors.nullOrEmpty && !serverConnectors.nullOrEmpty) {
			selectBestMatchingConnector (prot, chosenConnectors, serverConnectors)
		} else {
			s.findConnectorsByProtocol(prot, serverConnectors)
		}
		
	}
	
	def dispatch Connector resolveConnector (Server s, ServiceBinding bind, BindingProtocol prot) {
		val serverConnectors = if (!bind.resolveServer(prot)?.connectors.nullOrEmpty) 
				bind.resolveServer(prot)?.connectors
			else 
				s.connectors 
		val chosenConnectors = prot?.endpointConnector?.connectors
		if (!chosenConnectors.nullOrEmpty && !serverConnectors.nullOrEmpty) {
			selectBestMatchingConnector (prot, chosenConnectors, serverConnectors)
		} else {
			s.findConnectorsByProtocol(prot, serverConnectors)
		}
	}
	
	
	def dispatch Connector findConnectorsByProtocol (Server s, BindingProtocol prot, Iterable<Connector> canditateConnectors) {
	}
	
	def dispatch Connector findConnectorsByProtocol (AppServer s, BindingProtocol prot, Iterable<Connector> canditateConnectors) {
		selectBestMatchingConnector(prot, s.connectors, canditateConnectors)
	}
	
	def dispatch Connector findConnectorsByProtocol (ESB s, BindingProtocol prot, Iterable<Connector> canditateConnectors) {
		selectBestMatchingConnector(prot, s.connectors, canditateConnectors)
	}

	def dispatch Connector findConnectorsByProtocol (Broker s, BindingProtocol prot, Iterable<Connector> canditateConnectors) {
		selectBestMatchingConnector(prot, s.connectors, canditateConnectors)
	}

	def dispatch Connector findConnectorsByProtocol (WebServer s, BindingProtocol prot, Iterable<Connector> canditateConnectors) {
		selectBestMatchingConnector(prot, s.connectors, canditateConnectors)
	}
	
	
	def Connector selectBestMatchingConnector (Iterable<Connector> con, String connectorName) {
		if (connectorName != null) {
			con.findFirst (c | c.name == connectorName)
		} else {
			con.head
		}
	}

	def Connector selectBestMatchingConnector (BindingProtocol prot, Iterable<Connector> serverConnectors, Iterable<Connector> chosenConnectors) {
		val canditateCon = serverConnectors.filter(e | e.supportsProtocol(prot))
		canditateCon.findFirst (con | chosenConnectors.exists(c|c == con))
	}
	
	/*
	 * Test whether a connector supports the given protocol
	 * 
	 * TODO: complete this for all protocols and possible matches!!!
	 */
	def boolean supportsProtocol (Connector con, BindingProtocol prot) {
		switch (prot) {
			SOAP: 		con instanceof SOAPHTTP || con instanceof org.fornax.soa.environmentDsl.HTTP
			EJB:		con instanceof RMI || con instanceof IIOP
			JMS:		con instanceof org.fornax.soa.environmentDsl.JMS
			REST:		con instanceof org.fornax.soa.environmentDsl.REST || con instanceof org.fornax.soa.environmentDsl.HTTP
			HTTP:		con instanceof org.fornax.soa.environmentDsl.HTTP
			FTP:		con instanceof org.fornax.soa.environmentDsl.FTP
			AMQP:		con instanceof org.fornax.soa.environmentDsl.AMQP
			SCA:		con instanceof org.fornax.soa.environmentDsl.IIOP || con instanceof RMI || con instanceof EJB
			SAP:		con instanceof RFC
			default: 	false
		}
	}
	
	def getConnectors (Server server) {
		if (server == null)
			throw new IllegalArgumentException("Server may not be null");
		switch (server) {
			AppServer:		(server as AppServer).connectors
			Broker:			(server as Broker).connectors
			ESB:			(server as ESB).connectors
			ProcessServer:	(server as ProcessServer).connectors
			WebServer:		(server as WebServer).connectors
			default:		{
				log.severe ("Server " + server.name + " of type " + server.eClass.name + " dos not support connectors.")
				throw new ServerNotConnectableException()
			}
		}
	}
}