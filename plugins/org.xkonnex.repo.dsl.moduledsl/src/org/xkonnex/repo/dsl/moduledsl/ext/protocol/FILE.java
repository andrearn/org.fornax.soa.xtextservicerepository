package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

/**
 * File transfer using plain file system access
 */
public class FILE implements IModuleEndpointProtocol {
	
	protected String url;
	protected ReadWrite accessType;
	protected Long pollIntervall;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public ReadWrite getAccessType() {
		return accessType;
	}
	public void setAccessType(ReadWrite accessType) {
		this.accessType = accessType;
	}
	
	public Long getPollIntervall() {
		return pollIntervall;
	}
	public void setPollIntervall(Long pollIntervall) {
		this.pollIntervall = pollIntervall;
	}

}
