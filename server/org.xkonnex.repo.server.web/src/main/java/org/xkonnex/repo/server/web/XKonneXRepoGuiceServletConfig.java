package org.xkonnex.repo.server.web;

import java.util.List;

import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.util.Modules2;
import org.xkonnex.repo.core.XKonneXRepoDSL;
import org.xkonnex.repo.server.core.resource.DSLConfigurer;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class XKonneXRepoGuiceServletConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {

		return Guice.createInjector(Modules2.mixin(new ServletModule(),
				new AbstractGenericModule() {
			
				})

		);
	}
}