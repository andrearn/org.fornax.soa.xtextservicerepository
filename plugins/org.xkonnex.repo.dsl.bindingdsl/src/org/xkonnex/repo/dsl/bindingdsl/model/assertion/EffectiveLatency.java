package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.TimeSpan;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Escalation;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Latency;

public class EffectiveLatency extends EffectiveAssertion implements
		Latency {

	private TimeSpan latency;
	private double percentile;
	private Escalation escalation;
	private String penalty;

	public EffectiveLatency(EObject delegate) {
		super(delegate);
	}

	@Override
	public TimeSpan getLatency() {
		return latency;
	}

	@Override
	public void setLatency(TimeSpan value) {
		this.latency = value;
	}

	@Override
	public double getPercentile() {
		return percentile;
	}

	@Override
	public void setPercentile(double value) {
		this.percentile = value;
	}

	@Override
	public Escalation getEscalation() {
		return escalation;
	}

	@Override
	public void setEscalation(Escalation value) {
		this.escalation = value;
	}

	@Override
	public String getPenalty() {
		return penalty;
	}

	@Override
	public void setPenalty(String value) {
		this.penalty = value;
	}

}
