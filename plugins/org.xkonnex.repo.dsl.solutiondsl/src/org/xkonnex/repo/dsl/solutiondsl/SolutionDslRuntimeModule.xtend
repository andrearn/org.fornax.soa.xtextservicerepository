/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.solutiondsl

import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.xkonnex.repo.dsl.basedsl.converter.BaseDslValueConverterService
import org.xkonnex.repo.dsl.basedsl.resource.VersionedResourceDescriptionStrategy
import org.xkonnex.repo.dsl.basedsl.scoping.versions.VersionedGlobalScopeProvider
import org.xkonnex.repo.dsl.basedsl.search.DefaultPredicateSearch
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider
import org.xkonnex.repo.dsl.basedsl.validation.ReflectivePluggableValidatorProvider
import org.xkonnex.repo.dsl.environmentdsl.scoping.IEnvironmentPerspectiveSelector
import org.xkonnex.repo.dsl.environmentdsl.scoping.impl.DefaultEnvironmentPerspectiveSelector
import org.xkonnex.repo.dsl.environmentdsl.util.EnvironmentTypeComparator
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.DefaultStateMatcher
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver
import com.google.inject.Binder

/** 
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class SolutionDslRuntimeModule extends org.xkonnex.repo.dsl.solutiondsl.AbstractSolutionDslRuntimeModule {
	override Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return VersionedGlobalScopeProvider
	}

	@org.eclipse.xtext.service.SingletonBinding(eager=true) def Class<? extends IPluggableValidatorProvider> bindIPluggableValidatorProvider() {
		return ReflectivePluggableValidatorProvider
	}

	def void configureIDefaultResourceDescriptionStrategy(Binder binder) {
		binder.bind(IDefaultResourceDescriptionStrategy).to(
			VersionedResourceDescriptionStrategy)
	}

	def Class<? extends IStateMatcher> bindIStateResolver() {
		return DefaultStateMatcher
	}

	def Class<? extends EnvironmentTypeComparator> bindEnvironmentTypeComparator() {
		return EnvironmentTypeComparator
	}

	def Class<? extends LifecycleStateComparator> bindLifecycleStateComparator() {
		return LifecycleStateComparator
	}

	def Class<? extends ILifecycleStateResolver> bindLifecycleStateResolver() {
		return StateAttributeLifecycleStateResolver
	}

	@org.eclipse.xtext.service.SingletonBinding def Class<? extends IEnvironmentPerspectiveSelector> bindIEnvironmentPerspectiveSelector() {
		return DefaultEnvironmentPerspectiveSelector
	}

	def Class<? extends IPredicateSearch> bindIPredicateSearch() {
		return DefaultPredicateSearch
	}

	def Class<? extends ILifecycleStateResolver> bindILifecycleStateResolver() {
		return StateAttributeLifecycleStateResolver
	}

	override Class<? extends IValueConverterService> bindIValueConverterService() {
		return BaseDslValueConverterService
	}
}
