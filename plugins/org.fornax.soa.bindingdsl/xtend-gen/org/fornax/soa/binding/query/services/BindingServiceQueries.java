package org.fornax.soa.binding.query.services;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.serviceDsl.Service;

@SuppressWarnings("all")
public class BindingServiceQueries {
  @Inject
  private LifecycleQueries _lifecycleQueries;
  
  @Inject
  private IStateMatcher stateMatcher;
  
  protected boolean _isEligibleForEnvironment(final Service s, final Environment env) {
    LifecycleState _state = s.getState();
    EObject _eContainer = _state.eContainer();
    LifecycleState _minLifecycleState = this._lifecycleQueries.getMinLifecycleState(env, ((Lifecycle) _eContainer));
    LifecycleState _state_1 = s.getState();
    boolean _matches = this.stateMatcher.matches(_minLifecycleState, _state_1);
    return _matches;
  }
  
  public boolean isEligibleForEnvironment(final Service s, final Environment env) {
    {
      return _isEligibleForEnvironment(s, env);
    }
  }
}
