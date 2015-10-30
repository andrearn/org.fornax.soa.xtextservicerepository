/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.servicedsl.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.xkonnex.repo.dsl.basedsl.ui.highlighting.BaseDslHighLightingConfiguration;
import org.xkonnex.repo.dsl.servicedsl.ui.highlighting.ServiceDslSemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class ServiceDslUiModule extends org.xkonnex.repo.dsl.servicedsl.ui.AbstractServiceDslUiModule {
	public ServiceDslUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		return ServiceDslSemanticHighlightingCalculator.class;
	}

	public Class<? extends IHighlightingConfiguration> bindSemanticConfig() {
		return BaseDslHighLightingConfiguration.class;
	}

}