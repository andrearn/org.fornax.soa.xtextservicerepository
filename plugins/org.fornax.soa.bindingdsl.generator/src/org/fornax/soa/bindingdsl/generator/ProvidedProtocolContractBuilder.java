package org.fornax.soa.bindingdsl.generator;

import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingdsl.generator.templates.IProtocolContractBuilder;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.serviceDsl.SubNamespace;

import com.google.inject.Provider;

public class ProvidedProtocolContractBuilder implements IProtocolContractBuilder {
	
	private final Provider<? extends IProtocolContractBuilder> provider;
	
	public ProvidedProtocolContractBuilder(Provider<? extends IProtocolContractBuilder> provider) {
		this.provider = provider;
	}

	public void buildServiceContracts (ModuleBinding bind, SOAProfile profile) {
		provider.get().buildServiceContracts (bind, profile);
	}

	public void buildProvidedServiceContracts (Module module, Environment targetEnvironment, EndpointQualifierRef providerEndpointQualifier, SOAProfile profile) {
		provider.get().buildProvidedServiceContracts (module, targetEnvironment, providerEndpointQualifier, profile);
	}
	
	public void buildUsedServiceContracts (Module module, Environment targetEnvironment, EndpointQualifierRef endpointQualifier, SOAProfile profile) {
		provider.get().buildUsedServiceContracts (module, targetEnvironment, endpointQualifier, profile);
	}

	public void buildTypeDefinitions (SubNamespace namespace, Environment env,
			SOAProfile profile) {
		provider.get ().buildTypeDefinitions (namespace, env, profile);
	}

	public void buildTypeDefinitions (VersionedDomainNamespace namespace,
			Environment env, SOAProfile profile) {
		provider.get ().buildTypeDefinitions (namespace, env, profile);
	}

}
