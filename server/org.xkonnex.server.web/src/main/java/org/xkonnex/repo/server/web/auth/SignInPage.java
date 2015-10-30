package org.xkonnex.repo.server.web.auth;

import org.apache.wicket.authentication.IAuthenticationStrategy;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.Strings;
import org.wicketstuff.annotation.mount.MountPath;
import org.xkonnex.repo.server.web.layout.XKonneXRepoPage;

/**
 * A base class which provide standard functionality for sign in.
 * 
 * @author Jonathan Locke
 */
@MountPath ("signin")
public class SignInPage extends XKonneXRepoPage<SignInPage> {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	
	public SignInPage() {
		this(null);
	}
	
	public SignInPage(final PageParameters parameters) {
		super(parameters);
	

		StatelessForm<SignInPage> form = new StatelessForm<SignInPage>("xkonnexRepoSignInForm") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				if (Strings.isEmpty(getUsername()))
					return;

				boolean authResult = AuthenticatedWebSession.get().signIn(
						getUsername(), getPassword());
				if (authResult)
					continueToOriginalDestination();
			}
		};
		form.setDefaultModel(new CompoundPropertyModel<SignInPage>(this));

		form.add(new TextField<String>("username"));
		form.add(new PasswordTextField("password"));
		form.add(new Button("submit") {
			
			@Override
			public void onSubmit() {
				if (Strings.isEmpty(getUsername()))
					return;

				boolean authResult = AuthenticatedWebSession.get().signIn(
						getUsername(), getPassword());
				if (authResult)
					continueToOriginalDestination();
			}
			
		});

		add(form);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
