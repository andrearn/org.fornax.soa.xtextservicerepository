package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Percentile;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.LatencyAssertion;

public class EffectiveLatencyAssertion extends EffectiveAssertion implements
		LatencyAssertion {

	private String latency;
	private Percentile percentile;

	public EffectiveLatencyAssertion(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getLatency() {
		return latency;
	}

	@Override
	public void setLatency(String value) {
		this.latency = value;
	}

	@Override
	public Percentile getPercentile() {
		return percentile;
	}

	@Override
	public void setPercentile(Percentile value) {
		this.percentile = value;
	}

}
