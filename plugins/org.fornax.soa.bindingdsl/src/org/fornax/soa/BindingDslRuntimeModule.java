/*
 * generated by Xtext
 */
package org.fornax.soa;

import org.fornax.soa.basedsl.scoping.VersionedGlobalScopeProvider;
import org.fornax.soa.basedsl.validation.IPluggableValidatorProvider;
import org.fornax.soa.basedsl.validation.ReflectivePluggableValidatorProvider;
import org.fornax.soa.profiledsl.scoping.versions.DefaultStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.util.EnvironmentTypeComparator;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class BindingDslRuntimeModule extends org.fornax.soa.AbstractBindingDslRuntimeModule {
	
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return VersionedGlobalScopeProvider.class;
	}

	@org.eclipse.xtext.service.SingletonBinding(eager=true)	
	public Class<? extends IPluggableValidatorProvider> bindIPluggableValidatorProvider () {
		return ReflectivePluggableValidatorProvider.class;
	}
	
	public Class<? extends IStateMatcher> bindIStateMatcher () {
		return DefaultStateMatcher.class;
	}
	
	public Class<? extends EnvironmentTypeComparator> bindEnvironmentTypeComparator () {
		return EnvironmentTypeComparator.class;
	}
	
	public Class<? extends LifecycleStateComparator> bindLifecycleStateComparator () {
		return LifecycleStateComparator.class;
	}
	
	public Class<? extends LifecycleStateResolver> bindLifecycleStateResolver () {
		return StateAttributeLifecycleStateResolver.class;
	}

}
