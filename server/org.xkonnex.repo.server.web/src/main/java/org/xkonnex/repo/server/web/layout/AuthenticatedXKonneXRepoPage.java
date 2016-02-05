package org.xkonnex.repo.server.web.layout;

import java.util.Properties;

import org.apache.wicket.Application;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.FilteredHeaderItem;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.xkonnex.repo.server.web.XKonneXRepoApplication;

public abstract class AuthenticatedXKonneXRepoPage<T> extends GenericWebPage<T>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticatedXKonneXRepoPage() {
		this(null);
	}
	
	public AuthenticatedXKonneXRepoPage(PageParameters parameters) {
        super(parameters);

        add(new AuthenticatedNavBarPanel("navbar"));
        add(new Footer("footer"));
	}

	@Override
	protected void onConfigure() {
		AuthenticatedWebApplication app = (AuthenticatedWebApplication) Application
				.get();
		// if user is not signed in, redirect him to sign in page
		if (!AuthenticatedWebSession.get().isSignedIn())
			app.restartResponseAtSignInPage();
		super.onConfigure();
	}
    /**
     * @return application properties
     */
    public Properties getProperties() {
        return ((XKonneXRepoApplication) XKonneXRepoApplication.get()).getProperties();
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(FixBootstrapStylesCssResourceReference.INSTANCE));
        response.render(new FilteredHeaderItem(JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()), "footer-container"));

    }

    protected boolean hasNavigation() {
        return false;
    }

}
