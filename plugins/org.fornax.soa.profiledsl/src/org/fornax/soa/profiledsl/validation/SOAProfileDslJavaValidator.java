package org.fornax.soa.profiledsl.validation;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.validation.Check;
import org.fornax.soa.profiledsl.query.ProfileQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfileDslPackage;

import com.google.inject.Inject;
 

public class SOAProfileDslJavaValidator extends AbstractSOAProfileDslJavaValidator {
	
	@Inject
	private ProfileQueries profileQueries;
	

	@Check
	public void checkOneProfleMarkedAsDefault (SOAProfile profile) {
		ResourceSet rs = profile.eResource().getResourceSet();
		SOAProfile defaultProfile = profileQueries.getDefaultProfile(rs);
		if (defaultProfile == null) {
			warning ("You should declare one profile as default like this: \"default soa-profile ...\"", SOAProfileDslPackage.Literals.SOA_PROFILE__NAME);
		}
	}

}
