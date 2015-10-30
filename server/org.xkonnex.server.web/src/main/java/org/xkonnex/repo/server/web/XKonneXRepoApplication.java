package org.xkonnex.repo.server.web;

import java.io.IOException;
import java.util.Properties;

import org.apache.wicket.Page;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.core.util.file.WebApplicationPath;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.caching.FilenameWithVersionResourceCachingStrategy;
import org.apache.wicket.request.resource.caching.NoOpResourceCachingStrategy;
import org.apache.wicket.request.resource.caching.version.CachingResourceVersion;
import org.apache.wicket.serialize.java.DeflatedJavaSerializer;
import org.apache.wicket.settings.IRequestCycleSettings;
import org.apache.wicket.util.string.Strings;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;
import org.xkonnex.repo.server.core.XKonneXRepoCoreModule;
import org.xkonnex.repo.server.core.config.RepositoryDescription;
import org.xkonnex.repo.server.core.config.impl.RepositoryDescriptionManager;
import org.xkonnex.repo.server.web.auth.BasicAuthenticationSession;
import org.xkonnex.repo.server.web.auth.SignInPage;
import org.xkonnex.repo.server.web.setup.RepositorySetupPage;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.javascript.jscomp.CompilationLevel;


public class XKonneXRepoApplication extends AuthenticatedWebApplication {
	
	private static final String XKONNEX_REPO_CORE_UNIT = "XKonneXRepoCoreUnit";
    private Properties properties;
    protected Injector guiceInjector;
	protected GuiceComponentInjector componentInjector;

    public XKonneXRepoApplication() {
        properties = loadProperties();
//        setConfigurationType(RuntimeConfigurationType.valueOf(properties.getProperty("configuration.type")));
	}
    
	@Override
	protected void init() {
		super.init();
		initGuiceModules();
		configureResourceBundles();
		optimizeForWebPerformance();
        new AnnotatedMountScanner().scanPackage("org.xkonnex.repo.server.web").mount(this);

	}

	protected void initGuiceModules() {
		guiceInjector = Guice.createInjector(new JpaPersistModule(XKONNEX_REPO_CORE_UNIT), new XKonneXRepoCoreModule(), new XKonneXRepoWebModule());
		PersistService persistService = guiceInjector.getInstance(PersistService.class);
		persistService.start();
		componentInjector = new GuiceComponentInjector (this, guiceInjector);
		getComponentInstantiationListeners().add(componentInjector);
	}
	
	@Override
	protected void onDestroy() {
		PersistService persistService = guiceInjector.getInstance(PersistService.class);
		persistService.stop();
		super.onDestroy();
	}

	
	@Override
	public Class<? extends Page> getHomePage() {

		if (isRepositoryInitialized () ) 
			return HomePage.class;
		else
			return RepositorySetupPage.class;
	}

	
    protected boolean isRepositoryInitialized() {
		RepositoryDescriptionManager repositoryDescriptionManager = guiceInjector.getInstance(RepositoryDescriptionManager.class);
		RepositoryDescription masterRepository = repositoryDescriptionManager.getMasterRepository();
		RepositoryDescription stagingRepository = repositoryDescriptionManager.getStagingRepository();
		if (masterRepository != null && stagingRepository != null) {
			return true;
		} else {
			return false;
		}
	}

    
	/**
     * configure all resource bundles (css and js)
     * taken from wicket-bootstrap-examples
     */
    private void configureResourceBundles() {
        getResourceBundles().addJavaScriptBundle(XKonneXRepoApplication.class, "core.js",
                                                 (JavaScriptResourceReference) getJavaScriptLibrarySettings().getJQueryReference(),
                                                 (JavaScriptResourceReference) getJavaScriptLibrarySettings().getWicketEventReference(),
                                                 (JavaScriptResourceReference) getJavaScriptLibrarySettings().getWicketAjaxReference()
        );

        getResourceBundles().addCssBundle(XKonneXRepoApplication.class, "application.css",
                                          org.xkonnex.repo.server.web.layout.FixBootstrapStylesCssResourceReference.INSTANCE
        );
    }

    /**
     * optimize wicket for a better web performance
     */
    private void optimizeForWebPerformance() {
        if (usesDeploymentConfig()) {
            getFrameworkSettings().setSerializer(new DeflatedJavaSerializer(getApplicationKey()));
        } else {
            getResourceSettings().setCachingStrategy(new NoOpResourceCachingStrategy());
        }

        getRequestCycleSettings().setRenderStrategy(IRequestCycleSettings.RenderStrategy.ONE_PASS_RENDER);
    }

    /**
     * @return used configuration properties
     */
    public Properties getProperties() {
    	if  (properties == null) {
    		properties = loadProperties();
    	}
        return properties;
    }

    /**
     * loads all configuration properties from disk
     *
     * @return configuration properties
     */
    private Properties loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new WicketRuntimeException(e);
        }
        return properties;
    }

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return SignInPage.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return BasicAuthenticationSession.class;
	}
}
