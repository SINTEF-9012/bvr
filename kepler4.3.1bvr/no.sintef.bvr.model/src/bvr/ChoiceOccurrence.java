/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Occurrence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>ChoiceOccurrence is similar to a Choice, but refers to a VType instead of having the ability to define a subordinate VNode structure.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ChoiceOccurrence#getVType <em>VType</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getChoiceOccurrence()
 * @model
 * @generated
 */
public interface ChoiceOccurrence extends VNode, ChoiceVSpec {
	/**
	 * Returns the value of the '<em><b>VType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>vType refers to the VType that defines the details of the ChoiceOccurrence</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>VType</em>' reference.
	 * @see #setVType(VType)
	 * @see bvr.BvrPackage#getChoiceOccurrence_VType()
	 * @model ordered="false"
	 * @generated
	 */
	VType getVType();

	/**
	 * Sets the value of the '{@link bvr.ChoiceOccurrence#getVType <em>VType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VType</em>' reference.
	 * @see #getVType()
	 * @generated
	 */
	void setVType(VType value);

} // ChoiceOccurrence
