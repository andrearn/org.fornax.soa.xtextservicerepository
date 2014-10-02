package org.xkonnex.repo.dsl.servicedsl.ui.highlighting;

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
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ComplexConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef;
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

public class ServiceDslSemanticHighlightingCalculator implements
		ISemanticHighlightingCalculator {

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
		if (resource != null && !resource.getContents().isEmpty()) {
			for (TreeIterator<EObject> eObjIt = resource.getAllContents(); eObjIt.hasNext();) {
				EObject eObject = eObjIt.next();
				if (eObject instanceof Service && !Strings.isEmpty(((Service) eObject).getName()) && ((Service) eObject).isDeprecated()) {
					ITextRegion nameRegion = locationInFileProvider.getSignificantTextRegion(eObject);
					acceptor.addPosition(nameRegion.getOffset(), nameRegion.getLength(), BaseDslHighLightingConfiguration.DEPRECATED);
				}
				if (eObject instanceof VersionedType && !Strings.isEmpty(((VersionedType) eObject).getName()) && ((VersionedType) eObject).isDeprecated()) {
					ITextRegion nameRegion = locationInFileProvider.getSignificantTextRegion(eObject);
					acceptor.addPosition(nameRegion.getOffset(), nameRegion.getLength(), BaseDslHighLightingConfiguration.DEPRECATED);
				}
				if (eObject instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception && !Strings.isEmpty(((org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception) eObject).getName()) && ((org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception) eObject).isDeprecated()) {
					ITextRegion nameRegion = locationInFileProvider.getSignificantTextRegion(eObject);
					acceptor.addPosition(nameRegion.getOffset(), nameRegion.getLength(), BaseDslHighLightingConfiguration.DEPRECATED);
				}
				if (eObject instanceof Operation && !Strings.isEmpty(((Operation) eObject).getName()) && ((Operation) eObject).isDeprecated()) {
					ITextRegion nameRegion = locationInFileProvider.getSignificantTextRegion(eObject);
					acceptor.addPosition(nameRegion.getOffset(), nameRegion.getLength(), BaseDslHighLightingConfiguration.DEPRECATED);
				}
				if (eObject instanceof Property && !Strings.isEmpty(((Property) eObject).getName()) && ((Property) eObject).isDeprecated()) {
					ITextRegion nameRegion = locationInFileProvider.getSignificantTextRegion(eObject);
					acceptor.addPosition(nameRegion.getOffset(), nameRegion.getLength(), BaseDslHighLightingConfiguration.DEPRECATED);
				}

				if (eObject instanceof ServiceRef && ((ServiceRef)eObject).getService().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							ServiceDslPackage.Literals.SERVICE_REF__SERVICE)) {
						acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
								BaseDslHighLightingConfiguration.DEPRECATED);
					}
				}
				if (eObject instanceof VersionedTypeRef && ((VersionedTypeRef)eObject).getType().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE)) {
						acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
								BaseDslHighLightingConfiguration.DEPRECATED);
					}
				}
				if (eObject instanceof DataObjectRef && ((DataObjectRef)eObject).getType() != null && ((DataObjectRef)eObject).getType().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							ServiceDslPackage.Literals.DATA_OBJECT_REF__TYPE)) {
						acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
								BaseDslHighLightingConfiguration.DEPRECATED);
					}
				}
				if (eObject instanceof EnumTypeRef && ((EnumTypeRef)eObject).getType().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							ServiceDslPackage.Literals.ENUM_TYPE_REF__TYPE)) {
						acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
								BaseDslHighLightingConfiguration.DEPRECATED);
					}
				}
				if (eObject instanceof OperationRef && ((OperationRef)eObject).getOperation().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							ServiceDslPackage.Literals.OPERATION_REF__OPERATION)) {
						acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
								BaseDslHighLightingConfiguration.DEPRECATED);
					}
				}
				if (eObject instanceof ExceptionRef && ((ExceptionRef)eObject).getException().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION)) {
						acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
								BaseDslHighLightingConfiguration.DEPRECATED);
					}
				}
				if (eObject instanceof SimpleConsiderationPropertyRef && ((SimpleConsiderationPropertyRef)eObject).getProperty().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							ServiceDslPackage.Literals.SIMPLE_CONSIDERATION_PROPERTY_REF__PROPERTY)) {
						acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
								BaseDslHighLightingConfiguration.DEPRECATED);
					}
				}
				if (eObject instanceof ComplexConsiderationPropertyRef && ((ComplexConsiderationPropertyRef)eObject).getParentProperty().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							ServiceDslPackage.Literals.COMPLEX_CONSIDERATION_PROPERTY_REF__PARENT_PROPERTY)) {
						acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
								BaseDslHighLightingConfiguration.DEPRECATED);
					}
				}
			}
		}

	}

}
