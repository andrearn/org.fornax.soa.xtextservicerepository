package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

import java.util.List;

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Verb;

import com.google.common.collect.Lists;

/**
 * HTTP/REST protocol
 */
public class REST implements IModuleEndpointProtocol {
	
	protected String path;
	protected Verb verb;
	protected RESTParameterStyle parameterStyle;
	protected List<String> requestContentType = Lists.newArrayList();
	protected List<HttpResponse> response = Lists.newArrayList();
	protected List<Header> header = Lists.newArrayList();

	public String getPath() {
		return path;
	}

	/**
	 * URL path part
	 */
	public void setPath(String path) {
		this.path = path;
	}

	public Verb getVerb() {
		return verb;
	}

	/**
	 * HTTP operation verb
	 */
	public void setVerb(Verb verb) {
		this.verb = verb;
	}

	public RESTParameterStyle getParameterStyle() {
		return parameterStyle;
	}

	/**
	 * Defines how request parameters will be transferred (body, header, URL path or query string...) 
	 */
	public void setParameterStyle(RESTParameterStyle style) {
		this.parameterStyle = style;
	}

	public List<String> getRequestContentType() {
		return requestContentType;
	}

	public void setRequestContentType(List<String> requestContentType) {
		this.requestContentType = requestContentType;
	}

	/**
	 * Content type of a request body part
	 */
	public void addRequestContentType(String requestContentType) {
		this.requestContentType.add(requestContentType);
	}

	public List<HttpResponse> getResponse() {
		return response;
	}

	public void setResponse(List<HttpResponse> response) {
		this.response = response;
	}

	/**
	 * Defines a response with response code and content
	 */
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
