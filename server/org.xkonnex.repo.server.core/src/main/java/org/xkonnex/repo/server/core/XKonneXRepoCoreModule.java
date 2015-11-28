package org.xkonnex.repo.server.core;

import java.util.List;

import javax.persistence.EntityManager;

import org.xkonnex.repo.core.XKonneXRepoDSL;
import org.xkonnex.repo.server.core.config.IRepositoryDescriptionManager;
import org.xkonnex.repo.server.core.config.IRepositorySetupService;
import org.xkonnex.repo.server.core.config.impl.GitRepositorySetupService;
import org.xkonnex.repo.server.core.config.impl.RepositoryDescriptionManager;
import org.xkonnex.repo.server.core.resource.DSLConfigurer;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

public class XKonneXRepoCoreModule extends AbstractModule {

	private static final String XKONNEX_REPO_CORE_UNIT = "XKonneXRepoCoreUnit";
	private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE = new ThreadLocal<EntityManager>();
	
	@Override
	protected void configure() {
//		install(new JpaPersistModule(XKONNEX_REPO_CORE_UNIT));
		final DSLConfigurer configurer = new DSLConfigurer();
		List<Injector> injectors = configurer.getInjectors();
		bind(new TypeLiteral<List<Injector>>(){}).annotatedWith(XKonneXRepoDSL.class).toInstance(injectors);
		bind (IRepositorySetupService.class).to (GitRepositorySetupService.class);
		bind (IRepositoryDescriptionManager.class).to(RepositoryDescriptionManager.class);
	}
	
//	@Provides
//	@Singleton
//	public EntityManagerFactory createEntityManagerFactory() {
//		return Persistence.createEntityManagerFactory (XKONNEX_REPO_CORE_UNIT);
//	}
//
//	@Provides
//	public EntityManager createEntityManager(
//			EntityManagerFactory entityManagerFactory) {
//		EntityManager entityManager = ENTITY_MANAGER_CACHE.get();
//		if (entityManager == null) {
//			ENTITY_MANAGER_CACHE.set(entityManager = entityManagerFactory
//					.createEntityManager());
//		}
//		return entityManager;
//	}

}
