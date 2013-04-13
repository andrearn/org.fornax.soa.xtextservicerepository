package org.fornax.soa.ui.highlighting;

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
				if (eObject instanceof org.fornax.soa.serviceDsl.Exception && !Strings.isEmpty(((org.fornax.soa.serviceDsl.Exception) eObject).getName()) && ((org.fornax.soa.serviceDsl.Exception) eObject).isDeprecated()) {
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
				if (eObject instanceof BusinessObjectRef && ((BusinessObjectRef)eObject).getType().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							ServiceDslPackage.Literals.BUSINESS_OBJECT_REF__TYPE)) {
						acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(),
								BaseDslHighLightingConfiguration.DEPRECATED);
					}
				}
				if (eObject instanceof QueryObjectRef && ((QueryObjectRef)eObject).getType().isDeprecated()) {
					for (INode crossRefNode : NodeModelUtils.findNodesForFeature(eObject,
							ServiceDslPackage.Literals.QUERY_OBJECT_REF__TYPE)) {
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
