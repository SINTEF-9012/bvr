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
 * A representation of the model object '<em><b>To Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ToBinding#getToPlacement <em>To Placement</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.ToBinding#getToReplacement <em>To Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getToBinding()
 * @model annotation="doc description='ToBinding defines a binding between boundary elements of kind  ToPlacement/ToReplacement.\r\n\r\nThe ToPlacement boundary element has to be bound to the ToReplacement.' semantics='The semantics of the Placement Fragment can be found under Fragment Substitution.'"
 * @generated
 */
public interface ToBinding extends BoundaryElementBinding {
	/**
	 * Returns the value of the '<em><b>To Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Placement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Placement</em>' reference.
	 * @see #setToPlacement(ToPlacement)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getToBinding_ToPlacement()
	 * @model required="true"
	 *        annotation="doc description='Specifies the ToPlacement boundary element that is part of the binding.'"
	 * @generated
	 */
	ToPlacement getToPlacement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ToBinding#getToPlacement <em>To Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Placement</em>' reference.
	 * @see #getToPlacement()
	 * @generated
	 */
	void setToPlacement(ToPlacement value);

	/**
	 * Returns the value of the '<em><b>To Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Replacement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Replacement</em>' reference.
	 * @see #setToReplacement(ToReplacement)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getToBinding_ToReplacement()
	 * @model required="true"
	 *        annotation="doc description='Specifies the ToReplacement boundary element that is part of the binding.'"
	 * @generated
	 */
	ToReplacement getToReplacement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ToBinding#getToReplacement <em>To Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Replacement</em>' reference.
	 * @see #getToReplacement()
	 * @generated
	 */
	void setToReplacement(ToReplacement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitToBinding(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitToBinding(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ToBinding
