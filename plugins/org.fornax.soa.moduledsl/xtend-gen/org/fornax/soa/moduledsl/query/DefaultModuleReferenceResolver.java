package org.fornax.soa.moduledsl.query;

import com.google.common.base.Objects;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.scoping.versions.filter.VersionFilter;
import org.fornax.soa.basedsl.search.IEObjectDescriptionIsInstancePredicate;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.basedsl.search.IReferenceSearch;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef;
import org.fornax.soa.moduledsl.query.DeployedModuleInEnvironmentPredicate;
import org.fornax.soa.moduledsl.query.IModuleReferenceResolver;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.IVersionFilterProvider;

@SuppressWarnings("all")
public class DefaultModuleReferenceResolver implements IModuleReferenceResolver {
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  @Inject
  private IVersionFilterProvider versionFilterProvider;
  
  @Inject
  private IPredicateSearch search;
  
  @Inject
  private IStateMatcher stateMatcher;
  
  @Inject
  private IReferenceSearch referenceSearch;
  
  public Module resolveModuleRef(final ModuleRef moduleRef, final LifecycleState minState) {
    ServiceModuleRef _moduleRef = moduleRef.getModuleRef();
    Module _resolveModuleServiceRef = this.resolveModuleServiceRef(_moduleRef, minState);
    return _resolveModuleServiceRef;
  }
  
  public Module resolveModuleServiceRef(final ServiceModuleRef moduleRef, final LifecycleState minState) {
    Module _module = moduleRef.getModule();
    final QualifiedName moduleName = this.nameProvider.getFullyQualifiedName(_module);
    String _string = moduleName.toString();
    IEObjectDescriptionIsInstancePredicate _iEObjectDescriptionIsInstancePredicate = new IEObjectDescriptionIsInstancePredicate(Module.class);
    final Iterable<IEObjectDescription> moduleDescs = this.search.search(_string, "Module ", _iEObjectDescriptionIsInstancePredicate);
    VersionRef _version = moduleRef.getVersion();
    final VersionFilter versionFilter = this.versionFilterProvider.createVersionFilter(_version, minState);
    final Multimap<QualifiedName,IEObjectDescription> moduleMap = versionFilter.getBestMatchByNames(moduleDescs, false);
    Collection<IEObjectDescription> _get = moduleMap.get(moduleName);
    IEObjectDescription _head = _get==null?(IEObjectDescription)null:IterableExtensions.<IEObjectDescription>head(_get);
    final IEObjectDescription resolvedModuleDesc = ((IEObjectDescription) _head);
    EObject _eObjectOrProxy = resolvedModuleDesc.getEObjectOrProxy();
    Module resolvedMod = ((Module) _eObjectOrProxy);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(resolvedMod, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _eIsProxy = resolvedMod.eIsProxy();
      _and = (_notEquals && _eIsProxy);
    }
    if (_and) {
      Resource _eResource = moduleRef.eResource();
      ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
      EObject _resolve = EcoreUtil2.resolve(resolvedMod, _resourceSet);
      resolvedMod = ((Module) _resolve);
    }
    return resolvedMod;
  }
  
  public Module resolveModuleRef(final ModuleRef moduleRef, final Environment targetEnvironment, final Lifecycle lifecycle) {
    Module _xblockexpression = null;
    {
      final LifecycleState minState = this.stateMatcher.getLowestStateByEnvironment(lifecycle, targetEnvironment);
      Module _resolveModuleRef = this.resolveModuleRef(moduleRef, minState);
      _xblockexpression = (_resolveModuleRef);
    }
    return _xblockexpression;
  }
  
  public Module resolveModuleServiceRef(final ServiceModuleRef moduleRef, final Environment targetEnvironment, final Lifecycle lifecycle) {
    Module _xblockexpression = null;
    {
      final LifecycleState minState = this.stateMatcher.getLowestStateByEnvironment(lifecycle, targetEnvironment);
      Module _resolveModuleServiceRef = this.resolveModuleServiceRef(moduleRef, minState);
      _xblockexpression = (_resolveModuleServiceRef);
    }
    return _xblockexpression;
  }
  
