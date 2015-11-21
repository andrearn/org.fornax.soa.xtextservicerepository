package org.xkonnex.repo.generator.bindingdsl.templates;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.AbstractProfile;
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace;

/** 
 * An IProtocolContractBuilder builds all interface contract artifacts that can be used to build an interface stub 
 * for a certain technology like SOAP.
 */
public abstract interface IProtocolContractBuilder {
	
	/**
	 * Build technical service contracts for all services provided by the module referenced in the binding. 
	 */
	public void buildServiceContracts (ModuleBinding bind, AbstractProfile enforcedProfile);
	
	/**
	 * Build technical service contracts for all services provided by this module. A binding of this module (or to
	 * a compatible module version) to the given target environment will be used.
	 */
	public void buildProvidedServiceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef providerEndpointQualifierRef, AbstractProfile enforcedProfile);
	
	
	/**
	 * Build technical service contracts for all services used by this module as stated by implicit or explicit reference
	 * in the "uses" clause of this modules definition. Generation is done for all of these services, that are bound 
	 * to the given environment.
	 * The bindings of the modules used by explicit or implicit reference from this module are used as bindings.
	 */
	public void buildUsedServiceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef endpointQualifierRef, AbstractProfile enforcedProfile);
	
	/**
	 * Build technical type definitions for all types defined in the given namespace. The latest minor versions 
	 * of the types with lifecycle state supported in the given target environment are being selected
	 * 
	 * @param namespace
	 * @param env
	 * @param enforcedProfile
	 */
	public void buildTypeDefinitions (SubNamespace namespace, Environment env, AbstractProfile enforcedProfile);

	/**
	 * Build technical type definitions for all types defined in the given namespace of a major version number slice of the namespace. 
	 * The latest minor versions of the types with lifecycle state supported in the given target environment 
	 * are being selected.
	 * 
	 * @param namespace
	 * @param env
	 * @param enforcedProfile
	 */
	public void buildTypeDefinitions (VersionedDomainNamespace namespace, Environment env, AbstractProfile enforcedProfile);

}
