/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.fornax.soa.sladsl.sLADsl.LogRequirement;
import org.fornax.soa.sladsl.sLADsl.LogRequirementKind;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Log Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.LogRequirementImpl#getLogLevel <em>Log Level</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.LogRequirementImpl#getAdditionalLoggingRequirement <em>Additional Logging Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogRequirementImpl extends ServiceQualityPropertyImpl implements LogRequirement
{
  /**
   * The default value of the '{@link #getLogLevel() <em>Log Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogLevel()
   * @generated
   * @ordered
   */
  protected static final LogRequirementKind LOG_LEVEL_EDEFAULT = LogRequirementKind.NONE;

  /**
   * The cached value of the '{@link #getLogLevel() <em>Log Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogLevel()
   * @generated
   * @ordered
   */
  protected LogRequirementKind logLevel = LOG_LEVEL_EDEFAULT;

  /**
   * The default value of the '{@link #getAdditionalLoggingRequirement() <em>Additional Logging Requirement</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdditionalLoggingRequirement()
   * @generated
   * @ordered
   */
  protected static final String ADDITIONAL_LOGGING_REQUIREMENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAdditionalLoggingRequirement() <em>Additional Logging Requirement</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdditionalLoggingRequirement()
   * @generated
   * @ordered
   */
  protected String additionalLoggingRequirement = ADDITIONAL_LOGGING_REQUIREMENT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LogRequirementImpl()
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
    return SLADslPackage.Literals.LOG_REQUIREMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogRequirementKind getLogLevel()
  {
    return logLevel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLogLevel(LogRequirementKind newLogLevel)
  {
    LogRequirementKind oldLogLevel = logLevel;
    logLevel = newLogLevel == null ? LOG_LEVEL_EDEFAULT : newLogLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.LOG_REQUIREMENT__LOG_LEVEL, oldLogLevel, logLevel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAdditionalLoggingRequirement()
  {
    return additionalLoggingRequirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdditionalLoggingRequirement(String newAdditionalLoggingRequirement)
  {
    String oldAdditionalLoggingRequirement = additionalLoggingRequirement;
    additionalLoggingRequirement = newAdditionalLoggingRequirement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.LOG_REQUIREMENT__ADDITIONAL_LOGGING_REQUIREMENT, oldAdditionalLoggingRequirement, additionalLoggingRequirement));
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
      case SLADslPackage.LOG_REQUIREMENT__LOG_LEVEL:
        return getLogLevel();
      case SLADslPackage.LOG_REQUIREMENT__ADDITIONAL_LOGGING_REQUIREMENT:
        return getAdditionalLoggingRequirement();
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
      case SLADslPackage.LOG_REQUIREMENT__LOG_LEVEL:
        setLogLevel((LogRequirementKind)newValue);
        return;
      case SLADslPackage.LOG_REQUIREMENT__ADDITIONAL_LOGGING_REQUIREMENT:
        setAdditionalLoggingRequirement((String)newValue);
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
      case SLADslPackage.LOG_REQUIREMENT__LOG_LEVEL:
        setLogLevel(LOG_LEVEL_EDEFAULT);
        return;
      case SLADslPackage.LOG_REQUIREMENT__ADDITIONAL_LOGGING_REQUIREMENT:
        setAdditionalLoggingRequirement(ADDITIONAL_LOGGING_REQUIREMENT_EDEFAULT);
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
      case SLADslPackage.LOG_REQUIREMENT__LOG_LEVEL:
        return logLevel != LOG_LEVEL_EDEFAULT;
      case SLADslPackage.LOG_REQUIREMENT__ADDITIONAL_LOGGING_REQUIREMENT:
        return ADDITIONAL_LOGGING_REQUIREMENT_EDEFAULT == null ? additionalLoggingRequirement != null : !ADDITIONAL_LOGGING_REQUIREMENT_EDEFAULT.equals(additionalLoggingRequirement);
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
    result.append(" (logLevel: ");
    result.append(logLevel);
    result.append(", additionalLoggingRequirement: ");
    result.append(additionalLoggingRequirement);
    result.append(')');
    return result.toString();
  }

} //LogRequirementImpl
