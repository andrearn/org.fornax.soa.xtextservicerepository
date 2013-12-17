package org.fornax.soa.xsr.connex.core.config;


public interface IRepositoryDescriptionManager {

	public abstract RepositoryDescription getStagingRepository();

	public abstract RepositoryDescription getMasterRepository();

	public abstract void createOrUpdateRepositoryDescription(
			RepositoryDescription description);
	
	public abstract String getRepositoryFolder();

}