/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.basedsl.ui.contentassist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.common.types.xtext.ui.TypeMatchFilters;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.search.IXtextEObjectSearch;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment;
import org.xkonnex.repo.dsl.basedsl.baseDsl.AuthToken;
import org.xkonnex.repo.dsl.basedsl.baseDsl.AuthTokenKind;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage;
import org.xkonnex.repo.dsl.basedsl.baseDsl.CipherAlgorithmKind;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Component;
import org.xkonnex.repo.dsl.basedsl.baseDsl.HashAlgorithm;
import org.xkonnex.repo.dsl.basedsl.baseDsl.HashAlgorithmKind;
import org.xkonnex.repo.dsl.basedsl.baseDsl.SigningAlgorithm;
import org.xkonnex.repo.dsl.basedsl.ext.crypto.ICipherAlgoritm;
import org.xkonnex.repo.dsl.basedsl.ext.crypto.IHashAlgorithm;
import org.xkonnex.repo.dsl.basedsl.ext.crypto.ISigningAlgorithm;
import org.xkonnex.repo.dsl.basedsl.ext.token.IAuthTokenKind;
import org.xkonnex.repo.dsl.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.xkonnex.repo.dsl.basedsl.scoping.BaseDslScopeProvider;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("restriction")
public class BaseDslProposalProvider extends AbstractBaseDslProposalProvider {

	@Inject
	private IXtextEObjectSearch searchEngine;
	
	@Inject
	private ITypesProposalProvider typeProposalProvider;
	
	@Inject
	private BaseDslScopeProvider componentScopeProvider; 
	
	@Inject
	private AbstractTypeScopeProvider typeScopeProvider;
	
	private DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

	public void complete_QualifiedName(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.complete_QualifiedName(model, ruleCall, context, acceptor);
		String proposal = "qualified.name";
		acceptor.accept(createCompletionProposal(proposal , context));
	}

	public void complete_VersionId(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.complete_VersionId(model, ruleCall, context, acceptor);
		String proposal = "0.0.0";
		acceptor.accept(createCompletionProposal(proposal , context));
	}

	public Iterable<String> getCanditateVersions(final String canditateName, final String canditateClassName, final Iterable<String> importedNamespaces, final boolean majorVersionsOnly) {
		Iterable<IEObjectDescription> canditates = findByNameAndEClass(canditateName, canditateClassName, importedNamespaces);
		return extractCanditateVersions (canditates, majorVersionsOnly);
	}

	public Iterable<String> getCanditateVersions(final String canditateName, final List<String> canditateClassName, final Iterable<String> importedNamespaces, final boolean majorVersionsOnly) {
		List<IEObjectDescription> canditates = Lists.newArrayList();
		for (String className : canditateClassName) {
			List<IEObjectDescription> curCanditates = Lists.newArrayList (findByNameAndEClass (canditateName, className, importedNamespaces));
			canditates.addAll (curCanditates);
		}
		return extractCanditateVersions (canditates, majorVersionsOnly);
	}
	
	private Iterable<IEObjectDescription> findByNameAndEClass (final String canditateName, final String canditateClassName, final Iterable<String> importedNamespaces) {
		Iterable<IEObjectDescription> ieObjDesc = searchEngine.findMatches (canditateName + " ", canditateClassName);
		if (!ieObjDesc.iterator().hasNext()) {
			ieObjDesc = Iterables.concat (ieObjDesc, searchEngine.findMatches("*." + canditateName + " ", canditateClassName));
			ieObjDesc = Iterables.filter (ieObjDesc, new Predicate<IEObjectDescription>() {
	
				public boolean apply(IEObjectDescription desc) {
					for (String impName : importedNamespaces) {
						if (desc.getName().toString().equals(impName + "." + canditateName))
							return true;
					}
					return false;
				}
			});
		}
		return ieObjDesc;
	}

