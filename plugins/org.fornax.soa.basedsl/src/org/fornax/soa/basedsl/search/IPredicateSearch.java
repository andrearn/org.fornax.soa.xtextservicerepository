package org.fornax.soa.basedsl.search;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;

public interface IPredicateSearch {
	
	public static final String DEFAULT_NAMESPACE_DELIMITER = ".";

	public abstract Iterable<IEObjectDescription> search(
			Predicate<IEObjectDescription> predicate);

	public abstract Iterable<IEObjectDescription> search (
			final String searchPattern, final String typeSearchPattern,
			Predicate<IEObjectDescription> predicate);

	public abstract Iterable<IEObjectDescription> search (
			final String searchPattern, final String typeSearchPattern,
			Predicate<IEObjectDescription> predicate, ResourceSet resourceSet);
	
	public abstract Iterable<IEObjectDescription> search (
			final String searchPattern, int allowedSearchRules, final String typeSearchPattern,
			Predicate<IEObjectDescription> predicate);
	
	public abstract Iterable<IEObjectDescription> search (
			final String searchPattern, int allowedSearchRules, final String typeSearchPattern,
			Predicate<IEObjectDescription> predicate, ResourceSet resourceSet);

	public abstract Iterable<IEObjectDescription> search (
			final String typeSearchPattern,
			Predicate<IEObjectDescription> predicate);

	public abstract Iterable<IEObjectDescription> search (
			final String typeSearchPattern,
			Predicate<IEObjectDescription> predicate, ResourceSet resourceSet);

}