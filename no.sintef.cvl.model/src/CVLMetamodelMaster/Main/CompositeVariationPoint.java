/**
 */
package CVLMetamodelMaster.Main;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A composite variation point is either a configurable unit or a configurable unit usage. It must be bound to a CVSpec.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.CompositeVariationPoint#getBindingCVSpec <em>Binding CV Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getCompositeVariationPoint()
 * @model abstract="true"
 * @generated
 */
public interface CompositeVariationPoint extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Binding CV Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The binding CVSpec</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding CV Spec</em>' reference.
	 * @see #setBindingCVSpec(CVSpec)
	 * @see CVLMetamodelMaster.Main.MainPackage#getCompositeVariationPoint_BindingCVSpec()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CVSpec getBindingCVSpec();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.CompositeVariationPoint#getBindingCVSpec <em>Binding CV Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding CV Spec</em>' reference.
	 * @see #getBindingCVSpec()
	 * @generated
	 */
	void setBindingCVSpec(CVSpec value);

} // CompositeVariationPoint
