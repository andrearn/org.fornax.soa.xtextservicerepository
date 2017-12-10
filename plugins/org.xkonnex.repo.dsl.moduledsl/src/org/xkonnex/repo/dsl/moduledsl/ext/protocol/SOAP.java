package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

/**
 * SOAP protocol
 */
public class SOAP implements IModuleEndpointProtocol {

	private SOAPStyle style;
	private String version;
	private String contextRoot;
	private SOAPTransport transportProtocol;

	public SOAPStyle getStyle() {
		return style;
	}

	/**
	 * SOAP encoding style. Use document/literal-wrapped by default
	 */
	public void setStyle(SOAPStyle style) {
		this.style = style;
	}

	public String getVersion() {
		return version;
	}

	/**
	 * SOAP protocol version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	public String getContextRoot() {
		return contextRoot;
	}

	/**
	 * URL path to context root
	 */
	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}

	public SOAPTransport getTransportProtocol() {
		return transportProtocol;
	}

	/**
	 * SOAP transport layer protocol
	 */
	public void setTransportProtocol(SOAPTransport transportProtocol) {
		this.transportProtocol = transportProtocol;
	}
}
