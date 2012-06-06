package org.fornax.soa.basedsl.search;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.fornax.soa.basedsl.resource.ILocalResourceAccess;
import org.fornax.soa.basedsl.resource.SimpleLocalResourceAccess;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

import static java.util.Collections.singleton;

public class PredicateReferenceSearch implements IReferenceSearch {

	private IResourceDescriptions index;
	private IEObjectLookup ieObjLookup;

	@Inject
	public PredicateReferenceSearch (IResourceDescriptions index, IEObjectLookup ieObjLookup) {
		this.index = index;
		this.ieObjLookup = ieObjLookup;
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
		if (!queryData.getTargetURIs().isEmpty()) {
			findLocalReferences(queryData, localResourceAccess, acceptor);
			findIndexedReferences(queryData, resourceSet, acceptor);
		}
	}

	public void findIndexedReferences(final IReferenceQueryData queryData, ResourceSet resourceSet, final IAcceptor<IReferenceDescription> acceptor) {
		findIndexedReferences(queryData.getTargetURIs(), acceptor, queryData.getResultFilter());
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
		localResourceAccess.readOnly(queryData.getLocalContextResourceURI(), new IUnitOfWork<Boolean, ResourceSet>() {
			public Boolean exec(ResourceSet localContext) throws Exception {
				Set<EObject> targets = newHashSet();
				for (URI targetURI : queryData.getTargetURIs()) {
					EObject target = localContext.getEObject(targetURI, true);
					if (target != null)
						targets.add(target);
				}
				findLocalReferences(targets, acceptor, queryData.getResultFilter());
				return true;
			}
		});
	}

	public void findLocalReferences(Set<? extends EObject> targets, IAcceptor<IReferenceDescription> acceptor,
			Predicate<IReferenceDescription> filter) {
		if (targets != null && !targets.isEmpty()) {
			Set<Resource> targetResources = new HashSet<Resource>();
			for (EObject target : targets) {
				targetResources.add(target.eResource());
			}
			Map<EObject, Collection<Setting>> targetResourceInternalCrossRefs = CrossReferencer.find(targetResources);
			Map<EObject, URI> exportedElementsMap = null;
			for (EObject target : targets) {
				Collection<Setting> crossRefSettings = targetResourceInternalCrossRefs.get(target);
				if (crossRefSettings != null) {
					for (Setting crossRefSetting : crossRefSettings) {
						EObject source = crossRefSetting.getEObject();
						if (crossRefSetting.getEStructuralFeature() instanceof EReference) {
							EReference reference = (EReference) crossRefSetting.getEStructuralFeature();
							int index = 0;
							if (reference.isMany()) {
								List<?> values = (List<?>) source.eGet(reference);
								for (int i = 0; i < values.size(); ++i) {
									if (target == values.get(i)) {
										index = i;
										break;
									}
								}
							}
							if (exportedElementsMap == null)
								exportedElementsMap = createExportedElementsMap(target.eResource());
							IReferenceDescription localReferenceDescription = new DefaultReferenceDescription(source,
									target, reference, index, findClosestExportedContainerURI(source,
											exportedElementsMap));
							if (filter == null || filter.apply(localReferenceDescription))
								acceptor.accept(localReferenceDescription);
						}
					}
				}
			}
		}
	}

	protected Map<EObject, URI> createExportedElementsMap(Resource resource) {
		if (index instanceof ResourceSetBasedResourceDescriptions)
			((ResourceSetBasedResourceDescriptions)index).setContext (resource.getResourceSet ());
		IResourceDescription resourceDescription = index.getResourceDescription(EcoreUtil2.getNormalizedURI(resource));
		Map<EObject, URI> exportedElementMap = newHashMap();
		if (resourceDescription != null) {
			for (IEObjectDescription exportedEObjectDescription : resourceDescription.getExportedObjects()) {
				EObject eObject = resource.getEObject(exportedEObjectDescription.getEObjectURI().fragment());
				if (eObject != null)
					exportedElementMap.put(eObject, exportedEObjectDescription.getEObjectURI());
			}
		}
		return exportedElementMap;
	}

	protected URI findClosestExportedContainerURI(EObject element, Map<EObject, URI> exportedElementsMap) {
		EObject current = element;
		while (current != null) {
			URI uri = exportedElementsMap.get(current);
			if (uri != null)
				return uri;
			current = current.eContainer();
		}
		return null;
	}

	protected void findIndexedReferences(Set<URI> targetURIs, IAcceptor<IReferenceDescription> acceptor,
			Predicate<IReferenceDescription> filter) {
		Set<URI> targetResourceURIs = newHashSet(transform(targetURIs, new Function<URI, URI>() {
			public URI apply(URI from) {
				return from.trimFragment();
			}
		}));
		int numResources = Iterables.size(index.getAllResourceDescriptions());
		for (IResourceDescription resourceDescription : index.getAllResourceDescriptions()) {
			if (!targetResourceURIs.contains(resourceDescription.getURI())) {
				for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
					if (targetURIs.contains(referenceDescription.getTargetEObjectUri())
							&& (filter == null || filter.apply(referenceDescription))) {
						acceptor.accept(referenceDescription);
					}
				}
			}
		}
	}

}
