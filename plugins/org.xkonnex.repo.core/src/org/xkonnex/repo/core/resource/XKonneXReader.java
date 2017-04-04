package org.xkonnex.repo.core.resource;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.mwe.ContainersStateFactory;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.containers.DelegatingIAllContainerAdapter;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.xkonnex.repo.core.validation.ModelIssues;
import org.xkonnex.repo.core.validation.ModelValidator;

import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class XKonneXReader {
	
	@Inject
	private ModelValidator validator;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	
	private ContainersStateFactory containersStateFactory = new ContainersStateFactory();
	
	
	public XtextResourceSet read(List<String> pathes, ModelIssues modelIssues) {
		String classPath = System.getProperty("java.class.path");
		String separator = System.getProperty("path.separator");
		String[] strings = classPath.split(separator);
		for (String path : strings) {
			pathes.add(path);
		}

		XtextResourceSet resourceSet = getResourceSet();
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
	
	
	
	private XtextResourceSet getResourceSet() {
		XtextResourceSet resourceSet = null;
		if (resourceSetProvider != null)
			resourceSet = resourceSetProvider.get();
		if (resourceSet == null) {
			resourceSet = new XtextResourceSet();
		}
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		resourceSet.setClasspathURIContext(this);
		return resourceSet;
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
	
	public void setContainersStateFactory(ContainersStateFactory containersStateFactory) {
		this.containersStateFactory = containersStateFactory;
	}
	
	public ContainersStateFactory getContainersStateFactory() {
		return containersStateFactory;
	}

}
