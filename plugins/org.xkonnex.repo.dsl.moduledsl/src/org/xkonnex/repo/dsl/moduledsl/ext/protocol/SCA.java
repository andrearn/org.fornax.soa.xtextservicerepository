package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

/**
 * Direct SCA (Service Component Architecture) call
 */
public class SCA implements IModuleEndpointProtocol {
	
	protected String promote;
	protected String reference;
	protected boolean isMultipleRef;
	
	public String getPromote() {
		return promote;
	}
	public void setPromote(String promote) {
		this.promote = promote;
	}
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public boolean isMultipleRef() {
		return isMultipleRef;
	}
	public void setMultipleRef(boolean isMultipleRef) {
		this.isMultipleRef = isMultipleRef;
	}

}
