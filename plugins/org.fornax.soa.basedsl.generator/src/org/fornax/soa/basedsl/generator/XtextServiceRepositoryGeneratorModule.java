package org.fornax.soa.basedsl.generator;

import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;

public class XtextServiceRepositoryGeneratorModule extends AbstractGenericModule {
	
	private ResourceSetBasedResourceDescriptions resourceDescriptions;
	
	public XtextServiceRepositoryGeneratorModule() {
		resourceDescriptions = new ResourceSetBasedResourceDescriptions();
	}
	
	public void configureIResourceDescriptions (Binder binder) {
		
		binder.bind (IResourceDescriptions.class).toInstance (resourceDescriptions);
		binder.bind (ResourceSetBasedResourceDescriptions.class).toInstance (resourceDescriptions);
	}

//	public void configureIResourceDescriptions (Binder binder) {
//		ResourceSetBasedResourceDescriptions resourceDescriptions = new ResourceSetBasedResourceDescriptions ();
//		binder.bind (IResourceDescriptions.class).toInstance (
//				resourceDescriptions);
//		binder.bind (ResourceSetBasedResourceDescriptions.class).toInstance (
//				resourceDescriptions);
//	}
}
