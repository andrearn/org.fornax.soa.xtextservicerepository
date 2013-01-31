package org.fornax.soa.moduledsl.query

import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.basedsl.version.VersionMatcher
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject

class ServiceRefMatcher {
	
	@Inject extension VersionMatcher
	@Inject extension IQualifiedNameProvider
	
	def matches (Service svc, AbstractServiceRef ref) {
		val svcName = svc.fullyQualifiedName
		val refSvcName = ref.service.fullyQualifiedName
		if (svcName == refSvcName && svc.version.versionMatches(ref.versionRef)) {
			return true
		} else {
			return false
		}
	}
}