package org.xkonnex.repo.server.web;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;
import org.xkonnex.repo.server.web.layout.AuthenticatedXKonneXRepoPage;

@MountPath(value = "/", alt = "/home")
public class HomePage<T> extends AuthenticatedXKonneXRepoPage<T> {
	
	private static final long serialVersionUID = 1L;

    /**
     * @param parameters the current page parameters.
     */
    public HomePage(PageParameters parameters) {
        super(parameters);

    }
}
