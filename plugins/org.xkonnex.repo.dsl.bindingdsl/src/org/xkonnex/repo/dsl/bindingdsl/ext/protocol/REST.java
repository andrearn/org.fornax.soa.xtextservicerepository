package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import java.util.List;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.HTTP;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.HttpResponse;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.HttpVerb;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.RESTParameterStyle;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;

import com.google.common.collect.Lists;

public class REST implements IProtocol {
	
	private String path;
	private HttpVerb verb;
	private RESTParameterStyle style;
	private List<String> requestContentType = Lists.newArrayList();
	private List<HttpResponse> response = Lists.newArrayList();

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

	@Override
	public boolean supportedOnConnector(Connector connector) {
		return connector instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.REST || connector instanceof HTTP;
	}

	@Override
	public boolean supportedOnConnector(IConnector connector) {
		return false;
	}

}
