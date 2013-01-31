package org.fornax.soa.bindingdsl.generator.templates

import com.google.inject.Inject
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.EJB
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.SCA
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.environmentDsl.AppServer
import org.fornax.soa.environmentDsl.Broker
import org.fornax.soa.environmentDsl.Connector
import org.fornax.soa.environmentDsl.ESB
import org.fornax.soa.environmentDsl.HTTP
import org.fornax.soa.environmentDsl.IIOP
import org.fornax.soa.environmentDsl.JMS
import org.fornax.soa.environmentDsl.REST
import org.fornax.soa.environmentDsl.RMI
import org.fornax.soa.environmentDsl.SOAPHTTP
import org.fornax.soa.environmentDsl.WebServer
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.environmentdsl.generator.EndpointResolver
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.environmentdsl.generator.ServerNotConnectableException
import java.util.logging.Logger
import java.util.logging.Level
import org.fornax.soa.binding.query.BindingResolver


/*
 * Lookup and resolution of connectors for bindings
 */
class BindingConnectorResolver {
	
	@Inject extension BindingExtensions
	@Inject extension BindingResolver
	@Inject extension EndpointResolver
	@Inject Logger log
	
	/*
	 * Find the closest matching connector for the given protocol and connector name. If the connector name
	 * is not provided the first closest match based on the supported protocol is returned
	 */	
	def dispatch Connector resolveConnector (Server s, EObject bind, BindingProtocol prot) {
	}
	
	def dispatch Connector resolveConnector (Server s, ModuleBinding bind, BindingProtocol prot) {
		val serverConnectors = if (!bind.provider?.provServer?.connectors.nullOrEmpty) 
				bind.provider?.provServer.connectors
			else 
				s.connectors 
		val chosenConnectors = bind.provider?.connectors
		if (!chosenConnectors.nullOrEmpty && !serverConnectors.nullOrEmpty) {
			selectBestMatchingConnector (prot, chosenConnectors, serverConnectors)
		} else if (bind.provider != null && !serverConnectors.nullOrEmpty){
			bind.provider.provServer.findConnectorsByProtocol(prot, serverConnectors)
		} else {
			s.findConnectorsByProtocol(prot, serverConnectors)
		}
		
	}
	
	def dispatch Connector resolveConnector (Server s, DomainBinding bind, BindingProtocol prot) {
		val publisher = prot.publisher
		val serverConnectors = if (!publisher?.pubServer?.connectors.nullOrEmpty)
				publisher?.pubServer.connectors
			else 
				s.connectors 
		val chosenConnectors = publisher?.connectors
		if (!chosenConnectors.nullOrEmpty && !serverConnectors.nullOrEmpty) {
			selectBestMatchingConnector (prot, chosenConnectors, serverConnectors)
		} else {
			s.findConnectorsByProtocol(prot, serverConnectors)
		}
		
	}
	
	def dispatch Connector resolveConnector (Server s, ServiceBinding bind, BindingProtocol prot) {
		val publisher = prot.publisher
		val serverConnectors = if (!publisher?.pubServer?.connectors.nullOrEmpty) 
				publisher?.pubServer?.connectors
			else 
				s.connectors 
		val chosenConnectors = publisher?.connectors
		if (!chosenConnectors.nullOrEmpty && !serverConnectors.nullOrEmpty) {
			selectBestMatchingConnector (prot, chosenConnectors, serverConnectors)
		} else if (publisher != null && !serverConnectors.nullOrEmpty){
			publisher.pubServer.findConnectorsByProtocol(prot, serverConnectors)
		} else {
			s.findConnectorsByProtocol(prot, serverConnectors)
		}
	}
	
	
	/*
	 * Find the closest matching connector to be used for the outbound provider side by the given protocol and connector name. If the connector name
	 * is not provided the first closest match based on the supported protocol is returned
	 */	
//	def dispatch Connector resolveProviderConnector (Server s, EObject bind, BindingProtocol prot) {
//		
//	}
//	
//	def dispatch Connector resolveProviderConnector (Server s, ModuleBinding bind, BindingProtocol prot) {
//		val serverConnectors = if (!bind.provider?.provServer?.connectors.nullOrEmpty) 
//				bind.provider?.provServer?.connectors
//			else 
//				s.connectors 
//		val chosenConnectors = bind.provider.connectors
//		if (!chosenConnectors.nullOrEmpty && !serverConnectors.nullOrEmpty) {
//			selectBestMatchingConnector (prot, chosenConnectors, serverConnectors)
//		} else if (bind.provider != null && !serverConnectors.nullOrEmpty){
//			bind.provider.provServer.findConnectorsByProtocol(prot, serverConnectors)
//		} else {
//			s.findConnectorsByProtocol(prot, serverConnectors)
//		}
//		
//	}
//	
//	def dispatch Connector resolveProviderConnector (Server s, DomainBinding bind, BindingProtocol prot) {
//		val provider = prot.provider
//		val serverConnectors = if (!provider?.provServer?.connectors.nullOrEmpty) 
//				provider?.provServer?.connectors
//			else 
//				s.connectors 
//		val chosenConnectors = provider?.connectors
//		if (!chosenConnectors.nullOrEmpty && !serverConnectors.nullOrEmpty) {
//			selectBestMatchingConnector (prot, chosenConnectors, serverConnectors)
//		} else if (provider != null && !serverConnectors.nullOrEmpty) {
//			provider.provServer.findConnectorsByProtocol(prot, serverConnectors)
//		} else {
//			s.findConnectorsByProtocol(prot, serverConnectors)
//		}
//		
//	}
//	
//	def dispatch Connector resolveProviderConnector (Server s, ServiceBinding bind, BindingProtocol prot) {
//		val provider = prot.provider
//		val serverConnectors = if (!provider?.provServer?.connectors.nullOrEmpty) 
//				provider?.provServer?.connectors
//			else 
//				s.connectors 
//		val chosenConnectors = provider?.connectors
//		if (!chosenConnectors.nullOrEmpty && !serverConnectors.nullOrEmpty) {
//			selectBestMatchingConnector (prot, chosenConnectors, serverConnectors)
//		} else if (provider.provServer != null && !serverConnectors.nullOrEmpty) {
//			provider.provServer.findConnectorsByProtocol(prot, serverConnectors)
//		} else {
//			s.resolveProviderConnector(bind.eContainer, prot)
//		}
//	}
	
	
	
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
			SOAP: 		con instanceof SOAPHTTP
			EJB:		con instanceof RMI || con instanceof IIOP
			SCA:		con instanceof RMI || con instanceof IIOP
			JMS:		con instanceof org.fornax.soa.environmentDsl.JMS
			REST:		con instanceof org.fornax.soa.environmentDsl.REST
			HTTP:		con instanceof org.fornax.soa.environmentDsl.HTTP
			default: 	false
		}
	}
}