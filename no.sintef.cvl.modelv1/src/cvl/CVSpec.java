/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CV Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p class="MsoNormal"><span style="font-size:8pt;font-family:Tahoma;">A CVSpec is a VSpec whose resolution requires resolving the VSpecs in its type, which is a VInterface. When a configurable unit is bound to a CVSpec, its resolution determines the transformations to be applied to the internals of the unit during materialization. </span></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.CVSpec#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getCVSpec()
 * @model
 * @generated
 */
public interface CVSpec extends VSpec {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The VInterface  whose members need to be resolved in order to resolve the CVSpec.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(VInterface)
	 * @see cvl.cvlPackage#getCVSpec_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VInterface getType();

	/**
	 * Sets the value of the '{@link cvl.CVSpec#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(VInterface value);

} // CVSpec
