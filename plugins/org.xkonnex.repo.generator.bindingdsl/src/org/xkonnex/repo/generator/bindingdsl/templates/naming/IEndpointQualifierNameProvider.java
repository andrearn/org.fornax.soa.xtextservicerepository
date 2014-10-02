package org.xkonnex.repo.generator.bindingdsl.templates.naming;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

public interface IEndpointQualifierNameProvider {

	public String getEndpointQualifierName (Binding bind, Service svc, BindingProtocol prot);
	
}
