package org.fornax.soa.basedsl.scoping.versions;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;

public interface VersionFilter<T> extends Predicate<T> {
	
	public abstract boolean matches (IEObjectDescription description);
	public abstract Multimap<QualifiedName, IEObjectDescription> getBestMatchByNames(Iterable<IEObjectDescription> canditates, boolean ignoreCase);
	public abstract Multimap<QualifiedName, IEObjectDescription> getBestMatchByQualifedNames(Iterable<IEObjectDescription> canditates, boolean ignoreCase);

}
