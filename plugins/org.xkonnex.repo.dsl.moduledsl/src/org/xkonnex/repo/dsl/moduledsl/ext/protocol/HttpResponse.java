package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

import java.util.List;

import com.google.common.collect.Lists;

public class HttpResponse {
	
	private Integer statusCode;
	private List<String> contentType = Lists.newArrayList();
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer responseCode) {
		this.statusCode = responseCode;
	}
	
	public List<String> getContentType() {
		return contentType;
	}
	public void setContentType(List<String> contentTypes) {
		this.contentType = contentTypes;
	}
	public void addContentType(String contentType) {
		this.contentType.add(contentType);
	}

}
