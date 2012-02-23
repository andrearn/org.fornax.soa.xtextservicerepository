package org.fornax.soa.environmentdsl.generator;

import org.fornax.soa.EnvironmentDslRuntimeModule;

public class EnvironmentDslGeneratorModule extends EnvironmentDslRuntimeModule {

	public Class<? extends EndpointResolver> bindEndpointResolver () {
		return EndpointResolver.class;
	}
}
