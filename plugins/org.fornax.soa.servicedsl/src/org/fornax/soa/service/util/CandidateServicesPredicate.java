package org.fornax.soa.service.util;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.fornax.soa.serviceDsl.Service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class CandidateServicesPredicate implements Predicate<IEObjectDescription> {
	
	private final List<Service> candidates;
	private final ResourceSet context;
	
	@Inject
	private IQualifiedNameProvider nameProvider;

	public CandidateServicesPredicate(List<Service> candidates,
			ResourceSet context) {
		super();
		this.candidates = candidates;
		this.context = context;
	}

	public boolean apply(final IEObjectDescription input) {
		// TODO Auto-generated method stub
		final String version = input.getUserData(VersionedResourceDescriptionStrategy.VERSION_KEY);
		return Iterables.any(candidates, new Predicate<Service>(){

			public boolean apply(Service service) {
				try {
					String candVersion = service.getVersion().getVersion();
					return input.getQualifiedName().equals(getNameProvider().getFullyQualifiedName(service)) && version.equals(candVersion);
				} catch (Exception ex) {
					
				}
				return false;
			}
			
		} );
	}

	public IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}

	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

}
