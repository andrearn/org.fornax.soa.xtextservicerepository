/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.solutionDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.fornax.soa.basedsl.sOABaseDsl.AdditionalInformation;
import org.fornax.soa.basedsl.sOABaseDsl.User;

import org.fornax.soa.businessDsl.Domain;

import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

import org.fornax.soa.semanticsDsl.Tag;

import org.fornax.soa.serviceDsl.Channel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getName <em>Name</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getVersion <em>Version</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getState <em>State</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getProductVersion <em>Product Version</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getAdditionalInfo <em>Additional Info</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getRequiresChannel <em>Requires Channel</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getModules <em>Modules</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getResponsible <em>Responsible</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getBudgeting <em>Budgeting</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getTags <em>Tags</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Solution#getSubscriptions <em>Subscriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution()
 * @model
 * @generated
 */
public interface Solution extends EObject
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
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Solution#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Domain</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' reference.
   * @see #setDomain(Domain)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_Domain()
   * @model
   * @generated
   */
  Domain getDomain();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Solution#getDomain <em>Domain</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(Domain value);

  /**
   * Returns the value of the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' containment reference.
   * @see #setVersion(Version)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_Version()
   * @model containment="true"
   * @generated
   */
  Version getVersion();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Solution#getVersion <em>Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' containment reference.
   * @see #getVersion()
   * @generated
   */
  void setVersion(Version value);

  /**
   * Returns the value of the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' reference.
   * @see #setState(LifecycleState)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_State()
   * @model
   * @generated
   */
  LifecycleState getState();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Solution#getState <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' reference.
   * @see #getState()
   * @generated
   */
  void setState(LifecycleState value);

  /**
   * Returns the value of the '<em><b>Product Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Product Version</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Product Version</em>' containment reference.
   * @see #setProductVersion(Version)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_ProductVersion()
   * @model containment="true"
   * @generated
   */
  Version getProductVersion();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Solution#getProductVersion <em>Product Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Product Version</em>' containment reference.
   * @see #getProductVersion()
   * @generated
   */
  void setProductVersion(Version value);

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
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_AdditionalInfo()
   * @model containment="true"
   * @generated
   */
  AdditionalInformation getAdditionalInfo();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Solution#getAdditionalInfo <em>Additional Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Additional Info</em>' containment reference.
   * @see #getAdditionalInfo()
   * @generated
   */
  void setAdditionalInfo(AdditionalInformation value);

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
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_Requires()
   * @model containment="true"
   * @generated
   */
  EList<ServiceRef> getRequires();

  /**
   * Returns the value of the '<em><b>Requires Channel</b></em>' reference list.
   * The list contents are of type {@link org.fornax.soa.serviceDsl.Channel}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requires Channel</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requires Channel</em>' reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_RequiresChannel()
   * @model
   * @generated
   */
  EList<Channel> getRequiresChannel();

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
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_Features()
   * @model containment="true"
   * @generated
   */
  EList<Feature> getFeatures();

  /**
   * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.solutionDsl.Module}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modules</em>' containment reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_Modules()
   * @model containment="true"
   * @generated
   */
  EList<Module> getModules();

  /**
   * Returns the value of the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owner</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owner</em>' reference.
   * @see #setOwner(User)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_Owner()
   * @model
   * @generated
   */
  User getOwner();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Solution#getOwner <em>Owner</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owner</em>' reference.
   * @see #getOwner()
   * @generated
   */
  void setOwner(User value);

  /**
   * Returns the value of the '<em><b>Responsible</b></em>' reference list.
   * The list contents are of type {@link org.fornax.soa.basedsl.sOABaseDsl.User}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Responsible</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Responsible</em>' reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_Responsible()
   * @model
   * @generated
   */
  EList<User> getResponsible();

  /**
   * Returns the value of the '<em><b>Budgeting</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Budgeting</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Budgeting</em>' reference.
   * @see #setBudgeting(User)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_Budgeting()
   * @model
   * @generated
   */
  User getBudgeting();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Solution#getBudgeting <em>Budgeting</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Budgeting</em>' reference.
   * @see #getBudgeting()
   * @generated
   */
  void setBudgeting(User value);

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
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_Tags()
   * @model
   * @generated
   */
  EList<Tag> getTags();

  /**
   * Returns the value of the '<em><b>Subscriptions</b></em>' reference list.
   * The list contents are of type {@link org.fornax.soa.basedsl.sOABaseDsl.User}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subscriptions</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subscriptions</em>' reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getSolution_Subscriptions()
   * @model
   * @generated
   */
  EList<User> getSubscriptions();

} // Solution
