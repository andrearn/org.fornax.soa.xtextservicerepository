package org.xkonnex.repo.dsl.basedsl.search;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.inject.ImplementedBy;

@ImplementedBy (EObjectLookup.class)
public interface IEObjectLookup {
	
	public <T> T  getModelElementByName (String elementName, Resource resource, String eClassName);
	public <T> T  getModelElementByNameAndVersion (String elementName, String version, Resource resource, String eClassName);
	public <T> T  getModelElementByName (String elementName, ResourceSet resourceSet, String eClassName);
	public <T> T  getModelElementByNameAndVersion (String elementName, String version, ResourceSet resourceSet, String eClassName);
	public EObject  getModelElementByURI (URI elementURI, ResourceSet resourceSet);
	public IEObjectDescription  getIEOBjectDescriptionByURI (URI eObjectURI, ResourceSet resourceSet);
	public EObject getVersionedOwner(EObject object);
	public EObject getStatefulOwner(EObject object);
	public <T> T getOwnerByType (EObject object, Class<T> clazz);
}
