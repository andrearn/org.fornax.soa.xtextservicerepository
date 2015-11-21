/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.servicedsl;

import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory;
import org.xkonnex.repo.dsl.basedsl.baseDsl.impl.BaseDslFactoryImpl;
import org.xkonnex.repo.dsl.basedsl.documentation.DocFeatureDocumationProvider;
import org.xkonnex.repo.dsl.basedsl.resource.EObjectDescriptionBuilder;
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder;
import org.xkonnex.repo.dsl.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.VersionedGlobalScopeProvider;
import org.xkonnex.repo.dsl.basedsl.search.DefaultPredicateSearch;
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch;
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider;
import org.xkonnex.repo.dsl.basedsl.validation.ReflectivePluggableValidatorProvider;
import org.xkonnex.repo.dsl.environmentdsl.scoping.IEnvironmentPerspectiveSelector;
import org.xkonnex.repo.dsl.environmentdsl.scoping.impl.DefaultEnvironmentPerspectiveSelector;
import org.xkonnex.repo.dsl.environmentdsl.util.EnvironmentTypeComparator;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.DefaultStateMatcher;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.state.DefaultStateResolver;
import org.xkonnex.repo.dsl.profiledsl.state.ILifecycleStateInferrer;
import org.xkonnex.repo.dsl.servicedsl.service.versioning.DefaultExceptionResolver;
import org.xkonnex.repo.dsl.servicedsl.service.versioning.DefaultServiceResolver;
import org.xkonnex.repo.dsl.servicedsl.service.versioning.DefaultTypeResolver;
import org.xkonnex.repo.dsl.servicedsl.service.versioning.LatestMinorVersionExceptionResolver;
import org.xkonnex.repo.dsl.servicedsl.service.versioning.LatestMinorVersionServiceResolver;
import org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueryInternal;
import org.xkonnex.repo.dsl.servicedsl.service.state.ServiceDslStateInferrer;
import org.xkonnex.repo.dsl.servicedsl.service.versioning.IExceptionResolver;
import org.xkonnex.repo.dsl.servicedsl.service.versioning.IServiceResolver;
import org.xkonnex.repo.dsl.servicedsl.service.versioning.IVersionedTypeRefResolver;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ServiceDslRuntimeModule extends org.xkonnex.repo.dsl.servicedsl.AbstractServiceDslRuntimeModule {
	
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return VersionedGlobalScopeProvider.class;
	}

	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends org.xkonnex.repo.dsl.servicedsl.validation.ServiceDslJavaValidator> bindServiceDslJavaValidator() {
		return org.xkonnex.repo.dsl.servicedsl.validation.ServiceDslJavaValidator.class;
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
	public Class<org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueryInternal> bindBusinessObjectQuery () {
		return DataObjectQueryInternal.class;
	}
	
	public Class<? extends IPredicateSearch> bindIPredicateSearch () {
		return DefaultPredicateSearch.class;
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
	
	public Class<? extends ILifecycleStateResolver> bindLifecycleStateResolver () {
		return DefaultStateResolver.class;
	}
	
	public Class<? extends ILifecycleStateInferrer> bindILifecycleStateInferrer () {
		return ServiceDslStateInferrer.class;
	}
	
	@org.eclipse.xtext.service.SingletonBinding	
	public Class<? extends IEnvironmentPerspectiveSelector> bindIEnvironmentPerspectiveSelector () {
		return DefaultEnvironmentPerspectiveSelector.class;
	}
	
	public Class<? extends IVersionedTypeRefResolver> bindIVersionedTypeRefResolver () {
		return DefaultTypeResolver.class;
	}
	
	public Class<? extends IServiceResolver> bindIServiceResolver () {
		return DefaultServiceResolver.class;
	}
	
	public Class<? extends IExceptionResolver> bindIExceptionResolver () {
		return DefaultExceptionResolver.class;
	}
	
	public Class<? extends BaseDslFactory> bindSOABaseDslFactory () {
		return BaseDslFactoryImpl.class;
	}

}

