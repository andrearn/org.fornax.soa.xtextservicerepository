package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SAP;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SAPTransport;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SapClient;

public class EffectiveSAPProtocol extends EffectiveBindingProtocol implements
		SAP {

	private SAPTransport transport;
	private SapClient client;

	public EffectiveSAPProtocol(EObject delegate) {
		super(delegate);
	}

	@Override
	public SAPTransport getTransport() {
		return transport;
	}

	@Override
	public void setTransport(SAPTransport value) {
		this.transport = value;
	}

	@Override
	public SapClient getClient() {
		return client;
	}

	@Override
	public void setClient(SapClient value) {
		this.client = value;
	}

}
