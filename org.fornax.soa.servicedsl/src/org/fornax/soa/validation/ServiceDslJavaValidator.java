package org.fornax.soa.validation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.basedsl.scoping.versions.ServiceDslLifecycleStateResolver;
import org.fornax.soa.search.ReferenceSearch;
import org.fornax.soa.serviceDsl.ApprovalDecision;
import org.fornax.soa.serviceDsl.Attribute;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.GovernanceApproval;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.Reference;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceCategory;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.VISIBILITY;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.fornax.soa.util.DslElementAccessor;
import org.fornax.soa.util.ReferencedStateChecker;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.internal.Lists;

public class ServiceDslJavaValidator extends AbstractServiceDslJavaValidator {

	// @Check
	// public void checkTypeNameStartsWithCapital(Type type) {
	// if (!Character.isUpperCase(type.getName().charAt(0))) {
	// warning("Name should start with a capital", MyDslPackage.TYPE__NAME);
	// }
	// }

	// Naming
	@Check
	public void checkServiceNameStartsWithCapital(Service s) {
		if (!Character.isUpperCase(s.getName().charAt(0))) {
			warning("Name should start with a capital",
					ServiceDslPackage.SERVICE__NAME);
		}
	}

	@Check
	public void checkEntityServiceNameEndsWithBES(Service s) {
		if (s.getCategory() == ServiceCategory.ENTITY
				&& !s.getName().endsWith("BES")) {
			warning("The name of an entity service should end with BES",
					ServiceDslPackage.SERVICE__NAME);
		}
	}

	@Check
	public void checkActivityServiceNameEndsWithBAS(Service s) {
		if (s.getCategory() == ServiceCategory.ACTIVITY
				&& !s.getName().endsWith("BAS")) {
			warning("The name of an activity service should end with BAS",
					ServiceDslPackage.SERVICE__NAME);
		}
	}

	@Check
	public void checkProcessServiceNameEndsWithBPS(Service s) {
		if (s.getCategory() == ServiceCategory.PROCESS
				&& !s.getName().endsWith("BPS")) {
			warning("The name of a process service should end with BPS",
					ServiceDslPackage.SERVICE__NAME);
		}
	}

	@Check
	public void checkUtilityServiceNameEndsWithUS(Service s) {
		if (s.getCategory() == ServiceCategory.UTILITY
				&& !s.getName().endsWith("US")
				&& !(s.eContainer() instanceof InternalNamespace || s
						.getVisibility() == VISIBILITY.PRIVATE)) {
			warning("The name of a utility service should end with US",
					ServiceDslPackage.SERVICE__NAME);
		}
	}

	@Check
	public void checkRuleServiceNameEndsWithBRS(Service s) {
		if (s.getCategory() == ServiceCategory.RULE
				&& !s.getName().endsWith("BRS")) {
			warning("The name of a rule service should end with BRS",
					ServiceDslPackage.SERVICE__NAME);
		}
	}

	// Call semantics
	@Check(CheckType.NORMAL)
	public void checkEntityServicesDontCallProcessServices(ServiceRef svcRef) {
		EObject o = svcRef.eContainer().eContainer();
		if (o instanceof Service) {
			Service s = (Service) svcRef.eContainer().eContainer();
			if (s.getCategory() == ServiceCategory.ENTITY) {
				if (svcRef.getService().getCategory() == ServiceCategory.PROCESS) {
					error("Business entity services may not call business process services",
							ServiceDslPackage.OPERATION__REQUIRES);
				}
			}
		}
	}

	@Check
	public void checkWeakRefHasBusinessKey (BusinessObjectRef b) {
		if (b.eContainer() instanceof Reference) {
			Iterable<Property> keys = Iterables.filter(b.getType().getProperties(), new Predicate<Property> () {
	
				public boolean apply(Property input) {
					// TODO Auto-generated method stub
					return input.isIsBusinessKey();
				}
				
			});
			if (Lists.newArrayList(keys).isEmpty())
				error ("The target businessObject of the weak-ref defines no business-key. " +
						"The business-key is required to represent and resolve the reference. " +
						"Remove the weak-ref qualifier or define a single business-key in the target businessObject", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE );
		}
	}
	
