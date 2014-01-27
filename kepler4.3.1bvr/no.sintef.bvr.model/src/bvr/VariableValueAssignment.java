/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Value Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A VariableValueAssignment is a VSpecResolution which resolves a variables by providing a value of the variable's type.</p><p></p><p>####BVRSemanticStart####</p><p></p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition :</p><p>Before the execution of a VariableValueAssignment, the variable stored in the VariableValueAssignment must exist in the variable dictionary.</p><p>Post-condition:</p><p>After a VariableValueAssignment has been executed, the resolvedVariable is assigned with the value.</p><p></p><p>OCL :</p><p>context VariableValueAssignment::eval(ctx : BVRExecutionContext) :</p><p>pre: not ctx.variabledictionary-&gt;exists(p | p.elements-&gt;exists ( k | k.key == (self.resolvedVariable.name)))</p><p>post: ctx.variabledictionary-&gt;exists(p | p.elements-&gt;exists ( k| k.key == (self.resolvedVariable.name) and k.value == (self.value)) )</p><p>####BVRSemanticEnd####</p><p></p><p></p><p></p><p></p><p></p><p></p><p></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.VariableValueAssignment#getResolvedVariable <em>Resolved Variable</em>}</li>
 *   <li>{@link bvr.VariableValueAssignment#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getVariableValueAssignment()
 * @model
 * @generated
 */
public interface VariableValueAssignment extends VSpecResolution {
	/**
	 * Returns the value of the '<em><b>Resolved Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The resolved variable.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolved Variable</em>' reference.
	 * @see #setResolvedVariable(Variable)
	 * @see bvr.BvrPackage#getVariableValueAssignment_ResolvedVariable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Variable getResolvedVariable();

	/**
	 * Sets the value of the '{@link bvr.VariableValueAssignment#getResolvedVariable <em>Resolved Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved Variable</em>' reference.
	 * @see #getResolvedVariable()
	 * @generated
	 */
	void setResolvedVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The value assigned.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(ValueSpecification)
	 * @see bvr.BvrPackage#getVariableValueAssignment_Value()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ValueSpecification getValue();

	/**
	 * Sets the value of the '{@link bvr.VariableValueAssignment#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ValueSpecification value);

} // VariableValueAssignment
