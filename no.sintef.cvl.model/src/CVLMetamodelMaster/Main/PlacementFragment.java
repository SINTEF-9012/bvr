/**
 */
package CVLMetamodelMaster.Main;

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
 *   <li>{@link CVLMetamodelMaster.Main.PlacementFragment#getPlacementBoundaryElement <em>Placement Boundary Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getPlacementFragment()
 * @model
 * @generated
 */
public interface PlacementFragment extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Placement Boundary Element</b></em>' containment reference list.
	 * The list contents are of type {@link CVLMetamodelMaster.Main.PlacementBoundaryElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The boundary elements captures all the relations from and to the fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Placement Boundary Element</em>' containment reference list.
	 * @see CVLMetamodelMaster.Main.MainPackage#getPlacementFragment_PlacementBoundaryElement()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PlacementBoundaryElement> getPlacementBoundaryElement();

} // PlacementFragment
