package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

/**
 * Access service using MQTT messaging protocol
 */
public class MQTT implements IModuleEndpointProtocol {

	protected String topic;
	protected String responseTopic;
	protected QoSLevel qoSLevel;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getResponseTopic() {
		return responseTopic;
	}

	public void setResponseTopic(String responseTopic) {
		this.responseTopic = responseTopic;
	}

	public QoSLevel getQoSLevel() {
		return qoSLevel;
	}

	public void setQoSLevel(QoSLevel qoSLevel) {
		this.qoSLevel = qoSLevel;
	}

}
