package org.xkonnex.repo.dsl.basedsl.ide.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles

interface BaseDslHighlightingStyles extends HighlightingStyles {
	
	String DEPRECATED_ID = "xkonnex.repo.basedsl.deprecated"
	String TEXT_ID = "xkonnex.repo.basedsl.text"
	
}