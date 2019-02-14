/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.sladsl.ui.contentassist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.xkonnex.repo.dsl.basedsl.ext.crypto.ICipherAlgoritm;
import org.xkonnex.repo.dsl.basedsl.ext.crypto.IHashAlgorithm;
import org.xkonnex.repo.dsl.basedsl.ext.crypto.ISigningAlgorithm;
import org.xkonnex.repo.dsl.basedsl.ext.token.IAuthTokenKind;
import org.xkonnex.repo.dsl.sladsl.sLADsl.AuthenticationPolicy;
import org.xkonnex.repo.dsl.sladsl.sLADsl.EncryptionPolicy;
import org.xkonnex.repo.dsl.sladsl.sLADsl.SigningPolicy;

import com.google.inject.Inject;
/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("restriction")
public class SLADslProposalProvider extends AbstractSLADslProposalProvider {
	
	@Inject
	private ITypesProposalProvider typeProposalProvider;
	
	@Inject
	private AbstractTypeScopeProvider typeScopeProvider;

	private DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
	
	@Override
	public void completeAuthenticationPolicy_AuthTokens(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof AuthenticationPolicy) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType protocolType = typeProvider.findTypeByName(IAuthTokenKind.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(protocolType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void completeAuthenticationPolicy_HashAlgorithms(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof AuthenticationPolicy) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType hashType = typeProvider.findTypeByName(IHashAlgorithm.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(hashType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void completeEncryptionPolicy_RequiredCipherAlgorithm(
			EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof EncryptionPolicy) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType cipherType = typeProvider.findTypeByName(ICipherAlgoritm.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(cipherType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void completeEncryptionPolicy_SupportedCipherAlgorithms(
			EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof EncryptionPolicy) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType cipherType = typeProvider.findTypeByName(ICipherAlgoritm.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(cipherType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}

	@Override
	public void completeSigningPolicy_RequiredSigningAlgorithm(
			EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof SigningPolicy) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType signingType = typeProvider.findTypeByName(ISigningAlgorithm.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(signingType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void completeSigningPolicy_SupportedSigningAlgorithms(
			EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof SigningPolicy) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType signingType = typeProvider.findTypeByName(ISigningAlgorithm.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(signingType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void completeSLA_EffectiveDate(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		String proposal = dateFormat.format(new Date());
		acceptor.accept(createCompletionProposal(proposal , context));
	}
	
	@Override
	public void completeSLA_EffectiveUntil(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		String proposal = dateFormat.format(new Date());
		acceptor.accept(createCompletionProposal(proposal , context));
	}
	
	@Override
	public void complete_Duration(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("1 s", context));
	}
	
	@Override
	public void complete_BinarySize(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("1 MB", context));
	}
	
	@Override
	public void completeDuration_Duration(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("1", context));
	}
		
	@Override
	public void completeBinarySize_Size(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("1", context));
	}
	
}
