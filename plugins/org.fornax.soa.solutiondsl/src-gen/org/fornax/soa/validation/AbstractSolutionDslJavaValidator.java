package org.fornax.soa.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.fornax.soa.basedsl.validation.SOABaseDslJavaValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class})
public class AbstractSolutionDslJavaValidator extends SOABaseDslJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.fornax.soa.solutionDsl.SolutionDslPackage.eINSTANCE);
		return result;
	}

}
