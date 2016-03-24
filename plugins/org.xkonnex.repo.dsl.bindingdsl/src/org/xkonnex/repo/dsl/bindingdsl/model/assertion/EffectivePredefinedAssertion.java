package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.PredefinedAssertion;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Assertion;

public class EffectivePredefinedAssertion extends EffectiveAssertion implements
		PredefinedAssertion {

	private Assertion assertion;

	public EffectivePredefinedAssertion(EObject delegate) {
		super(delegate);
	}

	@Override
	public Assertion getAssertion() {
		return assertion;
	}

	@Override
	public void setAssertion(Assertion value) {
		this.assertion = value;
	}

}
