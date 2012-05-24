package org.fornax.soa.bindingdsl.generator.templates;

import org.fornax.soa.bindingDsl.DomainBinding;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.serviceDsl.SubNamespace;

/* 
 * An IProtocolContractBuilder builds all interface contract artifacts that can be used to build an interface stub 
 * for a certain technology like SOAP.
 */
public abstract interface IProtocolContractBuilder {
	
	public void buildServiceContracts (ModuleBinding bind, SOAProfile profile);
	
	public void buildServiceContracts (DomainBinding bind, SOAProfile profile);
	
	public void buildUsedServiceContracts (Module module, Environment targetEnvironment, SOAProfile profile);
	
	
	public void buildTypeDefinitions (SubNamespace namespace, Environment env, SOAProfile profile);

	public void buildTypeDefinitions (VersionedDomainNamespace namespace, Environment env, SOAProfile profile);

}
