package org.fornax.soa.servicerepo.query.predicates;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.SubNamespace;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

public class CanonicalOrNotPredicate implements Predicate<IEObjectDescription> {
	
	@Inject IEObjectLookup objLookup;
	
	private boolean inclCanonicalModel;
	private boolean inclNonCanonicalModel;
	private ResourceSet resourceSet;
	
	public CanonicalOrNotPredicate(boolean inclCanonicalModel, boolean inclNonCanonicalModel, ResourceSet rs) {
		this.inclCanonicalModel = inclCanonicalModel;
		this.inclNonCanonicalModel = inclNonCanonicalModel;
		this.resourceSet = rs;
		
	}
	public boolean apply(IEObjectDescription input) {
		EObject o = input.getEObjectOrProxy();
		if (o.eIsProxy()) {
			o = EcoreUtil2.resolve(o, resourceSet);
		}
		SubNamespace ns = objLookup.getOwnerByType(o, SubNamespace.class);
		if (ns instanceof DomainNamespace) {
			return inclCanonicalModel;
		}
		if (ns instanceof InternalNamespace) {
			return inclNonCanonicalModel;
		}
		return true;
	}
	
}
