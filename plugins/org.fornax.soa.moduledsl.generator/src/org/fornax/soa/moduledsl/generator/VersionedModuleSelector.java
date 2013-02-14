package org.fornax.soa.moduledsl.generator;

public class VersionedModuleSelector {
	
	private String name;
	private String version;
	private boolean generateProvidedServices;
	private boolean generateUsedServices;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getMaxVersion() {
		return version;
	}
	public void setMaxVersion(String version) {
		this.version = version;
	}
	public boolean isGenerateProvidedServices() {
		return generateProvidedServices;
	}
	public void setGenerateProvidedServices(boolean generateProvidedServices) {
		this.generateProvidedServices = generateProvidedServices;
	}
	public boolean isGenerateUsedServices() {
		return generateUsedServices;
	}
	public void setGenerateUsedServices(boolean generateUsedServices) {
		this.generateUsedServices = generateUsedServices;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		VersionedModuleSelector other = (VersionedModuleSelector) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	

}
