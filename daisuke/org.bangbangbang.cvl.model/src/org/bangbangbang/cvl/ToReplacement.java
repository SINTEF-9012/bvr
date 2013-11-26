/**
 */
package org.bangbangbang.cvl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>To Replacement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     ToReplacement is the kind of boundary element that defines the inwards boundary of the owning replacement fragment. The
 *     insideBoundaryElement defines the starting points for the traversal to isolate the model elements that as part of a
 *     fragment substitution will be copied into the placement fragment.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bangbangbang.cvl.ToReplacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.ToReplacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}</li>
 *   <li>{@link org.bangbangbang.cvl.ToReplacement#getToPlacement <em>To Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bangbangbang.cvl.CvlPackage#getToReplacement()
 * @model
 * @generated
 */
public interface ToReplacement extends ReplacementBoundaryElement {
	/**
	 * Returns the value of the '<em><b>Inside Boundary Element</b></em>' reference list.
	 * The list contents are of type {@link org.bangbangbang.cvl.ObjectHandle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Model elements that are referred to by outside model elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inside Boundary Element</em>' reference list.
	 * @see org.bangbangbang.cvl.CvlPackage#getToReplacement_InsideBoundaryElement()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ObjectHandle> getInsideBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Outside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outside Boundary Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outside Boundary Element</em>' reference.
	 * @see #setOutsideBoundaryElement(ObjectHandle)
	 * @see org.bangbangbang.cvl.CvlPackage#getToReplacement_OutsideBoundaryElement()
	 * @model ordered="false"
	 * @generated
	 */
	ObjectHandle getOutsideBoundaryElement();

	/**
	 * Sets the value of the '{@link org.bangbangbang.cvl.ToReplacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outside Boundary Element</em>' reference.
	 * @see #getOutsideBoundaryElement()
	 * @generated
	 */
	void setOutsideBoundaryElement(ObjectHandle value);

	/**
	 * Returns the value of the '<em><b>To Placement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bangbangbang.cvl.ToPlacement#getToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to a ToPlacement contained by the replacement fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>To Placement</em>' reference.
	 * @see #setToPlacement(ToPlacement)
	 * @see org.bangbangbang.cvl.CvlPackage#getToReplacement_ToPlacement()
	 * @see org.bangbangbang.cvl.ToPlacement#getToReplacement
	 * @model opposite="toReplacement" ordered="false"
	 * @generated
	 */
	ToPlacement getToPlacement();

	/**
	 * Sets the value of the '{@link org.bangbangbang.cvl.ToReplacement#getToPlacement <em>To Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Placement</em>' reference.
	 * @see #getToPlacement()
	 * @generated
	 */
	void setToPlacement(ToPlacement value);

} // ToReplacement
