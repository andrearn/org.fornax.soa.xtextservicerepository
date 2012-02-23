package org.fornax.soa.basedsl.search;

import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;

public interface IPredicateSearch {
	
	public static final String DEFAULT_NAMESPACE_DELIMITER = ".";

	public abstract Iterable<IEObjectDescription> search(
			Predicate<IEObjectDescription> predicate);

}