/**
 */
package bvr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VClass Occurrence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>VClassOccurrence is a set concept similar to VClassifier. The difference is that VClassOccurence refers a VType and does not have its own defining subtree.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.VClassOccurrence#getVType <em>VType</em>}</li>
 *   <li>{@link bvr.VClassOccurrence#getInstanceMultiplicity <em>Instance Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVClassOccurrence()
 * @model
 * @generated
 */
public interface VClassOccurrence extends VSpec, VNode {
	/**
	 * Returns the value of the '<em><b>VType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VType</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VType</em>' reference.
	 * @see #setVType(VType)
	 * @see bvr.BvrPackage#getVClassOccurrence_VType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VType getVType();

	/**
	 * Sets the value of the '{@link bvr.VClassOccurrence#getVType <em>VType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VType</em>' reference.
	 * @see #getVType()
	 * @generated
	 */
	void setVType(VType value);

	/**
	 * Returns the value of the '<em><b>Instance Multiplicity</b></em>' containment reference list.
	 * The list contents are of type {@link bvr.MultiplicityInterval}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Multiplicity</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Multiplicity</em>' containment reference list.
	 * @see bvr.BvrPackage#getVClassOccurrence_InstanceMultiplicity()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MultiplicityInterval> getInstanceMultiplicity();

} // VClassOccurrence
