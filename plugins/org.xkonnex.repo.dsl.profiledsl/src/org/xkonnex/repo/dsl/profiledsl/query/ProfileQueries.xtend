package org.xkonnex.repo.dsl.profiledsl.query

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import com.google.common.base.Predicates
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfileDslPackage
import java.util.List

class ProfileQueries {
	
	@Inject IPredicateSearch search
	@Inject IEObjectLookup lookup
	
	def SOAProfile getDefaultProfile (ResourceSet resourceSet) {
		val profiles = getAllProfiles(resourceSet)
		var profile = profiles.filter(e|e.isDefault == true).head
		if (profile == null && profiles.size == 1) {
			profile = profiles.head
		}
		return profile
	}
	
	def SOAProfile getProfileByName (String profileName, ResourceSet resourceSet) {
		if (profileName != null && profileName != "") {
			var SOAProfile profile = lookup.getModelElementByName(profileName, resourceSet, SOAProfileDslPackage::Literals.SOA_PROFILE.name)
			return profile
		} else {
			return null
		}
	}
	
	def List<SOAProfile> getAllProfiles (ResourceSet resourceSet) {
		val profiles = search.search("SOAProfile ", Predicates::alwaysTrue).map (p|p.EObjectOrProxy).filter (typeof (SOAProfile))
		return profiles.map [if (it.eIsProxy) {EcoreUtil2::resolve(it, resourceSet) as SOAProfile} else {it}].toList
	}
}