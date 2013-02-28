package org.fornax.soa.servicerepo.query.predicates;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.search.predicate.StrictLifecycleStatePredicate;
import org.fornax.soa.serviceDsl.ApprovalDecision;
import org.fornax.soa.serviceDsl.GovernanceApproval;
import org.fornax.soa.serviceDsl.InternalNamespace;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;
import com.google.inject.Injector;


public class FindUnapprovedAssetsQuery {
	
	@Inject IPredicateSearch search;
	
	@Inject Injector injector;

	public Iterable<IEObjectDescription> search (String pattern, String assetType, LifecycleState minState, LifecycleState maxState, String minVersion, String maxVersion, boolean inclCanonicalModel, boolean inclNonCanonicalModel, final ResourceSet resourceSet) {
		if (assetType == null)
			assetType = "";
		Predicate<IEObjectDescription> govPredicate = new Predicate<IEObjectDescription>() {

			public boolean apply (final IEObjectDescription objDesc) {
				EObject eObjectOrProxy = objDesc.getEObjectOrProxy ();
				final EStructuralFeature approvalFeature = objDesc.getEClass().getEStructuralFeature("governanceApproval");
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
			
		};
		StrictLifecycleStatePredicate statePredicate = new StrictLifecycleStatePredicate(minState, maxState, minVersion, maxVersion, resourceSet);
		injector.injectMembers(statePredicate);
		CanonicalOrNotPredicate canonicalPredicate = new CanonicalOrNotPredicate(inclCanonicalModel, inclNonCanonicalModel, resourceSet);
		injector.injectMembers(canonicalPredicate);
		Iterable<IEObjectDescription> result = search.search (pattern, assetType, Predicates.and(statePredicate, Predicates.and (statePredicate, canonicalPredicate, govPredicate)));
		return result;
	}
}
