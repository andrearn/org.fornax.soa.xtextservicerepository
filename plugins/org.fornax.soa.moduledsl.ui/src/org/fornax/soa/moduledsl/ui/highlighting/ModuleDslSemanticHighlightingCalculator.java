package org.fornax.soa.moduledsl.ui.highlighting;

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
import org.fornax.soa.basedsl.ui.highlighting.BaseDslHighLightingConfiguration;
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.ComplexConsiderationPropertyRef;
import org.fornax.soa.serviceDsl.ConsiderationPropertyRef;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.OperationRef;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.QueryObject;
import org.fornax.soa.serviceDsl.QueryObjectRef;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.SimpleConsiderationPropertyRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

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
				if (eObject instanceof AbstractServiceRef && ((AbstractServiceRef)eObject).getService().isDeprecated()) {
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
