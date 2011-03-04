package org.fornax.soa.basedsl.scoping.versions;

import java.util.Map;

import org.eclipse.xtext.resource.IEObjectDescription;

public interface VersionFilter {
	
	public final static VersionFilter NULL_VERSION_FILTER = new NullVersionFilter();
	
	public abstract boolean matches (IEObjectDescription description);
	public abstract Map<String, IEObjectDescription> getBestMatchByNames(Iterable<IEObjectDescription> canditates);
	public abstract Map<String, IEObjectDescription> getBestMatchByQualifedNames(Iterable<IEObjectDescription> canditates);

}
