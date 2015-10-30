/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.moduledsl.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.xkonnex.repo.dsl.basedsl.ui.highlighting.BaseDslHighLightingConfiguration;
import org.xkonnex.repo.dsl.moduledsl.ui.highlighting.ModuleDslSemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class ModuleDslUiModule extends org.xkonnex.repo.dsl.moduledsl.ui.AbstractModuleDslUiModule {
	public ModuleDslUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		return ModuleDslSemanticHighlightingCalculator.class;
	}

	public Class<? extends IHighlightingConfiguration> bindSemanticConfig() {
		return BaseDslHighLightingConfiguration.class;
	}
}