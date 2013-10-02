package org.fornax.soa.basedsl.validation;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.google.inject.Inject;

public class NameAndVersionAreUniqueValidator extends
		AbstractPluggableDeclarativeValidator {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
	
	@Inject
	private INameAndVersionAreUniqueHelper helper;

	@Override
	public void register(EValidatorRegistrar registrar) {
		// library validator is not registered for a specific language
	}

	@Check
	public void checkUniqueNamesInResourceOf(EObject eObject) {
		Map<Object, Object> context = getContext();
		Resource resource = eObject.eResource();
		if (resource==null)
			return;
		CancelIndicator cancelIndicator = null;
		if (context != null) {
			if (context.containsKey(resource))
				return; // resource was already validated
			context.put(resource, this);
			cancelIndicator = (CancelIndicator) context.get(CancelableDiagnostician.CANCEL_INDICATOR);
		}
		doCheckUniqueNames(resource, cancelIndicator);
	}

	public void doCheckUniqueNames(Resource resource, CancelIndicator cancelIndicator) {
		final IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(resource.getURI());
		if (resourceServiceProvider==null)
			return;
		IResourceDescription.Manager manager = resourceServiceProvider.getResourceDescriptionManager();
		if (manager != null) {
			IResourceDescription description = manager.getResourceDescription(resource);
			if (description != null) {
				Iterable<IEObjectDescription> descriptions = description.getExportedObjects();
				helper.checkUniqueNames(descriptions, cancelIndicator, this);
			}
		}
	}

	public void setHelper(INameAndVersionAreUniqueHelper helper) {
		this.helper = helper;
	}

	public INameAndVersionAreUniqueHelper getHelper() {
		return helper;
	}

	public void setResourceServiceProviderRegistry(IResourceServiceProvider.Registry resourceDescriptionManagerRegistry) {
		this.resourceServiceProviderRegistry = resourceDescriptionManagerRegistry;
	}

	public IResourceServiceProvider.Registry getResourceServiceProviderRegistry() {
		return resourceServiceProviderRegistry;
	}


}
