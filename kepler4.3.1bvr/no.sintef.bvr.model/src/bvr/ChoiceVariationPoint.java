/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A choice variation point is a variation point which may be bound to a<span style="font-size:8pt;"> choice. During materialization the resolution of the choice determines whether or not the variation point will be applied or not.</span></p><p></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ChoiceVariationPoint#getBindingChoice <em>Binding Choice</em>}</li>
 *   <li>{@link bvr.ChoiceVariationPoint#getBindingChoiceOcc <em>Binding Choice Occ</em>}</li>
 *   <li>{@link bvr.ChoiceVariationPoint#isResolution_kind <em>Resolution kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getChoiceVariationPoint()
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
	 * @see bvr.BvrPackage#getChoiceVariationPoint_BindingChoice()
	 * @model ordered="false"
	 * @generated
	 */
	Choice getBindingChoice();

	/**
	 * Sets the value of the '{@link bvr.ChoiceVariationPoint#getBindingChoice <em>Binding Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Choice</em>' reference.
	 * @see #getBindingChoice()
	 * @generated
	 */
	void setBindingChoice(Choice value);

	/**
	 * Returns the value of the '<em><b>Binding Choice Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The binding choice occurrence</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding Choice Occ</em>' reference.
	 * @see #setBindingChoiceOcc(ChoiceOccurrence)
	 * @see bvr.BvrPackage#getChoiceVariationPoint_BindingChoiceOcc()
	 * @model ordered="false"
	 * @generated
	 */
	ChoiceOccurrence getBindingChoiceOcc();

	/**
	 * Sets the value of the '{@link bvr.ChoiceVariationPoint#getBindingChoiceOcc <em>Binding Choice Occ</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Choice Occ</em>' reference.
	 * @see #getBindingChoiceOcc()
	 * @generated
	 */
	void setBindingChoiceOcc(ChoiceOccurrence value);

	/**
	 * Returns the value of the '<em><b>Resolution kind</b></em>' attribute.
	 * The default value is <code>"True"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The resolution_kind has the following definition:</p><p>True: The enclosing ChoiceVariationPoint shall be executed if the triggering resolution is a PosResolution.</p><p>False: The enclosing ChoiceVariationPoint shall be executed if the triggering resolution is a NegResolution.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolution kind</em>' attribute.
	 * @see #setResolution_kind(boolean)
	 * @see bvr.BvrPackage#getChoiceVariationPoint_Resolution_kind()
	 * @model default="True" required="true" ordered="false"
	 * @generated
	 */
	boolean isResolution_kind();

	/**
	 * Sets the value of the '{@link bvr.ChoiceVariationPoint#isResolution_kind <em>Resolution kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolution kind</em>' attribute.
	 * @see #isResolution_kind()
	 * @generated
	 */
	void setResolution_kind(boolean value);

} // ChoiceVariationPoint
