package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ReliabilityAssertion;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ReliabilityKind;
import org.xkonnex.repo.dsl.sladsl.sLADsl.ReliablilityKind;

public class EffectiveReliabilityAssertion extends EffectiveAssertion implements
		ReliabilityAssertion {

	private ReliabilityKind reliability;
	private boolean inOrderDelivery;

	public EffectiveReliabilityAssertion(EObject delegate) {
		super(delegate);
	}

	@Override
	public ReliabilityKind getReliability() {
		return reliability;
	}

	@Override
	public void setReliability(ReliabilityKind value) {
		this.reliability = value;
	}

	@Override
	public boolean isInOrderDelivery() {
		return inOrderDelivery;
	}

	@Override
	public void setInOrderDelivery(boolean value) {
		this.inOrderDelivery = value;
	}

}
