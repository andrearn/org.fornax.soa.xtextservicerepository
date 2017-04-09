package org.xkonnex.repo.generator.bindingdsl.http

import com.google.inject.Inject
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.bindingdsl.templates.naming.IEndpointQualifierNameProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource

class HttpBindingResolver {
	
	@Inject extension IEndpointQualifierNameProvider
		
	def String toBindingName (Service s, ExtensibleProtocol p) {
		s.name + p.getPortNamePostfix();
	}
		
	def String toBindingName (Service s, ExtensibleProtocol p, String qualifierName) {
		s.name + qualifierName + p.getPortNamePostfix();
	}
	def String toBindingName (Resource s, ExtensibleProtocol p) {
		s.name + p.getPortNamePostfix();
	}
		
	def String toBindingName (Resource s, ExtensibleProtocol p, String qualifierName) {
		s.name + qualifierName + p.getPortNamePostfix();
	}
	
	def String toPortName (Service s, ExtensibleProtocol p) {
		s.name + p.getPortNamePostfix();
	}
	
	def String toPortName (Service s, ExtensibleProtocol p, String qualifierName) {
		if (qualifierName != "Public" && qualifierName != "Private")
			s.name + qualifierName + p.getPortNamePostfix()
		else 
			s.toPortName(p)
	}
	def String toPortName (Resource s, ExtensibleProtocol p) {
		s.name + p.getPortNamePostfix();
	}
	
	def String toPortName (Resource s, ExtensibleProtocol p, String qualifierName) {
		if (qualifierName != "Public" && qualifierName != "Private")
			s.name + qualifierName + p.getPortNamePostfix()
		else 
			s.toPortName(p)
	}
	
	
	def String toScopedPortName (Service s, AnyBinding binding, ExtensibleProtocol p) {
		binding.getEndpointQualifierName (s, p)
		s.toPortName(p) + binding.getEndpointQualifierName (s, p);
	}
	
	def String toScopedPortName (Service s, AnyBinding binding, ExtensibleProtocol p, String qualifierName) {
		if (qualifierName != "Public" && qualifierName != "Private")
			s.toPortName(p) + qualifierName
		else
			s.toScopedPortName(binding, p)
	}
	def String toScopedPortName (Resource s, AnyBinding binding, ExtensibleProtocol p) {
		binding.getEndpointQualifierName (s, p)
		s.toPortName(p) + binding.getEndpointQualifierName (s, p);
	}
	
	def String toScopedPortName (Resource s, AnyBinding binding, ExtensibleProtocol p, String qualifierName) {
		if (qualifierName != "Public" && qualifierName != "Private")
			s.toPortName(p) + qualifierName
		else
			s.toScopedPortName(binding, p)
	}
	
	def protected String getPortNamePostfix(ExtensibleProtocol p) { 
		p.type.simpleName
	}
}