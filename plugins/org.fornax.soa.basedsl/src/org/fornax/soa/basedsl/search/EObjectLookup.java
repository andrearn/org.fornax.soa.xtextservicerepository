package org.fornax.soa.basedsl.search;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class EObjectLookup implements IEObjectLookup {
	
	@Inject IPredicateSearch searchEngine;

	@Inject
	private IResourceDescriptions resourceDescriptions;
	
	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;

	public <T> T getModelElementByName (final String elementName, final ResourceSet res, String eClassName) {
        List<IEObjectDescription> searchResult = Lists.newArrayList (searchEngine.search(elementName, SearchPattern.RULE_EXACT_MATCH, eClassName, Predicates.<IEObjectDescription>alwaysTrue()));
        if (searchResult.size () == 1) {
        	IEObjectDescription ieDesc = searchResult.get (0);
        	EObject obj = ieDesc.getEObjectOrProxy ();
        	if (obj.eIsProxy ()) {
				obj = EcoreUtil.resolve (obj, res);
			}
        	try {
        		T result  = (T)obj;
        		return result;
        	} catch (Exception ex) {
        		
        	}
        } else if (searchResult.size () > 1 && !elementName.contains("*")) {
        	for (IEObjectDescription ieDesc : searchResult) {
        		if (ieDesc.getQualifiedName().toString().equals(elementName)) {
	            	EObject obj = ieDesc.getEObjectOrProxy ();
	            	if (obj.eIsProxy ()) {
	    				obj = EcoreUtil.resolve (obj, res);
	    			}
	            	try {
	            		T result  = (T)obj;
	            		return result;
	            	} catch (Exception ex) {
	            		
	            	}
        		}
			}
        	
        }
        return null;
	}

	public <T> T getModelElementByNameAndVersion (final String elementName, final String version, ResourceSet res, String eClassName) {
        List<IEObjectDescription> searchResult = Lists.newArrayList (searchEngine.search(elementName, SearchPattern.RULE_EXACT_MATCH, eClassName, new Predicate<IEObjectDescription>() {

			public boolean apply (IEObjectDescription input) {
				String objVersion = input.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY);
				return version == null || version.equals (objVersion);
			}
        	
        }));
        if (searchResult.size () == 1) {
        	IEObjectDescription ieDesc = searchResult.get (0);
        	EObject obj = ieDesc.getEObjectOrProxy ();
        	if (obj.eIsProxy ()) {
				obj = EcoreUtil.resolve (obj, res);
			}
        	try {
        		T result  = (T)obj;
        		return result;
        	} catch (Exception ex) {
        		
        	}
        }
        return null;
	}

	public <T> T getModelElementByName(String elementName, Resource resource,
			String eClassName) {
		return getModelElementByName(elementName, resource.getResourceSet(), eClassName);
	}

	public <T> T getModelElementByNameAndVersion(String elementName,
			String version, Resource resource, String eClassName) {
		return getModelElementByNameAndVersion(elementName, version, resource.getResourceSet(), eClassName);
	}


	public EObject getModelElementByURI (URI eEObjectUri, ResourceSet resourceSet) {
		return resourceSet.getEObject(eEObjectUri, true);
	}

	public IEObjectDescription getIEOBjectDescriptionByURI (URI eObjectURI,
			ResourceSet resourceSet) {
		if (getResourceDescriptions() instanceof IResourceDescriptions.IContextAware)
			((IResourceDescriptions.IContextAware)getResourceDescriptions()).setContext (resourceSet);
		IResourceDescription resourceDescription = getResourceDescriptions().getResourceDescription(eObjectURI
				.trimFragment());
		IEObjectDescription ieObjDesc = null;
		if (resourceDescription != null) {
			for (IEObjectDescription eObjectDescription : resourceDescription.getExportedObjects()) {
				if (eObjectDescription.getEObjectURI().equals(eObjectURI)) {
					ieObjDesc = eObjectDescription;
					break;
				}
			}
		}
		return ieObjDesc;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getOwnerByType (EObject o, Class<T> c) {
		if (c.isInstance(o))
			return (T) o;
		while (o.eContainer() != null) {
			o = o.eContainer();
			if (c.isInstance(o))
				return (T) o;
		}
		return null;
	}
	
	public EObject getStatefulOwner (EObject o) {
		EStructuralFeature feature = o.eClass().getEStructuralFeature("state");
		if (feature != null) 
			return o;
		else if (o.eContainer() != null)
			return getStatefulOwner(o.eContainer());
		else
			return null;
	}
	
	public EObject getVersionedOwner (EObject o) {
		EStructuralFeature feature = o.eClass().getEStructuralFeature("version");
		if (feature != null) 
			return o;
		else if (o.eContainer() != null)
			return getStatefulOwner(o.eContainer());
		else
			return null;
	}

	public IResourceDescriptions getResourceDescriptions() {
		return resourceDescriptions;
	}

	public void setResourceDescriptions(IResourceDescriptions resourceDescriptions) {
		this.resourceDescriptions = resourceDescriptions;
	}

	public ResourceDescriptionsProvider getResourceDescriptionsProvider() {
		return resourceDescriptionsProvider;
	}

	public void setResourceDescriptionsProvider(
			ResourceDescriptionsProvider resourceDescriptionsProvider) {
		this.resourceDescriptionsProvider = resourceDescriptionsProvider;
	}

}
