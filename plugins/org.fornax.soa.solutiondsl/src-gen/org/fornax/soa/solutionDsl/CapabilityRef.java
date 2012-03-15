/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.solutionDsl;

import org.eclipse.emf.ecore.EObject;

import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;

import org.fornax.soa.businessDsl.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capability Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.CapabilityRef#getCapability <em>Capability</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.CapabilityRef#getVersionRef <em>Version Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getCapabilityRef()
 * @model
 * @generated
 */
public interface CapabilityRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Capability</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capability</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capability</em>' reference.
   * @see #setCapability(Capability)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getCapabilityRef_Capability()
   * @model
   * @generated
   */
  Capability getCapability();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.CapabilityRef#getCapability <em>Capability</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Capability</em>' reference.
   * @see #getCapability()
   * @generated
   */
  void setCapability(Capability value);

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
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getCapabilityRef_VersionRef()
   * @model containment="true"
   * @generated
   */
  VersionRef getVersionRef();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.CapabilityRef#getVersionRef <em>Version Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version Ref</em>' containment reference.
   * @see #getVersionRef()
   * @generated
   */
  void setVersionRef(VersionRef value);

} // CapabilityRef
