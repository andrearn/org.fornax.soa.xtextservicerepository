package org.xkonnex.repo.dsl.profiledsl.scoping.versions;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.VersionFilter;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;

import com.google.common.base.Predicate;

public interface IVersionFilterProvider<T> {
	
	public VersionFilter<T> createVersionFilter(final VersionRef v, LifecycleState minState);
	
	public VersionFilter<T> createVersionFilter(final VersionRef v);
	
	public VersionFilter<T> createVersionFilter(final VersionRef v, LifecycleState minState, Predicate<IEObjectDescription> preFilterPredicate);
	
	public VersionFilter<T> createVersionFilter(final VersionRef v, Predicate<IEObjectDescription> preFilterPredicate);
	
}
