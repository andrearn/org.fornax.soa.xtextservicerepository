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
	 * 
	 * @param style SOAP message encoding style
	 */
	public void setStyle(SOAPStyle style) {
		this.style = style;
	}

	public String getVersion() {
		return version;
	}

	/**
	 * SOAP protocol version
	 * 
	 * @param version the SOAP protocol version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	public String getContextRoot() {
		return contextRoot;
	}

	/**
	 * URL path to context root
	 * 
	 * @param contextRoot the URL path part below which all SOAP requests are handled
	 */
	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}

	public SOAPTransport getTransportProtocol() {
		return transportProtocol;
	}

	/**
	 * SOAP transport layer protocol
	 * 
	 * @param transportProtocol the SOAP transport protocol to use
	 */
	public void setTransportProtocol(SOAPTransport transportProtocol) {
		this.transportProtocol = transportProtocol;
	}
}
