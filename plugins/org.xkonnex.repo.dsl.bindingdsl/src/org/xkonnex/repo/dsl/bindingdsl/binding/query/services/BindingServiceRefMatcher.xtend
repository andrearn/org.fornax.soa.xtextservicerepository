package org.xkonnex.repo.dsl.bindingdsl.binding.query.services


import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceRef

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