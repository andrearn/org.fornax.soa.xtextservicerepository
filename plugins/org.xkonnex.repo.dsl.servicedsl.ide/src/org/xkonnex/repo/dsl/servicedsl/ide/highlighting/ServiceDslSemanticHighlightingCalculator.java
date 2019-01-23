package org.xkonnex.repo.dsl.servicedsl.ide.highlighting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Strings;
import org.xkonnex.repo.dsl.basedsl.ide.highlighting.BaseDslSemanticHighlightingCalculator;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ComplexConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OperationRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SimpleConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef;

import com.google.inject.Inject;

public class ServiceDslSemanticHighlightingCalculator extends BaseDslSemanticHighlightingCalculator {

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Override
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object instanceof Service) {
			return highlightElement((Service) object, acceptor, cancelIndicator);
		} else if (object instanceof VersionedType) {
			return highlightElement((VersionedType) object, acceptor, cancelIndicator);
		} else if (object instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception) {
			return highlightElement((org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception) object, acceptor,
					cancelIndicator);
		} else if (object instanceof Operation) {
			return highlightElement((Operation) object, acceptor, cancelIndicator);
		} else if (object instanceof Property) {
			return highlightElement((Property) object, acceptor, cancelIndicator);
		} else

		if (object instanceof ServiceRef) {
			return highlightElement((ServiceRef) object, acceptor, cancelIndicator);
		} else if (object instanceof VersionedTypeRef) {
			return highlightElement((VersionedTypeRef) object, acceptor, cancelIndicator);
		} else if (object instanceof DataObjectRef) {
			return highlightElement((DataObjectRef) object, acceptor, cancelIndicator);
		} else if (object instanceof EnumTypeRef) {
			return highlightElement((EnumTypeRef) object, acceptor, cancelIndicator);
		} else if (object instanceof OperationRef) {
			return highlightElement((OperationRef) object, acceptor, cancelIndicator);
		} else if (object instanceof ExceptionRef) {
			return highlightElement((ExceptionRef) object, acceptor, cancelIndicator);
		} else if (object instanceof SimpleConsiderationPropertyRef) {
			return highlightElement((SimpleConsiderationPropertyRef) object, acceptor, cancelIndicator);
		} else if (object instanceof ComplexConsiderationPropertyRef) {
			return highlightElement((ComplexConsiderationPropertyRef) object, acceptor, cancelIndicator);
		} else {
			return super.highlightElement(object, acceptor, cancelIndicator);
		}
	}

	protected boolean highlightElement(Service object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (!Strings.isEmpty(object.getName()) && object.isDeprecated()) {
			ITextRegion nameRegion = locationInFileProvider.getSignificantTextRegion(object);
			acceptor.addPosition(nameRegion.getOffset(), nameRegion.getLength(), DEPRECATED_ID);
		}
		return false;
	}

	protected boolean highlightElement(VersionedType object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object instanceof VersionedType && !Strings.isEmpty(object.getName()) && object.isDeprecated()) {
			ITextRegion nameRegion = locationInFileProvider.getSignificantTextRegion(object);
			acceptor.addPosition(nameRegion.getOffset(), nameRegion.getLength(), DEPRECATED_ID);
		}
		return false;
	}

	protected boolean highlightElement(org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception object,
			IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (!Strings.isEmpty(object.getName()) && object.isDeprecated()) {
			ITextRegion nameRegion = locationInFileProvider.getSignificantTextRegion(object);
			acceptor.addPosition(nameRegion.getOffset(), nameRegion.getLength(), DEPRECATED_ID);
		}
		return false;
	}

	protected boolean highlightElement(Operation object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (!Strings.isEmpty(object.getName()) && object.isDeprecated()) {
			ITextRegion nameRegion = locationInFileProvider.getSignificantTextRegion(object);
			acceptor.addPosition(nameRegion.getOffset(), nameRegion.getLength(), DEPRECATED_ID);
		}
		return false;
	}

	protected boolean highlightElement(Property object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (!Strings.isEmpty(object.getName()) && object.isDeprecated()) {
			ITextRegion nameRegion = locationInFileProvider.getSignificantTextRegion(object);
			acceptor.addPosition(nameRegion.getOffset(), nameRegion.getLength(), DEPRECATED_ID);
		}
		return false;
	}

	protected boolean highlightElement(ServiceRef object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object.getService().isDeprecated()) {
			for (INode crossRefNode : NodeModelUtils.findNodesForFeature(object,
					ServiceDslPackage.Literals.SERVICE_REF__SERVICE)) {
				acceptor.addPosition(crossRefNode.getOffset(), crossRefNode.getLength(), DEPRECATED_ID);
			}
		}
		return false;
	}

	protected boolean highlightElement(VersionedTypeRef object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object.getType() != null && object.getType().isDeprecated()) {
			highlightFeature(acceptor, object, ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE, DEPRECATED_ID);
		}
		return false;
	}

	protected boolean highlightElement(DataObjectRef object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object.getType() != null && object.getType().isDeprecated()) {
			highlightFeature(acceptor, object, ServiceDslPackage.Literals.DATA_OBJECT_REF__TYPE, DEPRECATED_ID);
		}
		return false;
	}

	protected boolean highlightElement(EnumTypeRef object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object.getType() != null && object.getType().isDeprecated()) {
			highlightFeature(acceptor, object, ServiceDslPackage.Literals.ENUM_TYPE_REF__TYPE, DEPRECATED_ID);
		}
		return false;
	}

	protected boolean highlightElement(OperationRef object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object.getOperation() != null && object.getOperation().isDeprecated()) {
			highlightFeature(acceptor, object, ServiceDslPackage.Literals.OPERATION_REF__OPERATION, DEPRECATED_ID);
		}
		return false;
	}

	protected boolean highlightElement(ExceptionRef object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object.getException() != null && object.getException().isDeprecated()) {
			highlightFeature(acceptor, object, ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION, DEPRECATED_ID);
		}
		return false;
	}

	protected boolean highlightElement(SimpleConsiderationPropertyRef object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object.getProperty() != null && object.getProperty().isDeprecated()) {
			highlightFeature(acceptor, object, ServiceDslPackage.Literals.SIMPLE_CONSIDERATION_PROPERTY_REF__PROPERTY,
					DEPRECATED_ID);
		}
		return false;
	}

	protected boolean highlightElement(ComplexConsiderationPropertyRef object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object.getParentProperty() != null && object.getParentProperty().isDeprecated()) {
			highlightFeature(acceptor, object,
					ServiceDslPackage.Literals.COMPLEX_CONSIDERATION_PROPERTY_REF__PARENT_PROPERTY, DEPRECATED_ID);
		}
		return false;
	}

}
