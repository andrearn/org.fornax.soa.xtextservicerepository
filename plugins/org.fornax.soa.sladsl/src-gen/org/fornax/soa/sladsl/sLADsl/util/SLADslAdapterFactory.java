/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.fornax.soa.sladsl.sLADsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage
 * @generated
 */
public class SLADslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SLADslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SLADslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = SLADslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SLADslSwitch<Adapter> modelSwitch =
    new SLADslSwitch<Adapter>()
    {
      @Override
      public Adapter caseSlaModel(SlaModel object)
      {
        return createSlaModelAdapter();
      }
      @Override
      public Adapter caseSLA(SLA object)
      {
        return createSLAAdapter();
      }
      @Override
      public Adapter caseCost(Cost object)
      {
        return createCostAdapter();
      }
      @Override
      public Adapter caseServiceQualityProperty(ServiceQualityProperty object)
      {
        return createServiceQualityPropertyAdapter();
      }
      @Override
      public Adapter caseAvailability(Availability object)
      {
        return createAvailabilityAdapter();
      }
      @Override
      public Adapter caseThroughput(Throughput object)
      {
        return createThroughputAdapter();
      }
      @Override
      public Adapter caseLatency(Latency object)
      {
        return createLatencyAdapter();
      }
      @Override
      public Adapter caseMaxDownTime(MaxDownTime object)
      {
        return createMaxDownTimeAdapter();
      }
      @Override
      public Adapter caseCapacityRequirement(CapacityRequirement object)
      {
        return createCapacityRequirementAdapter();
      }
      @Override
      public Adapter caseReliablityRequirement(ReliablityRequirement object)
      {
        return createReliablityRequirementAdapter();
      }
      @Override
      public Adapter caseAccuracyRequirement(AccuracyRequirement object)
      {
        return createAccuracyRequirementAdapter();
      }
      @Override
      public Adapter caseLogRequirement(LogRequirement object)
      {
        return createLogRequirementAdapter();
      }
      @Override
      public Adapter casePercentile(Percentile object)
      {
        return createPercentileAdapter();
      }
      @Override
      public Adapter caseSecurityRequirement(SecurityRequirement object)
      {
        return createSecurityRequirementAdapter();
      }
      @Override
      public Adapter caseAuthenticationRequirement(AuthenticationRequirement object)
      {
        return createAuthenticationRequirementAdapter();
      }
      @Override
      public Adapter caseAuthToken(AuthToken object)
      {
        return createAuthTokenAdapter();
      }
      @Override
      public Adapter caseHashAlgorithm(HashAlgorithm object)
      {
        return createHashAlgorithmAdapter();
      }
      @Override
      public Adapter caseSigningRequirement(SigningRequirement object)
      {
        return createSigningRequirementAdapter();
      }
      @Override
      public Adapter caseMessagePartRef(MessagePartRef object)
      {
        return createMessagePartRefAdapter();
      }
      @Override
      public Adapter caseEncryptionRequirement(EncryptionRequirement object)
      {
        return createEncryptionRequirementAdapter();
      }
      @Override
      public Adapter casePriorityDeclaration(PriorityDeclaration object)
      {
        return createPriorityDeclarationAdapter();
      }
      @Override
      public Adapter caseEscalation(Escalation object)
      {
        return createEscalationAdapter();
      }
      @Override
      public Adapter caseParty(Party object)
      {
        return createPartyAdapter();
      }
      @Override
      public Adapter caseCustomerParty(CustomerParty object)
      {
        return createCustomerPartyAdapter();
      }
      @Override
      public Adapter caseProviderParty(ProviderParty object)
      {
        return createProviderPartyAdapter();
      }
      @Override
      public Adapter caseThirdParty(ThirdParty object)
      {
        return createThirdPartyAdapter();
      }
      @Override
      public Adapter caseRepresentative(Representative object)
      {
        return createRepresentativeAdapter();
      }
      @Override
      public Adapter caseUserRef(UserRef object)
      {
        return createUserRefAdapter();
      }
      @Override
      public Adapter caseInlineRepresentative(InlineRepresentative object)
      {
        return createInlineRepresentativeAdapter();
      }
      @Override
      public Adapter caseResponsibility(Responsibility object)
      {
        return createResponsibilityAdapter();
      }
      @Override
      public Adapter caseReport(Report object)
      {
        return createReportAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.SlaModel <em>Sla Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.SlaModel
   * @generated
   */
  public Adapter createSlaModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.SLA <em>SLA</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.SLA
   * @generated
   */
  public Adapter createSLAAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.Cost <em>Cost</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.Cost
   * @generated
   */
  public Adapter createCostAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.ServiceQualityProperty <em>Service Quality Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.ServiceQualityProperty
   * @generated
   */
  public Adapter createServiceQualityPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.Availability <em>Availability</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.Availability
   * @generated
   */
  public Adapter createAvailabilityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.Throughput <em>Throughput</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.Throughput
   * @generated
   */
  public Adapter createThroughputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.Latency <em>Latency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.Latency
   * @generated
   */
  public Adapter createLatencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.MaxDownTime <em>Max Down Time</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.MaxDownTime
   * @generated
   */
  public Adapter createMaxDownTimeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement <em>Capacity Requirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.CapacityRequirement
   * @generated
   */
  public Adapter createCapacityRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.ReliablityRequirement <em>Reliablity Requirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.ReliablityRequirement
   * @generated
   */
  public Adapter createReliablityRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.AccuracyRequirement <em>Accuracy Requirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.AccuracyRequirement
   * @generated
   */
  public Adapter createAccuracyRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.LogRequirement <em>Log Requirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.LogRequirement
   * @generated
   */
  public Adapter createLogRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.Percentile <em>Percentile</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.Percentile
   * @generated
   */
  public Adapter createPercentileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.SecurityRequirement <em>Security Requirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.SecurityRequirement
   * @generated
   */
  public Adapter createSecurityRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement <em>Authentication Requirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement
   * @generated
   */
  public Adapter createAuthenticationRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.AuthToken <em>Auth Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.AuthToken
   * @generated
   */
  public Adapter createAuthTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.HashAlgorithm <em>Hash Algorithm</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.HashAlgorithm
   * @generated
   */
  public Adapter createHashAlgorithmAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.SigningRequirement <em>Signing Requirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.SigningRequirement
   * @generated
   */
  public Adapter createSigningRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.MessagePartRef <em>Message Part Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.MessagePartRef
   * @generated
   */
  public Adapter createMessagePartRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.EncryptionRequirement <em>Encryption Requirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.EncryptionRequirement
   * @generated
   */
  public Adapter createEncryptionRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.PriorityDeclaration <em>Priority Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.PriorityDeclaration
   * @generated
   */
  public Adapter createPriorityDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.Escalation <em>Escalation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.Escalation
   * @generated
   */
  public Adapter createEscalationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.Party <em>Party</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.Party
   * @generated
   */
  public Adapter createPartyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.CustomerParty <em>Customer Party</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.CustomerParty
   * @generated
   */
  public Adapter createCustomerPartyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.ProviderParty <em>Provider Party</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.ProviderParty
   * @generated
   */
  public Adapter createProviderPartyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.ThirdParty <em>Third Party</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.ThirdParty
   * @generated
   */
  public Adapter createThirdPartyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.Representative <em>Representative</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.Representative
   * @generated
   */
  public Adapter createRepresentativeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.UserRef <em>User Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.UserRef
   * @generated
   */
  public Adapter createUserRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.InlineRepresentative <em>Inline Representative</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.InlineRepresentative
   * @generated
   */
  public Adapter createInlineRepresentativeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.Responsibility <em>Responsibility</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.Responsibility
   * @generated
   */
  public Adapter createResponsibilityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.fornax.soa.sladsl.sLADsl.Report <em>Report</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.fornax.soa.sladsl.sLADsl.Report
   * @generated
   */
  public Adapter createReportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //SLADslAdapterFactory
