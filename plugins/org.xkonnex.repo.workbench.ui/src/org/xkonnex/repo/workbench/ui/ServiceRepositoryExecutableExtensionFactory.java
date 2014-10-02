package org.xkonnex.repo.workbench.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

public class ServiceRepositoryExecutableExtensionFactory  extends AbstractGuiceAwareExecutableExtensionFactory {


	protected Bundle getBundle() {
		return org.xkonnex.repo.workbench.ui.internal.ServiceRepositoryActivator.getInstance().getBundle();
	}
	
	protected Injector getInjector() {
		return org.xkonnex.repo.workbench.ui.internal.ServiceRepositoryActivator.getInstance().getInjector("org.xkonnex.repo.dsl.bindingdsl.ServiceRepository");
	}
	
}
