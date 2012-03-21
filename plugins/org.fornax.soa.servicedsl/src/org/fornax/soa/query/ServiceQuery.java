package org.fornax.soa.query;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.serviceDsl.ApprovalDecision;
import org.fornax.soa.serviceDsl.GovernanceApproval;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;

import com.google.common.base.Predicate;
import com.google.inject.Inject;


public class ServiceQuery {
	
	@Inject IPredicateSearch search;

	public Iterable<IEObjectDescription> findUnapprovedServices (ResourceSet res) {
		final ResourceSet resSet = res;
		Iterable<IEObjectDescription> result = search.search (ServiceDslPackage.Literals.SERVICE.getName (), new Predicate<IEObjectDescription>() {

			@Override
			public boolean apply (IEObjectDescription objDesc) {
				EObject eObjectOrProxy = objDesc.getEObjectOrProxy ();
				if (eObjectOrProxy.eIsProxy () && eObjectOrProxy instanceof Service) {
					Service svc = (Service) EcoreUtil2.resolve (eObjectOrProxy, resSet);
					if (svc.getGovernanceApproval () == null)
						return true;
					else if (svc.getGovernanceApproval ().getDecision () != ApprovalDecision.YES)
						return true;
				}
				return false;
			}
			
		});
		return result;
	}
}
