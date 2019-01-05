package org.xkonnex.repo.dsl.bindingdsl.binding.query.hierarchy

import java.util.List
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.sladsl.sLADsl.ServiceQualityKPI

class AssertionLookup {
	
	def getCorrespondingAssertionInBinding (AnyBinding binding, ServiceQualityKPI assertion) {
		val candidates = binding.assertions.filter[eClass == assertion.eClass]
		val inlineCandidates = binding.inlineAssertions.filter[eClass == assertion.eClass]
		if (!inlineCandidates.empty)
			return candidates.head
		else if (!candidates.empty)
			return candidates.head
		else
			return null
	}
	
	def findCorrespondingAssertionlDefinitionInParent (ServiceQualityKPI assertion) {
		val owningBinding = EcoreUtil2.getContainerOfType(assertion, typeof (AnyBinding))
		var parent = EcoreUtil2.getContainerOfType(owningBinding.eContainer, typeof (AnyBinding))
		while (parent !== null) {
			val correspondant =  getCorrespondingAssertionInBinding(parent, assertion)
			if (correspondant !== null)
				return correspondant
			else 
				parent = EcoreUtil2.getContainerOfType(owningBinding.eContainer, typeof (AnyBinding))
		}
	}
	
	def collectCorrespondingAssertionsFromHierarchy (List<AnyBinding> bindings, ServiceQualityKPI assertion) {
		var List<ServiceQualityKPI> assertionDefs = newArrayList()
		for (bind : bindings) {
			assertionDefs += getCorrespondingAssertionInBinding(bind, assertion)
		}
		assertionDefs
	}
}