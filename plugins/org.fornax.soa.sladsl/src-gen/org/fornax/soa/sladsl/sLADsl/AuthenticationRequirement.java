/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Authentication Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#getAuthTokens <em>Auth Tokens</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#getHashAlgorithms <em>Hash Algorithms</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#isUseNonce <em>Use Nonce</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#getIssuer <em>Issuer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAuthenticationRequirement()
 * @model
 * @generated
 */
public interface AuthenticationRequirement extends SecurityRequirement
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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAuthenticationRequirement_Optional()
   * @model
   * @generated
   */
  boolean isOptional();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#isOptional <em>Optional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Optional</em>' attribute.
   * @see #isOptional()
   * @generated
   */
  void setOptional(boolean value);

  /**
   * Returns the value of the '<em><b>Auth Tokens</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.AuthToken}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Auth Tokens</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Auth Tokens</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAuthenticationRequirement_AuthTokens()
   * @model containment="true"
   * @generated
   */
  EList<AuthToken> getAuthTokens();

  /**
   * Returns the value of the '<em><b>Hash Algorithms</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hash Algorithms</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hash Algorithms</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAuthenticationRequirement_HashAlgorithms()
   * @model containment="true"
   * @generated
   */
  EList<HashAlgorithm> getHashAlgorithms();

  /**
   * Returns the value of the '<em><b>Use Nonce</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Nonce</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Nonce</em>' attribute.
   * @see #setUseNonce(boolean)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAuthenticationRequirement_UseNonce()
   * @model
   * @generated
   */
  boolean isUseNonce();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#isUseNonce <em>Use Nonce</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use Nonce</em>' attribute.
   * @see #isUseNonce()
   * @generated
   */
  void setUseNonce(boolean value);

  /**
   * Returns the value of the '<em><b>Issuer</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issuer</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issuer</em>' attribute.
   * @see #setIssuer(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAuthenticationRequirement_Issuer()
   * @model
   * @generated
   */
  String getIssuer();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#getIssuer <em>Issuer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Issuer</em>' attribute.
   * @see #getIssuer()
   * @generated
   */
  void setIssuer(String value);

} // AuthenticationRequirement
