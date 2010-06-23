/**
 * <copyright>
 * </copyright>
 *
 */
package org.elysium.lilyPond;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheme Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.elysium.lilyPond.SchemeExpression#isQuoted <em>Quoted</em>}</li>
 *   <li>{@link org.elysium.lilyPond.SchemeExpression#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.elysium.lilyPond.LilyPondPackage#getSchemeExpression()
 * @model
 * @generated
 */
public interface SchemeExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Quoted</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quoted</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quoted</em>' attribute.
   * @see #setQuoted(boolean)
   * @see org.elysium.lilyPond.LilyPondPackage#getSchemeExpression_Quoted()
   * @model
   * @generated
   */
  boolean isQuoted();

  /**
   * Sets the value of the '{@link org.elysium.lilyPond.SchemeExpression#isQuoted <em>Quoted</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quoted</em>' attribute.
   * @see #isQuoted()
   * @generated
   */
  void setQuoted(boolean value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(SchemeValue)
   * @see org.elysium.lilyPond.LilyPondPackage#getSchemeExpression_Value()
   * @model containment="true"
   * @generated
   */
  SchemeValue getValue();

  /**
   * Sets the value of the '{@link org.elysium.lilyPond.SchemeExpression#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(SchemeValue value);

} // SchemeExpression