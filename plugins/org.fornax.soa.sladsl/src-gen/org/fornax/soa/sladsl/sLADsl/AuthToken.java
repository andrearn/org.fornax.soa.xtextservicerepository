/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Auth Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AuthToken#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AuthToken#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAuthToken()
 * @model
 * @generated
 */
public interface AuthToken extends EObject
{
  /**
   * Returns the value of the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Optional</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Optional</em>' attribute.
   * @see #setOptional(boolean)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAuthToken_Optional()
   * @model
   * @generated
   */
  boolean isOptional();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.AuthToken#isOptional <em>Optional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Optional</em>' attribute.
   * @see #isOptional()
   * @generated
   */
  void setOptional(boolean value);

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.fornax.soa.sladsl.sLADsl.AuthTokenKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.AuthTokenKind
   * @see #setKind(AuthTokenKind)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAuthToken_Kind()
   * @model
   * @generated
   */
  AuthTokenKind getKind();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.AuthToken#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.AuthTokenKind
   * @see #getKind()
   * @generated
   */
  void setKind(AuthTokenKind value);

} // AuthToken
