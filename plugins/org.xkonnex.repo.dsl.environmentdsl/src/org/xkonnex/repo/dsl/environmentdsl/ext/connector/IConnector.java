package org.xkonnex.repo.dsl.environmentdsl.ext.connector;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleConnector;

public interface IConnector {
	
	public String getEndpointUrl(ExtensibleConnector connectorDefinition);
	
	public String getSecuredEndpointUrl(ExtensibleConnector connectorDefinition);

}
