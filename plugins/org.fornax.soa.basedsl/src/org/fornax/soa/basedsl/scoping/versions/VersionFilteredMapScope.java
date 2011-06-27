package org.fornax.soa.basedsl.scoping.versions;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MultimapBasedScope;

import com.google.common.collect.Multimap;

public class VersionFilteredMapScope extends MultimapBasedScope {
	
	public static IScope createScope (IScope parent, Iterable<IEObjectDescription> descriptions, boolean ignoreCase, AbstractPredicateVersionFilter <IEObjectDescription> versionFilter) {
		Multimap<QualifiedName, IEObjectDescription> map = versionFilter.getBestMatchByNames (descriptions, ignoreCase);
		if (map == null || map.isEmpty()) {
			return parent;
		}
		return new VersionFilteredMapScope (parent, map, ignoreCase);
	}
	
	public static IScope createScope (IScope parent, Iterable<IEObjectDescription> descriptions, AbstractPredicateVersionFilter <IEObjectDescription> versionFilter) {
		return createScope(parent, descriptions, false, versionFilter);
	}
	
	protected VersionFilteredMapScope (IScope parent, Multimap<QualifiedName, IEObjectDescription> elements, boolean ignoreCase) {
		super(parent, elements, ignoreCase);
	}

}
