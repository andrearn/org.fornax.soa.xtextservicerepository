package org.fornax.soa.xsr.connex.core.user;

import java.util.List;

public class User {
	
	private String userId;
	private String committerId;
	private List<Role> assignedRoles;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommitterId() {
		return committerId;
	}
	public void setCommitterId(String committerId) {
		this.committerId = committerId;
	}
	public List<Role> getAssignedRoles() {
		return assignedRoles;
	}
	public void setAssignedRoles(List<Role> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}

}
