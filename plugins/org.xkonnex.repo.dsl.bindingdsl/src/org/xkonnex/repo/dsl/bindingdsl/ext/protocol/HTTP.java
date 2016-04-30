package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.HttpVerb;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;


public class HTTP implements IProtocol {

	private String url;
	private HttpVerb verb;

	@Override
	public boolean supportsModuleEndpointProtocol(
			EndpointProtocol endpointProtocol) {
		if (endpointProtocol instanceof org.xkonnex.repo.dsl.moduledsl.ext.protocol.HTTP)
			return true;
		else
			return false;
	}

	@Override
	public boolean supportsModuleEndpointProtocol(
			Class<? extends IModuleEndpointProtocol> endpointProtocol) {
		return org.xkonnex.repo.dsl.moduledsl.ext.protocol.HTTP.class.isAssignableFrom(endpointProtocol);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HttpVerb getVerb() {
		return verb;
	}

	public void setVerb(HttpVerb verb) {
		this.verb = verb;
	}

	@Override
	public boolean supportedOnConnector(Connector connector) {
		return connector instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.HTTP;
	}

	@Override
	public boolean supportedOnConnector(IConnector connector) {
		return false;
	}

}
