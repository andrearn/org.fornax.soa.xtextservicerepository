package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.CostAssertion;

public class EffectiveCostAssertion extends EffectiveAssertion implements
		CostAssertion {

	private String costsAmount;
	private String billedUnit;

	public EffectiveCostAssertion(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getCostsAmount() {
		return costsAmount;
	}

	@Override
	public void setCostsAmount(String value) {
		this.costsAmount = value;
	}

	@Override
	public String getBilledUnit() {
		return billedUnit;
	}

	@Override
	public void setBilledUnit(String value) {
		this.billedUnit = value;
	}

}
