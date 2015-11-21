package org.xkonnex.repo.dsl.basedsl.search;

import static com.google.common.collect.Iterables.isEmpty;
import static com.google.common.collect.Maps.newIdentityHashMap;
import static com.google.common.collect.Sets.newLinkedHashSet;
import static java.util.Collections.singleton;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.xkonnex.repo.dsl.basedsl.resource.ILocalResourceAccess;
import org.xkonnex.repo.dsl.basedsl.resource.SimpleLocalResourceAccess;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

public class PredicateReferenceSearch implements IReferenceSearch {

	private IResourceDescriptions index;

	private IResourceServiceProvider.Registry serviceProviderRegistry;

	private IEObjectLookup ieObjLookup;

	@Inject
	public PredicateReferenceSearch (IResourceDescriptions index, IEObjectLookup ieObjLookup,
			IResourceServiceProvider.Registry serviceProviderRegistry) {
		this.index = index;
		this.ieObjLookup = ieObjLookup;
		this.serviceProviderRegistry = serviceProviderRegistry;
	}

	public void findAllReferences (EObject eObjectOrProxy,
			ResourceSet resourceSet, Predicate<IReferenceDescription> referencePredicate, IAcceptor<IReferenceDescription> acceptor) {
		if (eObjectOrProxy.eIsProxy ()) {
			eObjectOrProxy = EcoreUtil2.resolve (eObjectOrProxy, resourceSet);
		}
		if (!eObjectOrProxy.eIsProxy ()) {
			URI targetURI = EcoreUtil.getURI (eObjectOrProxy);
			IReferenceQueryData queryData = new ReferenceQueryData (targetURI, singleton (targetURI), targetURI.trimFragment (), referencePredicate);
			findAllReferences (queryData, resourceSet, new SimpleLocalResourceAccess (resourceSet), acceptor);
		}
	}
	public void findAllReferences (IEObjectDescription iEObjDesc,
			ResourceSet resourceSet, Predicate<IReferenceDescription> referencePredicate, IAcceptor<IReferenceDescription> acceptor) {
		EObject eObjectOrProxy = iEObjDesc.getEObjectOrProxy ();
		findAllReferences (eObjectOrProxy, resourceSet, referencePredicate, acceptor);
	}

	public void findAllReferences(IReferenceQueryData queryData, ResourceSet resourceSet, ILocalResourceAccess localResourceAccess,
			final IAcceptor<IReferenceDescription> acceptor) {
		Set<URI> targetURIs = queryData.getTargetURIs();
		if (!isEmpty(targetURIs)) {
			if (localResourceAccess != null) {
				findLocalReferences(queryData, localResourceAccess, acceptor);
			}
			Set<URI> targetURIsAsSet = newLinkedHashSet(targetURIs);
			findAllIndexedReferences(acceptor, targetURIsAsSet, localResourceAccess);
		}
//		if (!queryData.getTargetURIs().isEmpty()) {
//			findLocalReferences(queryData, localResourceAccess, acceptor);
//			findIndexedReferences(queryData, resourceSet, acceptor);
//		}
	}
	
	protected void findAllIndexedReferences(IAcceptor<IReferenceDescription> referenceAcceptor, 
			Set<URI> targetURIsAsSet, ILocalResourceAccess localResourceAccess) {
		for (IResourceDescription resourceDescription : index.getAllResourceDescriptions()) {
			IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(resourceDescription.getURI());
			IReferenceSearch referenceFinder = serviceProvider.get(IReferenceSearch.class);
			// don't use the language specific reference finder here for backwards compatibility reasons
			findReferences(targetURIsAsSet, resourceDescription, referenceAcceptor, localResourceAccess);
		}
	}

