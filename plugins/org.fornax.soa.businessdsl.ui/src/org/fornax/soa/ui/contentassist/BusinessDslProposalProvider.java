/*
* generated by Xtext
*/
package org.fornax.soa.ui.contentassist;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.fornax.soa.basedsl.sOABaseDsl.Import;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.businessDsl.BusinessDslPackage;
import org.fornax.soa.businessDsl.BusinessModel;
import org.fornax.soa.businessDsl.CapabilityRef;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class BusinessDslProposalProvider extends AbstractBusinessDslProposalProvider {
	
	@Inject
	IQualifiedNameProvider qualifiedNameProvider;

	public void complete_VersionId (EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		calculateVersionProposals(model, context, acceptor, false);
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

	private void calculateVersionProposals (EObject model,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor, boolean majorVersionsOnly) {
		ICompositeNode parentNode = NodeModelUtils.findActualNodeFor (model).getParent();
		Iterable<ILeafNode> leafs = parentNode.getLeafNodes();
		Iterable<ILeafNode> nonHidden = Iterables.filter (leafs, new Predicate<ILeafNode>() {

			public boolean apply (ILeafNode node) {
				return !node.isHidden();
			}
			
		});
		BusinessModel bizModel = null;
		EObject curObj = model;
		while (! (curObj instanceof BusinessModel) && curObj.eContainer() != null) {
			curObj = curObj.eContainer();
		}
		if (curObj instanceof BusinessModel) {
			bizModel = (BusinessModel) curObj;
			EList<Import> imports = bizModel.getImports();
			List<String> importedNamespaces = Lists.newArrayList (Lists.transform (imports, new Function<Import, String> () {

				public String apply (Import from) {
					return from.getImportedNamespace().replaceAll("\\.\\*", "");
				}
				
			}));
			Iterator<ILeafNode> leafIt = nonHidden.iterator();
			if (model.eContainer() instanceof CapabilityRef) {
				CapabilityRef capRef = (CapabilityRef) model.eContainer();
				boolean versionConstraintFound = false;
				StringBuilder nameParts = new StringBuilder();
				while (leafIt.hasNext() && !versionConstraintFound) {
					ILeafNode curNode = leafIt.next();
					if (curNode.getSemanticElement() instanceof VersionRef)
						versionConstraintFound = true;
					else
						nameParts.append (curNode.getText());
				}
				String typeName = nameParts.toString().trim().replaceAll("\\[\\]", "").trim();
				final List<String> classNames = Lists.newArrayList (BusinessDslPackage.Literals.SIMPLE_CAPABILITY.getName(), BusinessDslPackage.Literals.CAPABILITY_VARIANT.getName());
				Iterable<String> canditateVersions = getCanditateVersions (typeName, classNames, importedNamespaces, majorVersionsOnly);
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
	
	private EObject getNamedEObject	(EObject model) {
		EObject curObj = model;
		while (curObj.eContainer() != null) {
			if (curObj.eClass().getEStructuralFeature("name") != null) {
				return model;
			} else {
				curObj = curObj.eContainer();
			}
		}
		return null;
	}

}
