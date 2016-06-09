package org.xkonnex.repo.dsl.bindingdsl.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch;
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.OperationBinding;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.query.ModuleLookup;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace;

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
	
	@Inject
	EnvironmentBindingResolver envBindResolver;

	
	public static Binding getTopLevelBinding (EObject o) {
		if (o instanceof ModuleBinding) {
			return (Binding)o;
		} else if (o.eContainer() != null) {
			return getTopLevelBinding(o.eContainer());
		} else {
			return null;
		}
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
