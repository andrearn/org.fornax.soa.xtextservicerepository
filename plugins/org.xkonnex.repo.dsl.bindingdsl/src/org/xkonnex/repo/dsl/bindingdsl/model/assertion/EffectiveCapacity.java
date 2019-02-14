package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.sladsl.sLADsl.BinarySize;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Capacity;
import org.xkonnex.repo.dsl.sladsl.sLADsl.TimeUnit;

public class EffectiveCapacity extends EffectiveAssertion implements
		Capacity {

	private int requestNum;
	private TimeUnit timeoutUnit;
	private BinarySize messageSize;

	public EffectiveCapacity(EObject delegate) {
		super(delegate);
	}

	@Override
	public int getRequestNum() {
		return requestNum;
	}

	@Override
	public void setRequestNum(int value) {
		this.requestNum = value;
	}

	@Override
	public TimeUnit getTimeUnit() {
		return timeoutUnit;
	}

	@Override
	public void setTimeUnit(TimeUnit value) {
		this.timeoutUnit = value;
	}

	@Override
	public BinarySize getMessageSize() {
		return messageSize;
	}

	@Override
	public void setMessageSize(BinarySize value) {
		this.messageSize = value;
	}

}
