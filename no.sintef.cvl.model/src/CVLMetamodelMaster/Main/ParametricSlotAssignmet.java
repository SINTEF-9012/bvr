/**
 */
package CVLMetamodelMaster.Main;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parametric Slot Assignmet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A parametric slot assignment is a parametric variation point which specifies that a value arriving as parameter will be assigned to a particular slot in a particular object in the base model. The object is identified via an object handle pointing to the base model, The object is identified via an object handle, and the the slot is identified via its name, as indicated in the attribute slotIdentifie. The variation point must be bound to a variable which will provide the value coming as parameter.<br><br>When this variation point is applied, the value coming as parameter is inserted into the base model slot</p><p></p><p>####CVLSemanticStart####</p><p>Invariant</p><p>Invariant : The slotIdentifier must correspond to a property name of the associated ObjectHandle</p><p>OCL :</p><p>-- ParametricSlotAssignment</p><p>-- The slotIdentifier must correspond to a property name of the associated ObjectHandle</p><p>context ParametricSlotAssignmet :</p><p>inv slotIdentifierExists :</p><p>self.slotOwner.getPropertyByName(self.slotIdentifier)</p><p>null</p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition :</p><p>Before the execution of a ParametricSlotAssignment, the ObjectHandle slotOwner must exist in the base model.</p><p>Post-condition:</p><p>After a ParametricSlotAssignment has been executed, the slot identified by the slotIdentifier and contained in the ObjectHandle slotOwner is assigned with a given value.</p><p>OCL :</p><p>-- ParametricSlotAssignment</p><p>context ParametricSlotAssignmet::eval(ctx : CVLExecutionContext)</p><p>pre : ctx.resolvedModelElements->includes(self.slotOwner)</p><p>post: self.slotOwner.getPropertyValue(self.slotIdentifier)->asOrderedSet()->first() == (VariableValueAssignment.allInstances()->select (varValueAssign | (self.bindingVspec</p><p>->includes(varValueAssign.resolvedVariable)))->asOrderedSet()->first().value)</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.ParametricSlotAssignmet#getSlotIdentifier <em>Slot Identifier</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.ParametricSlotAssignmet#getSlotOwner <em>Slot Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getParametricSlotAssignmet()
 * @model
 * @generated
 */
public interface ParametricSlotAssignmet extends ParametricVariationPoint {
	/**
	 * Returns the value of the '<em><b>Slot Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The name of the slot identifier.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Slot Identifier</em>' attribute.
	 * @see #setSlotIdentifier(String)
	 * @see CVLMetamodelMaster.Main.MainPackage#getParametricSlotAssignmet_SlotIdentifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSlotIdentifier();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ParametricSlotAssignmet#getSlotIdentifier <em>Slot Identifier</em>}' attribute.
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
	 * <p>The slot owner.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Slot Owner</em>' containment reference.
	 * @see #setSlotOwner(ObjectHandle)
	 * @see CVLMetamodelMaster.Main.MainPackage#getParametricSlotAssignmet_SlotOwner()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ObjectHandle getSlotOwner();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ParametricSlotAssignmet#getSlotOwner <em>Slot Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot Owner</em>' containment reference.
	 * @see #getSlotOwner()
	 * @generated
	 */
	void setSlotOwner(ObjectHandle value);

} // ParametricSlotAssignmet
