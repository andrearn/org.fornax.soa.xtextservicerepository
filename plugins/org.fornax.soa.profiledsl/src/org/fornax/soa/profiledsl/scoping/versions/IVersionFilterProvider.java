package org.fornax.soa.profiledsl.scoping.versions;

import java.util.List;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.scoping.versions.filter.VersionFilter;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

import com.google.common.base.Predicate;

public interface IVersionFilterProvider<T> {
	
	public VersionFilter<T> createVersionFilter(final VersionRef v, LifecycleState minState);
	
	public VersionFilter<T> createVersionFilter(final VersionRef v);
	
	public VersionFilter<T> createVersionFilter(final VersionRef v, LifecycleState minState, Predicate<IEObjectDescription> preFilterPredicate);
	
	public VersionFilter<T> createVersionFilter(final VersionRef v, Predicate<IEObjectDescription> preFilterPredicate);
	
}
