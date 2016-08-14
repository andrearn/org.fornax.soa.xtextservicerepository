package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

import java.util.List;

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Verb;

import com.google.common.collect.Lists;

public class REST implements IModuleEndpointProtocol {
	
	private String path;
	private Verb verb;
	private RESTParameterStyle style;
	private List<String> requestContentType = Lists.newArrayList();
	private List<HttpResponse> response = Lists.newArrayList();
	private List<Header> header = Lists.newArrayList();

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Verb getVerb() {
		return verb;
	}

	public void setVerb(Verb verb) {
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

	public List<Header> getHeader() {
		return header;
	}

	public void addHeader(Header header) {
		this.header.add(header);
	}

}
