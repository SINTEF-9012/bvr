/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;

import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.Assignment#getValue <em>Value</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.Assignment#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getAssignment()
 * @model annotation="doc description='Assign an instance of a replacement fragment to a ReplacementFragmentReference.' semantics='The target ReplacementFragmentReference is assigned the value.' constraint='The target and value have to be of the same kind of replacement fragment.'"
 * @generated
 */
public interface Assignment extends ExecutablePrimitive {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(ReplacementFragmentAbstract)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getAssignment_Value()
	 * @model required="true"
	 *        annotation="doc description='The value to be assigned to the target.'"
	 * @generated
	 */
	ReplacementFragmentAbstract getValue();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Assignment#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ReplacementFragmentAbstract value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ReplacementFragmentReference)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getAssignment_Target()
	 * @model required="true"
	 *        annotation="doc description='The ReplacementFragmentReference to be assigned a value.'"
	 * @generated
	 */
	ReplacementFragmentReference getTarget();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.Assignment#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ReplacementFragmentReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitAssignment(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitAssignment(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // Assignment
