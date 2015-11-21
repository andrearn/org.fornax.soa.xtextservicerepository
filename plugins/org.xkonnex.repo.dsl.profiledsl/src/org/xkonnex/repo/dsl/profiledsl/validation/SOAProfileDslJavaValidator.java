package org.xkonnex.repo.dsl.profiledsl.validation;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.validation.Check;
import org.xkonnex.repo.dsl.basedsl.validation.NameAndVersionAreUniqueValidator;
import org.xkonnex.repo.dsl.basedsl.validation.PluggableChecks;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.AbstractProfile;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfileDslPackage;
import org.xkonnex.repo.dsl.profiledsl.validation.AbstractSOAProfileDslJavaValidator;
import org.xkonnex.repo.dsl.profiledsl.query.ProfileQueries;

import com.google.inject.Inject;
 

@PluggableChecks (validators = {
		NameAndVersionAreUniqueValidator.class})
public class SOAProfileDslJavaValidator extends AbstractSOAProfileDslJavaValidator {
	
	@Inject
	private ProfileQueries profileQueries;
	

	@Check
	public void checkOneProfleMarkedAsDefault (AbstractProfile profile) {
		ResourceSet rs = profile.eResource().getResourceSet();
		AbstractProfile defaultProfile = profileQueries.getDefaultProfile(rs);
		if (defaultProfile == null) {
			warning ("You should declare one profile as default like this: \"default soa-profile ...\"", SOAProfileDslPackage.Literals.ABSTRACT_PROFILE__NAME);
		}
	}
	
	@Check
	public void checkDefaultProfileDefinesLifecycle (AbstractProfile profile) {
		ResourceSet rs = profile.eResource().getResourceSet();
		AbstractProfile defaultProfile = profileQueries.getDefaultProfile(rs);
		if (defaultProfile != null && defaultProfile.getLifecycle() == null) {
			warning ("You should declare a Lifecyle default profile like this: \"lifecycle DefaultLifecycle { ...\"", SOAProfileDslPackage.Literals.ABSTRACT_PROFILE__NAME);
		}
	}

}
