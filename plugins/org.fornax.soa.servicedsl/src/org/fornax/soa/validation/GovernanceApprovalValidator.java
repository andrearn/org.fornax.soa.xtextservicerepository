package org.fornax.soa.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.Check;
import org.fornax.soa.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.fornax.soa.environmentDsl.EnvironmentType;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.profiledsl.util.ReferencedStateChecker;
import org.fornax.soa.service.query.VersionedObjectQueryHelper;
import org.fornax.soa.serviceDsl.ApprovalDecision;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.GovernanceApproval;
import org.fornax.soa.serviceDsl.QueryObject;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.VersionedType;

import com.google.inject.Inject;

public class GovernanceApprovalValidator extends AbstractPluggableDeclarativeValidator {

	@Inject ReferencedStateChecker referencedStateChecker;
	@Inject IStateMatcher stateMatcher;
	@Inject ILifecycleStateResolver stateResolver;

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.fornax.soa.serviceDsl.ServiceDslPackage.eINSTANCE);
		return result;
	}
	
	// Governance approvals ...
	
	@Check
	public void checkPublicTmpToleratedAssetShouldHaveApproval (GovernanceApproval g) {
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& stateResolver.getLifecycleState(g).isRequiresApproval()
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
	public void checkPublicToleratedAssetShouldHaveApproval (GovernanceApproval g) {
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& stateResolver.getLifecycleState(g).isRequiresApproval()
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
	public void checkPublicToleratedAssetNeedsJustification (Service s) {
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
	public void checkPublicAssetsMustHaveApproval (GovernanceApproval g) {

		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& stateResolver.getLifecycleState(g).isRequiresApproval()
				&& (g.getDecision() == ApprovalDecision.NO || g.getDecision() == ApprovalDecision.DENIED))
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
	public void checkApprovedAssetHasDate (Service s) {
		GovernanceApproval g = s.getGovernanceApproval();
		if (s.eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovalDate() == null || "".equals(g
						.getApprovalDate())))
			warning("Please provide the date of the governance decision!",
					ServiceDslPackage.Literals.SERVICE__GOVERNANCE_APPROVAL);
	}
	
	@Check
	public void checkApprovedAssetHasDate (VersionedType bo) {
		GovernanceApproval g = bo.getGovernanceApproval();
		if (bo.eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovalDate() == null || "".equals(g
						.getApprovalDate())))
			warning("Please provide the date of the governance decision!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__GOVERNANCE_APPROVAL);
	}
	
	@Check
	public void checkApprovedAssetHasDate (org.fornax.soa.serviceDsl.Exception ex) {
		GovernanceApproval g = ex.getGovernanceApproval();
		if (ex.eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovalDate() == null || "".equals(g
						.getApprovalDate())))
			warning("Please provide the date of the governance decision!",
					ServiceDslPackage.Literals.EXCEPTION__GOVERNANCE_APPROVAL);
	}

	@Check
	public void checkApprovedAssetHasBy (Service s) {
		GovernanceApproval g = s.getGovernanceApproval();
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovedBy() == null || "".equals(g.getApprovedBy()))) {
			warning("Please state who made the governance decision!",
					ServiceDslPackage.Literals.SERVICE__GOVERNANCE_APPROVAL);
		}
	}
	
	@Check
	public void checkApprovedAssetHasBy (VersionedType bo) {
		GovernanceApproval g = bo.getGovernanceApproval();
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovedBy() == null || "".equals(g.getApprovedBy()))) {
			warning("Please state who made the governance decision!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__GOVERNANCE_APPROVAL);
		}
	}
	
	@Check
	public void checkApprovedAssetHasBy (org.fornax.soa.serviceDsl.Exception ex) {
		GovernanceApproval g = ex.getGovernanceApproval();
		if (g.eContainer().eContainer() instanceof DomainNamespace
				&& g.getDecision() != ApprovalDecision.NO
				&& (g.getApprovedBy() == null || "".equals(g.getApprovedBy()))) {
			warning("Please state who made the governance decision!",
					ServiceDslPackage.Literals.EXCEPTION__GOVERNANCE_APPROVAL);
		}
	}

	@Check
	public void checkGovApprovalDeclared (VersionedType o) {
		if (o.eContainer() instanceof DomainNamespace
				&& o.getState() != null
				&& o.getState().isRequiresApproval()
				&& o.getGovernanceApproval() == null)
			error("The state of the governance-approval for a canonical " + getContainingObjectTypeName(o) + " must be declared!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__STATE);
	}

	@Check
	public void checkGovApprovalDeclared (org.fornax.soa.serviceDsl.Exception ex) {
		if (ex.eContainer() instanceof DomainNamespace
				&& ex.getState() != null
				&& ex.getState().isRequiresApproval()
				&& ex.getGovernanceApproval() == null)
			error("The state of the governance-approval for a canonical exception must be declared!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__STATE);
	}

	@Check
	public void checkGovApprovalDeclared(Service s) {
		if (s.eContainer() instanceof DomainNamespace
				&& s.getState() != null
				&& s.getState().isRequiresApproval()
				&& s.getGovernanceApproval() == null)
			error("The state of the governance-approval for a canonical service must be declared!",
					ServiceDslPackage.Literals.VERSIONED_TYPE__STATE);
	}


	private String getObjectTypeName (EObject o) {
		if (o instanceof BusinessObject)
			return "businessObject";
		else if (o instanceof QueryObject)
			return "queryObject";
		else if (o instanceof Enumeration)
			return "enum";
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return "exception";
		else if (o instanceof Service)
			return "service";
		else
			return "";
	}
	
	private String getContainingObjectTypeName (EObject ele) {
		EObject o = ele.eContainer();
		if (o instanceof BusinessObject)
			return "businessObject";
		else if (o instanceof QueryObject)
			return "queryObject";
		else if (o instanceof Enumeration)
			return "enum";
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return "exception";
		else if (o instanceof Service)
			return "service";
		else
			return "";
	}

	private String getPubCanocicalName (GovernanceApproval g) {
		return "canonical";
	}
	
	private String getObjectName (GovernanceApproval g) {
		EObject o = g.eContainer();
		if (o instanceof VersionedType)
			return ((VersionedType) o).getName();
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return ((org.fornax.soa.serviceDsl.Exception) o).getName();
		else if (o instanceof Service)
			return ((Service) o).getName();
		else
			return null;
	}

}
