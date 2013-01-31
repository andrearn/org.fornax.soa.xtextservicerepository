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
import java.util.logging.Logger
import java.util.logging.Level

class BindingServiceContractBuilder {

	@Inject
	Set<ProvidedProtocolContractBuilder> protocolContractBuilders	
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject @Named ("forceRelativePaths") 		
	Boolean forceRelativePaths
	
	@Inject Logger log

	
	def dispatch void build (ModuleBinding binding, SOAProfile profile) {
		for (protContractBuilder : protocolContractBuilders) {
			try {
				protContractBuilder.buildServiceContracts (binding, profile);
			} catch (Exception ex) {
				log.log (Level::SEVERE, "Error generating contracts\n", ex)
			}
		}
	}
	
	def void build (Module module, Environment targetEnvironment, SOAProfile profile) {
		for (protContractBuilder : protocolContractBuilders) {
			try {
				protContractBuilder.buildUsedServiceContracts (module, targetEnvironment, profile);
			} catch (Exception ex) {
				log.log (Level::SEVERE, "Error generating contracts\n", ex)
			}
		}
	}
	
	def dispatch void build (DomainBinding binding, SOAProfile profile) {
		for (protContractBuilder : protocolContractBuilders) {
			try {
				protContractBuilder.buildServiceContracts (binding, profile);
			} catch (Exception ex) {
				log.log (Level::SEVERE, "Error generating contracts\n", ex)
			}
		}
	}
	
}