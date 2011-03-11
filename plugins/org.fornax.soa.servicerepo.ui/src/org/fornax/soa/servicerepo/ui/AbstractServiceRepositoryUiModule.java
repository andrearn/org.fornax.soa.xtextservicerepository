package org.fornax.soa.servicerepo.ui;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.fornax.soa.servicerepo.ui.wizards.ServiceRepositoryProjectCreator;

import com.google.inject.Binder;

/**
 * Manual modifications go to {org.fornax.soa.ui.BindingDslUiModule}
 */
@SuppressWarnings("all")
public abstract class AbstractServiceRepositoryUiModule extends AbstractGenericModule {
	
	private final AbstractUIPlugin plugin;

	public AbstractServiceRepositoryUiModule(AbstractUIPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(AbstractUIPlugin.class).toInstance(plugin);
		binder.bind(IDialogSettings.class).toInstance(plugin.getDialogSettings());
	}
	
	public Class<? extends org.eclipse.xtext.ui.wizard.IProjectCreator> bindIProjectCreator() {
		return ServiceRepositoryProjectCreator.class;
	}

}
