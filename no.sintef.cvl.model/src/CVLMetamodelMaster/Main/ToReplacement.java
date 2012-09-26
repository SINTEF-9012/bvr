/**
 */
package CVLMetamodelMaster.Main;

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
 *   <li>{@link CVLMetamodelMaster.Main.ToReplacement#getInsideBoundaryElement <em>Inside Boundary Element</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.ToReplacement#getToPlacement <em>To Placement</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getToReplacement()
 * @model
 * @generated
 */
public interface ToReplacement extends ReplacementBoundaryElement {
	/**
	 * Returns the value of the '<em><b>Inside Boundary Element</b></em>' reference list.
	 * The list contents are of type {@link CVLMetamodelMaster.Main.ObjectHandle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Model elements that are referred to by outside model elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inside Boundary Element</em>' reference list.
	 * @see CVLMetamodelMaster.Main.MainPackage#getToReplacement_InsideBoundaryElement()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ObjectHandle> getInsideBoundaryElement();

	/**
	 * Returns the value of the '<em><b>To Placement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link CVLMetamodelMaster.Main.ToPlacement#getToReplacement <em>To Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to a ToPlacement contained by the replacement fragment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>To Placement</em>' reference.
	 * @see #setToPlacement(ToPlacement)
	 * @see CVLMetamodelMaster.Main.MainPackage#getToReplacement_ToPlacement()
	 * @see CVLMetamodelMaster.Main.ToPlacement#getToReplacement
	 * @model opposite="toReplacement" ordered="false"
	 * @generated
	 */
	ToPlacement getToPlacement();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ToReplacement#getToPlacement <em>To Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Placement</em>' reference.
	 * @see #getToPlacement()
	 * @generated
	 */
	void setToPlacement(ToPlacement value);

} // ToReplacement
