package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AccuracyAssertion;

public class EffectiveAccuracyAssertion extends EffectiveAssertion implements AccuracyAssertion {

	private String maxErrorRate;

	public EffectiveAccuracyAssertion(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getMaxErrorRate() {
		return maxErrorRate;
	}

	@Override
	public void setMaxErrorRate(String value) {
		this.maxErrorRate = value;
	}

}
