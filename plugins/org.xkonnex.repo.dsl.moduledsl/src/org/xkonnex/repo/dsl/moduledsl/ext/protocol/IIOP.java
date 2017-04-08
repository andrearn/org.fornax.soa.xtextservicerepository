package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

/** CORBA IIOP protocol */
public class IIOP implements IModuleEndpointProtocol {

	protected String lookupName;

	public String getLookupName() {
		return lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

}
