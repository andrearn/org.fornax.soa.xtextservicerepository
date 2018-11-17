package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Percentile;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AvailabilityAssertion;

public class EffectiveAvailabilityAssertion extends EffectiveAssertion
		implements AvailabilityAssertion {

	private String availability;
	private String mtbf;
	private String mttr;
	private Percentile mttrPercentile;
	private String regularDownTimes;

	public EffectiveAvailabilityAssertion(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getAvailability() {
		return availability;
	}

	@Override
	public void setAvailability(String value) {
		this.availability = value;
	}

	@Override
	public String getMtbf() {
		return mtbf;
	}

	@Override
	public void setMtbf(String value) {
		this.mtbf = value;
	}

	@Override
	public String getMttr() {
		return mttr;
	}

	@Override
	public void setMttr(String value) {
		this.mttr = value;
	}

	@Override
	public Percentile getMttrPercentile() {
		return mttrPercentile;
	}

	@Override
	public void setMttrPercentile(Percentile value) {
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
