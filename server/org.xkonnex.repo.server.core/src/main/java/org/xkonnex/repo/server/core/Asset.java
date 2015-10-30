package org.xkonnex.repo.server.core;

import javax.persistence.Embeddable;

@Embeddable
public class Asset {
	
	private String qualifiedName;
	private String type;
	private String version;
	
	public Asset() {
		// TODO Auto-generated constructor stub
	}
	
	public Asset(String qualifiedName, String type, String version) {
		this.setQualifiedName(qualifiedName);
		this.setType(type);
		this.setVersion(version);
	}

	public String getQualifiedName() {
		return qualifiedName;
	}

	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
