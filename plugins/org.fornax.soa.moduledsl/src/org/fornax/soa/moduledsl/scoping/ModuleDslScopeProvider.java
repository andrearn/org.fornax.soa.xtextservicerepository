/*
 * generated by Xtext
 */
package org.fornax.soa.moduledsl.scoping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.sOABaseDsl.FixedVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.FixedVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.NullVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.VersionedImportedNamespaceAwareScopeProvider;
import org.fornax.soa.basedsl.version.IScopeVersionResolver;
import org.fornax.soa.basedsl.version.SimpleScopeVersionResolver;
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage;
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.NamespaceRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef;
import org.fornax.soa.moduledsl.query.IModuleServiceResolver;
import org.fornax.soa.moduledsl.query.ModuleLookup;
import org.fornax.soa.moduledsl.util.ModuleDslAccess;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.RelaxedLatestMajorVersionForOwnerStateFilter;
import org.fornax.soa.profiledsl.scoping.versions.RelaxedLatestMinMaxVersionForOwnerStateFilter;
import org.fornax.soa.profiledsl.scoping.versions.RelaxedLatestMinVersionForOwnerStateFilter;
import org.fornax.soa.profiledsl.scoping.versions.RelaxedMaxVersionForOwnerStateFilter;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.service.util.CandidateServicesPredicate;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class ModuleDslScopeProvider extends VersionedImportedNamespaceAwareScopeProvider {

	
	@Inject Injector injector;
	
	@Inject ModuleLookup modLookup;
	@Inject IModuleServiceResolver modServiceResolver;
	@Inject IQualifiedNameProvider nameProvider;
	@Inject ILifecycleStateResolver stateResolver; 

	@Override
	protected AbstractPredicateVersionFilter<IEObjectDescription> getVersionFilterFromContext(
			EObject context, EReference reference) {
		if (reference == ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE && context instanceof ServiceRef) {
			final VersionRef v = ((ServiceRef) context).getVersionRef();
			AbstractPredicateVersionFilter<IEObjectDescription> versionFilter = createVersionFilter(v, context);
			if (context.eContainer() instanceof ModuleRef) {
				
				ModuleRef modRef = (ModuleRef) context.eContainer();
				Set<AbstractServiceRef> providedServiceRefs = modServiceResolver.getAllProvidedServiceRefs(modRef.getModuleRef().getModule());
				if (!providedServiceRefs.isEmpty()) {
					final List<QualifiedName> provServiceNames = new ArrayList<QualifiedName>();
					for (AbstractServiceRef provSvcRef : providedServiceRefs) {
						provServiceNames.add(nameProvider.getFullyQualifiedName(provSvcRef.getService()));
					}
					createServiceNameFilter(versionFilter, provServiceNames);
				}
			} else if (context.eContainer() instanceof NamespaceRef) {
				NamespaceRef nsRef = (NamespaceRef)context.eContainer();
				List<Service> services = nsRef.getNamespace().getServices();
				final List<QualifiedName> provServiceNames = new ArrayList<QualifiedName>();
				for (Service provSvc : services) {
					provServiceNames.add(nameProvider.getFullyQualifiedName(provSvc));
				}
				createServiceNameFilter(versionFilter, provServiceNames);
			}
			return versionFilter;
		}
		if (reference == ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE && context instanceof ImportServiceRef) {
			final VersionRef v = ((ImportServiceRef) context).getVersionRef();
			ImportServiceRef impSvcRef = (ImportServiceRef) context;
			Module owningModule = ModuleDslAccess.getOwningModule(impSvcRef);
			final List<ServiceModuleRef> modules = impSvcRef.getModules();
			List<Service> candServices = new ArrayList<Service>();
			if (modules.isEmpty()) {
				Set<Module> allModules = modLookup.findAllModules (context.eResource().getResourceSet());
				for (Module mod : allModules) {
					if (!mod.equals(owningModule)) {
						extractProvidedServices(context, candServices, mod);
					}
				}
			} else {
				for (ServiceModuleRef ref : modules) {
					Module targetModule = ref.getModule();
					//TODO filter modules, that are don not have one of the accepted qualifiers
					extractProvidedServices(context, candServices, targetModule);
				}
			}
 
			if (!candServices.isEmpty())
				return createVersionFilter(v, context, candServices);
			else
				return createVersionFilter(v, context);
		}
		if (reference == ModuleDslPackage.Literals.SERVICE_MODULE_REF__MODULE && context instanceof ServiceModuleRef) {
			final VersionRef v = ((ServiceModuleRef) context).getVersion();
			Module owningModule = ModuleDslAccess.getOwningModule (context);
			return createVersionFilter(v, owningModule);
		}
		return new NullVersionFilter<IEObjectDescription>();
	}

	private void createServiceNameFilter(
			AbstractPredicateVersionFilter<IEObjectDescription> versionFilter,
			final List<QualifiedName> provServiceNames) {
		versionFilter.setPreFilterPredicate(new Predicate<IEObjectDescription> () {

			public boolean apply(IEObjectDescription input) {
				for (QualifiedName name : provServiceNames) {
					if (ServiceDslPackage.Literals.SERVICE.equals(input.getEClass()) && input.getQualifiedName() != null && name != null && input.getQualifiedName().startsWith(name)) {
						return true;
					}
				}
				return false;
			}
			
		});
	}

	private void extractProvidedServices(EObject context,
			List<Service> candServices, Module targetModule) {
		if (targetModule != null) {
			if (targetModule.eIsProxy())
				targetModule = (Module) EcoreUtil.resolve (targetModule, context.eResource().getResourceSet());
			Set<AbstractServiceRef> providedServiceRefs = modServiceResolver.getAllProvidedServiceRefs(targetModule);
			for (AbstractServiceRef svcRef : providedServiceRefs) {
				if (svcRef.eIsProxy()) {
					svcRef = (ServiceRef) EcoreUtil.resolve (svcRef, context.eResource().getResourceSet());
				}
				if (svcRef.getService() != null)
					candServices.add (svcRef.getService());
			}
		}
	}

	@Override
	protected AbstractPredicateVersionFilter<IEObjectDescription> createVersionFilter(final VersionRef v, EObject owner) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = new NullVersionFilter<IEObjectDescription>();
		if (v != null) {
			IScopeVersionResolver verResolver = new SimpleScopeVersionResolver (v.eResource().getResourceSet());
			LifecycleState ownerState = stateResolver.getLifecycleState(owner);
			if (v instanceof MajorVersionRef) {
				RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), stateResolver, ownerState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MaxVersionRef) {
				RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription>(verResolver, ((MaxVersionRef)v).getMaxVersion(), stateResolver, ownerState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MinVersionRef) {
				RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription>(verResolver, ((MinVersionRef)v).getMinVersion(), stateResolver, ownerState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof LowerBoundRangeVersionRef) {
				RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription>(verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion(), stateResolver, ownerState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof FixedVersionRef)
				return new FixedVersionFilter<IEObjectDescription>(verResolver, ((FixedVersionRef) v).getFixedVersion());
		}
		return filter;
	}
	
	protected AbstractPredicateVersionFilter<IEObjectDescription> createVersionFilter(final VersionRef v, EObject owner, List<Service> candidates) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = new NullVersionFilter<IEObjectDescription>();
		if (v != null) {
			IScopeVersionResolver verResolver = new SimpleScopeVersionResolver (v.eResource().getResourceSet());
			LifecycleState ownerState = stateResolver.getLifecycleState(owner);
			
			if (candidates != null && !candidates.isEmpty()) {
				
				CandidateServicesPredicate pred = new CandidateServicesPredicate(candidates, v.eResource().getResourceSet());
				injector.injectMembers(pred);
			
				if (v instanceof MajorVersionRef) {
					RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), stateResolver, ownerState, v.eResource().getResourceSet());
					injector.injectMembers (stateFilter);
					stateFilter.setPreFilterPredicate (pred);
					return stateFilter;
				}
				if (v instanceof MaxVersionRef) {
					RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription> latestMaxExclVersionFilter = new RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription>(verResolver, ((MaxVersionRef)v).getMaxVersion(), stateResolver, ownerState, v.eResource().getResourceSet());
					injector.injectMembers (latestMaxExclVersionFilter);
					latestMaxExclVersionFilter.setPreFilterPredicate(pred);
					return latestMaxExclVersionFilter;
				}
				if (v instanceof MinVersionRef) {
					RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription> latestMinInclVersionFilter = new RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription>(verResolver, ((MinVersionRef)v).getMinVersion(), stateResolver, ownerState, v.eResource().getResourceSet());
					injector.injectMembers (latestMinInclVersionFilter);
					latestMinInclVersionFilter.setPreFilterPredicate(pred);
					return latestMinInclVersionFilter;
				}
				if (v instanceof LowerBoundRangeVersionRef) {
					RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription> latestMinInclMaxExclRangeVersionFilter = new RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription>(verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion(), stateResolver, ownerState, v.eResource().getResourceSet());
					injector.injectMembers (latestMinInclMaxExclRangeVersionFilter);
					latestMinInclMaxExclRangeVersionFilter.setPreFilterPredicate(pred);
					return latestMinInclMaxExclRangeVersionFilter;
				}
				if (v instanceof FixedVersionRef) {
					FixedVersionFilter<IEObjectDescription> fixedVersionFilter = new FixedVersionFilter<IEObjectDescription>(verResolver, ((FixedVersionRef) v).getFixedVersion());
					fixedVersionFilter.setPreFilterPredicate(pred);
					return fixedVersionFilter;
				}
			} else {
				createVersionFilter(v, owner);
			}
		}
		return filter;
	}
}
