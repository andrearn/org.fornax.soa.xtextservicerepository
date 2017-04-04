package org.xkonnex.repo.dsl.profiledsl.query.type

import com.google.inject.Inject
import java.util.List
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType

class VersionedTypeFilter {
	
	@Inject extension VersionMatcher
	
	def List<VersionedType> allTypesByMajorVersion (TechnicalNamespace s, String majorVersion) { 
		s.types.filter (typeof (org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType))
			.filter (t|t.version.matchesMajorVersion (majorVersion)).toList();
	}
}