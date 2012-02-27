package org.fornax.soa.servicedsl;

import java.util.List;

import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.Type;


public class VersionedDomainNamespace {

	private Object subdomain;
	
	private String fqn;
	
	private String name;
	
	private String shortName;
	
	private String version;
	
	private List<Type> types;
	
	private List<Service> services;
	
	private List<org.fornax.soa.serviceDsl.Exception> exceptions;
	
	public Object getSubdomain() {
		return subdomain;
	}

	public void setSubdomain(Object owner) {
		this.subdomain = owner;
	}

	public String getFqn() {
		return fqn;
	}

	public void setFqn(String fqn) {
		this.fqn = fqn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<org.fornax.soa.serviceDsl.Exception> getExceptions() {
		return exceptions;
	}

	public void setExceptions(List<org.fornax.soa.serviceDsl.Exception> exceptions) {
		this.exceptions = exceptions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fqn == null) ? 0 : fqn.hashCode());
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
		VersionedDomainNamespace other = (VersionedDomainNamespace) obj;
		if (fqn == null) {
			if (other.fqn != null)
				return false;
		} else if (!fqn.equals(other.fqn))
			return false;
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
