/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.fornax.soa.semanticsDsl.Tag;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SLA</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getName <em>Name</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getEffectiveDate <em>Effective Date</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getEffectiveUntil <em>Effective Until</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getPreample <em>Preample</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getDescription <em>Description</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getScope <em>Scope</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getAppliesTo <em>Applies To</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getCosts <em>Costs</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getServiceQualityProperties <em>Service Quality Properties</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getDataSecProtClause <em>Data Sec Prot Clause</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getSecurityRequirements <em>Security Requirements</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getRestrictions <em>Restrictions</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getPriorities <em>Priorities</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getEscalationProcedure <em>Escalation Procedure</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getAdditionalServices <em>Additional Services</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getParties <em>Parties</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getCancellation <em>Cancellation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getExtraordinaryCancellation <em>Extraordinary Cancellation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getEffortAccounting <em>Effort Accounting</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getReports <em>Reports</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.SLA#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA()
 * @model
 * @generated
 */
public interface SLA extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Owner</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owner</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owner</em>' attribute.
   * @see #setOwner(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Owner()
   * @model
   * @generated
   */
  String getOwner();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getOwner <em>Owner</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owner</em>' attribute.
   * @see #getOwner()
   * @generated
   */
  void setOwner(String value);

  /**
   * Returns the value of the '<em><b>Effective Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Effective Date</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Effective Date</em>' attribute.
   * @see #setEffectiveDate(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_EffectiveDate()
   * @model
   * @generated
   */
  String getEffectiveDate();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getEffectiveDate <em>Effective Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Effective Date</em>' attribute.
   * @see #getEffectiveDate()
   * @generated
   */
  void setEffectiveDate(String value);

  /**
   * Returns the value of the '<em><b>Effective Until</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Effective Until</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Effective Until</em>' attribute.
   * @see #setEffectiveUntil(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_EffectiveUntil()
   * @model
   * @generated
   */
  String getEffectiveUntil();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getEffectiveUntil <em>Effective Until</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Effective Until</em>' attribute.
   * @see #getEffectiveUntil()
   * @generated
   */
  void setEffectiveUntil(String value);

  /**
   * Returns the value of the '<em><b>Preample</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Preample</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Preample</em>' attribute.
   * @see #setPreample(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Preample()
   * @model
   * @generated
   */
  String getPreample();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getPreample <em>Preample</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Preample</em>' attribute.
   * @see #getPreample()
   * @generated
   */
  void setPreample(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Scope</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scope</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scope</em>' attribute.
   * @see #setScope(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Scope()
   * @model
   * @generated
   */
  String getScope();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getScope <em>Scope</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scope</em>' attribute.
   * @see #getScope()
   * @generated
   */
  void setScope(String value);

  /**
   * Returns the value of the '<em><b>Applies To</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.AssetRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applies To</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Applies To</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_AppliesTo()
   * @model containment="true"
   * @generated
   */
  EList<AssetRef> getAppliesTo();

  /**
   * Returns the value of the '<em><b>Costs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Costs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Costs</em>' containment reference.
   * @see #setCosts(Cost)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Costs()
   * @model containment="true"
   * @generated
   */
  Cost getCosts();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getCosts <em>Costs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Costs</em>' containment reference.
   * @see #getCosts()
   * @generated
   */
  void setCosts(Cost value);

  /**
   * Returns the value of the '<em><b>Service Quality Properties</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.ServiceQualityProperty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service Quality Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Service Quality Properties</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_ServiceQualityProperties()
   * @model containment="true"
   * @generated
   */
  EList<ServiceQualityProperty> getServiceQualityProperties();

  /**
   * Returns the value of the '<em><b>Data Sec Prot Clause</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Sec Prot Clause</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Sec Prot Clause</em>' attribute.
   * @see #setDataSecProtClause(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_DataSecProtClause()
   * @model
   * @generated
   */
  String getDataSecProtClause();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getDataSecProtClause <em>Data Sec Prot Clause</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Sec Prot Clause</em>' attribute.
   * @see #getDataSecProtClause()
   * @generated
   */
  void setDataSecProtClause(String value);

  /**
   * Returns the value of the '<em><b>Security Requirements</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.SecurityRequirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Security Requirements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Security Requirements</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_SecurityRequirements()
   * @model containment="true"
   * @generated
   */
  EList<SecurityRequirement> getSecurityRequirements();

  /**
   * Returns the value of the '<em><b>Restrictions</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Restrictions</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Restrictions</em>' attribute.
   * @see #setRestrictions(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Restrictions()
   * @model
   * @generated
   */
  String getRestrictions();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getRestrictions <em>Restrictions</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Restrictions</em>' attribute.
   * @see #getRestrictions()
   * @generated
   */
  void setRestrictions(String value);

  /**
   * Returns the value of the '<em><b>Priorities</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.PriorityDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priorities</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priorities</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Priorities()
   * @model containment="true"
   * @generated
   */
  EList<PriorityDeclaration> getPriorities();

  /**
   * Returns the value of the '<em><b>Escalation Procedure</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Escalation Procedure</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Escalation Procedure</em>' containment reference.
   * @see #setEscalationProcedure(Escalation)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_EscalationProcedure()
   * @model containment="true"
   * @generated
   */
  Escalation getEscalationProcedure();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getEscalationProcedure <em>Escalation Procedure</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escalation Procedure</em>' containment reference.
   * @see #getEscalationProcedure()
   * @generated
   */
  void setEscalationProcedure(Escalation value);

  /**
   * Returns the value of the '<em><b>Additional Services</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Additional Services</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Additional Services</em>' attribute.
   * @see #setAdditionalServices(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_AdditionalServices()
   * @model
   * @generated
   */
  String getAdditionalServices();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getAdditionalServices <em>Additional Services</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Additional Services</em>' attribute.
   * @see #getAdditionalServices()
   * @generated
   */
  void setAdditionalServices(String value);

  /**
   * Returns the value of the '<em><b>Parties</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.Party}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parties</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Parties()
   * @model containment="true"
   * @generated
   */
  EList<Party> getParties();

  /**
   * Returns the value of the '<em><b>Cancellation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cancellation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cancellation</em>' attribute.
   * @see #setCancellation(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Cancellation()
   * @model
   * @generated
   */
  String getCancellation();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getCancellation <em>Cancellation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cancellation</em>' attribute.
   * @see #getCancellation()
   * @generated
   */
  void setCancellation(String value);

  /**
   * Returns the value of the '<em><b>Extraordinary Cancellation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extraordinary Cancellation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extraordinary Cancellation</em>' attribute.
   * @see #setExtraordinaryCancellation(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_ExtraordinaryCancellation()
   * @model
   * @generated
   */
  String getExtraordinaryCancellation();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getExtraordinaryCancellation <em>Extraordinary Cancellation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extraordinary Cancellation</em>' attribute.
   * @see #getExtraordinaryCancellation()
   * @generated
   */
  void setExtraordinaryCancellation(String value);

  /**
   * Returns the value of the '<em><b>Effort Accounting</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Effort Accounting</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Effort Accounting</em>' attribute.
   * @see #setEffortAccounting(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_EffortAccounting()
   * @model
   * @generated
   */
  String getEffortAccounting();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.SLA#getEffortAccounting <em>Effort Accounting</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Effort Accounting</em>' attribute.
   * @see #getEffortAccounting()
   * @generated
   */
  void setEffortAccounting(String value);

  /**
   * Returns the value of the '<em><b>Reports</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.Report}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reports</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Reports()
   * @model containment="true"
   * @generated
   */
  EList<Report> getReports();

  /**
   * Returns the value of the '<em><b>Tags</b></em>' reference list.
   * The list contents are of type {@link org.fornax.soa.semanticsDsl.Tag}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tags</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tags</em>' reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSLA_Tags()
   * @model
   * @generated
   */
  EList<Tag> getTags();

} // SLA
