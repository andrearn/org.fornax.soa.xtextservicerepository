package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

import java.util.List;

import com.google.common.collect.Lists;

public class REST implements IModuleEndpointProtocol {
	
	private String path;
	private HttpVerb verb;
	private RESTParameterStyle style;
	private List<String> requestContentType = Lists.newArrayList();
	private List<HttpResponse> response = Lists.newArrayList();

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

	public RESTParameterStyle getStyle() {
		return style;
	}

	public void setStyle(RESTParameterStyle style) {
		this.style = style;
	}

	public List<String> getRequestContentType() {
		return requestContentType;
	}

	public void setRequestContentType(List<String> requestContentType) {
		this.requestContentType = requestContentType;
	}

	public void addRequestContentType(String requestContentType) {
		this.requestContentType.add(requestContentType);
	}

	public List<HttpResponse> getResponse() {
		return response;
	}

	public void setResponse(List<HttpResponse> response) {
		this.response = response;
	}

	public void addResponse(HttpResponse response) {
		this.response.add(response);
	}

}
