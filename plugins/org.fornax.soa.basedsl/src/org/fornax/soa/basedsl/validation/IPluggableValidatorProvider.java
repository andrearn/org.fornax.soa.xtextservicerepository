package org.fornax.soa.basedsl.validation;

import java.util.Collection;
import java.util.Set;


public interface IPluggableValidatorProvider {
	
	public void initFromClassNames (Collection<String> validatorClassNames);

	public void setValidators (Collection<AbstractPluggableDeclarativeValidator> validators);
	
	public Set<AbstractPluggableDeclarativeValidator> getValidators ();

}
