package org.xkonnex.repo.dsl.bindingdsl.model;

import java.util.List;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding;
import org.xkonnex.repo.dsl.bindingdsl.model.protocol.EffectiveBindingProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractOperation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

import com.google.inject.ImplementedBy;

@ImplementedBy(EffectiveBindingBuilder.class)
public interface IEffectiveBindingBuilder {

	public EffectiveBinding createEffectiveBinding (AbstractOperation operation, Binding binding);
	
	public EffectiveBinding createEffectiveBinding (Service service, Binding binding);

	public EffectiveBinding createEffectiveBinding (Resource service, Binding binding);

	public List<EffectiveBindingProtocol> createEffectiveBindingProtocol (List<AnyBinding> bindingsBottomUp);

	public EffectiveBinding createEffectiveBinding (AbstractOperation operation, Binding binding, EndpointQualifierRef endpointQualifier);
	
	public EffectiveBinding createEffectiveBinding (Service service, Binding binding, EndpointQualifierRef endpointQualifier);

	public EffectiveBinding createEffectiveBinding (Resource service, Binding binding, EndpointQualifierRef endpointQualifier);
}
