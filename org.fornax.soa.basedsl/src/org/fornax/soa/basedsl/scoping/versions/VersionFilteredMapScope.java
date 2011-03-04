package org.fornax.soa.basedsl.scoping.versions;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;

public class VersionFilteredMapScope extends AbstractScope {
	private IScope parent;
	private VersionFilter filter;
	private Map<String, IEObjectDescription> descriptions ;
	
	public VersionFilteredMapScope(IScope parent, Map<String, IEObjectDescription> descriptions) {
		this.parent = parent;
		this.descriptions = descriptions;
		this.filter = VersionFilter.NULL_VERSION_FILTER;
	}
	public VersionFilteredMapScope(IScope parent, Map<String, IEObjectDescription> descriptions, VersionFilter filter) {
		this.parent = parent;
		this.descriptions = descriptions;
		this.filter = filter;
	}
	public VersionFilteredMapScope(IScope parent, List<IEObjectDescription> descriptions, VersionFilter filter) {
		this.parent = parent;
		this.descriptions = filter.getBestMatchByNames(descriptions);
		this.filter = filter;
	}

	@Override
	protected Iterable<IEObjectDescription> internalGetContents() {
		return descriptions.values();
	}

	@Override
	public IEObjectDescription getContentByName(String name) {
		IEObjectDescription ieObjectDescription = getContentByNameImpl(name);
		return ieObjectDescription!=null ? ieObjectDescription : parent.getContentByName(name);
	}

	protected IEObjectDescription getContentByNameImpl(String name) {
		return descriptions.get(name);
	}

	public IScope getOuterScope() {
		return parent;
	}

	@Override
	public String toString() {
		return "contains "+descriptions.size()+" elements";
	}

}
