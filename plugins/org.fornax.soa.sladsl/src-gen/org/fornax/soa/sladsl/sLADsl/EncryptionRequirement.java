/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Encryption Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.EncryptionRequirement#getSupportedCipherAlgorithms <em>Supported Cipher Algorithms</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.EncryptionRequirement#getRequiredCipherAlgorithm <em>Required Cipher Algorithm</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.EncryptionRequirement#getEncryptedParts <em>Encrypted Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getEncryptionRequirement()
 * @model
 * @generated
 */
public interface EncryptionRequirement extends SecurityRequirement
{
  /**
   * Returns the value of the '<em><b>Supported Cipher Algorithms</b></em>' attribute list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind}.
   * The literals are from the enumeration {@link org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supported Cipher Algorithms</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supported Cipher Algorithms</em>' attribute list.
   * @see org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getEncryptionRequirement_SupportedCipherAlgorithms()
   * @model unique="false"
   * @generated
   */
  EList<CipherAlgorithmKind> getSupportedCipherAlgorithms();

  /**
   * Returns the value of the '<em><b>Required Cipher Algorithm</b></em>' attribute.
   * The literals are from the enumeration {@link org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Cipher Algorithm</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Cipher Algorithm</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind
   * @see #setRequiredCipherAlgorithm(CipherAlgorithmKind)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getEncryptionRequirement_RequiredCipherAlgorithm()
   * @model
   * @generated
   */
  CipherAlgorithmKind getRequiredCipherAlgorithm();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.EncryptionRequirement#getRequiredCipherAlgorithm <em>Required Cipher Algorithm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Required Cipher Algorithm</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind
   * @see #getRequiredCipherAlgorithm()
   * @generated
   */
  void setRequiredCipherAlgorithm(CipherAlgorithmKind value);

  /**
   * Returns the value of the '<em><b>Encrypted Parts</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.MessagePartRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Encrypted Parts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Encrypted Parts</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getEncryptionRequirement_EncryptedParts()
   * @model containment="true"
   * @generated
   */
  EList<MessagePartRef> getEncryptedParts();

} // EncryptionRequirement
