package org.fornax.soa.xsr.connex.web;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.fornax.soa.xsr.connex.web.layout.AuthenticatedConnexPage;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath(value = "/", alt = "/home")
public class HomePage<T> extends AuthenticatedConnexPage<T> {
	
	private static final long serialVersionUID = 1L;

    /**
     * @param parameters the current page parameters.
     */
    public HomePage(PageParameters parameters) {
        super(parameters);

    }
}
