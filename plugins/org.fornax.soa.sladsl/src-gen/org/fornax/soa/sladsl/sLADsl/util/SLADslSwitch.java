/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.fornax.soa.sladsl.sLADsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage
 * @generated
 */
public class SLADslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SLADslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SLADslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = SLADslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case SLADslPackage.SLA_MODEL:
      {
        SlaModel slaModel = (SlaModel)theEObject;
        T result = caseSlaModel(slaModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.SLA:
      {
        SLA sla = (SLA)theEObject;
        T result = caseSLA(sla);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.ASSET_REF:
      {
        AssetRef assetRef = (AssetRef)theEObject;
        T result = caseAssetRef(assetRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.COST:
      {
        Cost cost = (Cost)theEObject;
        T result = caseCost(cost);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.SERVICE_QUALITY_PROPERTY:
      {
        ServiceQualityProperty serviceQualityProperty = (ServiceQualityProperty)theEObject;
        T result = caseServiceQualityProperty(serviceQualityProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.AVAILABILITY:
      {
        Availability availability = (Availability)theEObject;
        T result = caseAvailability(availability);
        if (result == null) result = caseServiceQualityProperty(availability);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.THROUGHPUT:
      {
        Throughput throughput = (Throughput)theEObject;
        T result = caseThroughput(throughput);
        if (result == null) result = caseServiceQualityProperty(throughput);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.LATENCY:
      {
        Latency latency = (Latency)theEObject;
        T result = caseLatency(latency);
        if (result == null) result = caseServiceQualityProperty(latency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.MAX_DOWN_TIME:
      {
        MaxDownTime maxDownTime = (MaxDownTime)theEObject;
        T result = caseMaxDownTime(maxDownTime);
        if (result == null) result = caseServiceQualityProperty(maxDownTime);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.CAPACITY_REQUIREMENT:
      {
        CapacityRequirement capacityRequirement = (CapacityRequirement)theEObject;
        T result = caseCapacityRequirement(capacityRequirement);
        if (result == null) result = caseServiceQualityProperty(capacityRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.RELIABLITY_REQUIREMENT:
      {
        ReliablityRequirement reliablityRequirement = (ReliablityRequirement)theEObject;
        T result = caseReliablityRequirement(reliablityRequirement);
        if (result == null) result = caseServiceQualityProperty(reliablityRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.ACCURACY_REQUIREMENT:
      {
        AccuracyRequirement accuracyRequirement = (AccuracyRequirement)theEObject;
        T result = caseAccuracyRequirement(accuracyRequirement);
        if (result == null) result = caseServiceQualityProperty(accuracyRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.LOG_REQUIREMENT:
      {
        LogRequirement logRequirement = (LogRequirement)theEObject;
        T result = caseLogRequirement(logRequirement);
        if (result == null) result = caseServiceQualityProperty(logRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.PERCENTILE:
      {
        Percentile percentile = (Percentile)theEObject;
        T result = casePercentile(percentile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.SECURITY_REQUIREMENT:
      {
        SecurityRequirement securityRequirement = (SecurityRequirement)theEObject;
        T result = caseSecurityRequirement(securityRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.AUTHENTICATION_REQUIREMENT:
      {
        AuthenticationRequirement authenticationRequirement = (AuthenticationRequirement)theEObject;
        T result = caseAuthenticationRequirement(authenticationRequirement);
        if (result == null) result = caseSecurityRequirement(authenticationRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.AUTH_TOKEN:
      {
        AuthToken authToken = (AuthToken)theEObject;
        T result = caseAuthToken(authToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.HASH_ALGORITHM:
      {
        HashAlgorithm hashAlgorithm = (HashAlgorithm)theEObject;
        T result = caseHashAlgorithm(hashAlgorithm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.SIGNING_REQUIREMENT:
      {
        SigningRequirement signingRequirement = (SigningRequirement)theEObject;
        T result = caseSigningRequirement(signingRequirement);
        if (result == null) result = caseSecurityRequirement(signingRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.MESSAGE_PART_REF:
      {
        MessagePartRef messagePartRef = (MessagePartRef)theEObject;
        T result = caseMessagePartRef(messagePartRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.ENCRYPTION_REQUIREMENT:
      {
        EncryptionRequirement encryptionRequirement = (EncryptionRequirement)theEObject;
        T result = caseEncryptionRequirement(encryptionRequirement);
        if (result == null) result = caseSecurityRequirement(encryptionRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.PRIORITY_DECLARATION:
      {
        PriorityDeclaration priorityDeclaration = (PriorityDeclaration)theEObject;
        T result = casePriorityDeclaration(priorityDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.ESCALATION:
      {
        Escalation escalation = (Escalation)theEObject;
        T result = caseEscalation(escalation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.PARTY:
      {
        Party party = (Party)theEObject;
        T result = caseParty(party);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.CUSTOMER_PARTY:
      {
        CustomerParty customerParty = (CustomerParty)theEObject;
        T result = caseCustomerParty(customerParty);
        if (result == null) result = caseParty(customerParty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.PROVIDER_PARTY:
      {
        ProviderParty providerParty = (ProviderParty)theEObject;
        T result = caseProviderParty(providerParty);
        if (result == null) result = caseParty(providerParty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.THIRD_PARTY:
      {
        ThirdParty thirdParty = (ThirdParty)theEObject;
        T result = caseThirdParty(thirdParty);
        if (result == null) result = caseParty(thirdParty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.REPESENTATIVE:
      {
        Repesentative repesentative = (Repesentative)theEObject;
        T result = caseRepesentative(repesentative);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.RESPONSIBILITY:
      {
        Responsibility responsibility = (Responsibility)theEObject;
        T result = caseResponsibility(responsibility);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.SIMPLE_RESPONSIBILITY:
      {
        SimpleResponsibility simpleResponsibility = (SimpleResponsibility)theEObject;
        T result = caseSimpleResponsibility(simpleResponsibility);
        if (result == null) result = caseResponsibility(simpleResponsibility);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.REPORT:
      {
        Report report = (Report)theEObject;
        T result = caseReport(report);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SLADslPackage.REPORTING_RESPONSIBILITY:
      {
        ReportingResponsibility reportingResponsibility = (ReportingResponsibility)theEObject;
        T result = caseReportingResponsibility(reportingResponsibility);
        if (result == null) result = caseResponsibility(reportingResponsibility);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sla Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sla Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSlaModel(SlaModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SLA</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SLA</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSLA(SLA object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Asset Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Asset Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssetRef(AssetRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cost</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cost</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCost(Cost object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Service Quality Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Service Quality Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServiceQualityProperty(ServiceQualityProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Availability</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Availability</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAvailability(Availability object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Throughput</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Throughput</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThroughput(Throughput object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Latency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Latency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLatency(Latency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Max Down Time</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Max Down Time</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMaxDownTime(MaxDownTime object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Capacity Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Capacity Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCapacityRequirement(CapacityRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reliablity Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reliablity Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReliablityRequirement(ReliablityRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Accuracy Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Accuracy Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAccuracyRequirement(AccuracyRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Log Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Log Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogRequirement(LogRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Percentile</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Percentile</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePercentile(Percentile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Security Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Security Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSecurityRequirement(SecurityRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Authentication Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Authentication Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAuthenticationRequirement(AuthenticationRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Auth Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Auth Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAuthToken(AuthToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Hash Algorithm</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Hash Algorithm</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHashAlgorithm(HashAlgorithm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Signing Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Signing Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSigningRequirement(SigningRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Message Part Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message Part Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessagePartRef(MessagePartRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Encryption Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Encryption Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEncryptionRequirement(EncryptionRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Priority Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Priority Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePriorityDeclaration(PriorityDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Escalation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Escalation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEscalation(Escalation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Party</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Party</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParty(Party object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Customer Party</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Customer Party</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCustomerParty(CustomerParty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Provider Party</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Provider Party</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProviderParty(ProviderParty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Third Party</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Third Party</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThirdParty(ThirdParty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Repesentative</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Repesentative</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRepesentative(Repesentative object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Responsibility</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Responsibility</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResponsibility(Responsibility object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Responsibility</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Responsibility</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleResponsibility(SimpleResponsibility object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Report</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Report</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReport(Report object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reporting Responsibility</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reporting Responsibility</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReportingResponsibility(ReportingResponsibility object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //SLADslSwitch
