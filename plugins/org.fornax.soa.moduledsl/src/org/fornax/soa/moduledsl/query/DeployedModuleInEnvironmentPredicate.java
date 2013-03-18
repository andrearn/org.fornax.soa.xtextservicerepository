package org.fornax.soa.moduledsl.query;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.fornax.soa.basedsl.search.IReferenceSearch;
import org.fornax.soa.basedsl.search.ReferrerTypePredicate;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.semanticsDsl.Qualifier;

import com.google.common.base.Predicate;

public class DeployedModuleInEnvironmentPredicate implements
		Predicate<IEObjectDescription> {

	private Environment targetEnvironment;
	private EndpointQualifierRef referrerEndpointQualifierRef;
	private ResourceSet resourceSet;
	private IReferenceSearch refSearch;
	private Predicate<IReferenceDescription> moduleRefReferrerPredicate = new ReferrerTypePredicate("ModuleRef");
	
	public DeployedModuleInEnvironmentPredicate(Environment targetEnvironment,
			EndpointQualifierRef referrerEndpointQualifierRef, IReferenceSearch refSearch) {
		super();
		this.targetEnvironment = targetEnvironment;
		this.referrerEndpointQualifierRef = referrerEndpointQualifierRef;
		this.refSearch = refSearch;
		this.resourceSet = targetEnvironment.eResource().getResourceSet();
	}

	public boolean apply(IEObjectDescription input) {
		EObject obj = input.getEObjectOrProxy();
		if (obj instanceof Module) {
			Module mod = (Module)obj;
			if (mod.eIsProxy()) {
				mod = (Module) EcoreUtil2.resolve(mod, resourceSet);
			}
			final List<IReferenceDescription> bindings = new ArrayList<IReferenceDescription>();
			IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {

				public void accept(IReferenceDescription t) {
					if (t.getEReference().eContainer() != null && t.getEReference().eContainer().eContainer() != null && 
							"ModuleBinding".equals(t.getEReference().eContainer().eContainer().eClass()) ) {
						bindings.add(t);
					}
				}
			};
			refSearch.findAllReferences(mod, resourceSet, moduleRefReferrerPredicate, acceptor);
			for (IReferenceDescription candBindingRef : bindings) {
				if (candBindingRef.getTargetEObjectUri().equals(mod)) {
					EObject candBinding = candBindingRef.getEReference().eContainer().eContainer();
					if (isBoundByBinding(mod, candBinding)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean isBoundByBinding (Module module, EObject candBinding) {
		final EStructuralFeature envFeature = candBinding.eClass()
				.getEStructuralFeature("environment");
		final EStructuralFeature provServerFeature = candBinding.eClass()
				.getEStructuralFeature("provServer");
		final EStructuralFeature endpointQualifierRefFeature = candBinding.eClass()
				.getEStructuralFeature("endpointQualifierRef");
		
		Object env = candBinding.eGet(envFeature);
		EObject server = (EObject)candBinding.eGet(provServerFeature);
		EObject endpointQualifierRef = (EObject) candBinding.eGet(endpointQualifierRefFeature);
		
		if (env != null && env.equals(targetEnvironment)) {
			return matchesReferrerEndpointQualifier(endpointQualifierRef);
		} else if (server != null && server.eContainer().equals(targetEnvironment)) {
			return matchesReferrerEndpointQualifier(endpointQualifierRef);
		}
		return false;
	}

	private boolean matchesReferrerEndpointQualifier(
			EObject endpointQualifierRef) {
		if (referrerEndpointQualifierRef != null) {
			if (endpointQualifierRef != null) {
				final EStructuralFeature endpointQualifierFeature = endpointQualifierRef.eClass()
						.getEStructuralFeature("endpointQualifier");
				Object endpointQualifier = endpointQualifierRef.eGet(endpointQualifierFeature);
				if (referrerEndpointQualifierRef != null && referrerEndpointQualifierRef.getEndpointQualifier().equals(endpointQualifier)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	
	

}
