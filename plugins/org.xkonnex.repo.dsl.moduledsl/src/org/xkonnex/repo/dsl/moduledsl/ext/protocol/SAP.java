package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SapClient;

public class SAP implements IModuleEndpointProtocol {
	
	protected SAPTransport transport;
	protected SapClient client;
	
	public SAPTransport getTransport() {
		return transport;
	}
	public void setTransport(SAPTransport transport) {
		this.transport = transport;
	}
	
	public SapClient getClient() {
		return client;
	}
	public void setClient(SapClient client) {
		this.client = client;
	}

}
