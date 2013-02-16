package org.fornax.soa.profiledsl.query;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.search.EObjectLookup;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.environmentDsl.EnvironmentType;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;

/**
 * Queries for lifecycle states
 */
@SuppressWarnings("all")
public class LifecycleQueries {
  private String STATE_ATTR_NAME = "state";
  
  @Inject
  private EObjectLookup lookup;
  
  @Inject
  private LifecycleStateComparator stateComparator;
  
  @Inject
  private IStateMatcher _iStateMatcher;
  
  public LifecycleState stateByName(final String state, final Resource res) {
    LifecycleState _modelElementByName = this.lookup.<LifecycleState>getModelElementByName(state, res, "LifecycleState");
    return _modelElementByName;
  }
  
  /**
   * Get the minimal state for an environment of type LOCAL based on a given lifecycle definition
   */
  public LifecycleState getMinLocalState(final Lifecycle lifecycleDefinition) {
    EList<LifecycleState> _states = lifecycleDefinition.getStates();
    final Function1<LifecycleState,Boolean> _function = new Function1<LifecycleState,Boolean>() {
        public Boolean apply(final LifecycleState s) {
          boolean _supportsEnvironmentType = LifecycleQueries.this._iStateMatcher.supportsEnvironmentType(s, EnvironmentType.LOCAL);
          return Boolean.valueOf(_supportsEnvironmentType);
        }
      };
    Iterable<LifecycleState> _filter = IterableExtensions.<LifecycleState>filter(_states, _function);
    List<LifecycleState> _sort = IterableExtensions.<LifecycleState>sort(_filter, this.stateComparator);
    LifecycleState _head = IterableExtensions.<LifecycleState>head(_sort);
    return _head;
  }
  
  /**
   * Get the minimal state for an environment of type DEV based on a given lifecycle definition
   */
  public LifecycleState getMinDevState(final Lifecycle lifecycleDefinition) {
    EList<LifecycleState> _states = lifecycleDefinition.getStates();
    final Function1<LifecycleState,Boolean> _function = new Function1<LifecycleState,Boolean>() {
        public Boolean apply(final LifecycleState s) {
          boolean _supportsEnvironmentType = LifecycleQueries.this._iStateMatcher.supportsEnvironmentType(s, EnvironmentType.DEV);
          return Boolean.valueOf(_supportsEnvironmentType);
        }
      };
    Iterable<LifecycleState> _filter = IterableExtensions.<LifecycleState>filter(_states, _function);
    List<LifecycleState> _sort = IterableExtensions.<LifecycleState>sort(_filter, this.stateComparator);
    LifecycleState _head = IterableExtensions.<LifecycleState>head(_sort);
    return _head;
  }
  
  /**
   * Get the minimal state for an environment of type TEST based on a given lifecycle definition
   */
  public LifecycleState getMinTestState(final Lifecycle lifecycleDefinition) {
    EList<LifecycleState> _states = lifecycleDefinition.getStates();
    final Function1<LifecycleState,Boolean> _function = new Function1<LifecycleState,Boolean>() {
        public Boolean apply(final LifecycleState s) {
          boolean _supportsEnvironmentType = LifecycleQueries.this._iStateMatcher.supportsEnvironmentType(s, EnvironmentType.TEST);
          return Boolean.valueOf(_supportsEnvironmentType);
        }
      };
    Iterable<LifecycleState> _filter = IterableExtensions.<LifecycleState>filter(_states, _function);
    List<LifecycleState> _sort = IterableExtensions.<LifecycleState>sort(_filter, this.stateComparator);
    LifecycleState _head = IterableExtensions.<LifecycleState>head(_sort);
    return _head;
  }
  
  /**
   * Get the minimal state for an environment of type STAGING based on a given lifecycle definition
   */
  public LifecycleState getMinStagingState(final Lifecycle lifecycleDefinition) {
    EList<LifecycleState> _states = lifecycleDefinition.getStates();
    final Function1<LifecycleState,Boolean> _function = new Function1<LifecycleState,Boolean>() {
        public Boolean apply(final LifecycleState s) {
          boolean _supportsEnvironmentType = LifecycleQueries.this._iStateMatcher.supportsEnvironmentType(s, EnvironmentType.STAGING);
          return Boolean.valueOf(_supportsEnvironmentType);
        }
      };
    Iterable<LifecycleState> _filter = IterableExtensions.<LifecycleState>filter(_states, _function);
    List<LifecycleState> _sort = IterableExtensions.<LifecycleState>sort(_filter, this.stateComparator);
    LifecycleState _head = IterableExtensions.<LifecycleState>head(_sort);
    return _head;
  }
  
  /**
   * Get the minimal state for an environment of type PROD based on a given lifecycle definition
   */
  public LifecycleState getMinProdState(final Lifecycle lifecycleDefinition) {
    EList<LifecycleState> _states = lifecycleDefinition.getStates();
    final Function1<LifecycleState,Boolean> _function = new Function1<LifecycleState,Boolean>() {
        public Boolean apply(final LifecycleState s) {
          boolean _supportsEnvironmentType = LifecycleQueries.this._iStateMatcher.supportsEnvironmentType(s, EnvironmentType.PROD);
          return Boolean.valueOf(_supportsEnvironmentType);
        }
      };
    Iterable<LifecycleState> _filter = IterableExtensions.<LifecycleState>filter(_states, _function);
    List<LifecycleState> _sort = IterableExtensions.<LifecycleState>sort(_filter, this.stateComparator);
    LifecycleState _head = IterableExtensions.<LifecycleState>head(_sort);
    return _head;
  }
  
  public LifecycleState getMinLifecycleState(final Environment env, final Lifecycle l) {
    LifecycleState _switchResult = null;
    EnvironmentType _type = env.getType();
    final EnvironmentType _switchValue = _type;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,EnvironmentType.LOCAL)) {
        _matched=true;
        LifecycleState _minLocalState = this.getMinLocalState(l);
        _switchResult = _minLocalState;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,EnvironmentType.DEV)) {
        _matched=true;
        LifecycleState _minDevState = this.getMinDevState(l);
        _switchResult = _minDevState;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,EnvironmentType.TEST)) {
        _matched=true;
        LifecycleState _minTestState = this.getMinTestState(l);
        _switchResult = _minTestState;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,EnvironmentType.STAGING)) {
        _matched=true;
        LifecycleState _minStagingState = this.getMinStagingState(l);
        _switchResult = _minStagingState;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,EnvironmentType.PROD)) {
        _matched=true;
        LifecycleState _minProdState = this.getMinProdState(l);
        _switchResult = _minProdState;
      }
    }
    if (!_matched) {
      LifecycleState _minDevState_1 = this.getMinDevState(l);
      _switchResult = _minDevState_1;
    }
    return _switchResult;
  }
  
  public EObject getStatefulOwner(final EObject o) {
    EClass _eClass = o.eClass();
    final EStructuralFeature stateFeature = _eClass.getEStructuralFeature(this.STATE_ATTR_NAME);
    boolean _notEquals = (!Objects.equal(stateFeature, null));
    if (_notEquals) {
      return o;
    } else {
      EObject _eContainer = o.eContainer();
      boolean _notEquals_1 = (!Objects.equal(_eContainer, null));
      if (_notEquals_1) {
        EObject _eContainer_1 = o.eContainer();
        return this.getStatefulOwner(_eContainer_1);
      } else {
        return null;
      }
    }
  }
}
