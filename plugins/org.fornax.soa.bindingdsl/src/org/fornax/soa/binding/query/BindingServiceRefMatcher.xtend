package org.fornax.soa.binding.query

import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.basedsl.version.VersionMatcher
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject
import org.fornax.soa.bindingDsl.ServiceRef

class BindingServiceRefMatcher {
	
	@Inject extension VersionMatcher
	@Inject extension IQualifiedNameProvider
	
	def matches (Service svc, ServiceRef ref) {
		val svcName = svc.fullyQualifiedName
		val refSvcName = ref.service.fullyQualifiedName
		if (svcName == refSvcName && svc.version.versionMatches(ref.versionRef)) {
			return true
		} else {
			return false
		}
	}
}