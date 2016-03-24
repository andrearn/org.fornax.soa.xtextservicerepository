package org.xkonnex.repo.dsl.moduledsl.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment;
import org.xkonnex.repo.dsl.basedsl.model.DelegatingEObject;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpointProtocol;

public class EffectiveProvidingEndpointProtocol extends DelegatingEObject implements ProvidingEndpointProtocol {

	private String name;
	private JvmType type;
	private EList<Assignment> assignment;
	private IModuleEndpointProtocol endpointProtocol;

	public EffectiveProvidingEndpointProtocol(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public JvmType getType() {
		return type;
	}

	@Override
	public void setType(JvmType value) {
		this.type = value;
	}

	@Override
	public EList<Assignment> getAssignment() {
		return assignment;
	}

	public IModuleEndpointProtocol getEndpointProtocol() {
		return endpointProtocol;
	}

	public void setEndpointProtocol(IModuleEndpointProtocol endpointProtocol) {
		this.endpointProtocol = endpointProtocol;
	}

}
