package org.xkonnex.repo.dsl.bindingdsl.binding.query.hierarchy

import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import java.util.List

class BindingProtocolLookup {
	
	def getCorrespondingProtocolInBinding (AnyBinding binding, BindingProtocol protocol) {
		if (protocol.type != null) {
			val candidates = binding.protocol.filter[type != null type.qualifiedName==protocol.type.qualifiedName]
			if (!candidates.empty)
				return candidates.head
			else
				return null
		} else {
			val candidates = binding.protocol.filter[eClass == protocol.eClass]
			if (!candidates.empty)
				return candidates.head
			else
				return null
		}
	}
	
	def findCorrespondingProtocolDefinitionInParent (BindingProtocol protocol) {
		val owningBinding = EcoreUtil2.getContainerOfType(protocol, typeof (AnyBinding))
		var parent = EcoreUtil2.getContainerOfType(owningBinding.eContainer, typeof (AnyBinding))
		while (parent != null) {
			val correspondant =  getCorrespondingProtocolInBinding(parent, protocol)
			if (correspondant != null)
				return correspondant
			else 
				parent = EcoreUtil2.getContainerOfType(owningBinding.eContainer, typeof (AnyBinding))
		}
	}
	
	def collectCorrespondingProtocolsFromHierarchy (List<AnyBinding> bindings, BindingProtocol protocol) {
		var List<BindingProtocol> protocolDefs = newArrayList()
		for (bind : bindings) {
			protocolDefs += getCorrespondingProtocolInBinding(bind, protocol)
		}
		protocolDefs
	}
}