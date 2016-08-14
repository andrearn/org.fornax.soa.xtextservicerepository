package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

import java.util.List;

import com.google.common.collect.Lists;

public class HTTP implements IModuleEndpointProtocol {
	
	private String version;
	private List<Header> header = Lists.newArrayList();

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

}
