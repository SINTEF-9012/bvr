/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Handle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     An object handle identifies an object of the base model. This Class abstracts over the cross-domain referencing
 *     mechanism needed to refer from CVL elements to base model objects.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.ObjectHandle#getHref <em>Href</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getObjectHandle()
 * @model
 * @generated
 */
public interface ObjectHandle extends BaseModelHandle {
	/**
	 * Returns the value of the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Representing a MOF Reference.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Href</em>' attribute.
	 * @see #setHref(String)
	 * @see cvl.cvlPackage#getObjectHandle_Href()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getHref();

	/**
	 * Sets the value of the '{@link cvl.ObjectHandle#getHref <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Href</em>' attribute.
	 * @see #getHref()
	 * @generated
	 */
	void setHref(String value);

} // ObjectHandle
