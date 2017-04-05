/*
 * generated by Xtext
 */
package org.xkonnex.repo.core;

import java.util.Properties;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.SimpleResourceDescriptionsBasedContainerManager;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.service.DefaultRuntimeModule;
import org.xkonnex.repo.core.resource.XKonneXResourceSetProvider;
import org.xkonnex.repo.dsl.basedsl.search.DefaultPredicateSearch;
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.name.Names;


/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class ServiceRepositoryRuntimeModule extends DefaultRuntimeModule {

	protected Properties properties = null;

	@Override
	public void configure(Binder binder) {
		properties = tryBindProperties(binder, "org/xkonnex/repo/core/ServiceRepository.properties");
		super.configure(binder);
	}

	public void configureLanguageName(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance("org.xkonnex.repo.dsl.bindingdsl.ServiceRepository");
	}
	
	public void configureFileExtensions(Binder binder) {
		if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)
			binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("svcdsl");
	}
	
	public Class<? extends IPredicateSearch> bindIPredicateSearch () {
		return DefaultPredicateSearch.class;
	}
	
	public Class<? extends org.eclipse.xtext.serializer.ISerializer> bindISerializer() {
		return org.eclipse.xtext.serializer.impl.Serializer.class;
	}
}
