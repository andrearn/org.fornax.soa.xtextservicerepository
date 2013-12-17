package org.fornax.soa.xsr.connex.web.auth;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.fornax.soa.xsr.connex.web.layout.ConnexPage;

public class SignOutPage<T> extends ConnexPage<T> {

	public SignOutPage() {
		this (null);
	}
	
	public SignOutPage(PageParameters parameters) {
		super(parameters);
		BasicAuthenticationSession.get().signOut();
		getSession().invalidate();
	}

}
