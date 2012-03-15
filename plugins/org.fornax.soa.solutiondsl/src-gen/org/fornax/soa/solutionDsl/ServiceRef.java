/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.solutionDsl;

import org.eclipse.emf.ecore.EObject;

import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;

import org.fornax.soa.serviceDsl.Service;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.ServiceRef#getService <em>Service</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.ServiceRef#getVersionRef <em>Version Ref</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.ServiceRef#isIsResponseHandler <em>Is Response Handler</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getServiceRef()
 * @model
 * @generated
 */
public interface ServiceRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Service</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Service</em>' reference.
   * @see #setService(Service)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getServiceRef_Service()
   * @model
   * @generated
   */
  Service getService();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.ServiceRef#getService <em>Service</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Service</em>' reference.
   * @see #getService()
   * @generated
   */
  void setService(Service value);

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
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getServiceRef_VersionRef()
   * @model containment="true"
   * @generated
   */
  VersionRef getVersionRef();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.ServiceRef#getVersionRef <em>Version Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version Ref</em>' containment reference.
   * @see #getVersionRef()
   * @generated
   */
  void setVersionRef(VersionRef value);

  /**
   * Returns the value of the '<em><b>Is Response Handler</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Response Handler</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Response Handler</em>' attribute.
   * @see #setIsResponseHandler(boolean)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getServiceRef_IsResponseHandler()
   * @model
   * @generated
   */
  boolean isIsResponseHandler();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.ServiceRef#isIsResponseHandler <em>Is Response Handler</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Response Handler</em>' attribute.
   * @see #isIsResponseHandler()
   * @generated
   */
  void setIsResponseHandler(boolean value);

} // ServiceRef
