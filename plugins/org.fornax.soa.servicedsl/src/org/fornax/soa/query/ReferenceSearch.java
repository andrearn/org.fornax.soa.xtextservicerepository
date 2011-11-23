package org.fornax.soa.query;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class ReferenceSearch {
	
	@Inject
	private IResourceDescriptions resourceDescriptions;

	public List<IReferenceDescription> findReferences (EObject o) {
		final URI eObjectTargetURI = EcoreUtil.getURI(o);
		List<IReferenceDescription> searchResult = new ArrayList<IReferenceDescription>();
		for (IResourceDescription resourceDescription : resourceDescriptions.getAllResourceDescriptions()) {
			Iterable<IReferenceDescription> matchingReferenceDescriptors = Iterables.filter (resourceDescription
					.getReferenceDescriptions(), new Predicate<IReferenceDescription>() {
				
				public boolean apply(IReferenceDescription input) {
					return eObjectTargetURI.equals (input.getTargetEObjectUri());
				}
				
			});
			for (IReferenceDescription matchingReferenceDescription : matchingReferenceDescriptors) {
				searchResult.add (matchingReferenceDescription);
			}
		}
		return searchResult;
	}
}
