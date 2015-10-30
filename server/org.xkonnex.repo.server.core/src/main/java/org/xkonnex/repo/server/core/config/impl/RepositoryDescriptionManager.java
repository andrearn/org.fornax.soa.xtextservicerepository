package org.xkonnex.repo.server.core.config.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.xkonnex.repo.server.core.config.IRepositoryDescriptionManager;
import org.xkonnex.repo.server.core.config.RepositoryDescription;
import org.xkonnex.repo.server.core.config.RepositoryType;

import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.persist.Transactional;

public class RepositoryDescriptionManager implements IRepositoryDescriptionManager {
	
	@Inject
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see org.fornax.soa.xsr.connex.core.config.IRepositoryDescriptionManager#getStagingRepository()
	 */
	public RepositoryDescription getStagingRepository () {
		TypedQuery<RepositoryDescription> query = em.createNamedQuery(RepositoryDescription.REPOSITORY_DESCRIPTION_BY_TYPE, RepositoryDescription.class);
		query.setParameter("type", RepositoryType.STAGING);
		List<RepositoryDescription> result = query.getResultList();
		if (result.size() == 1)
			return result.get(0);
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see org.fornax.soa.xsr.connex.core.config.IRepositoryDescriptionManager#getMasterRepository()
	 */
	public RepositoryDescription getMasterRepository () {
		TypedQuery<RepositoryDescription> query = em.createNamedQuery(RepositoryDescription.REPOSITORY_DESCRIPTION_BY_TYPE, RepositoryDescription.class);
		query.setParameter("type", RepositoryType.MASTER);
		List<RepositoryDescription> result = query.getResultList();
		if (result.size() == 1)
			return result.get(0);
		else
			return null;
	}
	
	/* (non-Javadoc)
	 * @see org.fornax.soa.xsr.connex.core.config.IRepositoryDescriptionManager#createOrUpdateRepositoryDescription(org.fornax.soa.xsr.connex.core.config.RepositoryDescription)
	 */
	@Transactional
	public void createOrUpdateRepositoryDescription (RepositoryDescription description) {
		if (description.getId() != null) {
			RepositoryDescription existingRepoDescr = em.find(RepositoryDescription.class, description.getId());
			if (existingRepoDescr != null) {
				existingRepoDescr.setName(description.getName());
				existingRepoDescr.setType(description.getType());
				existingRepoDescr.setUrl(description.getUrl());
				existingRepoDescr.setWorkspaceLocation(description.getWorkspaceLocation());
			} else {
				em.persist(description);
			}
		} else {
			em.persist(description);
		}
	}

	public String getRepositoryFolder() {
		// TODO Auto-generated method stub
		return "git";
	}
	
}
