/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Existence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>ObjectExistence is a choice variation point which indicates that an object of the base model may or may not exist in the materialized model. The object is identified via an object handle. When this variation point is applied the object identified in the base model as the optionalObject is deleted.<br></p><p>####CVLSemanticStart####</p><p>Invariant</p><p>Invariant : An ObjectExistence must be bound to a Choice, not to a variable or to a classifier</p><p>OCL :</p><p>-- ObjectExistence</p><p>-- An ObjectExistence must be bound to a Choice, not to a variable or to a classifier</p><p>context ObjectExistence :</p><p>inv must_bound_to_choice :</p><p>(self.bindingVspec->exists( vspec | vspec.oclIsTypeOf(Choice)))</p><p>and not ( (self.bindingVspec->exists( vspec | vspec.oclIsTypeOf(Variable))))</p><p>and not ( (self.bindingVspec->exists( vspec | vspec.oclIsTypeOf(VClassifier))))</p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition :</p><p>None</p><p>Post-condition:</p><p>After an ObjectExistence has been executed, the optionalObject must be in the resolved model otherwise it cannot be in the resolved model.</p><p>OCL :</p><p>-- ObjectExistence</p><p>context ObjectExistence::eval(ctx : CVLExecutionContext)</p><p>pre :</p><p>post:</p><p>ctx.selectedVSpecs->includes(self.bindingVspec->asOrderedSet()->first()) implies ctx.resolvedModelElements->includes(self.optionalObject) and</p><p>ctx.unselectedVSpecs->includes((self.bindingVspec->asOrderedSet()->first())) implies not ctx.resolvedModelElements->includes(self.optionalObject)</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.ObjectExistence#getOptionalObject <em>Optional Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getObjectExistence()
 * @model
 * @generated
 */
public interface ObjectExistence extends ChoiceVariationPoint {
	/**
	 * Returns the value of the '<em><b>Optional Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The&nbsp;object&nbsp;handle&nbsp;identifying&nbsp;the&nbsp;base&nbsp;model&nbsp;object&nbsp;whose&nbsp;existence&nbsp;is&nbsp;in&nbsp;question.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Optional Object</em>' containment reference.
	 * @see #setOptionalObject(ObjectHandle)
	 * @see cvl.cvlPackage#getObjectExistence_OptionalObject()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ObjectHandle getOptionalObject();

	/**
	 * Sets the value of the '{@link cvl.ObjectExistence#getOptionalObject <em>Optional Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional Object</em>' containment reference.
	 * @see #getOptionalObject()
	 * @generated
	 */
	void setOptionalObject(ObjectHandle value);

} // ObjectExistence
