package org.xkonnex.repo.dsl.servicedsl.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.util.ReferencedStateChecker;
import org.xkonnex.repo.dsl.servicedsl.service.query.VersionedObjectQueryHelper;
import org.xkonnex.repo.dsl.servicedsl.service.util.ServiceDslElementAccessor;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef;

import com.google.inject.Inject;

public class LifecycleStatefulReferenceValidator extends AbstractPluggableDeclarativeValidator {

	@Inject ReferencedStateChecker referencedStateChecker;
	@Inject IStateMatcher stateMatcher;
	@Inject LifecycleStateComparator stateComparator;
	@Inject IEObjectLookup objLookup;
	@Inject ILifecycleStateResolver stateResolver;

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage.eINSTANCE);
		return result;
	}

	@Check
	public void checkDoesNotRefRetiredService(ServiceRef svcRef) {
		EObject owner = objLookup.getStatefulOwner(svcRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null && stateResolver.definesState(owner) && ownerState.isIsEnd() 
				&& svcRef.getService().getState() != null
				&& svcRef.getService().getState().isIsEnd()) 
			error ("A service in state " + ownerState.getName() + " cannot be referenced", ServiceDslPackage.Literals.SERVICE_REF__SERVICE);
	}

	@Check
	public void checkDoesNotRefRetiredDO(DataObjectRef doRef) {
		EObject owner = objLookup.getVersionedOwner(doRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null && stateResolver.definesState(owner) && ownerState.isIsEnd()
				&& doRef.getType().getState() != null
				&& doRef.getType().getState().isIsEnd())
			error ("A businessObject / queryObject in state " + ownerState.getName() + " cannot be referenced", ServiceDslPackage.Literals.DATA_OBJECT_REF__TYPE);
	}

	@Check
	public void checkDoesNotRefRetiredEnumeration(EnumTypeRef enumRef) {
		EObject owner = objLookup.getStatefulOwner(enumRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null && stateResolver.definesState (owner) && ownerState.isIsEnd()
				&& enumRef.getType().getState() != null
				&& enumRef.getType().getState().isIsEnd())
			error ("An enum in state " + ownerState.getName() + " cannot be referenced", ServiceDslPackage.Literals.ENUM_TYPE_REF__TYPE);
	}

	@Check
	public void checkExDoesNotRefRetiredException(ExceptionRef exRef) {
		EObject owner = objLookup.getStatefulOwner(exRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null && stateResolver.definesState (owner) && ownerState.isIsEnd()
				&& exRef.getException().getState() != null
				&& exRef.getException().getState().isIsEnd())
			error ("An exception in state " + ownerState.getName() + " cannot be referenced", ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION);
	}
	
	@Check
	public void checkServiceOpDoesNotRefRetiredException(ExceptionRef exRef) {
		EObject owner = objLookup.getStatefulOwner(exRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null && stateResolver.definesState (owner) && ownerState.isIsEnd()
				&& exRef.getException().getState() != null
				&& exRef.getException().getState().isIsEnd())
			error ("An exception in state " + ownerState.getName() + " cannot be referenced", ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION);
	}

	
	@Check
	public void checkRefsServiceInMatchingState (ServiceRef svcRef) {
		EObject owner = objLookup.getStatefulOwner(svcRef);
		if (owner != null && stateResolver.definesState (owner)) {
			if(!referencedStateChecker.stateMatches(svcRef.getService().getState(), owner))
				error ("A Service with a lower lifecycle-state or the declared minimal state must not be referenced as it does not support all environments supported by the service.", ServiceDslPackage.Literals.SERVICE_REF__SERVICE);
		}
	}
	@Check
	public void checkRefsVersionedTypeInMatchingState (VersionedTypeRef verTypeRef) {
		EObject owner = objLookup.getStatefulOwner(verTypeRef);
		if (owner != null && stateResolver.definesState (owner)) {
			if (!referencedStateChecker.stateMatches (verTypeRef.getType().getState(), owner))
				error ("A " + getObjectTypeName(verTypeRef.getType()) + " with a lower lifecycle-state or the declared minimal state must not be referenced as it does not support all environments supported by the type", ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE);
		}
	}
	@Check
	public void checkRefsDOInMatchingState (DataObjectRef doRef) {
		EObject owner = objLookup.getVersionedOwner(doRef);
		if (owner != null && stateResolver.definesState (owner)) {
			if (!referencedStateChecker.stateMatches (((BusinessObject)doRef.getType()).getState(), owner))
				error ("A businessObject / queryObject with a lower lifecycle-state or the declared minimal state must not be referenced as it does not support all environments supported by the businessObject", ServiceDslPackage.Literals.DATA_OBJECT_REF__TYPE);
		}
	}

	@Check
	public void checkRefsEnumerationInMatchingState (EnumTypeRef enumRef) {
		EObject owner = objLookup.getStatefulOwner(enumRef);
		if (owner != null && stateResolver.definesState (owner)) {
			if (!referencedStateChecker.stateMatches (((Enumeration)enumRef.getType()).getState(), owner))
				error ("An enum with a lower lifecycle-state or the declared minimal state must not be referenced as it does not support all environments supported by the enum", ServiceDslPackage.Literals.ENUM_TYPE_REF__TYPE);
		}
	}

	
	
	@Check
	public void checkRefsExceptionInMatchingState (ExceptionRef exRef) {
		EObject owner = objLookup.getStatefulOwner(exRef);
		if (owner != null && stateResolver.definesState (owner)) {
			if (!referencedStateChecker.stateMatches (exRef.getException().getState(), owner))
				error ("An exception with a lower lifecycle-state or the declared minimal state must not be referenced as it does not support all environments supported by the exception", ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION);
		}
	}

	
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateService(ServiceRef svcRef) {
		EObject owner = objLookup.getStatefulOwner(svcRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null && stateResolver.definesState (owner)) {
			if (stateComparator.compare (ownerState, svcRef.getService().getState()) > 0 && !(ownerState != null && ownerState.isIsEnd()))
				warning ("A service with a lower lifecycle-state is being referenced. You should review the referenced service and adjust it's lifecycle-state.", ServiceDslPackage.Literals.SERVICE_REF__SERVICE);
		}
	}
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateDO(DataObjectRef doRef) {
		EObject owner = objLookup.getVersionedOwner(doRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null) {
			if (stateComparator.compare (ownerState, ((BusinessObject)doRef.getType()).getState()) > 0 && !(ownerState != null && ownerState.isIsEnd()))
				warning ("A businessObject / queryObject with a lower lifecycle-state is being referenced. You should review the referenced businessObject and adjust it's lifecycle-state.", ServiceDslPackage.Literals.DATA_OBJECT_REF__TYPE);
		}
	}
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateBO(VersionedTypeRef boRef) {
		EObject owner = objLookup.getStatefulOwner(boRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null) {
			if (stateComparator.compare (ownerState, boRef.getType().getState()) > 0 && !(ownerState != null && ownerState.isIsEnd()))
				warning ("A " + getObjectTypeName (boRef.getType())+ " with a lower lifecycle-state is being referenced. You should review the referenced businessObject and adjust it's lifecycle-state.", ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE);
		}
	}

	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateEnumeration(EnumTypeRef enumRef) {
		EObject owner = objLookup.getStatefulOwner(enumRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null && stateResolver.definesState (owner)) {
			if (stateComparator.compare (ownerState, enumRef.getType().getState()) > 0 && !(ownerState != null && ownerState.isIsEnd()))
				warning ("An enum with a lower lifecycle-state is being referenced. You should review the referenced enum and adjust it's lifecycle-state.", ServiceDslPackage.Literals.ENUM_TYPE_REF__TYPE);
		}
	}

	
	
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateException(ExceptionRef exRef) {
		EObject owner = objLookup.getStatefulOwner(exRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null && stateResolver.definesState (owner)) {
			if (stateComparator.compare(ownerState, exRef.getException().getState()) > 0 && !(ownerState != null && ownerState.isIsEnd()))
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
		else if (o instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception)
			return "exception";
		else if (o instanceof Service)
			return "service";
		else
			return "";
	}


}
