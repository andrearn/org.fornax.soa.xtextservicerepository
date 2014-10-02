package org.xkonnex.repo.server.web.connex.web.layout;

import org.apache.wicket.Application;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class AuthenticatedConnexPage<T> extends ConnexPage<T>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticatedConnexPage() {
		super();
	}
	
	public AuthenticatedConnexPage(PageParameters parameters) {
		super(parameters);
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
