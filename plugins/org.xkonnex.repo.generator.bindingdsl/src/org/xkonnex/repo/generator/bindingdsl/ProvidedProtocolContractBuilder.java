package org.xkonnex.repo.generator.bindingdsl;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile;
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace;
import org.xkonnex.repo.generator.bindingdsl.templates.IProtocolContractBuilder;

import com.google.inject.Provider;

public class ProvidedProtocolContractBuilder implements IProtocolContractBuilder {
	
	private final Provider<? extends IProtocolContractBuilder> provider;
	
	public ProvidedProtocolContractBuilder(Provider<? extends IProtocolContractBuilder> provider) {
		this.provider = provider;
	}

	public void buildServiceContracts (ModuleBinding bind, SOAProfile profile) {
		provider.get().buildServiceContracts (bind, profile);
	}

	public void buildProvidedServiceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef providerEndpointQualifier, SOAProfile enforcedProfile) {
		provider.get().buildProvidedServiceContracts (module, targetEnvironment, selectTypeVersionsByEnvironment, providerEndpointQualifier, enforcedProfile);
	}
	
	public void buildUsedServiceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef endpointQualifier, SOAProfile enforcedProfile) {
		provider.get().buildUsedServiceContracts (module, targetEnvironment, selectTypeVersionsByEnvironment, endpointQualifier, enforcedProfile);
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