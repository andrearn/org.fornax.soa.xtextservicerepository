/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage
 * @generated
 */
public interface SLADslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SLADslFactory eINSTANCE = org.fornax.soa.sladsl.sLADsl.impl.SLADslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Sla Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sla Model</em>'.
   * @generated
   */
  SlaModel createSlaModel();

  /**
   * Returns a new object of class '<em>SLA</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SLA</em>'.
   * @generated
   */
  SLA createSLA();

  /**
   * Returns a new object of class '<em>Cost</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cost</em>'.
   * @generated
   */
  Cost createCost();

  /**
   * Returns a new object of class '<em>Service Quality Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Service Quality Property</em>'.
   * @generated
   */
  ServiceQualityProperty createServiceQualityProperty();

  /**
   * Returns a new object of class '<em>Availability</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Availability</em>'.
   * @generated
   */
  Availability createAvailability();

  /**
   * Returns a new object of class '<em>Throughput</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Throughput</em>'.
   * @generated
   */
  Throughput createThroughput();

  /**
   * Returns a new object of class '<em>Latency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Latency</em>'.
   * @generated
   */
  Latency createLatency();

  /**
   * Returns a new object of class '<em>Max Down Time</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Max Down Time</em>'.
   * @generated
   */
  MaxDownTime createMaxDownTime();

  /**
   * Returns a new object of class '<em>Capacity Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Capacity Requirement</em>'.
   * @generated
   */
  CapacityRequirement createCapacityRequirement();

  /**
   * Returns a new object of class '<em>Reliablity Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reliablity Requirement</em>'.
   * @generated
   */
  ReliablityRequirement createReliablityRequirement();

  /**
   * Returns a new object of class '<em>Accuracy Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Accuracy Requirement</em>'.
   * @generated
   */
  AccuracyRequirement createAccuracyRequirement();

  /**
   * Returns a new object of class '<em>Log Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Log Requirement</em>'.
   * @generated
   */
  LogRequirement createLogRequirement();

  /**
   * Returns a new object of class '<em>Percentile</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Percentile</em>'.
   * @generated
   */
  Percentile createPercentile();

  /**
   * Returns a new object of class '<em>Security Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Security Requirement</em>'.
   * @generated
   */
  SecurityRequirement createSecurityRequirement();

  /**
   * Returns a new object of class '<em>Authentication Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Authentication Requirement</em>'.
   * @generated
   */
  AuthenticationRequirement createAuthenticationRequirement();

  /**
   * Returns a new object of class '<em>Auth Token</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Auth Token</em>'.
   * @generated
   */
  AuthToken createAuthToken();

  /**
   * Returns a new object of class '<em>Hash Algorithm</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hash Algorithm</em>'.
   * @generated
   */
  HashAlgorithm createHashAlgorithm();

  /**
   * Returns a new object of class '<em>Signing Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Signing Requirement</em>'.
   * @generated
   */
  SigningRequirement createSigningRequirement();

  /**
   * Returns a new object of class '<em>Message Part Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Part Ref</em>'.
   * @generated
   */
  MessagePartRef createMessagePartRef();

  /**
   * Returns a new object of class '<em>Encryption Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Encryption Requirement</em>'.
   * @generated
   */
  EncryptionRequirement createEncryptionRequirement();

  /**
   * Returns a new object of class '<em>Priority Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Priority Declaration</em>'.
   * @generated
   */
  PriorityDeclaration createPriorityDeclaration();

  /**
   * Returns a new object of class '<em>Escalation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Escalation</em>'.
   * @generated
   */
  Escalation createEscalation();

  /**
   * Returns a new object of class '<em>Party</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Party</em>'.
   * @generated
   */
  Party createParty();

  /**
   * Returns a new object of class '<em>Customer Party</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Customer Party</em>'.
   * @generated
   */
  CustomerParty createCustomerParty();

  /**
   * Returns a new object of class '<em>Provider Party</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Provider Party</em>'.
   * @generated
   */
  ProviderParty createProviderParty();

  /**
   * Returns a new object of class '<em>Third Party</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Third Party</em>'.
   * @generated
   */
  ThirdParty createThirdParty();

  /**
   * Returns a new object of class '<em>Repesentative</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Repesentative</em>'.
   * @generated
   */
  Repesentative createRepesentative();

  /**
   * Returns a new object of class '<em>Responsibility</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Responsibility</em>'.
   * @generated
   */
  Responsibility createResponsibility();

  /**
   * Returns a new object of class '<em>Simple Responsibility</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Responsibility</em>'.
   * @generated
   */
  SimpleResponsibility createSimpleResponsibility();

  /**
   * Returns a new object of class '<em>Report</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Report</em>'.
   * @generated
   */
  Report createReport();

  /**
   * Returns a new object of class '<em>Reporting Responsibility</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reporting Responsibility</em>'.
   * @generated
   */
  ReportingResponsibility createReportingResponsibility();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SLADslPackage getSLADslPackage();

} //SLADslFactory
