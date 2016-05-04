package org.xkonnex.repo.generator.bindingdsl.rest.raml

import org.xkonnex.repo.generator.bindingdsl.templates.IProtocolContractBuilder
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.generator.bindingdsl.rest.raml.templates.RAMLContractGenerator
import javax.inject.Inject

class DefaultRAMLContractBuilder implements IProtocolContractBuilder {
	
	@Inject RAMLContractGenerator generator
	
	override buildProvidedServiceContracts(Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef providerEndpointQualifierRef, Profile enforcedProfile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override buildServiceContracts(ModuleBinding bind, Profile enforcedProfile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override buildTypeDefinitions(SubNamespace namespace, Environment env, Profile enforcedProfile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override buildTypeDefinitions(VersionedDomainNamespace namespace, Environment env, Profile enforcedProfile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override buildUsedServiceContracts(Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef endpointQualifierRef, Profile enforcedProfile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}