	public void findIndexedReferences(IReferenceQueryData queryData, ResourceSet resourceSet, URI resourceURI, IAcceptor<IReferenceDescription> acceptor) {
		if (index instanceof ResourceSetBasedResourceDescriptions)
			((ResourceSetBasedResourceDescriptions)index).setContext (resourceSet);
		IResourceDescription resourceDescription = index.getResourceDescription(resourceURI.trimFragment());
		if (resourceDescription != null) {
			for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
				if (queryData.getTargetURIs().contains(referenceDescription.getTargetEObjectUri())
						&& (queryData.getResultFilter() == null || queryData.getResultFilter().apply(
								referenceDescription))) {
					acceptor.accept(referenceDescription);
				}
			}
		}
	}

	public void findLocalReferences(final IReferenceQueryData queryData, ILocalResourceAccess localResourceAccess,
			final IAcceptor<IReferenceDescription> acceptor) {

		final Multimap<URI, URI> resource2target = LinkedHashMultimap.create();
		for (URI targetURI : queryData.getTargetURIs()) {
			resource2target.put(targetURI.trimFragment(), targetURI);
		}
		for (final URI resourceURI : resource2target.keySet()) {
			localResourceAccess.readOnly(resourceURI, new IUnitOfWork.Void<ResourceSet>() {
				@Override
				public void process(ResourceSet resourceSet) throws Exception {
					Resource resource = resourceSet.getResource(resourceURI, true);
					findLocalReferencesInResource(resource2target.get(resourceURI), resource, acceptor, queryData.getResultFilter());
				}
			});
		}
	}

	protected void findLocalReferencesInResource(final Iterable<URI> targetURIs, Resource resource,
			final IAcceptor<IReferenceDescription> acceptor, Predicate<IReferenceDescription> filter) {
		Set<URI> targetURISet = ImmutableSet.copyOf(targetURIs);
		Map<EObject, URI> exportedElementsMap = createExportedElementsMap(resource);
		for(EObject content: resource.getContents()) {
			findLocalReferencesFromElement(targetURISet, content, resource, acceptor, null, exportedElementsMap, filter);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void findLocalReferencesFromElement(
			final Set<URI> targetURISet, 
			EObject sourceCandidate,
			Resource localResource,
			final IAcceptor<IReferenceDescription> acceptor, 
			URI currentExportedContainerURI, 
			Map<EObject, URI> exportedElementsMap,
			Predicate<IReferenceDescription> filter) {
		URI sourceURI = null; 
		if(exportedElementsMap.containsKey(sourceCandidate)) { 
			currentExportedContainerURI = exportedElementsMap.get(sourceCandidate);
			sourceURI = currentExportedContainerURI;
		}
		for(EReference ref: sourceCandidate.eClass().getEAllReferences()) {
			if(sourceCandidate.eIsSet(ref)) {
				if(ref.isContainment()) {
					Object content = sourceCandidate.eGet(ref, false);
					if(ref.isMany()) {
						InternalEList<EObject> contentList = (InternalEList<EObject>) content;
						for(int i=0; i<contentList.size(); ++i) {
							EObject childElement = contentList.basicGet(i);
							if(!childElement.eIsProxy())
								findLocalReferencesFromElement(targetURISet, childElement, localResource, acceptor, currentExportedContainerURI, exportedElementsMap, filter);
						}
					} else {
						EObject childElement = (EObject) content;
						if(!childElement.eIsProxy())
							findLocalReferencesFromElement(targetURISet, childElement, localResource, acceptor, currentExportedContainerURI, exportedElementsMap, filter);
					}
				} else if (!ref.isContainer()) {
					Object value = sourceCandidate.eGet(ref, false);
					if(ref.isMany()) {
						InternalEList<EObject> values = (InternalEList<EObject>) value;
						for(int i=0; i< values.size(); ++i) {
							EObject refElement = resolveInternalProxy(values.basicGet(i), localResource);
							URI refURI= EcoreUtil2.getPlatformResourceOrNormalizedURI(refElement);
							if(targetURISet.contains(refURI)) {
								sourceURI = (sourceURI == null) ? EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceCandidate) : sourceURI;
								IReferenceDescription localReferenceDescription = new DefaultReferenceDescription(
										sourceURI, refURI, ref, i, currentExportedContainerURI);
								if (filter == null || filter.apply(localReferenceDescription)) {
									acceptor.accept(localReferenceDescription);
								}
							}
						}
					} else {
						EObject refElement = resolveInternalProxy((EObject) value, localResource);
						URI refURI= EcoreUtil2.getPlatformResourceOrNormalizedURI(refElement);
						if(targetURISet.contains(refURI)) {
							sourceURI = (sourceURI == null) ? EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceCandidate) : sourceURI;
							IReferenceDescription localReferenceDescription = new DefaultReferenceDescription(
									sourceURI, refURI, ref, -1, currentExportedContainerURI);
							if (filter == null || filter.apply(localReferenceDescription)) {
								acceptor.accept(localReferenceDescription);
							}
						}
					}
				}
			}
		}
	}
	
	protected EObject resolveInternalProxy(EObject elementOrProxy, Resource resource) {
		if(elementOrProxy.eIsProxy() && ((InternalEObject) elementOrProxy).eProxyURI().trimFragment().equals(resource.getURI()))
			return EcoreUtil.resolve(elementOrProxy, resource);
		else
			return elementOrProxy;
	}

	protected Map<EObject, URI> createExportedElementsMap(Resource resource) {
		URI uri = EcoreUtil2.getPlatformResourceOrNormalizedURI(resource);
		IResourceServiceProvider resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(uri);
		if (resourceServiceProvider == null) {
			return Collections.emptyMap();
		}
		IResourceDescription.Manager resourceDescriptionManager = resourceServiceProvider.getResourceDescriptionManager();
		if (resourceDescriptionManager == null) {
			return Collections.emptyMap();
		}
		IResourceDescription resourceDescription = resourceDescriptionManager.getResourceDescription(resource);
		Map<EObject, URI> exportedElementMap = newIdentityHashMap();
		if (resourceDescription != null) {
			for (IEObjectDescription exportedEObjectDescription : resourceDescription.getExportedObjects()) {
				EObject eObject = resource.getEObject(exportedEObjectDescription.getEObjectURI().fragment());
				if (eObject != null)
					exportedElementMap.put(eObject, exportedEObjectDescription.getEObjectURI());
			}
		}
		return exportedElementMap;
	}
	
	public void findReferences(Set<URI> targetURIs, IResourceDescription resourceDescription, IAcceptor<IReferenceDescription> acceptor, ILocalResourceAccess localResourceAccess) {
		for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
			if (targetURIs.contains(referenceDescription.getTargetEObjectUri())) {
				acceptor.accept(referenceDescription);
			}
		}
	}

}
