package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.model.DelegatingEObject;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Escalation;
import org.xkonnex.repo.dsl.sladsl.sLADsl.ServiceQualityKPI;

public class EffectiveAssertion extends DelegatingEObject implements ServiceQualityKPI {

	protected String name;
	protected Escalation escalation;
	protected String penalty;

	public EffectiveAssertion(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
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
