/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type of objects in the base model, specified as a metaclass in the metamodel of which the base model in an instance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.ObjectType#getMetaClass <em>Meta Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getObjectType()
 * @model
 * @generated
 */
public interface ObjectType extends Variabletype {
	/**
	 * Returns the value of the '<em><b>Meta Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the metaclass in the metamodel of which the base model is an instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Meta Class</em>' attribute.
	 * @see #setMetaClass(String)
	 * @see bvr.BvrPackage#getObjectType_MetaClass()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getMetaClass();

	/**
	 * Sets the value of the '{@link bvr.ObjectType#getMetaClass <em>Meta Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Class</em>' attribute.
	 * @see #getMetaClass()
	 * @generated
	 */
	void setMetaClass(String value);

} // ObjectType
