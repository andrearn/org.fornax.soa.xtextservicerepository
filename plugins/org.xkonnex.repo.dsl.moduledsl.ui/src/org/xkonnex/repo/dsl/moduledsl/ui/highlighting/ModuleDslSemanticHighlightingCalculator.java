package org.xkonnex.repo.dsl.moduledsl.ui.highlighting;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Strings;
import org.xkonnex.repo.dsl.basedsl.ui.highlighting.BaseDslHighLightingConfiguration;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractServiceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportServiceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslPackage;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ComplexConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OperationRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.QueryObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SimpleConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef;

import com.google.inject.Inject;

public class ModuleDslSemanticHighlightingCalculator implements
		ISemanticHighlightingCalculator {

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
		if (resource != null && !resource.getContents().isEmpty()) {
			for (TreeIterator<EObject> eObjIt = resource.getAllContents(); eObjIt.hasNext();) {
				EObject eObject = eObjIt.next();
				if (eObject instanceof AbstractServiceRef && ((AbstractServiceRef)eObject).getService() != null && ((AbstractServiceRef)eObject).getService().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE)) {
						acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
								BaseDslHighLightingConfiguration.DEPRECATED);
					}
				}
			}
		}

	}

}
