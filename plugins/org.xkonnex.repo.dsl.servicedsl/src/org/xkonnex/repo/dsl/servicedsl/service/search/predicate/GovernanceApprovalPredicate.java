package org.xkonnex.repo.dsl.servicedsl.service.search.predicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.Version;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ApprovalDecision;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.GovernanceApproval;

import com.google.common.base.Predicate;

public class GovernanceApprovalPredicate implements
		Predicate<IEObjectDescription> {
	
	private static final String GOVERNANCE_APPROVAL = "governanceApproval";
	private boolean includeTolerated;
	private ResourceSet resourceSet;
	
	public GovernanceApprovalPredicate(boolean includeTolerated, ResourceSet rs) {
		this.includeTolerated = includeTolerated;
		this.resourceSet = rs;
	}

	public boolean apply(IEObjectDescription input) {
		EObject eObjectOrProxy = input.getEObjectOrProxy();
		if (eObjectOrProxy.eIsProxy()) {
			eObjectOrProxy = EcoreUtil2.resolve (eObjectOrProxy, resourceSet);
		}
		if (!eObjectOrProxy.eIsProxy()) {
			final EStructuralFeature approvalFeature = eObjectOrProxy.eClass()
					.getEStructuralFeature(GOVERNANCE_APPROVAL);
			if (approvalFeature != null && eObjectOrProxy.eIsSet(approvalFeature)) {
				Object obj = eObjectOrProxy.eGet (approvalFeature, true);
				if (obj instanceof GovernanceApproval) {
					GovernanceApproval approval = (GovernanceApproval) obj;
					if (approval != null) {
						if (includeTolerated && approval.getDecision() != ApprovalDecision.NO) {
							return true;
						} else if (approval.getDecision() == ApprovalDecision.YES) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
