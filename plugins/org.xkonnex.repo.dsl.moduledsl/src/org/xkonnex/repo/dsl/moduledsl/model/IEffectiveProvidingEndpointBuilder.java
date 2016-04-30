package org.xkonnex.repo.dsl.moduledsl.model;

import java.util.List;

import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpoint;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

import com.google.inject.ImplementedBy;

@ImplementedBy(BottomUpProvidingEndpointBuilder.class)
public interface IEffectiveProvidingEndpointBuilder {

	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (Operation operation, ProvidingEndpoint specificEndpoint);
	
	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (Service service, ProvidingEndpoint specificEndpoint);

	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (Operation operation, Module module, IModuleEndpointProtocol protType);
	
	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (Service service, Module module, IModuleEndpointProtocol protType);

	public List<EffectiveProvidingEndpoint> createEffectiveProvidingEndpoints (Operation operation, Module module);
	
	public List<EffectiveProvidingEndpoint> createEffectiveProvidingEndpoints (Service service, Module module);

	public EffectiveProvidingEndpoint createEffectiveProvidingEndpointForClazz (Operation operation, Module module, Class<? extends IModuleEndpointProtocol> endpointProtocolClazz);
	
	public EffectiveProvidingEndpoint createEffectiveProvidingEndpointForClazz (Service service, Module module, Class<? extends IModuleEndpointProtocol> endpointProtocolClazz);

}
