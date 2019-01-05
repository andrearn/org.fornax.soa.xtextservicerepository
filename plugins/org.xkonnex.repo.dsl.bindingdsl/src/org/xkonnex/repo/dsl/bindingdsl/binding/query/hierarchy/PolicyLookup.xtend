package org.xkonnex.repo.dsl.bindingdsl.binding.query.hierarchy

import java.util.List
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.sladsl.sLADsl.Policy

class PolicyLookup {
	
	def getCorrespondingPolicyInBinding (AnyBinding binding, Policy policy) {
		val candidates = binding.policies.filter[eClass == policy.eClass]
		if (!candidates.empty)
			return candidates.head
		else
			return null
	}
	
	def findCorrespondingPolicyDefinitionInParent (Policy policy) {
		val owningBinding = EcoreUtil2.getContainerOfType(policy, typeof (AnyBinding))
		var parent = EcoreUtil2.getContainerOfType(owningBinding.eContainer, typeof (AnyBinding))
		while (parent !== null) {
			val correspondant =  getCorrespondingPolicyInBinding(parent, policy)
			if (correspondant !== null)
				return correspondant
			else 
				parent = EcoreUtil2.getContainerOfType(owningBinding.eContainer, typeof (AnyBinding))
		}
	}
	
	def collectCorrespondingPoliciesFromHierarchy (List<AnyBinding> bindings, Policy policy) {
		var List<Policy> policyDefs = newArrayList()
		for (bind : bindings) {
			policyDefs += getCorrespondingPolicyInBinding(bind, policy)
		}
		policyDefs
	}
}