package org.xkonnex.repo.dsl.bindingdsl.model

import java.util.List
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.basedsl.baseDsl.GovernanceDecision
import org.xkonnex.repo.dsl.basedsl.model.DelegatingEObject
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ChannelBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EndpointQualifierRef
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.OperationBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.moduledsl.model.EffectiveProvidingEndpoint
import org.xkonnex.repo.dsl.sladsl.sLADsl.Policy
import org.xkonnex.repo.dsl.sladsl.sLADsl.ServiceQualityKPI
import org.xkonnex.repo.dsl.sladsl.sLADsl.Costs

class EffectiveBinding extends DelegatingEObject implements AnyBinding {
	
	Environment environment
	Server provServer
	EndpointQualifierRef endpointQualifierRef
	EList<GovernanceDecision> governanceDecisions = new BasicEList<GovernanceDecision>()
	EList<BindingProtocol> protocol = new BasicEList<BindingProtocol>()
	EList<Policy> policies = new BasicEList<Policy>()
	EList<ServiceQualityKPI> assertions = new BasicEList<ServiceQualityKPI>()
	EList<ServiceQualityKPI> inlineAssertions = new BasicEList<ServiceQualityKPI>()
	ServiceBinding serviceBinding
	OperationBinding operationBinding
	ChannelBinding channelBinding
	Costs costs
	Costs inlineCosts
	
	List<EffectiveProvidingEndpoint> providingEndpoints = newArrayList()
	
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

	override EList<ServiceQualityKPI> getAssertions() {
		return assertions
	}

	def ModuleBinding getModuleBinding() {
		return moduleBinding
	}
	
	def Binding getBindingDelegate() {
		delegate as Binding
	}
	
	def List<EffectiveProvidingEndpoint> getProvidingEndpoints() {
		providingEndpoints
	}
	
	override getCosts() {
		costs
	}
	
	override setCosts(Costs value) {
		this.costs = value
	}
	
	override getInlineAssertions() {
		inlineAssertions
	}
	
	override getInlineCosts() {
		inlineCosts
	}
	
	override setInlineCosts(Costs value) {
		inlineCosts = value
	}
	
}
