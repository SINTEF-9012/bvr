/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link End Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A LinkEndSubstitution is a choice variation point which specifies that an object in the base model, called the replacement, may be substituted for another as the end of a particular link in the base model. The link-end is identified via a link handle referencing the base model plus a string representing a MOF property owned by the association of which the link is an instance. The placement is specified via an object handle.</p><p>When this variation point is applied,the link-end is redirected to the replacement object.</p><p>####BVRSemanticStart####</p><p>Dynamic semantics</p><p>Pre and post condition</p><p>Pre-condition :</p><p>None</p><p>Post-condition:</p><p>After a Link Assignment has been executed, the newEnd object handle must be an end of the LinkHandle link.</p><p></p><p>Note : To express more easily this OCL pre condition, we add an operation getEnd() on the LinkHandle metaclass. This operation computes the respective end of this linkHandle.</p><p>OCL :</p><p>-- LinkAssignment</p><p>context LinkAssignment::eval(ctx : BVRExecutionContext)</p><p>pre :</p><p>post : self.link.getEnd()->includes(self.newEnd)</p><p>####BVRSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.LinkEndSubstitution#getLink <em>Link</em>}</li>
 *   <li>{@link bvr.LinkEndSubstitution#getLinkEndIdentifier <em>Link End Identifier</em>}</li>
 *   <li>{@link bvr.LinkEndSubstitution#getReplacementObject <em>Replacement Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getLinkEndSubstitution()
 * @model
 * @generated
 */
public interface LinkEndSubstitution extends ChoiceVariationPoint {
	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Reference to the link.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link</em>' containment reference.
	 * @see #setLink(LinkHandle)
	 * @see bvr.BvrPackage#getLinkEndSubstitution_Link()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	LinkHandle getLink();

	/**
	 * Sets the value of the '{@link bvr.LinkEndSubstitution#getLink <em>Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link</em>' containment reference.
	 * @see #getLink()
	 * @generated
	 */
	void setLink(LinkHandle value);

	/**
	 * Returns the value of the '<em><b>Link End Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the MOF Property&nbsp;in the object's metaclass identifying the link-end where this substitution occurs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link End Identifier</em>' attribute.
	 * @see #setLinkEndIdentifier(String)
	 * @see bvr.BvrPackage#getLinkEndSubstitution_LinkEndIdentifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getLinkEndIdentifier();

	/**
	 * Sets the value of the '{@link bvr.LinkEndSubstitution#getLinkEndIdentifier <em>Link End Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link End Identifier</em>' attribute.
	 * @see #getLinkEndIdentifier()
	 * @generated
	 */
	void setLinkEndIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Replacement Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The&nbsp;object handle identifying the base model object&nbsp;replacing&nbsp;the link-end in this substitution. If no
	 * replacement is specified then the object is expected to arrive in a variable, that is the variation point must be bound to
	 * a variable to be acted on.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Replacement Object</em>' containment reference.
	 * @see #setReplacementObject(ObjectHandle)
	 * @see bvr.BvrPackage#getLinkEndSubstitution_ReplacementObject()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ObjectHandle getReplacementObject();

	/**
	 * Sets the value of the '{@link bvr.LinkEndSubstitution#getReplacementObject <em>Replacement Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement Object</em>' containment reference.
	 * @see #getReplacementObject()
	 * @generated
	 */
	void setReplacementObject(ObjectHandle value);

} // LinkEndSubstitution
