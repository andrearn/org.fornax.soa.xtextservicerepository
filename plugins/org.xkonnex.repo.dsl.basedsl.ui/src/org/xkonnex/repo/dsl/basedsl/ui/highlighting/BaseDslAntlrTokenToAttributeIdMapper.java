package org.xkonnex.repo.dsl.basedsl.ui.highlighting;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.xkonnex.repo.dsl.basedsl.ide.highlighting.BaseDslHighlightingStyles;

import com.google.inject.Singleton;

@Singleton
public class BaseDslAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper
		implements BaseDslHighlightingStyles {

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if ("RULE_TEXT".equals(tokenName)) {
			return BaseDslHighlightingStyles.TEXT_ID;
		} else {
			return super.calculateId(tokenName, tokenType);
		}
	}
}
