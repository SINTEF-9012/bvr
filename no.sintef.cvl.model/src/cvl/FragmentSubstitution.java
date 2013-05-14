/**
 */
package cvl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fragment Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>Fragment Substitution substitutes a placement fragment of the base model with one or more replacement fragments of the base model.</p><p>Constraints:</p><p>The boundary elements define all references going in and out of the placement fragment. The boundary elements fully define all references going in and out of the replacement fragment.</p><p>Semantics:</p><p>1. Delete the model elements defined by the PlacementFragment. The placement model elements can be found through FragmentSubstitution.placement's placementBoundaryElements that are of class ToPlacement (using the model element references called insideBoundaryElement) and the transitive closure of all references from these, where the traversal is cut off at any reference that has the same value as any of FragmentSubstitution.placement's PlacementBoundardyElement that are of class FromPlacement (using the model element references called outsideBoundaryElement).</p><p><br>2. For the replacement fragments, copy its content onto the hole made by the deletion of the placement fragment. The placement and replacement boundary elements must correspond. The content model elements can be found through FragmentSubstitution. replacement's ReplacementBoundaryElement that are of type ToReplacement (using the model element references called insideBoundaryElement) and all model elements found through the transitive closure of all references from this set of model elements, where the traversal is cut off at any reference that has the same value as any of FragmentSubstitution.replacement's ReplacementBoundaryElement that are of type FromReplacement (using the model element references called outsideBoundaryElement).</p><p>If multi is true, then a number of copies of the replacement fragment will be copied onto the placement. The resolution model will define how many.</p><p>Any substitutions addressing placements inside the given replacement fragment will be performed on the copy of the replacement fragment which is the last one generated.</p><p>3. Binding boundary elements. The placement and replacement boundary elements are connected by bindings. The bindings are given by the BoundaryElementBindings:<br>1. FromBinding: fromReplacement.insideBoundaryElement.propertyName[] = fromPlacement.outsideBoundaryElement[]<br>2. ToBinding: toPlacement.outsideBoundaryElement.propertyName[] = toReplacement.insideBoundaryElement[]. This definition in fact also covers attributes that have multiplicity. Such attributes may be seen as arrays or collections, and repeated reference assignments to such attributes during variability transformation will mean adding a new individual reference to the identifier collection.</p><p>####CVLSemanticStart####</p><p></p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition : </p><p>Before the execution of a Fragment Substitution, the placement fragment must exist in the base model.</p><p>Post-condition: </p><p>After a FragmentSubstitution has been executed, the placement elements cannot be found in the resolved model whereas the replacement elements are in the resolved model.</p><p>OCL :</p><p>context FragmentSubstitution::eval(ctx : CVLExecutionContext)</p><p>pre : </p><p>self.boundaryElementBinding-&gt;forAll(boundaryElt |boundaryElt.oclIsTypeOf(ToBinding) implies boundaryElt.oclAsType(ToBinding).toPlacement.insideBoundaryElement-&gt;forAll(e |  ctx.resolvedModelElements-&gt;includes(e)) )</p><p>post :</p><p> self.boundaryElementBinding-&gt;forAll(boundaryElt |boundaryElt.oclIsTypeOf(ToBinding) implies boundaryElt.oclAsType(ToBinding).toPlacement.insideBoundaryElement-&gt;forAll(e | not ctx.resolvedModelElements-&gt;includes(e)) )</p><p>           and self.boundaryElementBinding-&gt;forAll(boundaryElt |boundaryElt.oclIsTypeOf(ToBinding) implies boundaryElt.oclAsType(ToBinding).toReplacement.insideBoundaryElement-&gt;forAll(e |  ctx.resolvedModelElements-&gt;includes(e)) )</p><p>Note : FragmentSubstitution needs the use of FromBinding and ToBinding metaclasses (please refer to the corresponding pre and post conditions).</p><p>####CVLSemanticEnd####</p><p></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.FragmentSubstitution#getBoundaryElementBinding <em>Boundary Element Binding</em>}</li>
 *   <li>{@link cvl.FragmentSubstitution#getPlacement <em>Placement</em>}</li>
 *   <li>{@link cvl.FragmentSubstitution#isMulti <em>Multi</em>}</li>
 *   <li>{@link cvl.FragmentSubstitution#getReplacement <em>Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.CvlPackage#getFragmentSubstitution()
 * @model
 * @generated
 */
public interface FragmentSubstitution extends ChoiceVariationPoint, RepeatableVariationPoint {
	/**
	 * Returns the value of the '<em><b>Boundary Element Binding</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.BoundaryElementBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     Specifies the binding between the placement and replacement fragments.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Boundary Element Binding</em>' containment reference list.
	 * @see cvl.CvlPackage#getFragmentSubstitution_BoundaryElementBinding()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<BoundaryElementBinding> getBoundaryElementBinding();

	/**
	 * Returns the value of the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     Specifies the fragment to be replaced.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Placement</em>' reference.
	 * @see #setPlacement(PlacementFragment)
	 * @see cvl.CvlPackage#getFragmentSubstitution_Placement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PlacementFragment getPlacement();

	/**
	 * Sets the value of the '{@link cvl.FragmentSubstitution#getPlacement <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement</em>' reference.
	 * @see #getPlacement()
	 * @generated
	 */
	void setPlacement(PlacementFragment value);

	/**
	 * Returns the value of the '<em><b>Multi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Indicates multiple fragment substitution.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Multi</em>' attribute.
	 * @see #setMulti(boolean)
	 * @see cvl.CvlPackage#getFragmentSubstitution_Multi()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isMulti();

	/**
	 * Sets the value of the '{@link cvl.FragmentSubstitution#isMulti <em>Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi</em>' attribute.
	 * @see #isMulti()
	 * @generated
	 */
	void setMulti(boolean value);

	/**
	 * Returns the value of the '<em><b>Replacement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Specifies the replacement to be utilized.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Replacement</em>' reference.
	 * @see #setReplacement(ReplacementFragment)
	 * @see cvl.CvlPackage#getFragmentSubstitution_Replacement()
	 * @model ordered="false"
	 * @generated
	 */
	ReplacementFragment getReplacement();

	/**
	 * Sets the value of the '{@link cvl.FragmentSubstitution#getReplacement <em>Replacement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement</em>' reference.
	 * @see #getReplacement()
	 * @generated
	 */
	void setReplacement(ReplacementFragment value);

} // FragmentSubstitution
