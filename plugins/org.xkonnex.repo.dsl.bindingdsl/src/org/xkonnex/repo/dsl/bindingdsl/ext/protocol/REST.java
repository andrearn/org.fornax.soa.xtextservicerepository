package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import java.util.List;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.HTTP;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.Header;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.HttpResponse;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.RESTParameterStyle;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Verb;

import com.google.common.collect.Lists;

public class REST implements IProtocol {
	
	private String path;
	private Verb verb;
	private RESTParameterStyle parameterStyle;
	private List<String> requestContentType = Lists.newArrayList();
	private List<HttpResponse> response = Lists.newArrayList();
	private List<Header> header = Lists.newArrayList();

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

	/**
	 * URL path part
	 * @param path URL path part
	 */
	public void setPath(String path) {
		this.path = path;
	}

	public Verb getVerb() {
		return verb;
	}

	/**
	 * HTTP operation verb
	 * @param verb
	 */
	public void setVerb(Verb verb) {
		this.verb = verb;
	}

	public RESTParameterStyle getParameterStyle() {
		return parameterStyle;
	}

	/**
	 * Defines how request parameters will be transferred (body, header, URL path or query string...) 
	 * @param parameterStyle
	 */
	public void setParameterStyle(RESTParameterStyle parameterStyle) {
		this.parameterStyle = parameterStyle;
	}

	public List<String> getRequestContentType() {
		return requestContentType;
	}

	public void setRequestContentType(List<String> requestContentType) {
		this.requestContentType = requestContentType;
	}

	/**
	 * Content type of a request body part
	 * @param requestContentType
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
	 * @param response
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

	@Override
	public boolean supportedOnConnector(Connector connector) {
		return connector instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.REST || connector instanceof HTTP;
	}

	@Override
	public boolean supportedOnConnector(IConnector connector) {
		return false;
	}

}
