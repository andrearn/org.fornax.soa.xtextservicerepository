/*
 * generated by Xtext
 */
package org.fornax.soa;

import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.fornax.soa.basedsl.documentation.DocFeatureDocumationProvider;
import org.fornax.soa.basedsl.resource.EObjectDescriptionBuilder;
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslFactory;
import org.fornax.soa.basedsl.sOABaseDsl.impl.SOABaseDslFactoryImpl;
import org.fornax.soa.basedsl.scoping.VersionedGlobalScopeProvider;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.basedsl.search.PredicateSearch;
import org.fornax.soa.basedsl.validation.IPluggableValidatorProvider;
import org.fornax.soa.basedsl.validation.ReflectivePluggableValidatorProvider;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.DefaultStateMatcher;
import org.fornax.soa.query.BusinessObjectQuery;
import org.fornax.soa.scoping.IEnvironmentPerspectiveSelector;
import org.fornax.soa.scoping.impl.DefaultEnvironmentPerspectiveSelector;
import org.fornax.soa.service.versioning.IServiceResolver;
import org.fornax.soa.service.versioning.ITypeResolver;
import org.fornax.soa.service.versioning.LatestMinorVersionServiceResolver;
import org.fornax.soa.service.versioning.LatestMinorVersionTypeResolver;
import org.fornax.soa.util.EnvironmentTypeComparator;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ServiceDslRuntimeModule extends org.fornax.soa.AbstractServiceDslRuntimeModule {
	
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return VersionedGlobalScopeProvider.class;
	}

	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends org.fornax.soa.validation.ServiceDslJavaValidator> bindServiceDslJavaValidator() {
		return org.fornax.soa.validation.ServiceDslJavaValidator.class;
	}
	
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	
	public Class<? extends IPluggableValidatorProvider> bindIPluggableValidatorProvider () {
		return ReflectivePluggableValidatorProvider.class;
	}
	
	public void configureIDefaultResourceDescriptionStrategy (Binder binder) {
		binder.bind(IDefaultResourceDescriptionStrategy.class).to(VersionedResourceDescriptionStrategy.class);
	}
	
	public void configureIEObjectDocumentationProvider (Binder binder) {
		binder.bind(IEObjectDocumentationProvider.class).to(MultiLineCommentDocumentationProvider.class);
	}
	
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	
	public Class<org.fornax.soa.query.BusinessObjectQuery> bindBusinessObjectQuery () {
		return BusinessObjectQuery.class;
	}
	
	public Class<? extends IPredicateSearch> bindIPredicateSearch () {
		return PredicateSearch.class;
	}
	
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	
	public Class<? extends IEObjectDescriptionBuilder> bindEObjectDescriptionBuilder () {
		return EObjectDescriptionBuilder.class;
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
	
	@org.eclipse.xtext.service.SingletonBinding	
	public Class<? extends IEnvironmentPerspectiveSelector> bindIEnvironmentPerspectiveSelector () {
		return DefaultEnvironmentPerspectiveSelector.class;
	}
	
	public Class<? extends ITypeResolver> bindITypeResolver () {
		return LatestMinorVersionTypeResolver.class;
	}
	
	public Class<? extends IServiceResolver> bindIServiceResolver () {
		return LatestMinorVersionServiceResolver.class;
	}
	
	public Class<? extends SOABaseDslFactory> bindSOABaseDslFactory () {
		return SOABaseDslFactoryImpl.class;
	}

}

