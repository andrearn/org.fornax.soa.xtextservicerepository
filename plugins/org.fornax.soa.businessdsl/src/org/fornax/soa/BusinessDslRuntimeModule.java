/*
 * generated by Xtext
 */
package org.fornax.soa;

import org.fornax.soa.basedsl.validation.IPluggableValidatorProvider;
import org.fornax.soa.basedsl.validation.ReflectivePluggableValidatorProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class BusinessDslRuntimeModule extends org.fornax.soa.AbstractBusinessDslRuntimeModule {

	@org.eclipse.xtext.service.SingletonBinding(eager=true)	
	public Class<? extends IPluggableValidatorProvider> bindIPluggableValidatorProvider () {
		return ReflectivePluggableValidatorProvider.class;
	}

}
