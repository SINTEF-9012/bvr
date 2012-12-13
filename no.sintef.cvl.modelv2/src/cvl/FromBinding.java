/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>FromBinding defines a binding between boundary elements of kind FromPlacement/FromReplacement. The FromPlacement boundary<br>element that has to be bound to the FromPlacement.</p><p>####CVLSemanticStart####</p><p>Invariant</p><p>Invariant : The FromPlacement boundary element must be bound to the FromReplacement element.</p><p>OCL :</p><p></p><p>-- The FromPlacement boundary element must be bound to the FromReplacement element</p><p>context FromBinding :</p><p>inv mustBeBoundToTheReplacement :</p><p>self.fromPlacement.fromReplacement = self.fromReplacement</p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition : </p><p>None</p><p>Post-condition: </p><p>After a FragmentSubstitution has been executed (and as a consequence a FromBinding), the elements inside the replacement element references the element outside the placement elements. These outside elements referenced before the placement elements.</p><p>OCL :</p><p>-- FromBinding</p><p>-- (FragmentSubstitution : the placement and replacement boundary elements are connected by bindings)</p><p>-- fromReplacement.insideBoundaryElement.propertyName[] = fromPlacement.outsideBoundaryElement[]</p><p>context FromBinding::eval(ctx : CVLExecutionContext)</p><p>pre :</p><p>post : self.fromReplacement.insideBoundaryElement.getPropertyValue(self.fromReplacement.propertyName)-&gt;forAll( val | val.oclIsTypeOf(ObjectHandle) and  self.fromPlacement.outsideBoundaryElement-&gt;includes(val.oclAsType(ObjectHandle)))</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.FromBinding#getFromPlacement <em>From Placement</em>}</li>
 *   <li>{@link cvl.FromBinding#getFromReplacement <em>From Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getFromBinding()
 * @model
 * @generated
 */
public interface FromBinding extends BoundaryElementBinding {
	/**
	 * Returns the value of the '<em><b>From Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the FromPlacement boundary element that is part of the binding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From Placement</em>' reference.
	 * @see #setFromPlacement(FromPlacement)
	 * @see cvl.cvlPackage#getFromBinding_FromPlacement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FromPlacement getFromPlacement();

	/**
	 * Sets the value of the '{@link cvl.FromBinding#getFromPlacement <em>From Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Placement</em>' reference.
	 * @see #getFromPlacement()
	 * @generated
	 */
	void setFromPlacement(FromPlacement value);

	/**
	 * Returns the value of the '<em><b>From Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the FromReplacement boundary element that is part of the binding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From Replacement</em>' reference.
	 * @see #setFromReplacement(FromReplacement)
	 * @see cvl.cvlPackage#getFromBinding_FromReplacement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FromReplacement getFromReplacement();

	/**
	 * Sets the value of the '{@link cvl.FromBinding#getFromReplacement <em>From Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Replacement</em>' reference.
	 * @see #getFromReplacement()
	 * @generated
	 */
	void setFromReplacement(FromReplacement value);

} // FromBinding
