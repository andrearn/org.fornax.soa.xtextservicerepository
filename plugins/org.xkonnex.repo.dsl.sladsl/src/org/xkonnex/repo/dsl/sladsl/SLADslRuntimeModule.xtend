/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.sladsl

import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider
import org.xkonnex.repo.dsl.basedsl.validation.ReflectivePluggableValidatorProvider

/** 
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class SLADslRuntimeModule extends org.xkonnex.repo.dsl.sladsl.AbstractSLADslRuntimeModule {
	@org.eclipse.xtext.service.SingletonBinding(eager=true) def Class<? extends IPluggableValidatorProvider> bindIPluggableValidatorProvider() {
		return ReflectivePluggableValidatorProvider
	}
}
