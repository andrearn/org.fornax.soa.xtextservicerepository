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
 * A representation of the literals of the enumeration '<em><b>Message Part Ref Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getMessagePartRefKind()
 * @model
 * @generated
 */
public enum MessagePartRefKind implements Enumerator
{
  /**
   * The '<em><b>Header</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HEADER_VALUE
   * @generated
   * @ordered
   */
  HEADER(0, "header", "header"),

  /**
   * The '<em><b>Body</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BODY_VALUE
   * @generated
   * @ordered
   */
  BODY(1, "body", "body"),

  /**
   * The '<em><b>Attachments</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ATTACHMENTS_VALUE
   * @generated
   * @ordered
   */
  ATTACHMENTS(2, "attachments", "attachments"),

  /**
   * The '<em><b>All</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ALL_VALUE
   * @generated
   * @ordered
   */
  ALL(3, "all", "all"),

  /**
   * The '<em><b>Expression</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXPRESSION_VALUE
   * @generated
   * @ordered
   */
  EXPRESSION(4, "expression", "expression");

  /**
   * The '<em><b>Header</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Header</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HEADER
   * @model name="header"
   * @generated
   * @ordered
   */
  public static final int HEADER_VALUE = 0;

  /**
   * The '<em><b>Body</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Body</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BODY
   * @model name="body"
   * @generated
   * @ordered
   */
  public static final int BODY_VALUE = 1;

  /**
   * The '<em><b>Attachments</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Attachments</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ATTACHMENTS
   * @model name="attachments"
   * @generated
   * @ordered
   */
  public static final int ATTACHMENTS_VALUE = 2;

  /**
   * The '<em><b>All</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>All</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ALL
   * @model name="all"
   * @generated
   * @ordered
   */
  public static final int ALL_VALUE = 3;

  /**
   * The '<em><b>Expression</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Expression</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EXPRESSION
   * @model name="expression"
   * @generated
   * @ordered
   */
  public static final int EXPRESSION_VALUE = 4;

  /**
   * An array of all the '<em><b>Message Part Ref Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final MessagePartRefKind[] VALUES_ARRAY =
    new MessagePartRefKind[]
    {
      HEADER,
      BODY,
      ATTACHMENTS,
      ALL,
      EXPRESSION,
    };

  /**
   * A public read-only list of all the '<em><b>Message Part Ref Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<MessagePartRefKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Message Part Ref Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MessagePartRefKind get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      MessagePartRefKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Message Part Ref Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MessagePartRefKind getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      MessagePartRefKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Message Part Ref Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MessagePartRefKind get(int value)
  {
    switch (value)
    {
      case HEADER_VALUE: return HEADER;
      case BODY_VALUE: return BODY;
      case ATTACHMENTS_VALUE: return ATTACHMENTS;
      case ALL_VALUE: return ALL;
      case EXPRESSION_VALUE: return EXPRESSION;
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
  private MessagePartRefKind(int value, String name, String literal)
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
  
} //MessagePartRefKind
