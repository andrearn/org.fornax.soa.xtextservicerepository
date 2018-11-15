package org.xkonnex.repo.generator.bindingdsl.templates;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile;
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace;

/** 
 * An IProtocolContractBuilder builds all interface contract artifacts that can be used to build an interface stub 
 * for a certain technology like SOAP.
 */
public abstract interface IProtocolContractBuilder {
	
	/**
	 * Build technical service contracts for all services provided by the module referenced in the binding. 
	 * 
	 * @param bind the ModuleBinding to generate for
	 * @param enforcedProfile the architecture profile to use
	 */
	public void buildServiceContracts (ModuleBinding bind, Profile enforcedProfile);
	
	/**
	 * Build technical service contracts for all services provided by this module. A binding of this module (or to
	 * a compatible module version) to the given target environment will be used.
	 * 
	 * @param module the Module to generate for
	 * @param targetEnvironment the environment
	 * @param selectTypeVersionsByEnvironment whether version shall be selected based on the required LifecycleState for the environment
	 * @param providerEndpointQualifierRef the service endpoint qualifier (selects specific endpoints)
	 * @param enforcedProfile the architecture profile to use
	 */
	public void buildProvidedServiceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef providerEndpointQualifierRef, Profile enforcedProfile);
	
	/**
	 * Build technical service contracts for all services used by this module as stated by implicit or explicit reference
	 * in the "uses" clause of this modules definition. Generation is done for all of these services, that are bound 
	 * to the given environment.
	 * The bindings of the modules used by explicit or implicit reference from this module are used as bindings.
	 * 
	 * @param module the Module to generate for
	 * @param targetEnvironment the environment
	 * @param selectTypeVersionsByEnvironment whether version shall be selected based on the required LifecycleState for the environment
	 * @param endpointQualifierRef the service endpoint qualifier (selects specific endpoints)
	 * @param enforcedProfile the architecture profile to use
	 */
	public void buildUsedServiceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef endpointQualifierRef, Profile enforcedProfile);

	/**
	 * Build technical service contracts for all services provided by the module referenced in the binding. 
	 * 
	 * @param bind the ModuleBinding to generate for
	 * @param enforcedProfile the architecture profile to use
	 */
	public void buildResourceContracts (ModuleBinding bind, Profile enforcedProfile);
	
	/**
	 * Build technical service contracts for all services provided by this module. A binding of this module (or to
	 * a compatible module version) to the given target environment will be used.
	 * 
	 * @param module the Module to generate for
	 * @param targetEnvironment the environment
	 * @param selectTypeVersionsByEnvironment whether version shall be selected based on the required LifecycleState for the environment
	 * @param providerEndpointQualifierRef the service endpoint qualifier (selects specific endpoints)
	 * @param enforcedProfile the architecture profile to use
	 */
	public void buildProvidedResourceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef providerEndpointQualifierRef, Profile enforcedProfile);
	
	/**
	 * Build technical service contracts for all services used by this module as stated by implicit or explicit reference
	 * in the "uses" clause of this modules definition. Generation is done for all of these services, that are bound 
	 * to the given environment.
	 * The bindings of the modules used by explicit or implicit reference from this module are used as bindings.
	 * 
	 * @param module the Module to generate for
	 * @param targetEnvironment the environment
	 * @param selectTypeVersionsByEnvironment whether version shall be selected based on the required LifecycleState for the environment
	 * @param endpointQualifierRef the service endpoint qualifier (selects specific endpoints)
	 * @param enforcedProfile the architecture profile to use
	 */
	public void buildUsedResourceContracts (Module module, Environment targetEnvironment, boolean selectTypeVersionsByEnvironment, EndpointQualifierRef endpointQualifierRef, Profile enforcedProfile);
	
	/**
	 * Build technical type definitions for all types defined in the given namespace. The latest minor versions 
	 * of the types with lifecycle state supported in the given target environment are being selected
	 * 
	 * @param namespace the namespace to build for
	 * @param env runtime environment
	 * @param enforcedProfile architecture profile to use
	 */
	public void buildTypeDefinitions (SubNamespace namespace, Environment env, Profile enforcedProfile);

	/**
	 * Build technical type definitions for all types defined in the given namespace of a major version number slice of the namespace. 
	 * The latest minor versions of the types with lifecycle state supported in the given target environment 
	 * are being selected.
	 * 
	 * @param namespace the versioned  namespace to build for
	 * @param env runtime environment
	 * @param enforcedProfile architecture profile to use
	 */
	public void buildTypeDefinitions (VersionedDomainNamespace namespace, Environment env, Profile enforcedProfile);

}
