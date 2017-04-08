package org.xkonnex.repo.dsl.moduledsl.model;

import java.util.List;

import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpoint;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractOperation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

import com.google.inject.ImplementedBy;

@ImplementedBy(BottomUpProvidingEndpointBuilder.class)
public interface IEffectiveProvidingEndpointBuilder {

	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (AbstractOperation operation, ProvidingEndpoint specificEndpoint);
	
	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (Service service, ProvidingEndpoint specificEndpoint);
	
	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (Resource resource, ProvidingEndpoint specificEndpoint);

	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (AbstractOperation operation, Module module, IModuleEndpointProtocol protType);
	
	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (Service service, Module module, IModuleEndpointProtocol protType);
	
	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (Resource resource, Module module, IModuleEndpointProtocol protType);

	public List<EffectiveProvidingEndpoint> createEffectiveProvidingEndpoints (AbstractOperation operation, Module module);
	
	public List<EffectiveProvidingEndpoint> createEffectiveProvidingEndpoints (Service service, Module module);
	
	public List<EffectiveProvidingEndpoint> createEffectiveProvidingEndpoints (Resource resource, Module module);

	public EffectiveProvidingEndpoint createEffectiveProvidingEndpointForClazz (AbstractOperation operation, Module module, Class<? extends IModuleEndpointProtocol> endpointProtocolClazz);
	
	public EffectiveProvidingEndpoint createEffectiveProvidingEndpointForClazz (Service service, Module module, Class<? extends IModuleEndpointProtocol> endpointProtocolClazz);
	
	public EffectiveProvidingEndpoint createEffectiveProvidingEndpointForClazz (Resource resource, Module module, Class<? extends IModuleEndpointProtocol> endpointProtocolClazz);

}
