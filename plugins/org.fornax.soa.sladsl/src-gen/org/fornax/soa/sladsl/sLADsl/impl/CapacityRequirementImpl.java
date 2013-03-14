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

import org.fornax.soa.sladsl.sLADsl.CapacityRequirement;
import org.fornax.soa.sladsl.sLADsl.Escalation;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Capacity Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.CapacityRequirementImpl#getRequestNum <em>Request Num</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.CapacityRequirementImpl#getTimeUnit <em>Time Unit</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.CapacityRequirementImpl#getMessageSize <em>Message Size</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.CapacityRequirementImpl#getEscalation <em>Escalation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.CapacityRequirementImpl#getPenalty <em>Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CapacityRequirementImpl extends ServiceQualityPropertyImpl implements CapacityRequirement
{
  /**
   * The default value of the '{@link #getRequestNum() <em>Request Num</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequestNum()
   * @generated
   * @ordered
   */
  protected static final String REQUEST_NUM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRequestNum() <em>Request Num</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequestNum()
   * @generated
   * @ordered
   */
  protected String requestNum = REQUEST_NUM_EDEFAULT;

  /**
   * The default value of the '{@link #getTimeUnit() <em>Time Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeUnit()
   * @generated
   * @ordered
   */
  protected static final String TIME_UNIT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTimeUnit() <em>Time Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeUnit()
   * @generated
   * @ordered
   */
  protected String timeUnit = TIME_UNIT_EDEFAULT;

  /**
   * The default value of the '{@link #getMessageSize() <em>Message Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessageSize()
   * @generated
   * @ordered
   */
  protected static final String MESSAGE_SIZE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMessageSize() <em>Message Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessageSize()
   * @generated
   * @ordered
   */
  protected String messageSize = MESSAGE_SIZE_EDEFAULT;

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
  protected CapacityRequirementImpl()
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
    return SLADslPackage.Literals.CAPACITY_REQUIREMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRequestNum()
  {
    return requestNum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequestNum(String newRequestNum)
  {
    String oldRequestNum = requestNum;
    requestNum = newRequestNum;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.CAPACITY_REQUIREMENT__REQUEST_NUM, oldRequestNum, requestNum));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTimeUnit()
  {
    return timeUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimeUnit(String newTimeUnit)
  {
    String oldTimeUnit = timeUnit;
    timeUnit = newTimeUnit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.CAPACITY_REQUIREMENT__TIME_UNIT, oldTimeUnit, timeUnit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMessageSize()
  {
    return messageSize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessageSize(String newMessageSize)
  {
    String oldMessageSize = messageSize;
    messageSize = newMessageSize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.CAPACITY_REQUIREMENT__MESSAGE_SIZE, oldMessageSize, messageSize));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.CAPACITY_REQUIREMENT__ESCALATION, oldEscalation, newEscalation);
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
        msgs = ((InternalEObject)escalation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.CAPACITY_REQUIREMENT__ESCALATION, null, msgs);
      if (newEscalation != null)
        msgs = ((InternalEObject)newEscalation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.CAPACITY_REQUIREMENT__ESCALATION, null, msgs);
      msgs = basicSetEscalation(newEscalation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.CAPACITY_REQUIREMENT__ESCALATION, newEscalation, newEscalation));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.CAPACITY_REQUIREMENT__PENALTY, oldPenalty, penalty));
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
      case SLADslPackage.CAPACITY_REQUIREMENT__ESCALATION:
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
      case SLADslPackage.CAPACITY_REQUIREMENT__REQUEST_NUM:
        return getRequestNum();
      case SLADslPackage.CAPACITY_REQUIREMENT__TIME_UNIT:
        return getTimeUnit();
      case SLADslPackage.CAPACITY_REQUIREMENT__MESSAGE_SIZE:
        return getMessageSize();
      case SLADslPackage.CAPACITY_REQUIREMENT__ESCALATION:
        return getEscalation();
      case SLADslPackage.CAPACITY_REQUIREMENT__PENALTY:
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
      case SLADslPackage.CAPACITY_REQUIREMENT__REQUEST_NUM:
        setRequestNum((String)newValue);
        return;
      case SLADslPackage.CAPACITY_REQUIREMENT__TIME_UNIT:
        setTimeUnit((String)newValue);
        return;
      case SLADslPackage.CAPACITY_REQUIREMENT__MESSAGE_SIZE:
        setMessageSize((String)newValue);
        return;
      case SLADslPackage.CAPACITY_REQUIREMENT__ESCALATION:
        setEscalation((Escalation)newValue);
        return;
      case SLADslPackage.CAPACITY_REQUIREMENT__PENALTY:
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
      case SLADslPackage.CAPACITY_REQUIREMENT__REQUEST_NUM:
        setRequestNum(REQUEST_NUM_EDEFAULT);
        return;
      case SLADslPackage.CAPACITY_REQUIREMENT__TIME_UNIT:
        setTimeUnit(TIME_UNIT_EDEFAULT);
        return;
      case SLADslPackage.CAPACITY_REQUIREMENT__MESSAGE_SIZE:
        setMessageSize(MESSAGE_SIZE_EDEFAULT);
        return;
      case SLADslPackage.CAPACITY_REQUIREMENT__ESCALATION:
        setEscalation((Escalation)null);
        return;
      case SLADslPackage.CAPACITY_REQUIREMENT__PENALTY:
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
      case SLADslPackage.CAPACITY_REQUIREMENT__REQUEST_NUM:
        return REQUEST_NUM_EDEFAULT == null ? requestNum != null : !REQUEST_NUM_EDEFAULT.equals(requestNum);
      case SLADslPackage.CAPACITY_REQUIREMENT__TIME_UNIT:
        return TIME_UNIT_EDEFAULT == null ? timeUnit != null : !TIME_UNIT_EDEFAULT.equals(timeUnit);
      case SLADslPackage.CAPACITY_REQUIREMENT__MESSAGE_SIZE:
        return MESSAGE_SIZE_EDEFAULT == null ? messageSize != null : !MESSAGE_SIZE_EDEFAULT.equals(messageSize);
      case SLADslPackage.CAPACITY_REQUIREMENT__ESCALATION:
        return escalation != null;
      case SLADslPackage.CAPACITY_REQUIREMENT__PENALTY:
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
    result.append(" (requestNum: ");
    result.append(requestNum);
    result.append(", timeUnit: ");
    result.append(timeUnit);
    result.append(", messageSize: ");
    result.append(messageSize);
    result.append(", penalty: ");
    result.append(penalty);
    result.append(')');
    return result.toString();
  }

} //CapacityRequirementImpl
