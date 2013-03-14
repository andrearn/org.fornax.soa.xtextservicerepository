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

import org.fornax.soa.sladsl.sLADsl.AccuracyRequirement;
import org.fornax.soa.sladsl.sLADsl.Escalation;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accuracy Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AccuracyRequirementImpl#getMaxErrorRate <em>Max Error Rate</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AccuracyRequirementImpl#getEscalation <em>Escalation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AccuracyRequirementImpl#getPenalty <em>Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccuracyRequirementImpl extends ServiceQualityPropertyImpl implements AccuracyRequirement
{
  /**
   * The default value of the '{@link #getMaxErrorRate() <em>Max Error Rate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxErrorRate()
   * @generated
   * @ordered
   */
  protected static final String MAX_ERROR_RATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMaxErrorRate() <em>Max Error Rate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxErrorRate()
   * @generated
   * @ordered
   */
  protected String maxErrorRate = MAX_ERROR_RATE_EDEFAULT;

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
  protected AccuracyRequirementImpl()
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
    return SLADslPackage.Literals.ACCURACY_REQUIREMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMaxErrorRate()
  {
    return maxErrorRate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaxErrorRate(String newMaxErrorRate)
  {
    String oldMaxErrorRate = maxErrorRate;
    maxErrorRate = newMaxErrorRate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.ACCURACY_REQUIREMENT__MAX_ERROR_RATE, oldMaxErrorRate, maxErrorRate));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.ACCURACY_REQUIREMENT__ESCALATION, oldEscalation, newEscalation);
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
        msgs = ((InternalEObject)escalation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.ACCURACY_REQUIREMENT__ESCALATION, null, msgs);
      if (newEscalation != null)
        msgs = ((InternalEObject)newEscalation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.ACCURACY_REQUIREMENT__ESCALATION, null, msgs);
      msgs = basicSetEscalation(newEscalation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.ACCURACY_REQUIREMENT__ESCALATION, newEscalation, newEscalation));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.ACCURACY_REQUIREMENT__PENALTY, oldPenalty, penalty));
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
      case SLADslPackage.ACCURACY_REQUIREMENT__ESCALATION:
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
      case SLADslPackage.ACCURACY_REQUIREMENT__MAX_ERROR_RATE:
        return getMaxErrorRate();
      case SLADslPackage.ACCURACY_REQUIREMENT__ESCALATION:
        return getEscalation();
      case SLADslPackage.ACCURACY_REQUIREMENT__PENALTY:
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
      case SLADslPackage.ACCURACY_REQUIREMENT__MAX_ERROR_RATE:
        setMaxErrorRate((String)newValue);
        return;
      case SLADslPackage.ACCURACY_REQUIREMENT__ESCALATION:
        setEscalation((Escalation)newValue);
        return;
      case SLADslPackage.ACCURACY_REQUIREMENT__PENALTY:
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
      case SLADslPackage.ACCURACY_REQUIREMENT__MAX_ERROR_RATE:
        setMaxErrorRate(MAX_ERROR_RATE_EDEFAULT);
        return;
      case SLADslPackage.ACCURACY_REQUIREMENT__ESCALATION:
        setEscalation((Escalation)null);
        return;
      case SLADslPackage.ACCURACY_REQUIREMENT__PENALTY:
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
      case SLADslPackage.ACCURACY_REQUIREMENT__MAX_ERROR_RATE:
        return MAX_ERROR_RATE_EDEFAULT == null ? maxErrorRate != null : !MAX_ERROR_RATE_EDEFAULT.equals(maxErrorRate);
      case SLADslPackage.ACCURACY_REQUIREMENT__ESCALATION:
        return escalation != null;
      case SLADslPackage.ACCURACY_REQUIREMENT__PENALTY:
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
    result.append(" (maxErrorRate: ");
    result.append(maxErrorRate);
    result.append(", penalty: ");
    result.append(penalty);
    result.append(')');
    return result.toString();
  }

} //AccuracyRequirementImpl