	@Check
	public void checkWeakRefHasBusinessKey (VersionedTypeRef b) {
		if (b.eContainer() instanceof Reference && b.getType() instanceof BusinessObject) {
			Iterable<Property> keys = Iterables.filter(((BusinessObject)b.getType()).getProperties(), new Predicate<Property> () {
	
				public boolean apply(Property input) {
					// TODO Auto-generated method stub
					return input.isIsBusinessKey();
				}
				
			});
			if (Lists.newArrayList(keys).isEmpty())
				error ("The target businessObject of the weak-ref defines no business-key. " +
						"The business-key is required to represent and resolve the reference. " +
						"Remove the weak-ref qualifier or define a single business-key in the target businessObject", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE );
		}
	}
	
	@Check
	public void checkWeakRefTargetDefinesOnlyOneBusinessKey (BusinessObjectRef b) {
		if (b.eContainer() instanceof Reference) {
			Iterable<Property> keys = Iterables.filter(b.getType().getProperties(), new Predicate<Property> () {
	
				public boolean apply(Property input) {
					// TODO Auto-generated method stub
					return input.isIsBusinessKey();
				}
				
			});
			if (Lists.newArrayList(keys).size() > 1)
				error ("The target businessObject of the weak-ref defines more than one business-key. " +
						"The business-key is required to represent and resolve the reference. " +
						"Remove the weak-ref qualifier or define a single business-key in the target businessObject", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE );

		}
	}
	
	@Check
	public void checkWeakRefTargetDefinesOnlyOneBusinessKey (VersionedTypeRef b) {
		if (b.eContainer() instanceof Reference && b.getType() instanceof BusinessObject) {
			Iterable<Property> keys = Iterables.filter(((BusinessObject)b.getType()).getProperties(), new Predicate<Property> () {
	
				public boolean apply(Property input) {
					// TODO Auto-generated method stub
					return input.isIsBusinessKey();
				}
				
			});
			if (Lists.newArrayList(keys).size() > 1)
				error ("The target businessObject of the weak-ref defines more than one business-key. " +
						"The business-key is required to represent and resolve the reference. " +
						"Remove the weak-ref qualifier or define a single business-key in the target businessObject", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE );

		}
	}

	@Check(CheckType.NORMAL)
	public void checkEntityServicesDontCallActivityServices(ServiceRef svcRef) {
		EObject o = svcRef.eContainer().eContainer();
		if (o instanceof Service) {
			Service s = (Service) o;
			if (s.getCategory() == ServiceCategory.ACTIVITY) {
				if (svcRef.getService().getCategory() == ServiceCategory.PROCESS) {
					error("Business entity services may not call business activity services",
							ServiceDslPackage.OPERATION__REQUIRES);
				}
			}
		}
	}

	@Check(CheckType.NORMAL)
	public void checkEntityServicesDontCallRuleServices(ServiceRef svcRef) {
		EObject o = svcRef.eContainer().eContainer();
		if (o instanceof Service) {
			Service s = (Service) svcRef.eContainer().eContainer();
			if (s.getCategory() == ServiceCategory.ACTIVITY) {
				if (svcRef.getService().getCategory() == ServiceCategory.PROCESS) {
					error("Business entity services may not call business rule services",
							ServiceDslPackage.OPERATION__REQUIRES);
				}
			}
		}
	}

	@Check
	public void checkProvidedContractOnPrivateServiceOnly(Service s) {
		if (s.getProvidedContractUrl() != null
				&& s.getVisibility() != VISIBILITY.PRIVATE)
			error("Only private services may provide a predefined contract such as a WSDL",
					ServiceDslPackage.SERVICE__PROVIDED_CONTRACT_URL);
	}

	@Check
	public void checkProvidedDefOnInternalBOOnly(BusinessObject o) {
		if (o.getProvidedDefinitionUrl() != null
				&& o.eContainer() instanceof DomainNamespace)
			error("Only internal businessObjects may provide a predefined definition such as an XSD",
					ServiceDslPackage.BUSINESS_OBJECT__PROVIDED_DEFINITION_URL);
	}

