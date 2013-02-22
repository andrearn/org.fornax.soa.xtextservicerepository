/*
 * generated by Xtext
 */
package org.fornax.soa.moduledsl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslFactory;
import org.fornax.soa.basedsl.sOABaseDsl.impl.SOABaseDslFactoryImpl;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.basedsl.search.DefaultPredicateSearch;
import org.fornax.soa.basedsl.validation.IPluggableValidatorProvider;
import org.fornax.soa.basedsl.validation.ReflectivePluggableValidatorProvider;
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef;
import org.fornax.soa.moduledsl.query.DefaultModuleServiceResolver;
import org.fornax.soa.moduledsl.query.DefaultModuleVersionMatcher;
import org.fornax.soa.moduledsl.query.IModuleServiceResolver;
import org.fornax.soa.moduledsl.query.IModuleVersionMatcher;
import org.fornax.soa.profiledsl.scoping.versions.DefaultStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.scoping.IEnvironmentPerspectiveSelector;
import org.fornax.soa.scoping.impl.DefaultEnvironmentPerspectiveSelector;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ModuleDslRuntimeModule extends org.fornax.soa.moduledsl.AbstractModuleDslRuntimeModule {

	@org.eclipse.xtext.service.SingletonBinding(eager=true)	
	public Class<? extends IPluggableValidatorProvider> bindIPluggableValidatorProvider () {
		return ReflectivePluggableValidatorProvider.class;
	}
	
	public void configureIDefaultResourceDescriptionStrategy (Binder binder) {
		binder.bind(IDefaultResourceDescriptionStrategy.class).to(VersionedResourceDescriptionStrategy.class);
	}
	
	@org.eclipse.xtext.service.SingletonBinding	
	public Class<? extends IEnvironmentPerspectiveSelector> bindIEnvironmentPerspectiveSelector () {
		return DefaultEnvironmentPerspectiveSelector.class;
	}

	public Class<? extends LifecycleStateComparator> bindLifecycleStateComparator () {
		return LifecycleStateComparator.class;
	}
	
	public Class<? extends LifecycleStateResolver> bindLifecycleStateResolver () {
		return StateAttributeLifecycleStateResolver.class;
	}
	
	public Class<? extends IStateMatcher> bindIStateMatcher () {
		return DefaultStateMatcher.class;
	}
	
	public Class<? extends IPredicateSearch> bindIPredicateSearch () {
		return DefaultPredicateSearch.class;
	}
	
	public Class<? extends IModuleVersionMatcher> bindIModuleVersionMatcher () {
		return DefaultModuleVersionMatcher.class;
	}
	
	public Class<? extends SOABaseDslFactory> bindSOABaseDslFactory () {
		return SOABaseDslFactoryImpl.class;
	}
	
	public Class<? extends IModuleServiceResolver> bindIModuleServiceResolver () {
		return DefaultModuleServiceResolver.class;
	}

}
