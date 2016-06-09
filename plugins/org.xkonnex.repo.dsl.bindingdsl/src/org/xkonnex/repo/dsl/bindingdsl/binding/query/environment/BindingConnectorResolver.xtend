package org.xkonnex.repo.dsl.bindingdsl.binding.query.environment

import com.google.inject.Inject
import java.util.logging.Logger
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.AppServer
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Broker
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ESB
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ProcessServer
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SOAPHTTP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.WebServer
import org.xkonnex.repo.dsl.bindingdsl.binding.query.ServerNotConnectableException
import org.xkonnex.repo.dsl.bindingdsl.model.EffectiveBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IProtocol
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleServer

/*
 * Lookup and resolution of connectors for bindings
 */
class BindingConnectorResolver {
	
	@Inject extension EnvironmentBindingResolver
	@Inject extension IComponentInferrer
	@Inject Logger log
	
	/*
	 * Find the closest matching connector for the given protocol and connector name. If the connector name
	 * is not provided the first closest match based on the supported protocol is returned
	 */	
	def dispatch Connector resolveConnector (Server s, AnyBinding bind, BindingProtocol prot) {
	}
	
	/*
	 * Find the closest matching connector for the given protocol and connector name. If the connector name
	 * is not provided the first closest match based on the supported protocol is returned
	 */	
	def dispatch Connector resolveConnector (Server s, EffectiveBinding bind, BindingProtocol prot) {
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
	def dispatch boolean supportsProtocol (Connector con, BindingProtocol prot) {
		switch (prot) {
			SOAP: 		con instanceof SOAPHTTP || con instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.HTTP
			default: 	false
		}
	}
	
	def dispatch boolean supportsProtocol (Connector con, ExtensibleProtocol extensibleProtocol) {
		val IProtocol prot = extensibleProtocol.inferComponent
		return prot.supportedOnConnector(con)
	}
	
	def getConnectors (Server server) {
		if (server == null)
			throw new IllegalArgumentException("Server may not be null");
		switch (server) {
			AppServer:			(server as AppServer).connectors
			Broker:				(server as Broker).connectors
			ESB:				(server as ESB).connectors
			ProcessServer:		(server as ProcessServer).connectors
			WebServer:			(server as WebServer).connectors
			ExtensibleServer: 	(server as ExtensibleServer).connectors
			default:		{
				log.severe ("Server " + server.name + " of type " + server.eClass.name + " dos not support connectors.")
				throw new ServerNotConnectableException()
			}
		}
	}
}