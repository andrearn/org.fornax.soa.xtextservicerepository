package org.xkonnex.repo.dsl.solutiondsl.ide.highlighting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.CancelIndicator;
import org.xkonnex.repo.dsl.basedsl.ide.highlighting.BaseDslSemanticHighlightingCalculator;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Aggregate;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.InterfaceRef;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.SolutionDslPackage;

public class SolutionDslSemanticHighlightingCalculator extends BaseDslSemanticHighlightingCalculator {

	@Override
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object instanceof InterfaceRef) {
			InterfaceRef ref = (InterfaceRef) object;
			if (ref.getInterface() instanceof Service && ((Service) ref.getInterface()).isDeprecated()) {
				 highlightFeature(acceptor, ref, SolutionDslPackage.Literals.INTERFACE_REF__INTERFACE,
						DEFAULT_ID);
				 return false;
			}
			if (ref.getInterface() instanceof Resource && ((Resource) ref.getInterface()).isDeprecated()) {
				highlightFeature(acceptor, ref, SolutionDslPackage.Literals.INTERFACE_REF__INTERFACE,
						DEFAULT_ID);
				 return false;
			}
			if (ref.getInterface() instanceof Aggregate && ((Aggregate) ref.getInterface()).isDeprecated()) {
				highlightFeature(acceptor, ref, SolutionDslPackage.Literals.INTERFACE_REF__INTERFACE,
						DEFAULT_ID);
				 return false;
			}
		}
		return super.highlightElement(object, acceptor, cancelIndicator);
	}

}
