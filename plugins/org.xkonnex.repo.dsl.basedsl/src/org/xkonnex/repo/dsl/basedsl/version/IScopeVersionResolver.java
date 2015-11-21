package org.xkonnex.repo.dsl.basedsl.version;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version;

public interface IScopeVersionResolver {

	public abstract Version getVersion(IEObjectDescription desc);
	
	public abstract String getVersionAsString (IEObjectDescription desc);
	
	public abstract Version getVersion(EObject o);

	public abstract String getVersionAsString(EObject o);

}
