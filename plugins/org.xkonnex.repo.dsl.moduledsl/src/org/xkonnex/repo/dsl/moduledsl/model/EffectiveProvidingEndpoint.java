package org.xkonnex.repo.dsl.moduledsl.model;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.model.DelegatingEObject;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpoint;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpointProtocol;

public class EffectiveProvidingEndpoint extends DelegatingEObject implements
		ProvidingEndpoint {

	private EndpointQualifierRef endpointQualifierRef;
	private ProvidingEndpointProtocol endpointProtocol;

	public EffectiveProvidingEndpoint(EObject delegate) {
		super(delegate);
	}

	@Override
	public EndpointQualifierRef getEndpointQualifierRef() {
		return endpointQualifierRef;
	}

	@Override
	public void setEndpointQualifierRef(EndpointQualifierRef value) {
		this.endpointQualifierRef = value;
	}

	@Override
	public ProvidingEndpointProtocol getEndpointProtocol() {
		return endpointProtocol;
	}

	@Override
	public void setEndpointProtocol(ProvidingEndpointProtocol value) {
		this.endpointProtocol = value;
	}

}
