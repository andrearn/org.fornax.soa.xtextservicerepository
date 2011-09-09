package org.fornax.soa.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.Check;
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.basedsl.scoping.versions.ServiceDslLifecycleStateResolver;
import org.fornax.soa.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;
import org.fornax.soa.query.VersionedObjectQueryHelper;
import org.fornax.soa.serviceDsl.ApprovalDecision;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.GovernanceApproval;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.util.ReferencedStateChecker;

public class GovernanceApprovalValidator extends AbstractPluggableDeclarativeValidator {


	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.fornax.soa.serviceDsl.ServiceDslPackage.eINSTANCE);
		return result;
	}
	
	// Governance approvals ...
	
	@Check
	public void checkPublicTmpToleratedServiceShouldHaveApproval(
			GovernanceApproval g) {
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& VersionedObjectQueryHelper.getLifecycleState(g) == LifecycleState.PRODUCTIVE
				&& g.getDecision() == ApprovalDecision.TEMPORARILY_TOLERATED)
			warning("The temporarily tolerated "
					+ getPubCanocicalName(g)
					+ " "
					+ getContainingObjectTypeName(g)
					+ " "
					+ getObjectName(g)
					+ " "
					+ VersionedObjectQueryHelper.getObjectVersion(g).getVersion()
					+ " + needs to be reviewed. A decision on governance approval shoud be made soon.",
					ServiceDslPackage.Literals.GOVERNANCE_APPROVAL__DECISION);
	}

	@Check
	public void checkPublicToleratedServiceShouldHaveApproval(
			GovernanceApproval g) {
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& VersionedObjectQueryHelper.getLifecycleState(g) == LifecycleState.PRODUCTIVE
				&& g.getDecision() == ApprovalDecision.TOLERATED)
			warning("The "
					+ getPubCanocicalName(g)
					+ " "
					+ getContainingObjectTypeName(g)
					+ " "
					+ getObjectName(g)
					+ " "
					+ VersionedObjectQueryHelper.getObjectVersion(g).getVersion()
					+ " needs to be reviewed and possibly redesigned. A decision on governance approval shoud be made soon.",
					ServiceDslPackage.Literals.GOVERNANCE_APPROVAL__DECISION);
	}

	@Check
	public void checkPublicToleratedServiceNeedsJustification(
			Service s) {
		GovernanceApproval g = s.getGovernanceApproval();
		if (s.eContainer() instanceof DomainNamespace
				&& (g.getDecision() == ApprovalDecision.TEMPORARILY_TOLERATED || g
						.getDecision() == ApprovalDecision.TOLERATED)
				&& (g.getJustificationOrDocURL() == null || g
						.getJustificationOrDocURL().equals("")))
			warning("The "
					+ getPubCanocicalName(g)
					+ " "
					+ getContainingObjectTypeName(g)
					+ " "
					+ VersionedObjectQueryHelper.getObjectName(g)
					+ " "
					+ VersionedObjectQueryHelper.getObjectVersion(g).getVersion()
					+ " is being tolerated. A justification is required for that.",
					ServiceDslPackage.Literals.SERVICE__GOVERNANCE_APPROVAL);
	}

	@Check
	public void checkPublicServiceMustHaveApproval(GovernanceApproval g) {

		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& VersionedObjectQueryHelper.getLifecycleState(g) == LifecycleState.PRODUCTIVE
				&& g.getDecision() == ApprovalDecision.NO)
			error("A "
					+ getPubCanocicalName(g)
					+ " "
					+ getContainingObjectTypeName(g)
					+ " "
					+ VersionedObjectQueryHelper.getObjectVersion(g).getVersion()
					+ " may not be productive without governance approval. It must at least be tolerated",
					ServiceDslPackage.Literals.GOVERNANCE_APPROVAL__DECISION);
	}

	@Check
	public void checkApprovedServiceHasDate(Service s) {
		GovernanceApproval g = s.getGovernanceApproval();
		if (s.eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovalDate() == null || "".equals(g
						.getApprovalDate())))
			warning("Please provide the date of the governance decision!",
					ServiceDslPackage.Literals.SERVICE__GOVERNANCE_APPROVAL);
	}
	@Check
	public void checkApprovedServiceHasDate(BusinessObject bo) {
		GovernanceApproval g = bo.getGovernanceApproval();
		if (bo.eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovalDate() == null || "".equals(g
						.getApprovalDate())))
			warning("Please provide the date of the governance decision!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__GOVERNANCE_APPROVAL);
	}
	@Check
	public void checkApprovedServiceHasDate(Enumeration e) {
		GovernanceApproval g = e.getGovernanceApproval();
		if (e.eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovalDate() == null || "".equals(g
						.getApprovalDate())))
			warning("Please provide the date of the governance decision!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__GOVERNANCE_APPROVAL);
	}
	@Check
	public void checkApprovedServiceHasDate(org.fornax.soa.serviceDsl.Exception ex) {
		GovernanceApproval g = ex.getGovernanceApproval();
		if (ex.eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovalDate() == null || "".equals(g
						.getApprovalDate())))
			warning("Please provide the date of the governance decision!",
					ServiceDslPackage.Literals.EXCEPTION__GOVERNANCE_APPROVAL);
	}

	@Check
	public void checkApprovedServiceHasBy(Service s) {
		GovernanceApproval g = s.getGovernanceApproval();
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovedBy() == null || "".equals(g.getApprovedBy()))) {
			warning("Please state who made the governance decision!",
					ServiceDslPackage.Literals.SERVICE__GOVERNANCE_APPROVAL);
		}
	}
	
	@Check
	public void checkApprovedServiceHasBy(BusinessObject bo) {
		GovernanceApproval g = bo.getGovernanceApproval();
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovedBy() == null || "".equals(g.getApprovedBy()))) {
			warning("Please state who made the governance decision!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__GOVERNANCE_APPROVAL);
		}
	}
	
	@Check
	public void checkApprovedServiceHasBy(org.fornax.soa.serviceDsl.Exception ex) {
		GovernanceApproval g = ex.getGovernanceApproval();
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovedBy() == null || "".equals(g.getApprovedBy()))) {
			warning("Please state who made the governance decision!",
					ServiceDslPackage.Literals.EXCEPTION__GOVERNANCE_APPROVAL);
		}
	}
	
	@Check
	public void checkApprovedServiceHasBy(Enumeration e) {
		GovernanceApproval g = e.getGovernanceApproval();
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovedBy() == null || "".equals(g.getApprovedBy()))) {
			warning("Please state who made the governance decision!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__GOVERNANCE_APPROVAL);
		}
	}

	@Check
	public void checkGovApprovalDeclared(BusinessObject o) {
		if (o.eContainer() instanceof DomainNamespace
				&& o.getState() != LifecycleState.PROPOSED
				&& o.getGovernanceApproval() == null)
			error("The state of the governance-approval for a canonical businessObject must be declared!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__STATE);
	}

	@Check
	public void checkGovApprovalDeclared(Enumeration e) {
		if (e.eContainer() instanceof DomainNamespace
				&& e.getState() != LifecycleState.PROPOSED
				&& e.getGovernanceApproval() == null)
			error("The state of the governance-approval for a canonical enum must be declared!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__STATE);
	}

	@Check
	public void checkGovApprovalDeclared(org.fornax.soa.serviceDsl.Exception ex) {
		if (ex.eContainer() instanceof DomainNamespace
				&& ex.getState() != LifecycleState.PROPOSED
				&& ex.getGovernanceApproval() == null)
			error("The state of the governance-approval for a canonical exception must be declared!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__STATE);
	}

	@Check
	public void checkGovApprovalDeclared(Service s) {
		if (s.eContainer() instanceof DomainNamespace
				&& s.getState() != LifecycleState.PROPOSED
				&& s.getGovernanceApproval() == null)
			error("The state of the governance-approval for a public service must be declared!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__STATE);
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

}
