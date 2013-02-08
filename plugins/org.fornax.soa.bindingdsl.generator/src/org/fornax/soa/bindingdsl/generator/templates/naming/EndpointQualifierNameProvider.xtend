package org.fornax.soa.bindingdsl.generator.templates.naming

import javax.naming.Binding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.serviceDsl.Visibility
import org.fornax.soa.serviceDsl.Service

class EndpointQualifierNameProvider {
	
	def dispatch getEndpointQualifier (Binding bind, Service svc) {
		return svc.serviceVisibilityName
	}
	def dispatch getEndpointQualifier (ServiceBinding bind, Service svc) {
		if (bind.eContainer instanceof ModuleBinding) {
			val modBind = (bind.eContainer as ModuleBinding)
			modBind.getEndpointQualifier(svc)
		}
		return svc.serviceVisibilityName
	}
	def dispatch getEndpointQualifier (ModuleBinding bind, Service svc) {
		val moduleQualifier = bind.module.module.qualifiers
		if (moduleQualifier != null)
			return moduleQualifier.qualifiers.head.name.replaceAll("\\.","_")
		return svc.serviceVisibilityName
	}
	/*
	 * Derive a qualifying name for the endpoint
	 * 
	 * FIXME: strange convention to name provider endpoints 
	 */
	def dispatch String getProviderEndpointQualifier (Binding bind, Service svc) {
		if (svc.visibility == Visibility::PRIVATE)
			return "PrivateProvider"
		else
			return "Private"
	}
	def dispatch String getProviderEndpointQualifier (ModuleBinding bind, Service svc) {
		val moduleQualifier = bind.module.module.qualifiers
		if (moduleQualifier != null)
			return moduleQualifier.qualifiers.head.name.replaceAll("\\.","_")
		if (svc.visibility == Visibility::PRIVATE)
			return "PrivateProvider"
		else
			return "Private"
	}

	def dispatch String getServiceVisibilityName (Service s) {
		switch (s.visibility) {
			case Visibility::PUBLIC : "Public"
			case Visibility::DOMAIN : "Domain"
			default: "Private"
		}
	}
	
}