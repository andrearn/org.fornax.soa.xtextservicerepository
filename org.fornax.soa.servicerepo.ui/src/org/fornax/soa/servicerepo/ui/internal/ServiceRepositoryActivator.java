package org.fornax.soa.servicerepo.ui.internal;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * Generated
 */
public class ServiceRepositoryActivator extends AbstractUIPlugin {

	private Map<String, Injector> injectors = new HashMap<String, Injector>();
	private static ServiceRepositoryActivator INSTANCE;
	public static final String PLUGIN_ID = "org.fornax.soa.servicerepo.ui"; //$NON-NLS-1$

	public Injector getInjector(String languageName) {
		return injectors.get(languageName);
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		try {
			
			injectors.put("org.fornax.soa.ServiceRepository", Guice.createInjector(
				Modules.override (Modules.override (
						getRuntimeModule("org.fornax.soa.ServiceRepository"))
						.with(getUiModule("org.fornax.soa.ServiceRepository"))
					).with (getSharedStateModule())
			));
			
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}
	}
	
	public static ServiceRepositoryActivator getInstance() {
		return INSTANCE;
	}

	protected Module getRuntimeModule(String grammar) {

		if ("org.fornax.soa.ServiceRepository".equals(grammar)) {
			return new org.fornax.soa.servicerepo.ServiceRepositoryRuntimeModule();
		}

		throw new IllegalArgumentException(grammar);
	}

	protected Module getUiModule(String grammar) {

		if ("org.fornax.soa.ServiceRepository".equals(grammar)) {
			return new org.fornax.soa.servicerepo.ui.ServiceRepositoryUiModule(this);
		}

		throw new IllegalArgumentException(grammar);
	}

	protected Module getSharedStateModule() {
		return new org.eclipse.xtext.ui.shared.SharedStateModule();
	}

}
