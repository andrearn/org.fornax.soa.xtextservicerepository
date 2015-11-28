package org.xkonnex.repo.core.resource;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.mwe.ContainersStateFactory;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.containers.DelegatingIAllContainerAdapter;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.xkonnex.repo.core.validation.ModelIssues;
import org.xkonnex.repo.core.validation.ModelValidator;

import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class XKonneXReader {
	
	@Inject
	private ModelValidator validator;

	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	
	private ContainersStateFactory containersStateFactory = new ContainersStateFactory();
	
	
	public ResourceSet read(List<String> pathes, ModelIssues modelIssues) {
		ResourceSet resourceSet = getResourceSet();
		Multimap<String, URI> uris = getPathTraverser().resolvePathes(pathes, new Predicate<URI>() {
			public boolean apply(URI input) {
				boolean result = true;
				result = getRegistry().getResourceServiceProvider(input) != null;
				return result;
			}
		});
		IAllContainersState containersState = containersStateFactory.getContainersState(pathes, uris);
		installAsAdapter(resourceSet, containersState);
		populateResourceSet(resourceSet, uris);
		validator.validate(resourceSet, getRegistry(), modelIssues);
		return resourceSet;
	}
	
	private ResourceSet getResourceSet() {
		if (resourceSetProvider != null)
			return resourceSetProvider.get();
		return new ResourceSetImpl();
	}
	
	private PathTraverser getPathTraverser() {
		return new PathTraverser();
	}
	
	private void populateResourceSet(ResourceSet set, Multimap<String, URI> uris) {
		Collection<URI> values = Sets.newHashSet(uris.values());
		for (URI uri : values) {
			set.createResource(uri);
		}
	}

	private void installAsAdapter(ResourceSet set, IAllContainersState containersState){
		set.eAdapters().add(new DelegatingIAllContainerAdapter(containersState));
	}
	
	private IResourceServiceProvider.Registry getRegistry() {
		return IResourceServiceProvider.Registry.INSTANCE;
	}

}
