/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.moduledsl.ui.contentassist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.common.types.xtext.ui.TypeMatchFilters;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Component;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Import;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;
import org.xkonnex.repo.dsl.moduledsl.ext.assembly.IAssemblyType;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AssemblyType;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Endpoint;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ExtensibleAssemblyType;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportServiceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslPackage;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleModel;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.OperationRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceModuleRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.UsingEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.util.ModuleDslAccess;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("restriction")
public class ModuleDslProposalProvider extends AbstractModuleDslProposalProvider {
	
	@Inject
	private ITypesProposalProvider typeProposalProvider;
	
	@Inject
	private AbstractTypeScopeProvider typeScopeProvider;

	private DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

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
	
	@Override
	public void completeExtensibleAssemblyType_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof ExtensibleAssemblyType || model instanceof AssemblyType) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType assemblyType = typeProvider.findTypeByName(IAssemblyType.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(assemblyType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
//		} else {
//			super.completeExtensibleAssemblyType_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void complete_ExtensibleAssemblyType(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof ExtensibleAssemblyType || model instanceof AssemblyType) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType assemblyType = typeProvider.findTypeByName(IAssemblyType.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(assemblyType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		}
	}
	
	@Override
	public void completeAssemblyType_TypeEnum(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
		JvmType assemblyType = typeProvider.findTypeByName(IAssemblyType.class.getCanonicalName());
		typeProposalProvider.createSubTypeProposals(assemblyType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		super.completeAssemblyType_TypeEnum(model, assignment, context, acceptor);
	}
	
	@Override
	public void complete_AssemblyTypeEnum(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
		JvmType assemblyType = typeProvider.findTypeByName(IAssemblyType.class.getCanonicalName());
		typeProposalProvider.createSubTypeProposals(assemblyType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		super.complete_AssemblyTypeEnum(model, ruleCall, context, acceptor);
	}
	
	@Override
	public void complete_EndpointProtocol(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof EndpointProtocol || model instanceof Endpoint) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType importBindingType = typeProvider.findTypeByName(IModuleEndpointProtocol.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(importBindingType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.complete_EndpointProtocol(model, ruleCall, context,
				acceptor);
		}
	}
	@Override
	public void complete_UsingEndpointProtocol(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof EndpointProtocol || model instanceof Endpoint) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType importBindingType = typeProvider.findTypeByName(IModuleEndpointProtocol.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(importBindingType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.complete_UsingEndpointProtocol(model, ruleCall, context,
				acceptor);
		}
	}
	
	@Override
	public void complete_ProvidingEndpointProtocol(EObject model,
			RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof EndpointProtocol || model instanceof Endpoint) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType importBindingType = typeProvider.findTypeByName(IModuleEndpointProtocol.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(importBindingType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.complete_ProvidingEndpointProtocol(model, ruleCall, context,
				acceptor);
		}
	}
	
	@Override
	public void completeUsingEndpointProtocol_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof UsingEndpointProtocol || model instanceof Endpoint) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType importBindingType = typeProvider.findTypeByName(IModuleEndpointProtocol.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(importBindingType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeUsingEndpointProtocol_Type(model, assignment, context,
				acceptor);
		}
	}
	
	@Override
	public void completeProvidingEndpointProtocol_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof ProvidingEndpointProtocol || model instanceof Endpoint) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType importBindingType = typeProvider.findTypeByName(IModuleEndpointProtocol.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(importBindingType, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeProvidingEndpointProtocol_Type(model, assignment, context,
				acceptor);
		}
	}

	@Override
	public void completeAssignment_Feature(EObject model,
			org.eclipse.xtext.Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Component component = EcoreUtil2.getContainerOfType(model, Component.class);
		if ((model instanceof OperationRef || model instanceof org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment) && component != null) {
			createFeatureProposals((Component) component, context, acceptor);
		} else if (model instanceof Component) {
			createFeatureProposals((Component) model, context, acceptor);
		}
	}
	
	@Override
	public void completeModule_ReleaseDate(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		String proposal = dateFormat.format(new Date());
		acceptor.accept(createCompletionProposal(proposal , context));
	}

}
