package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import org.xkonnex.repo.dsl.moduledsl.ext.protocol.HttpVerb;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;

public class REST implements IProtocol {
	
	private String path;
	private HttpVerb verb;
	private String requestContentType;
	private String responseContentType;

	@Override
	public boolean supportsModuleEndpointProtocol(
			EndpointProtocol endpointProtocol) {
		if (endpointProtocol instanceof org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST)
			return true;
		else
			return false;
	}

	@Override
	public boolean supportsModuleEndpointProtocol(
			Class<? extends IModuleEndpointProtocol> endpointProtocol) {
		return org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST.class.isAssignableFrom(endpointProtocol);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HttpVerb getVerb() {
		return verb;
	}

	public void setVerb(HttpVerb verb) {
		this.verb = verb;
	}

	public String getRequestContentType() {
		return requestContentType;
	}

	public void setRequestContentType(String requestContentType) {
		this.requestContentType = requestContentType;
	}

	public String getResponseContentType() {
		return responseContentType;
	}

	public void setResponseContentType(String responseContentType) {
		this.responseContentType = responseContentType;
	}

}
