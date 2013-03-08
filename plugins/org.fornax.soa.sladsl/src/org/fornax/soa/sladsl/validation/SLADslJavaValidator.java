package org.fornax.soa.sladsl.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.ComposedChecks;
import org.fornax.soa.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.fornax.soa.basedsl.validation.IPluggableValidatorProvider;

import com.google.inject.Inject;
 

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class, org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class SLADslJavaValidator extends AbstractPluggableDeclarativeValidator {

	@Inject
	private IPluggableValidatorProvider validatorProvider;

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.fornax.soa.sladsl.sLADsl.SLADslPackage.eINSTANCE);
		return result;
	}

	@Override
	protected Set<AbstractPluggableDeclarativeValidator> getRegisteredValidators () {
		 return validatorProvider.getValidators();
	}
}
