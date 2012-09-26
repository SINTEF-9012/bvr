/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VClassifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A VClassifier (variability classifier) is a VSpec whose resolution requires instantiating it zero or more times and then resolving its sub-tree for each instance. When a repeatable variation point is bound to a VClassifier it will be applied once for each instance of the VClassifier during materialization.</p><p>Each variability classifier has an instance multiplicity which specifies lower and upper limits for the number of instances created from it.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.VClassifier#getInstanceMultiplicity <em>Instance Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getVClassifier()
 * @model
 * @generated
 */
public interface VClassifier extends VSpec {
	/**
	 * Returns the value of the '<em><b>Instance Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies a cardinality constraint on the number of instances created from this VClassifier.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance Multiplicity</em>' containment reference.
	 * @see #setInstanceMultiplicity(MultiplicityInterval)
	 * @see cvl.cvlPackage#getVClassifier_InstanceMultiplicity()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	MultiplicityInterval getInstanceMultiplicity();

	/**
	 * Sets the value of the '{@link cvl.VClassifier#getInstanceMultiplicity <em>Instance Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Multiplicity</em>' containment reference.
	 * @see #getInstanceMultiplicity()
	 * @generated
	 */
	void setInstanceMultiplicity(MultiplicityInterval value);

} // VClassifier
