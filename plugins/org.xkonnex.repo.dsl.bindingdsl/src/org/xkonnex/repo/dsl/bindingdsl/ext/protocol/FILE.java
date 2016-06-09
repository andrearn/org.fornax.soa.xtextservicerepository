package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;

public class FILE implements IProtocol {

	private String url;
	private ReadWrite accessType;
	private String pollIntervall;

	@Override
	public boolean supportsModuleEndpointProtocol(
			EndpointProtocol endpointProtocol) {
		if (endpointProtocol instanceof org.xkonnex.repo.dsl.moduledsl.ext.protocol.FILE)
			return true;
		else
			return false;
	}

	@Override
	public boolean supportsModuleEndpointProtocol(
			Class<? extends IModuleEndpointProtocol> endpointProtocol) {
		return org.xkonnex.repo.dsl.moduledsl.ext.protocol.FILE.class.isAssignableFrom(endpointProtocol);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ReadWrite getAccessType() {
		return accessType;
	}

	public void setAccessType(ReadWrite accessType) {
		this.accessType = accessType;
	}

	public String getPollIntervall() {
		return pollIntervall;
	}

	public void setPollIntervall(String pollIntervall) {
		this.pollIntervall = pollIntervall;
	}

	@Override
	public boolean supportedOnConnector(Connector connector) {
		return false;
	}

	@Override
	public boolean supportedOnConnector(IConnector connector) {
		// TODO Auto-generated method stub
		return false;
	}

}
