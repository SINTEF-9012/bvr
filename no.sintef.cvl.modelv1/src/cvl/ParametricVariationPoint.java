/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parametric Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p><span><span style="font-size:8pt;">A parametric variation point is a variation point that depends on a parameter and must be bound to a variable. During materialization the value supplied as the resolution for the variable is used for the parameter. </span></span></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.ParametricVariationPoint#getBindingVariable <em>Binding Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getParametricVariationPoint()
 * @model abstract="true"
 * @generated
 */
public interface ParametricVariationPoint extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Binding Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The binding variable.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding Variable</em>' reference.
	 * @see #setBindingVariable(Variable)
	 * @see cvl.cvlPackage#getParametricVariationPoint_BindingVariable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Variable getBindingVariable();

	/**
	 * Sets the value of the '{@link cvl.ParametricVariationPoint#getBindingVariable <em>Binding Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Variable</em>' reference.
	 * @see #getBindingVariable()
	 * @generated
	 */
	void setBindingVariable(Variable value);

} // ParametricVariationPoint
