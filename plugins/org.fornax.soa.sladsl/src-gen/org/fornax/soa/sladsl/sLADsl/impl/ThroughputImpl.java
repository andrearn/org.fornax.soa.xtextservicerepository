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
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;
import org.fornax.soa.sladsl.sLADsl.Throughput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throughput</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.ThroughputImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.ThroughputImpl#getScore <em>Score</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.ThroughputImpl#getEscalation <em>Escalation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.ThroughputImpl#getPenalty <em>Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThroughputImpl extends ServiceQualityPropertyImpl implements Throughput
{
  /**
   * The default value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinition()
   * @generated
   * @ordered
   */
  protected static final String DEFINITION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinition()
   * @generated
   * @ordered
   */
  protected String definition = DEFINITION_EDEFAULT;

  /**
   * The default value of the '{@link #getScore() <em>Score</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScore()
   * @generated
   * @ordered
   */
  protected static final String SCORE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getScore() <em>Score</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScore()
   * @generated
   * @ordered
   */
  protected String score = SCORE_EDEFAULT;

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
  protected ThroughputImpl()
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
    return SLADslPackage.Literals.THROUGHPUT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefinition()
  {
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefinition(String newDefinition)
  {
    String oldDefinition = definition;
    definition = newDefinition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.THROUGHPUT__DEFINITION, oldDefinition, definition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getScore()
  {
    return score;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScore(String newScore)
  {
    String oldScore = score;
    score = newScore;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.THROUGHPUT__SCORE, oldScore, score));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.THROUGHPUT__ESCALATION, oldEscalation, newEscalation);
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
        msgs = ((InternalEObject)escalation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.THROUGHPUT__ESCALATION, null, msgs);
      if (newEscalation != null)
        msgs = ((InternalEObject)newEscalation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.THROUGHPUT__ESCALATION, null, msgs);
      msgs = basicSetEscalation(newEscalation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.THROUGHPUT__ESCALATION, newEscalation, newEscalation));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.THROUGHPUT__PENALTY, oldPenalty, penalty));
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
      case SLADslPackage.THROUGHPUT__ESCALATION:
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
      case SLADslPackage.THROUGHPUT__DEFINITION:
        return getDefinition();
      case SLADslPackage.THROUGHPUT__SCORE:
        return getScore();
      case SLADslPackage.THROUGHPUT__ESCALATION:
        return getEscalation();
      case SLADslPackage.THROUGHPUT__PENALTY:
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
      case SLADslPackage.THROUGHPUT__DEFINITION:
        setDefinition((String)newValue);
        return;
      case SLADslPackage.THROUGHPUT__SCORE:
        setScore((String)newValue);
        return;
      case SLADslPackage.THROUGHPUT__ESCALATION:
        setEscalation((Escalation)newValue);
        return;
      case SLADslPackage.THROUGHPUT__PENALTY:
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
      case SLADslPackage.THROUGHPUT__DEFINITION:
        setDefinition(DEFINITION_EDEFAULT);
        return;
      case SLADslPackage.THROUGHPUT__SCORE:
        setScore(SCORE_EDEFAULT);
        return;
      case SLADslPackage.THROUGHPUT__ESCALATION:
        setEscalation((Escalation)null);
        return;
      case SLADslPackage.THROUGHPUT__PENALTY:
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
      case SLADslPackage.THROUGHPUT__DEFINITION:
        return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
      case SLADslPackage.THROUGHPUT__SCORE:
        return SCORE_EDEFAULT == null ? score != null : !SCORE_EDEFAULT.equals(score);
      case SLADslPackage.THROUGHPUT__ESCALATION:
        return escalation != null;
      case SLADslPackage.THROUGHPUT__PENALTY:
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
    result.append(" (definition: ");
    result.append(definition);
    result.append(", score: ");
    result.append(score);
    result.append(", penalty: ");
    result.append(penalty);
    result.append(')');
    return result.toString();
  }

} //ThroughputImpl
