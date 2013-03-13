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
 * A representation of the literals of the enumeration '<em><b>Auth Token Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAuthTokenKind()
 * @model
 * @generated
 */
public enum AuthTokenKind implements Enumerator
{
  /**
   * The '<em><b>Username Password</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #USERNAME_PASSWORD_VALUE
   * @generated
   * @ordered
   */
  USERNAME_PASSWORD(0, "UsernamePassword", "UsernamePassword"),

  /**
   * The '<em><b>SAML</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SAML_VALUE
   * @generated
   * @ordered
   */
  SAML(1, "SAML", "SAML"),

  /**
   * The '<em><b>SAML2</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SAML2_VALUE
   * @generated
   * @ordered
   */
  SAML2(2, "SAML2", "SAML2"),

  /**
   * The '<em><b>Kerberos</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #KERBEROS_VALUE
   * @generated
   * @ordered
   */
  KERBEROS(3, "Kerberos", "Kerberos"),

  /**
   * The '<em><b>SPNEGO</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SPNEGO_VALUE
   * @generated
   * @ordered
   */
  SPNEGO(4, "SPNEGO", "SPNEGO"),

  /**
   * The '<em><b>REL Token</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REL_TOKEN_VALUE
   * @generated
   * @ordered
   */
  REL_TOKEN(5, "RELToken", "RELToken"),

  /**
   * The '<em><b>X509 Certificate</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #X509_CERTIFICATE_VALUE
   * @generated
   * @ordered
   */
  X509_CERTIFICATE(6, "X509Certificate", "X509Certificate"),

  /**
   * The '<em><b>OAuth</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OAUTH_VALUE
   * @generated
   * @ordered
   */
  OAUTH(7, "OAuth", "OAuth"),

  /**
   * The '<em><b>OAuth2</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OAUTH2_VALUE
   * @generated
   * @ordered
   */
  OAUTH2(8, "OAuth2", "OAuth2");

  /**
   * The '<em><b>Username Password</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Username Password</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #USERNAME_PASSWORD
   * @model name="UsernamePassword"
   * @generated
   * @ordered
   */
  public static final int USERNAME_PASSWORD_VALUE = 0;

  /**
   * The '<em><b>SAML</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SAML</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SAML
   * @model
   * @generated
   * @ordered
   */
  public static final int SAML_VALUE = 1;

  /**
   * The '<em><b>SAML2</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SAML2</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SAML2
   * @model
   * @generated
   * @ordered
   */
  public static final int SAML2_VALUE = 2;

  /**
   * The '<em><b>Kerberos</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Kerberos</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #KERBEROS
   * @model name="Kerberos"
   * @generated
   * @ordered
   */
  public static final int KERBEROS_VALUE = 3;

  /**
   * The '<em><b>SPNEGO</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SPNEGO</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SPNEGO
   * @model
   * @generated
   * @ordered
   */
  public static final int SPNEGO_VALUE = 4;

  /**
   * The '<em><b>REL Token</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REL Token</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REL_TOKEN
   * @model name="RELToken"
   * @generated
   * @ordered
   */
  public static final int REL_TOKEN_VALUE = 5;

  /**
   * The '<em><b>X509 Certificate</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>X509 Certificate</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #X509_CERTIFICATE
   * @model name="X509Certificate"
   * @generated
   * @ordered
   */
  public static final int X509_CERTIFICATE_VALUE = 6;

  /**
   * The '<em><b>OAuth</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OAuth</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OAUTH
   * @model name="OAuth"
   * @generated
   * @ordered
   */
  public static final int OAUTH_VALUE = 7;

  /**
   * The '<em><b>OAuth2</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>OAuth2</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OAUTH2
   * @model name="OAuth2"
   * @generated
   * @ordered
   */
  public static final int OAUTH2_VALUE = 8;

  /**
   * An array of all the '<em><b>Auth Token Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AuthTokenKind[] VALUES_ARRAY =
    new AuthTokenKind[]
    {
      USERNAME_PASSWORD,
      SAML,
      SAML2,
      KERBEROS,
      SPNEGO,
      REL_TOKEN,
      X509_CERTIFICATE,
      OAUTH,
      OAUTH2,
    };

  /**
   * A public read-only list of all the '<em><b>Auth Token Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AuthTokenKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Auth Token Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AuthTokenKind get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AuthTokenKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Auth Token Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AuthTokenKind getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AuthTokenKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Auth Token Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AuthTokenKind get(int value)
  {
    switch (value)
    {
      case USERNAME_PASSWORD_VALUE: return USERNAME_PASSWORD;
      case SAML_VALUE: return SAML;
      case SAML2_VALUE: return SAML2;
      case KERBEROS_VALUE: return KERBEROS;
      case SPNEGO_VALUE: return SPNEGO;
      case REL_TOKEN_VALUE: return REL_TOKEN;
      case X509_CERTIFICATE_VALUE: return X509_CERTIFICATE;
      case OAUTH_VALUE: return OAUTH;
      case OAUTH2_VALUE: return OAUTH2;
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
  private AuthTokenKind(int value, String name, String literal)
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
  
} //AuthTokenKind
