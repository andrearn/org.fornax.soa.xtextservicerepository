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

import org.fornax.soa.businessDsl.Capability;

import org.fornax.soa.solutionDsl.CapabilityRef;
import org.fornax.soa.solutionDsl.SolutionDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Capability Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.CapabilityRefImpl#getCapability <em>Capability</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.CapabilityRefImpl#getVersionRef <em>Version Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CapabilityRefImpl extends MinimalEObjectImpl.Container implements CapabilityRef
{
  /**
   * The cached value of the '{@link #getCapability() <em>Capability</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCapability()
   * @generated
   * @ordered
   */
  protected Capability capability;

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
  protected CapabilityRefImpl()
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
    return SolutionDslPackage.Literals.CAPABILITY_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Capability getCapability()
  {
    if (capability != null && capability.eIsProxy())
    {
      InternalEObject oldCapability = (InternalEObject)capability;
      capability = (Capability)eResolveProxy(oldCapability);
      if (capability != oldCapability)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionDslPackage.CAPABILITY_REF__CAPABILITY, oldCapability, capability));
      }
    }
    return capability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Capability basicGetCapability()
  {
    return capability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCapability(Capability newCapability)
  {
    Capability oldCapability = capability;
    capability = newCapability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.CAPABILITY_REF__CAPABILITY, oldCapability, capability));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolutionDslPackage.CAPABILITY_REF__VERSION_REF, oldVersionRef, newVersionRef);
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
        msgs = ((InternalEObject)versionRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.CAPABILITY_REF__VERSION_REF, null, msgs);
      if (newVersionRef != null)
        msgs = ((InternalEObject)newVersionRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.CAPABILITY_REF__VERSION_REF, null, msgs);
      msgs = basicSetVersionRef(newVersionRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.CAPABILITY_REF__VERSION_REF, newVersionRef, newVersionRef));
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
      case SolutionDslPackage.CAPABILITY_REF__VERSION_REF:
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
      case SolutionDslPackage.CAPABILITY_REF__CAPABILITY:
        if (resolve) return getCapability();
        return basicGetCapability();
      case SolutionDslPackage.CAPABILITY_REF__VERSION_REF:
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
      case SolutionDslPackage.CAPABILITY_REF__CAPABILITY:
        setCapability((Capability)newValue);
        return;
      case SolutionDslPackage.CAPABILITY_REF__VERSION_REF:
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
      case SolutionDslPackage.CAPABILITY_REF__CAPABILITY:
        setCapability((Capability)null);
        return;
      case SolutionDslPackage.CAPABILITY_REF__VERSION_REF:
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
      case SolutionDslPackage.CAPABILITY_REF__CAPABILITY:
        return capability != null;
      case SolutionDslPackage.CAPABILITY_REF__VERSION_REF:
        return versionRef != null;
    }
    return super.eIsSet(featureID);
  }

} //CapabilityRefImpl
