/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slot Value Existence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>SlotValueExistence is a choice variation point which indicates that a value in a slot of some object of the base model may or may not exist in the materialized model. The object is identified via an object handle and the the slot is identified via its name, as indicated in the attribute slotIdentifie.</p><p>When this variation point is applied, the slot in the base model is cleared from whatever value it has.<br></p><p>####BVRSemanticStart####</p><p></p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition :</p><p>Before the execution of a SlotValueExistence, the slotOwner element must exist in the base model.</p><p>Post-condition:</p><blockquote><p>After a SlotValueExsitence has been executed, the MoF property with the name such as in the slotIdentifier is in the ObjectHandle otherwise it cannot be found in the ObjectHandle.</p></blockquote><p>OCL :</p><p>-- SlotValueExistence</p><p>context SlotValueExistence::eval(ctx : BVRExecutionContext)</p><p>pre : ctx.resolvedModelElements->includes(self.slotOwner)</p><p>post :</p><p>ctx.selectedVSpecs->includes(self.bindingVspec->asOrderedSet()->first()) implies self.slotOwner->asOrderedSet()->first().getPropertyByName(self.slotIdentifier)</p><p>null</p><p>and</p><p>ctx.unselectedVSpecs->includes(self.bindingVspec->asOrderedSet()->first()) implies (self.slotOwner->asOrderedSet()->first().getPropertyByName(self.slotIdentifier)) == (null)</p><p>####BVRSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.SlotValueExistence#getSlotIdentifier <em>Slot Identifier</em>}</li>
 *   <li>{@link bvr.SlotValueExistence#getSlotOwner <em>Slot Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getSlotValueExistence()
 * @model
 * @generated
 */
public interface SlotValueExistence extends ChoiceVariationPoint {
	/**
	 * Returns the value of the '<em><b>Slot Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The name of the slot identifier.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Slot Identifier</em>' attribute.
	 * @see #setSlotIdentifier(String)
	 * @see bvr.BvrPackage#getSlotValueExistence_SlotIdentifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSlotIdentifier();

	/**
	 * Sets the value of the '{@link bvr.SlotValueExistence#getSlotIdentifier <em>Slot Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot Identifier</em>' attribute.
	 * @see #getSlotIdentifier()
	 * @generated
	 */
	void setSlotIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Slot Owner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Reference to the slot owner.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Slot Owner</em>' containment reference.
	 * @see #setSlotOwner(ObjectHandle)
	 * @see bvr.BvrPackage#getSlotValueExistence_SlotOwner()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ObjectHandle getSlotOwner();

	/**
	 * Sets the value of the '{@link bvr.SlotValueExistence#getSlotOwner <em>Slot Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot Owner</em>' containment reference.
	 * @see #getSlotOwner()
	 * @generated
	 */
	void setSlotOwner(ObjectHandle value);

} // SlotValueExistence