	@Check
	public void checkProvidedDefOnInternalEnumOnly(Enumeration o) {
		if (o.getProvidedDefinitionUrl() != null
				&& o.eContainer() instanceof DomainNamespace)
			error("Only internal enums may provide a predefined definition such as an XSD",
					ServiceDslPackage.ENUMERATION__PROVIDED_DEFINITION_URL);
	}

	@Check
	public void checkProvidedDefOnInternalEnumOnly(
			org.fornax.soa.serviceDsl.Exception o) {
		if (o.getProvidedDefinitionUrl() != null
				&& o.eContainer() instanceof DomainNamespace)
			error("Only internal exceptions may provide a predefined definition such as an XSD or WSDL",
					ServiceDslPackage.ENUMERATION__PROVIDED_DEFINITION_URL);
	}

	// Governance approvals ...
	@Check
	public void checkPublicTmpToleratedServiceShouldHaveApproval(
			GovernanceApproval g) {
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& getLifecycleState(g) == LifecycleState.PRODUCTIVE
				&& g.getDecision() == ApprovalDecision.TEMPORARILY_TOLERATED)
			warning("The temporarily tolerated "
					+ getPubCanocicalName(g)
					+ " "
					+ getContainingObjectTypeName(g)
					+ " "
					+ getObjectName(g)
					+ " "
					+ getObjectVersion(g).getVersion()
					+ " + needs to be reviewed. A decision on governance approval shoud be made soon.",
					ServiceDslPackage.GOVERNANCE_APPROVAL__DECISION);
	}

	@Check
	public void checkPublicToleratedServiceShouldHaveApproval(
			GovernanceApproval g) {
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& getLifecycleState(g) == LifecycleState.PRODUCTIVE
				&& g.getDecision() == ApprovalDecision.TOLERATED)
			warning("The "
					+ getPubCanocicalName(g)
					+ " "
					+ getContainingObjectTypeName(g)
					+ " "
					+ getObjectName(g)
					+ " "
					+ getObjectVersion(g).getVersion()
					+ " needs to be reviewed and possibly redesigned. A decision on governance approval shoud be made soon.",
					ServiceDslPackage.GOVERNANCE_APPROVAL__DECISION);
	}

	@Check
	public void checkPublicToleratedServiceNeedsJustification(
			GovernanceApproval g) {
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& (g.getDecision() == ApprovalDecision.TEMPORARILY_TOLERATED || g
						.getDecision() == ApprovalDecision.TOLERATED)
				&& (g.getJustificationOrDocURL() == null || g
						.getJustificationOrDocURL().equals("")))
			warning("The "
					+ getPubCanocicalName(g)
					+ " "
					+ getContainingObjectTypeName(g)
					+ " "
					+ getObjectName(g)
					+ " "
					+ getObjectVersion(g).getVersion()
					+ " is being tolerated. A justification is required for that.",
					ServiceDslPackage.GOVERNANCE_APPROVAL);
	}

	@Check
	public void checkPublicServiceMustHaveApproval(GovernanceApproval g) {

		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& getLifecycleState(g) == LifecycleState.PRODUCTIVE
				&& g.getDecision() == ApprovalDecision.NO)
			error("A "
					+ getPubCanocicalName(g)
					+ " "
					+ getContainingObjectTypeName(g)
					+ " "
					+ getObjectVersion(g).getVersion()
					+ " may not be productive without governance approval. It must at least be tolerated",
					ServiceDslPackage.APPROVAL_DECISION);
	}

	@Check
	public void checkApprovedServiceHasDate(GovernanceApproval g) {
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovalDate() == null || "".equals(g
						.getApprovalDate())))
			warning("Please provide the date of the governance decision!",
					ServiceDslPackage.GOVERNANCE_APPROVAL);
	}

	@Check
	public void checkApprovedServiceHasBy(GovernanceApproval g) {
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovedBy() == null || "".equals(g.getApprovedBy())))
			warning("Please state who made the governance decision!",
					ServiceDslPackage.GOVERNANCE_APPROVAL);
	}

	@Check
	public void checkGovApprovalDeclared(BusinessObject o) {
		if (o.eContainer() instanceof DomainNamespace
				&& o.getState() != LifecycleState.PROPOSED
				&& o.getGovernanceApproval() == null)
			error("The state of the governance-approval for a canonical businessObject must be declared!",
					ServiceDslPackage.BUSINESS_OBJECT);
	}

	@Check
	public void checkGovApprovalDeclared(Enumeration e) {
		if (e.eContainer() instanceof DomainNamespace
				&& e.getState() != LifecycleState.PROPOSED
				&& e.getGovernanceApproval() == null)
			error("The state of the governance-approval for a canonical enum must be declared!",
					ServiceDslPackage.ENUMERATION);
	}

	@Check
	public void checkGovApprovalDeclared(org.fornax.soa.serviceDsl.Exception ex) {
		if (ex.eContainer() instanceof DomainNamespace
				&& ex.getState() != LifecycleState.PROPOSED
				&& ex.getGovernanceApproval() == null)
			error("The state of the governance-approval for a canonical exception must be declared!",
					ServiceDslPackage.EXCEPTION);
	}

	@Check
	public void checkGovApprovalDeclared(Service s) {
		if (s.eContainer() instanceof DomainNamespace
				&& s.getState() != LifecycleState.PROPOSED
				&& s.getGovernanceApproval() == null)
			error("The state of the governance-approval for a public service must be declared!",
					ServiceDslPackage.SERVICE);
	}

	@Check
	public void checkDoesNotRefRetiredService(ServiceRef svcRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(svcRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && isStatefulServiceDslObject (owner) && ownerState != LifecycleState.RETIRED 
				&& svcRef.getService().getState() == LifecycleState.RETIRED) 
			error("A retired Service cannot be referenced", ServiceDslPackage.SERVICE_REF__SERVICE);
	}

	@Check
	public void checkDoesNotRefRetiredBO(BusinessObjectRef boRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(boRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && isStatefulServiceDslObject (owner) && ownerState != LifecycleState.RETIRED
				&& boRef.getType().getState() == LifecycleState.RETIRED)
			error("A retired businessObject cannot be referenced", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE);
	}

	@Check
	public void checkDoesNotRefRetiredEnumeration(EnumTypeRef enumRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(enumRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && isStatefulServiceDslObject (owner) && ownerState != LifecycleState.RETIRED
				&& enumRef.getType().getState() == LifecycleState.RETIRED)
			error("A retired enum cannot be referenced", ServiceDslPackage.ENUM_TYPE_REF__TYPE);
	}

	@Check
	public void checkExDoesNotRefRetiredException(ExceptionRef exRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(exRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && isStatefulServiceDslObject (owner) && ownerState != LifecycleState.RETIRED
				&& exRef.getException().getState() == LifecycleState.RETIRED)
			error("A retired exception cannot be referenced", ServiceDslPackage.EXCEPTION_REF__EXCEPTION);
	}
	
	@Check
	public void checkServiceOpDoesNotRefRetiredException(ExceptionRef exRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(exRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && isStatefulServiceDslObject (owner) && ownerState != LifecycleState.RETIRED
				&& exRef.getException().getState() == LifecycleState.RETIRED)
			error("A retired exception cannot be referenced", ServiceDslPackage.EXCEPTION_REF__EXCEPTION);
	}

	
	@Check
	public void checkRefsServiceInMatchingState (ServiceRef svcRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(svcRef);
		if (owner != null && isStatefulServiceDslObject (owner)) {
			if(!createStateChecker(owner).stateMatches(svcRef.getService().getState()))
				error("A Service with a lower lifecycle-state or the declared minimal state must not be referenced", ServiceDslPackage.SERVICE_REF__SERVICE);
		}
	}
	@Check
	public void checkRefsVersionedTypeInMatchingState (VersionedTypeRef verTypeRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(verTypeRef);
		if (owner != null && isStatefulServiceDslObject (owner)) {
			if (!createStateChecker(owner).stateMatches(verTypeRef.getType().getState()))
				error("A " + getObjectTypeName(verTypeRef.getType()) + " with a lower lifecycle-state or the declared minimal state must not be referenced", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE);
		}
	}
	@Check
	public void checkRefsBOInMatchingState (BusinessObjectRef boRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(boRef);
		if (owner != null && isStatefulServiceDslObject (owner)) {
			if (!createStateChecker(owner).stateMatches(((BusinessObject)boRef.getType()).getState()))
				error("A businessObject with a lower lifecycle-state or the declared minimal state must not be referenced", ServiceDslPackage.BUSINESS_OBJECT_REF__TYPE);
		}
	}

	@Check
	public void checkRefsEnumerationInMatchingState (EnumTypeRef enumRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(enumRef);
		if (owner != null && isStatefulServiceDslObject (owner)) {
			if (!createStateChecker(owner).stateMatches(((Enumeration)enumRef.getType()).getState()))
				error("An enum with a lower lifecycle-state or the declared minimal state must not be referenced", ServiceDslPackage.ENUM_TYPE_REF__TYPE);
		}
	}

	
	
	@Check
	public void checkRefsExceptionInMatchingState (ExceptionRef exRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(exRef);
		if (owner != null && isStatefulServiceDslObject (owner)) {
			if (!createStateChecker(owner).stateMatches(exRef.getException().getState()))
				error("An exception with a lower lifecycle-state or the declared minimal state must not be referenced", ServiceDslPackage.EXCEPTION_REF__EXCEPTION);
		}
	}

	
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateService(ServiceRef svcRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(svcRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && isStatefulServiceDslObject (owner)) {
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
		if (owner != null && isStatefulServiceDslObject (owner)) {
			if (LifecycleStateComparator.compare(ownerState, enumRef.getType().getState()) < 0)
				warning("An enum with a lower lifecycle-state is being referenced. You should review the referenced enum and adjust it's lifecycle-state.", ServiceDslPackage.ENUM_TYPE_REF__TYPE);
		}
	}

	
	
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateException(ExceptionRef exRef) {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner(exRef);
		LifecycleStateResolver stateRes = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null && isStatefulServiceDslObject (owner)) {
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


	
	// Consistency
	@Check
	public void checkBusinessKeyIsMandatory(Attribute p) {
		if (p.isIsBusinessKey() && p.isOptional())
			error("A business-key attribute may not be optional.",
					ServiceDslPackage.ATTRIBUTE__IS_BUSINESS_KEY);
	}

	@Check
	public void checkBusinessKeyIsMandatory(Reference p) {
		if (p.isIsBusinessKey() && p.isOptional())
			error("A business-key weak-ref attribute may not be optional.",
					ServiceDslPackage.REFERENCE__IS_BUSINESS_KEY);
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
	
	private String getContainingObjectTypeName(EObject ele) {
		EObject o = ele.eContainer();
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

	private String getPubCanocicalName(GovernanceApproval g) {
		EObject o = g.eContainer();
		if (o instanceof Service)
			return "public";
		else
			return "canonical";
	}

	private LifecycleState getLifecycleState(GovernanceApproval g) {
		EObject o = g.eContainer();
		if (o instanceof BusinessObject)
			return ((BusinessObject) o).getState();
		else if (o instanceof Enumeration)
			return ((Enumeration) o).getState();
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return ((org.fornax.soa.serviceDsl.Exception) o).getState();
		else if (o instanceof Service)
			return ((Service) o).getState();
		else
			return null;
	}

	private String getObjectName(GovernanceApproval g) {
		EObject o = g.eContainer();
		if (o instanceof BusinessObject)
			return ((BusinessObject) o).getName();
		else if (o instanceof Enumeration)
			return ((Enumeration) o).getName();
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return ((org.fornax.soa.serviceDsl.Exception) o).getName();
		else if (o instanceof Service)
			return ((Service) o).getName();
		else
			return null;
	}

	private Version getObjectVersion(GovernanceApproval g) {
		EObject o = g.eContainer();
		if (o instanceof BusinessObject)
			return ((BusinessObject) o).getVersion();
		else if (o instanceof Enumeration)
			return ((Enumeration) o).getVersion();
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return ((org.fornax.soa.serviceDsl.Exception) o).getVersion();
		else if (o instanceof Service)
			return ((Service) o).getVersion();
		else
			return null;
	}
	
	boolean isStatefulServiceDslObject (EObject o) {
		if (o instanceof SubNamespace || 
				o instanceof BusinessObject ||
				o instanceof Service ||
				o instanceof Enumeration ||
				o instanceof org.fornax.soa.serviceDsl.Exception) {
			return true;
		} else {
			return false;
		}
	}
}
