package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;

public interface IProtocol {
	
	public boolean supportsModuleEndpointProtocol (EndpointProtocol endpointProtocol);
	public boolean supportsModuleEndpointProtocol (Class<? extends IModuleEndpointProtocol> endpointProtocol);
	
	public boolean supportedOnConnector (Connector connector);
	public boolean supportedOnConnector (IConnector connector);

}
