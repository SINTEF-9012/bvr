/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VClassifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>VClassifier is a set concept. The instanceMultiplicity defines the range of how many ChoiceResolutions that can be referring this particular VClassifier.</p><p>A VClassifier can also have a subtree as it is a CompoundNode which defines subordinate variability specifications (VNodes).</p><p>When a repeatable variation point is bound to a VClassifier it will be applied once for each resolution of the VClassifier during materialization.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.VClassifier#getInstanceMultiplicity <em>Instance Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVClassifier()
 * @model
 * @generated
 */
public interface VClassifier extends VSpec, CompoundNode {
	/**
	 * Returns the value of the '<em><b>Instance Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies a cardinality constraint on the number of instances created from this VClassifier.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance Multiplicity</em>' containment reference.
	 * @see #setInstanceMultiplicity(MultiplicityInterval)
	 * @see bvr.BvrPackage#getVClassifier_InstanceMultiplicity()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	MultiplicityInterval getInstanceMultiplicity();

	/**
	 * Sets the value of the '{@link bvr.VClassifier#getInstanceMultiplicity <em>Instance Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Multiplicity</em>' containment reference.
	 * @see #getInstanceMultiplicity()
	 * @generated
	 */
	void setInstanceMultiplicity(MultiplicityInterval value);

} // VClassifier
