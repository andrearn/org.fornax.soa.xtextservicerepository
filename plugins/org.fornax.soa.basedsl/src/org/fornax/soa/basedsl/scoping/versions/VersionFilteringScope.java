package org.fornax.soa.basedsl.scoping.versions;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Delayed;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.FilteringScope;

import com.google.common.collect.Lists;

public class VersionFilteringScope extends FilteringScope {

	
	private AbstractPredicateVersionFilter<IEObjectDescription> filter;
	private boolean ignoreCase;
	private IScope parent;

	public VersionFilteringScope(IScope delegate,
			AbstractPredicateVersionFilter <IEObjectDescription> filter, boolean ignoreCase) {
		super(delegate, filter);
		this.filter = filter;
		this.ignoreCase = ignoreCase;
		parent = delegate;
	}

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		return filter.getBestMatchByNames (super.getAllElements(), ignoreCase).values();
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		return filter.getBestMatchByNames (super.getElements(object), ignoreCase).values();
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		return filter.getBestMatchByNames (super.getElements(name), ignoreCase).values();
	}

	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		Iterable<IEObjectDescription> elements = getElements(object);
		List<IEObjectDescription> ieDesc = Lists.newArrayList (filter.getBestMatchByNames (elements, ignoreCase).values());
		return getFirst (ieDesc);
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		Iterable<IEObjectDescription> elements = getElements (name);
		List<IEObjectDescription> ieDesc = Lists.newArrayList (filter.getBestMatchByNames (elements, ignoreCase).values());
		return getFirst (ieDesc);
	}
	
	public IScope getParent () {
		return parent;
	}

}
