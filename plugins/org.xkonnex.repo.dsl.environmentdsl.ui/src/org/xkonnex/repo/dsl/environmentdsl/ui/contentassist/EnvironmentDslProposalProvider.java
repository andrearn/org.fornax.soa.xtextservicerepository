/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.environmentdsl.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.common.types.xtext.ui.TypeMatchFilters;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.AppServer;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Broker;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Cluster;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ConfigurationScript;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Container;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ESB;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Executable;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleConnector;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Gateway;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.IdentityAccessManager;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.InfrastructureManager;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ProcessServer;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Registry;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SecurityProtocol;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.VM;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.WebServer;
import org.xkonnex.repo.dsl.environmentdsl.ext.cluster.ICluster;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;
import org.xkonnex.repo.dsl.environmentdsl.ext.container.IContainer;
import org.xkonnex.repo.dsl.environmentdsl.ext.db.IDataBase;
import org.xkonnex.repo.dsl.environmentdsl.ext.executable.IExecutable;
import org.xkonnex.repo.dsl.environmentdsl.ext.gateway.IGateway;
import org.xkonnex.repo.dsl.environmentdsl.ext.image.IImageConfigurationScript;
import org.xkonnex.repo.dsl.environmentdsl.ext.management.IInfrastructureManager;
import org.xkonnex.repo.dsl.environmentdsl.ext.registry.IRegistry;
import org.xkonnex.repo.dsl.environmentdsl.ext.security.IIdentityAccessManager;
import org.xkonnex.repo.dsl.environmentdsl.ext.security.ISecurityProtocol;
import org.xkonnex.repo.dsl.environmentdsl.ext.server.IAppServer;
import org.xkonnex.repo.dsl.environmentdsl.ext.server.IServer;
import org.xkonnex.repo.dsl.environmentdsl.ext.server.IWebserver;
import org.xkonnex.repo.dsl.environmentdsl.ext.server.esb.IESB;
import org.xkonnex.repo.dsl.environmentdsl.ext.server.messaging.IMessagingServer;
import org.xkonnex.repo.dsl.environmentdsl.ext.server.process.IProcessServer;
import org.xkonnex.repo.dsl.environmentdsl.ext.vm.IVirtualMachine;

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
	
	@Override
	public void completeExecutable_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof Executable) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType securityProtocol = typeProvider.findTypeByName(IExecutable.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(securityProtocol, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeExecutable_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeInfrastructureManager_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof InfrastructureManager) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType infrastructureManager = typeProvider.findTypeByName(IInfrastructureManager.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(infrastructureManager, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeInfrastructureManager_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeDatabase_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof Container) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType container = typeProvider.findTypeByName(IDataBase.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(container, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeContainer_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeContainer_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof Container) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType container = typeProvider.findTypeByName(IContainer.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(container, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeContainer_Type(model, assignment, context, acceptor);
		}
	}
	
	
	@Override
	public void completeVM_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof VM) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType vm = typeProvider.findTypeByName(IVirtualMachine.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(vm, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeVM_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeConfigurationScript_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof ConfigurationScript) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType imageConfigScript = typeProvider.findTypeByName(IImageConfigurationScript.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(imageConfigScript, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeConfigurationScript_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeCluster_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof Cluster) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType clusterManager = typeProvider.findTypeByName(ICluster.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(clusterManager, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeCluster_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeGateway_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof Gateway) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType gateway = typeProvider.findTypeByName(IGateway.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(gateway, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeGateway_Type(model, assignment, context, acceptor);
		}
	}

	@Override
	public void completeIAMReference_IdentityAccessManager(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof IdentityAccessManager) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType iam = typeProvider.findTypeByName(IIdentityAccessManager.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(iam, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeIAMReference_IdentityAccessManager(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeRegistry_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof Registry) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType registry = typeProvider.findTypeByName(IRegistry.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(registry, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeRegistry_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeProcessServer_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof ProcessServer) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType server = typeProvider.findTypeByName(IProcessServer.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(server, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeProcessServer_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeAppServer_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof AppServer) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType server = typeProvider.findTypeByName(IAppServer.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(server, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeAppServer_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeBroker_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof Broker) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType server = typeProvider.findTypeByName(IMessagingServer.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(server, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeBroker_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeESB_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof ESB) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType server = typeProvider.findTypeByName(IESB.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(server, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeESB_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeWebServer_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof WebServer) {
			IJvmTypeProvider typeProvider = typeScopeProvider.getTypeProvider(model.eResource().getResourceSet());
			JvmType server = typeProvider.findTypeByName(IWebserver.class.getCanonicalName());
			typeProposalProvider.createSubTypeProposals(server, this, context, BaseDslPackage.Literals.COMPONENT__TYPE, TypeMatchFilters.canInstantiate(), acceptor);
		} else {
			super.completeWebServer_Type(model, assignment, context, acceptor);
		}
	}
}
