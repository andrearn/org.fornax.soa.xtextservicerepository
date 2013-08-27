package org.fornax.soa.service.state;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.profiledsl.state.StateCollectorModelVisitor;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.VersionedType;

public class ServiceDslStateCollectorVisitor extends StateCollectorModelVisitor {

	public ServiceDslStateCollectorVisitor(ResourceSet resourceSet,
			StateAttributeLifecycleStateResolver stateAttrResolver) {
		super(resourceSet, stateAttrResolver);
	}
	
	protected boolean isEligibleType(IEObjectDescription modelElement) {
		EObject obj = modelElement.getEObjectOrProxy();
		if (obj instanceof VersionedType ||
				obj instanceof Service ||
				"Module".equals(obj.eClass().getName()) && 
				"http://www.fornax.org/soa/moduledsl/ModuleDsl".equals (obj.eClass().getEPackage().getNsURI())) {
			return true;
		}
		return false;
	}

}
