package org.xkonnex.repo.dsl.moduledsl.model;

import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpoint;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

import com.google.inject.ImplementedBy;

@ImplementedBy(BottomUpProvidingEndpointBuilder.class)
public interface IEffectiveProvidingEndpointBuilder {

	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (Operation operation, ProvidingEndpoint specificEndpoint);
	
	public EffectiveProvidingEndpoint createEffectiveProvidingEndpoint (Service service, ProvidingEndpoint specificEndpoint);

}
