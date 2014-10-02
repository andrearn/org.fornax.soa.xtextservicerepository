package org.xkonnex.repo.dsl.profiledsl.query.type

import com.google.inject.Inject
import java.util.List
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType

class VersionedTypeFilter {
	
	@Inject extension VersionMatcher
	
	def dispatch List<VersionedType> allTypesByMajorVersion (TechnicalNamespace s, String majorVersion) { 
		s.types.filter (typeof (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType))
			.filter (t|t.version.matchesMajorVersion (majorVersion)).toList();
	}
}