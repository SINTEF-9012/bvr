/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.variabilitymodeling.cvl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.variabilitymodeling.cvl.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Placement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.FromPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.FromPlacement#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getFromPlacement()
 * @model annotation="doc description='FromPlacement is the kind of boundary element that defines the outwards boundary of the owning placement fragment.\r\n\r\nThe outsideBoundaryElement refers to the model elements on the outside of the placement fragment. In a fragment substitution these have to be referred by model elements within the replacement fragment.' semantics='The semantics of FromPlacement can be found under Fragment Substitution.'"
 * @generated
 */
public interface FromPlacement extends PlacementBoundaryElement {
	/**
	 * Returns the value of the '<em><b>Outside Boundary Element</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outside Boundary Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outside Boundary Element</em>' reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFromPlacement_OutsideBoundaryElement()
	 * @model annotation="doc description='Outside Model Element that are referred by the model elements inside the placement fragment.'"
	 * @generated
	 */
	EList<EObject> getOutsideBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Replacement Boundary Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.variabilitymodeling.cvl.FromReplacement#getInsideRef <em>Inside Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replacement Boundary Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replacement Boundary Element</em>' reference.
	 * @see #setReplacementBoundaryElement(FromReplacement)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getFromPlacement_ReplacementBoundaryElement()
	 * @see org.variabilitymodeling.cvl.FromReplacement#getInsideRef
	 * @model opposite="insideRef"
	 *        annotation="doc description='Reference to a FromReplacement in a containing replacement fragment.'"
	 * @generated
	 */
	FromReplacement getReplacementBoundaryElement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.FromPlacement#getReplacementBoundaryElement <em>Replacement Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement Boundary Element</em>' reference.
	 * @see #getReplacementBoundaryElement()
	 * @generated
	 */
	void setReplacementBoundaryElement(FromReplacement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitFromPlacement(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitFromPlacement(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // FromPlacement
