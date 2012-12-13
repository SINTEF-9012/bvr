/**
 */
package cvl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opaque Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>An OpaqueVariationPoint is an executable, domain-specific variation point whose semantics is not defined by CVL. It is the responsibility of the specific domain to execute this kind of variation point.<br><br>If bound to a choice then an OpaqueVariation point will be executed upon a positive decision. If bound to a VClassifier then it will be executed once for each instance created from it. If bound to a variable then it will be executed when a value is assigned to it, also providing the value as parameter for the execution.<br></p><p>####CVLSemanticStart####</p><p></p><p>Dynamic semantics</p><p>The OpaqueVariationPoint allows user to make use of variations that are not directly defined by CVL. So, its semantics is not detailed here, and we do not have pre and post conditions</p><p>Pre and post condition</p><p>Pre-condition :</p><p>None</p><p>Post-condition:</p><p>None</p><p>OCL :</p><p>-- OpaqueVariationPoint</p><p>context OpaqueVariationPoint::eval(ctx : CVLExecutionContext)</p><p>pre : true</p><p>post : true</p><p>####CVLSemanticEnd####</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.OpaqueVariationPoint#getPlaceHolder <em>Place Holder</em>}</li>
 *   <li>{@link cvl.OpaqueVariationPoint#getSourceObject <em>Source Object</em>}</li>
 *   <li>{@link cvl.OpaqueVariationPoint#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getOpaqueVariationPoint()
 * @model
 * @generated
 */
public interface OpaqueVariationPoint extends VariationPoint {
	/**
	 * Returns the value of the '<em><b>Place Holder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The place holder of the OpaqueVariationPoint.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Place Holder</em>' containment reference.
	 * @see #setPlaceHolder(BaseModelHandle)
	 * @see cvl.cvlPackage#getOpaqueVariationPoint_PlaceHolder()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	BaseModelHandle getPlaceHolder();

	/**
	 * Sets the value of the '{@link cvl.OpaqueVariationPoint#getPlaceHolder <em>Place Holder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Place Holder</em>' containment reference.
	 * @see #getPlaceHolder()
	 * @generated
	 */
	void setPlaceHolder(BaseModelHandle value);

	/**
	 * Returns the value of the '<em><b>Source Object</b></em>' containment reference list.
	 * The list contents are of type {@link cvl.ObjectHandle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The source objects of the OpaqueVariationPoint.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Object</em>' containment reference list.
	 * @see cvl.cvlPackage#getOpaqueVariationPoint_SourceObject()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<ObjectHandle> getSourceObject();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The transformation used by the opaque variation point.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(OVPType)
	 * @see cvl.cvlPackage#getOpaqueVariationPoint_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OVPType getType();

	/**
	 * Sets the value of the '{@link cvl.OpaqueVariationPoint#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(OVPType value);

} // OpaqueVariationPoint
