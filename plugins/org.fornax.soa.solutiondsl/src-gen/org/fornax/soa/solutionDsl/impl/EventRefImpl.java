/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.solutionDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;

import org.fornax.soa.serviceDsl.Event;

import org.fornax.soa.solutionDsl.EventRef;
import org.fornax.soa.solutionDsl.SolutionDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.EventRefImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.EventRefImpl#getVersionRef <em>Version Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventRefImpl extends MinimalEObjectImpl.Container implements EventRef
{
  /**
   * The cached value of the '{@link #getEvent() <em>Event</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvent()
   * @generated
   * @ordered
   */
  protected Event event;

  /**
   * The cached value of the '{@link #getVersionRef() <em>Version Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersionRef()
   * @generated
   * @ordered
   */
  protected VersionRef versionRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventRefImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SolutionDslPackage.Literals.EVENT_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event getEvent()
  {
    if (event != null && event.eIsProxy())
    {
      InternalEObject oldEvent = (InternalEObject)event;
      event = (Event)eResolveProxy(oldEvent);
      if (event != oldEvent)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionDslPackage.EVENT_REF__EVENT, oldEvent, event));
      }
    }
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event basicGetEvent()
  {
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEvent(Event newEvent)
  {
    Event oldEvent = event;
    event = newEvent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.EVENT_REF__EVENT, oldEvent, event));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VersionRef getVersionRef()
  {
    return versionRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVersionRef(VersionRef newVersionRef, NotificationChain msgs)
  {
    VersionRef oldVersionRef = versionRef;
    versionRef = newVersionRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolutionDslPackage.EVENT_REF__VERSION_REF, oldVersionRef, newVersionRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersionRef(VersionRef newVersionRef)
  {
    if (newVersionRef != versionRef)
    {
      NotificationChain msgs = null;
      if (versionRef != null)
        msgs = ((InternalEObject)versionRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.EVENT_REF__VERSION_REF, null, msgs);
      if (newVersionRef != null)
        msgs = ((InternalEObject)newVersionRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.EVENT_REF__VERSION_REF, null, msgs);
      msgs = basicSetVersionRef(newVersionRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.EVENT_REF__VERSION_REF, newVersionRef, newVersionRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SolutionDslPackage.EVENT_REF__VERSION_REF:
        return basicSetVersionRef(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SolutionDslPackage.EVENT_REF__EVENT:
        if (resolve) return getEvent();
        return basicGetEvent();
      case SolutionDslPackage.EVENT_REF__VERSION_REF:
        return getVersionRef();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SolutionDslPackage.EVENT_REF__EVENT:
        setEvent((Event)newValue);
        return;
      case SolutionDslPackage.EVENT_REF__VERSION_REF:
        setVersionRef((VersionRef)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SolutionDslPackage.EVENT_REF__EVENT:
        setEvent((Event)null);
        return;
      case SolutionDslPackage.EVENT_REF__VERSION_REF:
        setVersionRef((VersionRef)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SolutionDslPackage.EVENT_REF__EVENT:
        return event != null;
      case SolutionDslPackage.EVENT_REF__VERSION_REF:
        return versionRef != null;
    }
    return super.eIsSet(featureID);
  }

} //EventRefImpl
