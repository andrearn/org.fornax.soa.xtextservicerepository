package org.fornax.soa.basedsl.scoping.versions.filter;

import java.util.Collection;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;

public abstract class AbstractPredicateVersionFilter<T> implements VersionFilter<T>,
		Predicate<T> {
	
	private Predicate<T> preFilterPredicate;

	public final static AbstractPredicateVersionFilter<IEObjectDescription> NULL_VERSION_FILTER = new NullVersionFilter<IEObjectDescription>();

	public boolean apply(T input) {
		if (getPreFilterPredicate() != null)
			return getPreFilterPredicate().apply(input);
		else
			return true;
	}
	
	protected IEObjectDescription getCurrentBestMatch (final Multimap<QualifiedName, IEObjectDescription> canditates, final QualifiedName name) {
		Collection<IEObjectDescription> candList = canditates.get (name);
		if (candList != null && !candList.isEmpty()) {
			return canditates.get (name).iterator().next();
		}
		return null;
	}

	public Predicate<T> getPreFilterPredicate() {
		return preFilterPredicate;
	}

	public void setPreFilterPredicate(Predicate<T> preFilterPredicate) {
		this.preFilterPredicate = preFilterPredicate;
	}


}
