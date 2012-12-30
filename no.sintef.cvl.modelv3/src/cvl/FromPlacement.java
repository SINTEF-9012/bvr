/**
 */
package cvl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Placement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * FromPlacement is the kind of boundary element that defines the outwards boundary of the owning placement fragment. The
 * outsideBoundaryElement refers to the model elements on the outside of the placement fragment. In a fragment substitution
 * these have to be referred by model elements within the replacement fragment.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.FromPlacement#getFromReplacement <em>From Replacement</em>}</li>
 *   <li>{@link cvl.FromPlacement#getOutsideBoundaryElement <em>Outside Boundary Element</em>}</li>
 *   <li>{@link cvl.FromPlacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getFromPlacement()
 * @model
 * @generated
 */
public interface FromPlacement extends PlacementBoundaryElement {
	/**
	 * Returns the value of the '<em><b>From Replacement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cvl.FromReplacement#getFromPlacement <em>From Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to a FromReplacement in a containing replacement fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From Replacement</em>' reference.
	 * @see #setFromReplacement(FromReplacement)
	 * @see cvl.cvlPackage#getFromPlacement_FromReplacement()
	 * @see cvl.FromReplacement#getFromPlacement
	 * @model opposite="fromPlacement" ordered="false"
	 * @generated
	 */
	FromReplacement getFromReplacement();

	/**
	 * Sets the value of the '{@link cvl.FromPlacement#getFromReplacement <em>From Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Replacement</em>' reference.
	 * @see #getFromReplacement()
	 * @generated
	 */
	void setFromReplacement(FromReplacement value);

	/**
	 * Returns the value of the '<em><b>Outside Boundary Element</b></em>' reference list.
	 * The list contents are of type {@link cvl.ObjectHandle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Outside Model Element that are referred by the model elements inside the placement fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outside Boundary Element</em>' reference list.
	 * @see cvl.cvlPackage#getFromPlacement_OutsideBoundaryElement()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ObjectHandle> getOutsideBoundaryElement();

	/**
	 * Returns the value of the '<em><b>Inside Boundary Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inside Boundary Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inside Boundary Element</em>' reference.
	 * @see #setInsideBoundaryElement(ObjectHandle)
	 * @see cvl.cvlPackage#getFromPlacement_InsideBoundaryElement()
	 * @model ordered="false"
	 * @generated
	 */
	ObjectHandle getInsideBoundaryElement();

	/**
	 * Sets the value of the '{@link cvl.FromPlacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inside Boundary Element</em>' reference.
	 * @see #getInsideBoundaryElement()
	 * @generated
	 */
	void setInsideBoundaryElement(ObjectHandle value);

} // FromPlacement
