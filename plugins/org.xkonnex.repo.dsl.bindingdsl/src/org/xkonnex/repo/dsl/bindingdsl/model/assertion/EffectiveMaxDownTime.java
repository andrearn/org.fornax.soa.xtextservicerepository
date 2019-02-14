package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Duration;
import org.xkonnex.repo.dsl.sladsl.sLADsl.MaxDownTime;

public class EffectiveMaxDownTime extends EffectiveAssertion implements MaxDownTime {

	private Duration duration;

	public EffectiveMaxDownTime(EObject delegate) {
		super(delegate);
	}

	@Override
	public Duration getDuration() {
		return duration;
	}

	@Override
	public void setDuration(Duration value) {
		this.duration = value;
	}

}
