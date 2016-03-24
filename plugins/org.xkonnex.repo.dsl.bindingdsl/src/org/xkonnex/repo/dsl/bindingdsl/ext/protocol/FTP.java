package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ReadWrite;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;

public class FTP implements IProtocol {

	protected String url;
	protected ReadWrite accessType;
	protected String pollIntervall;

	@Override
	public boolean supportsModuleEndpointProtocol(
			EndpointProtocol endpointProtocol) {
		if (endpointProtocol instanceof org.xkonnex.repo.dsl.moduledsl.ext.protocol.FTP)
			return true;
		else
			return false;
	}

	@Override
	public boolean supportsModuleEndpointProtocol(
			Class<? extends IModuleEndpointProtocol> endpointProtocol) {
		return org.xkonnex.repo.dsl.moduledsl.ext.protocol.FTP.class.isAssignableFrom(endpointProtocol);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ReadWrite getAccessType() {
		return accessType;
	}

	public void setAccessType(ReadWrite accessType) {
		this.accessType = accessType;
	}

	public String getPollIntervall() {
		return pollIntervall;
	}

	public void setPollIntervall(String pollIntervall) {
		this.pollIntervall = pollIntervall;
	}

}
