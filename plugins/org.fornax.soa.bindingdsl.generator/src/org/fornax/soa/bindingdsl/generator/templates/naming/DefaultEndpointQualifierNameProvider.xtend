package org.fornax.soa.bindingdsl.generator.templates.naming

import com.google.inject.Inject
import com.google.inject.name.Named
import org.fornax.soa.binding.query.EndpointQualifierQueries
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.Visibility

class DefaultEndpointQualifierNameProvider implements IEndpointQualifierNameProvider {
	
	@Inject extension EndpointQualifierQueries
	
	@Inject @Named ("ignoreEndpointQualifierNames")
	private boolean ignoreEndpointQualifierNames
	
	override String getEndpointQualifierName (Binding bind, Service svc, BindingProtocol prot) {
		var detailedQualifierName = ""
		if (bind.endpointQualifierRef?.endpointQualifier != null) {
			detailedQualifierName = bind.effectiveEndpointQualifier.name.replaceAll("\\.","_")
		
		}
		if (svc.isPublicEndpoint(bind, prot)) {
			if (ignoreEndpointQualifierNames)
				return "Public"
			else
				return detailedQualifierName + "Public"
		} else {
			if (ignoreEndpointQualifierNames)
				return "Private"
			else
				return detailedQualifierName + "Private"
		}
	}
	
	def String getServiceVisibilityName (Service s) {
		switch (s.visibility) {
			case Visibility::PUBLIC : "Public"
			case Visibility::DOMAIN : "Domain"
			default: "Private"
		}
	}
	
}