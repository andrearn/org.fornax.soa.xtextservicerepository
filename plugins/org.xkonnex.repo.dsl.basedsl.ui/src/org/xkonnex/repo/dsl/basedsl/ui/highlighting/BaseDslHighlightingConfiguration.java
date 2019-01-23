package org.xkonnex.repo.dsl.basedsl.ui.highlighting;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.xkonnex.repo.dsl.basedsl.ide.highlighting.BaseDslHighlightingStyles;

public class BaseDslHighlightingConfiguration extends
		DefaultHighlightingConfiguration implements BaseDslHighlightingStyles {

	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(DEPRECATED_ID, "Deprecated Asset",
				deprecatedTextStyle());
		acceptor.acceptDefaultHighlighting(TEXT_ID, "Multiline text", multilineTextStyle());
	}

	public TextStyle deprecatedTextStyle(){
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setStyle(TextAttribute.STRIKETHROUGH);
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}
	
	public TextStyle multilineTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(64, 64, 64));
		return textStyle;
	}

}
