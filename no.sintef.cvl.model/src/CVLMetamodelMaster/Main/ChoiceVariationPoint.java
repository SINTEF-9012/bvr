/**
 */
package CVLMetamodelMaster.Main;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A choice variation point is a variation point which may be bound to a<span style="font-size:8pt;"> choice. During materialization the decision resolving the choice determines whether or not the variation point will be applied or not.</span></p><p></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.ChoiceVariationPoint#getBindingChoice <em>Binding Choice</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getChoiceVariationPoint()
 * @model abstract="true"
 * @generated
 */
public interface ChoiceVariationPoint extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Binding Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The binding choice.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding Choice</em>' reference.
	 * @see #setBindingChoice(Choice)
	 * @see CVLMetamodelMaster.Main.MainPackage#getChoiceVariationPoint_BindingChoice()
	 * @model ordered="false"
	 * @generated
	 */
	Choice getBindingChoice();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ChoiceVariationPoint#getBindingChoice <em>Binding Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Choice</em>' reference.
	 * @see #getBindingChoice()
	 * @generated
	 */
	void setBindingChoice(Choice value);

} // ChoiceVariationPoint
