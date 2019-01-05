package org.xkonnex.repo.dsl.bindingdsl.model.policy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.sladsl.sLADsl.LogPolicy;
import org.xkonnex.repo.dsl.sladsl.sLADsl.MessagePartRef;
import org.xkonnex.repo.dsl.sladsl.sLADsl.SLADslPackage;

public class EffectiveLogPolicy extends EffectivePolicy implements LogPolicy {
	
	public EffectiveLogPolicy(EObject delegate) {
		super(delegate, "");
	}

	@SuppressWarnings("unchecked")
	@Override
	public EList<MessagePartRef> getLoggedMessageParts() {
		return (EList<MessagePartRef>) delegate.eGet(SLADslPackage.Literals.LOG_POLICY__LOGGED_MESSAGE_PARTS);
	}

	@Override
	public String getAdditionalLoggingRequirement() {
		return (String) delegate.eGet(SLADslPackage.Literals.LOG_POLICY__ADDITIONAL_LOGGING_REQUIREMENT);
	}

	@Override
	public void setAdditionalLoggingRequirement(String value) {
		delegate.eSet(SLADslPackage.Literals.LOG_POLICY__ADDITIONAL_LOGGING_REQUIREMENT, value);
	}

}
