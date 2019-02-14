package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.model.DelegatingEObject;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Costs;
import org.xkonnex.repo.dsl.sladsl.sLADsl.Escalation;

public class EffectiveCost extends  DelegatingEObject  implements
		Costs {

	private String name;
	private String costsAmount;
	private String billedUnit;
	private String effortAccounting;
	private Escalation escalation;
	private String serviceItem;
	private String penalty;

	public EffectiveCost(EObject delegate) {
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
	public String getCostsAmount() {
		return costsAmount;
	}

	@Override
	public void setCostsAmount(String value) {
		this.costsAmount = value;
	}

	@Override
	public String getBilledUnit() {
		return billedUnit;
	}

	@Override
	public void setBilledUnit(String value) {
		this.billedUnit = value;
	}

	@Override
	public String getEffortAccounting() {
		return effortAccounting;
	}

	@Override
	public void setEffortAccounting(String value) {
		this.effortAccounting = value;
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

	@Override
	public String getServiceItem() {
		return serviceItem;
	}

	@Override
	public void setServiceItem(String value) {
		this.serviceItem = value;
	}

}
