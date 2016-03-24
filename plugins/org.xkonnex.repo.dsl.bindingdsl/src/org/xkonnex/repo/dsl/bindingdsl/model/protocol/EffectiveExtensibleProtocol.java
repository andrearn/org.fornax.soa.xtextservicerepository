package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol;
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IProtocol;

public class EffectiveExtensibleProtocol extends EffectiveBindingProtocol
		implements ExtensibleProtocol {
	
	private IProtocol protocol;

	public EffectiveExtensibleProtocol(EObject delegate) {
		super(delegate);
	}

	public IProtocol getProtocol() {
		return protocol;
	}

	public void setProtocol(IProtocol protocol) {
		this.protocol = protocol;
	}

}
