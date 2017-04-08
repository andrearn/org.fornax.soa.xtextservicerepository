package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

/**
 * AMQP protocol
 */
public class AMQP implements IModuleEndpointProtocol {
	
	protected String queue;
	protected boolean persistentQueue;
	protected String topic;
	protected boolean durableTopic;
	protected String responseQueue;
	protected String lookupName;
	protected QoSLevel qosLevel;

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

}
