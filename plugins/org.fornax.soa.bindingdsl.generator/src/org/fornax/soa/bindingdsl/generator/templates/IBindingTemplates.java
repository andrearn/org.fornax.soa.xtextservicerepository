package org.fornax.soa.bindingdsl.generator.templates;

import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.serviceDsl.Service;

public interface IBindingTemplates {
	
	public void generateServiceContracts (Service svc, Binding bind, BindingProtocol prot, SOAProfile profile);

}
