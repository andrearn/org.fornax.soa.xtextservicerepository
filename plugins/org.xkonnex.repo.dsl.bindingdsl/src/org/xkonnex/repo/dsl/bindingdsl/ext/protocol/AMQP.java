package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Connector;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;

public class AMQP implements IProtocol {

	private String queue;
	private boolean persistentQueue;
	private String topic;
	private boolean durableTopic;
	private String responseQueue;
	private String lookupName;
	private QoSLevel qosLevel;

	@Override
	public boolean supportsModuleEndpointProtocol(
			EndpointProtocol endpointProtocol) {
		if (endpointProtocol instanceof org.xkonnex.repo.dsl.moduledsl.ext.protocol.AMQP)
			return true;
		else
			return false;
	}

	@Override
	public boolean supportsModuleEndpointProtocol(
			Class<? extends IModuleEndpointProtocol> endpointProtocol) {
		return org.xkonnex.repo.dsl.moduledsl.ext.protocol.AMQP.class.isAssignableFrom(endpointProtocol);
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public boolean isPersistentQueue() {
		return persistentQueue;
	}

	public void setPersistentQueue(boolean persistentQueue) {
		this.persistentQueue = persistentQueue;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public boolean isDurableTopic() {
		return durableTopic;
	}

	public void setDurableTopic(boolean durableTopic) {
		this.durableTopic = durableTopic;
	}

	public String getResponseQueue() {
		return responseQueue;
	}

	public void setResponseQueue(String responseQueue) {
		this.responseQueue = responseQueue;
	}

	public String getLookupName() {
		return lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

	public QoSLevel getQosLevel() {
		return qosLevel;
	}

	public void setQosLevel(QoSLevel qosLevel) {
		this.qosLevel = qosLevel;
	}

	@Override
	public boolean supportedOnConnector(Connector connector) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportedOnConnector(IConnector connector) {
		// TODO Auto-generated method stub
		return false;
	}

}
