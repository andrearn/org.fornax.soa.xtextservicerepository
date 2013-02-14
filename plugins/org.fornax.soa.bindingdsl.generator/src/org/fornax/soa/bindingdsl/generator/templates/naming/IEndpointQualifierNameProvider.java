package org.fornax.soa.bindingdsl.generator.templates.naming;

import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.serviceDsl.Service;

public interface IEndpointQualifierNameProvider {

	public String getEndpointQualifierName (Binding bind, Service svc, BindingProtocol prot);
	
}
