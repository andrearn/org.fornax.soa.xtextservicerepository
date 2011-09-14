package org.fornax.soa.basedsl.search;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class PredicateSearch implements IPredicateSearch {
	
	@Inject
	private IResourceDescriptions resourceDescriptions;
	
	/* (non-Javadoc)
	 * @see org.fornax.soa.basedsl.search.IPredicateSearch#search(com.google.common.base.Predicate)
	 */
	public Iterable<IEObjectDescription> search (Predicate<IEObjectDescription> predicate) {
		return Iterables.filter(getSearchScope(), predicate);
	}
	
	protected Iterable<IEObjectDescription> getSearchScope() {
		return Iterables.concat(Iterables.transform(getResourceDescriptions().getAllResourceDescriptions(),
				new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
					public Iterable<IEObjectDescription> apply(IResourceDescription from) {
						return from.getExportedObjects();
					}
				}));
	}

	public void setResourceDescriptions(IResourceDescriptions resourceDescriptions) {
		this.resourceDescriptions = resourceDescriptions;
	}

	public IResourceDescriptions getResourceDescriptions() {
		return resourceDescriptions;
	}
}
