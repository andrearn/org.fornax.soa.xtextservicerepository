/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.servicedsl.ui.contentassist;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Import;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ComplexConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.QueryObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.RequiredServiceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceModel;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SimpleConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SimpleOperationRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef;
import org.xkonnex.repo.dsl.servicedsl.services.ServiceDslGrammarAccess.BusinessObjectRefElements;
import org.xkonnex.repo.dsl.servicedsl.ui.contentassist.AbstractServiceDslProposalProvider;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class ServiceDslProposalProvider extends AbstractServiceDslProposalProvider {
	
	@Inject
	protected IQualifiedNameProvider nameProvider;
	
	@Inject
	protected IEObjectLookup objLookup;

	public void complete_VersionId (EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		calculateVersionProposals (model, context, acceptor, false);
	}
	
	public void complete_INT(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof MajorVersionRef)  {
			calculateVersionProposals (model, context, acceptor, true);
		} else if(model.eContainer() instanceof MajorVersionRef) {
			calculateVersionProposals (model, context, acceptor, true);
		} else {
			super.complete_INT (model, ruleCall, context, acceptor);
		}
	}
	
//	public void complete_Operation (EObject model, RuleCall ruleCall, ContentAssistContext context,
//			ICompletionProposalAcceptor acceptor) {
//		if (model.eContainer() instanceof SimpleOperationRef && model.eContainer().eContainer() instanceof RequiredServiceRef) {
//			RequiredServiceRef serviceRef = (RequiredServiceRef) model.eContainer().eContainer();
//			final QualifiedName serviceName = nameProvider.getFullyQualifiedName(serviceRef.getService());
//			getCrossReferenceProposalCreator().
//		} else {
//			super.complete_Operation(model, ruleCall, context, acceptor);
//		}
//		
//	}
	

	private void calculateVersionProposals (EObject model,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor, boolean majorVersionsOnly) {
		ICompositeNode parentNode = NodeModelUtils.findActualNodeFor (model).getParent();
		if (parentNode != null) {
			Iterable<ILeafNode> leafs = parentNode.getLeafNodes();
			Iterable<ILeafNode> nonHidden = Iterables.filter (leafs, new Predicate<ILeafNode>() {
	
				public boolean apply (ILeafNode node) {
					return !node.isHidden();
				}
				
			});
			ServiceModel serviceModel = null;
			EObject curObj = model;
			while (! (curObj instanceof ServiceModel) && curObj.eContainer() != null) {
				curObj = curObj.eContainer();
			}
			if (curObj instanceof ServiceModel) {
				serviceModel = (ServiceModel) curObj;
				EList<Import> imports = serviceModel.getImports();
				final Iterable<String> importedNamespaces = Lists.transform (imports, new Function<Import, String> () {
	
					public String apply (Import from) {
						return from.getImportedNamespace().replaceAll("\\.\\*", "");
					}
					
				});
				Iterator<ILeafNode> leafIt = nonHidden.iterator();
				if (model.eContainer() instanceof VersionedTypeRef) {
					VersionedTypeRef typeRef = (VersionedTypeRef) model.eContainer();
					boolean versionConstraintFound = false;
					StringBuilder nameParts = new StringBuilder();
					while (leafIt.hasNext() && !versionConstraintFound) {
						ILeafNode curNode = leafIt.next();
						if (curNode.getSemanticElement() instanceof VersionRef)
							versionConstraintFound = true;
						else
							nameParts.append(curNode.getText());
					}
					String typeName = nameParts.toString().trim().replaceAll("\\[\\]", "").trim();
					Iterable<String> canditateVersions = getCanditateVersions (typeName, ServiceDslPackage.Literals.BUSINESS_OBJECT.getName(), importedNamespaces, majorVersionsOnly);
					if (!canditateVersions.iterator().hasNext())
						canditateVersions = getCanditateVersions (typeName, ServiceDslPackage.Literals.ENUMERATION.getName(), importedNamespaces, majorVersionsOnly);
					for (String version : canditateVersions) {
						acceptor.accept (createCompletionProposal (version, context));
					}
	
				} else if (model.eContainer() instanceof DataObjectRef) {
					DataObjectRef typeRef = (DataObjectRef) model.eContainer();
					boolean versionConstraintFound = false;
					StringBuilder nameParts = new StringBuilder();
					while (leafIt.hasNext() && !versionConstraintFound) {
						ILeafNode curNode = leafIt.next();
						if (curNode.getSemanticElement() instanceof VersionRef)
							versionConstraintFound = true;
						else
							nameParts.append(curNode.getText());
					}
					String typeName = nameParts.toString().trim().replaceAll("\\[\\]", "").trim();
					EObject versionedOwner = objLookup.getVersionedOwner(model.eContainer());
					String className = null;
					if (versionedOwner instanceof QueryObject) 
						className = ServiceDslPackage.Literals.QUERY_OBJECT.getName();
					else
						className = ServiceDslPackage.Literals.BUSINESS_OBJECT.getName();
					Iterable<String> canditateVersions = getCanditateVersions (typeName, className, importedNamespaces, majorVersionsOnly);
					for (String version : canditateVersions) {
						acceptor.accept (createCompletionProposal (version, context));
					}
	
				} else if (model.eContainer() instanceof EnumTypeRef) {
					EnumTypeRef typeRef = (EnumTypeRef) model.eContainer();
					boolean versionConstraintFound = false;
					StringBuilder nameParts = new StringBuilder();
					while (leafIt.hasNext() && !versionConstraintFound) {
						ILeafNode curNode = leafIt.next();
						if (curNode.getSemanticElement() instanceof VersionRef)
							versionConstraintFound = true;
						else
							nameParts.append(curNode.getText());
					}
					String typeName = nameParts.toString().trim().replaceAll("\\[\\]", "").trim();
					String className = ServiceDslPackage.Literals.ENUMERATION.getName();
					Iterable<String> canditateVersions = getCanditateVersions (typeName, className, importedNamespaces, majorVersionsOnly);
					for (String version : canditateVersions) {
						acceptor.accept (createCompletionProposal (version, context));
					}
	
				} else if (model.eContainer() instanceof ServiceRef) {
					ServiceRef svcRef = (ServiceRef) model.eContainer();
					boolean versionConstraintFound = false;
					StringBuilder nameParts = new StringBuilder();
					while (leafIt.hasNext() && !versionConstraintFound) {
						ILeafNode curNode = leafIt.next();
						if (curNode.getSemanticElement() instanceof VersionRef)
							versionConstraintFound = true;
						else
							nameParts.append(curNode.getText());
					}
					String svcName = nameParts.toString().trim().replaceAll("\\[\\]", "").trim();
					String className = ServiceDslPackage.Literals.SERVICE.getName();
					Iterable<String> canditateVersions = getCanditateVersions (svcName, className, importedNamespaces, majorVersionsOnly);
					for (String version : canditateVersions) {
						acceptor.accept (createCompletionProposal (version, context));
					}
	
				} else if (model.eContainer() instanceof ExceptionRef) {
					boolean versionConstraintFound = false;
					StringBuilder nameParts = new StringBuilder();
					while (leafIt.hasNext() && !versionConstraintFound) {
						ILeafNode curNode = leafIt.next();
						if (curNode.getSemanticElement() instanceof VersionRef)
							versionConstraintFound = true;
						else
							nameParts.append(curNode.getText());
					}
					String typeName = nameParts.toString().trim().replaceAll("\\[\\]", "").trim();
					String className = ServiceDslPackage.Literals.EXCEPTION.getName();
					Iterable<String> canditateVersions = getCanditateVersions (typeName, className, importedNamespaces, majorVersionsOnly);
					for (String version : canditateVersions) {
						acceptor.accept (createCompletionProposal (version, context));
					}
				} else {
					if (majorVersionsOnly)
						acceptor.accept (createCompletionProposal ("1", context));
					else
						acceptor.accept (createCompletionProposal ("1.0", context));
				}
			}
		}
	}
	
}
