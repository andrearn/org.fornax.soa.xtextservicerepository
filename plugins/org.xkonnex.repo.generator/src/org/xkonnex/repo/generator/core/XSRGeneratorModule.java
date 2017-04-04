package org.xkonnex.repo.generator.core;

import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class XSRGeneratorModule extends AbstractGenericModule {
	
	private ResourceSetBasedResourceDescriptions resourceDescriptions;
	
	public XSRGeneratorModule() {
		resourceDescriptions = new ResourceSetBasedResourceDescriptions();
	}
	
	public void configureIResourceDescriptions (Binder binder) {
		
		binder.bind (IResourceDescriptions.class).toInstance (resourceDescriptions);
		binder.bind (ResourceSetBasedResourceDescriptions.class).toInstance (resourceDescriptions);
	}
	
	public void configureUseRegistryBasedFilePaths (Binder binder) {
		binder.bind(Boolean.class).
			annotatedWith (Names.named(XSRGeneratorConstants.USE_REGISTRY_BASED_FILE_PATHS)).
					toInstance(false);
	}

	public void configureUseNestedPaths (Binder binder) {
		binder.bind(Boolean.class).
			annotatedWith (Names.named(XSRGeneratorConstants.USE_NESTED_PATHS)).
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
