/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A constraint specifies restrictions on permissible resolution models.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.Constraint#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends VPackageable {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The context of the constraint.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(VSpec)
	 * @see bvr.BvrPackage#getConstraint_Context()
	 * @model ordered="false"
	 * @generated
	 */
	VSpec getContext();

	/**
	 * Sets the value of the '{@link bvr.Constraint#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(VSpec value);

} // Constraint
