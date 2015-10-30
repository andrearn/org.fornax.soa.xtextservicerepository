package org.xkonnex.repo.server.web.layout;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.xkonnex.repo.server.web.auth.SignOutPage;

public class AuthenticatedNavBarPanel extends Panel {

	public AuthenticatedNavBarPanel(String id) {
		super(id);
		add(new Link("signoutLink") {

			@Override
			public void onClick() {
				AuthenticatedWebSession.get().invalidate();
	            setResponsePage(SignOutPage.class);
			}
		});
	}

}
