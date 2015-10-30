package org.xkonnex.repo.server.web.layout;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.xkonnex.repo.server.web.auth.SignInPage;
import org.xkonnex.repo.server.web.auth.SignOutPage;

public class NavBarPanel extends Panel {

	public NavBarPanel(String id) {
		super(id);
		add(new Link("signinLink") {

			@Override
			public void onClick() {
	            setResponsePage(SignInPage.class);
			}
		});
		
	}

}
