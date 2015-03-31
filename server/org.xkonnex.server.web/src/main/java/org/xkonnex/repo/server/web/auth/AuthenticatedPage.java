package org.xkonnex.repo.server.web.auth;

import org.apache.wicket.Application;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public abstract class AuthenticatedPage<T> extends GenericWebPage<T> {
	public AuthenticatedPage(PageParameters parameters) {
		super(parameters);
	}

	@Override
	protected void onConfigure() {
		AuthenticatedWebApplication app = (AuthenticatedWebApplication) Application
				.get();
		// if user is not signed in, redirect him to sign in page
		if (!AuthenticatedWebSession.get().isSignedIn())
			app.restartResponseAtSignInPage();
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
//		add(new Link("goToHomePage") {
//			@Override
//			public void onClick() {
//				setResponsePage(getApplication().getHomePage());
//			}
//		});
//		add(new Link("logOut") {
//			@Override
//			public void onClick() {
//				AuthenticatedWebSession.get().invalidate();
//				setResponsePage(getApplication().getHomePage());
//			}
//		});
	}
}
