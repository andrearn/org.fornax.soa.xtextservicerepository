package org.xkonnex.repo.dsl.semanticsdsl.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.ComposedChecks;
import org.xkonnex.repo.dsl.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider;

import com.google.inject.Inject;
 

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class, org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class SemanticsDslJavaValidator extends AbstractPluggableDeclarativeValidator {

	@Inject
	protected IPluggableValidatorProvider validatorProvider;

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.SemanticsDslPackage.eINSTANCE);
		return result;
	}
	
	@Override
	protected Set<AbstractPluggableDeclarativeValidator> getRegisteredValidators () {
		 return validatorProvider.getValidators();
	}

}
