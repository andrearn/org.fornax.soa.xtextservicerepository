package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

public class JMS implements IModuleEndpointProtocol {
	
	protected String queue;
	protected boolean persistentQueue;
	protected String topic;
	protected boolean durableTopic;
	protected String responseQueue;
	protected String lookupName;
	protected QoSLevel qosLevel;
	protected String jndiName;

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

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

}
