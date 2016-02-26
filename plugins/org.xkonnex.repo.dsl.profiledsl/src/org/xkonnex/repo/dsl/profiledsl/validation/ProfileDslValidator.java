package org.xkonnex.repo.dsl.profiledsl.validation;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.validation.Check;
import org.xkonnex.repo.dsl.basedsl.validation.NameAndVersionAreUniqueValidator;
import org.xkonnex.repo.dsl.basedsl.validation.PluggableChecks;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ProfileDslPackage;
import org.xkonnex.repo.dsl.profiledsl.query.ProfileQueries;

import com.google.inject.Inject;
 

@PluggableChecks (validators = {
		NameAndVersionAreUniqueValidator.class})
public class ProfileDslValidator extends AbstractProfileDslValidator {
	
	@Inject
	private ProfileQueries profileQueries;
	

	@Check
	public void checkOneProfleMarkedAsDefault (Profile profile) {
		ResourceSet rs = profile.eResource().getResourceSet();
		Profile defaultProfile = profileQueries.getDefaultProfile(rs);
		if (defaultProfile == null) {
			warning ("You should declare one profile as default like this: \"default soa-profile ...\"", ProfileDslPackage.Literals.PROFILE__NAME);
		}
	}
	
	@Check
	public void checkDefaultProfileDefinesLifecycle (Profile profile) {
		ResourceSet rs = profile.eResource().getResourceSet();
		Profile defaultProfile = profileQueries.getDefaultProfile(rs);
		if (defaultProfile != null && defaultProfile.getLifecycle() == null) {
			warning ("You should declare a Lifecyle default profile like this: \"lifecycle DefaultLifecycle { ...\"", ProfileDslPackage.Literals.PROFILE__NAME);
		}
	}

}
