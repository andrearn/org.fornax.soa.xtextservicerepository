package org.fornax.soa.basedsl.validation;

import java.util.Collection;

import org.eclipse.xtext.validation.AbstractDeclarativeValidator;


public interface IPluggableValidatorProvider {
	
	public Collection<Class<AbstractDeclarativeValidator>> getValidators ();

}
