/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.fornax.soa.sladsl.sLADsl.SLADslFactory
 * @model kind="package"
 * @generated
 */
public interface SLADslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "sLADsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.fornax.org/soa/sladsl/SLADsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "sLADsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SLADslPackage eINSTANCE = org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl.init();

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.SlaModelImpl <em>Sla Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.SlaModelImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getSlaModel()
   * @generated
   */
  int SLA_MODEL = 0;

  /**
   * The feature id for the '<em><b>Agreements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA_MODEL__AGREEMENTS = 0;

  /**
   * The number of structural features of the '<em>Sla Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl <em>SLA</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLAImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getSLA()
   * @generated
   */
  int SLA = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__NAME = 0;

  /**
   * The feature id for the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__VERSION = 1;

  /**
   * The feature id for the '<em><b>Effective Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__EFFECTIVE_DATE = 2;

  /**
   * The feature id for the '<em><b>Effective Until</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__EFFECTIVE_UNTIL = 3;

  /**
   * The feature id for the '<em><b>Parties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__PARTIES = 4;

  /**
   * The feature id for the '<em><b>Scope</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__SCOPE = 5;

  /**
   * The feature id for the '<em><b>Preample</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__PREAMPLE = 6;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__DESCRIPTION = 7;

  /**
   * The feature id for the '<em><b>Restrictions</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__RESTRICTIONS = 8;

  /**
   * The feature id for the '<em><b>Priorities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__PRIORITIES = 9;

  /**
   * The feature id for the '<em><b>Applies To</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__APPLIES_TO = 10;

  /**
   * The feature id for the '<em><b>Costs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__COSTS = 11;

  /**
   * The feature id for the '<em><b>Service Quality Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__SERVICE_QUALITY_PROPERTIES = 12;

  /**
   * The feature id for the '<em><b>Data Sec Prot Clause</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__DATA_SEC_PROT_CLAUSE = 13;

  /**
   * The feature id for the '<em><b>Security Requirements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__SECURITY_REQUIREMENTS = 14;

  /**
   * The feature id for the '<em><b>Additional Services</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__ADDITIONAL_SERVICES = 15;

  /**
   * The feature id for the '<em><b>Escalation Procedure</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__ESCALATION_PROCEDURE = 16;

  /**
   * The feature id for the '<em><b>Cancellation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__CANCELLATION = 17;

  /**
   * The feature id for the '<em><b>Extraordinary Cancellation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__EXTRAORDINARY_CANCELLATION = 18;

  /**
   * The feature id for the '<em><b>Reports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__REPORTS = 19;

  /**
   * The feature id for the '<em><b>Subscriptions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__SUBSCRIPTIONS = 20;

  /**
   * The feature id for the '<em><b>Tags</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA__TAGS = 21;

  /**
   * The number of structural features of the '<em>SLA</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLA_FEATURE_COUNT = 22;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.CostImpl <em>Cost</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.CostImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getCost()
   * @generated
   */
  int COST = 2;

  /**
   * The feature id for the '<em><b>Costs Amount</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COST__COSTS_AMOUNT = 0;

  /**
   * The feature id for the '<em><b>Billed Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COST__BILLED_UNIT = 1;

  /**
   * The feature id for the '<em><b>Effort Accounting</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COST__EFFORT_ACCOUNTING = 2;

  /**
   * The feature id for the '<em><b>Escalation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COST__ESCALATION = 3;

  /**
   * The feature id for the '<em><b>Penalty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COST__PENALTY = 4;

  /**
   * The number of structural features of the '<em>Cost</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COST_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ServiceQualityPropertyImpl <em>Service Quality Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.ServiceQualityPropertyImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getServiceQualityProperty()
   * @generated
   */
  int SERVICE_QUALITY_PROPERTY = 3;

  /**
   * The number of structural features of the '<em>Service Quality Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_QUALITY_PROPERTY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.AvailabilityImpl <em>Availability</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.AvailabilityImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getAvailability()
   * @generated
   */
  int AVAILABILITY = 4;

  /**
   * The feature id for the '<em><b>Availability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVAILABILITY__AVAILABILITY = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Mtbf</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVAILABILITY__MTBF = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mttr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVAILABILITY__MTTR = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Mttr Percentile</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVAILABILITY__MTTR_PERCENTILE = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Regular Down Times</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVAILABILITY__REGULAR_DOWN_TIMES = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Availability</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVAILABILITY_FEATURE_COUNT = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ThroughputImpl <em>Throughput</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.ThroughputImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getThroughput()
   * @generated
   */
  int THROUGHPUT = 5;

  /**
   * The feature id for the '<em><b>Definition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THROUGHPUT__DEFINITION = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Score</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THROUGHPUT__SCORE = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Escalation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THROUGHPUT__ESCALATION = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Penalty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THROUGHPUT__PENALTY = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Throughput</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THROUGHPUT_FEATURE_COUNT = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.LatencyImpl <em>Latency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.LatencyImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getLatency()
   * @generated
   */
  int LATENCY = 6;

  /**
   * The feature id for the '<em><b>Latency</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATENCY__LATENCY = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Percentile</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATENCY__PERCENTILE = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Escalation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATENCY__ESCALATION = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Penalty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATENCY__PENALTY = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Latency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LATENCY_FEATURE_COUNT = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.MaxDownTimeImpl <em>Max Down Time</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.MaxDownTimeImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getMaxDownTime()
   * @generated
   */
  int MAX_DOWN_TIME = 7;

  /**
   * The feature id for the '<em><b>Definition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAX_DOWN_TIME__DEFINITION = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Escalation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAX_DOWN_TIME__ESCALATION = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Penalty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAX_DOWN_TIME__PENALTY = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Max Down Time</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAX_DOWN_TIME_FEATURE_COUNT = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.CapacityRequirementImpl <em>Capacity Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.CapacityRequirementImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getCapacityRequirement()
   * @generated
   */
  int CAPACITY_REQUIREMENT = 8;

  /**
   * The feature id for the '<em><b>Request Num</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPACITY_REQUIREMENT__REQUEST_NUM = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Time Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPACITY_REQUIREMENT__TIME_UNIT = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Message Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPACITY_REQUIREMENT__MESSAGE_SIZE = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Escalation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPACITY_REQUIREMENT__ESCALATION = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Penalty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPACITY_REQUIREMENT__PENALTY = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Capacity Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPACITY_REQUIREMENT_FEATURE_COUNT = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ReliablityRequirementImpl <em>Reliablity Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.ReliablityRequirementImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getReliablityRequirement()
   * @generated
   */
  int RELIABLITY_REQUIREMENT = 9;

  /**
   * The feature id for the '<em><b>Reliability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELIABLITY_REQUIREMENT__RELIABILITY = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>In Order Delivery</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELIABLITY_REQUIREMENT__IN_ORDER_DELIVERY = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Reliablity Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELIABLITY_REQUIREMENT_FEATURE_COUNT = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.AccuracyRequirementImpl <em>Accuracy Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.AccuracyRequirementImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getAccuracyRequirement()
   * @generated
   */
  int ACCURACY_REQUIREMENT = 10;

  /**
   * The feature id for the '<em><b>Max Error Rate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCURACY_REQUIREMENT__MAX_ERROR_RATE = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Escalation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCURACY_REQUIREMENT__ESCALATION = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Penalty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCURACY_REQUIREMENT__PENALTY = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Accuracy Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCURACY_REQUIREMENT_FEATURE_COUNT = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.LogRequirementImpl <em>Log Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.LogRequirementImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getLogRequirement()
   * @generated
   */
  int LOG_REQUIREMENT = 11;

  /**
   * The feature id for the '<em><b>Log Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_REQUIREMENT__LOG_LEVEL = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Additional Logging Requirement</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_REQUIREMENT__ADDITIONAL_LOGGING_REQUIREMENT = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Log Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_REQUIREMENT_FEATURE_COUNT = SERVICE_QUALITY_PROPERTY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.PercentileImpl <em>Percentile</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.PercentileImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getPercentile()
   * @generated
   */
  int PERCENTILE = 12;

  /**
   * The feature id for the '<em><b>Percentile</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERCENTILE__PERCENTILE = 0;

  /**
   * The number of structural features of the '<em>Percentile</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERCENTILE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.SecurityRequirementImpl <em>Security Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.SecurityRequirementImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getSecurityRequirement()
   * @generated
   */
  int SECURITY_REQUIREMENT = 13;

  /**
   * The number of structural features of the '<em>Security Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECURITY_REQUIREMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.AuthenticationRequirementImpl <em>Authentication Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.AuthenticationRequirementImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getAuthenticationRequirement()
   * @generated
   */
  int AUTHENTICATION_REQUIREMENT = 14;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTHENTICATION_REQUIREMENT__OPTIONAL = SECURITY_REQUIREMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Auth Tokens</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTHENTICATION_REQUIREMENT__AUTH_TOKENS = SECURITY_REQUIREMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Hash Algorithms</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTHENTICATION_REQUIREMENT__HASH_ALGORITHMS = SECURITY_REQUIREMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Use Nonce</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTHENTICATION_REQUIREMENT__USE_NONCE = SECURITY_REQUIREMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Issuer</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTHENTICATION_REQUIREMENT__ISSUER = SECURITY_REQUIREMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Authentication Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTHENTICATION_REQUIREMENT_FEATURE_COUNT = SECURITY_REQUIREMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.AuthTokenImpl <em>Auth Token</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.AuthTokenImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getAuthToken()
   * @generated
   */
  int AUTH_TOKEN = 15;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTH_TOKEN__OPTIONAL = 0;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTH_TOKEN__KIND = 1;

  /**
   * The number of structural features of the '<em>Auth Token</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTH_TOKEN_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.HashAlgorithmImpl <em>Hash Algorithm</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.HashAlgorithmImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getHashAlgorithm()
   * @generated
   */
  int HASH_ALGORITHM = 16;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HASH_ALGORITHM__OPTIONAL = 0;

  /**
   * The feature id for the '<em><b>Use Base64</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HASH_ALGORITHM__USE_BASE64 = 1;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HASH_ALGORITHM__KIND = 2;

  /**
   * The number of structural features of the '<em>Hash Algorithm</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HASH_ALGORITHM_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.SigningRequirementImpl <em>Signing Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.SigningRequirementImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getSigningRequirement()
   * @generated
   */
  int SIGNING_REQUIREMENT = 17;

  /**
   * The feature id for the '<em><b>Supported Signing Algorithms</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNING_REQUIREMENT__SUPPORTED_SIGNING_ALGORITHMS = SECURITY_REQUIREMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Required Signing Algorithm</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNING_REQUIREMENT__REQUIRED_SIGNING_ALGORITHM = SECURITY_REQUIREMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Signed Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNING_REQUIREMENT__SIGNED_PARTS = SECURITY_REQUIREMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Signing Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNING_REQUIREMENT_FEATURE_COUNT = SECURITY_REQUIREMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.MessagePartRefImpl <em>Message Part Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.MessagePartRefImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getMessagePartRef()
   * @generated
   */
  int MESSAGE_PART_REF = 18;

  /**
   * The feature id for the '<em><b>Message Part Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_PART_REF__MESSAGE_PART_REF = 0;

  /**
   * The feature id for the '<em><b>Part Ref Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_PART_REF__PART_REF_EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Message Part Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_PART_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.EncryptionRequirementImpl <em>Encryption Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.EncryptionRequirementImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getEncryptionRequirement()
   * @generated
   */
  int ENCRYPTION_REQUIREMENT = 19;

  /**
   * The feature id for the '<em><b>Supported Cipher Algorithms</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENCRYPTION_REQUIREMENT__SUPPORTED_CIPHER_ALGORITHMS = SECURITY_REQUIREMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Required Cipher Algorithm</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENCRYPTION_REQUIREMENT__REQUIRED_CIPHER_ALGORITHM = SECURITY_REQUIREMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Encrypted Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENCRYPTION_REQUIREMENT__ENCRYPTED_PARTS = SECURITY_REQUIREMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Encryption Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENCRYPTION_REQUIREMENT_FEATURE_COUNT = SECURITY_REQUIREMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.PriorityDeclarationImpl <em>Priority Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.PriorityDeclarationImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getPriorityDeclaration()
   * @generated
   */
  int PRIORITY_DECLARATION = 20;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIORITY_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIORITY_DECLARATION__DESCRIPTION = 1;

  /**
   * The number of structural features of the '<em>Priority Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIORITY_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.EscalationImpl <em>Escalation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.EscalationImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getEscalation()
   * @generated
   */
  int ESCALATION = 21;

  /**
   * The feature id for the '<em><b>Cause</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESCALATION__CAUSE = 0;

  /**
   * The feature id for the '<em><b>Escalation Targets</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESCALATION__ESCALATION_TARGETS = 1;

  /**
   * The feature id for the '<em><b>Procedure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESCALATION__PROCEDURE = 2;

  /**
   * The number of structural features of the '<em>Escalation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESCALATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.PartyImpl <em>Party</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.PartyImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getParty()
   * @generated
   */
  int PARTY = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTY__NAME = 0;

  /**
   * The feature id for the '<em><b>Representatives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTY__REPRESENTATIVES = 1;

  /**
   * The feature id for the '<em><b>Responsibilities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTY__RESPONSIBILITIES = 2;

  /**
   * The number of structural features of the '<em>Party</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARTY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.CustomerPartyImpl <em>Customer Party</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.CustomerPartyImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getCustomerParty()
   * @generated
   */
  int CUSTOMER_PARTY = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOMER_PARTY__NAME = PARTY__NAME;

  /**
   * The feature id for the '<em><b>Representatives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOMER_PARTY__REPRESENTATIVES = PARTY__REPRESENTATIVES;

  /**
   * The feature id for the '<em><b>Responsibilities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOMER_PARTY__RESPONSIBILITIES = PARTY__RESPONSIBILITIES;

  /**
   * The number of structural features of the '<em>Customer Party</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOMER_PARTY_FEATURE_COUNT = PARTY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ProviderPartyImpl <em>Provider Party</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.ProviderPartyImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getProviderParty()
   * @generated
   */
  int PROVIDER_PARTY = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDER_PARTY__NAME = PARTY__NAME;

  /**
   * The feature id for the '<em><b>Representatives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDER_PARTY__REPRESENTATIVES = PARTY__REPRESENTATIVES;

  /**
   * The feature id for the '<em><b>Responsibilities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDER_PARTY__RESPONSIBILITIES = PARTY__RESPONSIBILITIES;

  /**
   * The number of structural features of the '<em>Provider Party</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDER_PARTY_FEATURE_COUNT = PARTY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ThirdPartyImpl <em>Third Party</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.ThirdPartyImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getThirdParty()
   * @generated
   */
  int THIRD_PARTY = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_PARTY__NAME = PARTY__NAME;

  /**
   * The feature id for the '<em><b>Representatives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_PARTY__REPRESENTATIVES = PARTY__REPRESENTATIVES;

  /**
   * The feature id for the '<em><b>Responsibilities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_PARTY__RESPONSIBILITIES = PARTY__RESPONSIBILITIES;

  /**
   * The feature id for the '<em><b>Role</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_PARTY__ROLE = PARTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Third Party</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_PARTY_FEATURE_COUNT = PARTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.RepresentativeImpl <em>Representative</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.RepresentativeImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getRepresentative()
   * @generated
   */
  int REPRESENTATIVE = 26;

  /**
   * The number of structural features of the '<em>Representative</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPRESENTATIVE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.UserRefImpl <em>User Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.UserRefImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getUserRef()
   * @generated
   */
  int USER_REF = 27;

  /**
   * The feature id for the '<em><b>Representative</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_REF__REPRESENTATIVE = REPRESENTATIVE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>User Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_REF_FEATURE_COUNT = REPRESENTATIVE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.InlineRepresentativeImpl <em>Inline Representative</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.InlineRepresentativeImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getInlineRepresentative()
   * @generated
   */
  int INLINE_REPRESENTATIVE = 28;

  /**
   * The feature id for the '<em><b>Firstname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_REPRESENTATIVE__FIRSTNAME = REPRESENTATIVE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Lastname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_REPRESENTATIVE__LASTNAME = REPRESENTATIVE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Org Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_REPRESENTATIVE__ORG_UNIT = REPRESENTATIVE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Email</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_REPRESENTATIVE__EMAIL = REPRESENTATIVE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Phone</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_REPRESENTATIVE__PHONE = REPRESENTATIVE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Inline Representative</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_REPRESENTATIVE_FEATURE_COUNT = REPRESENTATIVE_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ResponsibilityImpl <em>Responsibility</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.ResponsibilityImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getResponsibility()
   * @generated
   */
  int RESPONSIBILITY = 29;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESPONSIBILITY__DESCRIPTION = 0;

  /**
   * The number of structural features of the '<em>Responsibility</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESPONSIBILITY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ReportImpl <em>Report</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.impl.ReportImpl
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getReport()
   * @generated
   */
  int REPORT = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPORT__NAME = 0;

  /**
   * The feature id for the '<em><b>Report To</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPORT__REPORT_TO = 1;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPORT__CONTENT = 2;

  /**
   * The number of structural features of the '<em>Report</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPORT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.HashAlgKind <em>Hash Alg Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.HashAlgKind
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getHashAlgKind()
   * @generated
   */
  int HASH_ALG_KIND = 31;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.MessagePartRefKind <em>Message Part Ref Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.MessagePartRefKind
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getMessagePartRefKind()
   * @generated
   */
  int MESSAGE_PART_REF_KIND = 32;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.SigningAlgothm <em>Signing Algothm</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.SigningAlgothm
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getSigningAlgothm()
   * @generated
   */
  int SIGNING_ALGOTHM = 33;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind <em>Cipher Algorithm Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getCipherAlgorithmKind()
   * @generated
   */
  int CIPHER_ALGORITHM_KIND = 34;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.AuthTokenKind <em>Auth Token Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.AuthTokenKind
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getAuthTokenKind()
   * @generated
   */
  int AUTH_TOKEN_KIND = 35;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.LogRequirementKind <em>Log Requirement Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.LogRequirementKind
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getLogRequirementKind()
   * @generated
   */
  int LOG_REQUIREMENT_KIND = 36;

  /**
   * The meta object id for the '{@link org.fornax.soa.sladsl.sLADsl.ReliablilityKind <em>Reliablility Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.fornax.soa.sladsl.sLADsl.ReliablilityKind
   * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getReliablilityKind()
   * @generated
   */
  int RELIABLILITY_KIND = 37;


  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.SlaModel <em>Sla Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sla Model</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SlaModel
   * @generated
   */
  EClass getSlaModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.SlaModel#getAgreements <em>Agreements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Agreements</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SlaModel#getAgreements()
   * @see #getSlaModel()
   * @generated
   */
  EReference getSlaModel_Agreements();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.SLA <em>SLA</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SLA</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA
   * @generated
   */
  EClass getSLA();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SLA#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getName()
   * @see #getSLA()
   * @generated
   */
  EAttribute getSLA_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.sladsl.sLADsl.SLA#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getVersion()
   * @see #getSLA()
   * @generated
   */
  EReference getSLA_Version();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SLA#getEffectiveDate <em>Effective Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Effective Date</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getEffectiveDate()
   * @see #getSLA()
   * @generated
   */
  EAttribute getSLA_EffectiveDate();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SLA#getEffectiveUntil <em>Effective Until</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Effective Until</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getEffectiveUntil()
   * @see #getSLA()
   * @generated
   */
  EAttribute getSLA_EffectiveUntil();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.SLA#getParties <em>Parties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parties</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getParties()
   * @see #getSLA()
   * @generated
   */
  EReference getSLA_Parties();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SLA#getScope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Scope</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getScope()
   * @see #getSLA()
   * @generated
   */
  EAttribute getSLA_Scope();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SLA#getPreample <em>Preample</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Preample</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getPreample()
   * @see #getSLA()
   * @generated
   */
  EAttribute getSLA_Preample();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SLA#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getDescription()
   * @see #getSLA()
   * @generated
   */
  EAttribute getSLA_Description();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SLA#getRestrictions <em>Restrictions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Restrictions</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getRestrictions()
   * @see #getSLA()
   * @generated
   */
  EAttribute getSLA_Restrictions();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.SLA#getPriorities <em>Priorities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Priorities</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getPriorities()
   * @see #getSLA()
   * @generated
   */
  EReference getSLA_Priorities();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.SLA#getAppliesTo <em>Applies To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Applies To</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getAppliesTo()
   * @see #getSLA()
   * @generated
   */
  EReference getSLA_AppliesTo();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.sladsl.sLADsl.SLA#getCosts <em>Costs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Costs</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getCosts()
   * @see #getSLA()
   * @generated
   */
  EReference getSLA_Costs();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.SLA#getServiceQualityProperties <em>Service Quality Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Service Quality Properties</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getServiceQualityProperties()
   * @see #getSLA()
   * @generated
   */
  EReference getSLA_ServiceQualityProperties();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SLA#getDataSecProtClause <em>Data Sec Prot Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data Sec Prot Clause</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getDataSecProtClause()
   * @see #getSLA()
   * @generated
   */
  EAttribute getSLA_DataSecProtClause();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.SLA#getSecurityRequirements <em>Security Requirements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Security Requirements</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getSecurityRequirements()
   * @see #getSLA()
   * @generated
   */
  EReference getSLA_SecurityRequirements();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SLA#getAdditionalServices <em>Additional Services</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Additional Services</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getAdditionalServices()
   * @see #getSLA()
   * @generated
   */
  EAttribute getSLA_AdditionalServices();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.sladsl.sLADsl.SLA#getEscalationProcedure <em>Escalation Procedure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Escalation Procedure</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getEscalationProcedure()
   * @see #getSLA()
   * @generated
   */
  EReference getSLA_EscalationProcedure();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SLA#getCancellation <em>Cancellation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cancellation</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getCancellation()
   * @see #getSLA()
   * @generated
   */
  EAttribute getSLA_Cancellation();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SLA#getExtraordinaryCancellation <em>Extraordinary Cancellation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extraordinary Cancellation</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getExtraordinaryCancellation()
   * @see #getSLA()
   * @generated
   */
  EAttribute getSLA_ExtraordinaryCancellation();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.SLA#getReports <em>Reports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Reports</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getReports()
   * @see #getSLA()
   * @generated
   */
  EReference getSLA_Reports();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.sladsl.sLADsl.SLA#getSubscriptions <em>Subscriptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Subscriptions</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getSubscriptions()
   * @see #getSLA()
   * @generated
   */
  EReference getSLA_Subscriptions();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.sladsl.sLADsl.SLA#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Tags</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SLA#getTags()
   * @see #getSLA()
   * @generated
   */
  EReference getSLA_Tags();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.Cost <em>Cost</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cost</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Cost
   * @generated
   */
  EClass getCost();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Cost#getCostsAmount <em>Costs Amount</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Costs Amount</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Cost#getCostsAmount()
   * @see #getCost()
   * @generated
   */
  EAttribute getCost_CostsAmount();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Cost#getBilledUnit <em>Billed Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Billed Unit</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Cost#getBilledUnit()
   * @see #getCost()
   * @generated
   */
  EAttribute getCost_BilledUnit();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Cost#getEffortAccounting <em>Effort Accounting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Effort Accounting</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Cost#getEffortAccounting()
   * @see #getCost()
   * @generated
   */
  EAttribute getCost_EffortAccounting();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.sladsl.sLADsl.Cost#getEscalation <em>Escalation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Escalation</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Cost#getEscalation()
   * @see #getCost()
   * @generated
   */
  EReference getCost_Escalation();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Cost#getPenalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Penalty</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Cost#getPenalty()
   * @see #getCost()
   * @generated
   */
  EAttribute getCost_Penalty();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.ServiceQualityProperty <em>Service Quality Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Service Quality Property</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.ServiceQualityProperty
   * @generated
   */
  EClass getServiceQualityProperty();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.Availability <em>Availability</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Availability</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Availability
   * @generated
   */
  EClass getAvailability();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Availability#getAvailability <em>Availability</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Availability</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Availability#getAvailability()
   * @see #getAvailability()
   * @generated
   */
  EAttribute getAvailability_Availability();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Availability#getMtbf <em>Mtbf</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mtbf</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Availability#getMtbf()
   * @see #getAvailability()
   * @generated
   */
  EAttribute getAvailability_Mtbf();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Availability#getMttr <em>Mttr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mttr</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Availability#getMttr()
   * @see #getAvailability()
   * @generated
   */
  EAttribute getAvailability_Mttr();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.sladsl.sLADsl.Availability#getMttrPercentile <em>Mttr Percentile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Mttr Percentile</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Availability#getMttrPercentile()
   * @see #getAvailability()
   * @generated
   */
  EReference getAvailability_MttrPercentile();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Availability#getRegularDownTimes <em>Regular Down Times</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Regular Down Times</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Availability#getRegularDownTimes()
   * @see #getAvailability()
   * @generated
   */
  EAttribute getAvailability_RegularDownTimes();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.Throughput <em>Throughput</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Throughput</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Throughput
   * @generated
   */
  EClass getThroughput();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Throughput#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Definition</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Throughput#getDefinition()
   * @see #getThroughput()
   * @generated
   */
  EAttribute getThroughput_Definition();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Throughput#getScore <em>Score</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Score</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Throughput#getScore()
   * @see #getThroughput()
   * @generated
   */
  EAttribute getThroughput_Score();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.sladsl.sLADsl.Throughput#getEscalation <em>Escalation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Escalation</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Throughput#getEscalation()
   * @see #getThroughput()
   * @generated
   */
  EReference getThroughput_Escalation();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Throughput#getPenalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Penalty</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Throughput#getPenalty()
   * @see #getThroughput()
   * @generated
   */
  EAttribute getThroughput_Penalty();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.Latency <em>Latency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Latency</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Latency
   * @generated
   */
  EClass getLatency();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Latency#getLatency <em>Latency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Latency</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Latency#getLatency()
   * @see #getLatency()
   * @generated
   */
  EAttribute getLatency_Latency();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.sladsl.sLADsl.Latency#getPercentile <em>Percentile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Percentile</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Latency#getPercentile()
   * @see #getLatency()
   * @generated
   */
  EReference getLatency_Percentile();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.sladsl.sLADsl.Latency#getEscalation <em>Escalation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Escalation</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Latency#getEscalation()
   * @see #getLatency()
   * @generated
   */
  EReference getLatency_Escalation();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Latency#getPenalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Penalty</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Latency#getPenalty()
   * @see #getLatency()
   * @generated
   */
  EAttribute getLatency_Penalty();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.MaxDownTime <em>Max Down Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Max Down Time</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.MaxDownTime
   * @generated
   */
  EClass getMaxDownTime();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.MaxDownTime#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Definition</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.MaxDownTime#getDefinition()
   * @see #getMaxDownTime()
   * @generated
   */
  EAttribute getMaxDownTime_Definition();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.sladsl.sLADsl.MaxDownTime#getEscalation <em>Escalation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Escalation</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.MaxDownTime#getEscalation()
   * @see #getMaxDownTime()
   * @generated
   */
  EReference getMaxDownTime_Escalation();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.MaxDownTime#getPenalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Penalty</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.MaxDownTime#getPenalty()
   * @see #getMaxDownTime()
   * @generated
   */
  EAttribute getMaxDownTime_Penalty();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement <em>Capacity Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Capacity Requirement</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.CapacityRequirement
   * @generated
   */
  EClass getCapacityRequirement();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getRequestNum <em>Request Num</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Request Num</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getRequestNum()
   * @see #getCapacityRequirement()
   * @generated
   */
  EAttribute getCapacityRequirement_RequestNum();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getTimeUnit <em>Time Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Time Unit</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getTimeUnit()
   * @see #getCapacityRequirement()
   * @generated
   */
  EAttribute getCapacityRequirement_TimeUnit();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getMessageSize <em>Message Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message Size</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getMessageSize()
   * @see #getCapacityRequirement()
   * @generated
   */
  EAttribute getCapacityRequirement_MessageSize();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getEscalation <em>Escalation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Escalation</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getEscalation()
   * @see #getCapacityRequirement()
   * @generated
   */
  EReference getCapacityRequirement_Escalation();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getPenalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Penalty</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getPenalty()
   * @see #getCapacityRequirement()
   * @generated
   */
  EAttribute getCapacityRequirement_Penalty();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.ReliablityRequirement <em>Reliablity Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reliablity Requirement</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.ReliablityRequirement
   * @generated
   */
  EClass getReliablityRequirement();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.ReliablityRequirement#getReliability <em>Reliability</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reliability</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.ReliablityRequirement#getReliability()
   * @see #getReliablityRequirement()
   * @generated
   */
  EAttribute getReliablityRequirement_Reliability();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.ReliablityRequirement#isInOrderDelivery <em>In Order Delivery</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>In Order Delivery</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.ReliablityRequirement#isInOrderDelivery()
   * @see #getReliablityRequirement()
   * @generated
   */
  EAttribute getReliablityRequirement_InOrderDelivery();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.AccuracyRequirement <em>Accuracy Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Accuracy Requirement</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AccuracyRequirement
   * @generated
   */
  EClass getAccuracyRequirement();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getMaxErrorRate <em>Max Error Rate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Max Error Rate</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getMaxErrorRate()
   * @see #getAccuracyRequirement()
   * @generated
   */
  EAttribute getAccuracyRequirement_MaxErrorRate();

  /**
   * Returns the meta object for the containment reference '{@link org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getEscalation <em>Escalation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Escalation</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getEscalation()
   * @see #getAccuracyRequirement()
   * @generated
   */
  EReference getAccuracyRequirement_Escalation();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getPenalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Penalty</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getPenalty()
   * @see #getAccuracyRequirement()
   * @generated
   */
  EAttribute getAccuracyRequirement_Penalty();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.LogRequirement <em>Log Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Log Requirement</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.LogRequirement
   * @generated
   */
  EClass getLogRequirement();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.LogRequirement#getLogLevel <em>Log Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Log Level</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.LogRequirement#getLogLevel()
   * @see #getLogRequirement()
   * @generated
   */
  EAttribute getLogRequirement_LogLevel();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.LogRequirement#getAdditionalLoggingRequirement <em>Additional Logging Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Additional Logging Requirement</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.LogRequirement#getAdditionalLoggingRequirement()
   * @see #getLogRequirement()
   * @generated
   */
  EAttribute getLogRequirement_AdditionalLoggingRequirement();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.Percentile <em>Percentile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Percentile</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Percentile
   * @generated
   */
  EClass getPercentile();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Percentile#getPercentile <em>Percentile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Percentile</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Percentile#getPercentile()
   * @see #getPercentile()
   * @generated
   */
  EAttribute getPercentile_Percentile();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.SecurityRequirement <em>Security Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Security Requirement</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SecurityRequirement
   * @generated
   */
  EClass getSecurityRequirement();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement <em>Authentication Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Authentication Requirement</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement
   * @generated
   */
  EClass getAuthenticationRequirement();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#isOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#isOptional()
   * @see #getAuthenticationRequirement()
   * @generated
   */
  EAttribute getAuthenticationRequirement_Optional();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#getAuthTokens <em>Auth Tokens</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Auth Tokens</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#getAuthTokens()
   * @see #getAuthenticationRequirement()
   * @generated
   */
  EReference getAuthenticationRequirement_AuthTokens();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#getHashAlgorithms <em>Hash Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Hash Algorithms</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#getHashAlgorithms()
   * @see #getAuthenticationRequirement()
   * @generated
   */
  EReference getAuthenticationRequirement_HashAlgorithms();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#isUseNonce <em>Use Nonce</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Use Nonce</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#isUseNonce()
   * @see #getAuthenticationRequirement()
   * @generated
   */
  EAttribute getAuthenticationRequirement_UseNonce();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#getIssuer <em>Issuer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Issuer</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement#getIssuer()
   * @see #getAuthenticationRequirement()
   * @generated
   */
  EAttribute getAuthenticationRequirement_Issuer();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.AuthToken <em>Auth Token</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Auth Token</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AuthToken
   * @generated
   */
  EClass getAuthToken();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.AuthToken#isOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AuthToken#isOptional()
   * @see #getAuthToken()
   * @generated
   */
  EAttribute getAuthToken_Optional();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.AuthToken#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AuthToken#getKind()
   * @see #getAuthToken()
   * @generated
   */
  EAttribute getAuthToken_Kind();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm <em>Hash Algorithm</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hash Algorithm</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.HashAlgorithm
   * @generated
   */
  EClass getHashAlgorithm();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm#isOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.HashAlgorithm#isOptional()
   * @see #getHashAlgorithm()
   * @generated
   */
  EAttribute getHashAlgorithm_Optional();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm#isUseBase64 <em>Use Base64</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Use Base64</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.HashAlgorithm#isUseBase64()
   * @see #getHashAlgorithm()
   * @generated
   */
  EAttribute getHashAlgorithm_UseBase64();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.HashAlgorithm#getKind()
   * @see #getHashAlgorithm()
   * @generated
   */
  EAttribute getHashAlgorithm_Kind();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.SigningRequirement <em>Signing Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Signing Requirement</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SigningRequirement
   * @generated
   */
  EClass getSigningRequirement();

  /**
   * Returns the meta object for the attribute list '{@link org.fornax.soa.sladsl.sLADsl.SigningRequirement#getSupportedSigningAlgorithms <em>Supported Signing Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Supported Signing Algorithms</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SigningRequirement#getSupportedSigningAlgorithms()
   * @see #getSigningRequirement()
   * @generated
   */
  EAttribute getSigningRequirement_SupportedSigningAlgorithms();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.SigningRequirement#getRequiredSigningAlgorithm <em>Required Signing Algorithm</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Required Signing Algorithm</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SigningRequirement#getRequiredSigningAlgorithm()
   * @see #getSigningRequirement()
   * @generated
   */
  EAttribute getSigningRequirement_RequiredSigningAlgorithm();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.SigningRequirement#getSignedParts <em>Signed Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Signed Parts</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SigningRequirement#getSignedParts()
   * @see #getSigningRequirement()
   * @generated
   */
  EReference getSigningRequirement_SignedParts();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.MessagePartRef <em>Message Part Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Message Part Ref</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.MessagePartRef
   * @generated
   */
  EClass getMessagePartRef();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.MessagePartRef#getMessagePartRef <em>Message Part Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message Part Ref</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.MessagePartRef#getMessagePartRef()
   * @see #getMessagePartRef()
   * @generated
   */
  EAttribute getMessagePartRef_MessagePartRef();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.MessagePartRef#getPartRefExpression <em>Part Ref Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Part Ref Expression</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.MessagePartRef#getPartRefExpression()
   * @see #getMessagePartRef()
   * @generated
   */
  EAttribute getMessagePartRef_PartRefExpression();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.EncryptionRequirement <em>Encryption Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Encryption Requirement</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.EncryptionRequirement
   * @generated
   */
  EClass getEncryptionRequirement();

  /**
   * Returns the meta object for the attribute list '{@link org.fornax.soa.sladsl.sLADsl.EncryptionRequirement#getSupportedCipherAlgorithms <em>Supported Cipher Algorithms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Supported Cipher Algorithms</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.EncryptionRequirement#getSupportedCipherAlgorithms()
   * @see #getEncryptionRequirement()
   * @generated
   */
  EAttribute getEncryptionRequirement_SupportedCipherAlgorithms();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.EncryptionRequirement#getRequiredCipherAlgorithm <em>Required Cipher Algorithm</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Required Cipher Algorithm</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.EncryptionRequirement#getRequiredCipherAlgorithm()
   * @see #getEncryptionRequirement()
   * @generated
   */
  EAttribute getEncryptionRequirement_RequiredCipherAlgorithm();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.EncryptionRequirement#getEncryptedParts <em>Encrypted Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Encrypted Parts</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.EncryptionRequirement#getEncryptedParts()
   * @see #getEncryptionRequirement()
   * @generated
   */
  EReference getEncryptionRequirement_EncryptedParts();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.PriorityDeclaration <em>Priority Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Priority Declaration</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.PriorityDeclaration
   * @generated
   */
  EClass getPriorityDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.PriorityDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.PriorityDeclaration#getName()
   * @see #getPriorityDeclaration()
   * @generated
   */
  EAttribute getPriorityDeclaration_Name();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.PriorityDeclaration#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.PriorityDeclaration#getDescription()
   * @see #getPriorityDeclaration()
   * @generated
   */
  EAttribute getPriorityDeclaration_Description();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.Escalation <em>Escalation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Escalation</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Escalation
   * @generated
   */
  EClass getEscalation();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Escalation#getCause <em>Cause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cause</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Escalation#getCause()
   * @see #getEscalation()
   * @generated
   */
  EAttribute getEscalation_Cause();

  /**
   * Returns the meta object for the reference list '{@link org.fornax.soa.sladsl.sLADsl.Escalation#getEscalationTargets <em>Escalation Targets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Escalation Targets</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Escalation#getEscalationTargets()
   * @see #getEscalation()
   * @generated
   */
  EReference getEscalation_EscalationTargets();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Escalation#getProcedure <em>Procedure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Procedure</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Escalation#getProcedure()
   * @see #getEscalation()
   * @generated
   */
  EAttribute getEscalation_Procedure();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.Party <em>Party</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Party</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Party
   * @generated
   */
  EClass getParty();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Party#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Party#getName()
   * @see #getParty()
   * @generated
   */
  EAttribute getParty_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.Party#getRepresentatives <em>Representatives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Representatives</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Party#getRepresentatives()
   * @see #getParty()
   * @generated
   */
  EReference getParty_Representatives();

  /**
   * Returns the meta object for the containment reference list '{@link org.fornax.soa.sladsl.sLADsl.Party#getResponsibilities <em>Responsibilities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Responsibilities</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Party#getResponsibilities()
   * @see #getParty()
   * @generated
   */
  EReference getParty_Responsibilities();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.CustomerParty <em>Customer Party</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Customer Party</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.CustomerParty
   * @generated
   */
  EClass getCustomerParty();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.ProviderParty <em>Provider Party</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Provider Party</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.ProviderParty
   * @generated
   */
  EClass getProviderParty();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.ThirdParty <em>Third Party</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Third Party</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.ThirdParty
   * @generated
   */
  EClass getThirdParty();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.ThirdParty#getRole <em>Role</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Role</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.ThirdParty#getRole()
   * @see #getThirdParty()
   * @generated
   */
  EAttribute getThirdParty_Role();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.Representative <em>Representative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Representative</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Representative
   * @generated
   */
  EClass getRepresentative();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.UserRef <em>User Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>User Ref</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.UserRef
   * @generated
   */
  EClass getUserRef();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.sladsl.sLADsl.UserRef#getRepresentative <em>Representative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Representative</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.UserRef#getRepresentative()
   * @see #getUserRef()
   * @generated
   */
  EReference getUserRef_Representative();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.InlineRepresentative <em>Inline Representative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inline Representative</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.InlineRepresentative
   * @generated
   */
  EClass getInlineRepresentative();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.InlineRepresentative#getFirstname <em>Firstname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Firstname</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.InlineRepresentative#getFirstname()
   * @see #getInlineRepresentative()
   * @generated
   */
  EAttribute getInlineRepresentative_Firstname();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.InlineRepresentative#getLastname <em>Lastname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lastname</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.InlineRepresentative#getLastname()
   * @see #getInlineRepresentative()
   * @generated
   */
  EAttribute getInlineRepresentative_Lastname();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.InlineRepresentative#getOrgUnit <em>Org Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Org Unit</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.InlineRepresentative#getOrgUnit()
   * @see #getInlineRepresentative()
   * @generated
   */
  EAttribute getInlineRepresentative_OrgUnit();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.InlineRepresentative#getEmail <em>Email</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Email</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.InlineRepresentative#getEmail()
   * @see #getInlineRepresentative()
   * @generated
   */
  EAttribute getInlineRepresentative_Email();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.InlineRepresentative#getPhone <em>Phone</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Phone</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.InlineRepresentative#getPhone()
   * @see #getInlineRepresentative()
   * @generated
   */
  EAttribute getInlineRepresentative_Phone();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.Responsibility <em>Responsibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Responsibility</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Responsibility
   * @generated
   */
  EClass getResponsibility();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Responsibility#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Responsibility#getDescription()
   * @see #getResponsibility()
   * @generated
   */
  EAttribute getResponsibility_Description();

  /**
   * Returns the meta object for class '{@link org.fornax.soa.sladsl.sLADsl.Report <em>Report</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Report</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Report
   * @generated
   */
  EClass getReport();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Report#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Report#getName()
   * @see #getReport()
   * @generated
   */
  EAttribute getReport_Name();

  /**
   * Returns the meta object for the reference '{@link org.fornax.soa.sladsl.sLADsl.Report#getReportTo <em>Report To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Report To</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Report#getReportTo()
   * @see #getReport()
   * @generated
   */
  EReference getReport_ReportTo();

  /**
   * Returns the meta object for the attribute '{@link org.fornax.soa.sladsl.sLADsl.Report#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.Report#getContent()
   * @see #getReport()
   * @generated
   */
  EAttribute getReport_Content();

  /**
   * Returns the meta object for enum '{@link org.fornax.soa.sladsl.sLADsl.HashAlgKind <em>Hash Alg Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Hash Alg Kind</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.HashAlgKind
   * @generated
   */
  EEnum getHashAlgKind();

  /**
   * Returns the meta object for enum '{@link org.fornax.soa.sladsl.sLADsl.MessagePartRefKind <em>Message Part Ref Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Message Part Ref Kind</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.MessagePartRefKind
   * @generated
   */
  EEnum getMessagePartRefKind();

  /**
   * Returns the meta object for enum '{@link org.fornax.soa.sladsl.sLADsl.SigningAlgothm <em>Signing Algothm</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Signing Algothm</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.SigningAlgothm
   * @generated
   */
  EEnum getSigningAlgothm();

  /**
   * Returns the meta object for enum '{@link org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind <em>Cipher Algorithm Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Cipher Algorithm Kind</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind
   * @generated
   */
  EEnum getCipherAlgorithmKind();

  /**
   * Returns the meta object for enum '{@link org.fornax.soa.sladsl.sLADsl.AuthTokenKind <em>Auth Token Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Auth Token Kind</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.AuthTokenKind
   * @generated
   */
  EEnum getAuthTokenKind();

  /**
   * Returns the meta object for enum '{@link org.fornax.soa.sladsl.sLADsl.LogRequirementKind <em>Log Requirement Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Log Requirement Kind</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.LogRequirementKind
   * @generated
   */
  EEnum getLogRequirementKind();

  /**
   * Returns the meta object for enum '{@link org.fornax.soa.sladsl.sLADsl.ReliablilityKind <em>Reliablility Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Reliablility Kind</em>'.
   * @see org.fornax.soa.sladsl.sLADsl.ReliablilityKind
   * @generated
   */
  EEnum getReliablilityKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SLADslFactory getSLADslFactory();

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
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.SlaModelImpl <em>Sla Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.SlaModelImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getSlaModel()
     * @generated
     */
    EClass SLA_MODEL = eINSTANCE.getSlaModel();

    /**
     * The meta object literal for the '<em><b>Agreements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA_MODEL__AGREEMENTS = eINSTANCE.getSlaModel_Agreements();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl <em>SLA</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLAImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getSLA()
     * @generated
     */
    EClass SLA = eINSTANCE.getSLA();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLA__NAME = eINSTANCE.getSLA_Name();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA__VERSION = eINSTANCE.getSLA_Version();

    /**
     * The meta object literal for the '<em><b>Effective Date</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLA__EFFECTIVE_DATE = eINSTANCE.getSLA_EffectiveDate();

    /**
     * The meta object literal for the '<em><b>Effective Until</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLA__EFFECTIVE_UNTIL = eINSTANCE.getSLA_EffectiveUntil();

    /**
     * The meta object literal for the '<em><b>Parties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA__PARTIES = eINSTANCE.getSLA_Parties();

    /**
     * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLA__SCOPE = eINSTANCE.getSLA_Scope();

    /**
     * The meta object literal for the '<em><b>Preample</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLA__PREAMPLE = eINSTANCE.getSLA_Preample();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLA__DESCRIPTION = eINSTANCE.getSLA_Description();

    /**
     * The meta object literal for the '<em><b>Restrictions</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLA__RESTRICTIONS = eINSTANCE.getSLA_Restrictions();

    /**
     * The meta object literal for the '<em><b>Priorities</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA__PRIORITIES = eINSTANCE.getSLA_Priorities();

    /**
     * The meta object literal for the '<em><b>Applies To</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA__APPLIES_TO = eINSTANCE.getSLA_AppliesTo();

    /**
     * The meta object literal for the '<em><b>Costs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA__COSTS = eINSTANCE.getSLA_Costs();

    /**
     * The meta object literal for the '<em><b>Service Quality Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA__SERVICE_QUALITY_PROPERTIES = eINSTANCE.getSLA_ServiceQualityProperties();

    /**
     * The meta object literal for the '<em><b>Data Sec Prot Clause</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLA__DATA_SEC_PROT_CLAUSE = eINSTANCE.getSLA_DataSecProtClause();

    /**
     * The meta object literal for the '<em><b>Security Requirements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA__SECURITY_REQUIREMENTS = eINSTANCE.getSLA_SecurityRequirements();

    /**
     * The meta object literal for the '<em><b>Additional Services</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLA__ADDITIONAL_SERVICES = eINSTANCE.getSLA_AdditionalServices();

    /**
     * The meta object literal for the '<em><b>Escalation Procedure</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA__ESCALATION_PROCEDURE = eINSTANCE.getSLA_EscalationProcedure();

    /**
     * The meta object literal for the '<em><b>Cancellation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLA__CANCELLATION = eINSTANCE.getSLA_Cancellation();

    /**
     * The meta object literal for the '<em><b>Extraordinary Cancellation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLA__EXTRAORDINARY_CANCELLATION = eINSTANCE.getSLA_ExtraordinaryCancellation();

    /**
     * The meta object literal for the '<em><b>Reports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA__REPORTS = eINSTANCE.getSLA_Reports();

    /**
     * The meta object literal for the '<em><b>Subscriptions</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA__SUBSCRIPTIONS = eINSTANCE.getSLA_Subscriptions();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLA__TAGS = eINSTANCE.getSLA_Tags();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.CostImpl <em>Cost</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.CostImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getCost()
     * @generated
     */
    EClass COST = eINSTANCE.getCost();

    /**
     * The meta object literal for the '<em><b>Costs Amount</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COST__COSTS_AMOUNT = eINSTANCE.getCost_CostsAmount();

    /**
     * The meta object literal for the '<em><b>Billed Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COST__BILLED_UNIT = eINSTANCE.getCost_BilledUnit();

    /**
     * The meta object literal for the '<em><b>Effort Accounting</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COST__EFFORT_ACCOUNTING = eINSTANCE.getCost_EffortAccounting();

    /**
     * The meta object literal for the '<em><b>Escalation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COST__ESCALATION = eINSTANCE.getCost_Escalation();

    /**
     * The meta object literal for the '<em><b>Penalty</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COST__PENALTY = eINSTANCE.getCost_Penalty();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ServiceQualityPropertyImpl <em>Service Quality Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.ServiceQualityPropertyImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getServiceQualityProperty()
     * @generated
     */
    EClass SERVICE_QUALITY_PROPERTY = eINSTANCE.getServiceQualityProperty();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.AvailabilityImpl <em>Availability</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.AvailabilityImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getAvailability()
     * @generated
     */
    EClass AVAILABILITY = eINSTANCE.getAvailability();

    /**
     * The meta object literal for the '<em><b>Availability</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AVAILABILITY__AVAILABILITY = eINSTANCE.getAvailability_Availability();

    /**
     * The meta object literal for the '<em><b>Mtbf</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AVAILABILITY__MTBF = eINSTANCE.getAvailability_Mtbf();

    /**
     * The meta object literal for the '<em><b>Mttr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AVAILABILITY__MTTR = eINSTANCE.getAvailability_Mttr();

    /**
     * The meta object literal for the '<em><b>Mttr Percentile</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AVAILABILITY__MTTR_PERCENTILE = eINSTANCE.getAvailability_MttrPercentile();

    /**
     * The meta object literal for the '<em><b>Regular Down Times</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AVAILABILITY__REGULAR_DOWN_TIMES = eINSTANCE.getAvailability_RegularDownTimes();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ThroughputImpl <em>Throughput</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.ThroughputImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getThroughput()
     * @generated
     */
    EClass THROUGHPUT = eINSTANCE.getThroughput();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THROUGHPUT__DEFINITION = eINSTANCE.getThroughput_Definition();

    /**
     * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THROUGHPUT__SCORE = eINSTANCE.getThroughput_Score();

    /**
     * The meta object literal for the '<em><b>Escalation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THROUGHPUT__ESCALATION = eINSTANCE.getThroughput_Escalation();

    /**
     * The meta object literal for the '<em><b>Penalty</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THROUGHPUT__PENALTY = eINSTANCE.getThroughput_Penalty();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.LatencyImpl <em>Latency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.LatencyImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getLatency()
     * @generated
     */
    EClass LATENCY = eINSTANCE.getLatency();

    /**
     * The meta object literal for the '<em><b>Latency</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LATENCY__LATENCY = eINSTANCE.getLatency_Latency();

    /**
     * The meta object literal for the '<em><b>Percentile</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LATENCY__PERCENTILE = eINSTANCE.getLatency_Percentile();

    /**
     * The meta object literal for the '<em><b>Escalation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LATENCY__ESCALATION = eINSTANCE.getLatency_Escalation();

    /**
     * The meta object literal for the '<em><b>Penalty</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LATENCY__PENALTY = eINSTANCE.getLatency_Penalty();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.MaxDownTimeImpl <em>Max Down Time</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.MaxDownTimeImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getMaxDownTime()
     * @generated
     */
    EClass MAX_DOWN_TIME = eINSTANCE.getMaxDownTime();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAX_DOWN_TIME__DEFINITION = eINSTANCE.getMaxDownTime_Definition();

    /**
     * The meta object literal for the '<em><b>Escalation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAX_DOWN_TIME__ESCALATION = eINSTANCE.getMaxDownTime_Escalation();

    /**
     * The meta object literal for the '<em><b>Penalty</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAX_DOWN_TIME__PENALTY = eINSTANCE.getMaxDownTime_Penalty();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.CapacityRequirementImpl <em>Capacity Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.CapacityRequirementImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getCapacityRequirement()
     * @generated
     */
    EClass CAPACITY_REQUIREMENT = eINSTANCE.getCapacityRequirement();

    /**
     * The meta object literal for the '<em><b>Request Num</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CAPACITY_REQUIREMENT__REQUEST_NUM = eINSTANCE.getCapacityRequirement_RequestNum();

    /**
     * The meta object literal for the '<em><b>Time Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CAPACITY_REQUIREMENT__TIME_UNIT = eINSTANCE.getCapacityRequirement_TimeUnit();

    /**
     * The meta object literal for the '<em><b>Message Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CAPACITY_REQUIREMENT__MESSAGE_SIZE = eINSTANCE.getCapacityRequirement_MessageSize();

    /**
     * The meta object literal for the '<em><b>Escalation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPACITY_REQUIREMENT__ESCALATION = eINSTANCE.getCapacityRequirement_Escalation();

    /**
     * The meta object literal for the '<em><b>Penalty</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CAPACITY_REQUIREMENT__PENALTY = eINSTANCE.getCapacityRequirement_Penalty();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ReliablityRequirementImpl <em>Reliablity Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.ReliablityRequirementImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getReliablityRequirement()
     * @generated
     */
    EClass RELIABLITY_REQUIREMENT = eINSTANCE.getReliablityRequirement();

    /**
     * The meta object literal for the '<em><b>Reliability</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELIABLITY_REQUIREMENT__RELIABILITY = eINSTANCE.getReliablityRequirement_Reliability();

    /**
     * The meta object literal for the '<em><b>In Order Delivery</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELIABLITY_REQUIREMENT__IN_ORDER_DELIVERY = eINSTANCE.getReliablityRequirement_InOrderDelivery();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.AccuracyRequirementImpl <em>Accuracy Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.AccuracyRequirementImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getAccuracyRequirement()
     * @generated
     */
    EClass ACCURACY_REQUIREMENT = eINSTANCE.getAccuracyRequirement();

    /**
     * The meta object literal for the '<em><b>Max Error Rate</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACCURACY_REQUIREMENT__MAX_ERROR_RATE = eINSTANCE.getAccuracyRequirement_MaxErrorRate();

    /**
     * The meta object literal for the '<em><b>Escalation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACCURACY_REQUIREMENT__ESCALATION = eINSTANCE.getAccuracyRequirement_Escalation();

    /**
     * The meta object literal for the '<em><b>Penalty</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACCURACY_REQUIREMENT__PENALTY = eINSTANCE.getAccuracyRequirement_Penalty();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.LogRequirementImpl <em>Log Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.LogRequirementImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getLogRequirement()
     * @generated
     */
    EClass LOG_REQUIREMENT = eINSTANCE.getLogRequirement();

    /**
     * The meta object literal for the '<em><b>Log Level</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOG_REQUIREMENT__LOG_LEVEL = eINSTANCE.getLogRequirement_LogLevel();

    /**
     * The meta object literal for the '<em><b>Additional Logging Requirement</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOG_REQUIREMENT__ADDITIONAL_LOGGING_REQUIREMENT = eINSTANCE.getLogRequirement_AdditionalLoggingRequirement();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.PercentileImpl <em>Percentile</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.PercentileImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getPercentile()
     * @generated
     */
    EClass PERCENTILE = eINSTANCE.getPercentile();

    /**
     * The meta object literal for the '<em><b>Percentile</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PERCENTILE__PERCENTILE = eINSTANCE.getPercentile_Percentile();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.SecurityRequirementImpl <em>Security Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.SecurityRequirementImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getSecurityRequirement()
     * @generated
     */
    EClass SECURITY_REQUIREMENT = eINSTANCE.getSecurityRequirement();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.AuthenticationRequirementImpl <em>Authentication Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.AuthenticationRequirementImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getAuthenticationRequirement()
     * @generated
     */
    EClass AUTHENTICATION_REQUIREMENT = eINSTANCE.getAuthenticationRequirement();

    /**
     * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUTHENTICATION_REQUIREMENT__OPTIONAL = eINSTANCE.getAuthenticationRequirement_Optional();

    /**
     * The meta object literal for the '<em><b>Auth Tokens</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUTHENTICATION_REQUIREMENT__AUTH_TOKENS = eINSTANCE.getAuthenticationRequirement_AuthTokens();

    /**
     * The meta object literal for the '<em><b>Hash Algorithms</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUTHENTICATION_REQUIREMENT__HASH_ALGORITHMS = eINSTANCE.getAuthenticationRequirement_HashAlgorithms();

    /**
     * The meta object literal for the '<em><b>Use Nonce</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUTHENTICATION_REQUIREMENT__USE_NONCE = eINSTANCE.getAuthenticationRequirement_UseNonce();

    /**
     * The meta object literal for the '<em><b>Issuer</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUTHENTICATION_REQUIREMENT__ISSUER = eINSTANCE.getAuthenticationRequirement_Issuer();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.AuthTokenImpl <em>Auth Token</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.AuthTokenImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getAuthToken()
     * @generated
     */
    EClass AUTH_TOKEN = eINSTANCE.getAuthToken();

    /**
     * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUTH_TOKEN__OPTIONAL = eINSTANCE.getAuthToken_Optional();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUTH_TOKEN__KIND = eINSTANCE.getAuthToken_Kind();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.HashAlgorithmImpl <em>Hash Algorithm</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.HashAlgorithmImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getHashAlgorithm()
     * @generated
     */
    EClass HASH_ALGORITHM = eINSTANCE.getHashAlgorithm();

    /**
     * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HASH_ALGORITHM__OPTIONAL = eINSTANCE.getHashAlgorithm_Optional();

    /**
     * The meta object literal for the '<em><b>Use Base64</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HASH_ALGORITHM__USE_BASE64 = eINSTANCE.getHashAlgorithm_UseBase64();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HASH_ALGORITHM__KIND = eINSTANCE.getHashAlgorithm_Kind();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.SigningRequirementImpl <em>Signing Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.SigningRequirementImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getSigningRequirement()
     * @generated
     */
    EClass SIGNING_REQUIREMENT = eINSTANCE.getSigningRequirement();

    /**
     * The meta object literal for the '<em><b>Supported Signing Algorithms</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIGNING_REQUIREMENT__SUPPORTED_SIGNING_ALGORITHMS = eINSTANCE.getSigningRequirement_SupportedSigningAlgorithms();

    /**
     * The meta object literal for the '<em><b>Required Signing Algorithm</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIGNING_REQUIREMENT__REQUIRED_SIGNING_ALGORITHM = eINSTANCE.getSigningRequirement_RequiredSigningAlgorithm();

    /**
     * The meta object literal for the '<em><b>Signed Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIGNING_REQUIREMENT__SIGNED_PARTS = eINSTANCE.getSigningRequirement_SignedParts();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.MessagePartRefImpl <em>Message Part Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.MessagePartRefImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getMessagePartRef()
     * @generated
     */
    EClass MESSAGE_PART_REF = eINSTANCE.getMessagePartRef();

    /**
     * The meta object literal for the '<em><b>Message Part Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MESSAGE_PART_REF__MESSAGE_PART_REF = eINSTANCE.getMessagePartRef_MessagePartRef();

    /**
     * The meta object literal for the '<em><b>Part Ref Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MESSAGE_PART_REF__PART_REF_EXPRESSION = eINSTANCE.getMessagePartRef_PartRefExpression();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.EncryptionRequirementImpl <em>Encryption Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.EncryptionRequirementImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getEncryptionRequirement()
     * @generated
     */
    EClass ENCRYPTION_REQUIREMENT = eINSTANCE.getEncryptionRequirement();

    /**
     * The meta object literal for the '<em><b>Supported Cipher Algorithms</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENCRYPTION_REQUIREMENT__SUPPORTED_CIPHER_ALGORITHMS = eINSTANCE.getEncryptionRequirement_SupportedCipherAlgorithms();

    /**
     * The meta object literal for the '<em><b>Required Cipher Algorithm</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENCRYPTION_REQUIREMENT__REQUIRED_CIPHER_ALGORITHM = eINSTANCE.getEncryptionRequirement_RequiredCipherAlgorithm();

    /**
     * The meta object literal for the '<em><b>Encrypted Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENCRYPTION_REQUIREMENT__ENCRYPTED_PARTS = eINSTANCE.getEncryptionRequirement_EncryptedParts();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.PriorityDeclarationImpl <em>Priority Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.PriorityDeclarationImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getPriorityDeclaration()
     * @generated
     */
    EClass PRIORITY_DECLARATION = eINSTANCE.getPriorityDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIORITY_DECLARATION__NAME = eINSTANCE.getPriorityDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIORITY_DECLARATION__DESCRIPTION = eINSTANCE.getPriorityDeclaration_Description();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.EscalationImpl <em>Escalation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.EscalationImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getEscalation()
     * @generated
     */
    EClass ESCALATION = eINSTANCE.getEscalation();

    /**
     * The meta object literal for the '<em><b>Cause</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ESCALATION__CAUSE = eINSTANCE.getEscalation_Cause();

    /**
     * The meta object literal for the '<em><b>Escalation Targets</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ESCALATION__ESCALATION_TARGETS = eINSTANCE.getEscalation_EscalationTargets();

    /**
     * The meta object literal for the '<em><b>Procedure</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ESCALATION__PROCEDURE = eINSTANCE.getEscalation_Procedure();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.PartyImpl <em>Party</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.PartyImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getParty()
     * @generated
     */
    EClass PARTY = eINSTANCE.getParty();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARTY__NAME = eINSTANCE.getParty_Name();

    /**
     * The meta object literal for the '<em><b>Representatives</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARTY__REPRESENTATIVES = eINSTANCE.getParty_Representatives();

    /**
     * The meta object literal for the '<em><b>Responsibilities</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARTY__RESPONSIBILITIES = eINSTANCE.getParty_Responsibilities();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.CustomerPartyImpl <em>Customer Party</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.CustomerPartyImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getCustomerParty()
     * @generated
     */
    EClass CUSTOMER_PARTY = eINSTANCE.getCustomerParty();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ProviderPartyImpl <em>Provider Party</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.ProviderPartyImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getProviderParty()
     * @generated
     */
    EClass PROVIDER_PARTY = eINSTANCE.getProviderParty();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ThirdPartyImpl <em>Third Party</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.ThirdPartyImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getThirdParty()
     * @generated
     */
    EClass THIRD_PARTY = eINSTANCE.getThirdParty();

    /**
     * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THIRD_PARTY__ROLE = eINSTANCE.getThirdParty_Role();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.RepresentativeImpl <em>Representative</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.RepresentativeImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getRepresentative()
     * @generated
     */
    EClass REPRESENTATIVE = eINSTANCE.getRepresentative();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.UserRefImpl <em>User Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.UserRefImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getUserRef()
     * @generated
     */
    EClass USER_REF = eINSTANCE.getUserRef();

    /**
     * The meta object literal for the '<em><b>Representative</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USER_REF__REPRESENTATIVE = eINSTANCE.getUserRef_Representative();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.InlineRepresentativeImpl <em>Inline Representative</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.InlineRepresentativeImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getInlineRepresentative()
     * @generated
     */
    EClass INLINE_REPRESENTATIVE = eINSTANCE.getInlineRepresentative();

    /**
     * The meta object literal for the '<em><b>Firstname</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INLINE_REPRESENTATIVE__FIRSTNAME = eINSTANCE.getInlineRepresentative_Firstname();

    /**
     * The meta object literal for the '<em><b>Lastname</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INLINE_REPRESENTATIVE__LASTNAME = eINSTANCE.getInlineRepresentative_Lastname();

    /**
     * The meta object literal for the '<em><b>Org Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INLINE_REPRESENTATIVE__ORG_UNIT = eINSTANCE.getInlineRepresentative_OrgUnit();

    /**
     * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INLINE_REPRESENTATIVE__EMAIL = eINSTANCE.getInlineRepresentative_Email();

    /**
     * The meta object literal for the '<em><b>Phone</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INLINE_REPRESENTATIVE__PHONE = eINSTANCE.getInlineRepresentative_Phone();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ResponsibilityImpl <em>Responsibility</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.ResponsibilityImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getResponsibility()
     * @generated
     */
    EClass RESPONSIBILITY = eINSTANCE.getResponsibility();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESPONSIBILITY__DESCRIPTION = eINSTANCE.getResponsibility_Description();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.impl.ReportImpl <em>Report</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.impl.ReportImpl
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getReport()
     * @generated
     */
    EClass REPORT = eINSTANCE.getReport();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REPORT__NAME = eINSTANCE.getReport_Name();

    /**
     * The meta object literal for the '<em><b>Report To</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REPORT__REPORT_TO = eINSTANCE.getReport_ReportTo();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REPORT__CONTENT = eINSTANCE.getReport_Content();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.HashAlgKind <em>Hash Alg Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.HashAlgKind
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getHashAlgKind()
     * @generated
     */
    EEnum HASH_ALG_KIND = eINSTANCE.getHashAlgKind();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.MessagePartRefKind <em>Message Part Ref Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.MessagePartRefKind
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getMessagePartRefKind()
     * @generated
     */
    EEnum MESSAGE_PART_REF_KIND = eINSTANCE.getMessagePartRefKind();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.SigningAlgothm <em>Signing Algothm</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.SigningAlgothm
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getSigningAlgothm()
     * @generated
     */
    EEnum SIGNING_ALGOTHM = eINSTANCE.getSigningAlgothm();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind <em>Cipher Algorithm Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getCipherAlgorithmKind()
     * @generated
     */
    EEnum CIPHER_ALGORITHM_KIND = eINSTANCE.getCipherAlgorithmKind();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.AuthTokenKind <em>Auth Token Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.AuthTokenKind
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getAuthTokenKind()
     * @generated
     */
    EEnum AUTH_TOKEN_KIND = eINSTANCE.getAuthTokenKind();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.LogRequirementKind <em>Log Requirement Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.LogRequirementKind
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getLogRequirementKind()
     * @generated
     */
    EEnum LOG_REQUIREMENT_KIND = eINSTANCE.getLogRequirementKind();

    /**
     * The meta object literal for the '{@link org.fornax.soa.sladsl.sLADsl.ReliablilityKind <em>Reliablility Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.fornax.soa.sladsl.sLADsl.ReliablilityKind
     * @see org.fornax.soa.sladsl.sLADsl.impl.SLADslPackageImpl#getReliablilityKind()
     * @generated
     */
    EEnum RELIABLILITY_KIND = eINSTANCE.getReliablilityKind();

  }

} //SLADslPackage
