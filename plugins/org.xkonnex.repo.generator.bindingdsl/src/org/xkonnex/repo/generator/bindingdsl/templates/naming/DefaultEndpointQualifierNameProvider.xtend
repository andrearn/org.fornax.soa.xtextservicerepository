package org.xkonnex.repo.generator.bindingdsl.templates.naming

import com.google.inject.Inject
import com.google.inject.name.Named
import org.xkonnex.repo.dsl.bindingdsl.binding.query.EndpointQualifierQueries
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Visibility
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource

class DefaultEndpointQualifierNameProvider implements IEndpointQualifierNameProvider {
	
	@Inject extension EndpointQualifierQueries
	
	@Inject @Named ("ignoreEndpointQualifierNames")
	private boolean ignoreEndpointQualifierNames
	
	override String getEndpointQualifierName (AnyBinding bind, Service svc, BindingProtocol prot) {
		var detailedQualifierName = ""
		if (prot.effectiveEndpointQualifier != null) {
			detailedQualifierName = prot.effectiveEndpointQualifier.name.replaceAll("\\.","_")
		
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
	def String getResourceVisibilityName (Resource s) {
		switch (s.visibility) {
			case Visibility::PUBLIC : "Public"
			case Visibility::DOMAIN : "Domain"
			default: "Private"
		}
	}
	
	override getEndpointQualifierName(AnyBinding bind, Resource res, BindingProtocol prot) {
		var detailedQualifierName = ""
		if (prot.effectiveEndpointQualifier != null) {
			detailedQualifierName = prot.effectiveEndpointQualifier.name.replaceAll("\\.","_")
		
		}
		if (res.isPublicEndpoint(bind, prot)) {
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
	
}