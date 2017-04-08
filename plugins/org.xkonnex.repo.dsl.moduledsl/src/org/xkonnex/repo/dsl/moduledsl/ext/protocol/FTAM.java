package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

/**
 * Access service using file transfer via FTAM protocol
 */
public class FTAM implements IModuleEndpointProtocol {
	
	protected String folder;

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

}
