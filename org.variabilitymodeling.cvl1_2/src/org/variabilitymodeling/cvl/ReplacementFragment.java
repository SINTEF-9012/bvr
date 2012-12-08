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
 * A representation of the model object '<em><b>Replacement Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ReplacementFragment#getBoundaryElement <em>Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.ReplacementFragment#getPlacements <em>Placements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getReplacementFragment()
 * @model annotation="doc description='Replacement Fragment defines a fragment of the base model that will be used as replacement for some placement fragment of the base model.' semantics='The semantics of Replacement Fragment can be found under Fragment Substitution.' constraint='The pla\tcements contained in a replacement fragments should only involve model elements which are inside the replacement fragment. These placements can be used in all instances of a the replacement fragment.'"
 * @generated
 */
public interface ReplacementFragment extends CVLNamedElement, ReplacementFragmentAbstract {
	/**
	 * Returns the value of the '<em><b>Boundary Element</b></em>' containment reference list.
	 * The list contents are of type {@link org.variabilitymodeling.cvl.ReplacementBoundaryElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boundary Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boundary Element</em>' containment reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getReplacementFragment_BoundaryElement()
	 * @model containment="true"
	 *        annotation="doc description='The boundary elements captures all the relations from and to the fragment.'"
	 * @generated
	 */
	EList<ReplacementBoundaryElement> getBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Placements</b></em>' containment reference list.
	 * The list contents are of type {@link org.variabilitymodeling.cvl.PlacementLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placements</em>' containment reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getReplacementFragment_Placements()
	 * @model containment="true"
	 *        annotation="doc description='Set of placements contained by the replacement fragment.'"
	 * @generated
	 */
	EList<PlacementLiteral> getPlacements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitReplacementFragment(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitReplacementFragment(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ReplacementFragment
