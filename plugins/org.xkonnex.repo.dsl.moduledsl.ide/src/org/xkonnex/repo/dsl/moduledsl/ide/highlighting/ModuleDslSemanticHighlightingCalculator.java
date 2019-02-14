package org.xkonnex.repo.dsl.moduledsl.ide.highlighting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.CancelIndicator;
import org.xkonnex.repo.dsl.basedsl.ide.highlighting.BaseDslSemanticHighlightingCalculator;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractServiceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslPackage;

public class ModuleDslSemanticHighlightingCalculator extends BaseDslSemanticHighlightingCalculator {
		
	@Override
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object instanceof AbstractServiceRef) {
			return highlightElement((AbstractServiceRef)object, acceptor, cancelIndicator);
		} else {
			return super.highlightElement(object, acceptor, cancelIndicator);
		}
	}
	
	protected boolean highlightElement(AbstractServiceRef object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object.getService() != null && object.getService().isDeprecated()) {
			highlightFeature(acceptor, object, ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE, DEPRECATED_ID);
		}
		return false;
	}

}
