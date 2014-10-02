package org.xkonnex.repo.server.web.connex.web;

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
import org.xkonnex.repo.server.web.connex.web.auth.BasicAuthenticationSession;
import org.xkonnex.repo.server.web.connex.web.auth.SignInPage;
import org.xkonnex.repo.server.web.connex.web.setup.RepositorySetupPage;

import com.google.javascript.jscomp.CompilationLevel;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.RenderJavaScriptToFooterHeaderResponseDecorator;
import de.agilecoders.wicket.core.markup.html.references.BootstrapPrettifyCssReference;
import de.agilecoders.wicket.core.markup.html.references.BootstrapPrettifyJavaScriptReference;
import de.agilecoders.wicket.core.markup.html.references.ModernizrJavaScriptReference;
import de.agilecoders.wicket.core.request.resource.caching.version.Adler32ResourceVersion;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.ThemeProvider;
import de.agilecoders.wicket.extensions.javascript.GoogleClosureJavaScriptCompressor;
import de.agilecoders.wicket.extensions.javascript.YuiCssCompressor;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.html5player.Html5PlayerCssReference;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.html5player.Html5PlayerJavaScriptReference;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.OpenWebIconsCssReference;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.jqueryui.JQueryUIJavaScriptReference;
import de.agilecoders.wicket.extensions.request.StaticResourceRewriteMapper;
import de.agilecoders.wicket.less.BootstrapLess;
import de.agilecoders.wicket.themes.markup.html.google.GoogleTheme;
import de.agilecoders.wicket.themes.markup.html.metro.MetroTheme;
import de.agilecoders.wicket.themes.markup.html.wicket.WicketTheme;
import de.agilecoders.wicket.themes.settings.BootswatchThemeProvider;

public class ConnexApplication extends AuthenticatedWebApplication {
	
    private Properties properties;
	

    public ConnexApplication() {
        properties = loadProperties();
//        setConfigurationType(RuntimeConfigurationType.valueOf(properties.getProperty("configuration.type")));
	}
    
	@Override
	protected void init() {
		super.init();
		getComponentInstantiationListeners().add(
				new GuiceComponentInjector (this, new ConnexWebModule()));
		configureBootstrap();
		configureResourceBundles();
		optimizeForWebPerformance();
        new AnnotatedMountScanner().scanPackage("org.fornax.soa.xsr.connex.web").mount(this);

        if (Strings.isTrue(properties.getProperty("cdn.useCdn"))) {
            final String cdn = properties.getProperty("cdn.baseUrl");

            StaticResourceRewriteMapper.withBaseUrl(cdn).install(this);
        }
		getResourceSettings().getResourceFinders().add(
				new WebApplicationPath (getServletContext(), "pages"));
	}

	@Override
	public Class<? extends Page> getHomePage() {
		if (isRepositoryInitialized () ) 
			return HomePage.class;
		else
			return RepositorySetupPage.class;
	}

	
    private boolean isRepositoryInitialized() {
		// TODO Auto-generated method stub
		return false;
	}

    
	/**
     * configure all resource bundles (css and js)
     * taken from wicket-bootstrap-examples
     */
    private void configureResourceBundles() {
        getResourceBundles().addJavaScriptBundle(ConnexApplication.class, "core.js",
                                                 (JavaScriptResourceReference) getJavaScriptLibrarySettings().getJQueryReference(),
                                                 (JavaScriptResourceReference) getJavaScriptLibrarySettings().getWicketEventReference(),
                                                 (JavaScriptResourceReference) getJavaScriptLibrarySettings().getWicketAjaxReference(),
                                                 (JavaScriptResourceReference) ModernizrJavaScriptReference.INSTANCE
        );

        getResourceBundles().addJavaScriptBundle(ConnexApplication.class, "bootstrap.js",
                                                 (JavaScriptResourceReference) Bootstrap.getSettings().getJsResourceReference(),
                                                 (JavaScriptResourceReference) BootstrapPrettifyJavaScriptReference.INSTANCE
        );

        getResourceBundles().addJavaScriptBundle(ConnexApplication.class, "bootstrap-extensions.js",
                                                 JQueryUIJavaScriptReference.instance(),
                                                 Html5PlayerJavaScriptReference.instance()
        );

        getResourceBundles().addCssBundle(ConnexApplication.class, "bootstrap-extensions.css",
                                          Html5PlayerCssReference.instance(),
                                          OpenWebIconsCssReference.instance()
        );

        getResourceBundles().addCssBundle(ConnexApplication.class, "application.css",
                                          (CssResourceReference) BootstrapPrettifyCssReference.INSTANCE,
                                          org.xkonnex.repo.server.web.connex.web.layout.FixBootstrapStylesCssResourceReference.INSTANCE
        );
    }

    /**
     * configures wicket-bootstrap and installs the settings.
     * taken from wicket-bootstrap-examples
     */
    private void configureBootstrap() {
        final ThemeProvider themeProvider = new BootswatchThemeProvider() {{
            add(new MetroTheme());
            add(new GoogleTheme());
            add(new WicketTheme());
            defaultTheme("bootstrap-responsive");
        }};

        final BootstrapSettings settings = new BootstrapSettings();
        settings.setJsResourceFilterName("footer-container")
                .setThemeProvider(themeProvider);
        Bootstrap.install(this, settings);

        BootstrapLess.install(this);
    }

    /**
     * optimize wicket for a better web performance
     */
    private void optimizeForWebPerformance() {
        if (usesDeploymentConfig()) {
            getResourceSettings().setCachingStrategy(new FilenameWithVersionResourceCachingStrategy(
                    "-v-",
                    new CachingResourceVersion(new Adler32ResourceVersion())
            ));

            getResourceSettings().setJavaScriptCompressor(new GoogleClosureJavaScriptCompressor(CompilationLevel.SIMPLE_OPTIMIZATIONS));
            getResourceSettings().setCssCompressor(new YuiCssCompressor());

            getFrameworkSettings().setSerializer(new DeflatedJavaSerializer(getApplicationKey()));
        } else {
            getResourceSettings().setCachingStrategy(new NoOpResourceCachingStrategy());
        }

        setHeaderResponseDecorator(new RenderJavaScriptToFooterHeaderResponseDecorator());
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
