package org.xkonnex.repo.dsl.bindingdsl.binding.query.hierarchy

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Assertion
import org.eclipse.xtext.EcoreUtil2
import java.util.List

class AssertionLookup {
	
	def getCorrespondingAssertionInBinding (AnyBinding binding, Assertion assertion) {
		val candidates = binding.assertions.filter[eClass == assertion.eClass]
		if (!candidates.empty)
			return candidates.head
		else
			return null
	}
	
	def findCorrespondingAssertionlDefinitionInParent (Assertion assertion) {
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
	
	def collectCorrespondingAssertionsFromHierarchy (List<AnyBinding> bindings, Assertion assertion) {
		var List<Assertion> assertionDefs = newArrayList()
		for (bind : bindings) {
			assertionDefs += getCorrespondingAssertionInBinding(bind, assertion)
		}
		assertionDefs
	}
}