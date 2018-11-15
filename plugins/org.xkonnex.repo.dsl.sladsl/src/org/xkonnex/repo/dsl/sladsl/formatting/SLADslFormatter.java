/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.sladsl.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 */
public class SLADslFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
		org.xkonnex.repo.dsl.sladsl.services.SLADslGrammarAccess f = (org.xkonnex.repo.dsl.sladsl.services.SLADslGrammarAccess) getGrammarAccess();

		c.setAutoLinewrap(120);

		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());

		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs("{", "}")) {
			c.setIndentationIncrement().after(pair.getFirst());
			c.setLinewrap(1).after(pair.getFirst());
			c.setLinewrap(1).after(pair.getSecond());
			c.setIndentationDecrement().before(pair.getSecond());
		}
		for (Keyword kw : f.findKeywords(";")) {
			c.setLinewrap(1).after(kw);
		}
	}
}
