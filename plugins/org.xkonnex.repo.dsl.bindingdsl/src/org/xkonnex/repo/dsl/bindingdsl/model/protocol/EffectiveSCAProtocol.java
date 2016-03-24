package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SCA;

public class EffectiveSCAProtocol extends EffectiveBindingProtocol implements SCA {

	private String promote;
	private String reference;
	private boolean isMultipleRef;

	public EffectiveSCAProtocol(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getPromote() {
		return promote;
	}

	@Override
	public void setPromote(String value) {
		this.promote = value;
	}

	@Override
	public String getReference() {
		return reference;
	}

	@Override
	public void setReference(String value) {
		this.reference = value;
	}

	@Override
	public boolean isIsMultipleRef() {
		return isMultipleRef;
	}

	@Override
	public void setIsMultipleRef(boolean value) {
		this.isMultipleRef = value;
	}

}
