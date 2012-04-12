package org.fornax.soa.bindingdsl.generator.templates;

import org.fornax.soa.bindingDsl.DomainBinding;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.servicedsl.VersionedDomainNamespace;

/* 
 * An IProtocolContractBuilder builds all interface contract artifacts that can be used to build interface stub 
 * for a certain technology like SOAP.
 */
public abstract interface IProtocolContractBuilder {
	
	public void buildServiceContracts (ModuleBinding bind, SOAProfile profile);
	
	public void buildServiceContracts (DomainBinding bind, SOAProfile profile);
	
	
	public void buildTypeDefinitions (SubNamespace namespace, Environment env, SOAProfile profile);

	public void buildTypeDefinitions (VersionedDomainNamespace namespace, Environment env, SOAProfile profile);

}
