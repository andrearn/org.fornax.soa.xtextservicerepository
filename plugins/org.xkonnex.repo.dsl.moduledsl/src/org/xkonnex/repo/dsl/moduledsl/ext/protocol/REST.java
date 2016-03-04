package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

public class REST implements IModuleEndpointProtocol {
	
	private String path;
	private HttpVerb verb;
	private String requestContentType;
	private String responseContentType;

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
