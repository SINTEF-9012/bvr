/**
 */
package org.bangbangbang.cvl;


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
 *   <li>{@link org.bangbangbang.cvl.PrimitveType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bangbangbang.cvl.CvlPackage#getPrimitveType()
 * @model
 * @generated
 */
public interface PrimitveType extends Variabletype {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bangbangbang.cvl.PrimitiveTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The primitive type as an enumeration value.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.bangbangbang.cvl.PrimitiveTypeEnum
	 * @see #setType(PrimitiveTypeEnum)
	 * @see org.bangbangbang.cvl.CvlPackage#getPrimitveType_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PrimitiveTypeEnum getType();

	/**
	 * Sets the value of the '{@link org.bangbangbang.cvl.PrimitveType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.bangbangbang.cvl.PrimitiveTypeEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(PrimitiveTypeEnum value);

} // PrimitveType
