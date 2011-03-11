package org.fornax.soa.servicerepo.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

public class ServiceRepositoryExecutableExtensionFactory  extends AbstractGuiceAwareExecutableExtensionFactory {


	protected Bundle getBundle() {
		return org.fornax.soa.servicerepo.ui.internal.ServiceRepositoryActivator.getInstance().getBundle();
	}
	
	protected Injector getInjector() {
		return org.fornax.soa.servicerepo.ui.internal.ServiceRepositoryActivator.getInstance().getInjector("org.fornax.soa.ServiceRepository");
	}
	
}
