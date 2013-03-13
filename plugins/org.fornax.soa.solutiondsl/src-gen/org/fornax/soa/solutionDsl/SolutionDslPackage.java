/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.solutionDsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.fornax.soa.solutionDsl.SolutionDslFactory
 * @model kind="package"
 * @generated
 */
public interface SolutionDslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "solutionDsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.fornax.org/soa/SolutionDsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "solutionDsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SolutionDslPackage eINSTANCE = org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl.init();

  /**
   * The meta object id for the '{@link org.fornax.soa.solutionDsl.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.solutionDsl.impl.ModelImpl
   * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Solution</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__SOLUTION = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.fornax.soa.solutionDsl.impl.SolutionImpl <em>Solution</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.solutionDsl.impl.SolutionImpl
   * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getSolution()
   * @generated
   */
  int SOLUTION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__NAME = 0;

  /**
   * The feature id for the '<em><b>Domain</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__DOMAIN = 1;

  /**
   * The feature id for the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__VERSION = 2;

  /**
   * The feature id for the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__STATE = 3;

  /**
   * The feature id for the '<em><b>Product Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__PRODUCT_VERSION = 4;

  /**
   * The feature id for the '<em><b>Additional Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__ADDITIONAL_INFO = 5;

  /**
   * The feature id for the '<em><b>Requires</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__REQUIRES = 6;

  /**
   * The feature id for the '<em><b>Requires Channel</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__REQUIRES_CHANNEL = 7;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__FEATURES = 8;

  /**
   * The feature id for the '<em><b>Modules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__MODULES = 9;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__OWNER = 10;

  /**
   * The feature id for the '<em><b>Responsible</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__RESPONSIBLE = 11;

  /**
   * The feature id for the '<em><b>Budgeting</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__BUDGETING = 12;

  /**
   * The feature id for the '<em><b>Subscriptions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__SUBSCRIPTIONS = 13;

  /**
   * The feature id for the '<em><b>Tags</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION__TAGS = 14;

  /**
   * The number of structural features of the '<em>Solution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOLUTION_FEATURE_COUNT = 15;

  /**
   * The meta object id for the '{@link org.fornax.soa.solutionDsl.impl.ModuleImpl <em>Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.solutionDsl.impl.ModuleImpl
   * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getModule()
   * @generated
   */
  int MODULE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__NAME = 0;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__KIND = 1;

  /**
   * The feature id for the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__VERSION = 2;

  /**
   * The feature id for the '<em><b>Additional Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__ADDITIONAL_INFO = 3;

  /**
   * The feature id for the '<em><b>Requires</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__REQUIRES = 4;

  /**
   * The feature id for the '<em><b>Requires Channel</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__REQUIRES_CHANNEL = 5;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__FEATURES = 6;

  /**
   * The feature id for the '<em><b>Modules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__MODULES = 7;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__OWNER = 8;

  /**
   * The feature id for the '<em><b>Responsible</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__RESPONSIBLE = 9;

  /**
   * The feature id for the '<em><b>Budgeting</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__BUDGETING = 10;

  /**
   * The feature id for the '<em><b>Subscriptions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__SUBSCRIPTIONS = 11;

  /**
   * The feature id for the '<em><b>Tags</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__TAGS = 12;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = 13;

  /**
   * The meta object id for the '{@link org.fornax.soa.solutionDsl.impl.FeatureImpl <em>Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.solutionDsl.impl.FeatureImpl
   * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getFeature()
   * @generated
   */
  int FEATURE = 3;

  /**
   * The feature id for the '<em><b>Non Functional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__NON_FUNCTIONAL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__NAME = 1;

  /**
   * The feature id for the '<em><b>Use Case</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__USE_CASE = 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__DESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>Additional Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__ADDITIONAL_INFO = 4;

  /**
   * The feature id for the '<em><b>Uses Capabilities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__USES_CAPABILITIES = 5;

  /**
   * The feature id for the '<em><b>Requires</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__REQUIRES = 6;

  /**
   * The feature id for the '<em><b>Requires Channel</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__REQUIRES_CHANNEL = 7;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__OWNER = 8;

  /**
   * The feature id for the '<em><b>Responsible</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__RESPONSIBLE = 9;

  /**
   * The feature id for the '<em><b>Budgeting</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__BUDGETING = 10;

  /**
   * The feature id for the '<em><b>Subscriptions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__SUBSCRIPTIONS = 11;

  /**
   * The feature id for the '<em><b>Tags</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__TAGS = 12;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__FEATURES = 13;

  /**
   * The number of structural features of the '<em>Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FEATURE_COUNT = 14;

  /**
   * The meta object id for the '{@link org.fornax.soa.solutionDsl.impl.ServiceRefImpl <em>Service Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.solutionDsl.impl.ServiceRefImpl
   * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getServiceRef()
   * @generated
   */
  int SERVICE_REF = 4;

  /**
   * The feature id for the '<em><b>Service</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_REF__SERVICE = 0;

  /**
   * The feature id for the '<em><b>Version Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_REF__VERSION_REF = 1;

  /**
   * The feature id for the '<em><b>Is Response Handler</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_REF__IS_RESPONSE_HANDLER = 2;

  /**
   * The feature id for the '<em><b>Called Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_REF__CALLED_OPERATIONS = 3;

  /**
   * The number of structural features of the '<em>Service Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_REF_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.fornax.soa.solutionDsl.impl.SimpleOperationRefImpl <em>Simple Operation Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.solutionDsl.impl.SimpleOperationRefImpl
   * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getSimpleOperationRef()
   * @generated
   */
  int SIMPLE_OPERATION_REF = 5;

  /**
   * The feature id for the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_OPERATION_REF__OPERATION = 0;

  /**
   * The number of structural features of the '<em>Simple Operation Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_OPERATION_REF_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.fornax.soa.solutionDsl.impl.CapabilityRefImpl <em>Capability Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.solutionDsl.impl.CapabilityRefImpl
   * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getCapabilityRef()
   * @generated
   */
  int CAPABILITY_REF = 6;

  /**
   * The feature id for the '<em><b>Capability</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPABILITY_REF__CAPABILITY = 0;

  /**
   * The feature id for the '<em><b>Version Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPABILITY_REF__VERSION_REF = 1;

  /**
   * The number of structural features of the '<em>Capability Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPABILITY_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.fornax.soa.solutionDsl.impl.VersionImpl <em>Version</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.solutionDsl.impl.VersionImpl
   * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getVersion()
   * @generated
   */
  int VERSION = 7;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSION__VERSION = SOABaseDslPackage.VERSION__VERSION;

  /**
   * The number of structural features of the '<em>Version</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSION_FEATURE_COUNT = SOABaseDslPackage.VERSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.fornax.soa.solutionDsl.impl.EventRefImpl <em>Event Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.solutionDsl.impl.EventRefImpl
   * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getEventRef()
   * @generated
   */
  int EVENT_REF = 8;

  /**
   * The feature id for the '<em><b>Event</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_REF__EVENT = 0;

  /**
   * The feature id for the '<em><b>Version Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_REF__VERSION_REF = 1;

  /**
   * The number of structural features of the '<em>Event Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.fornax.soa.solutionDsl.ModuleKind <em>Module Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.solutionDsl.ModuleKind
   * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getModuleKind()
   * @generated
   */
  int MODULE_KIND = 9;


  /**
   * Returns the meta object for class '{@link org.fornax.soa.solutionDsl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.fornax.soa.solutionDsl.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.Model#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.fornax.soa.solutionDsl.Model#getImports()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.Model#getSolution <em>Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Solution</em>'.
   * @see org.fornax.soa.solutionDsl.Model#getSolution()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Solution();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.solutionDsl.Solution <em>Solution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Solution</em>'.
   * @see org.fornax.soa.solutionDsl.Solution
   * @generated
   */
  EClass getSolution();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.solutionDsl.Solution#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getName()
   * @see #getSolution()
   * @generated
   */
  EAttribute getSolution_Name();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.Solution#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Domain</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getDomain()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Domain();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.solutionDsl.Solution#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getVersion()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Version();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.Solution#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getState()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_State();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.solutionDsl.Solution#getProductVersion <em>Product Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Product Version</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getProductVersion()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_ProductVersion();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.solutionDsl.Solution#getAdditionalInfo <em>Additional Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Additional Info</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getAdditionalInfo()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_AdditionalInfo();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.Solution#getRequires <em>Requires</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requires</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getRequires()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Requires();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Solution#getRequiresChannel <em>Requires Channel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Requires Channel</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getRequiresChannel()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_RequiresChannel();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.Solution#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getFeatures()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Features();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.Solution#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modules</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getModules()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Modules();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.Solution#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Owner</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getOwner()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Owner();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Solution#getResponsible <em>Responsible</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Responsible</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getResponsible()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Responsible();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.Solution#getBudgeting <em>Budgeting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Budgeting</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getBudgeting()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Budgeting();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Solution#getSubscriptions <em>Subscriptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Subscriptions</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getSubscriptions()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Subscriptions();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Solution#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Tags</em>'.
   * @see org.fornax.soa.solutionDsl.Solution#getTags()
   * @see #getSolution()
   * @generated
   */
  EReference getSolution_Tags();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.solutionDsl.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module</em>'.
   * @see org.fornax.soa.solutionDsl.Module
   * @generated
   */
  EClass getModule();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.solutionDsl.Module#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getName()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Name();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.solutionDsl.Module#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getKind()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Kind();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.solutionDsl.Module#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getVersion()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Version();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.solutionDsl.Module#getAdditionalInfo <em>Additional Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Additional Info</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getAdditionalInfo()
   * @see #getModule()
   * @generated
   */
  EReference getModule_AdditionalInfo();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.Module#getRequires <em>Requires</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requires</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getRequires()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Requires();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Module#getRequiresChannel <em>Requires Channel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Requires Channel</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getRequiresChannel()
   * @see #getModule()
   * @generated
   */
  EReference getModule_RequiresChannel();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.Module#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getFeatures()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Features();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.Module#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modules</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getModules()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Modules();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.Module#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Owner</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getOwner()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Owner();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Module#getResponsible <em>Responsible</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Responsible</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getResponsible()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Responsible();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.Module#getBudgeting <em>Budgeting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Budgeting</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getBudgeting()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Budgeting();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Module#getSubscriptions <em>Subscriptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Subscriptions</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getSubscriptions()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Subscriptions();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Module#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Tags</em>'.
   * @see org.fornax.soa.solutionDsl.Module#getTags()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Tags();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.solutionDsl.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature</em>'.
   * @see org.fornax.soa.solutionDsl.Feature
   * @generated
   */
  EClass getFeature();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.solutionDsl.Feature#isNonFunctional <em>Non Functional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Non Functional</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#isNonFunctional()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_NonFunctional();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.solutionDsl.Feature#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getName()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_Name();

  /**
   * Returns the meta object for the attribute list '{@link org.fornax.soa.solutionDsl.Feature#getUseCase <em>Use Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Use Case</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getUseCase()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_UseCase();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.solutionDsl.Feature#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getDescription()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_Description();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.solutionDsl.Feature#getAdditionalInfo <em>Additional Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Additional Info</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getAdditionalInfo()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_AdditionalInfo();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.Feature#getUsesCapabilities <em>Uses Capabilities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Uses Capabilities</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getUsesCapabilities()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_UsesCapabilities();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.Feature#getRequires <em>Requires</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requires</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getRequires()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Requires();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Feature#getRequiresChannel <em>Requires Channel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Requires Channel</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getRequiresChannel()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_RequiresChannel();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.Feature#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Owner</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getOwner()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Owner();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Feature#getResponsible <em>Responsible</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Responsible</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getResponsible()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Responsible();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.Feature#getBudgeting <em>Budgeting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Budgeting</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getBudgeting()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Budgeting();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Feature#getSubscriptions <em>Subscriptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Subscriptions</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getSubscriptions()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Subscriptions();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.solutionDsl.Feature#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Tags</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getTags()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Tags();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.Feature#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.fornax.soa.solutionDsl.Feature#getFeatures()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Features();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.solutionDsl.ServiceRef <em>Service Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Service Ref</em>'.
   * @see org.fornax.soa.solutionDsl.ServiceRef
   * @generated
   */
  EClass getServiceRef();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.ServiceRef#getService <em>Service</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Service</em>'.
   * @see org.fornax.soa.solutionDsl.ServiceRef#getService()
   * @see #getServiceRef()
   * @generated
   */
  EReference getServiceRef_Service();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.solutionDsl.ServiceRef#getVersionRef <em>Version Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version Ref</em>'.
   * @see org.fornax.soa.solutionDsl.ServiceRef#getVersionRef()
   * @see #getServiceRef()
   * @generated
   */
  EReference getServiceRef_VersionRef();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.solutionDsl.ServiceRef#isIsResponseHandler <em>Is Response Handler</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Response Handler</em>'.
   * @see org.fornax.soa.solutionDsl.ServiceRef#isIsResponseHandler()
   * @see #getServiceRef()
   * @generated
   */
  EAttribute getServiceRef_IsResponseHandler();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.solutionDsl.ServiceRef#getCalledOperations <em>Called Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Called Operations</em>'.
   * @see org.fornax.soa.solutionDsl.ServiceRef#getCalledOperations()
   * @see #getServiceRef()
   * @generated
   */
  EReference getServiceRef_CalledOperations();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.solutionDsl.SimpleOperationRef <em>Simple Operation Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Operation Ref</em>'.
   * @see org.fornax.soa.solutionDsl.SimpleOperationRef
   * @generated
   */
  EClass getSimpleOperationRef();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.SimpleOperationRef#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Operation</em>'.
   * @see org.fornax.soa.solutionDsl.SimpleOperationRef#getOperation()
   * @see #getSimpleOperationRef()
   * @generated
   */
  EReference getSimpleOperationRef_Operation();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.solutionDsl.CapabilityRef <em>Capability Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Capability Ref</em>'.
   * @see org.fornax.soa.solutionDsl.CapabilityRef
   * @generated
   */
  EClass getCapabilityRef();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.CapabilityRef#getCapability <em>Capability</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Capability</em>'.
   * @see org.fornax.soa.solutionDsl.CapabilityRef#getCapability()
   * @see #getCapabilityRef()
   * @generated
   */
  EReference getCapabilityRef_Capability();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.solutionDsl.CapabilityRef#getVersionRef <em>Version Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version Ref</em>'.
   * @see org.fornax.soa.solutionDsl.CapabilityRef#getVersionRef()
   * @see #getCapabilityRef()
   * @generated
   */
  EReference getCapabilityRef_VersionRef();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.solutionDsl.Version <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Version</em>'.
   * @see org.fornax.soa.solutionDsl.Version
   * @generated
   */
  EClass getVersion();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.solutionDsl.EventRef <em>Event Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Ref</em>'.
   * @see org.fornax.soa.solutionDsl.EventRef
   * @generated
   */
  EClass getEventRef();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.solutionDsl.EventRef#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Event</em>'.
   * @see org.fornax.soa.solutionDsl.EventRef#getEvent()
   * @see #getEventRef()
   * @generated
   */
  EReference getEventRef_Event();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.solutionDsl.EventRef#getVersionRef <em>Version Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version Ref</em>'.
   * @see org.fornax.soa.solutionDsl.EventRef#getVersionRef()
   * @see #getEventRef()
   * @generated
   */
  EReference getEventRef_VersionRef();

  /**
   * Returns the meta object for enum '{@link org.fornax.soa.solutionDsl.ModuleKind <em>Module Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Module Kind</em>'.
   * @see org.fornax.soa.solutionDsl.ModuleKind
   * @generated
   */
  EEnum getModuleKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SolutionDslFactory getSolutionDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.fornax.soa.solutionDsl.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.solutionDsl.impl.ModelImpl
     * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__IMPORTS = eINSTANCE.getModel_Imports();

    /**
     * The meta object literal for the '<em><b>Solution</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__SOLUTION = eINSTANCE.getModel_Solution();

    /**
     * The meta object literal for the '{@link org.fornax.soa.solutionDsl.impl.SolutionImpl <em>Solution</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.solutionDsl.impl.SolutionImpl
     * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getSolution()
     * @generated
     */
    EClass SOLUTION = eINSTANCE.getSolution();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOLUTION__NAME = eINSTANCE.getSolution_Name();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__DOMAIN = eINSTANCE.getSolution_Domain();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__VERSION = eINSTANCE.getSolution_Version();

    /**
     * The meta object literal for the '<em><b>State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__STATE = eINSTANCE.getSolution_State();

    /**
     * The meta object literal for the '<em><b>Product Version</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__PRODUCT_VERSION = eINSTANCE.getSolution_ProductVersion();

    /**
     * The meta object literal for the '<em><b>Additional Info</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__ADDITIONAL_INFO = eINSTANCE.getSolution_AdditionalInfo();

    /**
     * The meta object literal for the '<em><b>Requires</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__REQUIRES = eINSTANCE.getSolution_Requires();

    /**
     * The meta object literal for the '<em><b>Requires Channel</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__REQUIRES_CHANNEL = eINSTANCE.getSolution_RequiresChannel();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__FEATURES = eINSTANCE.getSolution_Features();

    /**
     * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__MODULES = eINSTANCE.getSolution_Modules();

    /**
     * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__OWNER = eINSTANCE.getSolution_Owner();

    /**
     * The meta object literal for the '<em><b>Responsible</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__RESPONSIBLE = eINSTANCE.getSolution_Responsible();

    /**
     * The meta object literal for the '<em><b>Budgeting</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__BUDGETING = eINSTANCE.getSolution_Budgeting();

    /**
     * The meta object literal for the '<em><b>Subscriptions</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__SUBSCRIPTIONS = eINSTANCE.getSolution_Subscriptions();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOLUTION__TAGS = eINSTANCE.getSolution_Tags();

    /**
     * The meta object literal for the '{@link org.fornax.soa.solutionDsl.impl.ModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.solutionDsl.impl.ModuleImpl
     * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getModule()
     * @generated
     */
    EClass MODULE = eINSTANCE.getModule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__NAME = eINSTANCE.getModule_Name();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__KIND = eINSTANCE.getModule_Kind();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__VERSION = eINSTANCE.getModule_Version();

    /**
     * The meta object literal for the '<em><b>Additional Info</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__ADDITIONAL_INFO = eINSTANCE.getModule_AdditionalInfo();

    /**
     * The meta object literal for the '<em><b>Requires</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__REQUIRES = eINSTANCE.getModule_Requires();

    /**
     * The meta object literal for the '<em><b>Requires Channel</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__REQUIRES_CHANNEL = eINSTANCE.getModule_RequiresChannel();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__FEATURES = eINSTANCE.getModule_Features();

    /**
     * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__MODULES = eINSTANCE.getModule_Modules();

    /**
     * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__OWNER = eINSTANCE.getModule_Owner();

    /**
     * The meta object literal for the '<em><b>Responsible</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__RESPONSIBLE = eINSTANCE.getModule_Responsible();

    /**
     * The meta object literal for the '<em><b>Budgeting</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__BUDGETING = eINSTANCE.getModule_Budgeting();

    /**
     * The meta object literal for the '<em><b>Subscriptions</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__SUBSCRIPTIONS = eINSTANCE.getModule_Subscriptions();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__TAGS = eINSTANCE.getModule_Tags();

    /**
     * The meta object literal for the '{@link org.fornax.soa.solutionDsl.impl.FeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.solutionDsl.impl.FeatureImpl
     * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getFeature()
     * @generated
     */
    EClass FEATURE = eINSTANCE.getFeature();

    /**
     * The meta object literal for the '<em><b>Non Functional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__NON_FUNCTIONAL = eINSTANCE.getFeature_NonFunctional();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

    /**
     * The meta object literal for the '<em><b>Use Case</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__USE_CASE = eINSTANCE.getFeature_UseCase();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__DESCRIPTION = eINSTANCE.getFeature_Description();

    /**
     * The meta object literal for the '<em><b>Additional Info</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__ADDITIONAL_INFO = eINSTANCE.getFeature_AdditionalInfo();

    /**
     * The meta object literal for the '<em><b>Uses Capabilities</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__USES_CAPABILITIES = eINSTANCE.getFeature_UsesCapabilities();

    /**
     * The meta object literal for the '<em><b>Requires</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__REQUIRES = eINSTANCE.getFeature_Requires();

    /**
     * The meta object literal for the '<em><b>Requires Channel</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__REQUIRES_CHANNEL = eINSTANCE.getFeature_RequiresChannel();

    /**
     * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__OWNER = eINSTANCE.getFeature_Owner();

    /**
     * The meta object literal for the '<em><b>Responsible</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__RESPONSIBLE = eINSTANCE.getFeature_Responsible();

    /**
     * The meta object literal for the '<em><b>Budgeting</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__BUDGETING = eINSTANCE.getFeature_Budgeting();

    /**
     * The meta object literal for the '<em><b>Subscriptions</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__SUBSCRIPTIONS = eINSTANCE.getFeature_Subscriptions();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__TAGS = eINSTANCE.getFeature_Tags();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__FEATURES = eINSTANCE.getFeature_Features();

    /**
     * The meta object literal for the '{@link org.fornax.soa.solutionDsl.impl.ServiceRefImpl <em>Service Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.solutionDsl.impl.ServiceRefImpl
     * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getServiceRef()
     * @generated
     */
    EClass SERVICE_REF = eINSTANCE.getServiceRef();

    /**
     * The meta object literal for the '<em><b>Service</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SERVICE_REF__SERVICE = eINSTANCE.getServiceRef_Service();

    /**
     * The meta object literal for the '<em><b>Version Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SERVICE_REF__VERSION_REF = eINSTANCE.getServiceRef_VersionRef();

    /**
     * The meta object literal for the '<em><b>Is Response Handler</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SERVICE_REF__IS_RESPONSE_HANDLER = eINSTANCE.getServiceRef_IsResponseHandler();

    /**
     * The meta object literal for the '<em><b>Called Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SERVICE_REF__CALLED_OPERATIONS = eINSTANCE.getServiceRef_CalledOperations();

    /**
     * The meta object literal for the '{@link org.fornax.soa.solutionDsl.impl.SimpleOperationRefImpl <em>Simple Operation Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.solutionDsl.impl.SimpleOperationRefImpl
     * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getSimpleOperationRef()
     * @generated
     */
    EClass SIMPLE_OPERATION_REF = eINSTANCE.getSimpleOperationRef();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_OPERATION_REF__OPERATION = eINSTANCE.getSimpleOperationRef_Operation();

    /**
     * The meta object literal for the '{@link org.fornax.soa.solutionDsl.impl.CapabilityRefImpl <em>Capability Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.solutionDsl.impl.CapabilityRefImpl
     * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getCapabilityRef()
     * @generated
     */
    EClass CAPABILITY_REF = eINSTANCE.getCapabilityRef();

    /**
     * The meta object literal for the '<em><b>Capability</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPABILITY_REF__CAPABILITY = eINSTANCE.getCapabilityRef_Capability();

    /**
     * The meta object literal for the '<em><b>Version Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPABILITY_REF__VERSION_REF = eINSTANCE.getCapabilityRef_VersionRef();

    /**
     * The meta object literal for the '{@link org.fornax.soa.solutionDsl.impl.VersionImpl <em>Version</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.solutionDsl.impl.VersionImpl
     * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getVersion()
     * @generated
     */
    EClass VERSION = eINSTANCE.getVersion();

    /**
     * The meta object literal for the '{@link org.fornax.soa.solutionDsl.impl.EventRefImpl <em>Event Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.solutionDsl.impl.EventRefImpl
     * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getEventRef()
     * @generated
     */
    EClass EVENT_REF = eINSTANCE.getEventRef();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_REF__EVENT = eINSTANCE.getEventRef_Event();

    /**
     * The meta object literal for the '<em><b>Version Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_REF__VERSION_REF = eINSTANCE.getEventRef_VersionRef();

    /**
     * The meta object literal for the '{@link org.fornax.soa.solutionDsl.ModuleKind <em>Module Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.solutionDsl.ModuleKind
     * @see org.fornax.soa.solutionDsl.impl.SolutionDslPackageImpl#getModuleKind()
     * @generated
     */
    EEnum MODULE_KIND = eINSTANCE.getModuleKind();

  }

} //SolutionDslPackage
