/**
 */
package CVLMetamodelMaster.Main;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An ObjectSpecification specifies a value which is an object of the base mode through an object handle.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.ObjectSpecification#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getObjectSpecification()
 * @model
 * @generated
 */
public interface ObjectSpecification extends ValueSpecification {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The object specified.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(ObjectHandle)
	 * @see CVLMetamodelMaster.Main.MainPackage#getObjectSpecification_Object()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ObjectHandle getObject();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ObjectSpecification#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(ObjectHandle value);

} // ObjectSpecification
