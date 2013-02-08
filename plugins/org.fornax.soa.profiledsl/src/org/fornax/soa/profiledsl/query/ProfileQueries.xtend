package org.fornax.soa.profiledsl.query

import com.google.inject.Inject
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.basedsl.search.IPredicateSearch
import com.google.common.base.Predicates
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile

class ProfileQueries {
	
	@Inject IPredicateSearch search
	
	def SOAProfile getDefaultProfile () {
		search.search("SOAProfile ", Predicates::alwaysTrue).filter (typeof (SOAProfile)).head
	}
}