package org.fornax.soa.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.profiledsl.util.ReferencedStateChecker;
import org.fornax.soa.service.query.VersionedObjectQueryHelper;
import org.fornax.soa.service.util.ServiceDslElementAccessor;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

import com.google.inject.Inject;

public class LifecycleStatefulReferenceValidator extends AbstractPluggableDeclarativeValidator {

	@Inject ReferencedStateChecker referencedStateChecker;
	@Inject IStateMatcher stateMatcher;
	@Inject LifecycleStateComparator stateComparator;
	@Inject IEObjectLookup objLookup;

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.fornax.soa.serviceDsl.ServiceDslPackage.eINSTANCE);
		return result;
	}

	@Check
	public void checkDoesNotRefRetiredService(ServiceRef svcRef) {
		EObject owner = objLookup.getVersionedOwner(svcRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && stateRes.definesState(owner) && ownerState.isIsEnd() 
				&& svcRef.getService().getState().isIsEnd()) 
			error ("A service in state " + ownerState.getName() + " cannot be referenced", ServiceDslPackage.Literals.SERVICE_REF__SERVICE);
	}

	@Check
	public void checkDoesNotRefRetiredBO(BusinessObjectRef boRef) {
		EObject owner = objLookup.getVersionedOwner(boRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && stateRes.definesState(owner) && ownerState.isIsEnd()
				&& boRef.getType().getState().isIsEnd())
			error ("A businessObject in state " + ownerState.getName() + " cannot be referenced", ServiceDslPackage.Literals.BUSINESS_OBJECT_REF__TYPE);
	}

	@Check
	public void checkDoesNotRefRetiredEnumeration(EnumTypeRef enumRef) {
		EObject owner = objLookup.getVersionedOwner(enumRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && stateRes.definesState (owner) && ownerState.isIsEnd()
				&& enumRef.getType().getState().isIsEnd())
			error ("An enum in state " + ownerState.getName() + " cannot be referenced", ServiceDslPackage.Literals.ENUM_TYPE_REF__TYPE);
	}

	@Check
	public void checkExDoesNotRefRetiredException(ExceptionRef exRef) {
		EObject owner = objLookup.getVersionedOwner(exRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && stateRes.definesState (owner) && ownerState.isIsEnd()
				&& exRef.getException().getState().isIsEnd())
			error ("An exception in state " + ownerState.getName() + " cannot be referenced", ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION);
	}
	
	@Check
	public void checkServiceOpDoesNotRefRetiredException(ExceptionRef exRef) {
		EObject owner = objLookup.getVersionedOwner(exRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && stateRes.definesState (owner) && ownerState.isIsEnd()
				&& exRef.getException().getState().isIsEnd())
			error ("An exception in state " + ownerState.getName() + " cannot be referenced", ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION);
	}

	
	@Check
	public void checkRefsServiceInMatchingState (ServiceRef svcRef) {
		EObject owner = objLookup.getVersionedOwner(svcRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		if (owner != null && stateRes.definesState (owner)) {
			if(!referencedStateChecker.stateMatches(svcRef.getService().getState(), owner))
				error ("A Service with a lower lifecycle-state or the declared minimal state must not be referenced as it does not support all environments supported by the service.", ServiceDslPackage.Literals.SERVICE_REF__SERVICE);
		}
	}
	@Check
	public void checkRefsVersionedTypeInMatchingState (VersionedTypeRef verTypeRef) {
		EObject owner = objLookup.getVersionedOwner(verTypeRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		if (owner != null && stateRes.definesState (owner)) {
			if (!referencedStateChecker.stateMatches (verTypeRef.getType().getState(), owner))
				error ("A " + getObjectTypeName(verTypeRef.getType()) + " with a lower lifecycle-state or the declared minimal state must not be referenced as it does not support all environments supported by the type", ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE);
		}
	}
	@Check
	public void checkRefsBOInMatchingState (BusinessObjectRef boRef) {
		EObject owner = objLookup.getVersionedOwner(boRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		if (owner != null && stateRes.definesState (owner)) {
			if (!referencedStateChecker.stateMatches (((BusinessObject)boRef.getType()).getState(), owner))
				error ("A businessObject with a lower lifecycle-state or the declared minimal state must not be referenced as it does not support all environments supported by the businessObject", ServiceDslPackage.Literals.BUSINESS_OBJECT_REF__TYPE);
		}
	}

	@Check
	public void checkRefsEnumerationInMatchingState (EnumTypeRef enumRef) {
		EObject owner = objLookup.getVersionedOwner(enumRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		if (owner != null && stateRes.definesState (owner)) {
			if (!referencedStateChecker.stateMatches (((Enumeration)enumRef.getType()).getState(), owner))
				error ("An enum with a lower lifecycle-state or the declared minimal state must not be referenced as it does not support all environments supported by the enum", ServiceDslPackage.Literals.ENUM_TYPE_REF__TYPE);
		}
	}

	
	
	@Check
	public void checkRefsExceptionInMatchingState (ExceptionRef exRef) {
		EObject owner = objLookup.getVersionedOwner(exRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		if (owner != null && stateRes.definesState (owner)) {
			if (!referencedStateChecker.stateMatches (exRef.getException().getState(), owner))
				error ("An exception with a lower lifecycle-state or the declared minimal state must not be referenced as it does not support all environments supported by the exception", ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION);
		}
	}

	
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateService(ServiceRef svcRef) {
		EObject owner = objLookup.getVersionedOwner(svcRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && stateRes.definesState (owner)) {
			if (stateComparator.compare (ownerState, svcRef.getService().getState()) > 0 && !ownerState.isIsEnd())
				warning ("A service with a lower lifecycle-state is being referenced. You should review the referenced service and adjust it's lifecycle-state.", ServiceDslPackage.Literals.SERVICE_REF__SERVICE);
		}
	}
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateBO(BusinessObjectRef boRef) {
		EObject owner = objLookup.getVersionedOwner(boRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null) {
			if (stateComparator.compare (ownerState, ((BusinessObject)boRef.getType()).getState()) > 0 && !ownerState.isIsEnd())
				warning ("A businessObject with a lower lifecycle-state is being referenced. You should review the referenced businessObject and adjust it's lifecycle-state.", ServiceDslPackage.Literals.BUSINESS_OBJECT_REF__TYPE);
		}
	}
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateBO(VersionedTypeRef boRef) {
		EObject owner = objLookup.getVersionedOwner(boRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null) {
			if (stateComparator.compare (ownerState, boRef.getType().getState()) > 0 && !ownerState.isIsEnd())
				warning ("A " + getObjectTypeName (boRef.getType())+ " with a lower lifecycle-state is being referenced. You should review the referenced businessObject and adjust it's lifecycle-state.", ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE);
		}
	}

	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateEnumeration(EnumTypeRef enumRef) {
		EObject owner = objLookup.getVersionedOwner(enumRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && stateRes.definesState (owner)) {
			if (stateComparator.compare (ownerState, enumRef.getType().getState()) > 0 && !ownerState.isIsEnd())
				warning ("An enum with a lower lifecycle-state is being referenced. You should review the referenced enum and adjust it's lifecycle-state.", ServiceDslPackage.Literals.ENUM_TYPE_REF__TYPE);
		}
	}

	
	
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateException(ExceptionRef exRef) {
		EObject owner = objLookup.getVersionedOwner(exRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && stateRes.definesState (owner)) {
			if (stateComparator.compare(ownerState, exRef.getException().getState()) > 0 && !ownerState.isIsEnd())
				warning ("An exception with a lower lifecycle-state is being referenced. You should review the referenced exception and adjust it's lifecycle-state.", ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION);
		}
	}


	

	void checkNoRefsToRetiredService(Service s) {
//		if (s.getState() == LifecycleState.RETIRED) {
//
//			ReferenceSearch search = new ReferenceSearch();
//			List<IReferenceDescription> refs = search.findReferences(s);
//			Iterables.filter(refs, new Predicate<IReferenceDescription>() {
//
//				public boolean apply(IReferenceDescription input) {
//					EObject target = input.getEReference();
//					return false;
//				}
//
//			});
//		}
	}

	
	private String getObjectTypeName(EObject o) {
		if (o instanceof BusinessObject)
			return "businessObject";
		else if (o instanceof Enumeration)
			return "enum";
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return "exception";
		else if (o instanceof Service)
			return "service";
		else
			return "";
	}


}
