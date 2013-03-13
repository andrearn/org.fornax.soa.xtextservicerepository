/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.solutionDsl;

import org.eclipse.emf.ecore.EObject;

import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;

import org.fornax.soa.serviceDsl.Event;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.EventRef#getEvent <em>Event</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.EventRef#getVersionRef <em>Version Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getEventRef()
 * @model
 * @generated
 */
public interface EventRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Event</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event</em>' reference.
   * @see #setEvent(Event)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getEventRef_Event()
   * @model
   * @generated
   */
  Event getEvent();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.EventRef#getEvent <em>Event</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event</em>' reference.
   * @see #getEvent()
   * @generated
   */
  void setEvent(Event value);

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
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getEventRef_VersionRef()
   * @model containment="true"
   * @generated
   */
  VersionRef getVersionRef();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.EventRef#getVersionRef <em>Version Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version Ref</em>' containment reference.
   * @see #getVersionRef()
   * @generated
   */
  void setVersionRef(VersionRef value);

} // EventRef
