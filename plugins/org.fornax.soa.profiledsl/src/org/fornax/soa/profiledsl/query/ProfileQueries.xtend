package org.fornax.soa.profiledsl.query

import com.google.inject.Inject
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.basedsl.search.IPredicateSearch
import com.google.common.base.Predicates
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.EcoreUtil2
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfileDslPackage

class ProfileQueries {
	
	@Inject IPredicateSearch search
	@Inject IEObjectLookup lookup
	
	def SOAProfile getDefaultProfile (ResourceSet resourceSet) {
		val profiles = search.search("SOAProfile ", Predicates::alwaysTrue).map (p|p.EObjectOrProxy).filter (typeof (SOAProfile))
		var profile = profiles.filter(e|e.isDefault == true).head
		if (profile != null && profile.eIsProxy) {
			profile = EcoreUtil2.resolve(profile, resourceSet) as SOAProfile
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
}