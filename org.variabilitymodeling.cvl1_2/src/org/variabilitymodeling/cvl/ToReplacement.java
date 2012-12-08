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
 * A representation of the model object '<em><b>To Replacement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ToReplacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.ToReplacement#getPlacementBoundaryElement <em>Placement Boundary Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getToReplacement()
 * @model annotation="doc description='ToReplacement is the kind of boundary element that defines the inwards boundary of the owning replacement fragment.\r\n\r\nThe insideBoundaryElement defines the starting points for the traversal to isolate the model elements that as part of a fragment substitution will be copied into the placement fragment.\r\n' semantics='The semantics of To Replacement can be found under Fragment Substitution.'"
 * @generated
 */
public interface ToReplacement extends ReplacementBoundaryElement {
	/**
	 * Returns the value of the '<em><b>Inside Boundary Element</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inside Boundary Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inside Boundary Element</em>' reference list.
	 * @see org.variabilitymodeling.cvl.CvlPackage#getToReplacement_InsideBoundaryElement()
	 * @model annotation="doc description='Model elements that are referred to by outside model elements.'"
	 * @generated
	 */
	EList<EObject> getInsideBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Placement Boundary Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.variabilitymodeling.cvl.ToPlacement#getOutsideRef <em>Outside Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement Boundary Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement Boundary Element</em>' reference.
	 * @see #setPlacementBoundaryElement(ToPlacement)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getToReplacement_PlacementBoundaryElement()
	 * @see org.variabilitymodeling.cvl.ToPlacement#getOutsideRef
	 * @model opposite="outsideRef"
	 *        annotation="doc description='Reference to a ToPlacement contained by the replacement fragment.'"
	 * @generated
	 */
	ToPlacement getPlacementBoundaryElement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ToReplacement#getPlacementBoundaryElement <em>Placement Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement Boundary Element</em>' reference.
	 * @see #getPlacementBoundaryElement()
	 * @generated
	 */
	void setPlacementBoundaryElement(ToPlacement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitToReplacement(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitToReplacement(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ToReplacement
