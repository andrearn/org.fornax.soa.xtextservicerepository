package org.xkonnex.repo.dsl.environmentdsl.ext.connector;

public class HttpSoapConnector implements IConnector {
	private String httpPort;

	public String getHttpPort() {
		return httpPort;
	}

	public void setHttpPort(String httpPort) {
		this.httpPort = httpPort;
	}

}
