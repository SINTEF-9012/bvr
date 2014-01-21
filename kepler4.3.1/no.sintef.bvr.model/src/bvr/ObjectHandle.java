/**
 */
package bvr;

import org.eclipse.emf.ecore.EObject;

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
 *   <li>{@link bvr.ObjectHandle#getMOFRef <em>MOF Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getObjectHandle()
 * @model
 * @generated
 */
public interface ObjectHandle extends BaseModelHandle {
	/**
	 * Returns the value of the '<em><b>MOF Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MOF Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MOF Ref</em>' reference.
	 * @see #setMOFRef(EObject)
	 * @see bvr.BvrPackage#getObjectHandle_MOFRef()
	 * @model required="true"
	 * @generated
	 */
	EObject getMOFRef();

	/**
	 * Sets the value of the '{@link bvr.ObjectHandle#getMOFRef <em>MOF Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MOF Ref</em>' reference.
	 * @see #getMOFRef()
	 * @generated
	 */
	void setMOFRef(EObject value);

} // ObjectHandle
