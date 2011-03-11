package org.fornax.soa.basedsl.scoping.versions;

import org.eclipse.xtext.resource.IEObjectDescription;

public interface VersionResolver {
	
	public abstract String getVersion (IEObjectDescription desc);

}
