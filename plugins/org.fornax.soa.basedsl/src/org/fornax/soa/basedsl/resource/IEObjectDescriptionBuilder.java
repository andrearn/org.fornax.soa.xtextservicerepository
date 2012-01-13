package org.fornax.soa.basedsl.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;

public interface IEObjectDescriptionBuilder {

	public static final String STATE_KEY = "state";
	public static final String VERSION_KEY = "version";

	public abstract IEObjectDescription buildDescription(EObject eObject);

}