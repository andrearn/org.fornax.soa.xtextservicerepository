package org.fornax.soa.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.search.IReferenceSearch;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.OperationBinding;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.query.ModuleLookup;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.serviceDsl.SubNamespace;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

public class BindingDslHelper {

	@Inject
	LifecycleStateComparator stateComparator;
	
	@Inject
	ModuleLookup moduleLookup;
	
	@Inject
	IReferenceSearch referenceSearch;
	
	@Inject
	IEObjectLookup objLookup;

	public static Environment getEnvironment (BindingProtocol prot) {
		EObject o = prot.eContainer();
		if (o instanceof Binding)
			return getEnvironment((Binding)o);
		return null;
	}

	public static Environment getEnvironment (Binding bind) {
		if (bind instanceof ServiceBinding)
			if (((ServiceBinding)bind).eContainer() instanceof ModuleBinding)
				return ((ModuleBinding)((ServiceBinding)bind).eContainer()).getEnvironment();
		if (bind instanceof ModuleBinding)
			return ((ModuleBinding)bind).getEnvironment();
		if (bind instanceof OperationBinding)
			if (((ServiceBinding)bind).eContainer() instanceof ModuleBinding)
				return ((ModuleBinding)((ServiceBinding)bind).eContainer().eContainer()).getEnvironment();
		return null;
	}
	
	public static Binding getTopLevelBinding (EObject o) {
		if (o instanceof ModuleBinding) {
			return (Binding)o;
		} else if (o.eContainer() != null) {
			return getTopLevelBinding(o.eContainer());
		} else {
			return null;
		}
	}
	
	public static Environment getTargetEnvironment (EObject o) {
		Binding bind = getTopLevelBinding(o);
		if (bind instanceof ModuleBinding)
			return ((ModuleBinding) bind).getEnvironment();
		else
			return null;
	}
	
	public static SubNamespace getSubNamespace (BindingProtocol prot) {
		EObject o = prot.eContainer();
		if (o instanceof ServiceBinding)
			return (SubNamespace) ((ServiceBinding)o).getService().getService().eContainer();
		if (o instanceof OperationBinding)
			return (SubNamespace) ((ServiceBinding)o.eContainer()).getService().getService().eContainer();
		return null;
	}
	
	public Set<ModuleBinding> getBindingsForModule (Module module) {
		final Set<ModuleBinding> moduleBindings = new HashSet<ModuleBinding>();
		final ResourceSet rs = module.eResource().getResourceSet();
		IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {

			public void accept(IReferenceDescription ref) {
				EObject eObject = objLookup.getModelElementByURI (ref.getSourceEObjectUri(), rs);
				eObject = EcoreUtil.resolve(eObject, rs);
				if (eObject != null && eObject.eContainer() instanceof ModuleBinding) {
					moduleBindings.add ((ModuleBinding) eObject.eContainer());
				}
			}
			
		};
		referenceSearch.findAllReferences(module, module.eResource().getResourceSet(), new Predicate<IReferenceDescription>() {
			
			public boolean apply(IReferenceDescription input) {
				EObject eObject = objLookup.getModelElementByURI (input.getSourceEObjectUri(), rs);
				if (eObject != null && eObject.eContainer() instanceof ModuleBinding)
					return true;
				else 
					return false;
			}
			
		}, acceptor);
		return moduleBindings;
	}

}
