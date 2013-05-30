/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repeatable Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p><span><span style="font-size:8pt;">A repeatable variation point is a variation point that may be applied several times during materialization. It may be bound to a VClassifier and is applied once for each instance of it. </span></span></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.RepeatableVariationPoint#getBindingClassifier <em>Binding Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.CvlPackage#getRepeatableVariationPoint()
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
	 * @see cvl.CvlPackage#getRepeatableVariationPoint_BindingClassifier()
	 * @model ordered="false"
	 * @generated
	 */
	VClassifier getBindingClassifier();

	/**
	 * Sets the value of the '{@link cvl.RepeatableVariationPoint#getBindingClassifier <em>Binding Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Classifier</em>' reference.
	 * @see #getBindingClassifier()
	 * @generated
	 */
	void setBindingClassifier(VClassifier value);

} // RepeatableVariationPoint
