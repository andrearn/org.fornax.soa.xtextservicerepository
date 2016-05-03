package org.xkonnex.repo.dsl.environmentdsl.environment.query

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleConnector
import javax.inject.Inject
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer

class ConnectorLookup {
	
	@Inject
	private extension IComponentInferrer
	
	def <T extends Connector> T getConnectorByType(Server server, Class<? extends Connector> connectorType) {
		server.connectors.filter[connectorType.isAssignableFrom(it.getClass()) && it.isIsDefault].head as T
	}
	
	def <T extends IConnector> T getConnectorBeanByType(Server server, Class<? extends IConnector> connector) {
		val T con = server.connectors.filter(typeof(ExtensibleConnector)).filter[it.type.identifier == connector.class.canonicalName && it.isIsDefault].head?.inferComponent
		con 
	}
	
	def ExtensibleConnector getExtensibleConnectorByType(Server server, Class<? extends IConnector> connector) {
		server.connectors.filter(typeof(ExtensibleConnector)).filter[it.type.identifier == connector.class.canonicalName && it.isIsDefault].head
	}
	
	def Connector getConnectorByName(Server server, String connectorName) {
		server.connectors.filter[name == connectorName].head
	}
	
	def IConnector getConnectorBeanByName(Server server, String connectorName) {
		val IConnector con = server.connectors.filter(typeof(ExtensibleConnector)).filter[name == connectorName].head?.inferComponent
		con 
	}
	
	def ExtensibleConnector getExtensibleConnectorByName(Server server, String connectorName) {
		server.connectors.filter(typeof(ExtensibleConnector)).filter[name == connectorName].head
	}
	
}