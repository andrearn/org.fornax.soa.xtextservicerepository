package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.JMS;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.TopicOrQueue;

public class EffectiveJMSProtocol extends EffectiveBindingProtocol implements JMS {

	private TopicOrQueue channel;
	private String jndiName;
	private String providerJndi;

	public EffectiveJMSProtocol(EObject delegate) {
		super(delegate);
	}

	@Override
	public TopicOrQueue getChannel() {
		return channel;
	}

	@Override
	public void setChannel(TopicOrQueue value) {
		this.channel = value;
	}

	@Override
	public String getJndiName() {
		return jndiName;
	}

	@Override
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	@Override
	public String getProviderJndi() {
		return providerJndi;
	}

	@Override
	public void setProviderJndi(String value) {
		this.providerJndi = value;
	}

}
