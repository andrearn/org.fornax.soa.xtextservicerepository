/*
 * generated by Xtext
 */
package org.fornax.soa.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.fornax.soa.basedsl.ui.highlighting.BaseDslHighLightingConfiguration;
import org.fornax.soa.ui.highlighting.SolutionDslSemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class SolutionDslUiModule extends org.fornax.soa.ui.AbstractSolutionDslUiModule {
	public SolutionDslUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		return SolutionDslSemanticHighlightingCalculator.class;
	}

	public Class<? extends IHighlightingConfiguration> bindSemanticConfig() {
		return BaseDslHighLightingConfiguration.class;
	}
}
