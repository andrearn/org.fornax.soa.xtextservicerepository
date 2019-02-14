package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Accuracy;
import org.xkonnex.repo.dsl.sladsl.sLADsl.TimeUnit;

public class EffectiveAccuracy extends EffectiveAssertion implements Accuracy {

	private int maxErrorRate;
	private TimeUnit maxErrorRateTimeUnit;

	public EffectiveAccuracy(EObject delegate) {
		super(delegate);
	}

	@Override
	public int getMaxErrorRate() {
		return maxErrorRate;
	}

	@Override
	public void setMaxErrorRate(int value) {
		this.maxErrorRate = value;
	}

	@Override
	public TimeUnit getMaxErrorRateTimeUnit() {
		return maxErrorRateTimeUnit;
	}

	@Override
	public void setMaxErrorRateTimeUnit(TimeUnit value) {
		this.maxErrorRateTimeUnit = value;
	}

}
