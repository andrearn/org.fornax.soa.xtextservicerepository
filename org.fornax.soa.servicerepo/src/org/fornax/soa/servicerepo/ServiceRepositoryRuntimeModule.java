/*
 * generated by Xtext
 */
package org.fornax.soa.servicerepo;

import java.util.Properties;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.SimpleResourceDescriptionsBasedContainerManager;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;


/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ServiceRepositoryRuntimeModule extends AbstractGenericModule {

	protected Properties properties = null;

	@Override
	public void configure(Binder binder) {
		properties = tryBindProperties(binder, "org/fornax/soa/ServiceRepository.properties");
		super.configure(binder);
	}

	public void configureLanguageName(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance("org.fornax.soa.ServiceRepository");
	}
	
	public void configureFileExtensions(Binder binder) {
		if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)
			binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("svcdsl");
	}
//
//	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
//	public Class<? extends org.eclipse.xtext.resource.containers.IAllContainersState.Provider> bindIAllContainersState$Provider() {
//		return org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider.class;
//	}
//
//	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
//	public void configureIResourceDescriptions(com.google.inject.Binder binder) {
//		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
//	}
//
//	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
//	public void configureIResourceDescriptionsBuilderScope(com.google.inject.Binder binder) {
//		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider.NAMED_BUILDER_SCOPE)).to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
//	}
}
