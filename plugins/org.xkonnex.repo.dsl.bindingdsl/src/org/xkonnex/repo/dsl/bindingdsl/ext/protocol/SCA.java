package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.RMI;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;

public class SCA implements IProtocol {

	private String promote;
	private String reference;
	private boolean isMultipleRef;

	@Override
	public boolean supportsModuleEndpointProtocol(
			EndpointProtocol endpointProtocol) {
		if (endpointProtocol instanceof org.xkonnex.repo.dsl.moduledsl.ext.protocol.SCA)
			return true;
		else
			return false;
	}

	@Override
	public boolean supportsModuleEndpointProtocol(
			Class<? extends IModuleEndpointProtocol> endpointProtocol) {
		return org.xkonnex.repo.dsl.moduledsl.ext.protocol.SCA.class.isAssignableFrom(endpointProtocol);
	}

	public String getPromote() {
		return promote;
	}

	public void setPromote(String promote) {
		this.promote = promote;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public boolean isMultipleRef() {
		return isMultipleRef;
	}

	public void setMultipleRef(boolean isMultipleRef) {
		this.isMultipleRef = isMultipleRef;
	}

	@Override
	public boolean supportedOnConnector(Connector connector) {
		return connector instanceof org.xkonnex.repo.dsl.environmentdsl.environmentDsl.IIOP || connector instanceof RMI || connector instanceof EJB;
	}

	@Override
	public boolean supportedOnConnector(IConnector connector) {
		return false;
	}

}
