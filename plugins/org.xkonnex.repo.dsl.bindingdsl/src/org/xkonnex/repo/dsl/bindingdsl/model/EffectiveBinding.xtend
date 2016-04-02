package org.xkonnex.repo.dsl.bindingdsl.model

import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.basedsl.baseDsl.GovernanceDecision
import org.xkonnex.repo.dsl.basedsl.model.DelegatingEObject
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Assertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ChannelBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EndpointQualifierRef
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.OperationBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Policy
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server

class EffectiveBinding extends DelegatingEObject implements AnyBinding {
	
	private Environment environment
	private Server provServer
	private EndpointQualifierRef endpointQualifierRef
	private EList<GovernanceDecision> governanceDecisions = new BasicEList<GovernanceDecision>()
	private EList<BindingProtocol> protocol = new BasicEList<BindingProtocol>()
	private EList<Policy> policies = new BasicEList<Policy>()
	private EList<Assertion> assertions = new BasicEList<Assertion>()
	private ServiceBinding serviceBinding
	private OperationBinding operationBinding
	private ChannelBinding channelBinding
	
	ModuleBinding moduleBinding
	
	new(AnyBinding delegate) {
		super(delegate)
		if (delegate instanceof OperationBinding)
			operationBinding = delegate as OperationBinding
		else if (delegate instanceof ChannelBinding) 
			channelBinding = delegate as ChannelBinding
		moduleBinding = EcoreUtil2.getContainerOfType(delegate, typeof(ModuleBinding))
		serviceBinding = EcoreUtil2.getContainerOfType(delegate, typeof(ServiceBinding))
	}

	def Environment getEnvironment() {
		return environment
	}

	def void setEnvironment(Environment value) {
		this.environment = value
	}

	def Server getProvServer() {
		return provServer
	}

	def void setProvServer(Server value) {
		this.provServer = value
	}

	override EndpointQualifierRef getEndpointQualifierRef() {
		return endpointQualifierRef
	}

	override void setEndpointQualifierRef(EndpointQualifierRef value) {
		this.endpointQualifierRef = value
	}

	override EList<GovernanceDecision> getGovernanceDecisions() {
		return governanceDecisions
	}

	override EList<BindingProtocol> getProtocol() {
		return protocol
	}

	override EList<Policy> getPolicies() {
		return policies
	}

	override EList<Assertion> getAssertions() {
		return assertions
	}

	def ModuleBinding getModuleBinding() {
		return moduleBinding
	}
	
	def Binding getBindingDelegate() {
		delegate as Binding
	}
}
