package org.fornax.soa.xsr.connex.core.config;


public interface IRepositorySetupService {
	
	void attachStagingReposity (String stagingRepositoryUrl, String workspaceLocation) throws RepositoryConfigException;
	void attachMasterRepository (String masterRepositoryUrl) throws RepositoryConfigException;
	
	String createStagingRepository (String stagingRepositoryUrl, String masterRepositoryUrl) throws RepositoryConfigException;
	String createMasterRepository (String masterRepositoryUrl) throws RepositoryConfigException;

}
