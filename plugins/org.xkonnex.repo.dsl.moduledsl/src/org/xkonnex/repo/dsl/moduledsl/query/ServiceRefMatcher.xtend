package org.xkonnex.repo.dsl.moduledsl.query

import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractServiceRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
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