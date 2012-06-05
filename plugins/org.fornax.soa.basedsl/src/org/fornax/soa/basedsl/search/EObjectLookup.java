package org.fornax.soa.basedsl.search;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class EObjectLookup implements IEObjectLookup {
	
	@Inject IPredicateSearch searchEngine;

	@Inject
	private IResourceDescriptions resourceDescriptions;

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


	public EObject getModelElementByURI (URI elementURI, ResourceSet resourceSet) {
		IEObjectDescription ieObjDesc = getIEOBjectDescriptionByURI (elementURI, resourceSet);
		if (ieObjDesc != null) {
			EObject eObjectOrProxy = ieObjDesc.getEObjectOrProxy ();
			if (eObjectOrProxy.eIsProxy ()) {
				eObjectOrProxy = EcoreUtil.resolve (eObjectOrProxy, resourceSet);
			}
			
			return eObjectOrProxy;
		}
		return null;
	}

	public IEObjectDescription getIEOBjectDescriptionByURI (URI eObjectURI,
			ResourceSet resourceSet) {
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(eObjectURI
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

}
