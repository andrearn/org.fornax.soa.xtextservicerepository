package org.xkonnex.repo.dsl.bindingdsl.ext.protocol.mqtt;

import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ExtensibleImportBindingProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportBindingProtocol;

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
	public boolean supportsModuleImportBindingProtocol(
			ImportBindingProtocol importBindingProtocol) {
		if (importBindingProtocol instanceof ExtensibleImportBindingProtocol) {
			ExtensibleImportBindingProtocol extProt = (ExtensibleImportBindingProtocol)importBindingProtocol;
			if (extProt.getType().getQualifiedName().equals(org.xkonnex.repo.dsl.moduledsl.ext.protocol.MQTT.class.getCanonicalName()))
				return true;
		}
		return false;
	}

}
