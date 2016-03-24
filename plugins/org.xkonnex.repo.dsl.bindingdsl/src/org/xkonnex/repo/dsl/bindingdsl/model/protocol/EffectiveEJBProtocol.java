package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EJB;

public class EffectiveEJBProtocol extends EffectiveBindingProtocol implements EJB {

	private String jndiName;

	public EffectiveEJBProtocol(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getJndiName() {
		return jndiName;
	}

	@Override
	public void setJndiName(String value) {
		this.jndiName = value;
	}

}
