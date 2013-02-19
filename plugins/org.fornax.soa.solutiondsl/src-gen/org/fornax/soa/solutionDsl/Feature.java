/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.solutionDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.fornax.soa.basedsl.sOABaseDsl.AdditionalInformation;

import org.fornax.soa.semanticsDsl.Tag;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.Feature#isNonFunctional <em>Non Functional</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Feature#getName <em>Name</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Feature#getUseCase <em>Use Case</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Feature#getDescription <em>Description</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Feature#getAdditionalInfo <em>Additional Info</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Feature#getUsesCapabilities <em>Uses Capabilities</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Feature#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Feature#getEvent <em>Event</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Feature#getTags <em>Tags</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Feature#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends EObject
{
  /**
   * Returns the value of the '<em><b>Non Functional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Non Functional</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Non Functional</em>' attribute.
   * @see #setNonFunctional(boolean)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getFeature_NonFunctional()
   * @model
   * @generated
   */
  boolean isNonFunctional();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Feature#isNonFunctional <em>Non Functional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Non Functional</em>' attribute.
   * @see #isNonFunctional()
   * @generated
   */
  void setNonFunctional(boolean value);

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
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getFeature_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Feature#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Use Case</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Case</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Case</em>' attribute list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getFeature_UseCase()
   * @model unique="false"
   * @generated
   */
  EList<String> getUseCase();

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
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getFeature_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Feature#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Additional Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Additional Info</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Additional Info</em>' containment reference.
   * @see #setAdditionalInfo(AdditionalInformation)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getFeature_AdditionalInfo()
   * @model containment="true"
   * @generated
   */
  AdditionalInformation getAdditionalInfo();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Feature#getAdditionalInfo <em>Additional Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Additional Info</em>' containment reference.
   * @see #getAdditionalInfo()
   * @generated
   */
  void setAdditionalInfo(AdditionalInformation value);

  /**
   * Returns the value of the '<em><b>Uses Capabilities</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.solutionDsl.CapabilityRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uses Capabilities</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uses Capabilities</em>' containment reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getFeature_UsesCapabilities()
   * @model containment="true"
   * @generated
   */
  EList<CapabilityRef> getUsesCapabilities();

  /**
   * Returns the value of the '<em><b>Requires</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.solutionDsl.ServiceRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requires</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requires</em>' containment reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getFeature_Requires()
   * @model containment="true"
   * @generated
   */
  EList<ServiceRef> getRequires();

  /**
   * Returns the value of the '<em><b>Event</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.solutionDsl.EventRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event</em>' containment reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getFeature_Event()
   * @model containment="true"
   * @generated
   */
  EList<EventRef> getEvent();

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
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getFeature_Tags()
   * @model
   * @generated
   */
  EList<Tag> getTags();

  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.solutionDsl.Feature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getFeature_Features()
   * @model containment="true"
   * @generated
   */
  EList<Feature> getFeatures();

} // Feature
