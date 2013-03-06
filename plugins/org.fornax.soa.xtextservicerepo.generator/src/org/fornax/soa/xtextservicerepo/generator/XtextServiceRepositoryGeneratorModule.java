package org.fornax.soa.xtextservicerepo.generator;

import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class XtextServiceRepositoryGeneratorModule extends AbstractGenericModule {
	
	private ResourceSetBasedResourceDescriptions resourceDescriptions;
	
	public XtextServiceRepositoryGeneratorModule() {
		resourceDescriptions = new ResourceSetBasedResourceDescriptions();
	}
	
	public void configureIResourceDescriptions (Binder binder) {
		
		binder.bind (IResourceDescriptions.class).toInstance (resourceDescriptions);
		binder.bind (ResourceSetBasedResourceDescriptions.class).toInstance (resourceDescriptions);
	}
	
	public void configureUseRegistryBasedFilePaths (Binder binder) {
		binder.bind(Boolean.class).
			annotatedWith (Names.named(XtextServiceRepositoryGeneratorConstants.USE_REGISTRY_BASED_FILE_PATHS)).
					toInstance(false);
	}

	public void configureUseNestedPaths (Binder binder) {
		binder.bind(Boolean.class).
			annotatedWith (Names.named(XtextServiceRepositoryGeneratorConstants.USE_NESTED_PATHS)).
					toInstance(false);
	}

//	public void configureIResourceDescriptions (Binder binder) {
//		ResourceSetBasedResourceDescriptions resourceDescriptions = new ResourceSetBasedResourceDescriptions ();
//		binder.bind (IResourceDescriptions.class).toInstance (
//				resourceDescriptions);
//		binder.bind (ResourceSetBasedResourceDescriptions.class).toInstance (
//				resourceDescriptions);
//	}
}
