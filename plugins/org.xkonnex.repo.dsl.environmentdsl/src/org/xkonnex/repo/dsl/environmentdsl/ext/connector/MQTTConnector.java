package org.xkonnex.repo.dsl.environmentdsl.ext.connector;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleConnector;

@Connector
public class MQTTConnector implements IConnector {

	private String port;
	private String securePort;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSecurePort() {
		return securePort;
	}

	public void setSecurePort(String securePort) {
		this.securePort = securePort;
	}

	@Override
	public String getEndpointUrl(ExtensibleConnector connectorDefinition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSecuredEndpointUrl(ExtensibleConnector connectorDefinition) {
		// TODO Auto-generated method stub
		return null;
	}
}
