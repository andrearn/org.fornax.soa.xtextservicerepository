package org.xkonnex.repo.dsl.bindingdsl.binding.query;

import java.util.ArrayList;
import java.util.List;

import org.xkonnex.repo.dsl.bindingdsl.binding.query.resource.ResourceRefBindingDescription;
import org.xkonnex.repo.dsl.bindingdsl.binding.query.services.ServiceRefBindingDescription;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Qualifier;

public class ModuleRefServiceBindingDescription {

	private Module module;
	private Qualifier endpointQualifier;
	private List<ServiceRefBindingDescription> serviceRefDescriptions = new ArrayList<ServiceRefBindingDescription>();
	private List<ResourceRefBindingDescription> resourceRefDescriptions = new ArrayList<ResourceRefBindingDescription>();
	private List<ChannelRefBindingDescription> channelRefDescriptions = new ArrayList<ChannelRefBindingDescription>();
	
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	public Qualifier getEndpointQualifier() {
		return endpointQualifier;
	}
	public void setEndpointQualifier(Qualifier endpointQualifier) {
		this.endpointQualifier = endpointQualifier;
	}
	
	public List<ServiceRefBindingDescription> getServiceRefDescriptions() {
		return serviceRefDescriptions;
	}
	public void setServiceRefDescriptions(
			List<ServiceRefBindingDescription> serviceRefDescriptions) {
		this.serviceRefDescriptions = serviceRefDescriptions;
	}
	
	public List<ResourceRefBindingDescription> getResourceRefDescriptions() {
		return resourceRefDescriptions;
	}
	public void setResourceRefDescriptions(List<ResourceRefBindingDescription> resourceRefDescriptions) {
		this.resourceRefDescriptions = resourceRefDescriptions;
	}

	public List<ChannelRefBindingDescription> getChannelRefDescriptions() {
		return channelRefDescriptions;
	}
	public void setChannelRefDescriptions(List<ChannelRefBindingDescription> channelRefDescriptions) {
		this.channelRefDescriptions = channelRefDescriptions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((endpointQualifier == null) ? 0 : endpointQualifier
						.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime
				* result
				+ ((serviceRefDescriptions == null) ? 0
						: serviceRefDescriptions.hashCode());
		result = prime
				* result
				+ ((resourceRefDescriptions == null) ? 0
						: resourceRefDescriptions.hashCode());
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
		ModuleRefServiceBindingDescription other = (ModuleRefServiceBindingDescription) obj;
		if (endpointQualifier == null) {
			if (other.endpointQualifier != null)
				return false;
		} else if (!endpointQualifier.equals(other.endpointQualifier))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (serviceRefDescriptions == null) {
			if (other.serviceRefDescriptions != null)
				return false;
		} else if (!serviceRefDescriptions.equals(other.serviceRefDescriptions))
			return false;
		if (resourceRefDescriptions == null) {
			if (other.resourceRefDescriptions != null)
				return false;
		} else if (!resourceRefDescriptions.equals(other.resourceRefDescriptions))
			return false;
		return true;
	}

	
}
