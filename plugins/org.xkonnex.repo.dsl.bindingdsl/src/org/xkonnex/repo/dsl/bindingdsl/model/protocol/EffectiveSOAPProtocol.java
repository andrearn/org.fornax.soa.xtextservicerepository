package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAPProtocolVersion;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAPStyle;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAPTransport;

public class EffectiveSOAPProtocol extends EffectiveBindingProtocol implements SOAP {

	private SOAPStyle style;
	private SOAPProtocolVersion protocolVersion;
	private SOAPTransport transport;
	private String contextRoot;
	private String providedWsdlUrl;

	public EffectiveSOAPProtocol(EObject delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public SOAPStyle getStyle() {
		return style;
	}

	@Override
	public void setStyle(SOAPStyle value) {
		this.style = value;
	}

	@Override
	public SOAPProtocolVersion getProtocolVersion() {
		return protocolVersion;
	}

	@Override
	public void setProtocolVersion(SOAPProtocolVersion value) {
		this.protocolVersion = value;
	}

	@Override
	public SOAPTransport getTransport() {
		return transport;
	}

	@Override
	public void setTransport(SOAPTransport value) {
		this.transport = value;
	}

	@Override
	public String getContextRoot() {
		return contextRoot;
	}

	@Override
	public void setContextRoot(String value) {
		this.contextRoot = value;
	}

	@Override
	public String getProvidedWsdlUrl() {
		return providedWsdlUrl;
	}

	@Override
	public void setProvidedWsdlUrl(String value) {
		this.providedWsdlUrl = value;
	}

}
