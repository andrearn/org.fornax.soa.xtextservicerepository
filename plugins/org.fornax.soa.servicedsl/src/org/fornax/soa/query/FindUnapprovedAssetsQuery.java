package org.fornax.soa.query;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.serviceDsl.ApprovalDecision;
import org.fornax.soa.serviceDsl.GovernanceApproval;
import org.fornax.soa.serviceDsl.InternalNamespace;

import com.google.common.base.Predicate;
import com.google.inject.Inject;


public class FindUnapprovedAssetsQuery {
	
	@Inject IPredicateSearch search;

	public Iterable<IEObjectDescription> search (String pattern, String assetType, final ResourceSet resourceSet) {
		if (assetType == null)
			assetType = "";
		Iterable<IEObjectDescription> result = search.search (pattern, assetType, new Predicate<IEObjectDescription>() {

			@Override
			public boolean apply (final IEObjectDescription objDesc) {
				EObject eObjectOrProxy = objDesc.getEObjectOrProxy ();
				final EStructuralFeature approvalFeature = eObjectOrProxy.eClass().getEStructuralFeature("governanceApproval");
				if (approvalFeature != null) {
					if (eObjectOrProxy.eIsProxy ()) {
						eObjectOrProxy = EcoreUtil2.resolve (eObjectOrProxy, resourceSet);
						EObject eContainer = eObjectOrProxy.eContainer();
						if (eObjectOrProxy.eIsSet(approvalFeature)) {
							Object govApprovalObj = eObjectOrProxy.eGet (approvalFeature, true);
							if (govApprovalObj instanceof GovernanceApproval) {
								GovernanceApproval govApproval = (GovernanceApproval)govApprovalObj;
								if (govApproval.getDecision () != ApprovalDecision.YES && !(eContainer instanceof InternalNamespace)) {
									return true;
								}
							}
						} else if (!(eContainer instanceof InternalNamespace)){
							return true;
						}
					}
				}
				return false;
			}
			
		});
		return result;
	}
}
