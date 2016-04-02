package org.xkonnex.repo.dsl.bindingdsl.model

import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.basedsl.baseDsl.GovernanceDecision
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.basedsl.model.IEffectiveFeatureInferrer
import org.xkonnex.repo.dsl.basedsl.util.JavaBeanMerger
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup
import org.xkonnex.repo.dsl.bindingdsl.binding.query.hierarchy.AssertionLookup
import org.xkonnex.repo.dsl.bindingdsl.binding.query.hierarchy.BindingProtocolLookup
import org.xkonnex.repo.dsl.bindingdsl.binding.query.hierarchy.PolicyLookup
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AccuracyAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Assertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AuthenticationPolicy
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AvailabilityAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingDslPackage
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.CapacityAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.CostAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EncryptionPolicy
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.LatencyAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.LogPolicy
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Policy
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.PredefinedAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ReliabilityAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SigningPolicy
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IProtocol
import org.xkonnex.repo.dsl.bindingdsl.model.assertion.EffectiveAccuracyAssertion
import org.xkonnex.repo.dsl.bindingdsl.model.assertion.EffectiveAssertion
import org.xkonnex.repo.dsl.bindingdsl.model.assertion.EffectiveAvailabilityAssertion
import org.xkonnex.repo.dsl.bindingdsl.model.assertion.EffectiveCapacityAssertion
import org.xkonnex.repo.dsl.bindingdsl.model.assertion.EffectiveCostAssertion
import org.xkonnex.repo.dsl.bindingdsl.model.assertion.EffectiveLatencyAssertion
import org.xkonnex.repo.dsl.bindingdsl.model.assertion.EffectivePredefinedAssertion
import org.xkonnex.repo.dsl.bindingdsl.model.assertion.EffectiveReliabilityAssertion
import org.xkonnex.repo.dsl.bindingdsl.model.policy.EffectiveAuthenticationPolicy
import org.xkonnex.repo.dsl.bindingdsl.model.policy.EffectiveEncryptionPolicy
import org.xkonnex.repo.dsl.bindingdsl.model.policy.EffectiveLogPolicy
import org.xkonnex.repo.dsl.bindingdsl.model.policy.EffectivePolicy
import org.xkonnex.repo.dsl.bindingdsl.model.protocol.EffectiveBindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.model.protocol.EffectiveExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.model.protocol.EffectiveSOAPProtocol
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service

class EffectiveBindingBuilder implements IEffectiveBindingBuilder {
	
	@Inject
	private IEffectiveFeatureInferrer featureInferrer
	@Inject
	private JavaBeanMerger beanMerger
	@Inject
	private BindingProtocolLookup protocolLookup
	@Inject
	private PolicyLookup policyLookup
	@Inject
	private AssertionLookup assertionLookup
	@Inject
	private BindingLookup bindingLookup
	@Inject
	private IComponentInferrer componentInferrer
	
	override EffectiveBinding createEffectiveBinding (Operation operation, Binding binding) {
		val specBinding = bindingLookup.getMostSpecificOperationBinding(operation, binding)
		val bindingHierarchy = bindingLookup.getBottomUpHierarchyForSpecificBinding(specBinding);
		val hierarchyEObjects = bindingHierarchy.map[it as EObject]
		var effBind = new EffectiveBinding(specBinding)
		effBind.protocol += createEffectiveBindingProtocol(bindingHierarchy)
		effBind.policies += createEffectivePolicies(bindingHierarchy)
		effBind.assertions += createEffectiveAssertions(bindingHierarchy)
		effBind.environment = featureInferrer.inferFeatureValue(hierarchyEObjects, BindingDslPackage.Literals.BINDING__ENVIRONMENT)
		effBind.provServer = featureInferrer.inferFeatureValue(hierarchyEObjects, BindingDslPackage.Literals.BINDING__PROV_SERVER)
		effBind.governanceDecisions += createEffectiveGovernanceDecisions(bindingHierarchy)
		return effBind
	}
	
	def List<GovernanceDecision> createEffectiveGovernanceDecisions(List<AnyBinding> bindings) {
		newArrayList
	}
	
	override List<EffectiveBindingProtocol> createEffectiveBindingProtocol (List<AnyBinding> bindingsBottomUp) {
		var List<EffectiveBindingProtocol> effProts = newArrayList()
		var Set<Class<?>> protocolTypes = newHashSet
		for (bind : bindingsBottomUp) {
			val specProtocols = bind.protocol
			for (prot : specProtocols) {
				val protType = getProtocolType(prot)
				if (!protocolTypes.contains(protType)) {
					protocolTypes += protType
					if (prot instanceof SOAP) {
						effProts += createSOAP(bindingsBottomUp, prot as SOAP)
					} else if (prot instanceof ExtensibleProtocol) {
						effProts += createExtensibleProtocol(bindingsBottomUp, prot as ExtensibleProtocol)
					}
				}
			}
		}
		return effProts
	}
	
	def List<EffectivePolicy> createEffectivePolicies (List<AnyBinding> bindingsBottomUp) {
		var List<EffectivePolicy> effPols = newArrayList()
		var Set<Class<?>> policyTypes = newHashSet
		for (bind : bindingsBottomUp) {
			val specPolicies = bind.policies
			for (pol : specPolicies) {
				val polType = pol.class
				if (!policyTypes.contains(polType)) {
					policyTypes += polType
					effPols += createPolicyEObject(bindingsBottomUp, pol)
				}
			}
		}
		return effPols
	}
	
