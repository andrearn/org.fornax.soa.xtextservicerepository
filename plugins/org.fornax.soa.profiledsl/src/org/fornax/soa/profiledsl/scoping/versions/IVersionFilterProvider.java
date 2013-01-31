package org.fornax.soa.profiledsl.scoping.versions;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.scoping.versions.VersionFilter;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

public interface IVersionFilterProvider<T> {
	
	public VersionFilter<T> createVersionFilter(final VersionRef v, LifecycleState minState);
	
	public VersionFilter<T> createVersionFilter(final VersionRef v);
}