	private Iterable<String> extractCanditateVersions (Iterable<IEObjectDescription> canditates, final boolean majorVersionsOnly) {
		Iterable<String> versions = Iterables.transform (canditates, new Function<IEObjectDescription, String> () {
	
			public String apply(IEObjectDescription from) {
				String version = from.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY);
				if (majorVersionsOnly)
					return version.substring(0, version.indexOf("."));
				return version;
			}
			
		});
		return Sets.newTreeSet (Iterables.filter(versions, Predicates.notNull()));
	}


	
	@Override
	public BaseDslScopeProvider getScopeProvider() {
		return (BaseDslScopeProvider) super.getScopeProvider();
	}
	
	@Override
	public void completeAssignment_Feature(EObject model,
			org.eclipse.xtext.Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Component component = EcoreUtil2.getContainerOfType(model, Component.class);
		if (model instanceof Assignment && component != null) {
			createFeatureProposals((Component) component, context, acceptor);
		} else if (model instanceof Component) {
			createFeatureProposals((Component) model, context, acceptor);
		}
	}
	
	protected void createFeatureProposals(Component component,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		IScope scope = componentScopeProvider.createComponentFeaturesScope(component);
		Iterable<IEObjectDescription> candidates = scope.getAllElements();
		Function<IEObjectDescription, ICompletionProposal> factory = getProposalFactory("FQN", context);
		for (IEObjectDescription candidate: candidates) {
			if (!acceptor.canAcceptMoreProposals())
				return;
			acceptor.accept(factory.apply(candidate));
		}
	}
		
	@Override
	public void completeComponent_Type(EObject model,
			org.eclipse.xtext.Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof Component)
			model = model.eContainer();
		if (model instanceof Assignment) {
			Assignment attribute = (Assignment) model;
			if (attribute.getFeature() == null || attribute.getFeature().eIsProxy())
				return;
			JvmIdentifiableElement feature = attribute.getFeature();
			if (feature instanceof JvmOperation) {
				JvmType parameterType = ((JvmOperation) feature).getParameters().get(0).getParameterType().getType();
				typeProposalProvider.createSubTypeProposals(parameterType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
			}
		}
	}
	
	@Override
	public void completeAssignment_Value(EObject model,
			org.eclipse.xtext.Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if(model instanceof Assignment) {
			Assignment attribute = (Assignment) model;
			if (attribute.getFeature() == null || attribute.getFeature().eIsProxy())
				return;
			JvmIdentifiableElement feature = attribute.getFeature();
			if (feature instanceof JvmOperation) {
				JvmType parameterType = ((JvmOperation) feature).getParameters().get(0).getParameterType().getType();
				if (parameterType instanceof JvmEnumerationType) {
					JvmEnumerationType enumType = (JvmEnumerationType)parameterType;
					EList<JvmEnumerationLiteral> literals = enumType.getLiterals();
					for (JvmEnumerationLiteral jvmEnumerationLiteral : literals) {
						if (!acceptor.canAcceptMoreProposals())
							return;
						String proposalText = jvmEnumerationLiteral.getSimpleName();
						StyledString displayText = new StyledString(proposalText + " - Value");
						ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, 600,
								context.getPrefix(), context);
						acceptor.accept(proposal);
					}
				} else if(parameterType instanceof JvmGenericType) {
					JvmGenericType genericType = (JvmGenericType)parameterType;
					if (!("Boolean".equals(genericType.getSimpleName()) || "String".equals(genericType.getSimpleName()) || "Integer".equals(genericType.getSimpleName()))) {
						String proposalText = "{";
						acceptor.accept(createCompletionProposal(proposalText,  new StyledString(proposalText + " - Value"), null, 600,
								context.getPrefix(), context));
					}
				}
			}
		}
			
	}
	
	@Override
	protected String getDisplayString(EObject element, String qualifiedName,
			String shortName) {
		return super.getDisplayString(element, qualifiedName, shortName);
	}	
	
	
	@Override
	public void completeAuthTokenKind_Type(EObject model,
			org.eclipse.xtext.Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof AuthTokenKind || model instanceof AuthToken) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType protocolType = typeProvider.findTypeByName(IAuthTokenKind.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(protocolType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void completeHashAlgorithmKind_Type(EObject model,
			org.eclipse.xtext.Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof HashAlgorithmKind || model instanceof HashAlgorithm) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType hashType = typeProvider.findTypeByName(IHashAlgorithm.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(hashType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void completeCipherAlgorithmKind_Type(EObject model,
			org.eclipse.xtext.Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof CipherAlgorithmKind) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType cipherType = typeProvider.findTypeByName(ICipherAlgoritm.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(cipherType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void completeSigningAlgorithm_Type(EObject model,
			org.eclipse.xtext.Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof SigningAlgorithm) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType signingType = typeProvider.findTypeByName(ISigningAlgorithm.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(signingType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}

	@Override
	public void complete_AuthTokenKind(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof AuthTokenKind) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType protocolType = typeProvider.findTypeByName(IAuthTokenKind.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(protocolType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void complete_HashAlgorithmKind(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof HashAlgorithmKind) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType hashType = typeProvider.findTypeByName(IHashAlgorithm.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(hashType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void complete_CipherAlgorithmKind(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof CipherAlgorithmKind) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType cipherType = typeProvider.findTypeByName(ICipherAlgoritm.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(cipherType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void complete_SigningAlgorithm(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof SigningAlgorithm) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType signingType = typeProvider.findTypeByName(ISigningAlgorithm.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(signingType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void complete_TEXT(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("`Multiline text`" , context));
	}
	
	@Override
	public void complete_DATE(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		String proposal = dateFormat.format(new Date());
		acceptor.accept(createCompletionProposal(proposal , context));
	}
	
	@Override
	public void completePercent_Value(EObject model, org.eclipse.xtext.Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("99.9" , context));
	}
	
	@Override
	public void complete_Percent(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("99.9%" , context));
	}
	
	@Override
	public void complete_Double(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("1.0" , context));
	}
	
	@Override
	public void completeGovernanceDecision_ApprovalDate(EObject model,
			org.eclipse.xtext.Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		String proposal = dateFormat.format(new Date());
		acceptor.accept(createCompletionProposal(proposal , context));
	}
	
	@Override
	public void completeGovernanceDecision_EffectiveDate(EObject model,
			org.eclipse.xtext.Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		String proposal = dateFormat.format(new Date());
		acceptor.accept(createCompletionProposal(proposal , context));
	}
	
	@Override
	public void complete_EmailOrUsername(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("\"email or username\"",
				context));
		acceptor.accept(createCompletionProposal("user.name@example.org",
				context));
	}

}
