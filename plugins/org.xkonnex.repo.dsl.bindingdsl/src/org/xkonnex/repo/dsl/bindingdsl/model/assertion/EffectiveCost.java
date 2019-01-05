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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEffortAccounting(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Escalation getEscalation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEscalation(Escalation value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPenalty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPenalty(String value) {
		// TODO Auto-generated method stub
		
	}

}
