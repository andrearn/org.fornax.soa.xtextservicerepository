package org.xkonnex.repo.dsl.moduledsl.query.endpoint;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Channel;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

import com.google.inject.ImplementedBy;

@ImplementedBy(BottomUpModuleEndpointProtocolLookup.class)
public interface IModuleEndpointProtocolLookup {

	public List<IModuleEndpointProtocol> collectEndpointProtocolHierarchyByType (Service service, Module module, IModuleEndpointProtocol protocol);
	
	public List<IModuleEndpointProtocol> collectEndpointProtocolHierarchyByType (Operation operation, Module module, IModuleEndpointProtocol protocol);

	public List<IModuleEndpointProtocol> collectEndpointProtocolHierarchyByType (Channel channel, Module module, IModuleEndpointProtocol protocol);

}
