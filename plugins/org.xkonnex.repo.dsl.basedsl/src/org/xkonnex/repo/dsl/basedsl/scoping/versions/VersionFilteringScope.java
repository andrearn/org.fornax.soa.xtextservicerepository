package org.xkonnex.repo.dsl.basedsl.scoping.versions;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;

import com.google.common.collect.Lists;

public class VersionFilteringScope extends FilteringScope {

	
	private AbstractPredicateVersionFilter<IEObjectDescription> versionFilter;
	private boolean ignoreCase;
	private IScope parent;

	public VersionFilteringScope(IScope delegate,
			AbstractPredicateVersionFilter <IEObjectDescription> filter, boolean ignoreCase) {
		super(delegate, filter);
		this.versionFilter = filter;
		this.ignoreCase = ignoreCase;
		parent = delegate;
	}

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		return versionFilter.getBestMatchByNames (super.getAllElements(), ignoreCase).values();
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		return versionFilter.getBestMatchByNames (super.getElements(object), ignoreCase).values();
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		return versionFilter.getBestMatchByNames (super.getElements(name), ignoreCase).values();
	}

	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		Iterable<IEObjectDescription> elements = getElements(object);
		List<IEObjectDescription> ieDesc = Lists.newArrayList (versionFilter.getBestMatchByNames (elements, ignoreCase).values());
		return getFirst (ieDesc);
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		Iterable<IEObjectDescription> elements = getElements (name);
		List<IEObjectDescription> ieDesc = Lists.newArrayList (versionFilter.getBestMatchByNames (elements, ignoreCase).values());
		return getFirst (ieDesc);
	}
	
	public IScope getParent () {
		return parent;
	}

}
