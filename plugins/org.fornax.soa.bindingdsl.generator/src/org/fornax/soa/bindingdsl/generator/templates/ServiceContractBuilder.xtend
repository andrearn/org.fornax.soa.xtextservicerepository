package org.fornax.soa.bindingdsl.generator.templates

import com.google.inject.Inject
import java.util.Set
import java.util.logging.Level
import java.util.logging.Logger
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingdsl.generator.ProvidedProtocolContractBuilder
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile

/**
 * A builder that builds service contracts. The builder delegates to a chain of {@link IProtocolContractBuilder}s
 * to build service contracts for each protocol defined in the binding
 */
class ServiceContractBuilder {

	@Inject
	Set<ProvidedProtocolContractBuilder> protocolContractBuilders	
	
	@Inject Logger log

	/**
	 * Build service contracts for the given binding, respecting the rules defined in the architecture profile. Service
	 * contracts are build for each service provided by the bound module. Endpoints will point to environment defined 
	 * in the binding model. <br/><br/>
	 * 
	 * @param binding The module binding to generate service contracts for 
	 * @param profile The architecture profile defining the architectural rules, generated service contracts must 
	 * be compliant to 
	 */
	def void build (ModuleBinding binding, SOAProfile profile) {
		for (protContractBuilder : protocolContractBuilders) {
			try {
				protContractBuilder.buildServiceContracts (binding, profile);
			} catch (Exception ex) {
				log.log (Level::SEVERE, "Error generating contracts\n", ex)
			}
		}
	}
	
	/**
	 * Build service contracts for provided and/or used services by the module, respecting the rules defined 
	 * in the architecture profile. <br/>
	 * The build is based on binding definitions that bind the providing module to the given targetEnvironment. 
	 * Bindings are looked up for provided and used services. The most specific binding will be used for regarding 
	 * each provided or used service respectively. <br/><br/>
	 * 
	 * <b>Lookup of bindings for provided services:</b> <br/>
	 * Looks for a binding that binds the module (or a compatible newer version of it) to the given target environment.
	 * 
	 * <br/><br/>
	 * <b>Lookup of bindings for used services:</b> <br/>
	 * Looks for a binding that binds the used module, either defined as direct reference of via a service reference with 
	 * providing module in the module definition, to the given target environment.
	 * If no binding for resolved providing module can be found, the binding of a a compatible newer version of it will be 
	 * used.
	 * 
	 * @param module The module, for which to build service contracts for provided and/or used services
	 * @param targetEnvironment The environment to build service contracts for.
	 * @param generateProvidedServices If true, contracts for services provided by the module will be generated
	 * @param generateUsedServices If true, contracts for services provided by the module will be generated
	 * @param endpointQualifierRef Only generate for looked up bindings that are tagged with this endpoint qualifier
	 * @param profile The architecture profile defining the architectural rules, generated service contracts must be compliant to 
	 */
	def void build (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, boolean generateProvidedServices, boolean generateUsedServices, EndpointQualifierRef endpointQualifierRef, SOAProfile enforcedProfile) {
		for (protContractBuilder : protocolContractBuilders) {
			try {
				if (generateProvidedServices)
					protContractBuilder.buildProvidedServiceContracts (module, targetEnvironment, selectTypeVersionsByEnvironment, endpointQualifierRef, enforcedProfile);
				if (generateUsedServices)
					protContractBuilder.buildUsedServiceContracts (module, targetEnvironment, selectTypeVersionsByEnvironment, endpointQualifierRef, enforcedProfile);
			} catch (Exception ex) {
				log.log (Level::SEVERE, "Error generating contracts\n", ex)
			}
		}
	}
		
}