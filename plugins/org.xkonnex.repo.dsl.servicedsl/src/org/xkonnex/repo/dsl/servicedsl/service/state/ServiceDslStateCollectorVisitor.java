package org.xkonnex.repo.dsl.servicedsl.service.state;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.state.StateCollectorModelVisitor;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType;

import com.google.inject.Inject;

public class ServiceDslStateCollectorVisitor extends StateCollectorModelVisitor {
	
	private static final String VERSION_REF_FEATURE = "versionRef";
	private static final String SERVICE_FEATURE = "service";
	private static final String PROVIDED_SERVICE_FEATURE = "providedServices";
	
	@Inject
	private IQualifiedNameProvider nameProvider;
	@Inject 
	private VersionMatcher versionMatcher;
	
	
	public ServiceDslStateCollectorVisitor(ResourceSet resourceSet,
			StateAttributeLifecycleStateResolver stateAttrResolver) {
		super(resourceSet, stateAttrResolver);
	}
	
	protected boolean isEligibleElement(IEObjectDescription modelElement, IEObjectDescription referrerElement) {
		EObject obj = modelElement.getEObjectOrProxy();
		if (obj instanceof VersionedType ||
				obj instanceof Service) {
			return true;
		} else if ("Module".equals(obj.eClass().getName()) && 
				"http://www.fornax.org/soa/moduledsl/ModuleDsl".equals (obj.eClass().getEPackage().getNsURI())) {
			return moduleProvidesServiceExplicitely (obj, referrerElement);
		}
		return false;
	}

	private boolean moduleProvidesServiceExplicitely(EObject obj, IEObjectDescription referrerElement) {
		if (obj.eIsProxy()) {
			obj = EcoreUtil2.resolve(obj, resourceSet);
		}
		EObject referrerObj = referrerElement.getEObjectOrProxy();
		if (referrerObj instanceof Service) {
			Service referredService = (Service)referrerObj;
			QualifiedName referredServiceName = nameProvider.getFullyQualifiedName(referredService);
			
			EStructuralFeature provServicesFeature = obj.eClass().getEStructuralFeature(PROVIDED_SERVICE_FEATURE);
			EList<EObject> provServiceRefs = (EList<EObject>) obj.eGet(provServicesFeature);
			
			if (provServiceRefs != null) {
				for (EObject svcRef : provServiceRefs) {
					EStructuralFeature serviceFeature = svcRef.eClass().getEStructuralFeature(SERVICE_FEATURE);
					EStructuralFeature versionRefFeature = svcRef.eClass().getEStructuralFeature(VERSION_REF_FEATURE);
					
					EObject svc = (EObject)svcRef.eGet(serviceFeature);
					VersionRef verRef = (VersionRef)svcRef.eGet(versionRefFeature);
							
					QualifiedName refServiceName = nameProvider.getFullyQualifiedName(svc);
					
					if (referredServiceName.equals(refServiceName) && 
							versionMatcher.versionMatches(referredService.getVersion(), verRef)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
