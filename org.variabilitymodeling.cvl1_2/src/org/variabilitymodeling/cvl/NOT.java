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
 * A representation of the model object '<em><b>NOT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.NOT#getTerm <em>Term</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getNOT()
 * @model annotation="doc description='Specifies an NOT expression.' semantics='Negates the evaluation of the expression.'"
 * @generated
 */
public interface NOT extends Constraint {
	/**
	 * Returns the value of the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Term</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term</em>' containment reference.
	 * @see #setTerm(Constraint)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getNOT_Term()
	 * @model containment="true" required="true"
	 *        annotation="doc description='Left side of expression.'"
	 * @generated
	 */
	Constraint getTerm();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.NOT#getTerm <em>Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' containment reference.
	 * @see #getTerm()
	 * @generated
	 */
	void setTerm(Constraint value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitNOT(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitNOT(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // NOT
