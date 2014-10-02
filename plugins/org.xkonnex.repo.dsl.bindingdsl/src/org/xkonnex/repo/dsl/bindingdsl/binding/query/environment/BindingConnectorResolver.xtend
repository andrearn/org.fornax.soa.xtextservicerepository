package org.xkonnex.repo.dsl.bindingdsl.binding.query.environment

import com.google.inject.Inject
import java.util.logging.Logger
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EJB
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.HTTP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SCA
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.AppServer
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Broker
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ESB
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.IIOP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.JMS
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ProcessServer
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.REST
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.RMI
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SOAPHTTP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.WebServer
import org.xkonnex.repo.dsl.bindingdsl.binding.query.ServerNotConnectableException
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.FTP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AMQP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.RFC
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SAP


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
			SOAP: 		con instanceof SOAPHTTP || con instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.HTTP
			EJB:		con instanceof RMI || con instanceof IIOP
			JMS:		con instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.JMS
			REST:		con instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.REST || con instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.HTTP
			HTTP:		con instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.HTTP
			FTP:		con instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.FTP
			AMQP:		con instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.AMQP
			SCA:		con instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.IIOP || con instanceof RMI || con instanceof EJB
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