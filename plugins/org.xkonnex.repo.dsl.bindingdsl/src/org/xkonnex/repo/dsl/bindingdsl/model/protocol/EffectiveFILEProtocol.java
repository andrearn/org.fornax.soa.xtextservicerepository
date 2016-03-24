package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.FILE;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ReadWrite;

public class EffectiveFILEProtocol extends EffectiveBindingProtocol implements FILE {

	private String url;
	private ReadWrite accessType;
	private String pollIntervall;

	public EffectiveFILEProtocol(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void setUrl(String value) {
		this.url = value;
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
