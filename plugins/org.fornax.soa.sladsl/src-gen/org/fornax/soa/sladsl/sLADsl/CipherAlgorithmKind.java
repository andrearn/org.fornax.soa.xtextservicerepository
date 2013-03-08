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
 * A representation of the literals of the enumeration '<em><b>Cipher Algorithm Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCipherAlgorithmKind()
 * @model
 * @generated
 */
public enum CipherAlgorithmKind implements Enumerator
{
  /**
   * The '<em><b>NONE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NONE_VALUE
   * @generated
   * @ordered
   */
  NONE(0, "NONE", "NONE"),

  /**
   * The '<em><b>Basic128</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BASIC128_VALUE
   * @generated
   * @ordered
   */
  BASIC128(1, "Basic128", "Basic128"),

  /**
   * The '<em><b>Basic192</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BASIC192_VALUE
   * @generated
   * @ordered
   */
  BASIC192(2, "Basic192", "Basic192"),

  /**
   * The '<em><b>Basic256</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BASIC256_VALUE
   * @generated
   * @ordered
   */
  BASIC256(3, "Basic256", "Basic256"),

  /**
   * The '<em><b>DES</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DES_VALUE
   * @generated
   * @ordered
   */
  DES(4, "DES", "DES"),

  /**
   * The '<em><b>TRIPLE DES</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TRIPLE_DES_VALUE
   * @generated
   * @ordered
   */
  TRIPLE_DES(5, "TRIPLE_DES", "3DES"),

  /**
   * The '<em><b>AES128</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AES128_VALUE
   * @generated
   * @ordered
   */
  AES128(6, "AES128", "AES128"),

  /**
   * The '<em><b>AES256</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AES256_VALUE
   * @generated
   * @ordered
   */
  AES256(7, "AES256", "AES256");

  /**
   * The '<em><b>NONE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NONE
   * @model
   * @generated
   * @ordered
   */
  public static final int NONE_VALUE = 0;

  /**
   * The '<em><b>Basic128</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Basic128</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BASIC128
   * @model name="Basic128"
   * @generated
   * @ordered
   */
  public static final int BASIC128_VALUE = 1;

  /**
   * The '<em><b>Basic192</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Basic192</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BASIC192
   * @model name="Basic192"
   * @generated
   * @ordered
   */
  public static final int BASIC192_VALUE = 2;

  /**
   * The '<em><b>Basic256</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Basic256</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BASIC256
   * @model name="Basic256"
   * @generated
   * @ordered
   */
  public static final int BASIC256_VALUE = 3;

  /**
   * The '<em><b>DES</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DES
   * @model
   * @generated
   * @ordered
   */
  public static final int DES_VALUE = 4;

  /**
   * The '<em><b>TRIPLE DES</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TRIPLE DES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TRIPLE_DES
   * @model literal="3DES"
   * @generated
   * @ordered
   */
  public static final int TRIPLE_DES_VALUE = 5;

  /**
   * The '<em><b>AES128</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AES128</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AES128
   * @model
   * @generated
   * @ordered
   */
  public static final int AES128_VALUE = 6;

  /**
   * The '<em><b>AES256</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AES256</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AES256
   * @model
   * @generated
   * @ordered
   */
  public static final int AES256_VALUE = 7;

  /**
   * An array of all the '<em><b>Cipher Algorithm Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final CipherAlgorithmKind[] VALUES_ARRAY =
    new CipherAlgorithmKind[]
    {
      NONE,
      BASIC128,
      BASIC192,
      BASIC256,
      DES,
      TRIPLE_DES,
      AES128,
      AES256,
    };

  /**
   * A public read-only list of all the '<em><b>Cipher Algorithm Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<CipherAlgorithmKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Cipher Algorithm Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CipherAlgorithmKind get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      CipherAlgorithmKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Cipher Algorithm Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CipherAlgorithmKind getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      CipherAlgorithmKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Cipher Algorithm Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CipherAlgorithmKind get(int value)
  {
    switch (value)
    {
      case NONE_VALUE: return NONE;
      case BASIC128_VALUE: return BASIC128;
      case BASIC192_VALUE: return BASIC192;
      case BASIC256_VALUE: return BASIC256;
      case DES_VALUE: return DES;
      case TRIPLE_DES_VALUE: return TRIPLE_DES;
      case AES128_VALUE: return AES128;
      case AES256_VALUE: return AES256;
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
  private CipherAlgorithmKind(int value, String name, String literal)
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
  
} //CipherAlgorithmKind
