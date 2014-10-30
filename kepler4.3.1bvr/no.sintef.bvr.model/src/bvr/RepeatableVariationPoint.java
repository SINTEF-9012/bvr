/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repeatable Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p><span><span style="font-size:8pt;">A repeatable variation point is a variation point that may be applied several times during materialization. It may only be bound to a VClassifier (or VClassOccurrence) and is applied once for each resolution referring to it. </span></span></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.RepeatableVariationPoint#getBindingClassifier <em>Binding Classifier</em>}</li>
 *   <li>{@link bvr.RepeatableVariationPoint#getBindingVClassOcc <em>Binding VClass Occ</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getRepeatableVariationPoint()
 * @model abstract="true"
 * @generated
 */
public interface RepeatableVariationPoint extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Binding Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The binding classifier.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding Classifier</em>' reference.
	 * @see #setBindingClassifier(VClassifier)
	 * @see bvr.BvrPackage#getRepeatableVariationPoint_BindingClassifier()
	 * @model ordered="false"
	 * @generated
	 */
	VClassifier getBindingClassifier();

	/**
	 * Sets the value of the '{@link bvr.RepeatableVariationPoint#getBindingClassifier <em>Binding Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Classifier</em>' reference.
	 * @see #getBindingClassifier()
	 * @generated
	 */
	void setBindingClassifier(VClassifier value);

	/**
	 * Returns the value of the '<em><b>Binding VClass Occ</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>binding VClassifier occurrence</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding VClass Occ</em>' reference.
	 * @see #setBindingVClassOcc(VClassOccurrence)
	 * @see bvr.BvrPackage#getRepeatableVariationPoint_BindingVClassOcc()
	 * @model ordered="false"
	 * @generated
	 */
	VClassOccurrence getBindingVClassOcc();

	/**
	 * Sets the value of the '{@link bvr.RepeatableVariationPoint#getBindingVClassOcc <em>Binding VClass Occ</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding VClass Occ</em>' reference.
	 * @see #getBindingVClassOcc()
	 * @generated
	 */
	void setBindingVClassOcc(VClassOccurrence value);

} // RepeatableVariationPoint
