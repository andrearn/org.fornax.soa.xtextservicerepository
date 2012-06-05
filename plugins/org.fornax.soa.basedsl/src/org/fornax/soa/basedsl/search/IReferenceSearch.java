package org.fornax.soa.basedsl.search;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.fornax.soa.basedsl.resource.ILocalResourceAccess;

import com.google.common.base.Predicate;
import com.google.inject.ImplementedBy;

/*
 * Find references to an EObject via it's URI
 * derived from IReferenceFinder in Xtext UI
 */
@ImplementedBy (PredicateReferenceSearch.class)
public interface IReferenceSearch {


	interface IReferenceQueryData {
		URI getLeadElementURI();

		Set<URI> getTargetURIs();

		Predicate<IReferenceDescription> getResultFilter();

		URI getLocalContextResourceURI();
	}
	
	public abstract void findAllReferences (EObject eObject, ResourceSet resourceSet, Predicate<IReferenceDescription> referencePredicate, final IAcceptor<IReferenceDescription> acceptor);
	
	public abstract void findAllReferences (IEObjectDescription iEObjDesc, ResourceSet resourceSet, Predicate<IReferenceDescription> referencePredicate, final IAcceptor<IReferenceDescription> acceptor);

	public abstract void findLocalReferences (Set<? extends EObject> targets, IAcceptor<IReferenceDescription> acceptor,
			Predicate<IReferenceDescription> filter);

	public abstract void findLocalReferences (final IReferenceQueryData queryData, ILocalResourceAccess localResourceAccess,
			final IAcceptor<IReferenceDescription> acceptor);

	public abstract void findIndexedReferences (IReferenceQueryData queryData, URI resourceURI,
			IAcceptor<IReferenceDescription> acceptor);

	public abstract void findIndexedReferences (final IReferenceQueryData queryData, final IAcceptor<IReferenceDescription> acceptor);

	public abstract void findAllReferences (IReferenceQueryData queryData, ILocalResourceAccess localResourceAccess,
			final IAcceptor<IReferenceDescription> acceptor);
}
