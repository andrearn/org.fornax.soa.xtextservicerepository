/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.bindingdsl.ui

import org.eclipse.ui.plugin.AbstractUIPlugin
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration
import org.xkonnex.repo.dsl.basedsl.ui.highlighting.BaseDslAntlrTokenToAttributeIdMapper
import org.xkonnex.repo.dsl.basedsl.ui.highlighting.BaseDslHighlightingConfiguration

/** 
 * Use this class to register components to be used within the IDE.
 */
class BindingDslUiModule extends AbstractBindingDslUiModule {
	new(AbstractUIPlugin plugin) {
		super(plugin)
	}
	
	def Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return typeof(BaseDslAntlrTokenToAttributeIdMapper)
	}
	
	def Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration () {
		return typeof(BaseDslHighlightingConfiguration)	
	}

}
