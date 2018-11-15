package org.xkonnex.repo.generator.environmentdsl

import com.google.inject.Inject
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.environmentdsl.environment.query.ConnectorLookup
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleConnector
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.HTTP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.REST
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SOAPHTTP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.AbstractExecutable

class EndpointResolver {
	
	@Inject extension ConnectorLookup
	@Inject extension IComponentInferrer
	
	def getEndpointUrlByConnectorType(Server server, Class<? extends Connector> connectorType) {
		val Connector con = server.getConnectorByType(connectorType)
		con.getEndpointUrl
	}
	
	def dispatch getEndpointUrl(Connector connector) {
	}
	
	def dispatch getEndpointUrl(SOAPHTTP connector) {
		getHttpEndpointUrl(connector)
	}
	def dispatch getEndpointUrl(HTTP connector) {
		getHttpEndpointUrl(connector)
	}
	def dispatch getEndpointUrl(REST connector) {
		getHttpEndpointUrl(connector)
	}
	def dispatch getEndpointUrl(ExtensibleConnector connector) {
		val IConnector conBean = connector.inferComponent
		conBean.getEndpointUrl(connector)
	}
	
	def dispatch getSecuredEndpointUrl(Connector connector) {
	}
	
	def dispatch getSecuredEndpointUrl(SOAPHTTP connector) {
		getSecuredHttpEndpointUrl(connector)
	}
	def dispatch getSecuredEndpointUrl(HTTP connector) {
		getSecuredHttpEndpointUrl(connector)
	}
	def dispatch getSecuredEndpointUrl(REST connector) {
		getSecuredHttpEndpointUrl(connector)
	}
	def dispatch getSecuredEndpointUrl(ExtensibleConnector connector) {
		val IConnector conBean = connector.inferComponent
		conBean.getSecuredEndpointUrl(connector)
	}
	
	def getSecuredEndpointUrlByConnectorType(Server server, Class<? extends Connector> connectorType) {
		val Connector con = server.getConnectorByType(connectorType)
		getSecuredHttpEndpointUrl(con)
	}
	
	def String getEndpointUrl(String protocolQualifier, String host, String port, String path) {
		val url = new StringBuilder('''«protocolQualifier»://''')
		if (host !== null)
			url.append(host)
		if (port !== null)
			url.append(''':«port»''')
		if (path !== null) {
			if (path.startsWith("/")) url.append(path) else url.append('''/«path»''')
		}
		url.toString
	}
	
	private def dispatch String getHttpEndpointUrl(SOAPHTTP con) {
		val s = EcoreUtil2::getContainerOfType(con, typeof(Server))
		getEndpointUrl("http", s.hostname, con.port.toString(), con.contextRoot?.toContextRootPath)
	}
	private def dispatch String getHttpEndpointUrl(HTTP con) {
		val s = EcoreUtil2::getContainerOfType(con, typeof(Server))
		getEndpointUrl("http", s.hostname, con.port.toString(), con.contextRoot?.toContextRootPath)
	}
	private def dispatch String getHttpEndpointUrl(REST con) {
		val s = EcoreUtil2::getContainerOfType(con, typeof(Server))
		getEndpointUrl("http", s.hostname, con.port.toString(), con.contextRoot?.toContextRootPath)
	}
	
	
	private def dispatch String getSecuredHttpEndpointUrl(SOAPHTTP con) {
		val s = EcoreUtil2::getContainerOfType(con, typeof(Server))
		getEndpointUrl("https", s.hostname, con.securedPort.toString(), con.contextRoot?.toContextRootPath)
	}
	private def dispatch String getSecuredHttpEndpointUrl(HTTP con) {
		val s = EcoreUtil2::getContainerOfType(con, typeof(Server))
		getEndpointUrl("https", s.hostname, con.securedPort.toString(), con.contextRoot?.toContextRootPath)
	}
	private def dispatch String getSecuredHttpEndpointUrl(REST con) {
		val s = EcoreUtil2::getContainerOfType(con, typeof(Server))
		getEndpointUrl("https", s.hostname, con.securedPort.toString(), con.contextRoot?.toContextRootPath)
	}
	
	def private toContextRootPath (String path) {
		return if (path.startsWith("/")) path else '''/«path»''' 
	}
	
	private def hostname(AbstractExecutable exe) {
		if (exe.host !== null) exe.host.fqn else exe.hostAddress
	}
		
}