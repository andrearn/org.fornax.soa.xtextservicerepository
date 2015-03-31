package org.xkonnex.repo.server.core.config.impl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.xkonnex.repo.server.core.config.IRepositoryDescriptionManager;
import org.xkonnex.repo.server.core.config.RepositoryDescription;

import com.google.inject.Provides;
import com.google.inject.name.Named;

public class RepositoryDescriptionManager implements IRepositoryDescriptionManager {
	
	@PersistenceUnit(unitName="org.fornax.soa.xsr.connex.core") 
	private EntityManagerFactory factory;	
	
	/* (non-Javadoc)
	 * @see org.fornax.soa.xsr.connex.core.config.IRepositoryDescriptionManager#getStagingRepository()
	 */
	public RepositoryDescription getStagingRepository () {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.fornax.soa.xsr.connex.core.config.IRepositoryDescriptionManager#getMasterRepository()
	 */
	public RepositoryDescription getMasterRepository () {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.fornax.soa.xsr.connex.core.config.IRepositoryDescriptionManager#createOrUpdateRepositoryDescription(org.fornax.soa.xsr.connex.core.config.RepositoryDescription)
	 */
	public void createOrUpdateRepositoryDescription (RepositoryDescription description) {
		
	}

	public String getRepositoryFolder() {
		// TODO Auto-generated method stub
		return "git";
	}
	
}
