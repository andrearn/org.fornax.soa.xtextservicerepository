package org.fornax.soa.servicedsl.generator.query.type

import org.fornax.soa.serviceDsl.VersionedType
import java.util.List
import org.fornax.soa.serviceDsl.SubNamespace
import com.google.inject.Inject
import org.fornax.soa.basedsl.generator.version.VersionMatcher
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery

class VersionedTypeFilter {
	
	@Inject extension VersionMatcher
	@Inject extension NamespaceQuery 
	
	def dispatch List<VersionedType> allTypesByMajorVersion (SubNamespace s, String majorVersion) {
		s.types.filter (typeof (VersionedType))
			.filter (t|t.version.matchesMajorVersion (majorVersion)).toList();
	}

	def dispatch List<VersionedType> allTypesByMajorVersion (Service s, String majorVersion) { 
		(s.findSubdomain() as SubNamespace).types.filter (typeof (VersionedType))
			.filter (t|t.version.matchesMajorVersion (majorVersion)).toList();
	}
}