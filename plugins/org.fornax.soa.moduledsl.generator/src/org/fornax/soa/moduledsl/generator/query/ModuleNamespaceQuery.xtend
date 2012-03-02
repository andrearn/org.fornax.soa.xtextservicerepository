package org.fornax.soa.moduledsl.generator.query

import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery
import com.google.inject.Inject
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef

class ModuleNamespaceQuery {
	
	@Inject NamespaceQuery nsQuery
	
	def dispatch SubNamespace findSubdomain (ServiceRef s) {
		nsQuery.findSubdomain (s.service);
	}
	
	def dispatch SubNamespace findSubdomain (ImportServiceRef s) {
		nsQuery.findSubdomain (s.service);
	}
}