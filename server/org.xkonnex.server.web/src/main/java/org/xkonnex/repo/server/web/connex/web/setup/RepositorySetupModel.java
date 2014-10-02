package org.xkonnex.repo.server.web.connex.web.setup;

import java.io.Serializable;

public class RepositorySetupModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String masterRepositoryUrl;
	private String stagingRepositoryUrl;
	
	public String getMasterRepositoryUrl() {
		return masterRepositoryUrl;
	}
	public void setMasterRepositoryUrl(String masterRepositoryUrl) {
		this.masterRepositoryUrl = masterRepositoryUrl;
	}
	
	public String getStagingRepositoryUrl() {
		return stagingRepositoryUrl;
	}
	public void setStagingRepositoryUrl(String stagingRepositoryUrl) {
		this.stagingRepositoryUrl = stagingRepositoryUrl;
	}

}
