package org.fornax.soa.basedsl.search;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class DefaultPredicateSearch implements IPredicateSearch {

	
	private static final String XSR_ASSETTYPE_PREFIX = "org.fornax.soa";

	@Inject
	private IResourceDescriptions resourceDescriptions;
	
	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	public Iterable<IEObjectDescription> search (Predicate<IEObjectDescription> predicate) {
		return Iterables.filter (getSearchScope (), predicate);
	}

	public Iterable<IEObjectDescription> search (final String typeSearchPattern, Predicate<IEObjectDescription> predicate) {
		return Iterables.filter (getSearchScope (),getSearchPredicate (typeSearchPattern, predicate));
	}

	public Iterable<IEObjectDescription> search (
			final String searchPattern, final String typeSearchPattern, Predicate<IEObjectDescription> predicate) {
		int allowedSearchRules = SearchPattern.RULE_BLANK_MATCH
				| SearchPattern.RULE_CAMELCASE_MATCH
				| SearchPattern.RULE_CASE_SENSITIVE
				| SearchPattern.RULE_EXACT_MATCH
				| SearchPattern.RULE_PATTERN_MATCH
				| SearchPattern.RULE_PREFIX_MATCH;
		return Iterables.filter (getSearchScope (),
				getSearchPredicate (searchPattern, allowedSearchRules, typeSearchPattern, predicate));
	}
	
	public Iterable<IEObjectDescription> search (
			final String searchPattern, int allowedSearchRules, final String typeSearchPattern, Predicate<IEObjectDescription> predicate) {
		return Iterables.filter (getSearchScope (),
				getSearchPredicate (searchPattern, allowedSearchRules, typeSearchPattern, predicate));
	}
	
	public Iterable<IEObjectDescription> search (
			final String searchPattern, int allowedSearchRules, final String typeSearchPattern, Predicate<IEObjectDescription> predicate, ResourceSet resourceSet) {
		return Iterables.filter (getSearchScope (resourceSet),
				getSearchPredicate (searchPattern, allowedSearchRules, typeSearchPattern, predicate));
	}
	

	protected Predicate<IEObjectDescription> getSearchPredicate (final String typeStringPattern, final Predicate<IEObjectDescription> predicate) {
		final Collection<String> namespaceDelimiters = Sets.newHashSet (DEFAULT_NAMESPACE_DELIMITER);
		final SearchPattern typeSearchPattern = new SearchPattern ();
		typeSearchPattern.setPattern (typeStringPattern);
		return new Predicate<IEObjectDescription> () {
			
			public boolean apply (IEObjectDescription input) {
				if (typeSearchPattern.matches (input.getEClass ().getName ()) 
						&& input.getEObjectOrProxy().getClass().getCanonicalName().startsWith (XSR_ASSETTYPE_PREFIX)) {
					return predicate.apply (input);
				}
				return false;
			}
		};
	}
	
	protected Predicate<IEObjectDescription> getSearchPredicate (
			final String stringPattern, int allowedSearchRules, final String typeStringPattern, final Predicate<IEObjectDescription> predicate) {
		final Collection<String> namespaceDelimiters = Sets.newHashSet (DEFAULT_NAMESPACE_DELIMITER);
		final SearchPattern searchPattern = new SearchPattern ();
		searchPattern.setPattern (stringPattern);
		final SearchPattern typeSearchPattern = new SearchPattern ();
		typeSearchPattern.setPattern (typeStringPattern);
		return new Predicate<IEObjectDescription> () {
		
			public boolean apply (IEObjectDescription input) {
				if (isNameMatches (searchPattern, input, namespaceDelimiters)
						&& typeSearchPattern.matches (input.getEClass ()
								.getName ())
						&& input.getEObjectOrProxy().getClass().getCanonicalName().startsWith (XSR_ASSETTYPE_PREFIX)) {
					return predicate.apply (input);
				}
				return false;
			}
		};
	}

	protected boolean isNameMatches (SearchPattern searchPattern,
			IEObjectDescription eObjectDescription,
			Collection<String> namespaceDelimiters) {
		String qualifiedName = qualifiedNameConverter
				.toString (eObjectDescription.getQualifiedName ());
		if (qualifiedName != null) {
			if (searchPattern.matches (qualifiedName)) {
				return true;
			}
			for (String namespaceDelimiter : namespaceDelimiters) {
				int index = qualifiedName.lastIndexOf (namespaceDelimiter);
				if (index != -1
						&& searchPattern.matches (qualifiedName
								.substring (index + 1))) {
					return true;
				}
			}
		}
		return false;
	}

	protected Iterable<IEObjectDescription> getSearchScope () {
		return Iterables
				.concat (Iterables
						.transform (
								getResourceDescriptions ()
										.getAllResourceDescriptions (),
								new Function<IResourceDescription, Iterable<IEObjectDescription>> () {
									public Iterable<IEObjectDescription> apply (
											IResourceDescription from) {
										return from.getExportedObjects ();
									}
								}));
	}
	
	protected Iterable<IEObjectDescription> getSearchScope (ResourceSet resourceSet) {
		return Iterables
				.concat (Iterables
						.transform (
								getResourceDescriptionsProvider().getResourceDescriptions (resourceSet)
										.getAllResourceDescriptions (),
								new Function<IResourceDescription, Iterable<IEObjectDescription>> () {
									public Iterable<IEObjectDescription> apply (
											IResourceDescription from) {
										return from.getExportedObjects ();
									}
								}));
	}

	public Iterable<IEObjectDescription> search(String searchPattern,
			String typeSearchPattern, Predicate<IEObjectDescription> predicate,
			ResourceSet resourceSet) {
		int allowedSearchRules = SearchPattern.RULE_BLANK_MATCH
				| SearchPattern.RULE_CAMELCASE_MATCH
				| SearchPattern.RULE_CASE_SENSITIVE
				| SearchPattern.RULE_EXACT_MATCH
				| SearchPattern.RULE_PATTERN_MATCH
				| SearchPattern.RULE_PREFIX_MATCH;
		return Iterables.filter (getSearchScope (resourceSet),
				getSearchPredicate (searchPattern, allowedSearchRules, typeSearchPattern, predicate));
	}

	public Iterable<IEObjectDescription> search(String typeSearchPattern,
			Predicate<IEObjectDescription> predicate, ResourceSet resourceSet) {
		return Iterables.filter (getSearchScope (resourceSet),getSearchPredicate (typeSearchPattern, predicate));
	}

	public void setResourceDescriptions (
			IResourceDescriptions resourceDescriptions) {
		this.resourceDescriptions = resourceDescriptions;
	}

	public IResourceDescriptions getResourceDescriptions () {
		return resourceDescriptions;
	}

	public ResourceDescriptionsProvider getResourceDescriptionsProvider() {
		return resourceDescriptionsProvider;
	}

	public void setResourceDescriptionsProvider(
			ResourceDescriptionsProvider resourceDescriptionsProvider) {
		this.resourceDescriptionsProvider = resourceDescriptionsProvider;
	}

}
