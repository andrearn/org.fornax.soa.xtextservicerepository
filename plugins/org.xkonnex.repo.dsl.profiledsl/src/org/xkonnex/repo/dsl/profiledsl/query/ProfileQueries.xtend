package org.xkonnex.repo.dsl.profiledsl.query

import com.google.common.base.Predicates
import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.AbstractProfile
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfileDslPackage

class ProfileQueries {
	
	@Inject IPredicateSearch search
	@Inject IEObjectLookup lookup
	
	def AbstractProfile getDefaultProfile (ResourceSet resourceSet) {
		val profiles = getAllProfiles(resourceSet)
		var profile = profiles.filter(e|e.isDefault == true).head
		if (profile == null && profiles.size == 1) {
			profile = profiles.head
		}
		return profile
	}
	
	def AbstractProfile getProfileByName (String profileName, ResourceSet resourceSet) {
		if (profileName != null && profileName != "") {
			var AbstractProfile profile = lookup.getModelElementByName(profileName, resourceSet, SOAProfileDslPackage::Literals.SOA_PROFILE.name)
			return profile
		} else {
			return null
		}
	}
	
	def List<AbstractProfile> getAllProfiles (ResourceSet resourceSet) {
		val profiles = search.search("AbstractProfile ", Predicates::alwaysTrue).map (p|p.EObjectOrProxy).filter (typeof (AbstractProfile))
		return profiles.map [if (it.eIsProxy) {EcoreUtil2::resolve(it, resourceSet) as AbstractProfile} else {it}].toList
	}
}