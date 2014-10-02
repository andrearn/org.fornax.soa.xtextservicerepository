package org.xkonnex.repo.dsl.servicedsl.service.query.type;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.DataType;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.DataTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

public class TypeQueriesInternal {
	
	@Inject
	private IReferenceSearch refSearch;
	
	@Inject 
	private IEObjectLookup objLookup;
	
	public List<EObject> findReferrers (final DataType type) {
		final List<EObject> referrers = new ArrayList<EObject>();
		IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
			public void accept(IReferenceDescription referenceDescription) {
				EObject ref = objLookup.getModelElementByURI (referenceDescription.getSourceEObjectUri(), type.eResource().getResourceSet());
				if (ref instanceof DataTypeRef && !(ref.eContainer() instanceof Property)) {
					referrers.add (objLookup.getOwnerByType(ref, Property.class));
				} else if (ref instanceof DataTypeRef && ref.eContainer() instanceof Parameter) {
					referrers.add (ref.eContainer());
				} else {
					referrers.add (ref);
				}
			}
		};
		Predicate<IReferenceDescription> refPredicate = new Predicate<IReferenceDescription>() {

			public boolean apply(IReferenceDescription input) {
				EObject currentRef = input.getEReference().eContainer();
				if (currentRef instanceof Parameter || currentRef instanceof DataTypeRef) {
					return true;
				}
				return false;
			}
			
		};
		refSearch.findAllReferences(type, type.eResource().getResourceSet(), refPredicate, acceptor);
		return referrers;
	}
	
	public List<EObject> findReferrers (final Enumeration type) {
		final List<EObject> referrers = new ArrayList<EObject>();
		IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
			public void accept(IReferenceDescription referenceDescription) {
				EObject ref = objLookup.getModelElementByURI (referenceDescription.getSourceEObjectUri(), type.eResource().getResourceSet());
				if (ref instanceof DataTypeRef && !(ref.eContainer() instanceof Property)) {
					referrers.add (objLookup.getOwnerByType(ref, Property.class));
				} else if (ref instanceof DataTypeRef && ref.eContainer() instanceof Parameter) {
					referrers.add (ref.eContainer());
				} else {
					referrers.add (ref);
				}
			}
		};
		Predicate<IReferenceDescription> refPredicate = new Predicate<IReferenceDescription>() {

			public boolean apply(IReferenceDescription input) {
				EObject currentRef = input.getEReference().eContainer();
				if (currentRef instanceof Parameter || currentRef instanceof Property) {
					return true;
				}
				return false;
			}
			
		};
		refSearch.findAllReferences(type, type.eResource().getResourceSet(), refPredicate, acceptor);
		return referrers;
	}


}
