package org.fornax.soa.servicedsl.view

import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.eclipse.emf.ecore.EObject

class VersionedTypeExtensions {
	
	def dispatch String toNamespaceName (EObject o) {
		""
	}
	def dispatch String toNamespaceName (VersionedType type) {
		type.eContainer.toNamespaceName
	}
	def dispatch String toNamespaceName (OrganizationNamespace ns) {
		if (ns.prefix != null)
			ns.prefix
		else
			ns.name
	}
	def dispatch String toNamespaceName (SubNamespace ns) {
		if (ns.eContainer != null)
			ns.eContainer.toNamespaceName + "." + ns.name
		else
			ns.name
	}
}