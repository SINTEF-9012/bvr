/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;

import org.eclipse.emf.common.util.EList;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replacement Fragment Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ReplacementFragmentBinding#getBoundaryElementBinding <em>Boundary Element Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getReplacementFragmentBinding()
 * @model
 * @generated
 */
public interface ReplacementFragmentBinding extends CVLNamedElement {
	/**
	 * Returns the value of the '<em><b>Boundary Element Binding</b></em>' containment reference list.
	 * The list contents are of type {@link org.variabilitymodeling.cvl.BoundaryElementBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boundary Element Binding</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boundary Element Binding</em>' containment reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getReplacementFragmentBinding_BoundaryElementBinding()
	 * @model containment="true"
	 * @generated
	 */
	EList<BoundaryElementBinding> getBoundaryElementBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitReplacementFragmentBinding(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitReplacementFragmentBinding(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ReplacementFragmentBinding
