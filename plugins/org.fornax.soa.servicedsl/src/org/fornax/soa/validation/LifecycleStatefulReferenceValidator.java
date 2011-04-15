package org.fornax.soa.validation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.basedsl.scoping.versions.ServiceDslLifecycleStateResolver;
import org.fornax.soa.query.VersionedObjectQueryHelper;
import org.fornax.soa.search.ReferenceSearch;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.fornax.soa.util.DslElementAccessor;
import org.fornax.soa.util.ReferencedStateChecker;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class LifecycleStatefulReferenceValidator extends
		AbstractDeclarativeValidator {

	@Check
	public void checkDoesNotRefRetiredService(ServiceRef svcRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(svcRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner) && ownerState != LifecycleState.RETIRED 
				&& svcRef.getService().getState() == LifecycleState.RETIRED) 
			error("A retired Service cannot be referenced", ServiceDslPackage.SERVICE_REF__SERVICE);
	}

	@Check
	public void checkDoesNotRefRetiredBO(BusinessObjectRef boRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(boRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner) && ownerState != LifecycleState.RETIRED
				&& boRef.getType().getState() == LifecycleState.RETIRED)
			error("A retired businessObject cannot be referenced", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE);
	}

	@Check
	public void checkDoesNotRefRetiredEnumeration(EnumTypeRef enumRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(enumRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner) && ownerState != LifecycleState.RETIRED
				&& enumRef.getType().getState() == LifecycleState.RETIRED)
			error("A retired enum cannot be referenced", ServiceDslPackage.ENUM_TYPE_REF__TYPE);
	}

	@Check
	public void checkExDoesNotRefRetiredException(ExceptionRef exRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(exRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner) && ownerState != LifecycleState.RETIRED
				&& exRef.getException().getState() == LifecycleState.RETIRED)
			error("A retired exception cannot be referenced", ServiceDslPackage.EXCEPTION_REF__EXCEPTION);
	}
	
	@Check
	public void checkServiceOpDoesNotRefRetiredException(ExceptionRef exRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(exRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner) && ownerState != LifecycleState.RETIRED
				&& exRef.getException().getState() == LifecycleState.RETIRED)
			error("A retired exception cannot be referenced", ServiceDslPackage.EXCEPTION_REF__EXCEPTION);
	}

	
	@Check
	public void checkRefsServiceInMatchingState (ServiceRef svcRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(svcRef);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner)) {
			if(!createStateChecker(owner).stateMatches(svcRef.getService().getState()))
				error("A Service with a lower lifecycle-state or the declared minimal state must not be referenced", ServiceDslPackage.SERVICE_REF__SERVICE);
		}
	}
	@Check
	public void checkRefsVersionedTypeInMatchingState (VersionedTypeRef verTypeRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(verTypeRef);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner)) {
			if (!createStateChecker(owner).stateMatches(verTypeRef.getType().getState()))
				error("A " + getObjectTypeName(verTypeRef.getType()) + " with a lower lifecycle-state or the declared minimal state must not be referenced", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE);
		}
	}
	@Check
	public void checkRefsBOInMatchingState (BusinessObjectRef boRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(boRef);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner)) {
			if (!createStateChecker(owner).stateMatches(((BusinessObject)boRef.getType()).getState()))
				error("A businessObject with a lower lifecycle-state or the declared minimal state must not be referenced", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE);
		}
	}

	@Check
	public void checkRefsEnumerationInMatchingState (EnumTypeRef enumRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(enumRef);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner)) {
			if (!createStateChecker(owner).stateMatches(((Enumeration)enumRef.getType()).getState()))
				error("An enum with a lower lifecycle-state or the declared minimal state must not be referenced", ServiceDslPackage.ENUM_TYPE_REF__TYPE);
		}
	}

	
	
	@Check
	public void checkRefsExceptionInMatchingState (ExceptionRef exRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(exRef);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner)) {
			if (!createStateChecker(owner).stateMatches(exRef.getException().getState()))
				error("An exception with a lower lifecycle-state or the declared minimal state must not be referenced", ServiceDslPackage.EXCEPTION_REF__EXCEPTION);
		}
	}

	
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateService(ServiceRef svcRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(svcRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner)) {
			if (LifecycleStateComparator.compare(ownerState, svcRef.getService().getState()) < 0)
				warning("A service with a lower lifecycle-state is being referenced. You should review the referenced service and adjust it's lifecycle-state.", ServiceDslPackage.SERVICE_REF__SERVICE);
		}
	}
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateBO(BusinessObjectRef boRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(boRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null) {
			if (LifecycleStateComparator.compare(ownerState, ((BusinessObject)boRef.getType()).getState()) < 0)
				warning("A businessObject with a lower lifecycle-state is being referenced. You should review the referenced businessObject and adjust it's lifecycle-state.", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE);
		}
	}
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateBO(VersionedTypeRef boRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(boRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null) {
			if (LifecycleStateComparator.compare(ownerState, boRef.getType().getState()) < 0)
				warning("A " + getObjectTypeName(boRef.getType())+ " with a lower lifecycle-state is being referenced. You should review the referenced businessObject and adjust it's lifecycle-state.", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE);
		}
	}

	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateEnumeration(EnumTypeRef enumRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(enumRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner)) {
			if (LifecycleStateComparator.compare(ownerState, enumRef.getType().getState()) < 0)
				warning("An enum with a lower lifecycle-state is being referenced. You should review the referenced enum and adjust it's lifecycle-state.", ServiceDslPackage.ENUM_TYPE_REF__TYPE);
		}
	}

	
	
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateException(ExceptionRef exRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(exRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && VersionedObjectQueryHelper.isStatefulServiceDslObject (owner)) {
			if (LifecycleStateComparator.compare(ownerState, exRef.getException().getState()) < 0)
				warning("An exception with a lower lifecycle-state is being referenced. You should review the referenced exception and adjust it's lifecycle-state.", ServiceDslPackage.EXCEPTION_REF__EXCEPTION);
		}
	}


	

	void checkNoRefsToRetiredService(Service s) {
		if (s.getState() == LifecycleState.RETIRED) {

			ReferenceSearch search = new ReferenceSearch();
			List<IReferenceDescription> refs = search.findReferences(s);
			Iterables.filter(refs, new Predicate<IReferenceDescription>() {

				public boolean apply(IReferenceDescription input) {
					EObject target = input.getEReference();
					return false;
				}

			});
		}
	}

	private ReferencedStateChecker createStateChecker (EObject owner) {
		LifecycleStateResolver stateResolver = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		return new ReferencedStateChecker(owner, stateResolver);
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
