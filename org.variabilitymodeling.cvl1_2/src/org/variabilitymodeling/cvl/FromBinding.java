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
 * A representation of the model object '<em><b>From Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.FromBinding#getFromPlacement <em>From Placement</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.FromBinding#getFromReplacement <em>From Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getFromBinding()
 * @model annotation="doc description='FromBinding defines a binding between boundary elements of kind FromPlacement/FromReplacement.\r\n\r\nThe FromPlacement boundary element that has to be bound to the FromPlacement.' semantics='The semantics of the Placement Fragment can be found under Fragment Substitution.'"
 * @generated
 */
public interface FromBinding extends BoundaryElementBinding {
	/**
	 * Returns the value of the '<em><b>From Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Placement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Placement</em>' reference.
	 * @see #setFromPlacement(FromPlacement)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFromBinding_FromPlacement()
	 * @model required="true"
	 *        annotation="doc description='Specifies the FromPlacement boundary element that is part of the binding.'"
	 * @generated
	 */
	FromPlacement getFromPlacement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.FromBinding#getFromPlacement <em>From Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Placement</em>' reference.
	 * @see #getFromPlacement()
	 * @generated
	 */
	void setFromPlacement(FromPlacement value);

	/**
	 * Returns the value of the '<em><b>From Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Replacement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Replacement</em>' reference.
	 * @see #setFromReplacement(FromReplacement)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFromBinding_FromReplacement()
	 * @model required="true"
	 *        annotation="doc description='Specifies the FromReplacement boundary element that is part of the binding.'"
	 * @generated
	 */
	FromReplacement getFromReplacement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.FromBinding#getFromReplacement <em>From Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Replacement</em>' reference.
	 * @see #getFromReplacement()
	 * @generated
	 */
	void setFromReplacement(FromReplacement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitFromBinding(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitFromBinding(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // FromBinding
