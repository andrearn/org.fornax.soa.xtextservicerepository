package org.fornax.soa.basedsl.search;

import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;

public interface IPredicateSearch {

	public abstract Iterable<IEObjectDescription> search(
			Predicate<IEObjectDescription> predicate);

}