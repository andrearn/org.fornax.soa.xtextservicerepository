package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BytesEnum;
import org.xkonnex.repo.dsl.basedsl.baseDsl.TimeUnit;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Capacity;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Escalation;

public class EffectiveCapacity extends EffectiveAssertion implements
		Capacity {

	private int requestNum;
	private TimeUnit timeoutUnit;
	private int messageSize;
	private BytesEnum byteUnit;

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
	public int getMessageSize() {
		return messageSize;
	}

	@Override
	public void setMessageSize(int value) {
		this.messageSize = value;
	}

	@Override
	public BytesEnum getByteUnit() {
		return byteUnit;
	}

	@Override
	public void setByteUnit(BytesEnum value) {
		this.byteUnit = value;
	}

}
