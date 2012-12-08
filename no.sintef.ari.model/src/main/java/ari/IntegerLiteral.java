/**
 */
package ari;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ari.IntegerLiteral#getLiteralValue <em>Literal Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see ari.ariPackage#getIntegerLiteral()
 * @model
 * @generated
 */
public interface IntegerLiteral extends ExpressionNode {
	/**
	 * Returns the value of the '<em><b>Literal Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Value</em>' attribute.
	 * @see #setLiteralValue(String)
	 * @see ari.ariPackage#getIntegerLiteral_LiteralValue()
	 * @model
	 * @generated
	 */
	String getLiteralValue();

	/**
	 * Sets the value of the '{@link ari.IntegerLiteral#getLiteralValue <em>Literal Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal Value</em>' attribute.
	 * @see #getLiteralValue()
	 * @generated
	 */
	void setLiteralValue(String value);

} // IntegerLiteral
