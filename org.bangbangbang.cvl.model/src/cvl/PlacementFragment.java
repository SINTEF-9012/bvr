/**
 */
package cvl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Placement Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A PlacementFragment defines a fragment (set of model elements) of the base model that will be replaced by a
 * ReplacementFragment during the variability transformation. The set of model elements of the fragment will be deleted.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.PlacementFragment#getPlacementBoundaryElement <em>Placement Boundary Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.CvlPackage#getPlacementFragment()
 * @model
 * @generated
 */
public interface PlacementFragment extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Placement Boundary Element</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.PlacementBoundaryElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The boundary elements captures all the relations from and to the fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Placement Boundary Element</em>' containment reference list.
	 * @see cvl.CvlPackage#getPlacementFragment_PlacementBoundaryElement()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PlacementBoundaryElement> getPlacementBoundaryElement();

} // PlacementFragment
