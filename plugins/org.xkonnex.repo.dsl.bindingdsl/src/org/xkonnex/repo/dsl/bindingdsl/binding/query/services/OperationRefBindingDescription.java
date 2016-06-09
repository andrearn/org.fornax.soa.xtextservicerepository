package org.xkonnex.repo.dsl.bindingdsl.binding.query.services;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding;
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.OperationRef;
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Qualifier;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;

public class OperationRefBindingDescription {
	
	private OperationRef operationRef;
	private Operation resolvedOperation;
	private AnyBinding applicableBinding;
	private Module providingModule;
	private Qualifier endpointQualifier;

	public OperationRefBindingDescription() {
		// TODO Auto-generated constructor stub
	}
	
	
	public OperationRefBindingDescription(Operation resolvedOperation, AnyBinding applicableBinding,
			Module providingModule, Qualifier endpointQualifier) {
		super();
		this.resolvedOperation = resolvedOperation;
		this.applicableBinding = applicableBinding;
		this.providingModule = providingModule;
		this.endpointQualifier = endpointQualifier;
	}
	
	public OperationRefBindingDescription(OperationRef operationRef,
			Operation resolvedOperation, AnyBinding applicableBinding,
			Module providingModule, Qualifier endpointQualifier) {
		super();
		this.operationRef = operationRef;
		this.resolvedOperation = resolvedOperation;
		this.applicableBinding = applicableBinding;
		this.providingModule = providingModule;
		this.endpointQualifier = endpointQualifier;
	}


	public OperationRef getOperationRef() {
		return operationRef;
	}
	public void setOperationRef(OperationRef operationRef) {
		this.operationRef = operationRef;
	}
	
	public Operation getResolvedOperation() {
		return resolvedOperation;
	}
	public void setResolvedOperation(Operation resolvedOperation) {
		this.resolvedOperation = resolvedOperation;
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
				+ ((operationRef == null) ? 0 : operationRef.hashCode());
		result = prime * result
				+ ((providingModule == null) ? 0 : providingModule.hashCode());
		result = prime
				* result
				+ ((resolvedOperation == null) ? 0 : resolvedOperation
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
		OperationRefBindingDescription other = (OperationRefBindingDescription) obj;
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
		if (operationRef == null) {
			if (other.operationRef != null)
				return false;
		} else if (!operationRef.equals(other.operationRef))
			return false;
		if (providingModule == null) {
			if (other.providingModule != null)
				return false;
		} else if (!providingModule.equals(other.providingModule))
			return false;
		if (resolvedOperation == null) {
			if (other.resolvedOperation != null)
				return false;
		} else if (!resolvedOperation.equals(other.resolvedOperation))
			return false;
		return true;
	}

	
}
