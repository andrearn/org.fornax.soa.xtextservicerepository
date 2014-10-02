package org.xkonnex.repo.server.core.config;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RepositoryDescription {
	
	@Id 
	private String url;
	private String name;
	private RepositoryType type;
	private String workspaceLocation;

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public RepositoryType getType() {
		return type;
	}
	
	public void setType(RepositoryType type) {
		this.type = type;
	}
	
	public String getWorkspaceLocation() {
		return workspaceLocation;
	}

	public void setWorkspaceLocation(String workspaceLocation) {
		this.workspaceLocation = workspaceLocation;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime
				* result
				+ ((workspaceLocation == null) ? 0 : workspaceLocation
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepositoryDescription other = (RepositoryDescription) obj;
		if (type != other.type)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (workspaceLocation == null) {
			if (other.workspaceLocation != null)
				return false;
		} else if (!workspaceLocation.equals(other.workspaceLocation))
			return false;
		return true;
	}

}
