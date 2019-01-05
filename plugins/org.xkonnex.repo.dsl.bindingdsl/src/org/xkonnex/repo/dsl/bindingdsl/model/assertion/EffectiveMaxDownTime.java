package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.TimeSpan;
import org.xkonnex.repo.dsl.sladsl.sLADsl.MaxDownTime;

public class EffectiveMaxDownTime extends EffectiveAssertion implements MaxDownTime {

	private TimeSpan duration;

	public EffectiveMaxDownTime(EObject delegate) {
		super(delegate);
	}

	@Override
	public TimeSpan getDuration() {
		return duration;
	}

	@Override
	public void setDuration(TimeSpan value) {
		this.duration = value;
	}

}
