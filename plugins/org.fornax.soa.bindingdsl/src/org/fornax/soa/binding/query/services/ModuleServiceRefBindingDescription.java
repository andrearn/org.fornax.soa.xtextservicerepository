package org.fornax.soa.binding.query.services;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.semanticsDsl.Qualifier;
import org.fornax.soa.serviceDsl.Service;

/**
 * Describes a Binding to a Service with their providing Module and endpoint qualifiers. The binding should
 * be the most specific applicable binding for the service
 */
public class ModuleServiceRefBindingDescription {
	
	private AbstractServiceRef serviceRef;
	private Service resolvedService;
	private Binding applicableBinding;
	private Module providingModule;
	private Qualifier endpointQualifier;
	
	public AbstractServiceRef getServiceRef() {
		return serviceRef;
	}
	public void setServiceRef(AbstractServiceRef serviceRef) {
		this.serviceRef = serviceRef;
	}
	
	public Service getResolvedService() {
		return resolvedService;
	}
	public void setResolvedService(Service resolvedService) {
		this.resolvedService = resolvedService;
	}
	
	public Binding getApplicableBinding() {
		return applicableBinding;
	}
	public void setApplicableBinding(Binding applicableBinding) {
		this.applicableBinding = applicableBinding;
	}
	
	public Module getProvidingModule() {
		return providingModule;
	}
	public void setProvidingModule(Module providingModule) {
		this.providingModule = providingModule;
	}
	
	public Qualifier getEndpointQualifier() {
		return endpointQualifier;
	}
	public void setEndpointQualifier(Qualifier endpointQualifier) {
		this.endpointQualifier = endpointQualifier;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((applicableBinding == null) ? 0 : applicableBinding
						.hashCode());
		result = prime
				* result
				+ ((endpointQualifier == null) ? 0 : endpointQualifier
						.hashCode());
		result = prime * result
				+ ((providingModule == null) ? 0 : providingModule.hashCode());
		result = prime * result
				+ ((resolvedService == null) ? 0 : resolvedService.hashCode());
		result = prime * result
				+ ((serviceRef == null) ? 0 : serviceRef.hashCode());
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
		ModuleServiceRefBindingDescription other = (ModuleServiceRefBindingDescription) obj;
		if (applicableBinding == null) {
			if (other.applicableBinding != null)
				return false;
		} else if (!applicableBinding.equals(other.applicableBinding))
			return false;
		if (endpointQualifier == null) {
			if (other.endpointQualifier != null)
				return false;
		} else if (!endpointQualifier.equals(other.endpointQualifier))
			return false;
		if (providingModule == null) {
			if (other.providingModule != null)
				return false;
		} else if (!providingModule.equals(other.providingModule))
			return false;
		if (resolvedService == null) {
			if (other.resolvedService != null)
				return false;
		} else if (!resolvedService.equals(other.resolvedService))
			return false;
		if (serviceRef == null) {
			if (other.serviceRef != null)
				return false;
		} else if (!serviceRef.equals(other.serviceRef))
			return false;
		return true;
	}
	

}
