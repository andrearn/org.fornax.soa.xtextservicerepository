package org.xkonnex.repo.dsl.basedsl.search;

import static java.util.Collections.singleton;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch.IReferenceQueryData;

import com.google.common.base.Predicate;

public class ReferenceQueryData implements IReferenceQueryData {
	
	private URI localContextResourceURI;
	private URI leadElementURI;
	private Set<URI> targetURIs;
	private Predicate<IReferenceDescription> resultFilter;
	private String label;

	public ReferenceQueryData(URI targetURI) {
		this(targetURI, singleton(targetURI), targetURI.trimFragment(), null);
	}
	
	public ReferenceQueryData(URI leadElementURI, Set<URI> targetURIs, URI localContextResourceURI,
			Predicate<IReferenceDescription> resultFilter) {
		this.leadElementURI = leadElementURI;
		this.targetURIs = targetURIs;
		this.localContextResourceURI = localContextResourceURI;
		this.resultFilter = resultFilter;
		this.label = label;
	}

	public URI getLeadElementURI() {
		return leadElementURI;
	}

	public Set<URI> getTargetURIs() {
		return targetURIs;
	}

	public Predicate<IReferenceDescription> getResultFilter() {
		return resultFilter;
	}

	public URI getLocalContextResourceURI() {
		return localContextResourceURI.trimFragment();
	}
}