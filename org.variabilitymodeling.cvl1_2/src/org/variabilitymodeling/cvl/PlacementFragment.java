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
 * A representation of the model object '<em><b>Placement Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.PlacementFragment#getBoundaryElement <em>Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.PlacementFragment#getUsage <em>Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getPlacementFragment()
 * @model annotation="doc description='A PlacementFragment defines a fragment (set of model elements) of the base model that will be replaced by a ReplacementFragment during the variability transformation. The set of model elements of the fragment will be deleted.' semantics='The semantics of the Placement Fragment can be found under Fragment Substitution.'"
 * @generated
 */
public interface PlacementFragment extends CVLNamedElement, PlacementLiteral {
	/**
	 * Returns the value of the '<em><b>Boundary Element</b></em>' containment reference list.
	 * The list contents are of type {@link org.variabilitymodeling.cvl.PlacementBoundaryElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boundary Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boundary Element</em>' containment reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getPlacementFragment_BoundaryElement()
	 * @model containment="true"
	 *        annotation="doc description='The boundary elements captures all the relations from and to the fragment.'"
	 * @generated
	 */
	EList<PlacementBoundaryElement> getBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Usage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.variabilitymodeling.cvl.PlacementFragmentUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage</em>' attribute.
	 * @see org.variabilitymodeling.cvl.PlacementFragmentUsage
	 * @see #setUsage(PlacementFragmentUsage)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getPlacementFragment_Usage()
	 * @model
	 * @generated
	 */
	PlacementFragmentUsage getUsage();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.PlacementFragment#getUsage <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage</em>' attribute.
	 * @see org.variabilitymodeling.cvl.PlacementFragmentUsage
	 * @see #getUsage()
	 * @generated
	 */
	void setUsage(PlacementFragmentUsage value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitPlacementFragment(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitPlacementFragment(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // PlacementFragment
