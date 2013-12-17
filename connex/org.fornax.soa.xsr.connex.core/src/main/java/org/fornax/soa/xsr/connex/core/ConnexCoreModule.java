package org.fornax.soa.xsr.connex.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.fornax.soa.xsr.connex.core.config.GitRepositorySetupService;
import org.fornax.soa.xsr.connex.core.config.IRepositoryDescriptionManager;
import org.fornax.soa.xsr.connex.core.config.IRepositorySetupService;
import org.fornax.soa.xsr.connex.core.config.RepositoryDescriptionManager;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class ConnexCoreModule extends AbstractModule {

	private static final String CONNEX_CORE_UNIT = "ConnexCoreUnit";
	private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE = new ThreadLocal<EntityManager>();
	
	@Override
	protected void configure() {
		bind (IRepositorySetupService.class).to (GitRepositorySetupService.class);
		bind (IRepositoryDescriptionManager.class).to(RepositoryDescriptionManager.class);
	}
	
	@Provides
	@Singleton
	public EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory (CONNEX_CORE_UNIT);
	}

	@Provides
	public EntityManager createEntityManager(
			EntityManagerFactory entityManagerFactory) {
		EntityManager entityManager = ENTITY_MANAGER_CACHE.get();
		if (entityManager == null) {
			ENTITY_MANAGER_CACHE.set(entityManager = entityManagerFactory
					.createEntityManager());
		}
		return entityManager;
	}

}
