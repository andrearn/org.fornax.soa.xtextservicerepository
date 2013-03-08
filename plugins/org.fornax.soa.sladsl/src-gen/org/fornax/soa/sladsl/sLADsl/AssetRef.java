/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.ecore.EObject;

import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asset Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AssetRef#getAsset <em>Asset</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AssetRef#getVersionRef <em>Version Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAssetRef()
 * @model
 * @generated
 */
public interface AssetRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Asset</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asset</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asset</em>' reference.
   * @see #setAsset(EObject)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAssetRef_Asset()
   * @model
   * @generated
   */
  EObject getAsset();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.AssetRef#getAsset <em>Asset</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Asset</em>' reference.
   * @see #getAsset()
   * @generated
   */
  void setAsset(EObject value);

  /**
   * Returns the value of the '<em><b>Version Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version Ref</em>' containment reference.
   * @see #setVersionRef(VersionRef)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAssetRef_VersionRef()
   * @model containment="true"
   * @generated
   */
  VersionRef getVersionRef();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.AssetRef#getVersionRef <em>Version Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version Ref</em>' containment reference.
   * @see #getVersionRef()
   * @generated
   */
  void setVersionRef(VersionRef value);

} // AssetRef
