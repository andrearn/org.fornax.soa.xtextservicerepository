package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.IIOP;

public class EffectiveIIOPProtocol extends EffectiveBindingProtocol implements IIOP {

	private String lookupName;

	public EffectiveIIOPProtocol(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getLookupName() {
		return lookupName;
	}

	@Override
	public void setLookupName(String value) {
		this.lookupName = value;
	}

}
