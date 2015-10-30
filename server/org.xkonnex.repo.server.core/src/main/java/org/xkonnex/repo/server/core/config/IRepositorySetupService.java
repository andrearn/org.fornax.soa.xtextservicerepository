package org.xkonnex.repo.server.core.config;

import java.net.URI;


public interface IRepositorySetupService {
	
	void attachStagingRepository (URI stagingRepositoryUri, URI workspaceLocation) throws RepositoryConfigException;
	void attachMasterRepository (URI masterRepositoryUri) throws RepositoryConfigException;
	
	String createStagingRepository (URI stagingRepositoryUri, URI masterRepositoryUrl) throws RepositoryConfigException;
	String createMasterRepository (URI masterRepositoryUri) throws RepositoryConfigException;

}
