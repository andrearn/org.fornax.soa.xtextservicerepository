package org.xkonnex.repo.dsl.basedsl.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.google.inject.Singleton;

@Singleton
public class ReflectivePluggableValidatorProvider implements
		IPluggableValidatorProvider {
	
	private static final Logger log = Logger.getLogger (ReflectivePluggableValidatorProvider.class);
	private Set<AbstractPluggableDeclarativeValidator> validators = new HashSet<AbstractPluggableDeclarativeValidator>();

	public ReflectivePluggableValidatorProvider () {
		validators = new HashSet<AbstractPluggableDeclarativeValidator>();
	}
	
	public ReflectivePluggableValidatorProvider (Collection<String> validatorClassNames) {
		this ();
		initFromClassNames (validatorClassNames);
	}

	public Set<AbstractPluggableDeclarativeValidator> getValidators() {
		return validators;
	}

	@SuppressWarnings("unchecked")
	public void initFromClassNames(Collection<String> validatorClassNames) {
		for (String className : validatorClassNames) {
			try {
				List<Class<AbstractPluggableDeclarativeValidator>> validatorClasses = new ArrayList<Class<AbstractPluggableDeclarativeValidator>>();
				validatorClasses .add ((Class<AbstractPluggableDeclarativeValidator>) Class.forName (className));
				for (Class<AbstractPluggableDeclarativeValidator> valCls : validatorClasses) {
					AbstractPluggableDeclarativeValidator validator = valCls.newInstance();
					validators.add (validator);
				}
			} catch (ClassNotFoundException e) {
				log.warn ("Could not load validator class " + className, e);
			} catch (ClassCastException ccEx) {
				log.warn ("The class " + className + " is not an instance of AbstractDeclarativeValidator", ccEx);
			} catch (InstantiationException e) {
				log.warn ("An instance of class " + className + " can not be created", e);
			} catch (IllegalAccessException e) {
				log.warn ("Could not register validator ", e);
			}
		}
	}

	public void setValidators(
			Collection<AbstractPluggableDeclarativeValidator> validators) {
		this.validators.addAll (validators);
	}

}
