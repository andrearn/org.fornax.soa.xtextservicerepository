package org.xkonnex.repo.dsl.servicedsl.service.query;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.RequiredServiceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

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
	
	public List<EObject> findAllProvidingModules (final Service service) {
		final ResourceSet resourceSet = service.eResource().getResourceSet();
		Predicate<IReferenceDescription> predicate = new Predicate<IReferenceDescription> () {

			public boolean apply (final IReferenceDescription input) {
				if (input.getContainerEObjectURI () != null) {
					EObject sourceObj = objLookup.getModelElementByURI (input.getSourceEObjectUri (), resourceSet);
					if (sourceObj != null && (
							("ServiceRef".equals(sourceObj.eClass().getName()) && 
									"http://www.fornax.org/soa/moduledsl/ModuleDsl".equals (sourceObj.eClass().getEPackage().getNsURI())
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

	public List<EObject> findAllResourceConsumers (final Resource service) {
		final ResourceSet resourceSet = service.eResource().getResourceSet();
		Predicate<IReferenceDescription> predicate = new Predicate<IReferenceDescription> () {

			public boolean apply (final IReferenceDescription input) {
				if (input.getContainerEObjectURI () != null) {
					EObject sourceObj = objLookup.getModelElementByURI (input.getSourceEObjectUri (), resourceSet);
					if (sourceObj != null && (
							sourceObj instanceof RequiredServiceRef ||
							("ResourceRef".equals(sourceObj.eClass().getName()) && 
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
	
	public List<EObject> findAllProvidingModules (final Resource service) {
		final ResourceSet resourceSet = service.eResource().getResourceSet();
		Predicate<IReferenceDescription> predicate = new Predicate<IReferenceDescription> () {

			public boolean apply (final IReferenceDescription input) {
				if (input.getContainerEObjectURI () != null) {
					EObject sourceObj = objLookup.getModelElementByURI (input.getSourceEObjectUri (), resourceSet);
					if (sourceObj != null && (
							("ResourceRef".equals(sourceObj.eClass().getName()) && 
									"http://www.fornax.org/soa/moduledsl/ModuleDsl".equals (sourceObj.eClass().getEPackage().getNsURI())
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
