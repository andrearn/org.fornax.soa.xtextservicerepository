package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.FTP;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ReadWrite;

public class EffectiveFTPProtocol extends EffectiveBindingProtocol implements FTP {

	private ReadWrite accessType;
	private String pollIntervall;

	public EffectiveFTPProtocol(EObject delegate) {
		super(delegate);
	}

	@Override
	public ReadWrite getAccessType() {
		return accessType;
	}

	@Override
	public void setAccessType(ReadWrite value) {
		this.accessType = value;
	}

	@Override
	public String getPollIntervall() {
		return pollIntervall;
	}

	@Override
	public void setPollIntervall(String value) {
		this.pollIntervall = value;
	}

}
