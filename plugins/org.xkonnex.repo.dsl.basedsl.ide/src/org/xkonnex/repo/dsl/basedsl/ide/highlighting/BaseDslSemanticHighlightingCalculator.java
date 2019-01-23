package org.xkonnex.repo.dsl.basedsl.ide.highlighting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.CancelIndicator;

public class BaseDslSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator implements BaseDslHighlightingStyles {
	
	@Override
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		
		return super.highlightElement(object, acceptor, cancelIndicator);
	}

}
