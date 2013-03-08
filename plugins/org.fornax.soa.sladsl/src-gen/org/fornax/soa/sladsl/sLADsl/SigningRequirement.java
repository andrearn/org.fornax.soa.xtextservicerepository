/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signing Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SigningRequirement#getSupportedSigningAlgorithms <em>Supported Signing Algorithms</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SigningRequirement#getRequiredSigningAlgorithm <em>Required Signing Algorithm</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SigningRequirement#getSignedParts <em>Signed Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSigningRequirement()
 * @model
 * @generated
 */
public interface SigningRequirement extends SecurityRequirement
{
  /**
   * Returns the value of the '<em><b>Supported Signing Algorithms</b></em>' attribute list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.SigningAlgothm}.
   * The literals are from the enumeration {@link org.fornax.soa.sladsl.sLADsl.SigningAlgothm}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supported Signing Algorithms</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supported Signing Algorithms</em>' attribute list.
   * @see org.fornax.soa.sladsl.sLADsl.SigningAlgothm
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSigningRequirement_SupportedSigningAlgorithms()
   * @model unique="false"
   * @generated
   */
  EList<SigningAlgothm> getSupportedSigningAlgorithms();

  /**
   * Returns the value of the '<em><b>Required Signing Algorithm</b></em>' attribute.
   * The literals are from the enumeration {@link org.fornax.soa.sladsl.sLADsl.SigningAlgothm}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Signing Algorithm</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Signing Algorithm</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.SigningAlgothm
   * @see #setRequiredSigningAlgorithm(SigningAlgothm)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSigningRequirement_RequiredSigningAlgorithm()
   * @model
   * @generated
   */
  SigningAlgothm getRequiredSigningAlgorithm();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SigningRequirement#getRequiredSigningAlgorithm <em>Required Signing Algorithm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Required Signing Algorithm</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.SigningAlgothm
   * @see #getRequiredSigningAlgorithm()
   * @generated
   */
  void setRequiredSigningAlgorithm(SigningAlgothm value);

  /**
   * Returns the value of the '<em><b>Signed Parts</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.MessagePartRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signed Parts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signed Parts</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSigningRequirement_SignedParts()
   * @model containment="true"
   * @generated
   */
  EList<MessagePartRef> getSignedParts();

} // SigningRequirement
