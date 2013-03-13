/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sla Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SlaModel#getAgreements <em>Agreements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSlaModel()
 * @model
 * @generated
 */
public interface SlaModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Agreements</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.SLA}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Agreements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Agreements</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSlaModel_Agreements()
   * @model containment="true"
   * @generated
   */
  EList<SLA> getAgreements();

} // SlaModel
