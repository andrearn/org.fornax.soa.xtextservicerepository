package org.xkonnex.repo.server.web.auth;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.xkonnex.repo.server.web.layout.XKonneXRepoPage;

public class SignOutPage<T> extends XKonneXRepoPage<T> {

	public SignOutPage() {
		this (null);
	}
	
	public SignOutPage(PageParameters parameters) {
		super(parameters);
		BasicAuthenticationSession.get().signOut();
		getSession().invalidate();
	}

}
