package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol;

public class MQTT implements IProtocol {

	private String topic;
	private String responseTopic;
	private QoSLevel qoSLevel;

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

	@Override
	public boolean supportsModuleEndpointProtocol(
			EndpointProtocol importBindingProtocol) {
		if (importBindingProtocol instanceof org.xkonnex.repo.dsl.moduledsl.ext.protocol.MQTT)
			return true;
		else
			return false;
	}

	@Override
	public boolean supportsModuleEndpointProtocol(
			Class<? extends IModuleEndpointProtocol> endpointProtocol) {
		return org.xkonnex.repo.dsl.moduledsl.ext.protocol.MQTT.class.isAssignableFrom(endpointProtocol);
	}

}
