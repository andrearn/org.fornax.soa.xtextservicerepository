package org.xkonnex.repo.dsl.bindingdsl.binding.query.resource

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import javax.inject.Inject
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ResourceRef

class BindingResourceRefMatcher {
	@Inject extension VersionMatcher
	@Inject extension IQualifiedNameProvider
	
	def matches (Resource res, ResourceRef ref) {
		val resName = res.fullyQualifiedName
		val refResName = ref.resource.fullyQualifiedName
		if (resName == refResName && res.version.versionMatches(ref.versionRef)) {
			return true
		} else {
			return false
		}
	}
	
}