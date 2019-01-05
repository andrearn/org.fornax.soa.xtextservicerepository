package org.xkonnex.repo.dsl.bindingdsl.model.policy;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.model.DelegatingEObject;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Policy;

public class EffectivePolicy extends DelegatingEObject implements Policy {

	protected String name;

	public EffectivePolicy(EObject delegate) {
		super(delegate);
	}
	public EffectivePolicy(EObject delegate, String name) {
		super(delegate);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		this.name = value;
	}

}
