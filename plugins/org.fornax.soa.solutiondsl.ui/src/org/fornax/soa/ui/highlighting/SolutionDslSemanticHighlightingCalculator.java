package org.fornax.soa.ui.highlighting;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.fornax.soa.basedsl.ui.highlighting.BaseDslHighLightingConfiguration;
import org.fornax.soa.solutionDsl.ServiceRef;
import org.fornax.soa.solutionDsl.SolutionDslPackage;

import com.google.inject.Inject;

public class SolutionDslSemanticHighlightingCalculator implements
		ISemanticHighlightingCalculator {

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
		if (resource != null && !resource.getContents().isEmpty()) {
			for (TreeIterator<EObject> eObjIt = resource.getAllContents(); eObjIt.hasNext();) {
				EObject eObject = eObjIt.next();
				if (eObject instanceof ServiceRef && ((ServiceRef)eObject).getService().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							SolutionDslPackage.Literals.SERVICE_REF__SERVICE)) {
						acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
								BaseDslHighLightingConfiguration.DEPRECATED);
					}
				}
			}
		}

	}

}
