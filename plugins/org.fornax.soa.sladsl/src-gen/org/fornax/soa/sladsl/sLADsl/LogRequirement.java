/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Log Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.LogRequirement#getLogLevel <em>Log Level</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.LogRequirement#getAdditionalLoggingRequirement <em>Additional Logging Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getLogRequirement()
 * @model
 * @generated
 */
public interface LogRequirement extends ServiceQualityProperty
{
  /**
   * Returns the value of the '<em><b>Log Level</b></em>' attribute.
   * The literals are from the enumeration {@link org.fornax.soa.sladsl.sLADsl.LogRequirementKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Log Level</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Log Level</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.LogRequirementKind
   * @see #setLogLevel(LogRequirementKind)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getLogRequirement_LogLevel()
   * @model
   * @generated
   */
  LogRequirementKind getLogLevel();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.LogRequirement#getLogLevel <em>Log Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Log Level</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.LogRequirementKind
   * @see #getLogLevel()
   * @generated
   */
  void setLogLevel(LogRequirementKind value);

  /**
   * Returns the value of the '<em><b>Additional Logging Requirement</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Additional Logging Requirement</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Additional Logging Requirement</em>' attribute.
   * @see #setAdditionalLoggingRequirement(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getLogRequirement_AdditionalLoggingRequirement()
   * @model
   * @generated
   */
  String getAdditionalLoggingRequirement();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.LogRequirement#getAdditionalLoggingRequirement <em>Additional Logging Requirement</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Additional Logging Requirement</em>' attribute.
   * @see #getAdditionalLoggingRequirement()
   * @generated
   */
  void setAdditionalLoggingRequirement(String value);

} // LogRequirement
