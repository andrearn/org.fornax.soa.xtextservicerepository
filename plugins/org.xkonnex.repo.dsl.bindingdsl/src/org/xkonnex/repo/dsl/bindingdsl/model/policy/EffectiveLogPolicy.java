package org.xkonnex.repo.dsl.bindingdsl.model.policy;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.model.DelegatingEObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.LogPolicy;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.LogPolicyKind;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Policy;

public class EffectiveLogPolicy extends EffectivePolicy implements LogPolicy {
	
	private LogPolicyKind logPolicyKind;

	public EffectiveLogPolicy(EObject delegate) {
		super(delegate);
	}

	@Override
	public LogPolicyKind getLogPolicy() {
		return logPolicyKind;
	}

	@Override
	public void setLogPolicy(LogPolicyKind value) {
		this.logPolicyKind = value;
	}

}
