/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Existence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>LinkExistence is a choice variation point which indicates that a link of the base model may or may not exist in the materialized model. The link is identified via a link handle. When this variation point is applied the link identified in the base model as the optionalLink t is deleted.<br><br></p><p>####BVRSemanticStart####</p><p>Invariant : A LinkExistence must be bound to a Choice, not to a variable or to a classifier</p><p>OCL :</p><p>-- LinkExistence</p><p>-- A LinkExistence must be bound to a Choice, not to a variable or to a classifier</p><p>context LinkExistence :</p><p>inv linkExistence_must_bound_to_choice :</p><p>(self.bindingVspec->exists( vspec | vspec.oclIsTypeOf(Choice)))</p><p>and (not (self.bindingVspec->exists( vspec | vspec.oclIsTypeOf(Variable))))</p><p>and (not (self.bindingVspec->exists( vspec | vspec.oclIsTypeOf(VClassifier))))</p><p></p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition :</p><p>None</p><p>Post-condition:</p><p>After a LinkExistence has been executed, the optionalLink must be in the resolved model otherwise it cannot be in the resolved model.</p><p>OCL :</p><p>-- LinkExistence</p><p>context LinkExistence::eval(ctx : BVRExecutionContext)</p><p>pre :</p><p>post:</p><p>ctx.selectedVSpecs->includes((self.bindingVspec->asOrderedSet()->first())) implies ctx.baseLinks->includes(self.optionalLink) and</p><p>ctx.unselectedVSpecs->includes(self.bindingVspec->asOrderedSet()->first()) implies not ctx.baseLinks->includes(self.optionalLink)</p><p>####BVRSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.LinkExistence#getOptionalLink <em>Optional Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getLinkExistence()
 * @model
 * @generated
 */
public interface LinkExistence extends ChoiceVariationPoint {
	/**
	 * Returns the value of the '<em><b>Optional Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The link handle identifying the base model link whose existence is in question
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Optional Link</em>' containment reference.
	 * @see #setOptionalLink(LinkHandle)
	 * @see bvr.BvrPackage#getLinkExistence_OptionalLink()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	LinkHandle getOptionalLink();

	/**
	 * Sets the value of the '{@link bvr.LinkExistence#getOptionalLink <em>Optional Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional Link</em>' containment reference.
	 * @see #getOptionalLink()
	 * @generated
	 */
	void setOptionalLink(LinkHandle value);

} // LinkExistence
