package org.xkonnex.repo.workbench.ui.internal;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.BundleContext;
import org.xkonnex.repo.dsl.basedsl.SOABaseDslRuntimeModule;
import org.xkonnex.repo.dsl.bindingdsl.BindingDslRuntimeModule;
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslRuntimeModule;
import org.xkonnex.repo.dsl.moduledsl.ModuleDslRuntimeModule;
import org.xkonnex.repo.dsl.profiledsl.SOAProfileDslRuntimeModule;
import org.xkonnex.repo.dsl.semanticsdsl.SemanticsDslRuntimeModule;
import org.xkonnex.repo.dsl.servicedsl.ServiceDslRuntimeModule;
import org.xkonnex.repo.dsl.solutiondsl.SolutionDslRuntimeModule;
import org.xkonnex.repo.workbench.ui.ServiceRepositorySharedStateModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * Generated
 */
public class ServiceRepositoryActivator extends AbstractUIPlugin {

	public static final String INJECTOR_NAME = "org.xkonnex.repo.workbench.ui.XKonneXRepository";
	private Map<String, Injector> injectors = new HashMap<String, Injector>();
	private static ServiceRepositoryActivator INSTANCE;
	public static final String PLUGIN_ID = "org.xkonnex.repo.workbench.ui"; //$NON-NLS-1$
	public static final String DIALOG_SETTINGS_SECTION = "org.xkonnex.repo.workbench.ui";
	
	private IDialogSettings dialogSettings;

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
							new ServiceDslRuntimeModule(),
							new BindingDslRuntimeModule(),
							Modules.override (Modules.override (
									getRuntimeModule(INJECTOR_NAME))
									.with(getUiModule(INJECTOR_NAME))
								).with (getSharedStateModule())
					)
				);
			injectors.put(INJECTOR_NAME, injector);
			dialogSettings = new DialogSettings(DIALOG_SETTINGS_SECTION);
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}
	}
	
	public IDialogSettings getDialogSetting (String sectionName) {
		return DialogSettings.getOrCreateSection(dialogSettings, sectionName);
	}
	
	public static ServiceRepositoryActivator getInstance() {
		return INSTANCE;
	}

	protected Module getRuntimeModule(String grammar) {

		if (INJECTOR_NAME.equals(grammar)) {
			return new org.xkonnex.repo.core.ServiceRepositoryRuntimeModule();
		}

		throw new IllegalArgumentException(grammar);
	}

	protected Module getUiModule(String grammar) {

		if (INJECTOR_NAME.equals(grammar)) {
			return new org.xkonnex.repo.workbench.ui.ServiceRepositoryUiModule(this);
		}

		throw new IllegalArgumentException(grammar);
	}

	protected Module getSharedStateModule() {
		return new ServiceRepositorySharedStateModule();
	}

}
