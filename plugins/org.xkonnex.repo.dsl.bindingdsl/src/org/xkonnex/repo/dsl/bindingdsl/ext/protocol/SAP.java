package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SapClient;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;

public class SAP implements IProtocol {

	private SAPTransport transport;
	private SapClient client;

	@Override
	public boolean supportsModuleEndpointProtocol(
			EndpointProtocol endpointProtocol) {
		if (endpointProtocol instanceof org.xkonnex.repo.dsl.moduledsl.ext.protocol.SAP)
			return true;
		else
			return false;
	}

	@Override
	public boolean supportsModuleEndpointProtocol(
			Class<? extends IModuleEndpointProtocol> endpointProtocol) {
		return org.xkonnex.repo.dsl.moduledsl.ext.protocol.SAP.class.isAssignableFrom(endpointProtocol);
	}

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

	@Override
	public boolean supportedOnConnector(Connector connector) {
		return connector instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SAP;
	}

	@Override
	public boolean supportedOnConnector(IConnector connector) {
		return false;
	}

}
