package org.xkonnex.repo.core.query;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.core.query.predicates.CanonicalOrNotPredicate;
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.search.predicate.VersionAndLifecycleStatePredicate;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ApprovalDecision;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.GovernanceApproval;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;
import com.google.inject.Injector;


public class FindUnapprovedAssetsQuery {
	
	private static final String GOVERNANCE_APPROVAL = "governanceApproval";

	@Inject IPredicateSearch search;
	
	@Inject Injector injector;

	public Iterable<IEObjectDescription> search (String pattern, String assetType, LifecycleState minState, LifecycleState maxState, String minVersion, String maxVersion, boolean inclCanonicalModel, boolean inclNonCanonicalModel, final ResourceSet resourceSet) {
		if (assetType == null)
			assetType = "";
		Predicate<IEObjectDescription> govPredicate = new Predicate<IEObjectDescription>() {

			public boolean apply (final IEObjectDescription objDesc) {
				EObject eObjectOrProxy = objDesc.getEObjectOrProxy ();
				final EStructuralFeature approvalFeature = objDesc.getEClass().getEStructuralFeature(GOVERNANCE_APPROVAL);
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
		VersionAndLifecycleStatePredicate statePredicate = new VersionAndLifecycleStatePredicate(minState, maxState, minVersion, maxVersion, resourceSet);
		injector.injectMembers(statePredicate);
		CanonicalOrNotPredicate canonicalPredicate = new CanonicalOrNotPredicate(inclCanonicalModel, inclNonCanonicalModel, resourceSet);
		injector.injectMembers(canonicalPredicate);
		Iterable<IEObjectDescription> result = search.search (pattern, assetType, Predicates.and(statePredicate, Predicates.and (statePredicate, canonicalPredicate, govPredicate)));
		return result;
	}
}
