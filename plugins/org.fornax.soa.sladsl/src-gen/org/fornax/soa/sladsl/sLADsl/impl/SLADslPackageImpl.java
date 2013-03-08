/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslPackage;

import org.fornax.soa.semanticsDsl.SemanticsDslPackage;

import org.fornax.soa.sladsl.sLADsl.AccuracyRequirement;
import org.fornax.soa.sladsl.sLADsl.AssetRef;
import org.fornax.soa.sladsl.sLADsl.AuthToken;
import org.fornax.soa.sladsl.sLADsl.AuthTokenKind;
import org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement;
import org.fornax.soa.sladsl.sLADsl.Availability;
import org.fornax.soa.sladsl.sLADsl.CapacityRequirement;
import org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind;
import org.fornax.soa.sladsl.sLADsl.Contact;
import org.fornax.soa.sladsl.sLADsl.Cost;
import org.fornax.soa.sladsl.sLADsl.CustomerParty;
import org.fornax.soa.sladsl.sLADsl.EncryptionRequirement;
import org.fornax.soa.sladsl.sLADsl.Escalation;
import org.fornax.soa.sladsl.sLADsl.HashAlgKind;
import org.fornax.soa.sladsl.sLADsl.HashAlgorithm;
import org.fornax.soa.sladsl.sLADsl.Latency;
import org.fornax.soa.sladsl.sLADsl.LogRequirement;
import org.fornax.soa.sladsl.sLADsl.LogRequirementKind;
import org.fornax.soa.sladsl.sLADsl.MaxDownTime;
import org.fornax.soa.sladsl.sLADsl.MessagePartRef;
import org.fornax.soa.sladsl.sLADsl.MessagePartRefKind;
import org.fornax.soa.sladsl.sLADsl.Party;
import org.fornax.soa.sladsl.sLADsl.Percentile;
import org.fornax.soa.sladsl.sLADsl.PriorityDeclaration;
import org.fornax.soa.sladsl.sLADsl.ProviderParty;
import org.fornax.soa.sladsl.sLADsl.ReliablilityKind;
import org.fornax.soa.sladsl.sLADsl.ReliablityRequirement;
import org.fornax.soa.sladsl.sLADsl.Repesentative;
import org.fornax.soa.sladsl.sLADsl.Report;
import org.fornax.soa.sladsl.sLADsl.ReportingResponsibility;
import org.fornax.soa.sladsl.sLADsl.Responsibility;
import org.fornax.soa.sladsl.sLADsl.SLADslFactory;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;
import org.fornax.soa.sladsl.sLADsl.SecurityRequirement;
import org.fornax.soa.sladsl.sLADsl.ServiceQualityProperty;
import org.fornax.soa.sladsl.sLADsl.SigningAlgothm;
import org.fornax.soa.sladsl.sLADsl.SigningRequirement;
import org.fornax.soa.sladsl.sLADsl.SimpleResponsibility;
import org.fornax.soa.sladsl.sLADsl.SlaModel;
import org.fornax.soa.sladsl.sLADsl.ThirdParty;
import org.fornax.soa.sladsl.sLADsl.Throughput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SLADslPackageImpl extends EPackageImpl implements SLADslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slaModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assetRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass costEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass serviceQualityPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass availabilityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass throughputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass latencyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass maxDownTimeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass capacityRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reliablityRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass accuracyRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass percentileEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass securityRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass authenticationRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass authTokenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hashAlgorithmEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signingRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass messagePartRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass encryptionRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass priorityDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass escalationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contactEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass partyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass customerPartyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass providerPartyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thirdPartyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass repesentativeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass responsibilityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleResponsibilityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reportingResponsibilityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum hashAlgKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum messagePartRefKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum signingAlgothmEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum cipherAlgorithmKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum authTokenKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum logRequirementKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum reliablilityKindEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SLADslPackageImpl()
  {
    super(eNS_URI, SLADslFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link SLADslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SLADslPackage init()
  {
    if (isInited) return (SLADslPackage)EPackage.Registry.INSTANCE.getEPackage(SLADslPackage.eNS_URI);

    // Obtain or create and register package
    SLADslPackageImpl theSLADslPackage = (SLADslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SLADslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SLADslPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    SOABaseDslPackage.eINSTANCE.eClass();
    SemanticsDslPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theSLADslPackage.createPackageContents();

    // Initialize created meta-data
    theSLADslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSLADslPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SLADslPackage.eNS_URI, theSLADslPackage);
    return theSLADslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSlaModel()
  {
    return slaModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSlaModel_Agreements()
  {
    return (EReference)slaModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSLA()
  {
    return slaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_Name()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_Owner()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_EffectiveDate()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_EffectiveUntil()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_Preample()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_Description()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_Scope()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSLA_AppliesTo()
  {
    return (EReference)slaEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSLA_ServiceQualityProperties()
  {
    return (EReference)slaEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSLA_Costs()
  {
    return (EReference)slaEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_DataSecProtClause()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSLA_SecurityRequirements()
  {
    return (EReference)slaEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_Restrictions()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSLA_Priorities()
  {
    return (EReference)slaEClass.getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSLA_EscalationProcedure()
  {
    return (EReference)slaEClass.getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_AdditionalServices()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(15);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSLA_Parties()
  {
    return (EReference)slaEClass.getEStructuralFeatures().get(16);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_Cancellation()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(17);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_ExtraordinaryCancellation()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(18);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSLA_EffortAccounting()
  {
    return (EAttribute)slaEClass.getEStructuralFeatures().get(19);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSLA_Reports()
  {
    return (EReference)slaEClass.getEStructuralFeatures().get(20);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSLA_Tags()
  {
    return (EReference)slaEClass.getEStructuralFeatures().get(21);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssetRef()
  {
    return assetRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssetRef_Asset()
  {
    return (EReference)assetRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssetRef_VersionRef()
  {
    return (EReference)assetRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCost()
  {
    return costEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCost_CostsAmount()
  {
    return (EAttribute)costEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCost_BilledUnit()
  {
    return (EAttribute)costEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCost_Escalation()
  {
    return (EReference)costEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCost_Penalty()
  {
    return (EAttribute)costEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServiceQualityProperty()
  {
    return serviceQualityPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAvailability()
  {
    return availabilityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAvailability_Availability()
  {
    return (EAttribute)availabilityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAvailability_Percentile()
  {
    return (EReference)availabilityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAvailability_Mtbf()
  {
    return (EAttribute)availabilityEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAvailability_Mttr()
  {
    return (EAttribute)availabilityEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAvailability_MttrPercentile()
  {
    return (EReference)availabilityEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAvailability_RegularDownTimes()
  {
    return (EAttribute)availabilityEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThroughput()
  {
    return throughputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getThroughput_Definition()
  {
    return (EAttribute)throughputEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getThroughput_Score()
  {
    return (EAttribute)throughputEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThroughput_Escalation()
  {
    return (EReference)throughputEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getThroughput_Penalty()
  {
    return (EAttribute)throughputEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLatency()
  {
    return latencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLatency_Latency()
  {
    return (EAttribute)latencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLatency_Percentile()
  {
    return (EReference)latencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLatency_Escalation()
  {
    return (EReference)latencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLatency_Penalty()
  {
    return (EAttribute)latencyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMaxDownTime()
  {
    return maxDownTimeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMaxDownTime_Definition()
  {
    return (EAttribute)maxDownTimeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMaxDownTime_Escalation()
  {
    return (EReference)maxDownTimeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMaxDownTime_Penalty()
  {
    return (EAttribute)maxDownTimeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCapacityRequirement()
  {
    return capacityRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCapacityRequirement_RequestNum()
  {
    return (EAttribute)capacityRequirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCapacityRequirement_TimeUnit()
  {
    return (EAttribute)capacityRequirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCapacityRequirement_MessageSize()
  {
    return (EAttribute)capacityRequirementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCapacityRequirement_Escalation()
  {
    return (EReference)capacityRequirementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCapacityRequirement_Penalty()
  {
    return (EAttribute)capacityRequirementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReliablityRequirement()
  {
    return reliablityRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReliablityRequirement_Reliability()
  {
    return (EAttribute)reliablityRequirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReliablityRequirement_InOrderDelivery()
  {
    return (EAttribute)reliablityRequirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAccuracyRequirement()
  {
    return accuracyRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAccuracyRequirement_MaxErrorRate()
  {
    return (EAttribute)accuracyRequirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAccuracyRequirement_Escalation()
  {
    return (EReference)accuracyRequirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAccuracyRequirement_Penalty()
  {
    return (EAttribute)accuracyRequirementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogRequirement()
  {
    return logRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLogRequirement_LogLevel()
  {
    return (EAttribute)logRequirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLogRequirement_AdditionalLoggingRequirement()
  {
    return (EAttribute)logRequirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPercentile()
  {
    return percentileEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPercentile_Percentile()
  {
    return (EAttribute)percentileEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecurityRequirement()
  {
    return securityRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAuthenticationRequirement()
  {
    return authenticationRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAuthenticationRequirement_Optional()
  {
    return (EAttribute)authenticationRequirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAuthenticationRequirement_AuthTokens()
  {
    return (EReference)authenticationRequirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAuthenticationRequirement_HashAlgorithms()
  {
    return (EReference)authenticationRequirementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAuthenticationRequirement_UseNonce()
  {
    return (EAttribute)authenticationRequirementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAuthenticationRequirement_Issuer()
  {
    return (EAttribute)authenticationRequirementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAuthToken()
  {
    return authTokenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAuthToken_Optional()
  {
    return (EAttribute)authTokenEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAuthToken_Kind()
  {
    return (EAttribute)authTokenEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHashAlgorithm()
  {
    return hashAlgorithmEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHashAlgorithm_Optional()
  {
    return (EAttribute)hashAlgorithmEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHashAlgorithm_UseBase64()
  {
    return (EAttribute)hashAlgorithmEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHashAlgorithm_Kind()
  {
    return (EAttribute)hashAlgorithmEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSigningRequirement()
  {
    return signingRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigningRequirement_SupportedSigningAlgorithms()
  {
    return (EAttribute)signingRequirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigningRequirement_RequiredSigningAlgorithm()
  {
    return (EAttribute)signingRequirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSigningRequirement_SignedParts()
  {
    return (EReference)signingRequirementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMessagePartRef()
  {
    return messagePartRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMessagePartRef_MessagePartRef()
  {
    return (EAttribute)messagePartRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMessagePartRef_PartRefExpression()
  {
    return (EAttribute)messagePartRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEncryptionRequirement()
  {
    return encryptionRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEncryptionRequirement_SupportedCipherAlgorithms()
  {
    return (EAttribute)encryptionRequirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEncryptionRequirement_RequiredCipherAlgorithm()
  {
    return (EAttribute)encryptionRequirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEncryptionRequirement_EncryptedParts()
  {
    return (EReference)encryptionRequirementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPriorityDeclaration()
  {
    return priorityDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPriorityDeclaration_Name()
  {
    return (EAttribute)priorityDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPriorityDeclaration_Description()
  {
    return (EAttribute)priorityDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEscalation()
  {
    return escalationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEscalation_Cause()
  {
    return (EAttribute)escalationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEscalation_EscalationTargets()
  {
    return (EReference)escalationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEscalation_Procedure()
  {
    return (EAttribute)escalationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContact()
  {
    return contactEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContact_Fullname()
  {
    return (EAttribute)contactEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContact_Phone()
  {
    return (EAttribute)contactEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContact_Email()
  {
    return (EAttribute)contactEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParty()
  {
    return partyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParty_Name()
  {
    return (EAttribute)partyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParty_Representatives()
  {
    return (EReference)partyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParty_Responsibilities()
  {
    return (EReference)partyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCustomerParty()
  {
    return customerPartyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProviderParty()
  {
    return providerPartyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThirdParty()
  {
    return thirdPartyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getThirdParty_Role()
  {
    return (EAttribute)thirdPartyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRepesentative()
  {
    return repesentativeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRepesentative_Fullname()
  {
    return (EAttribute)repesentativeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRepesentative_Phone()
  {
    return (EAttribute)repesentativeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRepesentative_Email()
  {
    return (EAttribute)repesentativeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResponsibility()
  {
    return responsibilityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResponsibility_Name()
  {
    return (EAttribute)responsibilityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResponsibility_Escalations()
  {
    return (EReference)responsibilityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResponsibility_Penalty()
  {
    return (EAttribute)responsibilityEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleResponsibility()
  {
    return simpleResponsibilityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleResponsibility_Description()
  {
    return (EAttribute)simpleResponsibilityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReport()
  {
    return reportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReport_Name()
  {
    return (EAttribute)reportEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReport_ReportTo()
  {
    return (EAttribute)reportEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReport_Content()
  {
    return (EAttribute)reportEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReportingResponsibility()
  {
    return reportingResponsibilityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReportingResponsibility_Content()
  {
    return (EAttribute)reportingResponsibilityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getHashAlgKind()
  {
    return hashAlgKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getMessagePartRefKind()
  {
    return messagePartRefKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSigningAlgothm()
  {
    return signingAlgothmEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCipherAlgorithmKind()
  {
    return cipherAlgorithmKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAuthTokenKind()
  {
    return authTokenKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getLogRequirementKind()
  {
    return logRequirementKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getReliablilityKind()
  {
    return reliablilityKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SLADslFactory getSLADslFactory()
  {
    return (SLADslFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    slaModelEClass = createEClass(SLA_MODEL);
    createEReference(slaModelEClass, SLA_MODEL__AGREEMENTS);

    slaEClass = createEClass(SLA);
    createEAttribute(slaEClass, SLA__NAME);
    createEAttribute(slaEClass, SLA__OWNER);
    createEAttribute(slaEClass, SLA__EFFECTIVE_DATE);
    createEAttribute(slaEClass, SLA__EFFECTIVE_UNTIL);
    createEAttribute(slaEClass, SLA__PREAMPLE);
    createEAttribute(slaEClass, SLA__DESCRIPTION);
    createEAttribute(slaEClass, SLA__SCOPE);
    createEReference(slaEClass, SLA__APPLIES_TO);
    createEReference(slaEClass, SLA__SERVICE_QUALITY_PROPERTIES);
    createEReference(slaEClass, SLA__COSTS);
    createEAttribute(slaEClass, SLA__DATA_SEC_PROT_CLAUSE);
    createEReference(slaEClass, SLA__SECURITY_REQUIREMENTS);
    createEAttribute(slaEClass, SLA__RESTRICTIONS);
    createEReference(slaEClass, SLA__PRIORITIES);
    createEReference(slaEClass, SLA__ESCALATION_PROCEDURE);
    createEAttribute(slaEClass, SLA__ADDITIONAL_SERVICES);
    createEReference(slaEClass, SLA__PARTIES);
    createEAttribute(slaEClass, SLA__CANCELLATION);
    createEAttribute(slaEClass, SLA__EXTRAORDINARY_CANCELLATION);
    createEAttribute(slaEClass, SLA__EFFORT_ACCOUNTING);
    createEReference(slaEClass, SLA__REPORTS);
    createEReference(slaEClass, SLA__TAGS);

    assetRefEClass = createEClass(ASSET_REF);
    createEReference(assetRefEClass, ASSET_REF__ASSET);
    createEReference(assetRefEClass, ASSET_REF__VERSION_REF);

    costEClass = createEClass(COST);
    createEAttribute(costEClass, COST__COSTS_AMOUNT);
    createEAttribute(costEClass, COST__BILLED_UNIT);
    createEReference(costEClass, COST__ESCALATION);
    createEAttribute(costEClass, COST__PENALTY);

    serviceQualityPropertyEClass = createEClass(SERVICE_QUALITY_PROPERTY);

    availabilityEClass = createEClass(AVAILABILITY);
    createEAttribute(availabilityEClass, AVAILABILITY__AVAILABILITY);
    createEReference(availabilityEClass, AVAILABILITY__PERCENTILE);
    createEAttribute(availabilityEClass, AVAILABILITY__MTBF);
    createEAttribute(availabilityEClass, AVAILABILITY__MTTR);
    createEReference(availabilityEClass, AVAILABILITY__MTTR_PERCENTILE);
    createEAttribute(availabilityEClass, AVAILABILITY__REGULAR_DOWN_TIMES);

    throughputEClass = createEClass(THROUGHPUT);
    createEAttribute(throughputEClass, THROUGHPUT__DEFINITION);
    createEAttribute(throughputEClass, THROUGHPUT__SCORE);
    createEReference(throughputEClass, THROUGHPUT__ESCALATION);
    createEAttribute(throughputEClass, THROUGHPUT__PENALTY);

    latencyEClass = createEClass(LATENCY);
    createEAttribute(latencyEClass, LATENCY__LATENCY);
    createEReference(latencyEClass, LATENCY__PERCENTILE);
    createEReference(latencyEClass, LATENCY__ESCALATION);
    createEAttribute(latencyEClass, LATENCY__PENALTY);

    maxDownTimeEClass = createEClass(MAX_DOWN_TIME);
    createEAttribute(maxDownTimeEClass, MAX_DOWN_TIME__DEFINITION);
    createEReference(maxDownTimeEClass, MAX_DOWN_TIME__ESCALATION);
    createEAttribute(maxDownTimeEClass, MAX_DOWN_TIME__PENALTY);

    capacityRequirementEClass = createEClass(CAPACITY_REQUIREMENT);
    createEAttribute(capacityRequirementEClass, CAPACITY_REQUIREMENT__REQUEST_NUM);
    createEAttribute(capacityRequirementEClass, CAPACITY_REQUIREMENT__TIME_UNIT);
    createEAttribute(capacityRequirementEClass, CAPACITY_REQUIREMENT__MESSAGE_SIZE);
    createEReference(capacityRequirementEClass, CAPACITY_REQUIREMENT__ESCALATION);
    createEAttribute(capacityRequirementEClass, CAPACITY_REQUIREMENT__PENALTY);

    reliablityRequirementEClass = createEClass(RELIABLITY_REQUIREMENT);
    createEAttribute(reliablityRequirementEClass, RELIABLITY_REQUIREMENT__RELIABILITY);
    createEAttribute(reliablityRequirementEClass, RELIABLITY_REQUIREMENT__IN_ORDER_DELIVERY);

    accuracyRequirementEClass = createEClass(ACCURACY_REQUIREMENT);
    createEAttribute(accuracyRequirementEClass, ACCURACY_REQUIREMENT__MAX_ERROR_RATE);
    createEReference(accuracyRequirementEClass, ACCURACY_REQUIREMENT__ESCALATION);
    createEAttribute(accuracyRequirementEClass, ACCURACY_REQUIREMENT__PENALTY);

    logRequirementEClass = createEClass(LOG_REQUIREMENT);
    createEAttribute(logRequirementEClass, LOG_REQUIREMENT__LOG_LEVEL);
    createEAttribute(logRequirementEClass, LOG_REQUIREMENT__ADDITIONAL_LOGGING_REQUIREMENT);

    percentileEClass = createEClass(PERCENTILE);
    createEAttribute(percentileEClass, PERCENTILE__PERCENTILE);

    securityRequirementEClass = createEClass(SECURITY_REQUIREMENT);

    authenticationRequirementEClass = createEClass(AUTHENTICATION_REQUIREMENT);
    createEAttribute(authenticationRequirementEClass, AUTHENTICATION_REQUIREMENT__OPTIONAL);
    createEReference(authenticationRequirementEClass, AUTHENTICATION_REQUIREMENT__AUTH_TOKENS);
    createEReference(authenticationRequirementEClass, AUTHENTICATION_REQUIREMENT__HASH_ALGORITHMS);
    createEAttribute(authenticationRequirementEClass, AUTHENTICATION_REQUIREMENT__USE_NONCE);
    createEAttribute(authenticationRequirementEClass, AUTHENTICATION_REQUIREMENT__ISSUER);

    authTokenEClass = createEClass(AUTH_TOKEN);
    createEAttribute(authTokenEClass, AUTH_TOKEN__OPTIONAL);
    createEAttribute(authTokenEClass, AUTH_TOKEN__KIND);

    hashAlgorithmEClass = createEClass(HASH_ALGORITHM);
    createEAttribute(hashAlgorithmEClass, HASH_ALGORITHM__OPTIONAL);
    createEAttribute(hashAlgorithmEClass, HASH_ALGORITHM__USE_BASE64);
    createEAttribute(hashAlgorithmEClass, HASH_ALGORITHM__KIND);

    signingRequirementEClass = createEClass(SIGNING_REQUIREMENT);
    createEAttribute(signingRequirementEClass, SIGNING_REQUIREMENT__SUPPORTED_SIGNING_ALGORITHMS);
    createEAttribute(signingRequirementEClass, SIGNING_REQUIREMENT__REQUIRED_SIGNING_ALGORITHM);
    createEReference(signingRequirementEClass, SIGNING_REQUIREMENT__SIGNED_PARTS);

    messagePartRefEClass = createEClass(MESSAGE_PART_REF);
    createEAttribute(messagePartRefEClass, MESSAGE_PART_REF__MESSAGE_PART_REF);
    createEAttribute(messagePartRefEClass, MESSAGE_PART_REF__PART_REF_EXPRESSION);

    encryptionRequirementEClass = createEClass(ENCRYPTION_REQUIREMENT);
    createEAttribute(encryptionRequirementEClass, ENCRYPTION_REQUIREMENT__SUPPORTED_CIPHER_ALGORITHMS);
    createEAttribute(encryptionRequirementEClass, ENCRYPTION_REQUIREMENT__REQUIRED_CIPHER_ALGORITHM);
    createEReference(encryptionRequirementEClass, ENCRYPTION_REQUIREMENT__ENCRYPTED_PARTS);

    priorityDeclarationEClass = createEClass(PRIORITY_DECLARATION);
    createEAttribute(priorityDeclarationEClass, PRIORITY_DECLARATION__NAME);
    createEAttribute(priorityDeclarationEClass, PRIORITY_DECLARATION__DESCRIPTION);

    escalationEClass = createEClass(ESCALATION);
    createEAttribute(escalationEClass, ESCALATION__CAUSE);
    createEReference(escalationEClass, ESCALATION__ESCALATION_TARGETS);
    createEAttribute(escalationEClass, ESCALATION__PROCEDURE);

    contactEClass = createEClass(CONTACT);
    createEAttribute(contactEClass, CONTACT__FULLNAME);
    createEAttribute(contactEClass, CONTACT__PHONE);
    createEAttribute(contactEClass, CONTACT__EMAIL);

    partyEClass = createEClass(PARTY);
    createEAttribute(partyEClass, PARTY__NAME);
    createEReference(partyEClass, PARTY__REPRESENTATIVES);
    createEReference(partyEClass, PARTY__RESPONSIBILITIES);

    customerPartyEClass = createEClass(CUSTOMER_PARTY);

    providerPartyEClass = createEClass(PROVIDER_PARTY);

    thirdPartyEClass = createEClass(THIRD_PARTY);
    createEAttribute(thirdPartyEClass, THIRD_PARTY__ROLE);

    repesentativeEClass = createEClass(REPESENTATIVE);
    createEAttribute(repesentativeEClass, REPESENTATIVE__FULLNAME);
    createEAttribute(repesentativeEClass, REPESENTATIVE__PHONE);
    createEAttribute(repesentativeEClass, REPESENTATIVE__EMAIL);

    responsibilityEClass = createEClass(RESPONSIBILITY);
    createEAttribute(responsibilityEClass, RESPONSIBILITY__NAME);
    createEReference(responsibilityEClass, RESPONSIBILITY__ESCALATIONS);
    createEAttribute(responsibilityEClass, RESPONSIBILITY__PENALTY);

    simpleResponsibilityEClass = createEClass(SIMPLE_RESPONSIBILITY);
    createEAttribute(simpleResponsibilityEClass, SIMPLE_RESPONSIBILITY__DESCRIPTION);

    reportEClass = createEClass(REPORT);
    createEAttribute(reportEClass, REPORT__NAME);
    createEAttribute(reportEClass, REPORT__REPORT_TO);
    createEAttribute(reportEClass, REPORT__CONTENT);

    reportingResponsibilityEClass = createEClass(REPORTING_RESPONSIBILITY);
    createEAttribute(reportingResponsibilityEClass, REPORTING_RESPONSIBILITY__CONTENT);

    // Create enums
    hashAlgKindEEnum = createEEnum(HASH_ALG_KIND);
    messagePartRefKindEEnum = createEEnum(MESSAGE_PART_REF_KIND);
    signingAlgothmEEnum = createEEnum(SIGNING_ALGOTHM);
    cipherAlgorithmKindEEnum = createEEnum(CIPHER_ALGORITHM_KIND);
    authTokenKindEEnum = createEEnum(AUTH_TOKEN_KIND);
    logRequirementKindEEnum = createEEnum(LOG_REQUIREMENT_KIND);
    reliablilityKindEEnum = createEEnum(RELIABLILITY_KIND);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    SemanticsDslPackage theSemanticsDslPackage = (SemanticsDslPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticsDslPackage.eNS_URI);
    SOABaseDslPackage theSOABaseDslPackage = (SOABaseDslPackage)EPackage.Registry.INSTANCE.getEPackage(SOABaseDslPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    availabilityEClass.getESuperTypes().add(this.getServiceQualityProperty());
    throughputEClass.getESuperTypes().add(this.getServiceQualityProperty());
    latencyEClass.getESuperTypes().add(this.getServiceQualityProperty());
    maxDownTimeEClass.getESuperTypes().add(this.getServiceQualityProperty());
    capacityRequirementEClass.getESuperTypes().add(this.getServiceQualityProperty());
    reliablityRequirementEClass.getESuperTypes().add(this.getServiceQualityProperty());
    accuracyRequirementEClass.getESuperTypes().add(this.getServiceQualityProperty());
    logRequirementEClass.getESuperTypes().add(this.getServiceQualityProperty());
    authenticationRequirementEClass.getESuperTypes().add(this.getSecurityRequirement());
    signingRequirementEClass.getESuperTypes().add(this.getSecurityRequirement());
    encryptionRequirementEClass.getESuperTypes().add(this.getSecurityRequirement());
    customerPartyEClass.getESuperTypes().add(this.getParty());
    providerPartyEClass.getESuperTypes().add(this.getParty());
    thirdPartyEClass.getESuperTypes().add(this.getParty());
    simpleResponsibilityEClass.getESuperTypes().add(this.getResponsibility());
    reportingResponsibilityEClass.getESuperTypes().add(this.getResponsibility());

    // Initialize classes and features; add operations and parameters
    initEClass(slaModelEClass, SlaModel.class, "SlaModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSlaModel_Agreements(), this.getSLA(), null, "agreements", null, 0, -1, SlaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(slaEClass, org.fornax.soa.sladsl.sLADsl.SLA.class, "SLA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSLA_Name(), ecorePackage.getEString(), "name", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_Owner(), ecorePackage.getEString(), "owner", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_EffectiveDate(), ecorePackage.getEString(), "effectiveDate", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_EffectiveUntil(), ecorePackage.getEString(), "effectiveUntil", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_Preample(), ecorePackage.getEString(), "preample", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_Description(), ecorePackage.getEString(), "description", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_Scope(), ecorePackage.getEString(), "scope", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSLA_AppliesTo(), this.getAssetRef(), null, "appliesTo", null, 0, -1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSLA_ServiceQualityProperties(), this.getServiceQualityProperty(), null, "serviceQualityProperties", null, 0, -1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSLA_Costs(), this.getCost(), null, "costs", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_DataSecProtClause(), ecorePackage.getEString(), "dataSecProtClause", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSLA_SecurityRequirements(), this.getSecurityRequirement(), null, "securityRequirements", null, 0, -1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_Restrictions(), ecorePackage.getEString(), "restrictions", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSLA_Priorities(), this.getPriorityDeclaration(), null, "priorities", null, 0, -1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSLA_EscalationProcedure(), this.getEscalation(), null, "escalationProcedure", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_AdditionalServices(), ecorePackage.getEString(), "additionalServices", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSLA_Parties(), this.getParty(), null, "parties", null, 0, -1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_Cancellation(), ecorePackage.getEString(), "cancellation", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_ExtraordinaryCancellation(), ecorePackage.getEString(), "extraordinaryCancellation", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSLA_EffortAccounting(), ecorePackage.getEString(), "effortAccounting", null, 0, 1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSLA_Reports(), this.getReport(), null, "reports", null, 0, -1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSLA_Tags(), theSemanticsDslPackage.getTag(), null, "tags", null, 0, -1, org.fornax.soa.sladsl.sLADsl.SLA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assetRefEClass, AssetRef.class, "AssetRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssetRef_Asset(), ecorePackage.getEObject(), null, "asset", null, 0, 1, AssetRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssetRef_VersionRef(), theSOABaseDslPackage.getVersionRef(), null, "versionRef", null, 0, 1, AssetRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(costEClass, Cost.class, "Cost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCost_CostsAmount(), ecorePackage.getEString(), "costsAmount", null, 0, 1, Cost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCost_BilledUnit(), ecorePackage.getEString(), "billedUnit", null, 0, 1, Cost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCost_Escalation(), this.getEscalation(), null, "escalation", null, 0, 1, Cost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCost_Penalty(), ecorePackage.getEString(), "penalty", null, 0, 1, Cost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(serviceQualityPropertyEClass, ServiceQualityProperty.class, "ServiceQualityProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(availabilityEClass, Availability.class, "Availability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAvailability_Availability(), ecorePackage.getEString(), "availability", null, 0, 1, Availability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAvailability_Percentile(), this.getPercentile(), null, "percentile", null, 0, 1, Availability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAvailability_Mtbf(), ecorePackage.getEString(), "mtbf", null, 0, 1, Availability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAvailability_Mttr(), ecorePackage.getEString(), "mttr", null, 0, 1, Availability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAvailability_MttrPercentile(), this.getPercentile(), null, "mttrPercentile", null, 0, 1, Availability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAvailability_RegularDownTimes(), ecorePackage.getEString(), "regularDownTimes", null, 0, 1, Availability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(throughputEClass, Throughput.class, "Throughput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getThroughput_Definition(), ecorePackage.getEString(), "definition", null, 0, 1, Throughput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getThroughput_Score(), ecorePackage.getEString(), "score", null, 0, 1, Throughput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getThroughput_Escalation(), this.getEscalation(), null, "escalation", null, 0, 1, Throughput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getThroughput_Penalty(), ecorePackage.getEString(), "penalty", null, 0, 1, Throughput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(latencyEClass, Latency.class, "Latency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLatency_Latency(), ecorePackage.getEString(), "latency", null, 0, 1, Latency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLatency_Percentile(), this.getPercentile(), null, "percentile", null, 0, 1, Latency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLatency_Escalation(), this.getEscalation(), null, "escalation", null, 0, 1, Latency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLatency_Penalty(), ecorePackage.getEString(), "penalty", null, 0, 1, Latency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(maxDownTimeEClass, MaxDownTime.class, "MaxDownTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMaxDownTime_Definition(), ecorePackage.getEString(), "definition", null, 0, 1, MaxDownTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMaxDownTime_Escalation(), this.getEscalation(), null, "escalation", null, 0, 1, MaxDownTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMaxDownTime_Penalty(), ecorePackage.getEString(), "penalty", null, 0, 1, MaxDownTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(capacityRequirementEClass, CapacityRequirement.class, "CapacityRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCapacityRequirement_RequestNum(), ecorePackage.getEString(), "requestNum", null, 0, 1, CapacityRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCapacityRequirement_TimeUnit(), ecorePackage.getEString(), "timeUnit", null, 0, 1, CapacityRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCapacityRequirement_MessageSize(), ecorePackage.getEString(), "messageSize", null, 0, 1, CapacityRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCapacityRequirement_Escalation(), this.getEscalation(), null, "escalation", null, 0, 1, CapacityRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCapacityRequirement_Penalty(), ecorePackage.getEString(), "penalty", null, 0, 1, CapacityRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reliablityRequirementEClass, ReliablityRequirement.class, "ReliablityRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReliablityRequirement_Reliability(), this.getReliablilityKind(), "reliability", null, 0, 1, ReliablityRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReliablityRequirement_InOrderDelivery(), ecorePackage.getEBoolean(), "inOrderDelivery", null, 0, 1, ReliablityRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(accuracyRequirementEClass, AccuracyRequirement.class, "AccuracyRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAccuracyRequirement_MaxErrorRate(), ecorePackage.getEString(), "maxErrorRate", null, 0, 1, AccuracyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAccuracyRequirement_Escalation(), this.getEscalation(), null, "escalation", null, 0, 1, AccuracyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAccuracyRequirement_Penalty(), ecorePackage.getEString(), "penalty", null, 0, 1, AccuracyRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logRequirementEClass, LogRequirement.class, "LogRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLogRequirement_LogLevel(), this.getLogRequirementKind(), "logLevel", null, 0, 1, LogRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLogRequirement_AdditionalLoggingRequirement(), ecorePackage.getEString(), "additionalLoggingRequirement", null, 0, 1, LogRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(percentileEClass, Percentile.class, "Percentile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPercentile_Percentile(), ecorePackage.getEInt(), "percentile", null, 0, 1, Percentile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(securityRequirementEClass, SecurityRequirement.class, "SecurityRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(authenticationRequirementEClass, AuthenticationRequirement.class, "AuthenticationRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAuthenticationRequirement_Optional(), ecorePackage.getEBoolean(), "optional", null, 0, 1, AuthenticationRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAuthenticationRequirement_AuthTokens(), this.getAuthToken(), null, "authTokens", null, 0, -1, AuthenticationRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAuthenticationRequirement_HashAlgorithms(), this.getHashAlgorithm(), null, "hashAlgorithms", null, 0, -1, AuthenticationRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAuthenticationRequirement_UseNonce(), ecorePackage.getEBoolean(), "useNonce", null, 0, 1, AuthenticationRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAuthenticationRequirement_Issuer(), ecorePackage.getEString(), "issuer", null, 0, 1, AuthenticationRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(authTokenEClass, AuthToken.class, "AuthToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAuthToken_Optional(), ecorePackage.getEBoolean(), "optional", null, 0, 1, AuthToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAuthToken_Kind(), this.getAuthTokenKind(), "kind", null, 0, 1, AuthToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hashAlgorithmEClass, HashAlgorithm.class, "HashAlgorithm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getHashAlgorithm_Optional(), ecorePackage.getEBoolean(), "optional", null, 0, 1, HashAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHashAlgorithm_UseBase64(), ecorePackage.getEBoolean(), "useBase64", null, 0, 1, HashAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHashAlgorithm_Kind(), this.getHashAlgKind(), "kind", null, 0, 1, HashAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(signingRequirementEClass, SigningRequirement.class, "SigningRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSigningRequirement_SupportedSigningAlgorithms(), this.getSigningAlgothm(), "supportedSigningAlgorithms", null, 0, -1, SigningRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigningRequirement_RequiredSigningAlgorithm(), this.getSigningAlgothm(), "requiredSigningAlgorithm", null, 0, 1, SigningRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSigningRequirement_SignedParts(), this.getMessagePartRef(), null, "signedParts", null, 0, -1, SigningRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(messagePartRefEClass, MessagePartRef.class, "MessagePartRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMessagePartRef_MessagePartRef(), this.getMessagePartRefKind(), "messagePartRef", null, 0, 1, MessagePartRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMessagePartRef_PartRefExpression(), ecorePackage.getEString(), "partRefExpression", null, 0, 1, MessagePartRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(encryptionRequirementEClass, EncryptionRequirement.class, "EncryptionRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEncryptionRequirement_SupportedCipherAlgorithms(), this.getCipherAlgorithmKind(), "supportedCipherAlgorithms", null, 0, -1, EncryptionRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEncryptionRequirement_RequiredCipherAlgorithm(), this.getCipherAlgorithmKind(), "requiredCipherAlgorithm", null, 0, 1, EncryptionRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEncryptionRequirement_EncryptedParts(), this.getMessagePartRef(), null, "encryptedParts", null, 0, -1, EncryptionRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(priorityDeclarationEClass, PriorityDeclaration.class, "PriorityDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPriorityDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, PriorityDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPriorityDeclaration_Description(), ecorePackage.getEString(), "description", null, 0, 1, PriorityDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(escalationEClass, Escalation.class, "Escalation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEscalation_Cause(), ecorePackage.getEString(), "cause", null, 0, 1, Escalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEscalation_EscalationTargets(), this.getContact(), null, "escalationTargets", null, 0, -1, Escalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEscalation_Procedure(), ecorePackage.getEString(), "procedure", null, 0, 1, Escalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(contactEClass, Contact.class, "Contact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getContact_Fullname(), ecorePackage.getEString(), "fullname", null, 0, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContact_Phone(), ecorePackage.getEString(), "phone", null, 0, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContact_Email(), ecorePackage.getEString(), "email", null, 0, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(partyEClass, Party.class, "Party", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParty_Name(), ecorePackage.getEString(), "name", null, 0, 1, Party.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParty_Representatives(), this.getRepesentative(), null, "representatives", null, 0, -1, Party.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParty_Responsibilities(), this.getResponsibility(), null, "responsibilities", null, 0, -1, Party.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(customerPartyEClass, CustomerParty.class, "CustomerParty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(providerPartyEClass, ProviderParty.class, "ProviderParty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(thirdPartyEClass, ThirdParty.class, "ThirdParty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getThirdParty_Role(), ecorePackage.getEString(), "role", null, 0, 1, ThirdParty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(repesentativeEClass, Repesentative.class, "Repesentative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRepesentative_Fullname(), ecorePackage.getEString(), "fullname", null, 0, 1, Repesentative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRepesentative_Phone(), ecorePackage.getEString(), "phone", null, 0, 1, Repesentative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRepesentative_Email(), ecorePackage.getEString(), "email", null, 0, 1, Repesentative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(responsibilityEClass, Responsibility.class, "Responsibility", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResponsibility_Name(), ecorePackage.getEString(), "name", null, 0, 1, Responsibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResponsibility_Escalations(), this.getEscalation(), null, "escalations", null, 0, -1, Responsibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResponsibility_Penalty(), ecorePackage.getEString(), "penalty", null, 0, 1, Responsibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleResponsibilityEClass, SimpleResponsibility.class, "SimpleResponsibility", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleResponsibility_Description(), ecorePackage.getEString(), "description", null, 0, 1, SimpleResponsibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reportEClass, Report.class, "Report", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReport_Name(), ecorePackage.getEString(), "name", null, 0, 1, Report.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReport_ReportTo(), ecorePackage.getEString(), "reportTo", null, 0, 1, Report.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReport_Content(), ecorePackage.getEString(), "content", null, 0, 1, Report.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reportingResponsibilityEClass, ReportingResponsibility.class, "ReportingResponsibility", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReportingResponsibility_Content(), ecorePackage.getEString(), "content", null, 0, 1, ReportingResponsibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(hashAlgKindEEnum, HashAlgKind.class, "HashAlgKind");
    addEEnumLiteral(hashAlgKindEEnum, HashAlgKind.MD5);
    addEEnumLiteral(hashAlgKindEEnum, HashAlgKind.SHA1);
    addEEnumLiteral(hashAlgKindEEnum, HashAlgKind.SHA256);
    addEEnumLiteral(hashAlgKindEEnum, HashAlgKind.RSA);
    addEEnumLiteral(hashAlgKindEEnum, HashAlgKind.PLAIN_TEXT);

    initEEnum(messagePartRefKindEEnum, MessagePartRefKind.class, "MessagePartRefKind");
    addEEnumLiteral(messagePartRefKindEEnum, MessagePartRefKind.HEADER);
    addEEnumLiteral(messagePartRefKindEEnum, MessagePartRefKind.BODY);
    addEEnumLiteral(messagePartRefKindEEnum, MessagePartRefKind.ATTACHMENTS);
    addEEnumLiteral(messagePartRefKindEEnum, MessagePartRefKind.ALL);
    addEEnumLiteral(messagePartRefKindEEnum, MessagePartRefKind.EXPRESSION);

    initEEnum(signingAlgothmEEnum, SigningAlgothm.class, "SigningAlgothm");
    addEEnumLiteral(signingAlgothmEEnum, SigningAlgothm.NONE);
    addEEnumLiteral(signingAlgothmEEnum, SigningAlgothm.SHA1);
    addEEnumLiteral(signingAlgothmEEnum, SigningAlgothm.SHA256);
    addEEnumLiteral(signingAlgothmEEnum, SigningAlgothm.MD5);
    addEEnumLiteral(signingAlgothmEEnum, SigningAlgothm.RSA_15);
    addEEnumLiteral(signingAlgothmEEnum, SigningAlgothm.AES128);
    addEEnumLiteral(signingAlgothmEEnum, SigningAlgothm.AES192);
    addEEnumLiteral(signingAlgothmEEnum, SigningAlgothm.AES256);

    initEEnum(cipherAlgorithmKindEEnum, CipherAlgorithmKind.class, "CipherAlgorithmKind");
    addEEnumLiteral(cipherAlgorithmKindEEnum, CipherAlgorithmKind.NONE);
    addEEnumLiteral(cipherAlgorithmKindEEnum, CipherAlgorithmKind.BASIC128);
    addEEnumLiteral(cipherAlgorithmKindEEnum, CipherAlgorithmKind.BASIC192);
    addEEnumLiteral(cipherAlgorithmKindEEnum, CipherAlgorithmKind.BASIC256);
    addEEnumLiteral(cipherAlgorithmKindEEnum, CipherAlgorithmKind.DES);
    addEEnumLiteral(cipherAlgorithmKindEEnum, CipherAlgorithmKind.TRIPLE_DES);
    addEEnumLiteral(cipherAlgorithmKindEEnum, CipherAlgorithmKind.AES128);
    addEEnumLiteral(cipherAlgorithmKindEEnum, CipherAlgorithmKind.AES256);

    initEEnum(authTokenKindEEnum, AuthTokenKind.class, "AuthTokenKind");
    addEEnumLiteral(authTokenKindEEnum, AuthTokenKind.USERNAME_PASSWORD);
    addEEnumLiteral(authTokenKindEEnum, AuthTokenKind.SAML);
    addEEnumLiteral(authTokenKindEEnum, AuthTokenKind.SAML2);
    addEEnumLiteral(authTokenKindEEnum, AuthTokenKind.KERBEROS);
    addEEnumLiteral(authTokenKindEEnum, AuthTokenKind.SPNEGO);
    addEEnumLiteral(authTokenKindEEnum, AuthTokenKind.REL_TOKEN);
    addEEnumLiteral(authTokenKindEEnum, AuthTokenKind.X509_CERTIFICATE);
    addEEnumLiteral(authTokenKindEEnum, AuthTokenKind.OAUTH);
    addEEnumLiteral(authTokenKindEEnum, AuthTokenKind.OAUTH2);

    initEEnum(logRequirementKindEEnum, LogRequirementKind.class, "LogRequirementKind");
    addEEnumLiteral(logRequirementKindEEnum, LogRequirementKind.NONE);
    addEEnumLiteral(logRequirementKindEEnum, LogRequirementKind.HEADER);
    addEEnumLiteral(logRequirementKindEEnum, LogRequirementKind.ALL);

    initEEnum(reliablilityKindEEnum, ReliablilityKind.class, "ReliablilityKind");
    addEEnumLiteral(reliablilityKindEEnum, ReliablilityKind.EXACTLY_ONCE);
    addEEnumLiteral(reliablilityKindEEnum, ReliablilityKind.AT_MOST_ONCE);
    addEEnumLiteral(reliablilityKindEEnum, ReliablilityKind.AT_LEAST_ONCE);
    addEEnumLiteral(reliablilityKindEEnum, ReliablilityKind.BEST_EFFORT);

    // Create resource
    createResource(eNS_URI);
  }

} //SLADslPackageImpl
