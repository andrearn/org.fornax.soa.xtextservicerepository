package org.fornax.soa.moduledsl.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.fornax.soa.basedsl.metamodel.MetamodelAccess;
import org.fornax.soa.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage;
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.profiledsl.util.ReferencedStateChecker;
import org.fornax.soa.service.query.VersionedObjectQueryHelper;
import org.fornax.soa.serviceDsl.ServiceDslPackage;

import com.google.inject.Inject;

public class ModuleLifecycleStateValidator extends AbstractPluggableDeclarativeValidator {

	@Inject ReferencedStateChecker referencedStateChecker;
	@Inject IStateMatcher stateMatcher;
	@Inject LifecycleStateComparator stateComparator;
	@Inject MetamodelAccess metamodelAccess;
	

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage.eINSTANCE);
		return result;
	}
	
	
	@Check (CheckType.FAST)
	public void checkNotUsesLowerStateService(ImportServiceRef svcRef) {
		EObject owner = metamodelAccess.getVersionedOwner(svcRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null) {
			if (stateComparator.compare (ownerState, svcRef.getService().getState()) > 0 && !ownerState.isIsEnd()) {
				if (referencedStateChecker.stateMatches (svcRef.getService().getState(), owner))
					warning ("A service with a lower lifecycle-state is being provided by the module. You should review the referenced service "+ svcRef.getService().getName() + " and adjust it's lifecycle-state.", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
				else
					error ("A service with a lower lifecycle-state not supporting all required environments is being provided by the module. You should review the referenced service "+ svcRef.getService().getName() + " and adjust it's lifecycle-state.", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
			}
		}
	}
	
	@Check (CheckType.FAST)
	public void checkNotUsesLowerStateModule(ModuleRef modRef) {
		EObject owner = metamodelAccess.getVersionedOwner(modRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
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
		EObject owner = metamodelAccess.getVersionedOwner(svcRef);
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState(owner);
		if (owner != null) {
			if (stateComparator.compare (ownerState, svcRef.getService().getState()) > 0 && !ownerState.isIsEnd()) {
				if (referencedStateChecker.stateMatches (svcRef.getService().getState(), owner))
					warning ("A service with a lower lifecycle-state is being used by the module. You should review the referenced service "+ svcRef.getService().getName() + " and adjust it's lifecycle-state.", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
				else
					error ("A service with a lower lifecycle-state not supporting all required environments is being used by the module. You should review the referenced service "+ svcRef.getService().getName() + " and adjust it's lifecycle-state.", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
			}
		}
	}


}
