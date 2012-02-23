package org.fornax.soa.moduledsl.query

import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery
import com.google.inject.Inject
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef

class ModuleNamespaceQuery {
	
	@Inject extension NamespaceQuery
	
	def dispatch SubNamespace findSubdomain (ServiceRef s) {
		s.service.findSubdomain();
	}
	
	def dispatch SubNamespace findSubdomain (ImportServiceRef s) {
		s.service.findSubdomain();
	}
}