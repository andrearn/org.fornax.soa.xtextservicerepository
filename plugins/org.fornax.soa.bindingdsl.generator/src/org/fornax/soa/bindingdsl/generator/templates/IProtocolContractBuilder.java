package org.fornax.soa.bindingdsl.generator.templates;

import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.serviceDsl.SubNamespace;

/** 
 * An IProtocolContractBuilder builds all interface contract artifacts that can be used to build an interface stub 
 * for a certain technology like SOAP.
 */
public abstract interface IProtocolContractBuilder {
	
	/**
	 * Build technical service contracts for all services provided by the module referenced in the binding. 
	 */
	public void buildServiceContracts (ModuleBinding bind, SOAProfile profile);
	
	/**
	 * Build technical service contracts for all services provided by this module. A binding of this module (or to
	 * a compatible module version) to the given target environment will be used.
	 */
	public void buildProvidedServiceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef providerEndpointQualifierRef, SOAProfile profile);
	
	
	/**
	 * Build technical service contracts for all services used by this module as stated by implicit or explicit reference
	 * in the "uses" clause of this modules definition. Generation is done for all of these services, that are bound 
	 * to the given environment.
	 * The bindings of the modules used by explicit or implicit reference from this module are used as bindings.
	 */
	public void buildUsedServiceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef endpointQualifierRef, SOAProfile profile);
	
	/**
	 * Build technical type definitions for all types defined in the given namespace. The latest minor versions 
	 * of the types with lifecycle state supported in the given target environment are being selected
	 * 
	 * @param namespace
	 * @param env
	 * @param profile
	 */
	public void buildTypeDefinitions (SubNamespace namespace, Environment env, SOAProfile profile);

	/**
	 * Build technical type definitions for all types defined in the given namespace of a major version number slice of the namespace. 
	 * The latest minor versions of the types with lifecycle state supported in the given target environment 
	 * are being selected.
	 * 
	 * @param namespace
	 * @param env
	 * @param profile
	 */
	public void buildTypeDefinitions (VersionedDomainNamespace namespace, Environment env, SOAProfile profile);

}
