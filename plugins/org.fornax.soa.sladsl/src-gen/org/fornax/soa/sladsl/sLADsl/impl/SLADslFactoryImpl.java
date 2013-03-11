/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.fornax.soa.sladsl.sLADsl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SLADslFactoryImpl extends EFactoryImpl implements SLADslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SLADslFactory init()
  {
    try
    {
      SLADslFactory theSLADslFactory = (SLADslFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.fornax.org/soa/sladsl/SLADsl"); 
      if (theSLADslFactory != null)
      {
        return theSLADslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SLADslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SLADslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SLADslPackage.SLA_MODEL: return createSlaModel();
      case SLADslPackage.SLA: return createSLA();
      case SLADslPackage.ASSET_REF: return createAssetRef();
      case SLADslPackage.COST: return createCost();
      case SLADslPackage.SERVICE_QUALITY_PROPERTY: return createServiceQualityProperty();
      case SLADslPackage.AVAILABILITY: return createAvailability();
      case SLADslPackage.THROUGHPUT: return createThroughput();
      case SLADslPackage.LATENCY: return createLatency();
      case SLADslPackage.MAX_DOWN_TIME: return createMaxDownTime();
      case SLADslPackage.CAPACITY_REQUIREMENT: return createCapacityRequirement();
      case SLADslPackage.RELIABLITY_REQUIREMENT: return createReliablityRequirement();
      case SLADslPackage.ACCURACY_REQUIREMENT: return createAccuracyRequirement();
      case SLADslPackage.LOG_REQUIREMENT: return createLogRequirement();
      case SLADslPackage.PERCENTILE: return createPercentile();
      case SLADslPackage.SECURITY_REQUIREMENT: return createSecurityRequirement();
      case SLADslPackage.AUTHENTICATION_REQUIREMENT: return createAuthenticationRequirement();
      case SLADslPackage.AUTH_TOKEN: return createAuthToken();
      case SLADslPackage.HASH_ALGORITHM: return createHashAlgorithm();
      case SLADslPackage.SIGNING_REQUIREMENT: return createSigningRequirement();
      case SLADslPackage.MESSAGE_PART_REF: return createMessagePartRef();
      case SLADslPackage.ENCRYPTION_REQUIREMENT: return createEncryptionRequirement();
      case SLADslPackage.PRIORITY_DECLARATION: return createPriorityDeclaration();
      case SLADslPackage.ESCALATION: return createEscalation();
      case SLADslPackage.PARTY: return createParty();
      case SLADslPackage.CUSTOMER_PARTY: return createCustomerParty();
      case SLADslPackage.PROVIDER_PARTY: return createProviderParty();
      case SLADslPackage.THIRD_PARTY: return createThirdParty();
      case SLADslPackage.REPESENTATIVE: return createRepesentative();
      case SLADslPackage.RESPONSIBILITY: return createResponsibility();
      case SLADslPackage.SIMPLE_RESPONSIBILITY: return createSimpleResponsibility();
      case SLADslPackage.REPORT: return createReport();
      case SLADslPackage.REPORTING_RESPONSIBILITY: return createReportingResponsibility();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case SLADslPackage.HASH_ALG_KIND:
        return createHashAlgKindFromString(eDataType, initialValue);
      case SLADslPackage.MESSAGE_PART_REF_KIND:
        return createMessagePartRefKindFromString(eDataType, initialValue);
      case SLADslPackage.SIGNING_ALGOTHM:
        return createSigningAlgothmFromString(eDataType, initialValue);
      case SLADslPackage.CIPHER_ALGORITHM_KIND:
        return createCipherAlgorithmKindFromString(eDataType, initialValue);
      case SLADslPackage.AUTH_TOKEN_KIND:
        return createAuthTokenKindFromString(eDataType, initialValue);
      case SLADslPackage.LOG_REQUIREMENT_KIND:
        return createLogRequirementKindFromString(eDataType, initialValue);
      case SLADslPackage.RELIABLILITY_KIND:
        return createReliablilityKindFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case SLADslPackage.HASH_ALG_KIND:
        return convertHashAlgKindToString(eDataType, instanceValue);
      case SLADslPackage.MESSAGE_PART_REF_KIND:
        return convertMessagePartRefKindToString(eDataType, instanceValue);
      case SLADslPackage.SIGNING_ALGOTHM:
        return convertSigningAlgothmToString(eDataType, instanceValue);
      case SLADslPackage.CIPHER_ALGORITHM_KIND:
        return convertCipherAlgorithmKindToString(eDataType, instanceValue);
      case SLADslPackage.AUTH_TOKEN_KIND:
        return convertAuthTokenKindToString(eDataType, instanceValue);
      case SLADslPackage.LOG_REQUIREMENT_KIND:
        return convertLogRequirementKindToString(eDataType, instanceValue);
      case SLADslPackage.RELIABLILITY_KIND:
        return convertReliablilityKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SlaModel createSlaModel()
  {
    SlaModelImpl slaModel = new SlaModelImpl();
    return slaModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SLA createSLA()
  {
    SLAImpl sla = new SLAImpl();
    return sla;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssetRef createAssetRef()
  {
    AssetRefImpl assetRef = new AssetRefImpl();
    return assetRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cost createCost()
  {
    CostImpl cost = new CostImpl();
    return cost;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceQualityProperty createServiceQualityProperty()
  {
    ServiceQualityPropertyImpl serviceQualityProperty = new ServiceQualityPropertyImpl();
    return serviceQualityProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Availability createAvailability()
  {
    AvailabilityImpl availability = new AvailabilityImpl();
    return availability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Throughput createThroughput()
  {
    ThroughputImpl throughput = new ThroughputImpl();
    return throughput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Latency createLatency()
  {
    LatencyImpl latency = new LatencyImpl();
    return latency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MaxDownTime createMaxDownTime()
  {
    MaxDownTimeImpl maxDownTime = new MaxDownTimeImpl();
    return maxDownTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CapacityRequirement createCapacityRequirement()
  {
    CapacityRequirementImpl capacityRequirement = new CapacityRequirementImpl();
    return capacityRequirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReliablityRequirement createReliablityRequirement()
  {
    ReliablityRequirementImpl reliablityRequirement = new ReliablityRequirementImpl();
    return reliablityRequirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AccuracyRequirement createAccuracyRequirement()
  {
    AccuracyRequirementImpl accuracyRequirement = new AccuracyRequirementImpl();
    return accuracyRequirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogRequirement createLogRequirement()
  {
    LogRequirementImpl logRequirement = new LogRequirementImpl();
    return logRequirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Percentile createPercentile()
  {
    PercentileImpl percentile = new PercentileImpl();
    return percentile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SecurityRequirement createSecurityRequirement()
  {
    SecurityRequirementImpl securityRequirement = new SecurityRequirementImpl();
    return securityRequirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AuthenticationRequirement createAuthenticationRequirement()
  {
    AuthenticationRequirementImpl authenticationRequirement = new AuthenticationRequirementImpl();
    return authenticationRequirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AuthToken createAuthToken()
  {
    AuthTokenImpl authToken = new AuthTokenImpl();
    return authToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HashAlgorithm createHashAlgorithm()
  {
    HashAlgorithmImpl hashAlgorithm = new HashAlgorithmImpl();
    return hashAlgorithm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SigningRequirement createSigningRequirement()
  {
    SigningRequirementImpl signingRequirement = new SigningRequirementImpl();
    return signingRequirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessagePartRef createMessagePartRef()
  {
    MessagePartRefImpl messagePartRef = new MessagePartRefImpl();
    return messagePartRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EncryptionRequirement createEncryptionRequirement()
  {
    EncryptionRequirementImpl encryptionRequirement = new EncryptionRequirementImpl();
    return encryptionRequirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PriorityDeclaration createPriorityDeclaration()
  {
    PriorityDeclarationImpl priorityDeclaration = new PriorityDeclarationImpl();
    return priorityDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Escalation createEscalation()
  {
    EscalationImpl escalation = new EscalationImpl();
    return escalation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Party createParty()
  {
    PartyImpl party = new PartyImpl();
    return party;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomerParty createCustomerParty()
  {
    CustomerPartyImpl customerParty = new CustomerPartyImpl();
    return customerParty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProviderParty createProviderParty()
  {
    ProviderPartyImpl providerParty = new ProviderPartyImpl();
    return providerParty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThirdParty createThirdParty()
  {
    ThirdPartyImpl thirdParty = new ThirdPartyImpl();
    return thirdParty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Repesentative createRepesentative()
  {
    RepesentativeImpl repesentative = new RepesentativeImpl();
    return repesentative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Responsibility createResponsibility()
  {
    ResponsibilityImpl responsibility = new ResponsibilityImpl();
    return responsibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleResponsibility createSimpleResponsibility()
  {
    SimpleResponsibilityImpl simpleResponsibility = new SimpleResponsibilityImpl();
    return simpleResponsibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Report createReport()
  {
    ReportImpl report = new ReportImpl();
    return report;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReportingResponsibility createReportingResponsibility()
  {
    ReportingResponsibilityImpl reportingResponsibility = new ReportingResponsibilityImpl();
    return reportingResponsibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HashAlgKind createHashAlgKindFromString(EDataType eDataType, String initialValue)
  {
    HashAlgKind result = HashAlgKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertHashAlgKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessagePartRefKind createMessagePartRefKindFromString(EDataType eDataType, String initialValue)
  {
    MessagePartRefKind result = MessagePartRefKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMessagePartRefKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SigningAlgothm createSigningAlgothmFromString(EDataType eDataType, String initialValue)
  {
    SigningAlgothm result = SigningAlgothm.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSigningAlgothmToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CipherAlgorithmKind createCipherAlgorithmKindFromString(EDataType eDataType, String initialValue)
  {
    CipherAlgorithmKind result = CipherAlgorithmKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCipherAlgorithmKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AuthTokenKind createAuthTokenKindFromString(EDataType eDataType, String initialValue)
  {
    AuthTokenKind result = AuthTokenKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAuthTokenKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogRequirementKind createLogRequirementKindFromString(EDataType eDataType, String initialValue)
  {
    LogRequirementKind result = LogRequirementKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLogRequirementKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReliablilityKind createReliablilityKindFromString(EDataType eDataType, String initialValue)
  {
    ReliablilityKind result = ReliablilityKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertReliablilityKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SLADslPackage getSLADslPackage()
  {
    return (SLADslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SLADslPackage getPackage()
  {
    return SLADslPackage.eINSTANCE;
  }

} //SLADslFactoryImpl
