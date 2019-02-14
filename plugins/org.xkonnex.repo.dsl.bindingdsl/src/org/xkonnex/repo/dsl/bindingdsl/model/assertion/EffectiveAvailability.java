package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Percent;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Availability;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Duration;

public class EffectiveAvailability extends EffectiveAssertion
		implements Availability {

	private Percent percentage;
	private Duration mtbf;
	private Duration mttr;
	private Percent mttrPercentile;
	private String regularDownTimes;

	public EffectiveAvailability(EObject delegate) {
		super(delegate);
	}

	@Override
	public Percent getPercentage() {
		return percentage;
	}

	@Override
	public void setPercentage(Percent value) {
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
	public Percent getMttrPercentile() {
		return mttrPercentile;
	}

	@Override
	public void setMttrPercentile(Percent value) {
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
