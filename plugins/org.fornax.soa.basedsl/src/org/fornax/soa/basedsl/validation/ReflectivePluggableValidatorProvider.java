package org.fornax.soa.basedsl.validation;

import java.util.Collection;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

import com.google.inject.Singleton;

@Singleton
public class ReflectivePluggableValidatorProvider implements
		IPluggableValidatorProvider {
	
	private static final Logger log = Logger.getLogger (ReflectivePluggableValidatorProvider.class);
	private HashSet<Class<AbstractDeclarativeValidator>> validators;
	
	@SuppressWarnings("unchecked")
	public ReflectivePluggableValidatorProvider (Collection<String> validatorClassNames) {
		validators = new HashSet<Class<AbstractDeclarativeValidator>>();
		for (String className : validatorClassNames) {
			try {
				validators.add ((Class<AbstractDeclarativeValidator>) Class.forName (className));
			} catch (ClassNotFoundException e) {
				log.warn ("Could not load validator class " + className, e);
			} catch (ClassCastException ccEx) {
				log.warn ("The class " + className + " is not an instance of AbstractDeclarativeValidator", ccEx);
			}
		}
	}

	public Collection<Class<AbstractDeclarativeValidator>> getValidators() {
		return validators;
	}

}
