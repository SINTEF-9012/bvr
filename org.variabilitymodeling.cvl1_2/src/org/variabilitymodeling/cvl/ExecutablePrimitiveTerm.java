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
 * A representation of the model object '<em><b>Executable Primitive Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ExecutablePrimitiveTerm#getPrimitive <em>Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getExecutablePrimitiveTerm()
 * @model annotation="doc description='Specifies an ExecutablePrimitive.' semantics='The referred ExecutablePrimitive is used in the expression.'"
 * @generated
 */
public interface ExecutablePrimitiveTerm extends Constraint {
	/**
	 * Returns the value of the '<em><b>Primitive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive</em>' reference.
	 * @see #setPrimitive(ExecutablePrimitive)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getExecutablePrimitiveTerm_Primitive()
	 * @model required="true"
	 *        annotation="doc description='Reference to an executable primitive.'"
	 * @generated
	 */
	ExecutablePrimitive getPrimitive();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ExecutablePrimitiveTerm#getPrimitive <em>Primitive</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive</em>' reference.
	 * @see #getPrimitive()
	 * @generated
	 */
	void setPrimitive(ExecutablePrimitive value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitExecutablePrimitiveTerm(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitExecutablePrimitiveTerm(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ExecutablePrimitiveTerm
