package org.xkonnex.repo.dsl.bindingdsl.binding.query.resource;

import java.util.ArrayList;
import java.util.List;

import org.xkonnex.repo.dsl.bindingdsl.binding.query.services.OperationRefBindingDescription;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractResourceRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ResourceRef;
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Qualifier;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

public class ResourceRefBindingDescription {
	
	private AbstractResourceRef resourceRef;
	private Resource resolvedResource;
	private AnyBinding applicableBinding;
	private Module providingModule;
	private Qualifier endpointQualifier;
	private List<OperationRefBindingDescription> operationDescriptions = new ArrayList<OperationRefBindingDescription>();
	
	public AbstractResourceRef getResourceRef() {
		return resourceRef;
	}
	public void setResourceRef(AbstractResourceRef resourceRef) {
		this.resourceRef = resourceRef;
	}
	public Resource getResolvedResource() {
		return resolvedResource;
	}
	public void setResolvedResource(Resource resolvedResource) {
		this.resolvedResource = resolvedResource;
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
	public List<OperationRefBindingDescription> getOperationDescriptions() {
		return operationDescriptions;
	}
	public void setOperationDescriptions(List<OperationRefBindingDescription> operationDescriptions) {
		this.operationDescriptions = operationDescriptions;
	}

}
