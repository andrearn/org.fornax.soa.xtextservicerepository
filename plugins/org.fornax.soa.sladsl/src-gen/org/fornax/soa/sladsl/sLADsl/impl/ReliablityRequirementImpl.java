/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.fornax.soa.sladsl.sLADsl.ReliablilityKind;
import org.fornax.soa.sladsl.sLADsl.ReliablityRequirement;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reliablity Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.ReliablityRequirementImpl#getReliability <em>Reliability</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.ReliablityRequirementImpl#isInOrderDelivery <em>In Order Delivery</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReliablityRequirementImpl extends ServiceQualityPropertyImpl implements ReliablityRequirement
{
  /**
   * The default value of the '{@link #getReliability() <em>Reliability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReliability()
   * @generated
   * @ordered
   */
  protected static final ReliablilityKind RELIABILITY_EDEFAULT = ReliablilityKind.EXACTLY_ONCE;

  /**
   * The cached value of the '{@link #getReliability() <em>Reliability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReliability()
   * @generated
   * @ordered
   */
  protected ReliablilityKind reliability = RELIABILITY_EDEFAULT;

  /**
   * The default value of the '{@link #isInOrderDelivery() <em>In Order Delivery</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInOrderDelivery()
   * @generated
   * @ordered
   */
  protected static final boolean IN_ORDER_DELIVERY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isInOrderDelivery() <em>In Order Delivery</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInOrderDelivery()
   * @generated
   * @ordered
   */
  protected boolean inOrderDelivery = IN_ORDER_DELIVERY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReliablityRequirementImpl()
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
    return SLADslPackage.Literals.RELIABLITY_REQUIREMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReliablilityKind getReliability()
  {
    return reliability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReliability(ReliablilityKind newReliability)
  {
    ReliablilityKind oldReliability = reliability;
    reliability = newReliability == null ? RELIABILITY_EDEFAULT : newReliability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.RELIABLITY_REQUIREMENT__RELIABILITY, oldReliability, reliability));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isInOrderDelivery()
  {
    return inOrderDelivery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInOrderDelivery(boolean newInOrderDelivery)
  {
    boolean oldInOrderDelivery = inOrderDelivery;
    inOrderDelivery = newInOrderDelivery;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.RELIABLITY_REQUIREMENT__IN_ORDER_DELIVERY, oldInOrderDelivery, inOrderDelivery));
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
      case SLADslPackage.RELIABLITY_REQUIREMENT__RELIABILITY:
        return getReliability();
      case SLADslPackage.RELIABLITY_REQUIREMENT__IN_ORDER_DELIVERY:
        return isInOrderDelivery();
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
      case SLADslPackage.RELIABLITY_REQUIREMENT__RELIABILITY:
        setReliability((ReliablilityKind)newValue);
        return;
      case SLADslPackage.RELIABLITY_REQUIREMENT__IN_ORDER_DELIVERY:
        setInOrderDelivery((Boolean)newValue);
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
      case SLADslPackage.RELIABLITY_REQUIREMENT__RELIABILITY:
        setReliability(RELIABILITY_EDEFAULT);
        return;
      case SLADslPackage.RELIABLITY_REQUIREMENT__IN_ORDER_DELIVERY:
        setInOrderDelivery(IN_ORDER_DELIVERY_EDEFAULT);
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
      case SLADslPackage.RELIABLITY_REQUIREMENT__RELIABILITY:
        return reliability != RELIABILITY_EDEFAULT;
      case SLADslPackage.RELIABLITY_REQUIREMENT__IN_ORDER_DELIVERY:
        return inOrderDelivery != IN_ORDER_DELIVERY_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (reliability: ");
    result.append(reliability);
    result.append(", inOrderDelivery: ");
    result.append(inOrderDelivery);
    result.append(')');
    return result.toString();
  }

} //ReliablityRequirementImpl
