package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

/**
 * EJB accessed via RMI/IIOP
 */
public class EJB implements IModuleEndpointProtocol {

	protected String jndiName;

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

}
