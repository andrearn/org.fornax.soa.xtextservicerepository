package org.xkonnex.repo.dsl.solutiondsl.ui.highlighting;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.xkonnex.repo.dsl.basedsl.ui.highlighting.BaseDslHighLightingConfiguration;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Aggregate;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.InterfaceRef;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.SolutionDslPackage;

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
				if (eObject instanceof InterfaceRef) {
					InterfaceRef ref = (InterfaceRef)eObject;
					if (ref.getInterface() instanceof Service && ((Service)ref.getInterface()).isDeprecated()) {
						for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
								SolutionDslPackage.Literals.INTERFACE_REF__INTERFACE)) {
							acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
									BaseDslHighLightingConfiguration.DEPRECATED);
						}
					}
					if (ref.getInterface() instanceof Resource && ((Resource)ref.getInterface()).isDeprecated()) {
						for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
								SolutionDslPackage.Literals.INTERFACE_REF__INTERFACE)) {
							acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
									BaseDslHighLightingConfiguration.DEPRECATED);
						}
					}
					if (ref.getInterface() instanceof Aggregate && ((Aggregate)ref.getInterface()).isDeprecated()) {
						for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
								SolutionDslPackage.Literals.INTERFACE_REF__INTERFACE)) {
							acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
									BaseDslHighLightingConfiguration.DEPRECATED);
						}
					}
				}
			}
		}

	}

}
