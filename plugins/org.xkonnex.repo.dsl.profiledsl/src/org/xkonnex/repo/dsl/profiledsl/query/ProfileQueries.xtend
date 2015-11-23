package org.xkonnex.repo.dsl.profiledsl.query

import com.google.common.base.Predicates
import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ProfileDslPackage

class ProfileQueries {
	
	@Inject IPredicateSearch search
	@Inject IEObjectLookup lookup
	
	def Profile getDefaultProfile (ResourceSet resourceSet) {
		val profiles = getAllProfiles(resourceSet)
		var profile = profiles.filter(e|e.isDefault == true).head
		if (profile == null && profiles.size == 1) {
			profile = profiles.head
		}
		return profile
	}
	
	def Profile getProfileByName (String profileName, ResourceSet resourceSet) {
		if (profileName != null && profileName != "") {
			var Profile profile = lookup.getModelElementByName(profileName, resourceSet, ProfileDslPackage::Literals.PROFILE.name)
			return profile
		} else {
			return null
		}
	}
	
	def List<Profile> getAllProfiles (ResourceSet resourceSet) {
		val profiles = search.search("Profile ", Predicates::alwaysTrue).map (p|p.EObjectOrProxy).filter (typeof (Profile))
		return profiles.map [if (it.eIsProxy) {EcoreUtil2::resolve(it, resourceSet) as Profile} else {it}].toList
	}
}