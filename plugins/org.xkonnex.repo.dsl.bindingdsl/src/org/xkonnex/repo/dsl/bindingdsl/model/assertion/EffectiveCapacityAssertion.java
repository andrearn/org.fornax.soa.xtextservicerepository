package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.CapacityAssertion;

public class EffectiveCapacityAssertion extends EffectiveAssertion implements
		CapacityAssertion {

	private String requestNum;
	private String timeoutUnit;
	private String messageSize;

	public EffectiveCapacityAssertion(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getRequestNum() {
		return requestNum;
	}

	@Override
	public void setRequestNum(String value) {
		this.requestNum = value;
	}

	@Override
	public String getTimeUnit() {
		return timeoutUnit;
	}

	@Override
	public void setTimeUnit(String value) {
		this.timeoutUnit = value;
	}

	@Override
	public String getMessageSize() {
		return messageSize;
	}

	@Override
	public void setMessageSize(String value) {
		this.messageSize = value;
	}

}
