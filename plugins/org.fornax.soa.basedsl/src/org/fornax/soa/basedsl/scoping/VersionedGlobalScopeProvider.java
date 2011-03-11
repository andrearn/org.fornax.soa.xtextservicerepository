package org.fornax.soa.basedsl.scoping;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event.Source;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.FilterUriContainer;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.DelegatingEventSource;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.fornax.soa.basedsl.scoping.versions.NullVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.VersionFilter;
import org.fornax.soa.basedsl.scoping.versions.VersioningContainerBasedScope;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class VersionedGlobalScopeProvider extends DefaultGlobalScopeProvider {

	@Inject
	private IContainer.Manager containerManager;

	@Inject
	private IResourceDescription.Manager descriptionManager;

	
	public IScope getScope(final EObject context, EReference reference, VersionFilter filter) {
		IScope result = IScope.NULLSCOPE;
		List<IContainer> containers = Lists.newArrayList(getVisibleContainers(context, filter));
		Collections.reverse(containers);
		Iterator<IContainer> iter = containers.iterator();
		while (iter.hasNext()) {
			IContainer container = iter.next();
			result = createContainerScopeWithContext(context, result, container, reference, filter);
		}
		return result;
	}

	protected List<IContainer> getVisibleContainers(EObject context, VersionFilter filter) {
		IResourceDescription description = descriptionManager.getResourceDescription(context.eResource());
		IResourceDescriptions resourceDescriptions = getResourceDescriptions(context);
		String cacheKey = getCacheKey("VisibleContainers", context.eResource().getResourceSet(), filter);
		OnChangeEvictingCache.CacheAdapter cache = new OnChangeEvictingCache().getOrCreate(context);
		List<IContainer> result = null;
		result = cache.get(cacheKey);
		if (result == null) {
			result = containerManager.getVisibleContainers(description,	resourceDescriptions);
			// SZ: I'ld like this dependency to be moved to the implementation of the
			// container manager, but it is not aware of a CacheAdapter
			if (resourceDescriptions instanceof IResourceDescription.Event.Source) {
				IResourceDescription.Event.Source eventSource = (Source) resourceDescriptions;
				DelegatingEventSource delegatingEventSource = new DelegatingEventSource(eventSource);
				delegatingEventSource.addListeners(Collections2.forIterable(Iterables.filter(result, IResourceDescription.Event.Listener.class)));
				delegatingEventSource.initialize();
				cache.addCacheListener(delegatingEventSource);
			}
			cache.set(cacheKey, result);
		}
		return result;
	}
	
	protected String getCacheKey(String base, ResourceSet context, VersionFilter filter) {
		Map<Object, Object> loadOptions = context.getLoadOptions();
		if (loadOptions.containsKey(NAMED_BUILDER_SCOPE)) {
			return base + "@" + NAMED_BUILDER_SCOPE;
		} 
		return base + "@DEFAULT_SCOPE"; 
	}

	protected IScope createContainerScopeWithContext(EObject context, IScope result, IContainer container,
			EReference reference, VersionFilter filter) {
		Resource eResource = context.eResource();
		if (eResource != null) {
			URI uriToFilter = eResource.getURI();
			if (container.getResourceDescription(uriToFilter) != null)
				container = new FilterUriContainer(uriToFilter, container);
		}
		return createContainerScope(result, container, reference, filter);
	}

	protected IScope createContainerScope(IScope parent, IContainer container, EReference reference, VersionFilter filter) {
		Iterable<IResourceDescription> content = container.getResourceDescriptions();
		if (Iterables.isEmpty(content))
			return parent;
		VersioningContainerBasedScope scope = new VersioningContainerBasedScope(parent, reference, container, filter);
		return scope;
	}

}
