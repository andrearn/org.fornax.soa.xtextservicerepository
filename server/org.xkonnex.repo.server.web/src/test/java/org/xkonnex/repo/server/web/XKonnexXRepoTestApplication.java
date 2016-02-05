package org.xkonnex.repo.server.web;

import org.apache.wicket.guice.GuiceComponentInjector;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class XKonnexXRepoTestApplication extends XKonneXRepoApplication {

	private static final String XKONNEX_REPO_CORE_UNIT = "XKonneXRepoCoreUnitTest";
	
	@Override
	protected void initGuiceModules() {
		guiceInjector = Guice.createInjector(new JpaPersistModule(XKONNEX_REPO_CORE_UNIT), new XKonneXRepoWebModule());
		PersistService persistService = guiceInjector.getInstance(PersistService.class);
		persistService.start();
		componentInjector = new GuiceComponentInjector (this, guiceInjector);
		getComponentInstantiationListeners().add(componentInjector);
	}

}
