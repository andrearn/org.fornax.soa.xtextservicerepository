/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.moduledsl.ui.contentassist;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportServiceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslPackage;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleModel;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceModuleRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceRef;
import org.xkonnex.repo.dsl.moduledsl.ui.contentassist.AbstractModuleDslProposalProvider;
import org.xkonnex.repo.dsl.moduledsl.util.ModuleDslAccess;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.Import;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.Version;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.VersionRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class ModuleDslProposalProvider extends AbstractModuleDslProposalProvider {

	public void complete_VersionId(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		calculateVersionProposals(model, context, acceptor, false);
	}
	
	public void complete_INT(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model.eContainer() instanceof MajorVersionRef)  {
			calculateVersionProposals(model, context, acceptor, true);
		} else if (model instanceof MajorVersionRef)  {
				calculateVersionProposals(model, context, acceptor, true);
		} else {
			super.complete_INT (model, ruleCall, context, acceptor);
		}
	}	

	private void calculateVersionProposals(EObject model,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor, boolean majorVersionsOnly) {
		ICompositeNode parentNode = NodeModelUtils.findActualNodeFor (model).getParent();
		Iterable<ILeafNode> leafs = parentNode.getLeafNodes();
		Iterable<ILeafNode> nonHidden = Iterables.filter (leafs, new Predicate<ILeafNode>() {
			
			public boolean apply (ILeafNode node) {
				return !node.isHidden();
			}
			
		});
		ModuleModel moduleModel = ModuleDslAccess.getModuleModel (model);
		EList<Import> imports = moduleModel.getImports();
		final Iterable<String> importedNamespaces = Lists.transform (imports, new Function<Import, String> () {

			public String apply (Import from) {
				return from.getImportedNamespace().replaceAll("\\.\\*", "");
			}
			
		});
		Iterator<ILeafNode> leafIt = nonHidden.iterator();
		if (model.eContainer() instanceof ServiceRef || model.eContainer() instanceof ImportServiceRef) {
			boolean versionConstraintFound = false;
			StringBuilder nameParts = new StringBuilder();
			while (leafIt.hasNext() && !versionConstraintFound) {
				ILeafNode curNode = leafIt.next();
				if (curNode.getSemanticElement() instanceof VersionRef)
					versionConstraintFound = true;
				else
					nameParts.append(curNode.getText());
			}
			String serviceName = nameParts.toString().trim();
			if (serviceName.startsWith ("service"))
				serviceName = serviceName.replaceFirst ("service", "").trim();
			final String className = ServiceDslPackage.Literals.SERVICE.getName();
			Iterable<String> canditateVersions = getCanditateVersions (serviceName, className, importedNamespaces, model.eContainer() instanceof MajorVersionRef || model instanceof MajorVersionRef);
			for (String version : canditateVersions) {
				acceptor.accept (createCompletionProposal (version, context));
			}
		} else if (model.eContainer() instanceof ModuleRef || model.eContainer() instanceof ServiceModuleRef) {
			boolean versionConstraintFound = false;
			StringBuilder nameParts = new StringBuilder();
			while (leafIt.hasNext() && !versionConstraintFound) {
				ILeafNode curNode = leafIt.next();
				if (curNode.getSemanticElement() instanceof VersionRef)
					versionConstraintFound = true;
				else
					nameParts.append(curNode.getText());
			}
			String moduleName = nameParts.toString().trim();
			final String className = ModuleDslPackage.Literals.MODULE.getName();
			Iterable<String> canditateVersions = getCanditateVersions (moduleName, className, importedNamespaces, model.eContainer() instanceof MajorVersionRef || model instanceof MajorVersionRef);
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