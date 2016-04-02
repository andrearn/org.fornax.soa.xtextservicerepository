package org.xkonnex.repo.dsl.moduledsl.query.endpoint;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpoint;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpointConfig;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Channel;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultProvidingEndpointResolver.class)
public interface IProvidingEndpointResolver {
	
	public ProvidingEndpointConfig getMostSpecificProvidingEndpointConfig(Service service, Module module);
	
	public ProvidingEndpointConfig getMostSpecificProvidingEndpointConfig(Operation operation, Module module);

	public ProvidingEndpointConfig getMostSpecificProvidingEndpointConfig(Channel channel, Module module);

	public ProvidingEndpoint getMostSpecificProvidingEndpointByType(Service service, Module module, IModuleEndpointProtocol protocol);
	
	public ProvidingEndpoint getMostSpecificProvidingEndpointByType(Operation operation, Module module, IModuleEndpointProtocol protocol);

	public ProvidingEndpoint getMostSpecificProvidingEndpointByType(Channel channel, Module module, IModuleEndpointProtocol protocol);
	
	public EList<ProvidingEndpoint> getOperationProvidingEndpoints(Operation operation, Module module);
	
	public EList<ProvidingEndpoint> getServiceProvidingEndpoints(Service service, Module module);

	public List<EObject> collectProvidingEndpointHierarchyByType (Service service, Module module, IModuleEndpointProtocol protocol);
	
	public List<EObject> collectProvidingEndpointHierarchyByType (Operation operation, Module module, IModuleEndpointProtocol protocol);

	public List<EObject> collectProvidingEndpointHierarchyByType (Channel channel, Module module, IModuleEndpointProtocol protocol);
	

}
