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
 * A representation of the literals of the enumeration '<em><b>Hash Alg Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getHashAlgKind()
 * @model
 * @generated
 */
public enum HashAlgKind implements Enumerator
{
  /**
   * The '<em><b>MD5</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MD5_VALUE
   * @generated
   * @ordered
   */
  MD5(0, "MD5", "MD5"),

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
   * The '<em><b>RSA</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RSA_VALUE
   * @generated
   * @ordered
   */
  RSA(3, "RSA", "RSA"),

  /**
   * The '<em><b>Plain Text</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PLAIN_TEXT_VALUE
   * @generated
   * @ordered
   */
  PLAIN_TEXT(4, "PlainText", "PlainText");

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
  public static final int MD5_VALUE = 0;

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
   * The '<em><b>RSA</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RSA</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RSA
   * @model
   * @generated
   * @ordered
   */
  public static final int RSA_VALUE = 3;

  /**
   * The '<em><b>Plain Text</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Plain Text</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PLAIN_TEXT
   * @model name="PlainText"
   * @generated
   * @ordered
   */
  public static final int PLAIN_TEXT_VALUE = 4;

  /**
   * An array of all the '<em><b>Hash Alg Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final HashAlgKind[] VALUES_ARRAY =
    new HashAlgKind[]
    {
      MD5,
      SHA1,
      SHA256,
      RSA,
      PLAIN_TEXT,
    };

  /**
   * A public read-only list of all the '<em><b>Hash Alg Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<HashAlgKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Hash Alg Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static HashAlgKind get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      HashAlgKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Hash Alg Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static HashAlgKind getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      HashAlgKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Hash Alg Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static HashAlgKind get(int value)
  {
    switch (value)
    {
      case MD5_VALUE: return MD5;
      case SHA1_VALUE: return SHA1;
      case SHA256_VALUE: return SHA256;
      case RSA_VALUE: return RSA;
      case PLAIN_TEXT_VALUE: return PLAIN_TEXT;
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
  private HashAlgKind(int value, String name, String literal)
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
  
} //HashAlgKind
