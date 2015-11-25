package org.xkonnex.repo.dsl.servicedsl.service;

import java.util.List;

import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type;


public class VersionedDomainNamespace extends VersionedNamespace {

	private List<Type> types;
	
	private List<Service> services;
	
	private List<org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception> exceptions;

	public SubNamespace getSubdomain() {
		return (SubNamespace)namespace;
	}

	public void setSubdomain(SubNamespace owner) {
		this.namespace = owner;
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

	public List<org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception> getExceptions() {
		return exceptions;
	}

	public void setExceptions(List<org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception> exceptions) {
		this.exceptions = exceptions;
	}

}
