/**
 */
package bvr;


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
 *   <li>{@link bvr.VariationPoint#getBindingVSpec <em>Binding VSpec</em>}</li>
 *   <li>{@link bvr.VariationPoint#getStagedVariationPoint <em>Staged Variation Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVariationPoint()
 * @model abstract="true"
 * @generated
 */
public interface VariationPoint extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Binding VSpec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The VSpecs to which the variation point is bound.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding VSpec</em>' reference.
	 * @see #setBindingVSpec(VSpec)
	 * @see bvr.BvrPackage#getVariationPoint_BindingVSpec()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VSpec getBindingVSpec();

	/**
	 * Sets the value of the '{@link bvr.VariationPoint#getBindingVSpec <em>Binding VSpec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding VSpec</em>' reference.
	 * @see #getBindingVSpec()
	 * @generated
	 */
	void setBindingVSpec(VSpec value);

	/**
	 * Returns the value of the '<em><b>Staged Variation Point</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link bvr.StagedVariationPoint#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Staged Variation Point</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Staged Variation Point</em>' container reference.
	 * @see #setStagedVariationPoint(StagedVariationPoint)
	 * @see bvr.BvrPackage#getVariationPoint_StagedVariationPoint()
	 * @see bvr.StagedVariationPoint#getMember
	 * @model opposite="member" transient="false" ordered="false"
	 * @generated
	 */
	StagedVariationPoint getStagedVariationPoint();

	/**
	 * Sets the value of the '{@link bvr.VariationPoint#getStagedVariationPoint <em>Staged Variation Point</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Staged Variation Point</em>' container reference.
	 * @see #getStagedVariationPoint()
	 * @generated
	 */
	void setStagedVariationPoint(StagedVariationPoint value);

} // VariationPoint
