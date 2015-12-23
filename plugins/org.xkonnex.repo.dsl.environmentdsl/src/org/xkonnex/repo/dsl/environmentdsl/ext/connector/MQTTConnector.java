package org.xkonnex.repo.dsl.environmentdsl.ext.connector;

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
}
