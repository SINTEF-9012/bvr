/**
 */
package CVLMetamodelMaster.Main;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parametric Link End Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A ParametricLinkEndSubstitution is a parametric variation point which specifies that an object arriving as parameter, called the replacement, will be substituted for an object of the base model as the end of a particular link in the base model. The link-end is identified via a link handle pointing to the base model plus a string representing a MOF property owned by the association of which the link is an instance. The variation point must be bound to a variable which will provide the replacement object coming as parameter.<br><br>When this variation point is applied,the link-end is redirected to the replacement coming as parameter.</p><p>####CVLSemanticStart####</p><p></p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition :</p><p>Before the execution of a ParametricLinkAssignment, the link link must exist in the base model and a end corresponding to the given linkEndIdentifier exists in the ObjectHandle.</p><p>Post-condition:</p><p>After a ParametricLinkAssignment has been executed, the object which arrives in the variable is at the end of the link link.</p><p>OCL :</p><p>-- ParametricLinkAssignment</p><p>-- A end corresponding to the given linkEndIdentifier exists in the ObjectHandle</p><p>context ParametricLinkAssignment::eval(ctx : CVLExecutionContext)</p><p>pre : ctx.baseLinks->includes(self.link)</p><p>and if self.getPropertyValue(self.linkEndIdentifier)</p><p>null</p><p>then</p><p>self.getPropertyValue(self.linkEndIdentifier)->forAll( val | ctx.resolvedModelElements->includes(val.oclAsType(ObjectHandle)))</p><p>else</p><p>false</p><p>endif</p><p>post: self.link.getEnd()->includes(</p><p>VariableValueAssignment.allInstances()->select (varValueAssign | (self.bindingVspec</p><p>->includes(varValueAssign.resolvedVariable)))->asOrderedSet()->first().value )</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.ParametricLinkEndSubstitution#getLinkEndIdentifier <em>Link End Identifier</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.ParametricLinkEndSubstitution#getLink <em>Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getParametricLinkEndSubstitution()
 * @model
 * @generated
 */
public interface ParametricLinkEndSubstitution extends ParametricVariationPoint {
	/**
	 * Returns the value of the '<em><b>Link End Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Name of the link end.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link End Identifier</em>' attribute.
	 * @see #setLinkEndIdentifier(String)
	 * @see CVLMetamodelMaster.Main.MainPackage#getParametricLinkEndSubstitution_LinkEndIdentifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getLinkEndIdentifier();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ParametricLinkEndSubstitution#getLinkEndIdentifier <em>Link End Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link End Identifier</em>' attribute.
	 * @see #getLinkEndIdentifier()
	 * @generated
	 */
	void setLinkEndIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Reference to the link end.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link</em>' containment reference.
	 * @see #setLink(LinkHandle)
	 * @see CVLMetamodelMaster.Main.MainPackage#getParametricLinkEndSubstitution_Link()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	LinkHandle getLink();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ParametricLinkEndSubstitution#getLink <em>Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link</em>' containment reference.
	 * @see #getLink()
	 * @generated
	 */
	void setLink(LinkHandle value);

} // ParametricLinkEndSubstitution
