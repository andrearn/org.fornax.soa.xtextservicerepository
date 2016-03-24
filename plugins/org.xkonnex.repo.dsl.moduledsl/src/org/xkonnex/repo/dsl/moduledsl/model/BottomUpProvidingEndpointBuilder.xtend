package org.xkonnex.repo.dsl.moduledsl.model

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpoint
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service

class BottomUpProvidingEndpointBuilder implements IEffectiveProvidingEndpointBuilder {
	
	override createEffectiveProvidingEndpoint(Operation operation, ProvidingEndpoint endpoint) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override createEffectiveProvidingEndpoint(Service service, ProvidingEndpoint endpoint) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}