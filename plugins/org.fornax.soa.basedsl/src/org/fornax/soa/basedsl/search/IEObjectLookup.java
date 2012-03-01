package org.fornax.soa.basedsl.search;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;

@ImplementedBy (EObjectLookup.class)
public interface IEObjectLookup {
	
	public <T> T  getModelElementByName (String elementName, Resource resource, String eClassName);
	public <T> T  getModelElementByNameAndVersion (String elementName, String version, Resource resource, String eClassName);
	
}