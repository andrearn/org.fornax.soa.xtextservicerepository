package org.xkonnex.repo.dsl.basedsl.scoping.versions.filter;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;

public interface VersionFilter<T> extends Predicate<T> {
	
	public abstract boolean matches (IEObjectDescription description);
	public abstract Multimap<QualifiedName, IEObjectDescription> getBestMatchByNames(Iterable<IEObjectDescription> canditates, boolean ignoreCase);
	public abstract Multimap<QualifiedName, IEObjectDescription> getBestMatchByQualifiedNames(Iterable<IEObjectDescription> canditates, boolean ignoreCase);

}
