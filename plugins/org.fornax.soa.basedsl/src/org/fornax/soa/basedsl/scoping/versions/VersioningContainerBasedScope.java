package org.fornax.soa.basedsl.scoping.versions;

import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.fornax.soa.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.NullVersionFilter;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;

public class VersioningContainerBasedScope extends SelectableBasedScope {
	
	public static IScope createScope(IScope outer, ISelectable selectable, EClass type, boolean ignoreCase) {
		return createScope(outer, selectable, null, type, ignoreCase);
	}
	
	public static IScope createScope(IScope outer, ISelectable selectable, Predicate<IEObjectDescription> filter, EClass type, boolean ignoreCase) {
		if (selectable == null || selectable.isEmpty())
			return outer;
		return new VersioningContainerBasedScope(outer, selectable, filter, type, ignoreCase);
	}
	
	protected VersioningContainerBasedScope (IScope outer, ISelectable selectable, Predicate<IEObjectDescription> filter, EClass type, boolean ignoreCase) {
		super(outer, selectable, filter, type, ignoreCase);
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(final QualifiedName name) {
		if (getFilter() instanceof AbstractPredicateVersionFilter && !(getFilter() instanceof NullVersionFilter)) {
			Iterable<IEObjectDescription> localElementsByName = super.getLocalElementsByName (name);
			Multimap<QualifiedName, IEObjectDescription> descriptions = ((AbstractPredicateVersionFilter<IEObjectDescription>) getFilter()).getBestMatchByNames (localElementsByName, isIgnoreCase());
			if (isIgnoreCase()) 
				return descriptions.get (name.toLowerCase());
			else
				return descriptions.get (name);
		} else {
			return super.getLocalElementsByName (name);
		}
	}
	
	protected Iterable<IEObjectDescription> filterLocalElements(Iterable<IEObjectDescription> unfiltered) {
		if (getFilter() != null) {
			Iterable<IEObjectDescription> result = Iterables.filter(unfiltered, getFilter());
			return result;
		}
		return unfiltered;
	}

}
