package org.xkonnex.repo.generator.environmentdsl;

import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslRuntimeModule;

public class EnvironmentDslGeneratorModule extends EnvironmentDslRuntimeModule {

	public Class<? extends EndpointResolver> bindEndpointResolver () {
		return EndpointResolver.class;
	}
}
