/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Handle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A link handle identifies a link of the base model. This Class abstracts over the cross-domain referencing mechanism needed to refer from CVL elements to base model links.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.LinkHandle#getMOFRef <em>MOF Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getLinkHandle()
 * @model
 * @generated
 */
public interface LinkHandle extends BaseModelHandle {
	/**
	 * Returns the value of the '<em><b>MOF Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Representing a MOF Reference.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>MOF Ref</em>' attribute.
	 * @see #setMOFRef(String)
	 * @see bvr.BvrPackage#getLinkHandle_MOFRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getMOFRef();

	/**
	 * Sets the value of the '{@link bvr.LinkHandle#getMOFRef <em>MOF Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MOF Ref</em>' attribute.
	 * @see #getMOFRef()
	 * @generated
	 */
	void setMOFRef(String value);

} // LinkHandle
