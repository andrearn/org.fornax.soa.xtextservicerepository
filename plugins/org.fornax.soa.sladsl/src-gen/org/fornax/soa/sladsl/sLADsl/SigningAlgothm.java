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
 * A representation of the literals of the enumeration '<em><b>Signing Algothm</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getSigningAlgothm()
 * @model
 * @generated
 */
public enum SigningAlgothm implements Enumerator
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
   * The '<em><b>SHA1</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SHA1_VALUE
   * @generated
   * @ordered
   */
  SHA1(1, "SHA1", "SHA1"),

  /**
   * The '<em><b>SHA256</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SHA256_VALUE
   * @generated
   * @ordered
   */
  SHA256(2, "SHA256", "SHA256"),

  /**
   * The '<em><b>MD5</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MD5_VALUE
   * @generated
   * @ordered
   */
  MD5(3, "MD5", "MD5"),

  /**
   * The '<em><b>RSA 15</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RSA_15_VALUE
   * @generated
   * @ordered
   */
  RSA_15(4, "RSA_1_5", "RSA_1_5"),

  /**
   * The '<em><b>AES128</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AES128_VALUE
   * @generated
   * @ordered
   */
  AES128(5, "AES128", "AES128"),

  /**
   * The '<em><b>AES192</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AES192_VALUE
   * @generated
   * @ordered
   */
  AES192(6, "AES192", "AES192"),

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
   * The '<em><b>SHA1</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SHA1</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SHA1
   * @model
   * @generated
   * @ordered
   */
  public static final int SHA1_VALUE = 1;

  /**
   * The '<em><b>SHA256</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SHA256</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SHA256
   * @model
   * @generated
   * @ordered
   */
  public static final int SHA256_VALUE = 2;

  /**
   * The '<em><b>MD5</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MD5</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MD5
   * @model
   * @generated
   * @ordered
   */
  public static final int MD5_VALUE = 3;

  /**
   * The '<em><b>RSA 15</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RSA 15</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RSA_15
   * @model name="RSA_1_5"
   * @generated
   * @ordered
   */
  public static final int RSA_15_VALUE = 4;

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
  public static final int AES128_VALUE = 5;

  /**
   * The '<em><b>AES192</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AES192</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AES192
   * @model
   * @generated
   * @ordered
   */
  public static final int AES192_VALUE = 6;

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
   * An array of all the '<em><b>Signing Algothm</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final SigningAlgothm[] VALUES_ARRAY =
    new SigningAlgothm[]
    {
      NONE,
      SHA1,
      SHA256,
      MD5,
      RSA_15,
      AES128,
      AES192,
      AES256,
    };

  /**
   * A public read-only list of all the '<em><b>Signing Algothm</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<SigningAlgothm> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Signing Algothm</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SigningAlgothm get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SigningAlgothm result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Signing Algothm</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SigningAlgothm getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SigningAlgothm result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Signing Algothm</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SigningAlgothm get(int value)
  {
    switch (value)
    {
      case NONE_VALUE: return NONE;
      case SHA1_VALUE: return SHA1;
      case SHA256_VALUE: return SHA256;
      case MD5_VALUE: return MD5;
      case RSA_15_VALUE: return RSA_15;
      case AES128_VALUE: return AES128;
      case AES192_VALUE: return AES192;
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
  private SigningAlgothm(int value, String name, String literal)
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
  
} //SigningAlgothm
