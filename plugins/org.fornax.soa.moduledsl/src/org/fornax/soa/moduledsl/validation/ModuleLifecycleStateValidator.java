package org.fornax.soa.moduledsl.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage;
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.profiledsl.util.ReferencedStateChecker;

import com.google.inject.Inject;

public class ModuleLifecycleStateValidator extends AbstractPluggableDeclarativeValidator {

	@Inject 
	private ReferencedStateChecker referencedStateChecker;
	@Inject 
	private IStateMatcher stateMatcher;
	@Inject 
	private LifecycleStateComparator stateComparator;
	@Inject 
	private IEObjectLookup objLookup;
	@Inject 
	private ILifecycleStateResolver stateResolver;
	@Inject 
	private StateAttributeLifecycleStateResolver staticStateResolver;
	@Inject 
	private IResourceServiceProvider resourceServiceProvider;

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage.eINSTANCE);
		return result;
	}
	
	
	@Check (CheckType.FAST)
	public void checkNotUsesLowerStateService(ImportServiceRef svcRef) {
		EObject owner = objLookup.getVersionedOwner(svcRef);
		LifecycleState ownerState = staticStateResolver.getLifecycleState(owner);
		LifecycleState referredServiceState = staticStateResolver.getLifecycleState(svcRef.getService());
		if (owner != null) {
			if (stateComparator.compare (ownerState, referredServiceState) > 0 && !ownerState.isIsEnd()) {
				if (referencedStateChecker.stateMatches (referredServiceState, owner))
					warning ("A service with a lower lifecycle-state is being provided by the module. You should review the referenced service "+ svcRef.getService().getName() + " and adjust it's lifecycle-state.", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
				else
					error ("A service with a lower lifecycle-state not supporting all required environments is being provided by the module. You should review the referenced service "+ svcRef.getService().getName() + " and adjust it's lifecycle-state.", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
			}
		}
	}
	
	@Check (CheckType.FAST)
	public void checkNotUsesLowerStateModule(ModuleRef modRef) {
		EObject owner = objLookup.getVersionedOwner(modRef);
		LifecycleState ownerState = staticStateResolver.getLifecycleState(owner);
		if (owner != null) {
			if (stateComparator.compare (ownerState, modRef.getModuleRef().getModule().getState()) > 0 && !ownerState.isIsEnd()) {
				if (referencedStateChecker.stateMatches (modRef.getModuleRef().getModule().getState(), owner))
					warning ("A module with a lower lifecycle-state is being used by the module. You should review the referenced module " + modRef.getModuleRef().getModule().getName() + " and adjust it's lifecycle-state.", ModuleDslPackage.Literals.MODULE_REF__MODULE_REF);
				else
					error ("A module with a lower lifecycle-state not supporting all required environments is being used by the module. You should review the referenced module " + modRef.getModuleRef().getModule().getName() + " and adjust it's lifecycle-state.", ModuleDslPackage.Literals.MODULE_REF__MODULE_REF);
			}
		}
	}
	
	@Check (CheckType.FAST)
	public void checkNotProvidesLowerStateService(ServiceRef svcRef) {
		EObject owner = objLookup.getVersionedOwner(svcRef);
		LifecycleState ownerState = staticStateResolver.getLifecycleState(owner);
		LifecycleState referredServiceState = staticStateResolver.getLifecycleState(svcRef.getService());
		if (owner != null) {
			if (stateComparator.compare (ownerState, referredServiceState) > 0 && !ownerState.isIsEnd()) {
				if (referencedStateChecker.stateMatches (referredServiceState, owner))
					warning ("A service with a lower lifecycle-state is being used by the module. You should review the referenced service "+ svcRef.getService().getName() + " and adjust it's lifecycle-state.", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
				else
					error ("A service with a lower lifecycle-state not supporting all required environments is being used by the module. You should review the referenced service "+ svcRef.getService().getName() + " and adjust it's lifecycle-state.", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
			}
		}
	}


}
