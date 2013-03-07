package org.fornax.soa.binding.query.environment;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.VersionedType;

/**
 * Checks, whether an asset is eligible for an environment with regard to it's lifecycle state
 */
@SuppressWarnings("all")
public class AssetStateEnvironmentEligibilityChecker {
  @Inject
  private LifecycleQueries _lifecycleQueries;
  
  @Inject
  private IStateMatcher stateMatcher;
  
  protected boolean _isEligibleForEnvironment(final EObject asset, final Environment env) {
    boolean _hasLifecycleState = this._lifecycleQueries.hasLifecycleState(asset);
    if (_hasLifecycleState) {
      final LifecycleState assetState = this._lifecycleQueries.getAssetLifecycleState(asset);
      EObject _eContainer = assetState.eContainer();
      LifecycleState _minLifecycleState = this._lifecycleQueries.getMinLifecycleState(env, ((Lifecycle) _eContainer));
      return this.stateMatcher.matches(_minLifecycleState, assetState);
    } else {
      return true;
    }
  }
  
  protected boolean _isEligibleForEnvironment(final Service service, final Environment env) {
    LifecycleState _state = service.getState();
    EObject _eContainer = _state.eContainer();
    LifecycleState _minLifecycleState = this._lifecycleQueries.getMinLifecycleState(env, ((Lifecycle) _eContainer));
    LifecycleState _state_1 = service.getState();
    boolean _matches = this.stateMatcher.matches(_minLifecycleState, _state_1);
    return _matches;
  }
  
  protected boolean _isEligibleForEnvironment(final VersionedType type, final Environment env) {
    LifecycleState _state = type.getState();
    EObject _eContainer = _state.eContainer();
    LifecycleState _minLifecycleState = this._lifecycleQueries.getMinLifecycleState(env, ((Lifecycle) _eContainer));
    LifecycleState _state_1 = type.getState();
    boolean _matches = this.stateMatcher.matches(_minLifecycleState, _state_1);
    return _matches;
  }
  
  protected boolean _isEligibleForEnvironment(final org.fornax.soa.serviceDsl.Exception exception, final Environment env) {
    LifecycleState _state = exception.getState();
    EObject _eContainer = _state.eContainer();
    LifecycleState _minLifecycleState = this._lifecycleQueries.getMinLifecycleState(env, ((Lifecycle) _eContainer));
    LifecycleState _state_1 = exception.getState();
    boolean _matches = this.stateMatcher.matches(_minLifecycleState, _state_1);
    return _matches;
  }
  
  public boolean isEligibleForEnvironment(final EObject type, final Environment env) {
    if (type instanceof VersionedType) {
      return _isEligibleForEnvironment((VersionedType)type, env);
    } else if (type instanceof org.fornax.soa.serviceDsl.Exception) {
      return _isEligibleForEnvironment((org.fornax.soa.serviceDsl.Exception)type, env);
    } else if (type instanceof Service) {
      return _isEligibleForEnvironment((Service)type, env);
    } else if (type != null) {
      return _isEligibleForEnvironment(type, env);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type, env).toString());
    }
  }
}
