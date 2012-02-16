package org.fornax.soa.profiledsl.query.type

import com.google.inject.Inject
import java.util.List
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType

class VersionedTypeFilter {
	
	@Inject extension VersionMatcher
	
	def dispatch List<VersionedType> allTypesByMajorVersion (TechnicalNamespace s, String majorVersion) { 
		s.types.filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType))
			.filter (t|t.version.matchesMajorVersion (majorVersion)).toList();
	}
}