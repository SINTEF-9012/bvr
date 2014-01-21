/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>An ObjectSubstitution is a choice variation point which specifies that an object of the base model, called the replacement, may be substituted for another, called the placement. The placement and replacement objects are specified via object handles identifying base model objects.</p><p>When this variation point is applied, all links touching the placement are redirected to the replacement and the placement is deleted.<br></p><p>####CVLSemanticStart####</p><p>Invariant : An ObjectSubstitution may not be bound to a VClassifier</p><p>OCL :</p><p>-- ObjectSubstitution</p><p>-- An ObjectSubstitution may not be bound to a VClassifier</p><p>context ObjectSubstitution :</p><p>inv notBoundToAVClassifier :</p><p>not (self.bindingVspec->exists( vspec | vspec.oclIsTypeOf(VClassifier)))</p><p>Dynamic semantics</p><p>Pre and post conditions</p><p>Pre-condition :</p><p>Before the execution of an ObjectSubstitution, placement and replacement object must exist in the base model.</p><p>Post-condition:</p><p>After an Object Substitution has been executed, the replacement object must exist in the resolved model whereas the placement object cannot be found in the resolved model.</p><p>OCL :</p><p>-- ObjectSubstitution</p><p>context ObjectSubstitution::eval(ctx : CVLExecutionContext)</p><p>pre:</p><p>ctx.resolvedModelElements->includes( self.placementObject)</p><p>and ctx.resolvedModelElements->includes( self.replacementObject)</p><p>post:</p><p>ctx.resolvedModelElements->includes( self.replacementObject)</p><p>and not ctx.resolvedModelElements->includes( self.placementObject)</p><p></p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.ObjectSubstitution#getPlacementObject <em>Placement Object</em>}</li>
 *   <li>{@link cvl.ObjectSubstitution#getReplacementObject <em>Replacement Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.CvlPackage#getObjectSubstitution()
 * @model
 * @generated
 */
public interface ObjectSubstitution extends ChoiceVariationPoint {
	/**
	 * Returns the value of the '<em><b>Placement Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The&nbsp;object handle identifying the base model object&nbsp;to&nbsp;be&nbsp;replaced&nbsp;by&nbsp;the replacement
	 * object&nbsp;in&nbsp;this&nbsp;substitution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Placement Object</em>' containment reference.
	 * @see #setPlacementObject(ObjectHandle)
	 * @see cvl.CvlPackage#getObjectSubstitution_PlacementObject()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ObjectHandle getPlacementObject();

	/**
	 * Sets the value of the '{@link cvl.ObjectSubstitution#getPlacementObject <em>Placement Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement Object</em>' containment reference.
	 * @see #getPlacementObject()
	 * @generated
	 */
	void setPlacementObject(ObjectHandle value);

	/**
	 * Returns the value of the '<em><b>Replacement Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The&nbsp;object handle identifying the base model object&nbsp;replacing&nbsp;to&nbsp;the&nbsp;placement&nbsp;object in this
	 * substitution. If no replacement is specified then the object is expected to arrive in a variable, that is the variation
	 * point must be bound to a variable to be acted on.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Replacement Object</em>' containment reference.
	 * @see #setReplacementObject(ObjectHandle)
	 * @see cvl.CvlPackage#getObjectSubstitution_ReplacementObject()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ObjectHandle getReplacementObject();

	/**
	 * Sets the value of the '{@link cvl.ObjectSubstitution#getReplacementObject <em>Replacement Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement Object</em>' containment reference.
	 * @see #getReplacementObject()
	 * @generated
	 */
	void setReplacementObject(ObjectHandle value);

} // ObjectSubstitution
