/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.basedsl

import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory
import org.xkonnex.repo.dsl.basedsl.baseDsl.impl.BaseDslFactoryImpl
import org.xkonnex.repo.dsl.basedsl.converter.BaseDslValueConverterService
import org.xkonnex.repo.dsl.basedsl.resource.EObjectDescriptionBuilder
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder
import org.xkonnex.repo.dsl.basedsl.resource.VersionedResourceDescriptionStrategy
import org.xkonnex.repo.dsl.basedsl.search.DefaultPredicateSearch
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider
import org.xkonnex.repo.dsl.basedsl.validation.ReflectivePluggableValidatorProvider
import com.google.inject.Binder

/** 
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class BaseDslRuntimeModule extends org.xkonnex.repo.dsl.basedsl.AbstractBaseDslRuntimeModule {
	@org.eclipse.xtext.service.SingletonBinding(eager=true) 
	def Class<? extends IPluggableValidatorProvider> bindIPluggableValidatorProvider() {
		return ReflectivePluggableValidatorProvider
	}

	def Class<? extends IPredicateSearch> bindIPredicateSearch() {
		return DefaultPredicateSearch
	}

	def void configureIDefaultResourceDescriptionStrategy(Binder binder) {
		binder.bind(IDefaultResourceDescriptionStrategy).to(
			VersionedResourceDescriptionStrategy)
	}

	@org.eclipse.xtext.service.SingletonBinding(eager=true) 
	def Class<? extends IEObjectDescriptionBuilder> bindEObjectDescriptionBuilder() {
		return EObjectDescriptionBuilder
	}

	def Class<? extends BaseDslFactory> bindSOABaseDslFactory() {
		return BaseDslFactoryImpl
	}

	override Class<? extends IValueConverterService> bindIValueConverterService() {
		return BaseDslValueConverterService
	}
}
