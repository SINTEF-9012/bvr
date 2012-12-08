/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.Binary#getLeft <em>Left</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.Binary#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getBinary()
 * @model abstract="true"
 *        annotation="doc description='Specifies a binary expression.' semantics='The semantics of Binary is given by the specializations.'"
 * @generated
 */
public interface Binary extends Constraint {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Constraint)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getBinary_Left()
	 * @model containment="true" required="true"
	 *        annotation="doc description='Left side of expression.'"
	 * @generated
	 */
	Constraint getLeft();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Binary#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Constraint value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Constraint)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getBinary_Right()
	 * @model containment="true" required="true"
	 *        annotation="doc description='Right side of expression.'"
	 * @generated
	 */
	Constraint getRight();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Binary#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Constraint value);

} // Binary
