package org.xkonnex.repo.generator.bindingdsl.templates.naming;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

public interface IEndpointQualifierNameProvider {

	public String getEndpointQualifierName (AnyBinding bind, Service svc, BindingProtocol prot);
	
}