	def List<EffectiveAssertion> createEffectiveAssertions (List<AnyBinding> bindingsBottomUp) {
		var List<EffectiveAssertion> effAssertions = newArrayList()
		var Set<Class<?>> assertTypes = newHashSet
		for (bind : bindingsBottomUp) {
			val specAssertions = bind.assertions
			for (specAssert : specAssertions) {
				val assertType = specAssert.class
				if (!assertTypes.contains(assertType)) {
					assertTypes += assertType
					effAssertions += createAssertionEObject(bindingsBottomUp, specAssert)
				}
			}
		}
		return effAssertions
	}
	
	private def createSOAP (List<AnyBinding> bindings, SOAP soap) {
		val effSoap = new EffectiveSOAPProtocol(soap)
		var List<EObject> soapDefs = protocolLookup.collectCorrespondingProtocolsFromHierarchy(bindings, soap).map[it as EObject]
		
		effSoap.endpointConnector = featureInferrer.inferFeatureValue(soapDefs, BindingDslPackage.Literals.BINDING_PROTOCOL__ENDPOINT_CONNECTOR) 
		effSoap.endpointQualifierRef = featureInferrer.inferFeatureValue(soapDefs, BindingDslPackage.Literals.BINDING_PROTOCOL__ENDPOINT_QUALIFIER_REF) 
		effSoap.style = featureInferrer.inferFeatureValue(soapDefs, BindingDslPackage.Literals.SOAP__STYLE)
		effSoap.contextRoot = featureInferrer.inferFeatureValue(soapDefs, BindingDslPackage.Literals.SOAP__CONTEXT_ROOT)
		effSoap.protocolVersion = featureInferrer.inferFeatureValue(soapDefs, BindingDslPackage.Literals.SOAP__PROTOCOL_VERSION)
		effSoap.providedWsdlUrl = featureInferrer.inferFeatureValue(soapDefs, BindingDslPackage.Literals.SOAP__PROVIDED_WSDL_URL)
		effSoap.transport = featureInferrer.inferFeatureValue(soapDefs, BindingDslPackage.Literals.SOAP__TRANSPORT)
		return effSoap
	}
	
	private def createExtensibleProtocol(List<AnyBinding> bindings, ExtensibleProtocol protocol) {
		val effExtProt = new EffectiveExtensibleProtocol(protocol)
		val List<BindingProtocol> protDefs = protocolLookup.collectCorrespondingProtocolsFromHierarchy(bindings, protocol)
		var List<IProtocol> protInstances = newArrayList()
		for (prot : protDefs) {
			val IProtocol protInst = componentInferrer.inferComponent(prot)
			protInstances += protInst
		}
		effExtProt.extensibleProtocol = beanMerger.merge(protInstances)
		val protDefEObjects = protDefs.map[it as EObject]
		effExtProt.endpointConnector = featureInferrer.inferFeatureValue(protDefEObjects, BindingDslPackage.Literals.BINDING_PROTOCOL__ENDPOINT_CONNECTOR) 
		effExtProt.endpointQualifierRef = featureInferrer.inferFeatureValue(protDefEObjects, BindingDslPackage.Literals.BINDING_PROTOCOL__ENDPOINT_QUALIFIER_REF) 
		return effExtProt
	}
	
	override createEffectiveBinding(Service service, Binding binding) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	private def Class<?> getProtocolType(BindingProtocol prot) {
		if (prot instanceof ExtensibleProtocol) {
			val IProtocol protComp = componentInferrer.inferComponent(prot.type)
			return protComp.getClass()
		} else {
			return prot.getClass()
		}
	}
	
	private def EffectivePolicy createPolicyEObject(List<AnyBinding> bindings, Policy policy) {
		val List<Policy> polDefs = policyLookup.collectCorrespondingPoliciesFromHierarchy(bindings, policy)
		var EffectivePolicy effPol = null 
		switch (policy) {
			case AuthenticationPolicy: 	effPol = new EffectiveAuthenticationPolicy(policy)
			case EncryptionPolicy: 		effPol = new EffectiveEncryptionPolicy(policy)
			case LogPolicy: 			effPol = new EffectiveLogPolicy(policy)
			case SigningPolicy: 		effPol = new EffectiveEncryptionPolicy(policy)
			default: 					effPol = new EffectivePolicy(policy)
		}
		effPol = featureInferrer.inferFeatureValues(polDefs.map[it as EObject], effPol) as EffectivePolicy
		effPol
	}
	
	private def EffectiveAssertion createAssertionEObject(List<AnyBinding> bindings, Assertion assertion) {
		val List<Assertion> polDefs = assertionLookup.collectCorrespondingAssertionsFromHierarchy(bindings, assertion)
		var EffectiveAssertion effAssertion = null 
		switch (assertion) {
			case AccuracyAssertion: 	effAssertion = new EffectiveAccuracyAssertion(assertion)
			case AvailabilityAssertion: effAssertion = new EffectiveAvailabilityAssertion(assertion)
			case CapacityAssertion: 	effAssertion = new EffectiveCapacityAssertion(assertion)
			case CostAssertion: 		effAssertion = new EffectiveCostAssertion(assertion)
			case LatencyAssertion: 		effAssertion = new EffectiveLatencyAssertion(assertion)
			case PredefinedAssertion: 	effAssertion = new EffectivePredefinedAssertion(assertion)
			case ReliabilityAssertion: 	effAssertion = new EffectiveReliabilityAssertion(assertion)
			default: 					effAssertion = new EffectiveAssertion(assertion)
		}
		effAssertion = featureInferrer.inferFeatureValues(polDefs.map[it as EObject], effAssertion) as EffectiveAssertion
		effAssertion
	}
	
}