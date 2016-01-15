/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.environmentdsl.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.common.types.xtext.ui.TypeMatchFilters;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentDslPackage;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleConnector;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SecurityProtocol;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;
import org.xkonnex.repo.dsl.environmentdsl.ext.security.ISecurityProtocol;
import org.xkonnex.repo.dsl.environmentdsl.ext.server.IServer;

import com.google.inject.Inject;
/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("restriction")
public class EnvironmentDslProposalProvider extends AbstractEnvironmentDslProposalProvider {
	
	@Inject
	private ITypesProposalProvider typeProposalProvider;
	
	@Inject
	private AbstractTypeScopeProvider typeScopeProvider;
	
	@Override
	public void completeExtensibleConnector_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof ExtensibleConnector) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType connectorType = typeProvider.findTypeByName(IConnector.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(connectorType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeExtensibleConnector_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeExtensibleServer_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof ExtensibleConnector) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType serverType = typeProvider.findTypeByName(IServer.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(serverType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeExtensibleServer_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeSecurityProtocol_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof SecurityProtocol || model instanceof Connector) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType securityProtocol = typeProvider.findTypeByName(ISecurityProtocol.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(securityProtocol, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeSecurityProtocol_Type(model, assignment, context, acceptor);
		}
	}
}
