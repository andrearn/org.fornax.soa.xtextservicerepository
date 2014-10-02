package org.xkonnex.repo.server.web.connex.web.auth;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class BasicAuthenticationSession extends AuthenticatedWebSession {
	public BasicAuthenticationSession(Request request) {
		super(request);
	}

	@Override
	public boolean authenticate(String username, String password) {
		// user is authenticated if both username and password are equal to
		// 'admin'
		return username.equals(password) && username.equals("admin");
	}

	@Override
	public Roles getRoles() {
		Roles roles = new Roles();
		roles.add("admin");
		roles.add("user");
		roles.add("committer");
		return roles;
	}
}
