package org.fornax.soa.xsr.connex.core.user;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	
	@Id
	private String userId;
	private String committerId;
	
	private Set<Role> assignedRoles;
	
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
	
	@ManyToMany 
	public Set<Role> getAssignedRoles() {
		return assignedRoles;
	}
	
	public void setAssignedRoles(Set<Role> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}

}
