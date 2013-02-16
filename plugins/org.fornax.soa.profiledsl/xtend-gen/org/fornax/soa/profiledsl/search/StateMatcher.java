package org.fornax.soa.profiledsl.search;

import com.google.inject.Inject;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;

/**
 * @deprecated
 */
@SuppressWarnings("all")
public class StateMatcher {
  @Inject
  private IStateMatcher stateMatcher;
  
  public boolean matchesMinStateLevel(final LifecycleState state, final LifecycleState minState) {
    boolean _matches = this.stateMatcher.matches(minState, state);
    return _matches;
  }
}
