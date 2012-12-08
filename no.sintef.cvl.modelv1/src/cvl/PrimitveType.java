/**
 */
package cvl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitve Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A type of a variable which is either String, Integer,UnlimitedNatural, Real, or Boolean.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cvl.PrimitveType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see cvl.cvlPackage#getPrimitveType()
 * @model
 * @generated
 */
public interface PrimitveType extends Variabletype {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link cvl.PrimitiveTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The primitive type as an enumeration value.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see cvl.PrimitiveTypeEnum
	 * @see #setType(PrimitiveTypeEnum)
	 * @see cvl.cvlPackage#getPrimitveType_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PrimitiveTypeEnum getType();

	/**
	 * Sets the value of the '{@link cvl.PrimitveType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see cvl.PrimitiveTypeEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(PrimitiveTypeEnum value);

} // PrimitveType
