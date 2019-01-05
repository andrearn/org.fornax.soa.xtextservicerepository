package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Duration;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Percent;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Escalation;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Latency;

public class EffectiveLatency extends EffectiveAssertion implements
		Latency {

	private Duration latency;
	private Percent percentile;
	private Escalation escalation;
	private String penalty;

	public EffectiveLatency(EObject delegate) {
		super(delegate);
	}

	@Override
	public Duration getLatency() {
		return latency;
	}

	@Override
	public void setLatency(Duration value) {
		this.latency = value;
	}

	@Override
	public Percent getPercentile() {
		return percentile;
	}

	@Override
	public void setPercentile(Percent value) {
		this.percentile = value;
	}

}
