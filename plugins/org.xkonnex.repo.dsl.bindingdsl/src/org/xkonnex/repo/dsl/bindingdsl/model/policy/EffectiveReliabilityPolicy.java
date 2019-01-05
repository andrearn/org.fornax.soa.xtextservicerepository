package org.xkonnex.repo.dsl.bindingdsl.model.policy;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.sladsl.sLADsl.ReliabilityPolicy;
import org.xkonnex.repo.dsl.sladsl.sLADsl.ReliabilityKind;;

public class EffectiveReliabilityPolicy extends EffectivePolicy implements
		ReliabilityPolicy {

	private ReliabilityKind reliability;
	private boolean inOrderDelivery;

	public EffectiveReliabilityPolicy(EObject delegate) {
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
