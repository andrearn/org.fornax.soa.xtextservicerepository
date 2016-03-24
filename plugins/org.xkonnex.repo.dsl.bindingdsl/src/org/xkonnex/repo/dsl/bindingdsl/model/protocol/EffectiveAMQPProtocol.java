package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AMQP;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.TopicOrQueue;

public class EffectiveAMQPProtocol extends EffectiveBindingProtocol implements
		AMQP {

	private TopicOrQueue channel;
	private String lookupName;
	private String providerLookupName;

	public EffectiveAMQPProtocol(EObject delegate) {
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
	public String getLookupName() {
		return lookupName;
	}

	@Override
	public void setLookupName(String value) {
		this.lookupName = value;
	}

	@Override
	public String getProviderLookupName() {
		return providerLookupName;
	}

	@Override
	public void setProviderLookupName(String value) {
		this.providerLookupName = value;
	}

}
