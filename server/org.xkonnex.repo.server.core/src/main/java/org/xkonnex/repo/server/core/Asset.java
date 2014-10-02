package org.xkonnex.repo.server.core;

public class Asset {
	
	private String qualifiedName;
	private String type;
	private String version;
	
	
	public Asset(String qualifiedName, String type, String version) {
		this.qualifiedName = qualifiedName;
		this.type = type;
		this.version = version;
	}

	public String getQualifiedName() {
		return qualifiedName;
	}
	
	public String getType() {
		return type;
	}
	
	public String getVersion() {
		return version;
	}

}
