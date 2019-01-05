package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Duration;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Availability;

public class EffectiveAvailability extends EffectiveAssertion
		implements Availability {

	private double percentage;
	private Duration mtbf;
	private Duration mttr;
	private double mttrPercentile;
	private String regularDownTimes;

	public EffectiveAvailability(EObject delegate) {
		super(delegate);
	}

	@Override
	public double getPercentage() {
		return percentage;
	}

	@Override
	public void setPercentage(double value) {
		this.percentage = value;
	}

	@Override
	public Duration getMtbf() {
		return mtbf;
	}

	@Override
	public void setMtbf(Duration value) {
		this.mtbf = value;
	}

	@Override
	public Duration getMttr() {
		return mttr;
	}

	@Override
	public void setMttr(Duration value) {
		this.mttr = value;
	}

	@Override
	public double getMttrPercentile() {
		return mttrPercentile;
	}

	@Override
	public void setMttrPercentile(double value) {
		this.mttrPercentile = value;
	}

	@Override
	public String getRegularDownTimes() {
		return regularDownTimes;
	}

	@Override
	public void setRegularDownTimes(String value) {
		this.regularDownTimes = value;
	}

}
