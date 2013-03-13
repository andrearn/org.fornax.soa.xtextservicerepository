/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Reliablility Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getReliablilityKind()
 * @model
 * @generated
 */
public enum ReliablilityKind implements Enumerator
{
  /**
   * The '<em><b>EXACTLY ONCE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXACTLY_ONCE_VALUE
   * @generated
   * @ordered
   */
  EXACTLY_ONCE(0, "EXACTLY_ONCE", "exactly-once"),

  /**
   * The '<em><b>AT MOST ONCE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AT_MOST_ONCE_VALUE
   * @generated
   * @ordered
   */
  AT_MOST_ONCE(1, "AT_MOST_ONCE", "at-most-once"),

  /**
   * The '<em><b>AT LEAST ONCE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AT_LEAST_ONCE_VALUE
   * @generated
   * @ordered
   */
  AT_LEAST_ONCE(2, "AT_LEAST_ONCE", "at-least-once"),

  /**
   * The '<em><b>BEST EFFORT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BEST_EFFORT_VALUE
   * @generated
   * @ordered
   */
  BEST_EFFORT(3, "BEST_EFFORT", "best-effort");

  /**
   * The '<em><b>EXACTLY ONCE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EXACTLY ONCE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EXACTLY_ONCE
   * @model literal="exactly-once"
   * @generated
   * @ordered
   */
  public static final int EXACTLY_ONCE_VALUE = 0;

  /**
   * The '<em><b>AT MOST ONCE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AT MOST ONCE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AT_MOST_ONCE
   * @model literal="at-most-once"
   * @generated
   * @ordered
   */
  public static final int AT_MOST_ONCE_VALUE = 1;

  /**
   * The '<em><b>AT LEAST ONCE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AT LEAST ONCE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AT_LEAST_ONCE
   * @model literal="at-least-once"
   * @generated
   * @ordered
   */
  public static final int AT_LEAST_ONCE_VALUE = 2;

  /**
   * The '<em><b>BEST EFFORT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BEST EFFORT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BEST_EFFORT
   * @model literal="best-effort"
   * @generated
   * @ordered
   */
  public static final int BEST_EFFORT_VALUE = 3;

  /**
   * An array of all the '<em><b>Reliablility Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ReliablilityKind[] VALUES_ARRAY =
    new ReliablilityKind[]
    {
      EXACTLY_ONCE,
      AT_MOST_ONCE,
      AT_LEAST_ONCE,
      BEST_EFFORT,
    };

  /**
   * A public read-only list of all the '<em><b>Reliablility Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ReliablilityKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Reliablility Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ReliablilityKind get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ReliablilityKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Reliablility Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ReliablilityKind getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ReliablilityKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Reliablility Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ReliablilityKind get(int value)
  {
    switch (value)
    {
      case EXACTLY_ONCE_VALUE: return EXACTLY_ONCE;
      case AT_MOST_ONCE_VALUE: return AT_MOST_ONCE;
      case AT_LEAST_ONCE_VALUE: return AT_LEAST_ONCE;
      case BEST_EFFORT_VALUE: return BEST_EFFORT;
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
  private ReliablilityKind(int value, String name, String literal)
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
  
} //ReliablilityKind
