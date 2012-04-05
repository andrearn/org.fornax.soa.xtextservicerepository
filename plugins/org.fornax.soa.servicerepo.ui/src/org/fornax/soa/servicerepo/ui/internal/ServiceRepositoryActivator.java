package org.fornax.soa.servicerepo.ui.internal;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.util.Modules2;
import org.fornax.soa.BindingDslRuntimeModule;
import org.fornax.soa.EnvironmentDslRuntimeModule;
import org.fornax.soa.SLADslRuntimeModule;
import org.fornax.soa.SemanticsDslRuntimeModule;
import org.fornax.soa.ServiceDslRuntimeModule;
import org.fornax.soa.SolutionDslRuntimeModule;
import org.fornax.soa.basedsl.SOABaseDslRuntimeModule;
import org.fornax.soa.moduledsl.ModuleDslRuntimeModule;
import org.fornax.soa.profiledsl.SOAProfileDslRuntimeModule;
import org.fornax.soa.servicerepo.ui.ServiceRepositorySharedStateModule;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * Generated
 */
public class ServiceRepositoryActivator extends AbstractUIPlugin {

	public static final String INJECTOR_NAME = "org.fornax.soa.ServiceRepository";
	private Map<String, Injector> injectors = new HashMap<String, Injector>();
	private static ServiceRepositoryActivator INSTANCE;
	public static final String PLUGIN_ID = "org.fornax.soa.servicerepo.ui"; //$NON-NLS-1$

	public Injector getInjector(String languageName) {
		return injectors.get(languageName);
	}
	
	public Injector getInjector() {
		return injectors.get(INJECTOR_NAME);
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		try {
			Injector injector = Guice.createInjector(
					Modules2.mixin (
							new SOABaseDslRuntimeModule (),
							new SOAProfileDslRuntimeModule(),
							new SemanticsDslRuntimeModule(),
							new SolutionDslRuntimeModule(),
							new EnvironmentDslRuntimeModule(),
							new ModuleDslRuntimeModule(),
							new SLADslRuntimeModule(),
							new ServiceDslRuntimeModule(),
							new BindingDslRuntimeModule(),
							Modules.override (Modules.override (
									getRuntimeModule(INJECTOR_NAME))
									.with(getUiModule(INJECTOR_NAME))
								).with (getSharedStateModule())
					)
				);
			injectors.put(INJECTOR_NAME, injector);

		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}
	}
	
	public static ServiceRepositoryActivator getInstance() {
		return INSTANCE;
	}

	protected Module getRuntimeModule(String grammar) {

		if (INJECTOR_NAME.equals(grammar)) {
			return new org.fornax.soa.servicerepo.ServiceRepositoryRuntimeModule();
		}

		throw new IllegalArgumentException(grammar);
	}

	protected Module getUiModule(String grammar) {

		if (INJECTOR_NAME.equals(grammar)) {
			return new org.fornax.soa.servicerepo.ui.ServiceRepositoryUiModule(this);
		}

		throw new IllegalArgumentException(grammar);
	}

	protected Module getSharedStateModule() {
		return new ServiceRepositorySharedStateModule();
	}

}
