/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.fornax.soa.sladsl.sLADsl.Contact;
import org.fornax.soa.sladsl.sLADsl.Escalation;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Escalation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.EscalationImpl#getCause <em>Cause</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.EscalationImpl#getEscalationTargets <em>Escalation Targets</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.EscalationImpl#getProcedure <em>Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EscalationImpl extends MinimalEObjectImpl.Container implements Escalation
{
  /**
   * The default value of the '{@link #getCause() <em>Cause</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCause()
   * @generated
   * @ordered
   */
  protected static final String CAUSE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCause() <em>Cause</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCause()
   * @generated
   * @ordered
   */
  protected String cause = CAUSE_EDEFAULT;

  /**
   * The cached value of the '{@link #getEscalationTargets() <em>Escalation Targets</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEscalationTargets()
   * @generated
   * @ordered
   */
  protected EList<Contact> escalationTargets;

  /**
   * The default value of the '{@link #getProcedure() <em>Procedure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcedure()
   * @generated
   * @ordered
   */
  protected static final String PROCEDURE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProcedure() <em>Procedure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcedure()
   * @generated
   * @ordered
   */
  protected String procedure = PROCEDURE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EscalationImpl()
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
    return SLADslPackage.Literals.ESCALATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCause()
  {
    return cause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCause(String newCause)
  {
    String oldCause = cause;
    cause = newCause;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.ESCALATION__CAUSE, oldCause, cause));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Contact> getEscalationTargets()
  {
    if (escalationTargets == null)
    {
      escalationTargets = new EObjectContainmentEList<Contact>(Contact.class, this, SLADslPackage.ESCALATION__ESCALATION_TARGETS);
    }
    return escalationTargets;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getProcedure()
  {
    return procedure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProcedure(String newProcedure)
  {
    String oldProcedure = procedure;
    procedure = newProcedure;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.ESCALATION__PROCEDURE, oldProcedure, procedure));
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
      case SLADslPackage.ESCALATION__ESCALATION_TARGETS:
        return ((InternalEList<?>)getEscalationTargets()).basicRemove(otherEnd, msgs);
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
      case SLADslPackage.ESCALATION__CAUSE:
        return getCause();
      case SLADslPackage.ESCALATION__ESCALATION_TARGETS:
        return getEscalationTargets();
      case SLADslPackage.ESCALATION__PROCEDURE:
        return getProcedure();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SLADslPackage.ESCALATION__CAUSE:
        setCause((String)newValue);
        return;
      case SLADslPackage.ESCALATION__ESCALATION_TARGETS:
        getEscalationTargets().clear();
        getEscalationTargets().addAll((Collection<? extends Contact>)newValue);
        return;
      case SLADslPackage.ESCALATION__PROCEDURE:
        setProcedure((String)newValue);
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
      case SLADslPackage.ESCALATION__CAUSE:
        setCause(CAUSE_EDEFAULT);
        return;
      case SLADslPackage.ESCALATION__ESCALATION_TARGETS:
        getEscalationTargets().clear();
        return;
      case SLADslPackage.ESCALATION__PROCEDURE:
        setProcedure(PROCEDURE_EDEFAULT);
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
      case SLADslPackage.ESCALATION__CAUSE:
        return CAUSE_EDEFAULT == null ? cause != null : !CAUSE_EDEFAULT.equals(cause);
      case SLADslPackage.ESCALATION__ESCALATION_TARGETS:
        return escalationTargets != null && !escalationTargets.isEmpty();
      case SLADslPackage.ESCALATION__PROCEDURE:
        return PROCEDURE_EDEFAULT == null ? procedure != null : !PROCEDURE_EDEFAULT.equals(procedure);
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
    result.append(" (cause: ");
    result.append(cause);
    result.append(", procedure: ");
    result.append(procedure);
    result.append(')');
    return result.toString();
  }

} //EscalationImpl
