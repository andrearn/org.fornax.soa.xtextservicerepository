package org.fornax.soa.basedsl.ui.highlighting;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class BaseDslHighLightingConfiguration extends
		DefaultHighlightingConfiguration {

	public static final String DEPRECATED = "servicedsl.deprecated.asset";

	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(DEPRECATED, "Deprecated Asset",
				deprecatedTextStyle());
	}

	public TextStyle deprecatedTextStyle(){
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setStyle(TextAttribute.STRIKETHROUGH);
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}
}
