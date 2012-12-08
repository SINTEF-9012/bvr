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
 * A representation of the model object '<em><b>To Placement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.variabilitymodeling.cvl.ToPlacement#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.ToPlacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.ToPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}</li>
 *   <li>{@link org.variabilitymodeling.cvl.ToPlacement#getOutsideRef <em>Outside Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.variabilitymodeling.cvl.CvlPackage#getToPlacement()
 * @model annotation="doc description='ToPlacement is the kind of boundary element that defines the boundary between the owning placement fragment and the rest of the base model.\r\n\r\nThe insideBoundaryElements denote the ModelElements of owning fragment that are referred to by outside model elements.\r\n \r\nThe outsideBoundaryElement together with the propertyName denotes the attributes of model elements on the outside of the placement fragment that refer to the inside boundary model elements. ' semantics='The semantics of To Placement can be found under Fragment Substitution.' constraint='insideBoundaryElement = outsideRef.insideBoundaryElement\r\noutsideBoundaryElement != null xor outsideRef != null'"
 * @generated
 */
public interface ToPlacement extends PlacementBoundaryElement {
	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getToPlacement_PropertyName()
	 * @model annotation="doc description='Name of the attribute to be changed.'"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ToPlacement#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

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
	 * @see org.variabilitymodeling.cvl.CvlPackage#getToPlacement_InsideBoundaryElement()
	 * @model annotation="doc description='Model elements that are referred to by outside model elements. Used to distinguish miltiplicity references.'"
	 * @generated
	 */
	EList<EObject> getInsideBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Outside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outside Boundary Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outside Boundary Element</em>' reference.
	 * @see #setOutsideBoundaryElement(EObject)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getToPlacement_OutsideBoundaryElement()
	 * @model annotation="doc description='Outside model elements that refer model elements inside the fragment.'"
	 * @generated
	 */
	EObject getOutsideBoundaryElement();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ToPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outside Boundary Element</em>' reference.
	 * @see #getOutsideBoundaryElement()
	 * @generated
	 */
	void setOutsideBoundaryElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Outside Ref</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.variabilitymodeling.cvl.ToReplacement#getPlacementBoundaryElement <em>Placement Boundary Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outside Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outside Ref</em>' reference.
	 * @see #setOutsideRef(ToReplacement)
	 * @see org.variabilitymodeling.cvl.CvlPackage#getToPlacement_OutsideRef()
	 * @see org.variabilitymodeling.cvl.ToReplacement#getPlacementBoundaryElement
	 * @model opposite="placementBoundaryElement"
	 *        annotation="doc description='Reference to a ToReplacement in a containing replacement fragment.'"
	 * @generated
	 */
	ToReplacement getOutsideRef();

	/**
	 * Sets the value of the '{@link org.variabilitymodeling.cvl.ToPlacement#getOutsideRef <em>Outside Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outside Ref</em>' reference.
	 * @see #getOutsideRef()
	 * @generated
	 */
	void setOutsideRef(ToReplacement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitToPlacement(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitToPlacement(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ToPlacement
