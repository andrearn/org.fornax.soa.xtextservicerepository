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

import org.fornax.soa.sladsl.sLADsl.Escalation;
import org.fornax.soa.sladsl.sLADsl.Latency;
import org.fornax.soa.sladsl.sLADsl.Percentile;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Latency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.LatencyImpl#getLatency <em>Latency</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.LatencyImpl#getPercentile <em>Percentile</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.LatencyImpl#getEscalation <em>Escalation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.LatencyImpl#getPenalty <em>Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LatencyImpl extends ServiceQualityPropertyImpl implements Latency
{
  /**
   * The default value of the '{@link #getLatency() <em>Latency</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLatency()
   * @generated
   * @ordered
   */
  protected static final String LATENCY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLatency() <em>Latency</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLatency()
   * @generated
   * @ordered
   */
  protected String latency = LATENCY_EDEFAULT;

  /**
   * The cached value of the '{@link #getPercentile() <em>Percentile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPercentile()
   * @generated
   * @ordered
   */
  protected Percentile percentile;

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
  protected LatencyImpl()
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
    return SLADslPackage.Literals.LATENCY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLatency()
  {
    return latency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLatency(String newLatency)
  {
    String oldLatency = latency;
    latency = newLatency;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.LATENCY__LATENCY, oldLatency, latency));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Percentile getPercentile()
  {
    return percentile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPercentile(Percentile newPercentile, NotificationChain msgs)
  {
    Percentile oldPercentile = percentile;
    percentile = newPercentile;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.LATENCY__PERCENTILE, oldPercentile, newPercentile);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPercentile(Percentile newPercentile)
  {
    if (newPercentile != percentile)
    {
      NotificationChain msgs = null;
      if (percentile != null)
        msgs = ((InternalEObject)percentile).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.LATENCY__PERCENTILE, null, msgs);
      if (newPercentile != null)
        msgs = ((InternalEObject)newPercentile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.LATENCY__PERCENTILE, null, msgs);
      msgs = basicSetPercentile(newPercentile, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.LATENCY__PERCENTILE, newPercentile, newPercentile));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.LATENCY__ESCALATION, oldEscalation, newEscalation);
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
        msgs = ((InternalEObject)escalation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.LATENCY__ESCALATION, null, msgs);
      if (newEscalation != null)
        msgs = ((InternalEObject)newEscalation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.LATENCY__ESCALATION, null, msgs);
      msgs = basicSetEscalation(newEscalation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.LATENCY__ESCALATION, newEscalation, newEscalation));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.LATENCY__PENALTY, oldPenalty, penalty));
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
      case SLADslPackage.LATENCY__PERCENTILE:
        return basicSetPercentile(null, msgs);
      case SLADslPackage.LATENCY__ESCALATION:
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
      case SLADslPackage.LATENCY__LATENCY:
        return getLatency();
      case SLADslPackage.LATENCY__PERCENTILE:
        return getPercentile();
      case SLADslPackage.LATENCY__ESCALATION:
        return getEscalation();
      case SLADslPackage.LATENCY__PENALTY:
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
      case SLADslPackage.LATENCY__LATENCY:
        setLatency((String)newValue);
        return;
      case SLADslPackage.LATENCY__PERCENTILE:
        setPercentile((Percentile)newValue);
        return;
      case SLADslPackage.LATENCY__ESCALATION:
        setEscalation((Escalation)newValue);
        return;
      case SLADslPackage.LATENCY__PENALTY:
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
      case SLADslPackage.LATENCY__LATENCY:
        setLatency(LATENCY_EDEFAULT);
        return;
      case SLADslPackage.LATENCY__PERCENTILE:
        setPercentile((Percentile)null);
        return;
      case SLADslPackage.LATENCY__ESCALATION:
        setEscalation((Escalation)null);
        return;
      case SLADslPackage.LATENCY__PENALTY:
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
      case SLADslPackage.LATENCY__LATENCY:
        return LATENCY_EDEFAULT == null ? latency != null : !LATENCY_EDEFAULT.equals(latency);
      case SLADslPackage.LATENCY__PERCENTILE:
        return percentile != null;
      case SLADslPackage.LATENCY__ESCALATION:
        return escalation != null;
      case SLADslPackage.LATENCY__PENALTY:
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
    result.append(" (latency: ");
    result.append(latency);
    result.append(", penalty: ");
    result.append(penalty);
    result.append(')');
    return result.toString();
  }

} //LatencyImpl
