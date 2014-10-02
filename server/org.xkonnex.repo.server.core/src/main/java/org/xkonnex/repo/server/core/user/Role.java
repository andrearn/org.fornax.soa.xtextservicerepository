package org.xkonnex.repo.server.core.user;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	
	@Id
	private String roleName;
	@ManyToMany
	private Set<User> users;

}
