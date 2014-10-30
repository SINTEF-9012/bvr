/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A constraint expression that references a Target and through that a set of VSpecs. It must reference existing VSpecs.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.TargetRef#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getTargetRef()
 * @model
 * @generated
 */
public interface TargetRef extends BCLExpression {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Reference to the Target.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Target)
	 * @see bvr.BvrPackage#getTargetRef_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Target getTarget();

	/**
	 * Sets the value of the '{@link bvr.TargetRef#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Target value);

} // TargetRef
