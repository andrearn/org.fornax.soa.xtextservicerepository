package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;

public class FTAM implements IProtocol {
	
	private String folder;

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	@Override
	public boolean supportsModuleEndpointProtocol(
			EndpointProtocol importBindingProtocol) {
		if (importBindingProtocol instanceof org.xkonnex.repo.dsl.moduledsl.ext.protocol.FTAM)
			return true;
		else
			return false;
	}

	@Override
	public boolean supportsModuleEndpointProtocol(
			Class<? extends IModuleEndpointProtocol> endpointProtocol) {
		return org.xkonnex.repo.dsl.moduledsl.ext.protocol.FTAM.class.isAssignableFrom(endpointProtocol);
	}

	@Override
	public boolean supportedOnConnector(Connector connector) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportedOnConnector(IConnector connector) {
		// TODO Auto-generated method stub
		return false;
	}

}
