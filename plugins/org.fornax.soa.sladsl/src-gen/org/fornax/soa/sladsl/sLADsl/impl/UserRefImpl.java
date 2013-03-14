/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.fornax.soa.basedsl.sOABaseDsl.User;

import org.fornax.soa.sladsl.sLADsl.SLADslPackage;
import org.fornax.soa.sladsl.sLADsl.UserRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.UserRefImpl#getRepresentative <em>Representative</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserRefImpl extends RepresentativeImpl implements UserRef
{
  /**
   * The cached value of the '{@link #getRepresentative() <em>Representative</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepresentative()
   * @generated
   * @ordered
   */
  protected User representative;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UserRefImpl()
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
    return SLADslPackage.Literals.USER_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public User getRepresentative()
  {
    if (representative != null && representative.eIsProxy())
    {
      InternalEObject oldRepresentative = (InternalEObject)representative;
      representative = (User)eResolveProxy(oldRepresentative);
      if (representative != oldRepresentative)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SLADslPackage.USER_REF__REPRESENTATIVE, oldRepresentative, representative));
      }
    }
    return representative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public User basicGetRepresentative()
  {
    return representative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRepresentative(User newRepresentative)
  {
    User oldRepresentative = representative;
    representative = newRepresentative;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.USER_REF__REPRESENTATIVE, oldRepresentative, representative));
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
      case SLADslPackage.USER_REF__REPRESENTATIVE:
        if (resolve) return getRepresentative();
        return basicGetRepresentative();
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
      case SLADslPackage.USER_REF__REPRESENTATIVE:
        setRepresentative((User)newValue);
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
      case SLADslPackage.USER_REF__REPRESENTATIVE:
        setRepresentative((User)null);
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
      case SLADslPackage.USER_REF__REPRESENTATIVE:
        return representative != null;
    }
    return super.eIsSet(featureID);
  }

} //UserRefImpl
