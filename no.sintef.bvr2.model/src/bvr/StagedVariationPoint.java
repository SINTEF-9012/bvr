/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Staged Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A staged variation point refers to occurrences of VTypes (either VClassOccurrence or ChoiceOccurrence). The point is that realizing occurrences may vary from occurrence to occurrence of the very same VType. Typically the different occurrences of a VType correspond to desired changes in different concrete places of the base model.</p><p></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.StagedVariationPoint#getBindingStagedVP <em>Binding Staged VP</em>}</li>
 *   <li>{@link bvr.StagedVariationPoint#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getStagedVariationPoint()
 * @model
 * @generated
 */
public interface StagedVariationPoint extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Binding Staged VP</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The binding CVSpec which refers either a ChoiceOccurrence or a VClassOccurrence. </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding Staged VP</em>' reference.
	 * @see #setBindingStagedVP(VSpec)
	 * @see bvr.BvrPackage#getStagedVariationPoint_BindingStagedVP()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VSpec getBindingStagedVP();

	/**
	 * Sets the value of the '{@link bvr.StagedVariationPoint#getBindingStagedVP <em>Binding Staged VP</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Staged VP</em>' reference.
	 * @see #getBindingStagedVP()
	 * @generated
	 */
	void setBindingStagedVP(VSpec value);

	/**
	 * Returns the value of the '<em><b>Member</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.VariationPoint}.
	 * It is bidirectional and its opposite is '{@link bvr.VariationPoint#getStagedVariationPoint <em>Staged Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Members of the staged variation point constituting the next level of the tree and corresponding pairwise with the members of the VType of the occurrence referred by the bindingStagedVP</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member</em>' containment reference list.
	 * @see bvr.BvrPackage#getStagedVariationPoint_Member()
	 * @see bvr.VariationPoint#getStagedVariationPoint
	 * @model opposite="stagedVariationPoint" containment="true" ordered="false"
	 * @generated
	 */
	EList<VariationPoint> getMember();

} // StagedVariationPoint