  public Module resolveModuleRef(final ModuleRef moduleRef, final Environment targetEnvironment, final Lifecycle lifecycle, final EndpointQualifierRef endpointQualifierRef, final ImportBindingProtocol usedProtocol) {
    final ServiceModuleRef svcModuleRef = moduleRef.getModuleRef();
    final LifecycleState minState = this.stateMatcher.getLowestStateByEnvironment(lifecycle, targetEnvironment);
    Module _module = svcModuleRef.getModule();
    final QualifiedName moduleName = this.nameProvider.getFullyQualifiedName(_module);
    String _string = moduleName.toString();
    IEObjectDescriptionIsInstancePredicate _iEObjectDescriptionIsInstancePredicate = new IEObjectDescriptionIsInstancePredicate(Module.class);
    final Iterable<IEObjectDescription> moduleDescs = this.search.search(_string, "Module ", _iEObjectDescriptionIsInstancePredicate);
    DeployedModuleInEnvironmentPredicate _deployedModuleInEnvironmentPredicate = new DeployedModuleInEnvironmentPredicate(targetEnvironment, endpointQualifierRef, this.referenceSearch);
    final DeployedModuleInEnvironmentPredicate deployedModulePredicate = _deployedModuleInEnvironmentPredicate;
    VersionRef _version = svcModuleRef.getVersion();
    VersionFilter versionFilter = this.versionFilterProvider.createVersionFilter(_version, minState, deployedModulePredicate);
    final Multimap<QualifiedName,IEObjectDescription> moduleMap = versionFilter.getBestMatchByNames(moduleDescs, false);
    Collection<IEObjectDescription> _get = moduleMap.get(moduleName);
    IEObjectDescription _head = _get==null?(IEObjectDescription)null:IterableExtensions.<IEObjectDescription>head(_get);
    final IEObjectDescription resolvedModuleDesc = ((IEObjectDescription) _head);
    EObject _eObjectOrProxy = resolvedModuleDesc.getEObjectOrProxy();
    Module resolvedMod = ((Module) _eObjectOrProxy);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(resolvedMod, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _eIsProxy = resolvedMod.eIsProxy();
      _and = (_notEquals && _eIsProxy);
    }
    if (_and) {
      Resource _eResource = svcModuleRef.eResource();
      ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
      EObject _resolve = EcoreUtil2.resolve(resolvedMod, _resourceSet);
      resolvedMod = ((Module) _resolve);
    }
    return resolvedMod;
  }
  
  public Module resolveModuleServiceRef(final ServiceModuleRef moduleRef, final Environment targetEnvironment, final Lifecycle lifecycle, final EndpointQualifierRef endpointQualifierRef, final ImportBindingProtocol usedProtocol) {
    final LifecycleState minState = this.stateMatcher.getLowestStateByEnvironment(lifecycle, targetEnvironment);
    Module _module = moduleRef.getModule();
    final QualifiedName moduleName = this.nameProvider.getFullyQualifiedName(_module);
    String _string = moduleName.toString();
    IEObjectDescriptionIsInstancePredicate _iEObjectDescriptionIsInstancePredicate = new IEObjectDescriptionIsInstancePredicate(Module.class);
    final Iterable<IEObjectDescription> moduleDescs = this.search.search(_string, "Module ", _iEObjectDescriptionIsInstancePredicate);
    DeployedModuleInEnvironmentPredicate _deployedModuleInEnvironmentPredicate = new DeployedModuleInEnvironmentPredicate(targetEnvironment, endpointQualifierRef, this.referenceSearch);
    final DeployedModuleInEnvironmentPredicate deployedModulePredicate = _deployedModuleInEnvironmentPredicate;
    VersionRef _version = moduleRef.getVersion();
    VersionFilter versionFilter = this.versionFilterProvider.createVersionFilter(_version, minState, deployedModulePredicate);
    final Multimap<QualifiedName,IEObjectDescription> moduleMap = versionFilter.getBestMatchByNames(moduleDescs, false);
    Collection<IEObjectDescription> _get = moduleMap.get(moduleName);
    IEObjectDescription _head = _get==null?(IEObjectDescription)null:IterableExtensions.<IEObjectDescription>head(_get);
    final IEObjectDescription resolvedModuleDesc = ((IEObjectDescription) _head);
    EObject _eObjectOrProxy = resolvedModuleDesc.getEObjectOrProxy();
    Module resolvedMod = ((Module) _eObjectOrProxy);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(resolvedMod, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _eIsProxy = resolvedMod.eIsProxy();
      _and = (_notEquals && _eIsProxy);
    }
    if (_and) {
      Resource _eResource = moduleRef.eResource();
      ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
      EObject _resolve = EcoreUtil2.resolve(resolvedMod, _resourceSet);
      resolvedMod = ((Module) _resolve);
    }
    return resolvedMod;
  }
}
