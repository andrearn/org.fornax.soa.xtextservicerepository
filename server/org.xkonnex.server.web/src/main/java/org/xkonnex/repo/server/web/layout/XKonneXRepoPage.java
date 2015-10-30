package org.xkonnex.repo.server.web.layout;

import java.util.Properties;

import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.FilteredHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.xkonnex.repo.server.web.XKonneXRepoApplication;

public abstract class XKonneXRepoPage<T> extends GenericWebPage<T> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XKonneXRepoPage() {
		this(null);
	}
	
    /**
     * Construct.
     *
     * @param parameters current page parameters
     */
    public XKonneXRepoPage(final PageParameters parameters) {
        super(parameters);

        add(new NavBarPanel("navbar"));
        add(new Footer("footer"));


//        add(new HeaderResponseContainer("footer-container", "footer-container"));

    }

    /**
     * @return application properties
     */
    public Properties getProperties() {
        return ((XKonneXRepoApplication) XKonneXRepoApplication.get()).getProperties();
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();

    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(FixBootstrapStylesCssResourceReference.INSTANCE));
        response.render(new FilteredHeaderItem(JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()), "footer-container"));

    }

    protected boolean hasNavigation() {
        return false;
    }

}
