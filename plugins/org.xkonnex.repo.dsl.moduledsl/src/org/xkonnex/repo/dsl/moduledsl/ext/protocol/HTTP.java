package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

import java.util.List;

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Verb;

import com.google.common.collect.Lists;

public class HTTP implements IModuleEndpointProtocol {
	
	protected String version;
	protected String url;
	protected Verb verb;
	protected List<String> requestContentType = Lists.newArrayList();
	protected List<Header> header = Lists.newArrayList();
	protected List<HttpResponse> response = Lists.newArrayList();

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Header> getHeader() {
		return header;
	}

	public void addHeader(Header header) {
		this.header.add(header);
	}

	public Verb getVerb() {
		return verb;
	}

	public void setVerb(Verb verb) {
		this.verb = verb;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
