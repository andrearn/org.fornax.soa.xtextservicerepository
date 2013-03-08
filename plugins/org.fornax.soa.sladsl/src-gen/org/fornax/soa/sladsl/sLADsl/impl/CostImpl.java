/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.fornax.soa.sladsl.sLADsl.Cost;
import org.fornax.soa.sladsl.sLADsl.Escalation;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.CostImpl#getCostsAmount <em>Costs Amount</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.CostImpl#getBilledUnit <em>Billed Unit</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.CostImpl#getEscalation <em>Escalation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.CostImpl#getPenalty <em>Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CostImpl extends MinimalEObjectImpl.Container implements Cost
{
  /**
   * The default value of the '{@link #getCostsAmount() <em>Costs Amount</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCostsAmount()
   * @generated
   * @ordered
   */
  protected static final String COSTS_AMOUNT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCostsAmount() <em>Costs Amount</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCostsAmount()
   * @generated
   * @ordered
   */
  protected String costsAmount = COSTS_AMOUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getBilledUnit() <em>Billed Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBilledUnit()
   * @generated
   * @ordered
   */
  protected static final String BILLED_UNIT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBilledUnit() <em>Billed Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBilledUnit()
   * @generated
   * @ordered
   */
  protected String billedUnit = BILLED_UNIT_EDEFAULT;

  /**
   * The cached value of the '{@link #getEscalation() <em>Escalation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEscalation()
   * @generated
   * @ordered
   */
  protected Escalation escalation;

  /**
   * The default value of the '{@link #getPenalty() <em>Penalty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPenalty()
   * @generated
   * @ordered
   */
  protected static final String PENALTY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPenalty() <em>Penalty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPenalty()
   * @generated
   * @ordered
   */
  protected String penalty = PENALTY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CostImpl()
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
    return SLADslPackage.Literals.COST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCostsAmount()
  {
    return costsAmount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCostsAmount(String newCostsAmount)
  {
    String oldCostsAmount = costsAmount;
    costsAmount = newCostsAmount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.COST__COSTS_AMOUNT, oldCostsAmount, costsAmount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBilledUnit()
  {
    return billedUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBilledUnit(String newBilledUnit)
  {
    String oldBilledUnit = billedUnit;
    billedUnit = newBilledUnit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.COST__BILLED_UNIT, oldBilledUnit, billedUnit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Escalation getEscalation()
  {
    return escalation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEscalation(Escalation newEscalation, NotificationChain msgs)
  {
    Escalation oldEscalation = escalation;
    escalation = newEscalation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.COST__ESCALATION, oldEscalation, newEscalation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEscalation(Escalation newEscalation)
  {
    if (newEscalation != escalation)
    {
      NotificationChain msgs = null;
      if (escalation != null)
        msgs = ((InternalEObject)escalation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.COST__ESCALATION, null, msgs);
      if (newEscalation != null)
        msgs = ((InternalEObject)newEscalation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.COST__ESCALATION, null, msgs);
      msgs = basicSetEscalation(newEscalation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.COST__ESCALATION, newEscalation, newEscalation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPenalty()
  {
    return penalty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPenalty(String newPenalty)
  {
    String oldPenalty = penalty;
    penalty = newPenalty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.COST__PENALTY, oldPenalty, penalty));
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
      case SLADslPackage.COST__ESCALATION:
        return basicSetEscalation(null, msgs);
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
      case SLADslPackage.COST__COSTS_AMOUNT:
        return getCostsAmount();
      case SLADslPackage.COST__BILLED_UNIT:
        return getBilledUnit();
      case SLADslPackage.COST__ESCALATION:
        return getEscalation();
      case SLADslPackage.COST__PENALTY:
        return getPenalty();
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
      case SLADslPackage.COST__COSTS_AMOUNT:
        setCostsAmount((String)newValue);
        return;
      case SLADslPackage.COST__BILLED_UNIT:
        setBilledUnit((String)newValue);
        return;
      case SLADslPackage.COST__ESCALATION:
        setEscalation((Escalation)newValue);
        return;
      case SLADslPackage.COST__PENALTY:
        setPenalty((String)newValue);
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
      case SLADslPackage.COST__COSTS_AMOUNT:
        setCostsAmount(COSTS_AMOUNT_EDEFAULT);
        return;
      case SLADslPackage.COST__BILLED_UNIT:
        setBilledUnit(BILLED_UNIT_EDEFAULT);
        return;
      case SLADslPackage.COST__ESCALATION:
        setEscalation((Escalation)null);
        return;
      case SLADslPackage.COST__PENALTY:
        setPenalty(PENALTY_EDEFAULT);
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
      case SLADslPackage.COST__COSTS_AMOUNT:
        return COSTS_AMOUNT_EDEFAULT == null ? costsAmount != null : !COSTS_AMOUNT_EDEFAULT.equals(costsAmount);
      case SLADslPackage.COST__BILLED_UNIT:
        return BILLED_UNIT_EDEFAULT == null ? billedUnit != null : !BILLED_UNIT_EDEFAULT.equals(billedUnit);
      case SLADslPackage.COST__ESCALATION:
        return escalation != null;
      case SLADslPackage.COST__PENALTY:
        return PENALTY_EDEFAULT == null ? penalty != null : !PENALTY_EDEFAULT.equals(penalty);
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
    result.append(" (costsAmount: ");
    result.append(costsAmount);
    result.append(", billedUnit: ");
    result.append(billedUnit);
    result.append(", penalty: ");
    result.append(penalty);
    result.append(')');
    return result.toString();
  }

} //CostImpl
