package org.xkonnex.repo.dsl.bindingdsl.binding.query.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractServiceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Qualifier;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

/**
 * Describes a Binding to a Service with their providing Module and endpoint qualifiers. The binding should
 * be the most specific applicable binding for the service
 */
public class ServiceRefBindingDescription {
	
	private AbstractServiceRef serviceRef;
	private Service resolvedService;
	private AnyBinding applicableBinding;
	private Module providingModule;
	private Qualifier endpointQualifier;
	private List<OperationRefBindingDescription> operationDescriptions = new ArrayList<OperationRefBindingDescription>();
	

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
	
	public AnyBinding getApplicableBinding() {
		return applicableBinding;
	}
	public void setApplicableBinding(AnyBinding applicableBinding) {
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
		ServiceRefBindingDescription other = (ServiceRefBindingDescription) obj;
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
	public List<OperationRefBindingDescription> getOperationDescriptions() {
		return operationDescriptions;
	}
	public void setOperationDescriptions(List<OperationRefBindingDescription> operationDescriptions) {
		this.operationDescriptions = operationDescriptions;
	}
	

}
