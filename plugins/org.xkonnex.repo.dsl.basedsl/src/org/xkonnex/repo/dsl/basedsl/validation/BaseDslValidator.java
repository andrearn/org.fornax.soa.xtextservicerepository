package org.xkonnex.repo.dsl.basedsl.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;

import com.google.inject.Inject;
 

public class BaseDslValidator extends AbstractPluggableDeclarativeValidator {
	
	@Inject
	protected IPluggableValidatorProvider validatorProvider;


	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage.eINSTANCE);
		return result;
	}


	@Override
	protected Set<AbstractPluggableDeclarativeValidator> getRegisteredValidators () {
		 return validatorProvider.getValidators();
	}

}
