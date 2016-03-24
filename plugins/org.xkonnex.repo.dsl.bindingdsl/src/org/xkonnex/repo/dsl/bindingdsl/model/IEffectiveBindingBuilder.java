package org.xkonnex.repo.dsl.bindingdsl.model;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

import com.google.inject.ImplementedBy;

@ImplementedBy(EffectiveBindingBuilder.class)
public interface IEffectiveBindingBuilder {

	public EffectiveBinding createEffectiveBinding (Operation operation, Binding binding);
	
	public EffectiveBinding createEffectiveBinding (Service service, Binding binding);
	
}
