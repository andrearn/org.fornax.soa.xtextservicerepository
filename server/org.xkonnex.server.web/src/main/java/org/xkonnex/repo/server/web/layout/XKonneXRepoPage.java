package org.xkonnex.repo.server.web.layout;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.wicket.Application;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.FilteredHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;
import org.xkonnex.repo.server.web.HomePage;
import org.xkonnex.repo.server.web.XKonneXRepoApplication;
import org.xkonnex.repo.server.web.auth.AuthenticatedPage;
import org.xkonnex.repo.server.web.auth.BasicAuthenticationSession;
import org.xkonnex.repo.server.web.auth.SignInPage;
import org.xkonnex.repo.server.web.auth.SignOutPage;

import com.newrelic.api.agent.NewRelic;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.block.Code;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapLink;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.dropdown.DropDownButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.dropdown.MenuBookmarkablePageLink;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.dropdown.MenuDivider;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.dropdown.MenuHeader;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.ChromeFrameMetaTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.HtmlTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.MetaTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.OptimizedMobileViewportMetaTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.IconType;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.AffixBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.ImmutableNavbarComponent;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarAjaxButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarComponents;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarDropDownButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarForm;
import de.agilecoders.wicket.core.markup.html.references.BootstrapJavaScriptReference;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import de.agilecoders.wicket.core.settings.ITheme;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.button.DropDownAutoOpen;

public abstract class XKonneXRepoPage<T> extends GenericWebPage<T> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XKonneXRepoPage() {
		// TODO Auto-generated constructor stub
	}
	
    /**
     * Construct.
     *
     * @param parameters current page parameters
     */
    public XKonneXRepoPage(final PageParameters parameters) {
        super(parameters);

        add(new HtmlTag("html"));

        add(new OptimizedMobileViewportMetaTag("viewport"));
        add(new ChromeFrameMetaTag("chrome-frame"));

        add(newNavbar("navbar"));
        add(newNavigation("navigation"));
        add(new Footer("footer"));

        add(new BootstrapBaseBehavior());
//        add(new Code("code-internal"));

        add(new HeaderResponseContainer("footer-container", "footer-container"));

    }

    /**
     * @return application properties
     */
    public Properties getProperties() {
        return ((XKonneXRepoApplication) XKonneXRepoApplication.get()).getProperties();
    }

    /**
     * creates a new {@link Navbar} instance
     *
     * @param markupId The components markup id.
     * @return a new {@link Navbar} instance
     */
    protected Navbar newNavbar(String markupId) {
        Navbar navbar = new Navbar(markupId);

        navbar.setPosition(Navbar.Position.TOP);

        // show brand name
        navbar.brandName (Model.of("XSR Connex"));

		navbar.addComponents (NavbarComponents.transform(
				Navbar.ComponentPosition.LEFT, new NavbarButton<HomePage>(
						HomePage.class, Model.of ("Overview")).setIconType(IconType.home)));

        DropDownButton dropdown = new NavbarDropDownButton(Model.of("Themes")) {
            @Override
            public boolean isActive(Component item) {
                return false;
            }

            @Override
            protected List<AbstractLink> newSubMenuButtons(final String buttonMarkupId) {
                final List<AbstractLink> subMenu = new ArrayList<AbstractLink>();
                subMenu.add(new MenuHeader(Model.of("all available themes:")));
                subMenu.add(new MenuDivider());

                final IBootstrapSettings settings = Bootstrap.getSettings(getApplication());
                final List<ITheme> themes = settings.getThemeProvider().available();

                for (final ITheme theme : themes) {
                    PageParameters params = new PageParameters();
                    params.set("theme", theme.name());

                    subMenu.add(new MenuBookmarkablePageLink<Page>(getPageClass(), params, Model.of(theme.name())));
                }

                return subMenu;
            }
        }.setIconType(IconType.book);
        dropdown.add(new DropDownAutoOpen());
 
        navbar.addComponents(new ImmutableNavbarComponent(dropdown, Navbar.ComponentPosition.RIGHT));
        navbar.addComponents(NavbarComponents.transform(
        		Navbar.ComponentPosition.RIGHT, 
        		new NavbarButton<SignOutPage>(SignOutPage.class, Model.of ("Logout")).setIconType(IconType.off) ));

        return navbar;
    }

//    /**
//     * @return new dropdown button for all addons
//     */
//    private Component newAddonsDropDownButton() {
//        return new NavbarDropDownButton(Model.of("Addons")) {
//            @Override
//            protected List<AbstractLink> newSubMenuButtons(String buttonMarkupId) {
//                final List<AbstractLink> subMenu = new ArrayList<AbstractLink>();
//
//                subMenu.add(new MenuBookmarkablePageLink<HomePage>(Javascript.class, Model.of("Javascript"))/*.setIconType(IconType.refresh)*/);
//
//                return subMenu;
//            }
//        }/*.setIconType(IconType.thlarge).setInverted(true).add(new DropDownAutoOpen())*/;
//    }

    /**
     * sets the theme for the current user.
     *
     * @param pageParameters current page parameters
     */
    private void configureTheme(PageParameters pageParameters) {
        StringValue theme = pageParameters.get("theme");

        if (!theme.isEmpty()) {
            IBootstrapSettings settings = Bootstrap.getSettings(getApplication());
            settings.getActiveThemeProvider().setActiveTheme(theme.toString(""));
        }
    }

    protected ITheme activeTheme() {
        IBootstrapSettings settings = Bootstrap.getSettings(getApplication());

        return settings.getActiveThemeProvider().getActiveTheme();
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();

        configureTheme(getPageParameters());
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(FixBootstrapStylesCssResourceReference.INSTANCE));
//        response.render(new FilteredHeaderItem(JavaScriptHeaderItem.forReference(ApplicationJavaScript.INSTANCE), "footer-container"));
        response.render(new FilteredHeaderItem(JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()), "footer-container"));
        response.render(new FilteredHeaderItem(JavaScriptHeaderItem.forReference(BootstrapJavaScriptReference.instance()), "footer-container"));

        if ("google".equalsIgnoreCase(activeTheme().name())) {
            response.render(CssHeaderItem.forReference(DocsCssResourceReference.GOOGLE));
        }
    }

    protected boolean hasNavigation() {
        return false;
    }

    /**
     * creates a new navigation component.
     *
     * @param markupId The component's markup id
     * @return a new navigation component.
     */
    private Component newNavigation(String markupId) {
        WebMarkupContainer navigation = new WebMarkupContainer(markupId);
        navigation.add(new AffixBehavior("200"));
        navigation.setVisible(hasNavigation());

        return navigation;
    }

}
