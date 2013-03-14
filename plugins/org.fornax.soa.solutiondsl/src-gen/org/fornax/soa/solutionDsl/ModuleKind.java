/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.solutionDsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Module Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getModuleKind()
 * @model
 * @generated
 */
public enum ModuleKind implements Enumerator
{
  /**
   * The '<em><b>UI</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UI_VALUE
   * @generated
   * @ordered
   */
  UI(0, "UI", "UI"),

  /**
   * The '<em><b>Business Logic</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BUSINESS_LOGIC_VALUE
   * @generated
   * @ordered
   */
  BUSINESS_LOGIC(1, "BusinessLogic", "BusinessLogic"),

  /**
   * The '<em><b>Persistence</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PERSISTENCE_VALUE
   * @generated
   * @ordered
   */
  PERSISTENCE(2, "Persistence", "Persistence"),

  /**
   * The '<em><b>Security</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SECURITY_VALUE
   * @generated
   * @ordered
   */
  SECURITY(3, "Security", "Security"),

  /**
   * The '<em><b>Batch</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BATCH_VALUE
   * @generated
   * @ordered
   */
  BATCH(4, "Batch", "Batch"),

  /**
   * The '<em><b>OTHER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OTHER_VALUE
   * @generated
   * @ordered
   */
  OTHER(5, "OTHER", "OTHER");

  /**
   * The '<em><b>UI</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UI</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UI
   * @model
   * @generated
   * @ordered
   */
  public static final int UI_VALUE = 0;

  /**
   * The '<em><b>Business Logic</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Business Logic</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BUSINESS_LOGIC
   * @model name="BusinessLogic"
   * @generated
   * @ordered
   */
  public static final int BUSINESS_LOGIC_VALUE = 1;

  /**
   * The '<em><b>Persistence</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Persistence</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PERSISTENCE
   * @model name="Persistence"
   * @generated
   * @ordered
   */
  public static final int PERSISTENCE_VALUE = 2;

  /**
   * The '<em><b>Security</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Security</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SECURITY
   * @model name="Security"
   * @generated
   * @ordered
   */
  public static final int SECURITY_VALUE = 3;

  /**
   * The '<em><b>Batch</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Batch</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BATCH
   * @model name="Batch"
   * @generated
   * @ordered
   */
  public static final int BATCH_VALUE = 4;

  /**
   * The '<em><b>OTHER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OTHER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OTHER
   * @model
   * @generated
   * @ordered
   */
  public static final int OTHER_VALUE = 5;

  /**
   * An array of all the '<em><b>Module Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ModuleKind[] VALUES_ARRAY =
    new ModuleKind[]
    {
      UI,
      BUSINESS_LOGIC,
      PERSISTENCE,
      SECURITY,
      BATCH,
      OTHER,
    };

  /**
   * A public read-only list of all the '<em><b>Module Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ModuleKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Module Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModuleKind get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ModuleKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Module Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModuleKind getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ModuleKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Module Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModuleKind get(int value)
  {
    switch (value)
    {
      case UI_VALUE: return UI;
      case BUSINESS_LOGIC_VALUE: return BUSINESS_LOGIC;
      case PERSISTENCE_VALUE: return PERSISTENCE;
      case SECURITY_VALUE: return SECURITY;
      case BATCH_VALUE: return BATCH;
      case OTHER_VALUE: return OTHER;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private ModuleKind(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //ModuleKind
