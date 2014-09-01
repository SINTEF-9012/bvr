/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>To Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>ToBinding defines a binding between boundary elements of kind ToPlacement/ToReplacement. The ToPlacement boundary element<br>has to be bound to the ToReplacement.</p><p></p><p>####CVLSemanticStart####</p><p>Invariant</p><p>Invariant : The ToPlacement boundary element must be bound to the ToReplacement element</p><p>OCL :</p><p>-- The ToPlacement boundary element must be bound to the ToReplacement element</p><p>context ToBinding :</p><p>inv mustBeBoundToTheToReplacement :</p><p>self.toPlacement.toReplacement = self.toReplacement</p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition : </p><p>None</p><p>Post-condition: </p><p>After a FragmentSubstitution has been executed (and as a consequence a ToBinding), the elements that referenced before the placement inside model elements reference now the replacement inside model elements.</p><p>OCL :</p><p>-- ToBinding</p><p>-- (FragmentSubstitution : the placement and replacement boundary elements are connected by bindings)</p><p>-- toPlacement.outsideBoundaryElement.propertyName[] = toReplacement.insideBoundaryElement[]</p><p>context ToBinding::eval(ctx : CVLExecutionContext)</p><p>pre :</p><p>post : self.toPlacement.outsideBoundaryElement.getPropertyValue(self.toPlacement.propertyName)-&gt;forAll( val | val.oclIsTypeOf(ObjectHandle) and  self.toReplacement.insideBoundaryElement-&gt;includes(val.oclAsType(ObjectHandle)))</p><p></p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ToBinding#getToPlacement <em>To Placement</em>}</li>
 *   <li>{@link bvr.ToBinding#getToReplacement <em>To Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getToBinding()
 * @model
 * @generated
 */
public interface ToBinding extends BoundaryElementBinding {
	/**
	 * Returns the value of the '<em><b>To Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the ToPlacement boundary element that is part of the binding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>To Placement</em>' reference.
	 * @see #setToPlacement(ToPlacement)
	 * @see bvr.BvrPackage#getToBinding_ToPlacement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ToPlacement getToPlacement();

	/**
	 * Sets the value of the '{@link bvr.ToBinding#getToPlacement <em>To Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Placement</em>' reference.
	 * @see #getToPlacement()
	 * @generated
	 */
	void setToPlacement(ToPlacement value);

	/**
	 * Returns the value of the '<em><b>To Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the ToReplacement boundary element that is part of the binding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>To Replacement</em>' reference.
	 * @see #setToReplacement(ToReplacement)
	 * @see bvr.BvrPackage#getToBinding_ToReplacement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ToReplacement getToReplacement();

	/**
	 * Sets the value of the '{@link bvr.ToBinding#getToReplacement <em>To Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Replacement</em>' reference.
	 * @see #getToReplacement()
	 * @generated
	 */
	void setToReplacement(ToReplacement value);

} // ToBinding
