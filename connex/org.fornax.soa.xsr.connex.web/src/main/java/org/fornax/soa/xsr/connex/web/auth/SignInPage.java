package org.fornax.soa.xsr.connex.web.auth;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.Strings;
import org.fornax.soa.xsr.connex.web.layout.ConnexPage;

/**
 * A base class which provide standard functionality for sign in.
 * 
 * @author Jonathan Locke
 */
public class SignInPage<T> extends ConnexPage<T> {
	private static final long serialVersionUID = 1L;

	/**
	 * Construct
	 */
	public SignInPage() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * @param parameters
	 *            The page parameters
	 */
	public SignInPage(final PageParameters parameters) {
		super(parameters);
		AuthenticatedWebSession authenticatedWebSession = AuthenticatedWebSession.get();
		if (authenticatedWebSession != null)
			authenticatedWebSession.signOut();

		add(new SignInPanel("signInPanel"));
	}
}
