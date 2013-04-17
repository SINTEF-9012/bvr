/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p class="MsoNormal"><span style="font-size:8pt;font-family:Tahoma;"><span style="color:#000000;">A variation points is a specification of concrete variability in the base model. </span>Variation points define specific modifications to be applied to the base model during materialization. They refer to base model elements via base model handles and are bound to VSpecs. <span style="color:#000000;">Binding a variation point to a VSpec means that the application of the variation point to the base model during materialization depends on the resolution for the VSpec. The nature of the dependency is specific to the kind of variation point. </span></span><span style="font-size:8pt;font-family:Sylfaen;"><span style="color:#000000;"><span style="font-family:Tahoma;"></span></span></span></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.VariationPoint#getBindingVSpec <em>Binding VSpec</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.CvlPackage#getVariationPoint()
 * @model abstract="true"
 * @generated
 */
public interface VariationPoint extends VPackageable {
	/**
	 * Returns the value of the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The VSpecs to which the variation point is bound.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding VSpec</em>' reference.
	 * @see #setBindingVSpec(VSpec)
	 * @see cvl.CvlPackage#getVariationPoint_BindingVSpec()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VSpec getBindingVSpec();

	/**
	 * Sets the value of the '{@link cvl.VariationPoint#getBindingVSpec <em>Binding VSpec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding VSpec</em>' reference.
	 * @see #getBindingVSpec()
	 * @generated
	 */
	void setBindingVSpec(VSpec value);

} // VariationPoint
