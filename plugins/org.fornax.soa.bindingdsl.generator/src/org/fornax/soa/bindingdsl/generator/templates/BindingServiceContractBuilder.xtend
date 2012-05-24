package org.fornax.soa.bindingdsl.generator.templates

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.Set
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.bindingdsl.generator.ProvidedProtocolContractBuilder
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.environmentDsl.Environment

class BindingServiceContractBuilder {

	@Inject
	Set<ProvidedProtocolContractBuilder> protocolContractBuilders	
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject @Named ("forceRelativePaths") 		
	Boolean forceRelativePaths

	
	def dispatch void build (ModuleBinding binding, SOAProfile profile) {
		for (protContractBuilder : protocolContractBuilders) {
			protContractBuilder.buildServiceContracts (binding, profile);
		}
	}
	
	def void build (Module module, Environment targetEnvironment, SOAProfile profile) {
		for (protContractBuilder : protocolContractBuilders) {
			protContractBuilder.buildUsedServiceContracts (module, targetEnvironment, profile);
		}
	}
	
	def dispatch void build (DomainBinding binding, SOAProfile profile) {
		for (protContractBuilder : protocolContractBuilders) {
			protContractBuilder.buildServiceContracts (binding, profile);
		}
	}
	
}