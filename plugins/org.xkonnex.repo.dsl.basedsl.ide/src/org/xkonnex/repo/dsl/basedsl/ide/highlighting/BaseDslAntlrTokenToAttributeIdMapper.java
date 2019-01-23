package org.xkonnex.repo.dsl.basedsl.ide.highlighting;

import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

public class BaseDslAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if ("RULE_TEXT".equals(tokenName)) {
			return BaseDslHighlightingStyles.TEXT_ID;
		} else {
			return super.calculateId(tokenName, tokenType);
		}
	}
}
