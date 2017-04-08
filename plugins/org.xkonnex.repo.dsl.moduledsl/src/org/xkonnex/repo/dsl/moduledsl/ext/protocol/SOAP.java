package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

public class SOAP implements IModuleEndpointProtocol {

	private SOAPStyle style;
	private String version;
	private String contextRoot;
	private SOAPTransport transportProtocol;

	public SOAPStyle getStyle() {
		return style;
	}

	public void setStyle(SOAPStyle style) {
		this.style = style;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getContextRoot() {
		return contextRoot;
	}

	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}

	public SOAPTransport getTransportProtocol() {
		return transportProtocol;
	}

	public void setTransportProtocol(SOAPTransport transportProtocol) {
		this.transportProtocol = transportProtocol;
	}
}
