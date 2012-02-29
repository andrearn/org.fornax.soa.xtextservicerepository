package org.fornax.soa.basedsl.search;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class EObjectLookup implements IEObjectLookup {
	
	@Inject IPredicateSearch searchEngine;

	public <T> T getModelElementByName (final String elementName, final Resource res, String eClassName) {
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

	public <T> T getModelElementByNameAndVersion (final String elementName, final String version, Resource res, String eClassName) {
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

}
