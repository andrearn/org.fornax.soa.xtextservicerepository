/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hash Algorithm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm#isUseBase64 <em>Use Base64</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getHashAlgorithm()
 * @model
 * @generated
 */
public interface HashAlgorithm extends EObject
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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getHashAlgorithm_Optional()
   * @model
   * @generated
   */
  boolean isOptional();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm#isOptional <em>Optional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Optional</em>' attribute.
   * @see #isOptional()
   * @generated
   */
  void setOptional(boolean value);

  /**
   * Returns the value of the '<em><b>Use Base64</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Base64</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Base64</em>' attribute.
   * @see #setUseBase64(boolean)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getHashAlgorithm_UseBase64()
   * @model
   * @generated
   */
  boolean isUseBase64();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm#isUseBase64 <em>Use Base64</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use Base64</em>' attribute.
   * @see #isUseBase64()
   * @generated
   */
  void setUseBase64(boolean value);

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.fornax.soa.sladsl.sLADsl.HashAlgKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.HashAlgKind
   * @see #setKind(HashAlgKind)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getHashAlgorithm_Kind()
   * @model
   * @generated
   */
  HashAlgKind getKind();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.HashAlgKind
   * @see #getKind()
   * @generated
   */
  void setKind(HashAlgKind value);

} // HashAlgorithm
