package org.fornax.soa.service.query;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.search.IReferenceSearch;
import org.fornax.soa.serviceDsl.RequiredServiceRef;
import org.fornax.soa.serviceDsl.Service;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

class ServiceQueriesInternal {
	@Inject
	private IEObjectLookup objLookup;
	@Inject
	private IReferenceSearch refSearch;

	public List<EObject> findAllServiceConsumers (final Service service) {
		final ResourceSet resourceSet = service.eResource().getResourceSet();
		Predicate<IReferenceDescription> predicate = new Predicate<IReferenceDescription> () {

			public boolean apply (final IReferenceDescription input) {
				if (input.getContainerEObjectURI () != null) {
					IEObjectDescription sourceObjDesc = objLookup.getIEOBjectDescriptionByURI (input.getSourceEObjectUri(), resourceSet);
					EObject sourceObj = objLookup.getModelElementByURI (input.getSourceEObjectUri (), resourceSet);
					if (sourceObj != null && (
							sourceObj instanceof RequiredServiceRef ||
							("ServiceRef".equals(sourceObj.eClass().getName()) && 
									"http://www.fornax.org/soa/SolutionDsl".equals (sourceObj.eClass().getEPackage().getNsURI())
							)
						))
						return true;
					
					else
						return false;
				} else {
					return false;
				}
			}
			
		};
		final List<EObject> consumers = new ArrayList<EObject>();
		IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
			public void accept(IReferenceDescription referenceDescription) {
				EObject consumerDesc = objLookup.getModelElementByURI (referenceDescription.getSourceEObjectUri(), service.eResource().getResourceSet());
				consumers.add (consumerDesc);
			}
		};
		refSearch.findAllReferences(service, service.eResource().getResourceSet(), predicate, acceptor);
		return consumers;
	}

}
